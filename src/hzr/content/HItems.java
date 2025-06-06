package hzr.content;

import arc.graphics.Color;
import mindustry.type.Item;
import sc.type.SCItemType;

public class HItems {
  public static Item gao, brokenA, brokenB,brokenC;

  public static void load() {
    HItems.gao = new SCItemType("gao", Color.valueOf("0A72F2FF")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 1f;
        this.explosiveness = 0.0f;
      }
    };
    HItems.brokenA = new SCItemType("brokenA", Color.valueOf("#989BA4")) {
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
    HItems.brokenB = new SCItemType("brokenB", Color.valueOf("#55585F")) {
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
    HItems.brokenC = new SCItemType("brokenC", Color.valueOf("#55585F")) {
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
