package sc.content.blocks;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.bullet.MultiBulletType;
import sc.content.SCStatusEffects;
import sc.graphics.SCPal;

public class SCBullets {
  public static BulletType tuxibullet1 = new MissileBulletType(8f, 25, "sc-missle-middle") {
    {
      this.lifetime = 240f / 8f + 5f;
      this.splashDamage = 67;
      this.splashDamageRadius = 16.5f;
      this.height = 11f;
    }
  };
  public static BulletType tuxibullet2 = new MissileBulletType(8f, 12f, "sc-missle-middle") {
    {
      this.lifetime = 240f / 8f + 5f;
      this.splashDamage = 51;
      this.splashDamageRadius = 16.5f;
      this.status = StatusEffects.burning;
      this.frontColor = Color.valueOf("#EC4848FF");
      this.backColor = Color.valueOf("#B91515FF");
      this.height = 11f;
    }
  };
  public static BulletType tuxibullet3 = new MissileBulletType(8f, 20f, "sc-missle-middle") {
    {
      this.lifetime = 240f / 8f + 5f;
      this.splashDamage = 82;
      this.splashDamageRadius = 16.5f;
      this.status = SCStatusEffects.duanlu;
      this.frontColor = SCPal.light_blue1;
      this.height = 11f;
    }
  };
  public static BulletType[] bullets = { tuxibullet1, tuxibullet2, tuxibullet3 };
  public static BulletType tuxibullet4 = new MultiBulletType(3, bullets);
}
