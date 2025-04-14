package sc.content.blocks;

import java.awt.Container;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import sc.content.SCItems;
import sc.content.SCUnits;

public class SCBlocksEffects {

  public static Block core1;
  public static Block xiuliqi;
  public static Block xiuliqi2;
  public static Block liqiang1;
  public static Block lvrongqi;
  public static Block weicang;
  public static Block juxingcang;
  public static Block lvunloader;

  public static void load() {
    SCBlocksEffects.core1 = new CoreBlock("core1") {
      {
        this.health = 3000;
        this.size = 2;
        this.itemCapacity = 5000;
        this.armor = 3;
        this.alwaysUnlocked = true;
        this.unitCapModifier = 10;
        this.unitType = SCUnits.tansuozhe;
        this.requirements(Category.effect, ItemStack.with(new Object[] { SCItems.lv, 800, SCItems.li, 800 }));
      }
    };
    SCBlocksEffects.xiuliqi = new MendProjector("xiuliqi") {
      {
        this.size = 1;
        this.health = 200;
        this.reload = 330f;
        this.range = 45f;
        this.healPercent = 6.3f;
        this.itemCapacity = 10;
        this.phaseBoost = 10f;
        this.phaseRangeBoost = 15f;
        this.consumePower(0.48f);
        this.consumeItem(SCItems.cuguijing, 1).optional(true, true);
        this.requirements(Category.effect, ItemStack.with(new Object[] { SCItems.lv, 20, SCItems.li, 30 }));
      }
    };
    SCBlocksEffects.xiuliqi2 = new MendProjector("xiuliqi2") {
      {
        this.size = 2;
        this.health = 380;
        this.reload = 280f;
        this.range = 80f;
        this.healPercent = 8f;
        this.itemCapacity = 10;
        this.phaseBoost = 30f;
        this.phaseRangeBoost = 15f;
        this.consumePower(1.5f);
        this.consumeItem(SCItems.chunguijing, 1).optional(true, true);
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 55, SCItems.li, 60, SCItems.cuguijing, 65, SCItems.xi, 60 }));
      }
    };
    SCBlocksEffects.lvrongqi = new StorageBlock("lvrongqi") {
      {
        this.size = 2;
        this.itemCapacity = 200;
        this.health = 600;
        this.requirements(Category.effect, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.cuguijing, 50 }));
      }
    };
    SCBlocksEffects.liqiang1 = new ForceProjector("liqiang1") {
      {
        this.size = 2;
        this.itemCapacity = 10;
        this.health = 720;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.li, 100, SCItems.cuguijing, 75, SCItems.xi, 125 }));
        this.radius = 65f;
        this.shieldHealth = 600f;
        this.phaseShieldBoost = 700f;
        this.phaseRadiusBoost = 40f;
        this.phaseUseTime = 250f;
        this.cooldownNormal = 1.6f;
        this.cooldownLiquid = 2.6f;
        this.cooldownBrokenBase = 1f;
        this.consumesPower = true;
        this.consumePower(6.5f);
      }
    };
    SCBlocksEffects.weicang = new StorageBlock("weicang") {
      {
        this.size = 1;
        this.itemCapacity = 80;
        this.health = 160;
        this.requirements(Category.effect, ItemStack.with(new Object[] { SCItems.lv, 50, SCItems.li, 50 }));
      }
    };
    SCBlocksEffects.juxingcang = new StorageBlock("juxingcang") {
      {
        this.size = 8;
        this.itemCapacity = 800;
        this.health = 2000;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 350, SCItems.li, 350, SCItems.cuguijing, 250, SCItems.xi, 250 }));
      }
    };
    SCBlocksEffects.lvunloader = new Unloader("lvunloader") {
      {
        this.size = 1;
        this.health = 200;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 50, SCItems.cuguijing, 25 }));
        this.speed = 6f;
      }
    };
  }
}
