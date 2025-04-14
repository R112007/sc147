
package sc.entities.abilities;

import arc.Core;
import arc.math.Mathf;
import arc.math.Rand;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.entities.Effect;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import sc.world.meta.SCStat;

public class FlashAbility extends Ability {
  public float length;
  public float waittime;
  public static final Rand rand = new Rand();
  public Effect downEffect;
  protected float timer = 0;
  public float randtime;
  public float randlength;
  public boolean cycletowards;
  public boolean isShooting;
  public float randtimer;

  public FlashAbility(float length, float waittime, Effect downEffect, float randtime, float randlength,
      boolean cycletowards, boolean isShooting) {
    this.waittime = waittime;
    this.length = length;
    this.downEffect = downEffect;
    this.randtime = randtime;
    this.randlength = randlength;
    this.cycletowards = cycletowards;
    this.randtimer = rand.random(randtime);
    this.isShooting = isShooting;
  }

  public FlashAbility(float length, float waittime, Effect downEffect, float randtime, float randlength) {
    this.waittime = waittime;
    this.length = length;
    this.downEffect = downEffect;
    this.randtime = randtime;
    this.randlength = randlength;
    this.cycletowards = false;
    this.randtimer = rand.random(randtime);
    this.isShooting = true;
  }

  public boolean isShoot(Unit unit) {
    if (this.isShooting == true) {
      return unit.isShooting();
    } else {
      return true;
    }
  }

  @Override
  public void update(Unit unit) {
    // Log.info("randtimer是" + randtimer);
    timer += Time.delta;
    if (cycletowards) {
      if (timer >= waittime + randtimer && isShoot(unit)) {

        // Log.info("start");
        // Log.info("本次闪现间隔为" + timer / 60);
        /**
         * Log.info("角度" + unit.rotation);
         * Log.info("正弦" + Mathf.sin(unit.rotation * Mathf.degreesToRadians));
         * Log.info("余弦" + Mathf.cos(unit.rotation * Mathf.degreesToRadians));
         * Log.info("start");
         */
        // double angle = Mathf.(unit.rotation);
        // Log.info("闪现前单位x为" + unit.x);
        // float tempx1 = unit.x;
        // Log.info("闪现前单位y为" + unit.y);
        // float tempy1 = unit.y;
        unit.move(Mathf.cos(unit.rotation() * Mathf.degreesToRadians) * length + rand.random(randlength),
            Mathf.sin(unit.rotation() * Mathf.degreesToRadians) * length + rand.random(randlength));
        /**
         * Log.info("闪现后单位x为" + unit.x);
         * float tempx2 = unit.x;
         * Log.info("闪现后单位y为" + unit.y);
         * float tempy2 = unit.y;
         * float s = Mathf.sqrt(Mathf.pow((tempx1 - tempx2), 2) + Mathf.pow((tempy1 -
         * tempy2), 2)) / 8;
         * Log.info("本次闪现距离为" + s);
         * 
         * Log.info("end");
         */
        downEffect.at(unit.x(), unit.y());
        this.randtimer = rand.random(randtime);
        timer = 0f;

      }
    } else {
      if (timer >= waittime + randtimer && isShoot(unit)) {
        // Log.info(timer);
        int randx = (int) this.randlength;
        int randy = (int) this.randlength;
        unit.move(rand.random(-randx, randx) + (rand.chance(0.5f) ? length : -length),
            rand.random(0f, randy) + (rand.chance(0.5f) ? -length : length));
        downEffect.at(unit.x(), unit.y());
        this.randtimer = rand.random(randtime);
        timer = 0f;
      }
    }
  }

  @Override
  public String localized() {
    if (cycletowards) {
      return Core.bundle.get("ability.Flash1");
    } else {
      return Core.bundle.get("ability.Flash2");
    }
  }

  @Override
  public void addStats(Table t) {
    t.add(SCStat.waittime.localized() + waittime / 60f + "~" + (waittime + randtime) / 60 + "秒");
    t.row();
    if (cycletowards) {
      t.add(SCStat.length.localized() + (length / 8f) + "~" + ((length + randlength) / 8f) + "格");
      t.row();
    } else {
      t.add("x方向随机闪现距离" + "-" + (length + randlength) / 8f + "~" + (length + randlength) / 8f);
      t.row();
      t.add("y方向随机闪现距离" + "-" + (length + randlength) / 8f + "~" + (length + randlength) / 8f);
      t.row();
      if (this.isShooting == true) {
        t.add(Core.bundle.get("flash.isShoot"));
      }
    }
  }
}
