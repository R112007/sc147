package hzr.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import sc.world.SCAttributes;

public class HOre {
  public static Block oreGao;
  public static Block wasteFloor;

  public static void load() {
    HOre.oreGao = new OreBlock("oreGao", HItems.gao) {
      {
        oreDefault = true;
      }
    };
    HOre.wasteFloor = new Floor("wasteFloor") {
      {
        this.speedMultiplier = 1f;
        this.variants = 1;
        this.dragMultiplier = 0f;
        this.damageTaken = 0f;
        this.hasShadow = true;
        this.attributes.set(SCAttributes.waste, 0.25f);
      }
    };
  }
}
