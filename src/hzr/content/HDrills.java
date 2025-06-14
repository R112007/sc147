package hzr.content;

import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import sc.world.SCAttributes;
import sc.world.blocks.production.AttributeRandCrafter;
import sc.world.blocks.production.DrillTurret;

public class HDrills {
  public static Block turretdrill1;
  public static Block wastedrop;

  public static void load() {
    HDrills.turretdrill1 = new DrillTurret("turretdrill1") {
      {
        this.mineSpeed = 0.5f;
        this.range = 50f;
        this.itemCapacity = 25;
        this.requirements(Category.production, ItemStack.with(new Object[] { HItems.gao, 20 }));
      }
    };
    HDrills.wastedrop = new AttributeRandCrafter("wastedrop") {
      {
        this.hasLiquids = false;
        this.minEfficiency = 0;
        this.size = 2;
        this.craftTime = 600;
        this.results = ItemStack.with(
            HItems.brokenA, 1,
            HItems.brokenB, 1,
            HItems.brokenC, 8);
        this.requirements(Category.production, ItemStack.with(new Object[] { HItems.gao, 45, HItems.brokenA, 10 }));
        this.attribute = SCAttributes.waste;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawMulti(new DrawRegion("-top", 1.4f, true)));
        this.craftEffect = Fx.pulverize;
      }
    };
  }
}
