package sc.type;

import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import sc.world.meta.SCStat;
import arc.struct.Seq;
import mindustry.gen.*;

public class SCStatusType extends StatusEffect {
  /** buff装武器，妙不妙 */
  public Seq<Weapon> weapons = new Seq<>();
  /** 装甲倍率 */
  public float armorMultiplier;

  public SCStatusType(String name) {
    super(name);
    this.armorMultiplier = 1;
  }

  @Override
  public void init() {
    super.init();
  }

  @Override
  public void setStats() {
    super.setStats();
    if (armorMultiplier != 1)
      stats.addPercent(SCStat.armorMultiplier, armorMultiplier);
  }

  public void update(UnitType unitType) {
    unitType.armor *= armorMultiplier;
  }
}
