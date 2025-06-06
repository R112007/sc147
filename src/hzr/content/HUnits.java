package hzr.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.MissileUnitType;
import sc.content.SCItems;
import sc.entities.abilities.ContinueRepairField;
import sc.entities.abilities.DeathItemDrop;
import sc.type.weapons.MultiWeapon;

public class HUnits {
  public static UnitType
  // 玩家
  ningwang,
      // 机甲
      qiyuan1,
      // 坦克
      fenghuo1,
      // 物资
      unitbrokena;

  public static void load() {
    HUnits.ningwang = new UnitType("ningwang") {
      {
        this.health = 400.0f;
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
        this.mineSpeed = 4.0f;
        this.mineTier = 1;
        this.mineRange = 100f;
        this.engineOffset = 6.5f;
        this.engineColor = Color.valueOf("#79C5C5FF");
        this.trailLength = 6;
        this.trailColor = Color.valueOf("#79C5C5FF");
        this.hitSize = 12;
        this.coreUnitDock = true;
        this.abilities.add(new ContinueRepairField(1.5f, 64, true, true));
        this.weapons.add(new MultiWeapon(HBullets.ningwangbullet) {
          {
            this.reload = 65.0f;
            this.x = 0f;
            this.y = 0.75f;
            this.top = false;
            this.inaccuracy = 0f;
            this.bullet = HBullets.ningwangbullet;
          }
        });
      }
    };
    HUnits.qiyuan1 = new UnitType("qiyuan1") {
      {
        this.constructor = UnitTypes.dagger.constructor;
        this.controller = UnitTypes.dagger.controller;
        this.speed = 0.63f;
        this.ammoType = new ItemAmmoType(HItems.gao);
        this.hitSize = 8;
        this.health = 590;
        this.itemCapacity = 0;
        this.armor = 1;
        this.rotateSpeed = 3;
        this.abilities.add(new DeathItemDrop(ItemStack.with(HItems.brokenA, 2, HItems.brokenB, 2)));
        this.weapons.add(new Weapon("sc-qiyuan1-weapon") {
          {
            this.reload = 15;
            this.x = 3;
            this.y = 0;
            this.top = false;
            this.ejectEffect = Fx.casing1;
            this.bullet = new BasicBulletType() {
              {
                this.damage = 33;
                this.speed = 3;
                this.width = 3;
                this.height = 6;
                this.lifetime = 40;
                this.frontColor = Color.valueOf("#99F8FFFF");
                this.shootEffect = Fx.shootSmall;
                this.smokeEffect = Fx.shootSmallSmoke;
                this.despawnEffect = this.hitEffect = HFx.smallmechhit;
              }
            };
          }
        });
      }
    };
    HUnits.fenghuo1 = new UnitType("fenghuo1") {
      {
        this.constructor = UnitTypes.stell.constructor;
        this.controller = UnitTypes.stell.controller;
        this.ammoType = new ItemAmmoType(SCItems.cuguijing);
        this.armor = 1;
        this.speed = 0.8f;
        this.rotateSpeed = 8;
        this.abilities.add(new DeathItemDrop(ItemStack.with(HItems.brokenA, 4, HItems.brokenB, 6)));
        this.hitSize = 15;
        this.treadFrames = 10;
        this.health = 850;
        this.treadPullOffset = 1;
        this.rippleScale = 1.2f;
        this.squareShape = true;
        this.omniMovement = false;
        this.rotateMoveFirst = true;
        this.itemCapacity = 0;
        this.outlineColor = Color.valueOf("#212121");
        this.crushDamage = 4;
        this.weapons.add(new Weapon("sc-fenghuo1-weapon") {
          {
            this.mirror = false;
            this.y = 0;
            this.x = 0;
            this.top = true;
            this.reload = 45;
            this.rotateSpeed = 8;
            this.recoil = 0.5f;
            this.shake = 0.5f;
            this.rotate = true;
            this.inaccuracy = 0;
            this.shoot = new ShootBarrel() {
              {
                this.shotDelay = 0f;
                this.shots = 3;
                this.barrels = new float[] { 0f, 0f, 0f, 0f, 0f, 8f, 0f, 0f, -8f };
              }
            };
            this.bullet = new MissileBulletType() {
              {
                this.damage = 30;
                this.shootEffect = Fx.none;
                this.smokeEffect = Fx.none;
                this.splashDamageRadius = 15;
                this.splashDamage = 35;
                this.homingDelay = 30;
                this.width = 3.5f;
                this.height = 9;
                this.speed = 4;
                this.lifetime = 45;
                this.despawnEffect = this.hitEffect = HFx.smalltankhit;
                this.trailLength = 8;
                this.trailWidth = 1.5f;
                this.trailColor = Color.valueOf("99F8FFFF");
                this.trailEffect = new ParticleEffect() {
                  {
                    this.particles = 1;
                    this.region = "circle-shadow";
                    this.length = 0;
                    this.lifetime = 10;
                    this.sizeFrom = 4;
                    this.colorFrom = Color.valueOf("74C2E8FF");
                    this.colorTo = Color.valueOf("99F8FFFF");
                  }
                };
              }
            };
          }
        });
      }
    };
    HUnits.unitbrokena = new MissileUnitType("unitbrokena") {
      {
        this.lifetime = 0.5f;
        this.abilities.add(new DeathItemDrop(ItemStack.with(HItems.brokenA, 10)));
        this.createWreck = false;
        this.createScorch = false;
      }
    };
  }
}
