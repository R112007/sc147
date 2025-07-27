package sc.game;

import sc.type.UnitStack;

public class SCEventType {
  public static class SaveUnitInfo {
  }

  public static class LaunchUnitEvent {
    public final UnitStack stack;

    public LaunchUnitEvent(UnitStack stack) {
      this.stack = stack;
    }
  }
}
