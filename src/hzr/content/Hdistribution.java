package hzr.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.StackConveyor;

public class Hdistribution {
  public static Block gaoconveyor, gaobridge;

  public static void load() {

    Hdistribution.gaoconveyor = new StackConveyor("gao-conveyor") {
      {
        this.speed = 0.04f;
        this.itemCapacity = 8;
        this.health = 45;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { HItems.gao, 2 }));
      }
    };
    Hdistribution.gaobridge = new ItemBridge("gaobridge") {
      {
        this.size = 1;
        this.health = 80;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 4, HItems.brokenA, 1 }));
        this.armor = 2f;
        this.transportTime = 5f;
        this.itemCapacity = 15;
        this.range = 5;
        this.arrowSpacing = 6f;
        this.hasPower = false;
      }
    };
  }
}
