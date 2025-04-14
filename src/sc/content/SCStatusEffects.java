package sc.content;

import arc.util.Log;
import mindustry.type.StatusEffect;
import sc.graphics.SCPal;
import sc.type.SCStatusType;

public class SCStatusEffects {
  public static StatusEffect a;

  public static void load() {
    SCStatusEffects.a = new SCStatusType("a") {
      {
        this.color = SCPal.blue1;
        this.armorMultiplier = 50.0f;
        this.show = true;
        this.speedMultiplier = 1.2f;
      }
    };
  }

}
