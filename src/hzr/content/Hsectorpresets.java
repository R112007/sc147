package hzr.content;

import arc.Core;
import mindustry.type.SectorPreset;

public class Hsectorpresets {
  public static SectorPreset jizhanshifadian1;

  public static void load() {
    Hsectorpresets.jizhanshifadian1 = new SectorPreset("jizhanshifadian", HPlanets.hzr, 1) {
      {
        this.alwaysUnlocked = true;
        this.difficulty = 1;
        this.captureWave = 30;
        this.overrideLaunchDefaults = true;
        this.startWaveTimeMultiplier = 3f;
      }

      @Override
      public void loadIcon() {
        uiIcon = fullIcon = Core.atlas.find(this.name);
      }
    };
  }
}
