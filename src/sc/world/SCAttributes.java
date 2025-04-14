package sc.world;

import mindustry.world.meta.Attribute;

public class SCAttributes {
  public static Attribute underpower;

  public static void load() {

    SCAttributes.underpower = Attribute.add("underpower");
  }

}
