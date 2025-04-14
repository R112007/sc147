package sc.content;

import static arc.math.Angles.*;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.Colors;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.math.Rand;
import arc.util.Nullable;
import mindustry.entities.Effect;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.world.Block;
import sc.graphics.SCPal;

public class SCFx {
  public static final Rand rand = new Rand();
  public static Effect smoke4sides;
  public static Effect casingbig;
  public static Effect airmisslesmall;
  public static Effect airmisslemiddle;
  public static Effect airpiercedown;
  public static Effect pointdown;
  public static Effect bomb1;
  static {
    SCFx.smoke4sides = new Effect(30.0f, e -> {
      // @Nullable TextureRegion tex = Core.atlas.find("circle");
      Draw.color(SCPal.blue1, SCPal.light_blue1, SCPal.dark_blue1, e.fin());
      float tempx = rand.random(4f, 100.0f);
      float tempy = rand.random(4f, 100.0f);
      int tempi = rand.random(3, 6);
      float tempsize = rand.random(0f, 7.0f);
      Lines.circle(rand.chance(0.5) ? e.x + tempx : rand.chance(0.5) ? e.x * tempx : e.x / tempx,
          rand.chance(0.5) ? e.y + tempy : e.y - tempy, -tempsize);
      e.fout(0.8f);
      /*
       * for (int i = 0; i < tempi; i++) {
       * float tempx1 = rand.random(0.8f, 40.0f);
       * float tempy1 = rand.random(0.8f, 40.0f);
       * 
       * Draw.color(SCPal.blue1, SCPal.light_blue1, e.fin());
       * Lines.circle(e.x + tempx1, e.y + tempy1, tempsize);
       * e.fout(0.3f);
       * e.lifetime = 30.0f;
       * }
       */
    });
    casingbig = new Effect(30f, e -> {
      Draw.color(SCPal.blue1, Color.lightGray, Pal.lightishGray, e.fin());
      Draw.alpha(e.fout(0.3f));
      float rot = Math.abs(e.rotation) + 90f;
      int i = -Mathf.sign(e.rotation);

      float len = (2f + e.finpow() * 6f) * i;
      float lr = rot + e.fin() * 30f * i;
      Fill.rect(
          e.x + trnsx(lr, len) + Mathf.randomSeedRange(e.id + i + 7, 3f * e.fin()),
          e.y + trnsy(lr, len) + Mathf.randomSeedRange(e.id + i + 8, 3f * e.fin()),
          5f, 12f, rot + e.fin() * 50f * i);

    }).layer(Layer.bullet);
    airmisslesmall = new ExplosionEffect() {
      {
        this.waveColor = SCPal.light_blue1;
        this.sparkColor = SCPal.blue1;
      }
    }.layer(Layer.bullet);
    airmisslemiddle = new MultiEffect(airmisslesmall, new ParticleEffect() {
      {
        this.particles = 5;
        this.lifetime = 20;
        this.length = 20;
        this.baseLength = -20;
        this.sizeFrom = 5;
        this.sizeTo = 0;
        this.colorFrom = SCPal.light_blue1;
        this.colorTo = Color.white;
      }
    });
    airpiercedown = new MultiEffect(airmisslemiddle, new WaveEffect() {
      {
        this.sizeFrom = 0;
        this.sizeTo = 20;
        this.lifetime = 30;
        this.sides = 1;
        this.colorFrom = SCPal.light_blue1;
        this.colorTo = SCPal.blue1;
        this.strokeFrom = 2.5f;
        this.strokeTo = 0;
      }
    });
    pointdown = new MultiEffect(new ParticleEffect() {
      {
        this.particles = 1;
        this.lifetime = 11;
        this.length = 0;
        this.baseLength = 0;
        this.sizeFrom = 5;
        this.sizeTo = 0;
        this.colorFrom = SCPal.light_blue1;
        this.colorTo = Color.white;
        this.cone = 360f;
      }
    },
        new ParticleEffect() {
          {
            this.particles = 22;
            this.lifetime = 11;
            this.length = 33;
            this.baseLength = 2;
            this.strokeFrom = 2;
            this.strokeTo = 0;
            this.colorFrom = SCPal.light_blue1;
            this.colorTo = Color.white;
            this.cone = 360f;
            this.lenTo = 0f;
            this.lenFrom = 18f;
            this.line = true;
          }
        });
    bomb1 = new MultiEffect(new ParticleEffect() {
      {
        this.particles = 18;
        this.sizeFrom = 6;
        this.sizeTo = 0;
        this.length = 45;
        this.baseLength = 3;
        this.lifetime = 35;
        this.colorFrom = Color.valueOf("737373FF");
        this.colorTo = Color.valueOf("737373FF");
        this.cone = 360;
      }
    },
        new ParticleEffect() {
          {
            this.particles = 32;
            this.line = true;
            this.sizeFrom = 9;
            this.sizeTo = 0;
            this.length = 53;
            this.baseLength = 20;
            this.lifetime = 22;
            this.colorFrom = Color.valueOf("#FFFFFF");
            this.colorTo = Color.valueOf("#FFE176FF");
            this.cone = 360;
          }
        },
        new WaveEffect() {
          {
            this.lifetime = 15;
            this.sizeFrom = 0;
            this.sizeTo = 70;
            this.strokeFrom = 4;
            this.strokeTo = 0;
            this.colorFrom = Color.valueOf("FFE176FF");
            this.colorTo = Color.valueOf("ffffff");
          }
        });
  }
}
