package sc.game;

import arc.Core;
import arc.Events;
import arc.math.WindowedMean;
import arc.struct.ObjectMap;
import arc.util.Log;
import mindustry.type.Sector;
import mindustry.type.UnitType;
import sc.game.SCEventType.SaveUnitInfo;
import sc.type.UnitStack;

public class UnitInfo {
  private static final int valueWindow = 60;
  public final Sector sector;
  public final int id;
  public static UnitInfo[] all = new UnitInfo[2000];
  public ObjectMap<UnitType, ExportStat> export = new ObjectMap<>();
  public ObjectMap<UnitType, ExportStat> imports = new ObjectMap<>();
  public static int lastId = loadLastId();

  public UnitInfo(Sector sector) {
    this.sector = sector;
    this.id = lastId;
    all[id] = this;
    lastId++;
    saveLastId();
  }

  public void handUnitsExport(UnitStack stack) {
    handUnitsExport(stack.unit, stack.amount);
  }

  public void handUnitsExport(UnitType unit, int amount) {
    export.get(unit, ExportStat::new).counter += amount;
  }

  public void handUnitsImport(UnitType unit, int amount) {
    imports.get(unit, ExportStat::new).counter += amount;
  }

  public void handUnitsImport(UnitStack stack) {
    handUnitsImport(stack.unit, stack.amount);
  }

  public static boolean equal(Sector sector) {
    return get(sector) != null;
  }

  public static UnitInfo get(Sector targetSector) {
    for (UnitInfo info : all) {
      if (info == null) {
        continue;
      }
      if (info.sector.equals(targetSector)) {
        return info;
      }
    }
    return null;
  }

  private static int loadLastId() {
    return Core.settings.getInt("unitinfo.lastid", 0);
  }

  public static int returnLastId() {
    return Core.settings.getInt("unitinfo.lastid", 0);
  }

  private static void saveLastId() {
    Core.settings.put("unitinfo.lastid", lastId);
    Events.fire(SaveUnitInfo.class);
    Core.settings.manualSave();
  }

  public void saveInfo() {
    Core.settings.putJson(sector.planet.name + "-s-" + id + "-unitinfo", this);
  }

  public static class ExportStat {
    public transient float counter;
    public transient WindowedMean means = new WindowedMean(valueWindow);
    public transient boolean loaded;

    public float mean;

    public String toString() {
      return mean + "";
    }
  }
}
