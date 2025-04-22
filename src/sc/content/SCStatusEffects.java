package sc.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Log;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.ParticleEffect;
import mindustry.type.StatusEffect;
import sc.graphics.SCPal;
import sc.type.SCStatusType;

public class SCStatusEffects {
  public static StatusEffect duanlu;

  public static void load() {
    StatusEffects.boss.damageMultiplier = 1.8f;
    StatusEffects.boss.healthMultiplier = 2.5f;
    StatusEffects.boss.reloadMultiplier = 1.35f;
    StatusEffects.boss.damage = -2.5f;
    SCStatusEffects.duanlu = new StatusEffect("duanlu") {
      {
        this.color = SCPal.blue1;
        this.show = true;
        this.speedMultiplier = 0.8f;
        this.reloadMultiplier = 0.8f;
        this.damageMultiplier = 0.8f;
        this.damage = 0.5f;
        this.permanent = false;
        this.transitionDamage = 80f;
        this.reactive = false;
        this.disarm = false;
        this.effect = new ParticleEffect() {
          {
            this.region = "sc-particle1";
            this.particles = 7;
            this.lifetime = 15;
            this.length = 10;
            this.sizeFrom = 2;
            this.sizeTo = 0;
            this.colorFrom = Color.valueOf("#15f138");
            this.colorTo = Color.valueOf("#3ff115");
          }
        };
        init(() -> {
          affinity(StatusEffects.wet, (unit, result, time) -> {
            unit.damagePierce(transitionDamage);
            effect.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
            result.set(duanlu, Math.min(time + result.time, 200f));
          });
        });

      }
    };
  }

}
