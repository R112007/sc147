package hzr.content;

import static mindustry.content.TechTree.*;

public class HTechTree {
  public static void load() {
    HPlanets.hzr.techTree = nodeRoot("hzr", HStorage.hcore1, () -> {
      nodeProduce(HItems.gao, () -> {
      });
    });
  }
}
