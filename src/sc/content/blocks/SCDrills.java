package sc.content.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;
import static sc.content.SCItems.*;

public class SCDrills {

  public static Block lvdrill;
  public static Block guijingdrill;
  public static Block guijingdrill2;
  public static Block jindrill;

  public static void load() {
    SCDrills.lvdrill = new Drill("lvdrill") {
      {
        this.size = 2;
        this.health = 200;
        this.drillTime = 500.0f;
        this.armor = 2;
        this.tier = 2;
        this.hasLiquids = true;
        this.liquidCapacity = 18.0f;
        this.drawMineItem = true;
        this.drillEffect = Fx.mine;
        this.updateEffect = Fx.lightningCharge;
        this.rotateSpeed = 2.0f;
        this.drawRim = false;
        this.heatColor = Color.valueOf("#71d5ff");
        this.warmupSpeed = 0.005f;
        this.liquidBoostIntensity = 1.85f;
        this.consumeLiquid(Liquids.water, 0.1f).boost().optional = true;
        this.requirements(Category.production, ItemStack.with(new Object[] { lv, 10 }));
      }
    };
    SCDrills.guijingdrill = new Drill("guijingdrill") {
      {
        this.size = 2;
        this.health = 200;
        this.drillTime = 300.0f;
        this.armor = 2;
        this.tier = 3;
        this.hasLiquids = true;
        this.liquidCapacity = 18.0f;
        this.drawMineItem = true;
        this.drillEffect = Fx.mine;
        this.updateEffect = Fx.lightningCharge;
        this.rotateSpeed = 2.0f;
        this.drawRim = false;
        this.heatColor = Color.valueOf("#71d5ff");
        this.warmupSpeed = 0.005f;
        this.liquidBoostIntensity = 1.4f;
        this.consumeLiquid(Liquids.water, 0.1f).boost().optional = true;
        this.requirements(Category.production, ItemStack.with(new Object[] { lv, 20, cuguijing, 12 }));
      }
    };
    SCDrills.guijingdrill2 = new Drill("guijingdrill2") {
      {
        this.size = 3;
        this.tier = 4;
        this.health = 650;
        this.drillTime = 230.0f;
        this.armor = 5;
        this.hasLiquids = true;
        this.liquidCapacity = 36.0f;
        this.itemCapacity = 20;
        this.drawMineItem = true;
        this.drillEffect = Fx.mine;
        this.updateEffect = Fx.lightningCharge;
        this.consumePower(1.1f);
        this.rotateSpeed = 3.0f;
        this.drawRim = false;
        this.heatColor = Color.valueOf("#71d5ff");
        this.warmupSpeed = 0.004f;
        this.liquidBoostIntensity = 1.85f;
        this.consumeLiquid(Liquids.water, 0.15f).boost().optional = true;
        this.requirements(Category.production,
            ItemStack.with(new Object[] { lv, 80, cuguijing, 30, xi, 70, chunguijing, 30 }));
      }
    };
    SCDrills.jindrill = new Drill("jindrill") {
      {
        this.size = 4;
        this.health = 1850;
        this.drillTime = 150.0f;
        this.tier = 5;
        this.armor = 5;
        this.hasLiquids = true;
        this.liquidCapacity = 36.0f;
        this.itemCapacity = 30;
        this.drawMineItem = true;
        this.drillEffect = Fx.flakExplosion;
        this.updateEffect = Fx.mineHuge;
        this.rotateSpeed = 3.0f;
        this.drawRim = true;
        this.heatColor = Color.valueOf("#71d5ff");
        this.consumePower(4.5f);
        this.warmupSpeed = 0.03f;
        this.liquidBoostIntensity = 1.85f;
        this.consumeLiquid(Liquids.water, 0.2f).boost().optional = true;
        this.requirements(Category.production,
            ItemStack.with(new Object[] { lv, 180, lvgang, 80, xi, 125, chunguijing, 90, jin, 80 }));
      }
    };
  }
}
