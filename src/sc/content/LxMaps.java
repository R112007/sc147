package sc.content;

import arc.Core;
import mindustry.gen.Icon;
import mindustry.type.SectorPreset;

public class LxMaps {
  public static SectorPreset jianglindian;
  public static SectorPreset baoziliegu;
  public static SectorPreset jiaocuolianfeng;
  public static SectorPreset xiji;

  public static void load() {
    LxMaps.jianglindian = new SectorPreset("jianglindian", SCPlanets.lx, 1) {
      {
        this.alwaysUnlocked = true;
        this.difficulty = 1;
        this.captureWave = 25;
        this.overrideLaunchDefaults = true;
        this.startWaveTimeMultiplier = 3f;
      }

      @Override
      public void loadIcon() {
        if (Core.atlas.find(this.name) != null) {
          uiIcon = fullIcon = Core.atlas.find(this.name);
        } else {
          uiIcon = fullIcon = Icon.terrain.getRegion();
        }
      }
    };
    LxMaps.baoziliegu = new SectorPreset("baoziliegu", SCPlanets.lx, 2) {
      {
        this.alwaysUnlocked = false;
        this.difficulty = 1;
        this.captureWave = 30;
      }

      @Override
      public void loadIcon() {
        if (Core.atlas.find(this.name) != null) {
          uiIcon = fullIcon = Core.atlas.find(this.name);
        } else {
          uiIcon = fullIcon = Icon.terrain.getRegion();
        }
      }

    };
    LxMaps.jiaocuolianfeng = new SectorPreset("jiaocuolianfeng", SCPlanets.lx, 3) {
      {
        this.alwaysUnlocked = false;
        this.difficulty = 2;
        this.captureWave = 40;
      }

      @Override
      public void loadIcon() {
        if (Core.atlas.find(this.name) != null) {
          uiIcon = fullIcon = Core.atlas.find(this.name);
        } else {
          uiIcon = fullIcon = Icon.terrain.getRegion();
        }
      }
    };
    LxMaps.xiji = new SectorPreset("xiji", SCPlanets.lx, 0) {
      {
        this.alwaysUnlocked = false;
        this.difficulty = 2;
        this.captureWave = 50;
      }

      @Override
      public void loadIcon() {
        if (Core.atlas.find(this.name) != null) {
          uiIcon = fullIcon = Core.atlas.find(this.name);
        } else {
          uiIcon = fullIcon = Core.atlas.find("terrain");
        }
      }
    };
  }
}
