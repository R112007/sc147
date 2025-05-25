package sc.type;

import arc.Core;
import arc.func.Cons;
import arc.util.Nullable;
import mindustry.ctype.ContentType;
import mindustry.game.Rules;
import mindustry.gen.Icon;
import mindustry.maps.generators.FileMapGenerator;
import mindustry.mod.Mods.LoadedMod;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.type.SectorPreset;

public class SCSectorPreset extends SectorPreset {

  public FileMapGenerator generator;
  public Planet planet;
  public Sector sector;

  public int captureWave = 0;
  public Cons<Rules> rules = rules -> rules.winWave = captureWave;

  public float difficulty;
  public float startWaveTimeMultiplier = 2f;
  public boolean addStartingItems = false;
  public boolean noLighting = false;

  public boolean isLastSector;
  public boolean requireUnlock = true;
  public boolean showSectorLandInfo = true;
  public boolean overrideLaunchDefaults = false;
  public boolean allowLaunchSchematics = false;
  public boolean allowLaunchLoadout = false;
  public boolean attackAfterWaves = false;

  public SCSectorPreset(String name, Planet planet, int sector) {
    this(name, null, planet, sector);
  }

  public SCSectorPreset(String name, String fileName, Planet planet, int sector) {
    this(name, fileName, null);
    initialize(planet, sector);
  }

  public SCSectorPreset(String name, LoadedMod mod) {
    this(name, null, mod);
  }

  public SCSectorPreset(String name, @Nullable String fileName, LoadedMod mod) {
    super(name);
    if (mod != null) {
      this.minfo.mod = mod;
    }
    this.generator = new FileMapGenerator(fileName == null ? this.name : fileName, this);
  }

  public void initialize(Planet planet, int sector) {
    this.planet = planet;
    sector %= planet.sectors.size;
    this.sector = planet.sectors.get(sector);

    planet.preset(sector, this);
  }

  @Override
  public void loadIcon() {
    uiIcon = fullIcon = Core.atlas.find(this.name);
  }

  @Override
  public boolean isHidden() {
    return description == null;
  }

  @Override
  public ContentType getContentType() {
    return ContentType.sector;
  }

}
