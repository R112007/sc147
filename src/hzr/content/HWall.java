package hzr.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import sc.world.blocks.denfence.HealWall;

public class HWall {
  public static Block gaowall1, gaowall2;

  public static void load() {
    HWall.gaowall1 = new HealWall("gaowall1") {
      {
        this.health = 1000;
        this.buildCostMultiplier = 0.5f;
        this.size = 1;
        this.armor = 3;
        this.healpercent = 0.67f;
        this.requirements(Category.defense, ItemStack.with(new Object[] { HItems.gao, 12 }));
      }
    };
    HWall.gaowall2 = new HealWall("gaowall2") {
      {
        this.health = 1000 * 3;
        this.buildCostMultiplier = 0.5f;
        this.size = 2;
        this.armor = 3;
        this.healpercent = 0.67f;
        this.requirements(Category.defense, ItemStack.with(new Object[] { HItems.gao, 12 * 3 }));
      }
    };
  }
}
