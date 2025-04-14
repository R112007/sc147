package sc.content.blocks;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Door;
import mindustry.world.blocks.defense.ShieldWall;
import mindustry.world.blocks.defense.Wall;
import sc.content.SCItems;

public class SCWalls {
  public static Block lvwall1;
  public static Block lvwall2;
  public static Block lvwall3;
  public static Block lvwall4;
  public static Block xiwall1;
  public static Block xiwall2;
  public static Block xiwall3;
  public static Block xiwall4;
  public static Block lvgangwall1;
  public static Block lvgangwall2;
  public static Block lvgangwall3;
  public static Block lvgangwall4;
  public static Block jinwall1;
  public static Block jinwall2;
  public static Block jinwall3;
  public static Block jinwall4;
  public static Block chijinwall;
  public static Block hejingwall1;
  public static Block hejingwall2;
  public static Block hejingwall3;
  public static Block door1;
  public static Block door2;

  public static void load() {
    SCWalls.lvwall1 = new Wall("lvwall1") {
      {
        this.size = 1;
        this.health = 500;
        this.armor = 3;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 6 }));
      }
    };
    SCWalls.lvwall2 = new Wall("lvwall2") {
      {
        this.size = 2;
        this.health = 2000;
        this.armor = 3;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 24 }));
      }
    };
    SCWalls.lvwall3 = new Wall("lvwall3") {
      {
        this.size = 3;
        this.health = 4000;
        this.armor = 3;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 48 }));
      }
    };
    SCWalls.lvwall4 = new Wall("lvwall4") {
      {
        this.size = 4;
        this.health = 5000;
        this.armor = 6;
        this.placeableLiquid = true;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lv, 60 }));
      }
    };
    SCWalls.xiwall1 = new Wall("xiwall1") {
      {
        this.size = 1;
        this.health = 800;
        this.armor = 4;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.xi, 6 }));
      }
    };
    SCWalls.xiwall2 = new Wall("xiwall2") {
      {
        this.size = 2;
        this.health = 800 * 4;
        this.armor = 4;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.xi, 24 }));
      }
    };
    SCWalls.xiwall3 = new Wall("xiwall3") {
      {
        this.size = 3;
        this.health = 800 * 8;
        this.armor = 4;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.xi, 48 }));
      }
    };
    SCWalls.xiwall4 = new Wall("xiwall4") {
      {
        this.size = 4;
        this.health = 800 * 10;
        this.placeableLiquid = true;
        this.armor = 8;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.xi, 60 }));
      }
    };
    SCWalls.lvgangwall1 = new Wall("lvgangwall1") {
      {
        this.size = 1;
        this.health = 1000;
        this.armor = 5;
        this.insulated = true;
        this.absorbLasers = true;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lvgang, 6 }));
      }
    };
    SCWalls.lvgangwall2 = new Wall("lvgangwall2") {
      {
        this.size = 2;
        this.health = 1000 * 4;
        this.armor = 5;
        this.insulated = true;
        this.absorbLasers = true;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lvgang, 24 }));
      }
    };
    SCWalls.lvgangwall3 = new Wall("lvgangwall3") {
      {
        this.size = 3;
        this.health = 1000 * 8;
        this.armor = 5;
        this.insulated = true;
        this.absorbLasers = true;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lvgang, 48 }));
      }
    };
    SCWalls.lvgangwall4 = new Wall("lvgangwall4") {
      {
        this.size = 4;
        this.health = 1000 * 10;
        this.armor = 10;
        this.placeableLiquid = true;
        this.insulated = true;
        this.absorbLasers = true;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lvgang, 60 }));
      }
    };
    SCWalls.jinwall1 = new Wall("jinwall1") {
      {
        this.size = 1;
        this.health = 1300;
        this.armor = 6;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.jin, 6 }));
      }
    };
    SCWalls.jinwall2 = new Wall("jinwall2") {
      {
        this.size = 2;
        this.health = 1300 * 4;
        this.armor = 6;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.jin, 24 }));
      }
    };
    SCWalls.jinwall3 = new Wall("jinwall3") {
      {
        this.size = 3;
        this.health = 1300 * 8;
        this.armor = 6;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.jin, 48 }));
      }
    };
    SCWalls.jinwall4 = new Wall("jinwall4") {
      {
        this.size = 4;
        this.health = 1300 * 10;
        this.armor = 12;
        this.placeableLiquid = true;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.jin, 60 }));
      }
    };
    SCWalls.chijinwall = new Wall("chijinwall") {
      {
        this.size = 3;
        this.health = 18000;
        this.placeableLiquid = true;
        this.armor = 28;
        this.insulated = true;
        this.absorbLasers = true;
        this.chanceDeflect = 20;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lvgang, 84, SCItems.sujiao, 72,
            SCItems.chijin, 72, SCItems.jinhuihejin, 24, SCItems.hejing1, 12 }));
      }
    };
    SCWalls.hejingwall1 = new Wall("hejingwall1") {
      {
        this.size = 3;
        this.health = 24000;
        this.armor = 35;
        this.placeableLiquid = true;
        this.insulated = true;
        this.absorbLasers = true;
        this.chanceDeflect = 25;
        this.lightningChance = 0.1f;
        this.lightningDamage = 60.0f;
        this.lightningLength = 22;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.lvgang, 180, SCItems.sujiao, 128,
            SCItems.chijin, 128, SCItems.jinhuihejin, 84, SCItems.hejing1, 64, SCItems.hejing2, 12 }));
      }
    };
    SCWalls.hejingwall2 = new Wall("hejingwall2") {
      {
        this.size = 4;
        this.health = 455000;
        this.armor = 50;
        this.placeableLiquid = true;
        this.insulated = true;
        this.absorbLasers = true;
        this.chanceDeflect = 25;
        this.lightningChance = 0.1f;
        this.lightningDamage = 60.0f;
        this.lightningLength = 22;
        this.requirements(Category.defense,
            ItemStack
                .with(new Object[] { SCItems.lvgang, 450, SCItems.sujiao, 350, SCItems.chijin, 500, SCItems.jinhuihejin,
                    280, SCItems.hejing1, 150, SCItems.hejing2, 60, SCItems.hejing3, 10, SCItems.ningnengjing, 60 }));
      }
    };
    SCWalls.hejingwall3 = new ShieldWall("hejingwall3") {
      {
        this.size = 6;
        this.health = 80000;
        this.armor = 50;
        this.placeableLiquid = true;
        this.insulated = true;
        this.absorbLasers = true;
        this.chanceDeflect = 25;
        this.lightningChance = 0.1f;
        this.lightningDamage = 60.0f;
        this.lightningLength = 22;
        this.shieldHealth = 30000;
        this.outputsPower = false;
        this.hasPower = true;
        this.consumesPower = true;
        this.conductivePower = true;
        this.consumePower(5f / 60f);
        this.requirements(Category.defense,
            ItemStack.with(
                new Object[] { SCItems.lvgang, 1500, SCItems.sujiao, 800, SCItems.chijin, 1000, SCItems.jinhuihejin,
                    750, SCItems.hejing1, 600, SCItems.hejing2, 280, SCItems.hejing3, 60, SCItems.ningnengjing, 360 }));
      }
    };
    SCWalls.door1 = new Door("door1") {
      {
        this.size = 1;
        this.health = 650;
        this.armor = 3;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.xi, 5, SCItems.cuguijing, 10 }));
      }
    };
    SCWalls.door2 = new Door("door2") {
      {
        this.size = 2;
        this.health = 3000;
        this.armor = 3;
        this.requirements(Category.defense, ItemStack.with(new Object[] { SCItems.xi, 20, SCItems.cuguijing, 35 }));
      }
    };
  }
}
