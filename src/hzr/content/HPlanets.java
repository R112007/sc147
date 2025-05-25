package hzr.content;

import arc.graphics.Color;
import hzr.generator.HzrPlanetGenerator;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.Planet;
import sc.content.SCPlanets;
import sc.graphics.SCPal;

public class HPlanets {
  public static Planet hzr;

  public static void load() {
    HPlanets.hzr = new Planet("hzr", SCPlanets.scsun, 2f, 3) {
      {
        this.generator = new HzrPlanetGenerator();
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
