package sc.content.blocks;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.production.Pump;
import sc.content.SCItems;

public class SCLiquidBlocks {
  public static Block beng1;
  public static Block beng2;
  public static Block beng3;
  public static Block beng4;
  public static Block lvdaoguan;
  public static Block xidaoguan;
  public static Block lvyetijiaochaqi;
  public static Block lvyetiluyouqi;
  public static Block lvdaoguanqiao;
  public static Block xidaoguanqiao;
  public static Block yetichuguan;
  public static Block shuixiang;

  public static void load() {
    SCLiquidBlocks.beng1 = new Pump("beng1") {
      {
        this.size = 1;
        this.health = 300;
        this.liquidCapacity = 10;
        this.hasLiquids = true;
        this.pumpAmount = 0.16666666667f;
        this.requirements(Category.liquid, ItemStack.with(new Object[] { SCItems.lv, 10, SCItems.boli, 15 }));
      }
    };
    SCLiquidBlocks.beng2 = new Pump("beng2") {
      {
        this.size = 2;
        this.health = 680;
        this.liquidCapacity = 40;
        this.hasLiquids = true;
        this.pumpAmount = 0.2333333f;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.lv, 85, SCItems.li, 80, SCItems.boli, 65, SCItems.xi, 60 }));
        this.consumePower(2.3f);
      }
    };
    SCLiquidBlocks.beng3 = new Pump("beng3") {
      {
        this.size = 3;
        this.health = 1280;
        this.liquidCapacity = 90;
        this.hasLiquids = true;
        this.pumpAmount = 0.4f;
        this.requirements(Category.liquid, ItemStack.with(
            new Object[] { SCItems.lv, 350, SCItems.li, 300, SCItems.boli, 300, SCItems.jin, 120, SCItems.you, 150 }));
        this.consumePower(8f);
      }
    };
    SCLiquidBlocks.beng4 = new Pump("beng4") {
      {
        this.size = 4;
        this.health = 1800;
        this.liquidCapacity = 100;
        this.hasLiquids = true;
        this.pumpAmount = 0.48f;
        this.requirements(Category.liquid, ItemStack.with(new Object[] { SCItems.boli, 350, SCItems.xi, 280,
            SCItems.jin, 200, SCItems.you, 200, SCItems.hejing1, 40 }));
        this.consumePower(13f);
      }
    };
    SCLiquidBlocks.lvdaoguan = new Conduit("lvdaoguan") {
      {
        this.size = 1;
        this.health = 140;
        this.liquidCapacity = 10;
        this.hasLiquids = true;
        this.requirements(Category.liquid, ItemStack.with(new Object[] { SCItems.lv, 1, SCItems.boli, 2 }));
      }
    };
    SCLiquidBlocks.xidaoguan = new Conduit("xidaoguan") {
      {
        this.size = 1;
        this.health = 180;
        this.liquidCapacity = 20;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.xi, 2, SCItems.boli, 6, SCItems.chunguijing, 2 }));
        this.liquidPressure = 5f;
      }
    };
    SCLiquidBlocks.lvyetijiaochaqi = new LiquidJunction("lvyetijiaochaqi") {
      {
        this.size = 1;
        this.health = 180;
        this.liquidCapacity = 20;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.lv, 2, SCItems.boli, 2 }));

      }
    };
    SCLiquidBlocks.lvyetiluyouqi = new LiquidRouter("lvyetiluyouqi") {
      {
        this.size = 1;
        this.health = 180;
        this.liquidCapacity = 20;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.lv, 8, SCItems.boli, 4 }));
      }
    };
    SCLiquidBlocks.lvdaoguanqiao = new LiquidBridge("lvdaoguanqiao") {
      {
        this.size = 1;
        this.health = 250;
        this.liquidCapacity = 20;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.lv, 12, SCItems.boli, 9 }));
        this.range = 5;
      }
    };
    SCLiquidBlocks.xidaoguanqiao = new LiquidBridge("xidaoguanqiao") {
      {
        this.size = 1;
        this.health = 430;
        this.liquidCapacity = 40;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.xi, 12, SCItems.boli, 25, SCItems.chunguijing, 10 }));
        this.range = 8;
      }
    };
    SCLiquidBlocks.yetichuguan = new LiquidRouter("yetichuguan") {
      {
        this.size = 2;
        this.health = 450;
        this.liquidCapacity = 600;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.lv, 30, SCItems.boli, 45 }));
      }
    };
    SCLiquidBlocks.shuixiang = new LiquidRouter("shuixiang") {
      {
        this.size = 3;
        this.health = 980;
        this.liquidCapacity = 3000;
        this.hasLiquids = true;
        this.requirements(Category.liquid,
            ItemStack.with(new Object[] { SCItems.cuguijing, 180, SCItems.boli, 300, SCItems.lvgang, 200 }));
      }
    };
  }
}
