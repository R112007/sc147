package sc.type;

import mindustry.Vars;
import mindustry.type.UnitType;

public class SCUnitType {
  public static class SCUnitType1 extends UnitType {
    public SCUnitType1(String name, String Name) {
      super(name);
      this.controller = Vars.content.unit(Name).controller;
      this.constructor = Vars.content.unit(Name).constructor;
    }
  }
}
