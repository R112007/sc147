package sc.content.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootPattern;
import mindustry.gen.Sounds;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.BaseTurret;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;
import sc.content.SCFx;
import sc.content.SCItems;
import sc.content.SCStatusEffects;

public class SCTurrets {

  public static Block danguanpao;
  public static Block duoguanpao;
  public static Block zhentian;
  public static Block liuxing;
  public static Block tujin1;

  public static void load() {
    SCTurrets.danguanpao = new ItemTurret("danguanpao") {
      {
        this.health = 160;
        this.size = 1;
        this.reload = 30.0f;
        this.range = 130.0f;
        this.inaccuracy = 0.0f;
        this.recoil = 1.0f;
        this.rotateSpeed = 5.0f;
        this.maxAmmo = 30;
        this.alwaysUnlocked = false;
        this.ammo(
            SCItems.lv, new BasicBulletType(6.0f, 23.0f) {
              {
                this.width = 5.0f;
                this.height = 8.0f;
                this.lifetime = 130 / 6f;
                this.reloadMultiplier = 1.5f;
                this.ammoMultiplier = 1.8f;
                this.despawnEffect = this.hitEffect = Fx.none;
              }
            },
            SCItems.li, new BasicBulletType(6.0f, 23f) {
              {
                this.width = 5.0f;
                this.height = 8.0f;
                this.lifetime = 130 / 6f;
                this.reloadMultiplier = 1.0f;
                this.ammoMultiplier = 1.3f;
              }
            });
        this.coolant = consumeCoolant(0.1f);
        this.requirements(Category.turret, ItemStack.with(new Object[] { SCItems.lv, 30 }));
        this.drawer = new DrawTurret() {
          {
            for (int i = 0; i < 2; i++) {
              int f = i;
              this.parts.add(new RegionPart("-" + (f == 0 ? "l" : "r")) {
                {
                  this.moveX = (f == 0 ? -1 : 1) * (0.3f);
                  this.under = false;
                  this.mirror = false;
                  this.moveY = 0.0f;
                  this.heatColor = Color.valueOf("FF7055FF");
                }
              });
            }
          }
        };
      }
    };
    SCTurrets.duoguanpao = new ItemTurret("duoguanpao") {
      {
        this.health = 240;
        this.size = 1;
        this.reload = 23.0f;
        this.range = 190.0f;
        this.inaccuracy = 0.0f;
        this.recoil = 1.0f;
        this.rotateSpeed = 5.0f;
        this.maxAmmo = 40;
        this.coolant = consumeCoolant(0.1f);
        this.requirements(Category.turret, ItemStack.with(new Object[] { SCItems.lv, 50, SCItems.li, 50 }));
        this.shoot = new ShootBarrel() {
          {
            this.shots = 2;
          }
        };
        this.ammo(
            SCItems.lv, new BasicBulletType(4f, 27f) {
              {
                this.width = 5.0f;
                this.height = 8.0f;
                this.lifetime = 190f / 4f;
                this.reloadMultiplier = 1.0f;
                this.ammoMultiplier = 1.3f;
              }
            },
            SCItems.li, new BasicBulletType(4f, 27f) {
              {
                this.width = 5.0f;
                this.height = 8.0f;
                this.lifetime = 190f / 4f;
                this.reloadMultiplier = 1.0f;
                this.ammoMultiplier = 1.3f;
              }
            },
            SCItems.cuguijing, new BasicBulletType(4f, 32f) {
              {
                this.width = 5.0f;
                this.height = 8.0f;
                this.lifetime = 190f / 4f;
                this.reloadMultiplier = 1.0f;
                this.ammoMultiplier = 1.3f;
                this.fragBullets = 2;
                this.fragBullet = new BasicBulletType(5.5f, 15f) {
                  {
                    this.lifetime = 15f;
                    this.height = 8f;
                    this.width = 8f;
                    this.hitEffect = Fx.none;
                  }
                };
              }
            });
      }
    };
    BulletType zhentianbullet = new BasicBulletType(6, 6f) {
      {
        this.reloadMultiplier = 1.5f;
        this.knockback = 0.2f;
        this.lifetime = 32f;
        this.width = 6f;
        this.height = 10f;
        this.splashDamage = 30f;
        this.splashDamageRadius = 15;
      }
    };

    SCTurrets.zhentian = new ItemTurret("zhentian") {
      {
        this.size = 2;
        this.health = 550;
        this.ammoPerShot = 1;
        this.range = 210f;
        this.reload = 8f;
        this.inaccuracy = 5f;
        this.ammoUseEffect = Fx.casing1;
        this.rotateSpeed = 2f;
        this.maxAmmo = 35;
        this.targetAir = true;
        this.targetGround = false;
        this.coolantMultiplier = 2;
        this.heatColor = Color.valueOf("#FF0000");
        this.coolant = consumeCoolant(0.2f);
        this.requirements(Category.turret, ItemStack.with(new Object[] { SCItems.lv, 120, SCItems.li, 85 }));
        this.ammo(SCItems.lv, zhentianbullet, SCItems.li, zhentianbullet, SCItems.cuguijing,
            new BasicBulletType(6, 6f) {
              {
                this.reloadMultiplier = 1.5f;
                this.knockback = 0.2f;
                this.lifetime = 32f;
                this.width = 6f;
                this.height = 10f;
                this.splashDamage = 47f;
                this.splashDamageRadius = 18;
                this.fragBullets = 4;
                this.fragBullet = new BasicBulletType(2f, 16f) {
                  {
                    this.lifetime = 30;
                  }
                };
              }
            },
            SCItems.chunguijing,
            new BasicBulletType(6, 16f) {
              {
                this.reloadMultiplier = 1.5f;
                this.knockback = 0.2f;
                this.lifetime = 32f;
                this.width = 6f;
                this.height = 10f;
                this.splashDamage = 59f;
                this.splashDamageRadius = 25f;
                this.fragBullets = 3;
                this.fragBullet = new BasicBulletType(2f, 16f) {
                  {
                    this.lifetime = 30;
                    this.fragBullets = 3;
                    this.fragBullet = new BasicBulletType(2f, 16f) {
                      {
                        this.lifetime = 30;
                        this.splashDamage = 35f;
                        this.splashDamageRadius = 25f;
                      }
                    };
                  }
                };
              }
            });
      }
    };
    SCTurrets.liuxing = new ItemTurret("liuxing") {
      {
        this.size = 1;
        this.health = 530;
        this.ammoPerShot = 1;
        this.coolant = consumeCoolant(0.1f);
        this.requirements(Category.turret, ItemStack.with(new Object[] { SCItems.lv, 60, SCItems.cuguijing, 35 }));
        this.range = 260;
        this.reload = 60;
        this.inaccuracy = 0;
        this.ammoPerShot = 1;
        this.ammoUseEffect = Fx.casing2;
        this.rotateSpeed = 1;
        this.maxAmmo = 30;
        this.targetAir = false;
        this.targetGround = true;
        this.coolantMultiplier = 2;
        this.heatColor = Color.valueOf("#FF0000");
        this.shootSound = Sounds.bang;
        this.ammo(
            SCItems.lv, new ArtilleryBulletType(3f, 10f) {
              {
                this.reloadMultiplier = 1;
                this.knockback = 1;
                this.lifetime = 260f / 3f;
                this.width = 8;
                this.height = 13;
                this.ammoMultiplier = 2;
                this.splashDamageRadius = 20;
                this.splashDamage = 25;
              }
            },
            SCItems.tandanzhi, new ArtilleryBulletType(3f, 14f) {
              {
                this.reloadMultiplier = 1;
                this.status = StatusEffects.burning;
                this.makeFire = true;
                this.incendChance = 0.5f;
                this.incendSpread = 1;
                this.incendAmount = 10;
                this.knockback = 1;
                this.lifetime = 260f / 3f;
                this.width = 8;
                this.height = 13;
                this.ammoMultiplier = 2;
                this.splashDamageRadius = 30;
                this.splashDamage = 42;
              }
            },
            SCItems.cuguijing, new ArtilleryBulletType(3f, 20f) {
              {
                this.reloadMultiplier = 1.2f;
                this.knockback = 1;
                this.lifetime = 260f / 3f;
                this.width = 8;
                this.homingPower = 0.03f;
                this.homingRange = 40;
                this.height = 13;
                this.ammoMultiplier = 3;
                this.splashDamageRadius = 20;
                this.splashDamage = 53;
              }
            });
      }
    };

    SCTurrets.tujin1 = new ItemTurret("tujin1") {
      {
        this.health = 860;
        this.ammoPerShot = 2;
        this.size = 2;
        this.reload = 15;
        this.range = 160;
        this.inaccuracy = 0;
        this.recoil = 3;
        this.requirements(Category.turret,
            ItemStack.with(new Object[] { SCItems.lv, 60, SCItems.li, 80, SCItems.cuguijing, 45 }));
        this.rotateSpeed = 5;
        this.maxAmmo = 80;
        this.alwaysUnlocked = false;
        this.shoot = new ShootAlternate(1.5f) {
          {
            this.barrels = 2;
            this.shots = 2;
            this.shotDelay = 2;
          }
        };
        this.consumePower(1f);
        this.coolant = consumeCoolant(0.2f);
        this.ammo(
            SCItems.lv, new BasicBulletType(6f, 32f) {
              {
                this.reloadMultiplier = 1.2f;
                this.ammoMultiplier = 4;
                this.width = 8;
                this.height = 14;
                this.inaccuracy = 3;
                this.smokeEffect = Fx.pulverizeRed;
                this.lifetime = 30;
              }
            },
            SCItems.li, new BasicBulletType(6f, 38f) {
              {
                this.reloadMultiplier = 1.2f;
                this.ammoMultiplier = 4;
                this.width = 8;
                this.height = 14;
                this.inaccuracy = 3;
                this.smokeEffect = Fx.pulverizeRed;
                this.lifetime = 30;
              }
            },
            SCItems.xi, new BasicBulletType(6f, 45f) {
              {
                this.reloadMultiplier = 1.2f;
                this.ammoMultiplier = 4;
                this.width = 8;
                this.height = 14;
                this.inaccuracy = 3;
                this.smokeEffect = Fx.pulverizeRed;
                this.lifetime = 30;
                this.reloadMultiplier = 1;
                this.ammoMultiplier = 4;
                this.width = 14;
                this.pierce = true;
                this.pierceCap = 3;
                this.height = 8;
                this.backColor = Color.valueOf("l#00ffff");
                this.frontColor = Color.valueOf("#00ffff");
                this.trailColor = Color.valueOf("#00ffff");
                this.inaccuracy = 2;
                this.smokeEffect = Fx.pulverizeRed;
                this.lifetime = 30f;
                this.status = SCStatusEffects.duanlu;
              }
            },
            SCItems.tandanzhi, new MissileBulletType(6f, 32f) {
              {
                this.width = 8;
                this.height = 18;
                this.status = StatusEffects.burning;
                this.lifetime = 30;
                this.homingPower = 0.1f;
                this.homingRange = 40;
                this.ammoMultiplier = 5;
                this.shrinkY = 0;
                this.drag = -0.01f;
                this.splashDamageRadius = 38;
                this.splashDamage = 25;
                this.backColor = Color.valueOf("CC6600");
                this.frontColor = Color.valueOf("FFAA33");
                this.trailColor = Color.valueOf("CC6600");
                this.hitEffect = Fx.massiveExplosion;
              }
            },
            SCItems.cuguijing, new BasicBulletType(5f, 42f) {
              {
                this.knockback = 1;
                this.width = 8;
                this.height = 18;
                this.spin = 0;
                this.shrinkY = 0;
                this.shrinkX = 0;
                this.lifetime = 30;
                this.hitEffect = Fx.explosion;
                this.trailLength = 4;
                this.trailWidth = 5;
                this.trailColor = Color.valueOf("ffce7b");
                this.trailRotation = true;
                this.trailEffect = Fx.disperseTrail;
                this.trailInterval = 3;
                this.fragBullets = 5;
                this.fragRandomSpread = 0;
                this.fragSpread = 25;
                this.fragAngle = 22.5f;
                this.fragVelocityMin = 0.5f;
                this.fragVelocityMax = 0.5f;
                this.fragBullet = new BasicBulletType(4f, 20f) {
                  {
                    this.splashDamageRadius = 8;
                    this.splashDamage = 25;
                    this.trailEffect = Fx.missileTrail;
                    this.trailInterval = 8;
                    this.trailLength = 2;
                    this.trailWidth = 2;
                    this.trailColor = Color.valueOf("ffce7b");
                    this.lifetime = 26;
                  }
                };
              }
            });
      }
    };
  }
}
