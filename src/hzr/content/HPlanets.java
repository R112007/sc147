package hzr.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import arc.util.noise.Simplex;
import hzr.generator.HzrPlanetGenerator;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;
import sc.content.SCPlanets;
import sc.graphics.SCPal;

public class HPlanets {
  public static Planet hzr;

  public static void load() {
    HPlanets.hzr = new Planet("hzr", SCPlanets.scsun, 2f, 3) {
      {
        this.generator = new SerpuloPlanetGenerator() {
          public Color c1 = Color.valueOf("#895841FF");
          public Color c2 = Color.valueOf("#623C35FF");
          public Color c3 = Color.valueOf("#4D95A3FF");
          public Color c4 = Color.valueOf("#57ABA2FF");
          public Color c5 = Color.valueOf("#72AF3EFF");
          public Color c6 = Color.valueOf("#679C39FF");
          public Color c7 = Color.valueOf("#88CB4EFF");
          public Color c8 = Color.valueOf("#82CD7EFF");
          public Color c9 = Color.valueOf("#FFFEF9BF");
          public Color c10 = Color.valueOf("#919191FF");
          public Color[] arr = { c1, c2, c3, c4, c5, c6, c7, c8 };
          public Vec3 vec;

          @Override
          public boolean allowLanding(Sector sector) {
            return false;
          }

          @Override
          public Color getColor(Vec3 position) {
            this.vec = new Vec3(noise1(1, 16, 0.2, 8 / 3), noise1(6, 72, 0.8, 9 / 2), noise1(3, 2, 0.4, 3 / 2));
            int amo = Mathf.round(Mathf.clamp(this.vec.x * this.arr.length, 0, this.arr.length - 1));
            return Tmp.c1.set(this.arr[amo]);
          }

          public float noise1(double amount, double a, double b, double c) {
            return Simplex.noise3d((int) (this.seed + amount), a, b, c, (double) position.x, (double) position.y,
                (double) position.z);
          }
        };
        this.meshLoader = () -> new HexMesh(this, 6);
        this.cloudMeshLoader = () -> new MultiMesh(
            new HexSkyMesh(this, 11, 0.15f, 0.13f, 5,
                new arc.graphics.Color().set(SCPal.dark_blue2).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
            new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, arc.graphics.Color.white.cpy().lerp(SCPal.blue1, 0.55f).a(0.75f), 2,
                0.45f, 1f, 0.41f));
        this.atmosphereColor = arc.graphics.Color.valueOf("2d787d");
        this.landCloudColor = arc.graphics.Color.valueOf("2d787d");
        this.atmosphereRadIn = 0.005f;
        this.atmosphereRadOut = 0.05f;
        this.lightSrcTo = 0.7f;
        this.lightDstFrom = 0.2f;
        // this.localizedName = "this";
        this.visible = true;
        this.bloom = false;
        this.updateLighting = true;
        this.accessible = true;
        this.allowWaves = true;
        this.launchCapacityMultiplier = 0.8f;
        this.allowLaunchSchematics = true;// 开启发射核心蓝图
        this.allowSectorInvasion = false;// 模拟攻击图入侵
        this.allowWaveSimulation = true;// 模拟后台波次
        this.alwaysUnlocked = true;
        this.clearSectorOnLose = false;
        this.allowLaunchLoadout = true;
        this.startSector = 1;
        this.orbitRadius = 35;
        this.ruleSetter = r -> {
          r.waveTeam = Team.crux;
          r.placeRangeCheck = false;
          r.showSpawns = false;
        };

        this.tidalLock = false;
        this.iconColor = Color.valueOf("#79C5C5FF");
        this.rotateTime = 300;
        this.defaultCore = HStorage.hcore1;

      }
    };
  }
}
