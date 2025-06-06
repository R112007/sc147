package hzr.content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;

public class HFx {
  public static Effect smallmechhit, smalltankhit;

  static {
    smallmechhit = new MultiEffect(new ParticleEffect() {
      {
        this.particles = 3;
        this.sizeFrom = 6;
        this.sizeTo = 0;
        this.length = 0;
        this.baseLength = 0;
        this.lifetime = 15;
        this.colorFrom = Color.valueOf("99F8FFFF");
        this.colorTo = Color.valueOf("99F8FFFF");
        this.cone = 360;
      }
    },
        new WaveEffect() {
          {
            this.sizeFrom = 10;
            this.sizeTo = 0;
            this.colorFrom = Color.valueOf("99F8FFFF");
            this.colorTo = Color.valueOf("99F8FFFF");
            this.lifetime = 30;
            this.sides = 3;
            this.strokeFrom = 1;
            this.strokeTo = 0;
          }
        });
    smalltankhit = new MultiEffect(new WaveEffect() {
      {
        this.lifetime = 25;
        this.sizeFrom = 0;
        this.sizeTo = 20;
        this.strokeFrom = 3.5f;
        this.strokeTo = 0;
        this.colorFrom = Color.valueOf("74C2E8FF");
        this.colorTo = Color.valueOf("99F8FFFF");
      }
    },
        new ParticleEffect() {
          {
            this.particles = 9;
            this.length = 40;
            this.lifetime = 48;
            this.interp = Interp.circleOut;
            this.sizeInterp = Interp.pow5Out;
            this.cone = 360;
            this.colorFrom = Color.valueOf("74C2E8FF");
            this.colorTo = Color.valueOf("99F8FFFF");
            this.sizeFrom = 4.5f;
            this.sizeTo = 0;
          }
        });
  }
}
