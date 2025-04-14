package sc.world.meta;

import mindustry.world.meta.Stat;
import mindustry.world.meta.StatCat;

public class SCStat {
  public static final Stat armorMultiplier;
  public static final Stat crystalEnergy;
  public static final Stat basechangetime;
  public static final Stat changetime;
  public static final Stat waittime;
  public static final Stat length;
  public static final Stat reducepercent;

  static {
    armorMultiplier = new Stat("armorMultiplier");
    crystalEnergy = new Stat("crystalEnergy");
    basechangetime = new Stat("basechangetime");
    changetime = new Stat("changetime", StatCat.function);
    waittime = new Stat("waittime", StatCat.function);
    length = new Stat("length");
    reducepercent = new Stat("reducepercent", StatCat.function);
  }

}
