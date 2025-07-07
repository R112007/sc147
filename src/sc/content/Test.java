package sc.content;

import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;
import sc.content.blocks.SCDistribution;
import sc.content.blocks.SCTurrets;
import sc.world.blocks.DependentBlocks;
import sc.world.blocks.crystal.CrystalBlock;
import sc.world.blocks.denfence.HealWall;
import sc.world.blocks.denfence.LinkWall;
import sc.world.blocks.denfence.ShieldBuildTurret;
import sc.world.blocks.denfence.AbsorbForceProjector;
import sc.world.blocks.distribution.SCLaunchPad;
import sc.world.blocks.payloads.UnitLanuchPad;
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
  public static Block test7;
  public static Block test8;
  public static Block test9;

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
    Test.test7 = new ShieldBuildTurret("test7") {
      {
        range = 200f;
        size = 3;
        buildSpeed = 1.5f;

        this.requirements(Category.effect, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
        consumePower(3f);
      }
    };
    /*
     * test8 = new AbsorbForceProjector("test8") {
     * {
     * this.size = 2;
     * this.itemCapacity = 10;
     * this.health = 720;
     * this.requirements(Category.effect,
     * ItemStack.with(new Object[] { SCItems.li, 100, SCItems.cuguijing, 75,
     * SCItems.xi, 125 }));
     * this.radius = 65f;
     * this.shieldHealth = 600f;
     * this.phaseShieldBoost = 700f;
     * this.phaseRadiusBoost = 40f;
     * this.phaseUseTime = 250f;
     * this.cooldownNormal = 1.6f;
     * this.cooldownLiquid = 2.6f;
     * this.cooldownBrokenBase = 1f;
     * this.consumesPower = true;
     * this.consumePower(6.5f);
     * }
     * };
     */
    test9 = new UnitLanuchPad("test9") {
      {
        size = 3;
        this.requirements(Category.units, ItemStack.with(new Object[] { SCItems.lv, 8 }));
        this.alwaysUnlocked = true;
      }
    };
    Blocks.payloadSource.alwaysUnlocked = true;
    Blocks.payloadSource.buildVisibility = BuildVisibility.shown;
  }
}
