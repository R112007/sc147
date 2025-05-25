package hzr.content;

import arc.graphics.Color;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MultiBulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import sc.content.SCFx;
import sc.graphics.SCPal;

public class HBullets {
  public static BulletType ningwang1;
  public static BulletType ningwang2;
  public static MultiBulletType ningwangbullet;

  public static void load() {
    HBullets.ningwang1 = new BasicBulletType(5.0f, 28f) {
      {
        this.splashDamage = 58;
        this.splashDamageRadius = 12f;
        this.width = 7f;
        this.height = 14f;
        this.lifetime = 40;
        this.homingPower = 6f;
        this.trailChance = 0.4f;
        this.trailColor = SCPal.light_blue2;
        this.frontColor = SCPal.blue1;
        this.hitEffect = this.despawnEffect = SCFx.airmisslemiddle;
      }
    };
    HBullets.ningwang2 = new ShrapnelBulletType() {
      {
        this.damage = 48;
        this.length = 138;
        this.reloadMultiplier = 1.5f;
        this.ammoMultiplier = 3;
        this.knockback = 0.8f;
        this.toColor = Color.valueOf("#79C5C5FF");
      }
    };
    HBullets.ningwangbullet = new MultiBulletType(HBullets.ningwang1, HBullets.ningwang2);
  }
}
