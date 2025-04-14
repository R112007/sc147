package sc.content;

import mindustry.type.SectorPreset;

public class LxMaps {

  public static SectorPreset jianglindian;
  public static SectorPreset baoziliegu;

  public static void load() {
    LxMaps.jianglindian = new SectorPreset("jianglindian", SCPlanets.lx, 1) {
      {
        this.alwaysUnlocked = true;
        this.difficulty = 1;
        this.addStartingItems = true;
        this.captureWave = 25;
        this.overrideLaunchDefaults = true;
        this.noLighting = true;
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
  }
}
