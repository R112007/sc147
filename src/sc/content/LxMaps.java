package sc.content;

import mindustry.type.SectorPreset;

public class LxMaps {

  public static SectorPreset jianglindian;
  public static SectorPreset baoziliegu;
  public static SectorPreset jiaocuolianfeng;

  public static void load() {
    LxMaps.jianglindian = new SectorPreset("jianglindian", SCPlanets.lx, 1) {
      {
        this.alwaysUnlocked = true;
        this.difficulty = 1;
        this.captureWave = 25;
        this.overrideLaunchDefaults = true;
        this.startWaveTimeMultiplier = 3f;
      }
    };
    LxMaps.baoziliegu = new SectorPreset("baoziliegu", SCPlanets.lx, 2) {
      {
        this.alwaysUnlocked = false;
        this.difficulty = 1;
        this.captureWave = 30;
      }
    };
    LxMaps.jiaocuolianfeng = new SectorPreset("jiaocuolianfeng", SCPlanets.lx, 3) {
      {
        this.alwaysUnlocked = false;
        this.difficulty = 2;
        this.captureWave = 40;
      }
    };
  }
}
