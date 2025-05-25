package sc.content.blocks;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.logic.LogicBlock;
import sc.content.SCItems;

public class SCLogic {
  public static Block chuliqi1;

  public static void load() {
    SCLogic.chuliqi1 = new LogicBlock("chuliqi1") {
      {
        this.range = 96f;
        this.size = 1;
        this.instructionsPerTick = 2;
        this.health = 100;

        this.requirements(Category.logic,
            ItemStack.with(new Object[] { SCItems.lv, 50, SCItems.li, 50, SCItems.cuguijing, 30 }));
      }
    };
  }
}
