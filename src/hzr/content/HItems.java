package hzr.content;

import arc.graphics.Color;
import mindustry.type.Item;
import sc.type.SCItemType;

public class HItems {
  public static Item gao;

  public static void load() {
    HItems.gao = new SCItemType("gao", Color.valueOf("0A72F2FF")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.5f;
        this.explosiveness = 0.0f;
      }
    };
  }
}
