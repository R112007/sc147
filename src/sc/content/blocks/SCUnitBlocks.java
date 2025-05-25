package sc.content.blocks;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;
import sc.content.SCItems;
import sc.content.SCUnits;

public class SCUnitBlocks {
  public static Block groundfactory;
  public static Block airfactory;
  public static Block navalfactory;
  public static Block T2unit;

  public static void load() {
    groundfactory = new UnitFactory("groundfactory") {
      {
        this.size = 3;
        this.health = 450;
        this.consumePower(2.5f);
        this.plans.add(
            new UnitFactory.UnitPlan(SCUnits.chujia1, 60f * 30, ItemStack.with(SCItems.li, 30, SCItems.cuguijing, 30)),
            new UnitFactory.UnitPlan(SCUnits.papa1, 60f * 15,
                ItemStack.with(SCItems.tandanzhi, 15, SCItems.cuguijing, 20)),
            new UnitFactory.UnitPlan(SCUnits.zhuhuo1, 60f * 40,
                ItemStack.with(SCItems.li, 35, SCItems.cuguijing, 30, SCItems.xi, 25)));

        this.requirements(Category.units,
            ItemStack.with(new Object[] { SCItems.lv, 90, SCItems.li, 70, SCItems.cuguijing, 80 }));

      }
    };
    airfactory = new UnitFactory("airfactory") {
      {
        this.size = 3;
        this.health = 350;
        this.consumePower(1.5f);
        this.plans.add(
            new UnitFactory.UnitPlan(SCUnits.liekong1, 60f * 18, ItemStack.with(SCItems.lv, 15, SCItems.cuguijing, 15)),
            new UnitFactory.UnitPlan(SCUnits.miner1, 60f * 35, ItemStack.with(SCItems.li, 15, SCItems.cuguijing, 25)));

        this.requirements(Category.units, ItemStack.with(new Object[] { SCItems.lv, 60, SCItems.li, 70 }));

      }
    };
    T2unit = new Reconstructor("T2unit") {
      {
        this.size = 3;
        this.health = 280;
        this.consumePower(3.8f);
        this.constructTime = 1200f;
        this.buildCostMultiplier = 0.75f;
        this.consumeItems(ItemStack.with(SCItems.li, 50, SCItems.cuguijing, 40));
        this.upgrades.addAll(
            new UnitType[] { SCUnits.chujia1, SCUnits.chujia2 },
            new UnitType[] { SCUnits.papa1, SCUnits.papa2 },
            new UnitType[] { SCUnits.miner1, SCUnits.miner2 }

        );
        this.requirements(Category.units,
            ItemStack.with(new Object[] { SCItems.lv, 200, SCItems.li, 120, SCItems.cuguijing, 80 }));
        this.alwaysUnlocked = false;
      }
    };
  }
}
