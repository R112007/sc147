package sc.type.weapons;

import arc.scene.ui.layout.Table;
import arc.struct.ObjectMap;
import arc.util.Strings;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MultiBulletType;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.StatValues;

public class MultiWeapon extends Weapon {
  public MultiBulletType bullets;
  int i = 1;

  public MultiWeapon(MultiBulletType bullets) {
    super();
    this.bullets = bullets;
  }

  public MultiWeapon(String name, MultiBulletType bullets) {
    super(name);
    this.bullets = bullets;
  }

  @Override
  public void addStats(UnitType u, Table t) {
    if (inaccuracy > 0) {
      t.row();
      t.add("[lightgray]" + Stat.inaccuracy.localized() + ": [white]" + (int) inaccuracy + " "
          + StatUnit.degrees.localized());
    }
    if (!alwaysContinuous && reload > 0 && !bullet.killShooter) {
      t.row();
      t.add("[lightgray]" + Stat.reload.localized() + ": " + (mirror ? "2x " : "") + "[white]"
          + Strings.autoFixed(60f / reload * shoot.shots, 2) + " " + StatUnit.perSecond.localized());
    }
    for (BulletType b : bullets.bullets) {
      t.row();
      t.add("子弹" + i + ":");
      t.row();
      StatValues.ammo(ObjectMap.of(u, b)).display(t);
      t.row();
      i++;
    }
  }
}
