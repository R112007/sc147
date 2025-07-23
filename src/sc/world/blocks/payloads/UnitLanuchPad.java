package sc.world.blocks.payloads;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.scene.ui.layout.Table;
import arc.struct.Seq;
import arc.util.Log;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.ctype.UnlockableContent;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.ui.Bar;
import mindustry.world.blocks.ItemSelection;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.PayloadBlock;
import mindustry.world.blocks.payloads.UnitPayload;
import sc.game.WaitTime;
import sc.util.Logs;

/**
 * UnitLanuchPad
 */
public class UnitLanuchPad extends PayloadBlock {
  public float payloadsCapacity = 100f;
  public float reload = 300f;

  public UnitLanuchPad(String name) {
    super(name);
    this.update = true;
    this.solid = true;
    this.hasItems = false;
    this.configurable = true;
    this.clipSize = 120;
    this.payloadSpeed = 1.2f;
    this.outputsPayload = false;
    this.acceptsPayload = true;
    config(UnitType.class, (UnitLanuchPadBuild build, UnitType unit) -> {
      if (canProduce(unit) && build.unit != unit) {
        build.unit = unit;
        build.payload = null;
      }
    });
  }

  @Override
  public void setBars() {
    super.setBars();
    addBar("payloadsCapacity",
        (UnitLanuchPadBuild build) -> new Bar(() -> Core.bundle.format("bar.payloadsCapacity", build.payloadsTotal),
            () -> Pal.items, () -> (float) (build.payloadsTotal / this.payloadsCapacity)));
  }

  public boolean canProduce(UnitType t) {
    return !t.isHidden() && !t.isBanned() && t.supportsEnv(Vars.state.rules.env);
  }

  @Override
  public TextureRegion[] icons() {
    return new TextureRegion[] { region, topRegion };
  }

  public class UnitLanuchPadBuild extends PayloadBlockBuild<Payload> {
    public UnitType unit;
    public float payloadsTotal;
    public Seq<UnitType> unitTypes = new Seq<>();
    public float timer = 0f;

    @Override
    public boolean acceptPayload(Building source, Payload payload) {
      if (payload instanceof UnitPayload) {
        /**
         * Log.info("输入单位UnitType" + ((UnitPayload) payload).unit.type());
         * Log.info("输入单位Unit" + ((UnitPayload) payload).unit);
         * Log.info("选择单位UnitType" + this.unit);
         */
        if (((UnitPayload) payload).unit.type() == this.unit
            && payloadsTotal + ((UnitPayload) payload).unit.hitSize <= payloadsCapacity) {
          payloadsTotal += ((UnitPayload) payload).unit.hitSize;
          unitTypes.add(((UnitPayload) payload).unit.type());
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }

    @Override
    public void updateTile() {
      timer++;
      if (timer >= reload) {
        int u = 0;
        for (var l : unitTypes) {
          Log.info(u + " " + l);
          u++;
        }
        clear();
      }
      boolean b = WaitTime.waittime(120f);
      if (b) {
      }
      super.updateTile();
      if (moveInPayload(false) && efficiency > 0) {
        payload = null;
      }
    }

    public void clear() {
      unitTypes.clear();
      timer = 0f;
      payloadsTotal = 0f;
    }

    @Override
    public UnitType config() {
      return unit;
    }

    @Override
    public void buildConfiguration(Table table) {
      ItemSelection.buildTable(UnitLanuchPad.this, table,
          Vars.content.units().select(UnitLanuchPad.this::canProduce).as(),
          () -> (UnlockableContent) config(), this::configure, selectionRows, selectionColumns);
    }

    @Override
    public void write(Writes write) {
      super.write(write);
      write.s(unit == null ? -1 : unit.id);
    }

    @Override
    public void read(Reads read, byte revision) {
      super.read(read, revision);
      unit = Vars.content.unit(read.s());
    }
  }
}
