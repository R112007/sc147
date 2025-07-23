package sc.game;

import sc.type.UnitStack;

/**
 * EventTypes
 */
public class EventTypes {
  public static class LaunchUnitEvent {
    public final UnitStack stack;

    public LaunchUnitEvent(UnitStack stack) {
      this.stack = stack;
    }
  }
}
