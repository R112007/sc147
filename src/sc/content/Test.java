package sc.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;

public class Test {
  public static Block test;

  public static void load() {
    Test.test = new GenericCrafter("test") {
      {
        this.health = 130;
        this.size = 2;
        this.craftTime = 30.0f;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = false;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
        this.outputItem = new ItemStack(SCItems.cuguijing, 1);
        this.consumeItems(ItemStack.with(SCItems.lv, 1, SCItems.tandanzhi, 1));
        this.updateEffect = SCFx.smoke4sides;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

      }
    };
  }
}
