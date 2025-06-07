package sc.world.blocks.effect;

import java.util.Comparator;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.scene.ui.layout.Table;
import arc.struct.Seq;
import arc.util.Log;
import arc.util.io.Reads;
import arc.util.io.Writes;
import arc.util.pooling.Pools;
import arc.util.pooling.Pool.Poolable;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.blocks.ItemSelection;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import static mindustry.Vars.*;

public class SCUnloader extends Unloader {
  static Item[] allItems;

  public SCUnloader(String name) {
    super(name);
    update = true;
    solid = true;
    health = 70;
    hasItems = true;
    configurable = true;
    saveConfig = true;
    itemCapacity = 0;
    noUpdateDisabled = true;
    clearOnDoubleTap = true;
    unloadable = false;

    config(Item.class, (SCUnloaderBuild tile, Item item) -> tile.sortItem = item);
    configClear((SCUnloaderBuild tile) -> tile.sortItem = null);
  }

  @Override
  public void init() {
    super.init();

    allItems = content.items().toArray(Item.class);
  }

  public static class ECContainerStat implements Poolable {
    Building building;
    float loadFactor;
    boolean canLoad;
    boolean canUnload;
    /** Cached !(building instanceof StorageBuild) */
    boolean notStorage;
    int lastUsed;

    @Override
    public void reset() {
      building = null;
    }
  }

  public class SCUnloaderBuild extends UnloaderBuild {

    public float unloadTimer = 0f;
    public int rotations = 0;
    public Item sortItem = null;
    public ECContainerStat dumpingFrom, dumpingTo;
    public final Seq<ECContainerStat> possibleBlocks = new Seq<>(ECContainerStat.class);

    protected final Comparator<ECContainerStat> comparator = (x, y) -> {
      int unloadPriority = Boolean.compare(x.canUnload && !x.canLoad, y.canUnload && !y.canLoad); // priority to receive
                                                                                                  // if it cannot give
      if (unloadPriority != 0)
        return unloadPriority;
      int loadPriority = Boolean.compare(x.canUnload || !x.canLoad, y.canUnload || !y.canLoad); // priority to give if
                                                                                                // it cannot receive
      if (loadPriority != 0)
        return loadPriority;
      int loadFactor = Float.compare(x.loadFactor, y.loadFactor);
      if (loadFactor != 0)
        return loadFactor;
      return Integer.compare(y.lastUsed, x.lastUsed); // inverted
    };

    private boolean isPossibleItem(Item item) {
      boolean hasProvider = false,
          hasReceiver = false,
          isDistinct = false;

      var pbi = possibleBlocks.items;
      for (int i = 0, l = possibleBlocks.size; i < l; i++) {
        var pb = pbi[i];
        var other = pb.building;

        // set the stats of buildings in possibleBlocks while we are at it
        pb.canLoad = pb.notStorage && other.acceptItem(this, item);
        pb.canUnload = other.canUnload() && other.items != null && other.items.has(item);

        // thats also handling framerate issues and slow conveyor belts, to avoid
        // skipping items if nulloader
        isDistinct |= (hasProvider && pb.canLoad) || (hasReceiver && pb.canUnload);
        hasProvider |= pb.canUnload;
        hasReceiver |= pb.canLoad;
      }
      return isDistinct;
    }

    @Override
    public void onProximityUpdate() {
      // filter all blocks in the proximity that will never be able to trade items

      super.onProximityUpdate();
      Pools.freeAll(possibleBlocks, true);
      possibleBlocks.clear();

      for (int i = 0; i < proximity.size; i++) {
        var other = proximity.get(i);
        if (!other.interactable(team) || other == null || !other.isValid())
          continue; // avoid blocks of the wrong team

        // partial check
        boolean canLoad = !(other.block instanceof StorageBlock);
        boolean canUnload = other.canUnload() && other.items != null;

        if (canLoad || canUnload) { // avoid blocks that can neither give nor receive items
          var pb = Pools.obtain(ECContainerStat.class, ECContainerStat::new);
          pb.building = other;
          pb.notStorage = canLoad;
          // TODO store the partial canLoad/canUnload?
          possibleBlocks.add(pb);
        }
      }
    }

    @Override
    public void updateTile() {
      if (possibleBlocks.size < 2)
        return; // 邻近方块不足，直接返回
      float deltaTime = delta(); // 获取帧间隔时间（秒）
      unloadTimer += deltaTime; // 累积时间

      // 计算可处理的完整周期数
      int processCount = (int) (unloadTimer / speed);
      if (processCount <= 0)
        return; // 未达到一个周期，跳过
      Item item = null;
      boolean any = false;

      for (int j = 0; j < processCount; j++) {
        if (sortItem != null) {
          if (isPossibleItem(sortItem))
            item = sortItem;
        } else {
          for (int i = 0, l = allItems.length; i < l; i++) {
            int id = (rotations + i + 1) % l;
            var possibleItem = allItems[id];

            if (isPossibleItem(possibleItem)) {
              item = possibleItem;
              break;
            }
          }
        }

        if (item != null) {
          rotations = item.id; // next rotation for nulloaders //TODO maybe if(sortItem == null)
          var pbi = possibleBlocks.items;
          int pbs = possibleBlocks.size;

          for (int i = 0; i < pbs; i++) {
            var pb = pbi[i];
            var other = pb.building;
            int maxAccepted = other.getMaximumAccepted(item);
            pb.loadFactor = maxAccepted == 0 || other.items == null ? 0 : other.items.get(item) / (float) maxAccepted;
            pb.lastUsed = (pb.lastUsed + 1) % Integer.MAX_VALUE; // increment the priority if not used
          }

          possibleBlocks.sort(comparator);

          dumpingTo = null;
          dumpingFrom = null;

          // choose the building to accept the item
          for (int i = 0; i < pbs; i++) {
            if (pbi[i].canLoad && pbi[i].building != null && pbi[i].building.isValid()) {
              dumpingTo = pbi[i];
              break;
            }
          }

          // choose the building to take the item from
          for (int i = pbs - 1; i >= 0; i--) {
            if (pbi[i].canUnload && pbi[i].building != null && pbi[i].building.isValid()) {
              dumpingFrom = pbi[i];
              break;
            }
          }

          // trade the items
          if (dumpingTo == null || dumpingFrom == null ||
              dumpingTo.building == null || !dumpingTo.building.isValid() ||
              dumpingFrom.building == null || !dumpingFrom.building.isValid()) {
            continue;
          }
          if (dumpingFrom != null && dumpingTo != null
              && (dumpingFrom.loadFactor != dumpingTo.loadFactor || !dumpingFrom.canLoad)) {
            if (dumpingTo == null)
              Log.info("No valid dumpingTo found in SCUnloader");
            if (dumpingFrom == null)
              Log.info("No valid dumpingFrom found in SCUnloader");

            dumpingTo.building.handleItem(this, item);
            dumpingFrom.building.removeStack(item, 1);
            dumpingTo.lastUsed = 0;
            dumpingFrom.lastUsed = 0;
            any = true;
          }
        }
      }

      if (any) {
        unloadTimer -= processCount * speed;
      } else {
        unloadTimer = Math.min(unloadTimer, speed);
      }
    }

    @Override
    public void draw() {
      super.draw();

      Draw.color(sortItem == null ? Color.clear : sortItem.color);
      Draw.rect(centerRegion, x, y);
      Draw.color();
    }

    @Override
    public void drawSelect() {
      super.drawSelect();
      drawItemSelection(sortItem);
    }

    @Override
    public void buildConfiguration(Table table) {
      ItemSelection.buildTable(SCUnloader.this, table, content.items(), () -> sortItem, this::configure, selectionRows,
          selectionColumns);
    }

    @Override
    public Item config() {
      return sortItem;
    }

    @Override
    public byte version() {
      return 1;
    }

    @Override
    public void write(Writes write) {
      super.write(write);
      write.s(sortItem == null ? -1 : sortItem.id);
    }

    @Override
    public void read(Reads read, byte revision) {
      super.read(read, revision);
      int id = revision == 1 ? read.s() : read.b();
      sortItem = id == -1 ? null : content.item(id);
    }

  }
}
