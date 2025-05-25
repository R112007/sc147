package sc.entities.abilities;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.scene.ui.layout.Table;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import sc.game.WaitTime;

public class ContinueRepairField extends Ability {
  public float amount;
  public float range;
  public boolean repairUnit;
  public boolean repairBuild;

  public Effect healEffect = Fx.heal, hitEffect = Fx.hitLaserBlast;
  public Color color = Pal.heal;
  public Effect activeEffect;

  ContinueRepairField() {
  }

  public ContinueRepairField(float amount, float range, boolean repairUnit, boolean repairBuild) {
    this.amount = amount;
    this.range = range;
    this.repairUnit = repairUnit;
    this.repairBuild = repairBuild;
    this.activeEffect = new Effect(4f, e -> {
      e.color = Pal.heal;
      Draw.color(e.color, 0.7f);
      Lines.stroke(e.fout() * 2f);
      Lines.circle(e.x, e.y, 4f + this.range);
    });
  }

  @Override
  public void addStats(Table t) {
    super.addStats(t);
    t.add(Core.bundle.format("bullet.range", Strings.autoFixed(range / Vars.tilesize, 2)));
    t.row();
    t.add("每秒修复量" + " ∶" + amount * 60f);
    t.row();
    t.add("是否修理单位" + " ∶" + repairUnit);
    t.row();
    t.add("是否修理建筑" + " ∶" + repairBuild);
    t.row();
  }

  @Override
  public void update(Unit unit) {
    boolean t = WaitTime.waittime(60f);
    if (repairUnit == true) {
      Units.nearby(unit.team, unit.x, unit.y, range, other -> {
        if (other.damaged()) {
          activeEffect.at(unit.x, unit.y);
          if (t) {
            this.healEffect.at(other, false);
            hitEffect.at(other.x(), other.y(), unit.angleTo(other), color);
          }
        }
        other.heal(amount);
      });
    }
    if (repairBuild == true) {
      Vars.indexer.eachBlock(unit, range, b -> b.damaged() && !b.isHealSuppressed(), other -> {
        other.heal(amount);
        activeEffect.at(unit.x, unit.y);
        if (t) {
          this.healEffect.at(other, false);
          hitEffect.at(other.x(), other.y(), unit.angleTo(other), color);
        }
      });

    }
  }

  @Override
  public String localized() {
    return Core.bundle.get("ability.continuerepairfield");
  }
}
