package sc.graphics;

import arc.graphics.Color;

public class SCPal {
  public static Color light_blue1;
  public static Color blue1;
  public static Color dark_blue1;
  public static Color light_blue2;
  public static Color blue2;
  public static Color dark_blue2;

  static {
    SCPal.light_blue1 = Color.valueOf("99F8FFFF");
    SCPal.blue1 = Color.valueOf("74C2E8FF");
    SCPal.dark_blue1 = Color.valueOf("5898F0FF");
    SCPal.light_blue2 = Color.valueOf("9CC2F0FF");
    SCPal.blue2 = Color.valueOf("1F84FFFF");
    SCPal.dark_blue2 = Color.valueOf("0A72F2FF");
  }
}
