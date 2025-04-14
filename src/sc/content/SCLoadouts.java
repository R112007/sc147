package sc.content;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

public class SCLoadouts {

  public static Schematic jichuhexi;

  public static void load() {
    SCLoadouts.jichuhexi = Schematics.readBase64(
        "bXNjaAF4nGNgYmBiZmDJS8xNZeB5On/X84UNzxbseLq/mYE7JbU4uSizoCQzP4+BgYEtJzEpNaeYgSk6lpGBozhZNzm/KNUQKMHIAAEAn40VLQ==");
  }

}
