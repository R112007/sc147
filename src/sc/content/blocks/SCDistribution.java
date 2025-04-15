package sc.content.blocks;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.ArmoredConveyor;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.distribution.OverflowGate;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.distribution.StackConveyor;
import sc.content.SCItems;
import sc.world.blocks.distribution.DropDrillItem;

public class SCDistribution {
  public static Block lvconveyor;
  public static Block xiconveyor;
  public static Block armorxiconveyor;
  public static Block chijinconveyor;
  public static Block armorchijinconveyor;
  public static Block feijingconveyor;
  public static Block sujiaoconveyor;
  public static Block thickconveyor;
  public static Block lvlianjieqi;
  public static Block lvluyouqi;
  public static Block lvfenpeiqi;
  public static Block lvfenliuqi;
  public static Block lvbridge;
  public static Block xibridge;
  public static Block chijinbridge;
  public static Block lvfenleiqi;
  public static Block lvfanxiangfenleiqi;
  public static Block lvyiliumeng;
  public static Block lvfanxiangyiliumeng;
  public static Block dropdrill1;
  public static Block massdriver1;
  public static Block massdriver2;

  public static void load() {
    SCDistribution.lvconveyor = new Conveyor("lvconveyor") {
      {
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 1 }));
        this.armor = 2f;
        this.speed = 0.05f;
        this.displayedSpeed = 7f;
      }

      @Override
      public void init() {
        super.init();
        this.bridgeReplacement = SCDistribution.lvbridge;
        this.junctionReplacement = SCDistribution.lvlianjieqi;
      }

    };
    SCDistribution.xiconveyor = new Conveyor("xiconveyor") {
      {
        this.size = 1;
        this.health = 70;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.lv, 1, SCItems.li, 1, SCItems.xi, 1 }));
        this.armor = 2f;
        this.speed = 0.123f;
        this.displayedSpeed = 15f;
      }

      @Override
      public void init() {
        super.init();
        this.bridgeReplacement = SCDistribution.xibridge;
        this.junctionReplacement = SCDistribution.lvlianjieqi;
      }

    };
    SCDistribution.armorxiconveyor = new ArmoredConveyor("armorxiconveyor") {
      {
        this.size = 1;
        this.health = 70;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.jin, 1, SCItems.lvgang, 2, SCItems.xi, 2 }));
        this.armor = 2f;
        this.speed = 0.123f;
        this.displayedSpeed = 15f;
      }

      @Override
      public void init() {
        super.init();
        this.bridgeReplacement = SCDistribution.xibridge;
        this.junctionReplacement = SCDistribution.lvlianjieqi;
      }

    };
    SCDistribution.chijinconveyor = new Conveyor("chijinconveyor") {
      {
        this.size = 1;
        this.health = 300;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.sujiao, 1, SCItems.you, 1, SCItems.chijin, 1 }));
        this.armor = 2f;
        this.speed = 0.3f;
        this.displayedSpeed = 30.5f;
      }

      @Override
      public void init() {
        super.init();
        this.bridgeReplacement = SCDistribution.chijinbridge;
        this.junctionReplacement = SCDistribution.lvlianjieqi;
      }

    };
    SCDistribution.armorchijinconveyor = new ArmoredConveyor("armorchijinconveyor") {
      {
        this.size = 1;
        this.health = 300;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.sujiao, 5, SCItems.you, 3, SCItems.chijin, 3 }));
        this.armor = 2f;
        this.speed = 0.3f;
        this.displayedSpeed = 30.5f;
      }

      @Override
      public void init() {
        super.init();
        this.bridgeReplacement = SCDistribution.chijinbridge;
        this.junctionReplacement = SCDistribution.lvlianjieqi;
      }

    };
    SCDistribution.feijingconveyor = new StackConveyor("feijingconveyor") {
      {
        this.speed = 0.05f;
        this.itemCapacity = 15;
        this.health = 45;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.feijing, 2, SCItems.xi, 3 }));
      }
    };
    SCDistribution.sujiaoconveyor = new StackConveyor("sujiaoconveyor") {
      {
        this.speed = 0.07f;
        this.itemCapacity = 20;
        this.health = 90;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.sujiao, 2, SCItems.jin, 3 }));
      }
    };
    SCDistribution.thickconveyor = new StackConveyor("thickconveyor") {
      {
        this.speed = 0.1f;
        this.itemCapacity = 60;
        this.health = 350;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.hejing1, 12, SCItems.chijin, 15 }));
      }
    };
    SCDistribution.lvlianjieqi = new Junction("lvlianjieqi") {
      {
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 2 }));
        this.armor = 2f;
        this.speed = 20f;
        this.itemCapacity = 24;
      }
    };
    SCDistribution.lvluyouqi = new Router("lvluyouqi") {
      {
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 2 }));
        this.armor = 2f;
        this.speed = 1f;
      }
    };
    SCDistribution.lvfenpeiqi = new Router("lvfenpeiqi") {
      {
        this.size = 2;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 8, SCItems.li, 8 }));
        this.armor = 2f;
        this.speed = 1f;
      }
    };
    SCDistribution.lvfenliuqi = new Router("lvfenliuqi") {
      {
        this.size = 3;
        this.health = 100;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 18, SCItems.li, 18 }));
        this.armor = 2f;
        this.speed = 1f;
      }
    };
    SCDistribution.lvbridge = new ItemBridge("lvbridge") {
      {
        this.size = 1;
        this.health = 80;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 4, SCItems.li, 4 }));
        this.armor = 2f;
        this.transportTime = 5f;
        this.itemCapacity = 15;
        this.range = 5;
        this.arrowSpacing = 6f;
        this.hasPower = false;
      }
    };
    SCDistribution.xibridge = new ItemBridge("xibridge") {
      {
        this.size = 1;
        this.health = 120;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.xi, 6, SCItems.cuguijing, 8 }));
        this.armor = 2f;
        this.transportTime = 2.8f;
        this.itemCapacity = 20;
        this.range = 7;
        this.arrowSpacing = 6f;
        this.hasPower = false;
      }
    };
    SCDistribution.chijinbridge = new ItemBridge("chijinbridge") {
      {
        this.size = 1;
        this.health = 500;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.sujiao, 8, SCItems.chijin, 12 }));
        this.armor = 2f;
        this.transportTime = 0.5f;
        this.itemCapacity = 30;
        this.range = 15;
        this.arrowSpacing = 6f;
        this.hasPower = false;
      }
    };
    SCDistribution.lvfenleiqi = new Sorter("lvfenleiqi") {
      {
        this.solid = false;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 3, SCItems.li, 3 }));
        this.armor = 2f;
      }
    };
    SCDistribution.lvfanxiangfenleiqi = new Sorter("lvfanxiangfenleiqi") {
      {
        this.invert = true;
        this.solid = false;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 3, SCItems.li, 3 }));
        this.armor = 2f;
      }
    };
    SCDistribution.lvyiliumeng = new OverflowGate("lvyiliumeng") {
      {
        this.solid = false;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 3, SCItems.li, 3 }));
        this.armor = 2f;
      }
    };
    SCDistribution.lvfanxiangyiliumeng = new OverflowGate("lvfanxiangyiliumeng") {
      {
        this.solid = false;
        this.invert = true;
        this.size = 1;
        this.health = 40;
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 3, SCItems.li, 3 }));
        this.armor = 2f;
      }
    };
    SCDistribution.dropdrill1 = new DropDrillItem("dropdrill1") {
      {
        this.size = 2;
        this.hasPower = true;
        this.consumePower(7.5f);
        this.itemCapacity = 50;
        this.range = 72f;
        this.reload = 720f;
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.lv, 120, SCItems.li, 150, SCItems.cuguijing, 120 }));
      }
    };
    SCDistribution.massdriver1 = new MassDriver("massdriver1") {
      {
        this.size = 1;
        this.itemCapacity = 30;
        this.range = 200;
        this.bulletSpeed = 8;
        this.consumePower(2f);
        this.requirements(Category.distribution,
            ItemStack.with(new Object[] { SCItems.lv, 25, SCItems.li, 40, SCItems.cuguijing, 30, SCItems.lvgang, 45 }));
      }
    };
    SCDistribution.massdriver2 = new MassDriver("massdriver2") {
      {
        this.size = 3;
        this.itemCapacity = 130;
        this.range = 450;
        this.bulletSpeed = 10f;
        this.reload = 150f;
        this.consumePower(8f);
        this.requirements(Category.distribution,
            ItemStack
                .with(new Object[] { SCItems.lvgang, 75, SCItems.feijing, 60, SCItems.lvgang, 80, SCItems.jin, 100 }));
      }
    };
  }
}
