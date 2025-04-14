package sc.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class SCLiquids {
  public static Liquid nengliangliuti;
  public static Liquid nongsuonengliangliuti;

  public static void load() {
    SCLiquids.nengliangliuti = new Liquid("nengliangliuti", Color.valueOf("#ffff00")) {
      {
        this.barColor = Color.valueOf("#ffff99");
        this.lightColor = Color.valueOf("#ffff33");
        this.incinerable = false;
        this.flammability = 0.0f;
        this.temperature = 0.21f;
        this.heatCapacity = 1.0f;
        this.viscosity = 0.0f;
        this.explosiveness = 0.5f;
        this.effect = StatusEffects.overdrive;

      }
    };
    SCLiquids.nongsuonengliangliuti = new Liquid("nongsuonengliangliuti", Color.valueOf("#ffce00")) {
      {
        this.barColor = Color.valueOf("#bf9a00");
        this.lightColor = Color.valueOf("#ffe67c");
        this.incinerable = false;
        this.flammability = 0.0f;
        this.temperature = 0.12f;
        this.heatCapacity = 3.0f;
        this.viscosity = 0.8f;
        this.explosiveness = 0.0f;
        this.effect = StatusEffects.overdrive;
      }
    };
  }
}
