package hzr.content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.OverflowGate;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.distribution.StackConveyor;

public class Hdistribution {
  public static Block gaoconveyor, gaoconveyor1, gaobridge, gaofenleiqi, gaofanxiangfenleiqi, gaoyiliumeng,
      gaofanxiangyiliumeng, gaolianjieqi, gaoluyouqi;

  public static void load() {
    Hdistribution.gaoconveyor = new StackConveyor("gao-conveyor") {
      {
        this.speed = 0.04f;
        this.itemCapacity = 8;
        this.health = 45;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { HItems.gao, 2, HItems.brokenB, 2 }));
      }
    };
    Hdistribution.gaoconveyor1 = new Conveyor("gaoconveyor1") {
      {
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 1 }));
        this.armor = 2f;
        this.speed = 0.103f;
        this.displayedSpeed = 13f;
      }

      @Override
      public void init() {
        super.init();
        this.bridgeReplacement = Hdistribution.gaobridge;
        this.junctionReplacement = Hdistribution.gaolianjieqi;
      }
    };
    Hdistribution.gaolianjieqi = new Junction("gaolianjieqi") {
      {
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 2 }));
        this.armor = 2f;
        this.speed = 20f;
        this.itemCapacity = 24;
      }
    };
    Hdistribution.gaoluyouqi = new Router("gaoluyouqi") {
      {
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 2 }));
        this.armor = 2f;
        this.speed = 1f;
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
    Hdistribution.gaofenleiqi = new Sorter("gaofenleiqi") {
      {
        this.solid = false;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 8 }));
        this.armor = 2f;
      }
    };
    Hdistribution.gaofanxiangfenleiqi = new Sorter("gaofanxiangfenleiqi") {
      {
        this.invert = true;
        this.solid = false;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 8 }));
        this.armor = 2f;
      }
    };
    Hdistribution.gaoyiliumeng = new OverflowGate("gaoyiliumeng") {
      {
        this.solid = false;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 6 }));
        this.armor = 2f;
      }
    };
    Hdistribution.gaofanxiangyiliumeng = new OverflowGate("gaofanxiangyiliumeng") {
      {
        this.solid = false;
        this.invert = true;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { HItems.gao, 6 }));
        this.armor = 2f;
      }
    };
  }
}
