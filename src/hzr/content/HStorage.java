package hzr.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

public class HStorage {
  public static Block hcore1;

  public static void load() {
    HStorage.hcore1 = new CoreBlock("hcore1") {
      {
        this.health = 4000;
        this.itemCapacity = 6000;
        this.size = 3;
        this.unitCapModifier = 8;
        this.alwaysUnlocked = true;
        this.unitType = HUnits.ningwang;
        this.requirements(Category.effect, ItemStack.with(new Object[] { HItems.gao, 1200 }));
      }
    };
  }
}
