package sc.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.type.Planet;
import sc.content.blocks.SCBlocksEffects;
import sc.graphics.SCPal;
import sc.map.planet.LxPlanetGenerator;
import sc.type.SCPlanet;

public class SCPlanets {

  public static Planet lx;
  public static Planet scsun;

  public static void load() {
    scsun = new SCPlanet("scsun", null, 9.5f) {
      {
        this.bloom = true;
        this.accessible = false;

        this.meshLoader = () -> new SunMesh(
            this, 4,
            5, 0.3, 1.7, 1.2, 1,
            1.1f,
            Color.valueOf("#CB5DA8"),
            Color.valueOf("#DAB9E8"),
            Color.valueOf("#EAC3EF"),
            Color.valueOf("#DB5FB5"),
            Color.valueOf("#634E87"),
            Color.valueOf("#D489C4"));
      }
    };
    SCPlanets.lx = new Planet("lx", SCPlanets.scsun, 1.8f, 3) {
      {
        this.generator = new LxPlanetGenerator();
        this.meshLoader = () -> new HexMesh(this, 6);
        this.cloudMeshLoader = () -> new MultiMesh(
            new HexSkyMesh(this, 11, 0.15f, 0.13f, 5,
                new arc.graphics.Color().set(SCPal.light_blue1).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
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
        // this.description = " 这是一个富饶的星球，丰富的矿藏也招惹了一些敌人……攻下这里，发展科技，开启合晶之旅吧！";
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
        this.iconColor = SCPal.light_blue1;
        this.rotateTime = 300;
        this.defaultCore = SCBlocksEffects.core1;
      }
    };
  }
}
