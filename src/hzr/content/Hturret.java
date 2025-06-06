package hzr.content;

import mindustry.entities.bullet.MissileBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.BlockGroup;
import sc.content.SCFx;
import sc.graphics.SCPal;

public class Hturret {
  public static Block jianglin;

  public static void load() {
    Hturret.jianglin = new ItemTurret("jianglin") {
      {
        this.health = 300;
        this.size = 2;
        this.reload = 30;
        this.range = 180;
        this.inaccuracy = 0;
        this.recoil = 1;
        this.rotateSpeed = 5;
        this.maxAmmo = 25;
        this.ammo(
            HItems.gao, new MissileBulletType(4f, 24f) {
              {
                this.splashDamage = 58;
                this.splashDamageRadius = 12f;
                // this.status = StatusEffects.blasted;
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
            });
        this.requirements(Category.turret, ItemStack.with(new Object[] { HItems.gao, 60 }));
        this.group = BlockGroup.turrets;
      }
    };
  }
}
