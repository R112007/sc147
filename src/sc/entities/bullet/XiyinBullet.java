package sc.entities.bullet;

import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Bullet;

public class XiyinBullet extends BasicBulletType {
  public float range;
  public float power;
  public float staytime;

  public XiyinBullet(float speed, float damage, String sprite) {
    super(speed, damage);
    this.sprite = sprite;
  }

  public XiyinBullet(float speed, float damage) {
    this(speed, damage, "bullet");
  }

  public XiyinBullet() {
    this(1f, 1f, "bullet");
  }

  @Override
  public void update(Bullet b) {
    super.update(b);

  }
}
