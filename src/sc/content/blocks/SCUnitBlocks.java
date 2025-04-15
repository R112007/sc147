package sc.content.blocks;

import arc.struct.Seq;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.units.UnitFactory;
import sc.content.SCItems;
import sc.content.SCUnits;

public class SCUnitBlocks {
  public static Block airfoctory;

  public static void load() {
    airfoctory = new UnitFactory("airfoctory") {
      {
        this.size = 3;
        this.health = 350;
        this.consumePower(1.5f);
        this.plans.add(
            new UnitFactory.UnitPlan(SCUnits.liekong1, 60f * 18, ItemStack.with(SCItems.lv, 15, SCItems.cuguijing, 15)),
            new UnitFactory.UnitPlan(SCUnits.miner1, 60f * 35, ItemStack.with(SCItems.li, 15, SCItems.cuguijing, 25)));
      }
    };
  }
}
