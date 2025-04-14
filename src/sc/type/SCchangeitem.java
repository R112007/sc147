package sc.type;

import arc.graphics.Color;
import arc.math.Rand;
import arc.util.Time;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.meta.StatUnit;
import sc.content.SCItems;
import sc.world.meta.SCStat;

public class SCchangeitem extends SCItemType {
  /** 增加的数量 */
  public int changenum;
  /** 是否改变 */
  public boolean ischange;
  /** 最少改变时间 */
  public float basechangetime;
  /** 变成的物品 */
  public Item changeitem;
  public Rand rand = new Rand();;
  /** 随机时间增量 */
  public float randtime;
  /** 真正的随机时间 */
  public float changetime;
  float timer = 0f;

  public SCchangeitem(final String name, final Color color) {
    super(name, color);
    this.changenum = 1;
    this.ischange = true;
    this.basechangetime = 1800.0f;
    this.changeitem = SCItems.lv;
    this.randtime = 300.0f;
    this.changetime = basechangetime + rand.random(randtime);
  }

  @Override
  public void setStats() {
    super.setStats();
    this.stats.add(SCStat.basechangetime, this.basechangetime / 60.0f, StatUnit.seconds);
    this.stats.add(SCStat.changetime, (this.basechangetime + this.randtime) / 60.0f, StatUnit.seconds);
  }

  public void update(SCchangeitem si, Building build) {
    timer += Time.delta;
    if (timer >= changetime) {
      build.removeStack(si, 1);
      build.items.add(this.changeitem, changenum);
      this.changetime = basechangetime + rand.random(randtime);
      timer = 0f;
    }
  }
}
