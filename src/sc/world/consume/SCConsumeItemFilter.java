package sc.world.consume;

import arc.func.Boolf;
import arc.scene.ui.layout.Table;
import arc.util.Nullable;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.ui.MultiReqImage;
import mindustry.ui.ReqImage;
import mindustry.world.Block;
import mindustry.world.consumers.Consume;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatValues;
import mindustry.world.meta.Stats;
import sc.type.SCItemType;

import static mindustry.Vars.*;

public class SCConsumeItemFilter extends Consume {
  public Boolf<? super Item> filter = i -> false;

  public SCConsumeItemFilter(Boolf<? super Item> item) {
    this.filter = item;
  }

  public SCConsumeItemFilter() {
  }

  @Override
  public void apply(Block block) {
    block.hasItems = true;
    block.acceptsItems = true;
    content.items().each(filter, item -> block.itemFilter[item.id] = true);
  }

  @Override
  public void build(Building build, Table table) {
    MultiReqImage image = new MultiReqImage();
    content.items().each(i -> filter.get(i) && i.unlockedNow(),
        item -> image.add(new ReqImage(StatValues.stack(item, 1),
            () -> build.items.has(item))));
    table.add(image).size(8 * 4);
  }

  @Override
  public void update(Building build) {
  }

  @Override
  public float efficiency(Building build) {
    return build.consumeTriggerValid() || getConsumed(build) != null ? 1f : 0f;
  }

  public @Nullable Item getConsumed(Building build) {
    for (int i = 0; i < content.items().size; i++) {
      Item item = content.item(i);
      if (build.items.has(item) && this.filter.get(item)) {
        return item;
      }
    }
  }

  @Override
  public void display(Stats stats) {
    stats.add(booster ? Stat.booster : Stat.input, StatValues.items(stats.timePeriod, filter));
  }
}
