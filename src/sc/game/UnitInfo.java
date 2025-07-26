package sc.game;

import arc.math.WindowedMean;
import arc.struct.ObjectMap;
import mindustry.type.Sector;
import mindustry.type.UnitType;
import sc.type.UnitStack;

public class UnitInfo {
  private static final int valueWindow = 60;
  public final Sector sector;
  public final int id;
  public static final UnitInfo[] all = new UnitInfo[10000];
  public ObjectMap<UnitType, ExportStat> export = new ObjectMap<>();
  public ObjectMap<UnitType, ExportStat> imports = new ObjectMap<>();
  public static int lastedid;

  public UnitInfo(int id, Sector sector) {
    this.sector = sector;
    this.id = id;
    all[id] = this;
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
