package sc.content;

import arc.util.Log;
import mindustry.content.StatusEffects;
import mindustry.type.StatusEffect;
import sc.graphics.SCPal;
import sc.type.SCStatusType;

public class SCStatusEffects {
  public static StatusEffect duanlu;

  public static void load() {
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
      }
    };
  }

}
