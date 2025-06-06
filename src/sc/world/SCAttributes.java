package sc.world;

import mindustry.world.meta.Attribute;

public class SCAttributes {
  public static Attribute underpower;
  public static Attribute waste;

  public static void load() {

    SCAttributes.underpower = Attribute.add("underpower");
    SCAttributes.waste = Attribute.add("waste");
  }

}
