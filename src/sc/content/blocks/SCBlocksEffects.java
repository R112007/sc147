package sc.content.blocks;

import arc.graphics.Color;
import mindustry.Vars;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.BuildTurret;
import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockGroup;
import sc.content.SCItems;
import sc.content.SCLiquids;
import sc.content.SCUnits;
import sc.world.blocks.denfence.ShieldBuildTurret;
import sc.world.blocks.effect.SCUnloader;

public class SCBlocksEffects {

  public static Block core1;
  public static Block core2;
  public static Block core3;
  public static Block core4;
  public static Block core5;
  public static Block tempcore;
  public static Block xiuliqi;
  public static Block xiuliqi2;
  public static Block xiuliqi3;
  public static Block xiuliqi4;
  public static Block repairturret1;
  public static Block repairturret2;
  public static Block repairturret3;
  public static Block liqiang1;
  public static Block liqiang2;
  public static Block liqiang3;
  public static Block jiasu1;
  public static Block jiasu2;
  public static Block jiasu3;
  public static Block jiasu4;
  public static Block build1;
  public static Block build2;
  public static Block lvrongqi;
  public static Block cangku2;
  public static Block cangku3;
  public static Block cangku4;
  public static Block weicang;
  public static Block weicang2;
  public static Block juxingcang;
  public static Block juxingcang2;
  public static Block lvunloader;
  public static Block unloader2;
  public static Block unloader3;
  public static Block unloader4;

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
    SCBlocksEffects.tempcore = new CoreBlock("tempcore") {
      {
        this.health = 3000;
        this.size = 2;
        this.itemCapacity = 3000;
        this.armor = 8;
        this.unitCapModifier = 10;
        this.unitType = SCUnits.tansuozhe;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 10000, SCItems.li, 10000, SCItems.chunguijing, 5000,
                SCItems.feijing, 3000, SCItems.lvgang, 4500, SCItems.jin, 3000, SCItems.you, 3000 }));
      }

      @Override
      public boolean canBreak(Tile tile) {
        return Vars.state.teams.cores(Vars.player.team()).size > 1;
      }

      @Override
      public boolean canReplace(Block other) {
        return other.alwaysReplace;
      }

      @Override
      public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        return Vars.state.teams.cores(team).size < 8;
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
        this.phaseRangeBoost = 25f;
        this.consumePower(1.5f);
        this.consumeItem(SCItems.chunguijing, 1).optional(true, true);
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 55, SCItems.li, 60, SCItems.cuguijing, 65, SCItems.xi, 60 }));
      }
    };
    SCBlocksEffects.xiuliqi3 = new MendProjector("xiuliqi3") {
      {
        this.size = 3;
        this.health = 880;
        this.reload = 150f;
        this.range = 160f;
        this.healPercent = 7f;
        this.itemCapacity = 20;
        this.phaseBoost = 40f;
        this.phaseRangeBoost = 40f;
        this.consumePower(4.5f);
        this.consumeItem(SCItems.gutaineng, 1).optional(true, true);
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lvgang, 85, SCItems.jin, 120, SCItems.you, 80, SCItems.sujiao, 45 }));
      }
    };
    SCBlocksEffects.xiuliqi4 = new MendProjector("xiuliqi4") {
      {
        this.size = 5;
        this.health = 2880;
        this.reload = 130f;
        this.range = 250f;
        this.healPercent = 8f;
        this.itemCapacity = 20;
        this.phaseBoost = 40f;
        this.phaseRangeBoost = 40f;
        this.consumePower(25f);
        this.consumeItem(SCItems.jinhuihejin, 1).optional(true, true);
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.chijin, 250, SCItems.sujiao, 120, SCItems.hejing1, 120, SCItems.hejing2, 45 }));
      }
    };
    SCBlocksEffects.repairturret1 = new PowerTurret("repairturret1") {
      {
        this.health = 820;
        this.size = 2;
        this.reload = 20;
        this.range = 240;
        this.inaccuracy = 0;
        this.targetAir = false;
        this.targetGround = false;
        this.targetHealing = true;
        this.shootCone = 2;
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.lv, 60, SCItems.li, 60, SCItems.xi, 50, SCItems.chunguijing, 45 }));
        this.recoil = 0;
        this.rotateSpeed = 8;
        this.shootSound = Sounds.lasershoot;
        this.consumePower(4f);
        this.consumeCoolant(0.2f).optional(true, true);
        this.hasPower = true;
        this.liquidCapacity = 60f;
        this.shootType = new LaserBoltBulletType() {
          {
            this.speed = 8;
            this.lifetime = 48;
            this.width = 2;
            this.height = 8;
            this.ammoMultiplier = 1;
            this.healPercent = 2;
            this.backColor = Color.valueOf("#98FFA9FF");
            this.collidesAir = true;
            this.collidesGround = true;
            this.collidesTeam = true;
            this.damage = 0;
          }
        };
      }
    };
    SCBlocksEffects.repairturret2 = new PowerTurret("repairturret2") {
      {
        this.health = 1720;
        this.size = 2;
        this.reload = 10;
        this.range = 300;
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.lv, 180, SCItems.li, 160, SCItems.sujiao, 50, SCItems.feijing, 45 }));
        this.inaccuracy = 0;
        this.targetAir = false;
        this.targetGround = false;
        this.targetHealing = true;
        this.shootCone = 2;
        this.shoot = new ShootAlternate() {
          {
            this.barrels = 2;
            this.spread = 5f;
            this.shots = 2;
          }
        };
        this.recoil = 0;
        this.rotateSpeed = 8;
        this.shootSound = Sounds.lasershoot;
        this.consumePower(13f);
        this.consumeCoolant(0.2f).optional(true, true);
        this.hasPower = true;
        this.liquidCapacity = 60f;
        this.shootType = new LaserBoltBulletType() {
          {
            this.speed = 11;
            this.lifetime = 30f;
            this.width = 2;
            this.height = 8;
            this.ammoMultiplier = 1;
            this.healPercent = 2.8f;
            this.backColor = Color.valueOf("#98FFA9FF");
            this.collidesAir = true;
            this.collidesGround = true;
            this.collidesTeam = true;
            this.damage = 0;
          }
        };
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
    SCBlocksEffects.weicang2 = new StorageBlock("weicang2") {
      {
        this.size = 1;
        this.armor = 10;
        this.itemCapacity = 250;
        this.health = 1200;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lvgang, 50, SCItems.chunguijing, 80, SCItems.jin, 75 }));
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
    SCBlocksEffects.cangku2 = new StorageBlock("cangku2") {
      {
        this.armor = 3;
        this.size = 3;
        this.itemCapacity = 2000;
        this.health = 1600;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 200, SCItems.chunguijing, 240, SCItems.jin, 120 }));
      }
    };
    SCBlocksEffects.cangku3 = new StorageBlock("cangku3") {
      {
        this.armor = 10;
        this.size = 2;
        this.itemCapacity = 3500;
        this.health = 3200;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lvgang, 200, SCItems.chunguijing, 340, SCItems.jin, 280 }));
      }
    };
    SCBlocksEffects.cangku4 = new StorageBlock("cangku4") {
      {
        this.armor = 30;
        this.size = 3;
        this.itemCapacity = 8000;
        this.health = 5600;
        this.requirements(Category.effect, ItemStack.with(new Object[] { SCItems.lv, 800, SCItems.feijing, 300,
            SCItems.chijin, 130, SCItems.jinhuihejin, 150, SCItems.you, 350 }));
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
    SCBlocksEffects.liqiang2 = new ForceProjector("liqiang2") {
      {
        this.size = 3;
        this.itemCapacity = 15;
        this.health = 1720;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.li, 150, SCItems.lvgang, 75, SCItems.feijing, 125 }));
        this.radius = 120f;
        this.shieldHealth = 1800f;
        this.phaseShieldBoost = 1800f;
        this.phaseRadiusBoost = 80f;
        this.phaseUseTime = 500f;
        this.cooldownNormal = 1.6f;
        this.cooldownLiquid = 2.6f;
        this.cooldownBrokenBase = 1f;
        this.consumesPower = true;
        this.consumePower(10f);
      }
    };
    SCBlocksEffects.liqiang3 = new ForceProjector("liqiang3") {
      {
        this.size = 5;
        this.itemCapacity = 30;
        this.health = 6880;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.chunguijing, 100, SCItems.sujiao, 75, SCItems.chijin, 125,
                SCItems.hejing1, 45 }));
        this.radius = 450f;
        this.shieldHealth = 30000f;
        this.phaseShieldBoost = 20000f;
        this.phaseRadiusBoost = 100f;
        this.phaseUseTime = 180f;
        this.cooldownNormal = 10f;
        this.cooldownLiquid = 15f;
        this.cooldownBrokenBase = 8f;
        this.consumesPower = true;
        this.consumePower(30f);
      }
    };
    SCBlocksEffects.jiasu1 = new OverdriveProjector("jiasu1") {
      {
        this.health = 805;
        this.size = 2;
        this.range = 100;
        this.speedBoostPhase = 0.5f;
        this.useTime = 100;
        this.phaseRangeBoost = 35;
        this.speedBoost = 1.1f;
        this.consumePower(4.5f);
        this.consumeItem(SCItems.gutaineng, 1).optional(true, true);
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.li, 50, SCItems.xi, 70, SCItems.chunguijing, 50, SCItems.sujiao, 45 }));
      }
    };
    SCBlocksEffects.jiasu2 = new OverdriveProjector("jiasu2") {
      {
        this.health = 1250;
        this.size = 3;
        this.range = 200;
        this.speedBoostPhase = 0.8f;
        this.useTime = 300;
        this.phaseRangeBoost = 55;
        this.speedBoost = 1.6f;
        this.consumePower(16f);
        this.consumeItems(ItemStack.with(SCItems.chunguijing, 1, SCItems.gutaineng, 1)).optional(false, true);
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.lvgang, 120, SCItems.xi, 70, SCItems.chunguijing, 80, SCItems.sujiao, 45,
                    SCItems.jinhuihejin, 45 }));
      }
    };
    SCBlocksEffects.jiasu3 = new OverdriveProjector("jiasu3") {
      {
        this.health = 2850;
        this.size = 3;
        this.range = 220;
        this.speedBoostPhase = 1.3f;
        this.useTime = 600;
        this.phaseRangeBoost = 45;
        this.speedBoost = 1.8f;
        this.consumePower(18f);
        this.consumeItem(SCItems.jinhuihejin, 1).optional(true, true);
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.gutaineng, 80, SCItems.lvgang, 70, SCItems.chunguijing, 120, SCItems.sujiao, 75,
                    SCItems.hejing1, 35 }));
      }
    };
    SCBlocksEffects.jiasu4 = new OverdriveProjector("jiasu4") {
      {
        this.health = 5800;
        this.size = 5;
        this.range = 270;
        this.speedBoostPhase = 2.5f;
        this.useTime = 1000;
        this.phaseRangeBoost = 50;
        this.speedBoost = 4f;
        this.consumePower(45f);
        this.consumeItem(SCItems.hejing1, 1).optional(true, true);
        this.consumeLiquids(LiquidStack.with(SCLiquids.nengliangliuti, 0.1f)).optional(false, true);
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.gutaineng, 80, SCItems.you, 150, SCItems.chunguijing, 140, SCItems.chijin, 75,
                    SCItems.hejing2, 35 }));
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
    SCBlocksEffects.juxingcang2 = new StorageBlock("juxingcang2") {
      {
        this.size = 12;
        this.itemCapacity = 2000;
        this.health = 4000;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 1500, SCItems.li, 1800, SCItems.cuguijing, 1300, SCItems.xi, 1300,
                SCItems.jinhuihejin, 100, SCItems.hejing1, 200 }));
      }
    };
    SCBlocksEffects.build1 = new BuildTurret("build1") {
      {
        this.buildSpeed = 1f;
        this.size = 2;
        this.range = 150;
        this.health = 800;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.cuguijing, 100, SCItems.xi, 120 }));
        this.canOverdrive = true;
        this.consumePower(3f);
      }
    };
    SCBlocksEffects.build2 = new ShieldBuildTurret("build2") {
      {
        this.buildSpeed = 5f;
        this.size = 2;
        this.range = 230;
        this.health = 2000;
        this.requirements(Category.effect,
            ItemStack.with(
                new Object[] { SCItems.chunguijing, 80, SCItems.feijing, 120, SCItems.sujiao, 60, SCItems.jin, 80 }));
        this.canOverdrive = true;
        this.consumePower(8f);
      }
    };
    SCBlocksEffects.lvunloader = new SCUnloader("lvunloader") {
      {
        this.size = 1;
        this.health = 200;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 50, SCItems.cuguijing, 25 }));
        this.speed = 6f;
        this.group = BlockGroup.transportation;
      }
    };
    SCBlocksEffects.unloader2 = new SCUnloader("unloader2") {
      {
        this.armor = 1;
        this.size = 1;
        this.health = 300;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.lv, 20, SCItems.cuguijing, 35, SCItems.xi, 25 }));
        this.speed = 3f;
        this.group = BlockGroup.transportation;
      }
    };
    SCBlocksEffects.unloader3 = new SCUnloader("unloader3") {
      {
        this.armor = 7;
        this.size = 1;
        this.health = 800;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.jin, 20, SCItems.you, 25, SCItems.jinhuihejin, 25 }));
        this.speed = 0.9f;
        this.group = BlockGroup.transportation;
      }
    };
    SCBlocksEffects.unloader4 = new SCUnloader("unloader4") {
      {
        this.armor = 24;
        this.size = 1;
        this.health = 2300;
        this.requirements(Category.effect,
            ItemStack.with(new Object[] { SCItems.chijin, 40, SCItems.hejing1, 35, SCItems.jinhuihejin, 60 }));
        this.speed = 0.19f;
        this.group = BlockGroup.transportation;
      }
    };
  }
}
