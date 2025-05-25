package sc.game;

import arc.util.Time;

public class WaitTime {
  public static float timer = 0f;

  public static boolean waittime(float time) {
    timer += Time.delta;
    if (timer >= time) {
      timer = 0f;
      return true;
    } else {
      return false;
    }
  }
}
