package sc.content;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

public class SCLoadouts {

  public static Schematic jichuhexi;
  public static Schematic yijijizhan;

  public static void load() {
    SCLoadouts.jichuhexi = Schematics.readBase64(
        "bXNjaAF4nGNgYmBiZmDJS8xNZeB5On/X84UNzxbseLq/mYE7JbU4uSizoCQzP4+BgYEtJzEpNaeYgSk6lpGBozhZNzm/KNUQKMHIAAEAn40VLQ==");
    SCLoadouts.yijijizhan = Schematics.readBase64(
        "bXNjaAF4nGNgZmBmZmDJS8xNZeB5sqPh+a7lT+fver56JgN3SmpxclFmQUlmfh4DAwNbTmJSak4xA1N0LCMDZ3GybkZyflGqIVCGEYSABADBpxW8");
  }
}
