package sc.content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import sc.content.blocks.SCDistribution;
import sc.content.blocks.SCTurrets;
import sc.world.blocks.DependentBlocks;
import sc.world.blocks.crystal.CrystalBlock;
import sc.world.blocks.denfence.HealWall;
import sc.world.blocks.denfence.LinkWall;
import sc.world.blocks.distribution.SCLaunchPad;
import sc.world.blocks.power.LiquidFloorGenerator;
import sc.world.blocks.production.DrillTurret;

public class Test {
  public static Block test;
  public static Block test1;
  public static Block test2;
  public static Block test3;
  public static Block test4;
  public static Block test5;
  public static Block test6;

  public static void load() {
    Test.test = new CrystalBlock("test") {
      {
        this.health = 130;
        this.size = 2;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = false;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    test1 = new HealWall("g") {
      {
        lightningChance = 1;
        this.health = 1000;
        this.size = 2;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    test2 = new LinkWall("linkwall") {
      {
        lightningChance = 1;
        this.health = 1000;
        this.size = 1;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    Test.test3 = new DrillTurret("drill-mini") {
      {
        range = 90f;
        itemCapacity = 25;
        hasPower = true;
        consumePower(1f);
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    Test.test4 = new SCLaunchPad("ghbb") {
      {
        size = 3;
        itemCapacity = 100;
        launchTime = 60f * 20;
        hasPower = true;
        consumePower(4f);
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    test5 = new LiquidFloorGenerator("test5") {
      {
        // lightningChance = //1;
        this.health = 1000;
        this.size = 3;
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    test6 = new DependentBlocks.DGenericCrafter("test6") {
      {
        this.health = 1000;
        this.size = 3;
        this.blocks = new Block[] { SCTurrets.duoguanpao, SCDistribution.lvconveyor };
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
        outputItem = new ItemStack(Items.metaglass, 1);
        craftTime = 30f;
        hasPower = hasItems = true;
        consumeItems(ItemStack.with(Items.lead, 1, Items.sand, 1));
        consumePower(0.60f);
      }
    };
  }
}
