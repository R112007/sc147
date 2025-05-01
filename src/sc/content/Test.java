package sc.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import sc.world.blocks.crystal.CrystalBlock;
import sc.world.blocks.denfence.HealWall;

public class Test {
  public static Block test;
  public static Block test1;

  public static void load() {
    Test.test = new CrystalBlock("test") {
      {
        this.health = 130;
        this.size = 2;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = false;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    test1 = new HealWall("g") {
      {
        lightningChance = 1;
        this.health = 1000;
        this.size = 2;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
  }
}
