package sc.content;

import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import sc.entities.abilities.FlashAbility;
import sc.graphics.SCPal;
import arc.graphics.Color;
import arc.math.Rand;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.abilities.ShieldRegenFieldAbility;
import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.bullet.PointBulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.world.meta.BlockFlag;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.entities.effect.ParticleEffect;

public class SCUnits {
  public static UnitType tansuozhe;
  public static UnitType chujia1;// 101
  public static UnitType chujia2;// 133
  public static UnitType chujia3;// 168
  public static UnitType chujia4;// 224
  public static UnitType chujia5;// 321
  public static UnitType chujia6;// 423
  public static UnitType papa1;// 670
  public static UnitType papa2;// 703
  public static UnitType papa3;//
  public static UnitType liekong1;//
  public static UnitType liekong2;//
  public static UnitType liekong3;//

  public static void load() {
    SCUnits.tansuozhe = new UnitType("tansuozhe") {
      {
        this.health = 600.0f;
        this.constructor = UnitTypes.alpha.constructor;
        this.controller = UnitTypes.alpha.controller;
        this.flying = true;
        this.ammoType = new PowerAmmoType(800);
        this.speed = 6.0f;
        this.drag = 0.1f;
        this.accel = 0.3f;
        this.outlineColor = Color.valueOf("212121");
        this.lowAltitude = true;
        this.itemCapacity = 50;
        this.rotateSpeed = 22.0f;
        this.buildSpeed = 1.5f;
        this.buildBeamOffset = 3.0f;
        this.mineWalls = true;
        this.mineSpeed = 10.0f;
        this.mineTier = 1;
        this.mineRange = 100f;
        this.engineOffset = 6.5f;
        this.engineColor = SCPal.blue2;
        this.trailLength = 6;
        this.trailColor = SCPal.blue2;
        this.hitSize = 8;
        this.coreUnitDock = true;
        this.weapons.add(new RepairBeamWeapon() {
          {
            this.widthSinMag = 0.11f;
            this.reload = 10.0f;
            this.x = 0.0f;
            this.y = 4.0f;
            this.rotate = false;
            this.shootY = 0f;
            this.beamWidth = 0.7f;
            this.repairSpeed = 3.1f;
            this.fractionRepairSpeed = 0.06f;
            // this.aimDst = 0f;
            this.shootCone = 15f;
            this.mirror = false;
            this.targetBuildings = true;
            this.controllable = true;
            this.autoTarget = false;
            this.laserColor = SCPal.light_blue1;
            this.healColor = SCPal.light_blue1;
            this.bullet = new BulletType() {
              {
                this.maxRange = 120.0f;
              }
            };
          }
        });
      }
    };
    SCUnits.chujia1 = new UnitType("chujia1") {
      {
        this.constructor = UnitTypes.dagger.constructor;
        this.controller = UnitTypes.dagger.controller;
        this.speed = 0.3f;
        this.ammoType = new ItemAmmoType(SCItems.lv);
        this.health = 480.0f;
        this.itemCapacity = 0;
        this.armor = 1.0f;
        this.rotateSpeed = 3.0f;
        this.hitSize = 8.0f;
        this.weapons.add(new Weapon("sc-chujia1-weapon") {
          {
            this.reload = 5.0f;
            this.x = -4.0f;
            this.y = 0.75f;
            this.top = false;
            this.ejectEffect = Fx.casing1;
            this.bullet = new BasicBulletType(3.0f, 16.0f) {
              {
                this.width = 7.0f;
                this.height = 13.0f;
                this.lifetime = 30.0f;
                this.shootEffect = Fx.shootSmall;
                this.smokeEffect = Fx.shootSmallSmoke;
                this.ammoMultiplier = 1.5f;
              }
            };
          }
        });
      }
    };
    SCUnits.chujia2 = new UnitType("chujia2") {
      {
        this.constructor = UnitTypes.dagger.constructor;
        this.controller = UnitTypes.dagger.controller;
        this.speed = 0.35f;
        this.ammoType = new ItemAmmoType(SCItems.cuguijing);
        this.health = 1260.0f;
        this.itemCapacity = 0;
        this.armor = 4.0f;
        this.rotateSpeed = 2.0f;
        this.hitSize = 8.0f;
        this.weapons.add(new Weapon("sc-chujia2-weapon") {
          {
            this.reload = 7.0f;
            this.top = false;
            this.x = -7.0f;
            this.y = 0.0f;
            this.ejectEffect = Fx.casing1;
            this.bullet = new MissileBulletType(7.0f, 25.0f) {
              {
                this.width = 4.0f;
                this.height = 12.0f;
                this.lifetime = 30.0f;
                this.splashDamage = 32.0f;
                this.splashDamageRadius = 16.0f;
                this.status = StatusEffects.blasted;
                this.hitEffect = Fx.flakExplosion;
                this.homingPower = 2.0f;
                this.trailChance = 0.4f;
              }
            };
          }
        });
      }
    };
    SCUnits.chujia3 = new UnitType("chujia3") {
      {
        this.constructor = UnitTypes.dagger.constructor;
        this.controller = UnitTypes.dagger.controller;
        this.speed = 0.35f;
        this.ammoType = new ItemAmmoType(SCItems.cuguijing);
        this.health = 3050.0f;
        this.itemCapacity = 0;
        this.armor = 6.0f;
        this.rotateSpeed = 2.0f;
        this.hitSize = 8.0f;
        this.abilities.add(new ForceFieldAbility(22f, 0.3f, 300f, 100f));
        this.abilities.add(new ShieldRegenFieldAbility(40, 400, 300, 44));
        this.weapons.add(new Weapon("sc-chujia3-weapon") {
          {
            this.reload = 7.0f;
            this.x = 11.0f;
            this.y = 0f;
            this.top = false;
            this.ejectEffect = Fx.casing1;
            this.bullet = new BasicBulletType(4.0f, 35.0f) {
              {
                this.sprite = "sc-chujia3-bullet";
                this.width = 8.0f;
                this.height = 16.0f;
                this.lifetime = 40.0f;
                this.shootEffect = Fx.shootSmall;
                this.smokeEffect = Fx.shootSmallSmoke;
                this.ammoMultiplier = 1.2f;
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-chujia3-weapon2") {
          {
            this.reload = 30.0f;
            this.x = 4.0f;
            this.y = 0.0f;
            this.ejectEffect = Fx.casing1;
            this.bullet = new MissileBulletType(7.0f, 15.0f) {
              {
                this.width = 8.0f;
                this.height = 12.0f;
                this.lifetime = 40.0f;
                this.splashDamage = 36.0f;
                this.splashDamageRadius = 16.0f;
                this.status = StatusEffects.blasted;
                this.hitEffect = Fx.flakExplosion;
                this.homingPower = 2.0f;
                this.trailChance = 0.4f;
              }
            };
          }
        });
      }
    };
    SCUnits.chujia4 = new UnitType("chujia4") {
      {
        this.constructor = UnitTypes.dagger.constructor;
        this.controller = UnitTypes.dagger.controller;
        this.speed = 0.35f;
        this.ammoType = new PowerAmmoType(2400);
        this.health = 14600.0f;
        this.itemCapacity = 0;
        this.armor = 12.0f;
        this.rotateSpeed = 1.2f;
        this.hitSize = 21.0f;
        this.weapons.add(new Weapon("sc-chujia4-weapon1") {
          {
            this.reload = 60.0f;
            this.x = 13.5f;
            this.y = 0f;
            this.top = false;
            this.shoot.shots = 2;
            this.shoot.shotDelay = 10.0f;
            this.ejectEffect = Fx.casing1;
            this.bullet = new BasicBulletType(6.0f, 180.0f) {
              {
                this.width = 10.0f;
                this.height = 20.0f;
                this.buildingDamageMultiplier = 1.8f;
                this.lifetime = 50.0f;
                this.shootEffect = Fx.shootSmall;
                this.smokeEffect = Fx.shootSmallSmoke;
                this.ammoMultiplier = 1.2f;
                this.lightningDamage = 35;
                this.lightning = 4;
                this.lightningLength = 15;
                this.fragBullets = 3;
                this.fragBullet = new BasicBulletType(6.2f, 20.0f) {
                  {
                    this.width = 5.0f;
                    this.height = 8.0f;
                    this.buildingDamageMultiplier = 2.0f;
                    this.lifetime = 15.0f;
                    this.lightningDamage = 20;
                    this.lightning = 3;
                    this.lightningLength = 10;
                    this.fragBullets = 2;
                    this.fragBullet = new BasicBulletType(6.2f, 30.0f) {
                      {
                        this.lifetime = 10.0f;
                        this.splashDamageRadius = 15;
                        this.splashDamage = 20;
                        this.buildingDamageMultiplier = 2.0f;
                      }
                    };
                  }
                };
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-chujia4-weapon2") {
          {
            this.reload = 30.0f;
            this.top = true;
            this.x = 7.5f;
            this.y = 0.0f;
            this.ejectEffect = Fx.none;
            this.bullet = new ShrapnelBulletType() {
              {
                this.damage = 100;
                this.lifetime = 15;
                this.length = 120;
                this.width = 15;
                this.serrationLenScl = 3;
                this.serrationSpaceOffset = 30;
                this.serrationFadeOffset = 0;
                this.serrations = 10;
                this.serrationWidth = 3;
                this.statusDuration = 300;
                this.status = StatusEffects.sapped;
                this.fromColor = Color.valueOf("#00c7fc");
                this.toColor = Color.valueOf("#0031fc");
                this.shootEffect = new ParticleEffect() {
                  {
                    this.particles = 4;
                    this.line = true;
                    this.length = 15;
                    this.baseLength = 0;
                    this.lifetime = 15;
                    this.colorFrom = Color.valueOf("#0031fc");
                    this.colorTo = Color.valueOf("#00c7fc");
                    this.cone = 20;
                  }
                };
              }
            };
          }
        });
      }
    };
    SCUnits.chujia5 = new UnitType("chujia5") {
      {
        this.constructor = UnitTypes.reign.constructor;
        this.controller = UnitTypes.reign.controller;
        this.speed = 0.2f;
        this.ammoType = new ItemAmmoType(SCItems.chijin);
        this.health = 70000.0f;
        this.itemCapacity = 0;
        this.armor = 30.0f;
        this.rotateSpeed = 1.2f;
        this.hitSize = 40.0f;
        this.weapons.add(new Weapon("sc-chujia5-weapon") {
          {
            this.reload = 50.0f;
            this.shootY = 6.0f;
            this.x = -20.0f;
            this.y = 0.0f;
            this.top = false;
            this.ejectEffect = SCFx.casingbig;
            this.shoot.shots = 3;
            this.shoot.shotDelay = 10.0f;
            Rand rand = new Rand();
            this.bullet = new BasicBulletType(6.0f, rand.chance(0.5) ? 250.0f : 350.0f) {
              {
                this.shootEffect = Fx.shootSmall;
                this.smokeEffect = Fx.shootSmallSmoke;
                this.width = 10.0f;
                this.height = 20.0f;
                this.lifetime = 50.0f;
                this.ammoMultiplier = 1.5f;
                this.homingPower = 0.8f;
                this.homingRange = 260;
                this.fragBullets = 2;
                this.fragBullet = new BasicBulletType(6.0f, 150.0f) {
                  {
                    this.width = 5.0f;
                    this.height = 10.0f;
                    this.lifetime = 30.0f;
                    this.ammoMultiplier = 1.5f;
                    this.homingPower = 0.8f;
                    this.homingRange = 60;
                    this.fragBullets = 4;
                    this.fragBullet = new BasicBulletType(2.0f, 120.0f) {
                      {
                        this.width = 3.0f;
                        this.height = 8.0f;
                        this.lifetime = 10.0f;
                        this.ammoMultiplier = 1.5f;
                        this.lightningDamage = 50.0f;
                        this.lightning = 6;
                        this.lightningColor = SCPal.blue2;
                      }
                    };

                  }
                };
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-chujia4-weapon2") {
          {
            this.reload = 50.0f;
            this.top = true;
            this.x = 11.25f;
            this.y = -3.25f;
            this.ejectEffect = Fx.none;
            this.shootY = 3.0f;
            this.shoot = new ShootSpread(3, 8.0f);
            this.bullet = new ShrapnelBulletType() {
              {
                this.damage = 250;
                this.lifetime = 25;
                this.length = 200;
                this.width = 25;
                this.serrationLenScl = 3;
                this.serrationSpaceOffset = 30;
                this.serrationFadeOffset = 0;
                this.serrations = 10;
                this.serrationWidth = 3;
                this.statusDuration = 300;
                this.status = StatusEffects.sapped;
                this.fromColor = Color.valueOf("#00c7fc");
                this.toColor = Color.valueOf("#0031fc");
                this.shootEffect = new ParticleEffect() {
                  {
                    this.particles = 4;
                    this.line = true;
                    this.length = 15;
                    this.baseLength = 0;
                    this.lifetime = 15;
                    this.colorFrom = Color.valueOf("#0031fc");
                    this.colorTo = Color.valueOf("#00c7fc");
                    this.cone = 20;
                  }
                };
              }
            };
          }
        });
      }
    };
    SCUnits.chujia6 = new UnitType("chujia6") {
      {
        this.constructor = UnitTypes.reign.constructor;
        this.controller = UnitTypes.reign.controller;
        this.speed = 0.4f;
        this.ammoType = new ItemAmmoType(SCItems.hejing1);
        this.health = 310000.0f;
        this.itemCapacity = 0;
        this.armor = 35.0f;
        this.rotateSpeed = 2f;
        this.hitSize = 44.0f;
        this.weapons.add(new Weapon("sc-chujia6-weapon1") {
          {
            this.reload = 60.0f;
            this.shootY = 6.0f;
            this.x = 28.0f;
            this.y = 1.0f;
            this.top = false;
            this.ejectEffect = SCFx.casingbig;
            this.shoot.shots = 2;
            this.shoot.shotDelay = 5.0f;
            this.bullet = new BasicBulletType(6f, 500f) {
              {
                this.shootEffect = Fx.shootSmall;
                this.smokeEffect = Fx.shootSmallSmoke;
                this.width = 10.0f;
                this.height = 20.0f;
                this.lifetime = 50.0f;
                this.ammoMultiplier = 1.5f;
                this.homingPower = 0.8f;
                this.homingRange = 260;
                this.lightningDamage = 50f;
                this.lightning = 5;
                this.lightningLength = 28;
                this.lightColor = SCPal.blue1;
                this.fragBullets = 5;
                this.fragBullet = new BasicBulletType(6.2f, 125f) {
                  {
                    this.lifetime = 15.0f;
                    this.homingPower = 0.8f;
                    this.homingRange = 260;
                    this.lightningDamage = 40f;
                    this.lightning = 2;
                    this.lightningLength = 14;
                    this.lightColor = SCPal.blue1;
                    this.fragBullets = 1;
                    this.fragBullet = new PointBulletType() {
                      {
                        this.trailSpacing = 9f;
                        this.trailEffect = new ParticleEffect() {
                          {
                            this.particles = 1;
                            this.length = 0;
                            this.baseLength = 1;
                            this.lifetime = 8;
                            this.line = true;
                            this.randLength = false;
                            this.lenFrom = 10;
                            this.lenTo = 10;
                            this.strokeFrom = 2;
                            this.strokeTo = 0;
                            this.colorFrom = SCPal.blue1;
                            this.colorTo = SCPal.blue1;
                            this.cone = 0;
                          }
                        };
                        this.lifetime = 10;
                        this.speed = 15;
                        this.homingPower = 0.8f;
                        this.homingRange = 260;
                        this.statusDuration = 60;
                        this.buildingDamageMultiplier = 3;
                        this.splashDamageRadius = 38;
                        this.splashDamage = 300;
                        this.hitShake = 6;
                        this.hitSound = Sounds.laser;
                        this.hitEffect = this.despawnEffect = SCFx.pointdown;
                        this.fragBullets = 2;
                        this.fragBullet = new PointBulletType() {
                          {
                            this.trailSpacing = 9f;
                            this.trailEffect = new ParticleEffect() {
                              {
                                this.particles = 1;
                                this.length = 0;
                                this.baseLength = 1;
                                this.lifetime = 8;
                                this.line = true;
                                this.randLength = false;
                                this.lenFrom = 10;
                                this.lenTo = 10;
                                this.strokeFrom = 2;
                                this.strokeTo = 0;
                                this.colorFrom = SCPal.blue1;
                                this.colorTo = SCPal.blue1;
                                this.cone = 0;
                              }
                            };
                            this.lifetime = 10;
                            this.speed = 15;
                            this.homingPower = 0.8f;
                            this.homingRange = 260;
                            this.statusDuration = 60;
                            this.buildingDamageMultiplier = 3;
                            this.splashDamageRadius = 38;
                            this.splashDamage = 300;
                            this.hitShake = 6;
                            this.hitSound = Sounds.laser;
                            this.hitEffect = this.despawnEffect = SCFx.pointdown;
                          }
                        };
                      }
                    };
                  }
                };
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-chujia6-weapon2") {
          {
            this.mirror = true;
            this.alternate = true;
            this.x = 15f;
            this.y = -7;
            this.shootSound = Sounds.shootBig;
            this.reload = 30f;
            this.recoil = 1f;
            this.top = true;
            this.rotate = true;
            this.inaccuracy = 0.5f;
            this.rotateSpeed = 2.3f;
            this.bullet = new BasicBulletType(8f, 845f) {
              {
                this.splashDamage = 600;
                this.reflectable = false;
                this.splashDamageRadius = 40;
                this.pierce = true;
                this.pierceBuilding = true;
                this.pierceArmor = true;
                this.pierceCap = 3;
                this.lifetime = 60;
                this.hitSound = Sounds.explosion;
                this.shootEffect = Fx.shootBig;
                this.smokeEffect = Fx.shootBigSmoke;
                this.width = 12;
                this.height = 20;
                this.despawnEffect = Fx.flakExplosionBig;
                this.hitEffect = new ParticleEffect() {
                  {
                    this.particles = 22;
                    this.lifetime = 11;
                    this.length = 33;
                    this.baseLength = 2;
                    this.strokeFrom = 2;
                    this.strokeTo = 0;
                    this.colorFrom = SCPal.light_blue1;
                    this.colorTo = Color.white;
                    this.cone = 360f;
                    this.lenTo = 0f;
                    this.lenFrom = 18f;
                    this.line = true;
                  }
                };
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-chujia6-weapon2") {
          {
            this.mirror = true;
            this.alternate = true;
            this.x = 14f;
            this.y = 7;
            this.shootSound = Sounds.shootBig;
            this.reload = 30f;
            this.recoil = 1f;
            this.top = true;
            this.rotate = true;
            this.inaccuracy = 0.5f;
            this.rotateSpeed = 2.3f;
            this.bullet = new BasicBulletType(8f, 845f) {
              {
                this.splashDamage = 600;
                this.reflectable = false;
                this.splashDamageRadius = 40;
                this.pierce = true;
                this.pierceBuilding = true;
                this.pierceArmor = true;
                this.pierceCap = 3;
                this.lifetime = 60;
                this.hitSound = Sounds.explosion;
                this.shootEffect = Fx.shootBig;
                this.smokeEffect = Fx.shootBigSmoke;
                this.width = 12;
                this.height = 20;
                this.despawnEffect = Fx.flakExplosionBig;
                this.hitEffect = new ParticleEffect() {
                  {
                    this.particles = 22;
                    this.lifetime = 11;
                    this.length = 33;
                    this.baseLength = 2;
                    this.strokeFrom = 2;
                    this.strokeTo = 0;
                    this.colorFrom = SCPal.light_blue1;
                    this.colorTo = Color.white;
                    this.cone = 360f;
                    this.lenTo = 0f;
                    this.lenFrom = 18f;
                    this.line = true;
                  }
                };
              }
            };
          }
        });
        this.abilities.add(new ShieldArcAbility() {
          {
            this.radius = 80;
            this.width = 20;
            this.max = 5000;
            this.regen = 1;
            this.cooldown = 1200;
            this.angle = 360;
            this.angleOffset = 80;
            this.whenShooting = false;
          }
        });
        this.abilities.add(new UnitSpawnAbility() {
          {
            this.unit = SCUnits.chujia4;
            this.spawnX = 25f;
            this.spawnY = -8.5f;
            this.spawnTime = 3600f;
          }
        });
        this.abilities.add(new UnitSpawnAbility() {
          {
            this.unit = SCUnits.chujia4;
            this.spawnX = -25f;
            this.spawnY = -8.5f;
            this.spawnTime = 3600f;
          }
        });
      }
    };
    SCUnits.papa1 = new UnitType("papa1") {
      {
        this.health = 500f;
        this.hitSize = 10f;
        this.rotateSpeed = 5f;
        this.itemCapacity = 10;
        this.constructor = UnitTypes.crawler.constructor;
        this.controller = UnitTypes.crawler.controller;
        this.speed = 1f;
        this.weapons.add(new Weapon() {
          {
            this.reload = 5f;
            this.x = 0f;
            this.y = 0f;
            this.top = false;
            this.shootOnDeath = true;
            this.shootCone = 270f;
            this.bullet = new BasicBulletType(1f, 50) {
              {
                this.lifetime = 10f;
                this.splashDamageRadius = 68f;
                this.splashDamage = 160f;
                this.instantDisappear = true;
                this.killShooter = true;
                this.width = 0f;
                this.height = 0f;
                this.despawnEffect = this.hitEffect = SCFx.bomb1;
              }
            };
          }
        });
      }
    };
    SCUnits.papa2 = new UnitType("papa2") {
      {
        this.health = 880f;
        this.armor = 5f;
        this.legCount = 4;
        this.ammoType = new ItemAmmoType(SCItems.tandanzhi);
        this.legLength = 9;
        this.legBaseOffset = 0;
        this.legExtension = 0f;
        this.legMoveSpace = 1.4f;
        this.legSplashDamage = 1f;
        this.legSplashRange = 2f;
        this.rippleScale = 0.1f;
        this.legLengthScl = 1f;
        this.hovering = true;
        this.drawShields = false;
        this.allowLegStep = true;
        this.hitSize = 15f;
        this.rotateSpeed = 5f;
        this.itemCapacity = 20;
        this.constructor = UnitTypes.atrax.constructor;
        this.controller = UnitTypes.atrax.controller;
        this.legCount = 4;
        this.weapons.add(new Weapon("sc-papa2-weapon1") {
          {
            this.reload = 30;
            this.x = -5.5f;
            this.y = 0;
            this.rotate = false;
            this.inaccuracy = 0;
            this.shake = 0;
            this.top = true;
            this.alternate = true;
            this.ejectEffect = Fx.casing3;
            this.shootSound = Sounds.artillery;
            this.bullet = new ArtilleryBulletType(2f, 35f) {
              {
                this.collides = true;
                this.collidesTiles = true;
                this.knockback = 0.1f;
                this.hitEffect = Fx.flakExplosionBig;
                this.despawnEffect = Fx.flakExplosionBig;
                this.smokeEffect = Fx.shootBig;
                this.splashDamage = 45;
                this.splashDamageRadius = 25;
                this.width = 6;
                this.height = 8;
                this.lifetime = 60;
              }
            };
          }
        });
        this.weapons.add(new Weapon() {
          {
            this.reload = 8;
            this.mirror = false;
            this.x = 0;
            this.y = 0;
            this.shootY = 1;
            this.shoot.shots = 4;
            this.shoot.shotDelay = 1f;
            this.bullet = new BasicBulletType(5f, 20f) {
              {
                this.status = StatusEffects.burning;
                this.collidesAir = true;
                this.width = 0.1f;
                this.height = 0.1f;
                this.smokeEffect = Fx.none;
                this.lifetime = 15;
                this.despawnEffect = Fx.none;
                this.hittable = false;
                this.reflectable = false;
                this.pierce = true;
                this.makeFire = true;
                this.incendAmount = 1;
                this.hitEffect = new ParticleEffect() {
                  {
                    this.particles = 7;
                    this.sizeFrom = 2;
                    this.sizeTo = 0;
                    this.length = 20;
                    this.lifetime = 15;
                    this.interp = interp.circleOut;
                    this.colorFrom = Color.valueOf("#ff0000");
                    this.colorTo = Color.valueOf("#ff9900");
                    this.cone = 360f;
                  }
                };
                this.shootEffect = new ParticleEffect() {
                  {
                    this.particles = 7;
                    this.sizeFrom = 2;
                    this.sizeTo = 0;
                    this.length = 20;
                    this.lifetime = 15;
                    this.interp = interp.circleOut;
                    this.colorFrom = Color.valueOf("#ff0000");
                    this.colorTo = Color.valueOf("#ff9900");
                    this.cone = 360f;
                  }
                };
              }
            };
          }
        });
      }
    };
    SCUnits.liekong1 = new UnitType("liekong1") {
      {
        this.hitSize = 7f;
        this.rotateSpeed = 5f;
        this.itemCapacity = 10;
        this.constructor = UnitTypes.flare.constructor;
        this.controller = UnitTypes.flare.controller;
        this.canDrown = false;
        this.circleTarget = true;
        this.forceMultiTarget = true;
        this.buildSpeed = 0f;
        this.ammoType = new ItemAmmoType(SCItems.cuguijing);
        this.flying = true;
        this.speed = 1.8f;
        this.health = 300;
        this.engineSize = 2.5f;
        this.engineOffset = 4f;
        this.armor = 3;
        this.abilities.add(new FlashAbility(24f, 60f, Fx.none, 20f, 10f));
        this.targetFlags = new BlockFlag[] { BlockFlag.generator, null };
        this.weapons.add(new Weapon("sc-liekong1-weapon") {
          {
            this.mirror = true;
            this.alternate = true;
            this.x = -2.6f;
            this.y = 0;
            this.shootSound = Sounds.missile;
            this.reload = 20f;
            this.recoil = 0f;
            this.top = false;
            this.bullet = new MissileBulletType(5f, 12f) {
              {
                this.splashDamage = 13;
                this.splashDamageRadius = 12f;
                this.status = StatusEffects.blasted;
                this.width = 4f;
                this.height = 12f;
                this.hitEffect = Fx.flakExplosion;
                this.lifetime = 30;
                this.homingPower = 6f;
                this.trailChance = 0.4f;
                this.trailColor = SCPal.light_blue1;
                this.frontColor = SCPal.light_blue1;
                this.hitEffect = this.despawnEffect = SCFx.airmisslesmall;
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-liekong1-weapon") {
          {
            this.y = 0f;
            this.x = -2.6f;
            this.shootY = 3f;
            this.mirror = true;
            this.alternate = true;
            this.recoil = 0;
            this.reload = 15f;
            this.shake = 0f;
            this.shootSound = Sounds.shoot;
            this.rotate = false;
            this.top = false;
            this.bullet = new BasicBulletType(6f, 15f) {
              {
                this.width = 8;
                this.height = 12;
                this.lifetime = 30;
                this.shootEffect = Fx.shootSmallSmoke;
                this.frontColor = SCPal.light_blue1;
                this.hitEffect = SCFx.airmisslesmall;
                this.despawnEffect = SCFx.airmisslesmall;
              }
            };
          }
        });
      }
    };
    SCUnits.liekong2 = new UnitType("liekong2") {
      {
        this.hitSize = 11f;
        this.rotateSpeed = 5f;
        this.itemCapacity = 30;
        this.constructor = UnitTypes.horizon.constructor;
        this.controller = UnitTypes.horizon.controller;
        this.canDrown = false;
        this.circleTarget = false;
        this.abilities.add(new FlashAbility(24f, 60f, Fx.none, 20f, 10f));
        this.forceMultiTarget = true;
        this.buildSpeed = 0f;
        this.ammoType = new ItemAmmoType(SCItems.cuguijing);
        this.flying = true;
        this.speed = 1.3f;
        this.health = 850;
        this.engineSize = 2.5f;
        this.engineOffset = 7.2f;
        this.armor = 5;
        this.targetFlags = new BlockFlag[] { BlockFlag.factory, null };
        this.weapons.add(new Weapon("sc-liekong2-weapon") {
          {
            this.top = false;
            this.mirror = true;
            this.alternate = true;
            this.x = -4f;
            this.y = 4f;
            this.reload = 10f;
            this.recoil = 2f;
            this.bullet = new MissileBulletType(4f, 24f) {
              {
                this.splashDamage = 33;
                this.splashDamageRadius = 12f;
                this.status = StatusEffects.blasted;
                this.width = 7f;
                this.height = 14f;
                // this.hitEffect = Fx.flakExplosion;
                this.lifetime = 40;
                this.homingPower = 6f;
                this.trailChance = 0.4f;
                this.trailColor = SCPal.light_blue1;
                this.frontColor = SCPal.light_blue1;
                this.hitEffect = this.despawnEffect = SCFx.airmisslemiddle;
              }
            };
          }
        });
      }
    };
    SCUnits.liekong3 = new UnitType("liekong3") {
      {
        this.hitSize = 30f;
        this.rotateSpeed = 3f;
        this.itemCapacity = 30;
        this.abilities.add(new ForceFieldAbility(42f, 0.3f, 600f, 160f));
        this.constructor = UnitTypes.zenith.constructor;
        this.controller = UnitTypes.zenith.controller;
        this.canDrown = false;
        this.circleTarget = false;
        this.forceMultiTarget = true;
        this.buildSpeed = 0f;
        this.ammoType = new ItemAmmoType(SCItems.chunguijing);
        this.flying = true;
        this.speed = 1f;
        this.health = 3150;
        this.engineSize = 3.5f;
        this.engineOffset = 12f;
        this.lowAltitude = true;
        this.armor = 10;
        this.targetFlags = new BlockFlag[] { BlockFlag.storage, BlockFlag.battery, null };
        this.weapons.add(new Weapon("sc-liekong3-weapon2") {
          {
            this.mirror = true;
            this.alternate = true;
            this.rotate = true;
            this.rotateSpeed = 2.1f;
            this.x = -7f;
            this.y = 7f;
            this.reload = 25f;
            this.recoil = 0.5f;
            this.top = true;
            this.bullet = new MissileBulletType(4f, 52f) {
              {
                this.splashDamage = 53;
                this.splashDamageRadius = 12f;
                this.status = StatusEffects.blasted;
                this.width = 12f;
                this.height = 20f;
                // this.hitEffect = Fx.flakExplosion;
                this.lifetime = 50;
                this.homingPower = 6f;
                this.trailChance = 0.4f;
                this.trailColor = SCPal.light_blue1;
                this.frontColor = SCPal.light_blue1;
                this.hitEffect = this.despawnEffect = SCFx.airmisslemiddle;
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-liekong3-weapon2") {
          {
            this.mirror = true;
            this.rotate = true;
            this.rotateSpeed = 2.1f;
            this.alternate = true;
            this.x = -10f;
            this.y = -6.75f;
            this.reload = 35f;
            this.recoil = 0.5f;
            this.top = true;
            this.bullet = new MissileBulletType(4f, 52f) {
              {
                this.splashDamage = 53;
                this.splashDamageRadius = 24f;
                this.status = StatusEffects.blasted;
                this.width = 12f;
                this.height = 20f;
                // this.hitEffect = Fx.flakExplosion;
                this.lifetime = 50;
                this.homingPower = 6f;
                this.trailChance = 0.4f;
                this.trailColor = SCPal.light_blue1;
                this.frontColor = SCPal.light_blue1;
                this.hitEffect = this.despawnEffect = SCFx.airmisslemiddle;
              }
            };
          }
        });
        this.weapons.add(new Weapon("sc-liekong3-weapon1") {
          {
            this.reload = 30.0f;
            this.x = 0f;
            this.y = 0f;
            this.top = true;
            this.mirror = false;
            this.rotate = true;
            this.rotateSpeed = 2.1f;
            this.ejectEffect = Fx.casing1;
            this.bullet = new BasicBulletType(4.5f, 85.0f) {
              {
                this.width = 10.0f;
                this.height = 22.0f;
                this.lifetime = 70.0f;
                this.shootEffect = Fx.shootSmall;
                this.ammoMultiplier = 1.5f;
                this.pierce = true;
                this.pierceCap = 2;
                this.pierceBuilding = true;
                this.trailLength = 5;
                this.trailWidth = 1.3f;
                this.trailColor = SCPal.blue1;
                this.hitEffect = this.despawnEffect = SCFx.airpiercedown;

              }
            };
          }
        });
      }
    };
  }
}
