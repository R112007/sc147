package sc.content.blocks;

import arc.graphics.Color;
import arc.graphics.Colors;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawLiquidRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPower;
import mindustry.world.draw.DrawRegion;
import mindustry.world.draw.DrawWarmupRegion;
import sc.content.SCItems;
import sc.graphics.SCPal;

public class SCPower {

  public static Block powernode1;
  public static Block sun1;
  public static Block battery1;
  public static Block firepower1;
  public static Block qilunji;

  public static void load() {

    SCPower.powernode1 = new PowerNode("powernode1") {
      {
        this.size = 1;
        this.health = 80;
        this.laserColor1 = SCPal.light_blue1;
        this.laserColor2 = SCPal.dark_blue1;
        this.maxNodes = 7;
        this.armor = 1;
        this.laserRange = 8;
        this.hasPower = true;
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 2, SCItems.li, 3 }));
      }
    };
    SCPower.firepower1 = new ConsumeGenerator("firepower1") {
      {
        this.size = 1;
        this.health = 100;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 1.5f;
        this.lightRadius = 2.0f;
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 20, SCItems.li, 15 }));
        this.itemDuration = 120f;
        this.generateEffect = Fx.generatespark;
        this.consume(new ConsumeItemFlammable());
        this.drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
      }
    };
    SCPower.qilunji = new ConsumeGenerator("qilunji") {
      {
        this.size = 2;
        this.health = 300;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 7.5f;
        this.hasLiquids = true;
        this.lightRadius = 6.0f;
        this.liquidCapacity = 15f;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-turbine", 2f), new DrawRegion("-turbine", 2f) {
          {
            this.rotation = 45f;
          }
        }, new DrawRegion("-cap"), new DrawLiquidRegion(Liquids.water));
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 35, SCItems.li, 40, SCItems.cuguijing, 65 }));
        this.itemDuration = 135f;
        this.generateEffect = Fx.generatespark;
        this.consume(new ConsumeItemFlammable());
        this.consumeLiquid(Liquids.water, 0.14666f);
      }
    };
    SCPower.sun1 = new SolarGenerator("sun1") {
      {
        this.size = 1;
        this.health = 50;
        this.buildCostMultiplier = 2;
        this.powerProduction = 0.3f;
        this.lightRadius = 2.0f;
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 12, SCItems.li, 12 }));
      }
    };
    SCPower.battery1 = new Battery("battery1") {
      {
        this.size = 1;
        this.health = 60;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawPower() {
          {
            this.emptyLightColor = Color.valueOf("#F8C266");
            this.fullLightColor = Color.valueOf("#FFFFFF");
          }
        }, new DrawRegion("-top"));
        this.consumePowerBuffered(3000f);
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 8, SCItems.li, 20 }));
      }
    };
  }

}
