package sc.content.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.power.PowerDiode;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeItemRadioactive;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawLiquidRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPower;
import mindustry.world.draw.DrawRegion;
import mindustry.world.draw.DrawWarmupRegion;
import sc.content.SCItems;
import sc.content.SCLiquids;
import sc.graphics.SCPal;
import sc.world.SCAttributes;

public class SCPower {

  public static Block powernode1;
  public static Block powernode2;
  public static Block powernode3;
  public static Block powernode4;
  public static Block powernode5;
  public static Block erjiguan;
  public static Block sun1;
  public static Block battery1;
  public static Block battery2;
  public static Block battery3;
  public static Block battery4;
  public static Block firepower1;
  public static Block firepower2;
  public static Block qilunji;
  public static Block qilunji2;
  public static Block dire;
  public static Block dire2;
  public static Block dineng;
  public static Block watergenerate;
  public static Block nuclear1;
  public static Block nuclear2;
  public static Block rtg1;
  public static Block rtg2;
  public static Block impact1;
  public static Block impact2;

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
    SCPower.powernode2 = new PowerNode("powernode2") {
      {
        this.size = 2;
        this.health = 270;
        this.laserColor1 = SCPal.light_blue1;
        this.laserColor2 = SCPal.dark_blue1;
        this.maxNodes = 13;
        this.armor = 1;
        this.laserRange = 18;
        this.hasPower = true;
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lv, 4, SCItems.li, 5, SCItems.xi, 4 }));
      }
    };
    SCPower.powernode3 = new PowerNode("powernode3") {
      {
        this.size = 2;
        this.health = 500;
        this.laserColor1 = SCPal.light_blue1;
        this.laserColor2 = SCPal.dark_blue1;
        this.maxNodes = 30;
        this.armor = 1;
        this.laserRange = 26;
        this.hasPower = true;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lvgang, 4, SCItems.jin, 5, SCItems.gutaineng, 4 }));
      }
    };
    SCPower.powernode4 = new PowerNode("powernode4") {
      {
        this.size = 2;
        this.health = 1000;
        this.laserColor1 = SCPal.light_blue1;
        this.laserColor2 = SCPal.dark_blue1;
        this.maxNodes = 4;
        this.armor = 1;
        this.laserRange = 110;
        this.hasPower = true;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.boli, 50, SCItems.you, 35, SCItems.jinhuihejin, 40 }));
      }
    };
    SCPower.powernode5 = new PowerNode("powernode5") {
      {
        this.size = 2;
        this.health = 2000;
        this.laserColor1 = SCPal.light_blue1;
        this.laserColor2 = SCPal.dark_blue1;
        this.maxNodes = 15;
        this.armor = 1;
        this.laserRange = 150;
        this.hasPower = true;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.boli, 500, SCItems.jinhuihejin, 150, SCItems.hejing1, 40 }));
      }
    };
    SCPower.erjiguan = new PowerDiode("erjiguan") {
      {
        this.size = 1;
        this.health = 100;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.boli, 60, SCItems.chunguijing, 50, SCItems.feijing, 40 }));
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
    SCPower.battery2 = new Battery("battery2") {
      {
        this.size = 2;
        this.health = 240;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawPower() {
          {
            this.emptyLightColor = Color.valueOf("#F8C266");
            this.fullLightColor = Color.valueOf("#FFFFFF");
          }
        }, new DrawRegion("-top"));
        this.consumePowerBuffered(20000f);
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 35, SCItems.li, 20, SCItems.cuguijing, 20, SCItems.xi, 20 }));
      }
    };
    SCPower.battery3 = new Battery("battery3") {
      {
        this.size = 3;
        this.health = 800;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawPower() {
          {
            this.emptyLightColor = Color.valueOf("#F8C266");
            this.fullLightColor = Color.valueOf("#FFFFFF");
          }
        }, new DrawRegion("-top"));
        this.consumePowerBuffered(50000f);
        this.requirements(Category.power, ItemStack
            .with(new Object[] { SCItems.feijing, 20, SCItems.sujiao, 20, SCItems.lvgang, 50, SCItems.jin, 35 }));
      }
    };
    SCPower.battery4 = new Battery("battery4") {
      {
        this.size = 3;
        this.health = 2400;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawPower() {
          {
            this.emptyLightColor = Color.valueOf("#F8C266");
            this.fullLightColor = Color.valueOf("#FFFFFF");
          }
        }, new DrawRegion("-top"));
        this.consumePowerBuffered(100000f);
        this.requirements(Category.power, ItemStack
            .with(
                new Object[] { SCItems.chijin, 50, SCItems.sujiao, 120, SCItems.gutaineng, 50, SCItems.hejing1, 35 }));
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
    SCPower.firepower2 = new ConsumeGenerator("firepower2") {
      {
        this.size = 1;
        this.health = 300;
        this.buildCostMultiplier = 0.75f;
        this.powerProduction = 4f;
        this.lightRadius = 3.0f;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 40, SCItems.li, 35, SCItems.cuguijing, 25, SCItems.xi, 20 }));
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
    SCPower.qilunji2 = new ConsumeGenerator("qilunji2") {
      {
        this.size = 3;
        this.health = 900;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 25f;
        this.hasLiquids = true;
        this.lightRadius = 18.0f;
        this.liquidCapacity = 50f;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-turbine", 2f), new DrawRegion("-turbine", 2f) {
          {
            this.rotation = 45f;
          }
        }, new DrawRegion("-cap"), new DrawLiquidRegion(Liquids.water));
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.chunguijing, 50, SCItems.chijin, 90, SCItems.lvgang, 70,
                SCItems.gutaineng, 75, SCItems.hejing1, 50 }));
        this.itemDuration = 150f;
        this.generateEffect = Fx.generatespark;
        this.consume(new ConsumeItemFlammable());
        this.consumeLiquid(Liquids.water, 0.4f);
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
    SCPower.dire = new ThermalGenerator("dire") {
      {
        this.size = 2;
        this.health = 300;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 4f;
        this.generateEffect = Fx.coalSmeltsmoke;
        this.effectChance = 0.2f;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 85, SCItems.li, 125, SCItems.cuguijing, 75 }));
        this.floating = true;
      }
    };
    SCPower.dire2 = new ThermalGenerator("dire2") {
      {
        this.size = 3;
        this.health = 1200;
        this.buildCostMultiplier = 0.6f;
        this.powerProduction = 15f;
        this.generateEffect = Fx.coalSmeltsmoke;
        this.effectChance = 0.2f;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 285, SCItems.feijing, 125, SCItems.feijing, 75, SCItems.you, 75,
                SCItems.hejing1, 45 }));
        this.floating = true;
      }
    };
    SCPower.dineng = new ThermalGenerator("dineng") {
      {
        this.size = 2;
        this.health = 3000;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 50f;
        this.generateEffect = Fx.coalSmeltsmoke;
        this.effectChance = 0.2f;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.chunguijing, 300, SCItems.lvgang, 325, SCItems.feijing, 275,
                SCItems.hejing1, 80, SCItems.hejing2, 5 }));
        this.floating = true;
        this.attribute = SCAttributes.underpower;
      }
    };
    SCPower.watergenerate = new ImpactReactor("watergenerate") {
      {
        this.size = 2;
        this.health = 1000;
        this.buildCostMultiplier = 0.8f;
        this.powerProduction = 4.5f;
        this.placeableLiquid = true;
        this.itemCapacity = 0;
        this.liquidCapacity = 60;
        this.hasPower = true;
        this.hasLiquids = true;
        this.itemDuration = 120;
        this.warmupSpeed = 0.02f;
        this.explosionRadius = 16;
        this.explosionDamage = 50;
        this.explodeEffect = Fx.shockwave;
        this.consumeLiquid(Liquids.water, 0.2f);
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 45, SCItems.boli, 75, SCItems.cuguijing, 75, SCItems.xi, 45 }));
      }
    };
    SCPower.nuclear1 = new NuclearReactor("nuclear1") {
      {
        this.size = 2;
        this.health = 1500;
        this.liquidCapacity = 30;
        this.itemCapacity = 20;
        this.hasItems = true;
        this.hasLiquids = true;
        this.outputsPower = true;
        this.powerProduction = 50;
        this.itemDuration = 240;
        this.heating = 0.01f;
        this.lightColor = Color.white;
        this.explosionShake = 2;
        this.explosionShakeDuration = 60;
        this.explosionRadius = 20;
        this.explosionDamage = 1500;
        this.explodeSound = Sounds.explosionbig;
        this.fuelItem = SCItems.lin;
        this.consumeItem(SCItems.lin, 1);
        this.consumeLiquid(Liquids.water, 0.3f);
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lv, 200, SCItems.li, 150, SCItems.chunguijing, 75, SCItems.xi, 150,
                SCItems.lvgang, 50 }));
      }
    };
    SCPower.nuclear2 = new NuclearReactor("nuclear2") {
      {
        this.size = 3;
        this.health = 4500;
        this.liquidCapacity = 30;
        this.itemCapacity = 20;
        this.hasItems = true;
        this.hasLiquids = true;
        this.outputsPower = true;
        this.powerProduction = 100;
        this.itemDuration = 240;
        this.heating = 0.01f;
        this.lightColor = Color.white;
        this.explosionShake = 2;
        this.explosionShakeDuration = 60;
        this.explosionRadius = 40;
        this.explosionDamage = 5000;
        this.explodeSound = Sounds.explosionbig;
        this.fuelItem = SCItems.you;
        this.consumeItem(SCItems.you, 1);
        this.consumeLiquid(Liquids.cryofluid, 0.2f);
        this.requirements(Category.power,
            ItemStack
                .with(new Object[] { SCItems.lvgang, 200, SCItems.you, 150, SCItems.chunguijing, 350, SCItems.you, 150,
                    SCItems.chijin, 150, SCItems.hejing1, 80 }));
      }
    };
    SCPower.rtg1 = new ConsumeGenerator("rtg1") {
      {
        this.size = 2;
        this.health = 1000;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 8f;
        this.lightRadius = 2.0f;
        this.requirements(Category.power, ItemStack.with(new Object[] { SCItems.lvgang, 70, SCItems.li, 80, SCItems.you,
            50, SCItems.sujiao, 80, SCItems.chunguijing, 50 }));
        this.itemDuration = 120f;
        this.generateEffect = Fx.lightning;
        this.consume(new ConsumeItemRadioactive());
        this.drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
      }
    };
    SCPower.rtg2 = new ConsumeGenerator("rtg2") {
      {
        this.size = 3;
        this.health = 4000;
        this.buildCostMultiplier = 0.9f;
        this.powerProduction = 25f;
        this.lightRadius = 5.0f;
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.lvgang, 100, SCItems.li, 210, SCItems.you,
                120, SCItems.sujiao, 150, SCItems.chunguijing, 200, SCItems.hejing1, 100 }));
        this.itemDuration = 120f;
        this.generateEffect = Fx.lightning;
        this.consume(new ConsumeItemRadioactive());
        this.drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
      }
    };
    SCPower.impact1 = new ImpactReactor("impact1") {
      {
        this.size = 3;
        this.health = 2000;
        this.buildCostMultiplier = 0.8f;
        this.powerProduction = 100f;
        // this.placeableLiquid = true;
        this.itemCapacity = 30;
        this.liquidCapacity = 60;
        this.hasPower = true;
        this.hasLiquids = true;
        this.itemDuration = 120;
        this.warmupSpeed = 0.001f;
        this.explosionRadius = 16;
        this.explosionDamage = 5000;
        this.explodeEffect = Fx.shockwave;
        this.consumeLiquid(Liquids.cryofluid, 0.25f);
        this.consumeItem(SCItems.lin, 2);
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.boli, 200, SCItems.chunguijing, 275, SCItems.feijing, 125,
                SCItems.jin, 145, SCItems.lvgang, 120 }));
      }
    };
    SCPower.impact2 = new ImpactReactor("impact2") {
      {
        this.size = 5;
        this.health = 6000;
        this.buildCostMultiplier = 0.8f;
        this.powerProduction = 400f;
        // this.placeableLiquid = true;
        this.itemCapacity = 30;
        this.liquidCapacity = 60;
        this.hasPower = true;
        this.hasLiquids = true;
        this.itemDuration = 180;
        this.warmupSpeed = 0.0005f;
        this.explosionRadius = 80;
        this.explosionDamage = 20000;
        this.explodeEffect = Fx.shockwave;
        this.consumeLiquids(LiquidStack.with(Liquids.cryofluid, 0.25f, SCLiquids.nengliangliuti, 0.25));
        this.consumeItems(ItemStack.with(SCItems.zhayao, 5, SCItems.gutaineng, 4));
        this.requirements(Category.power,
            ItemStack.with(new Object[] { SCItems.boli, 600, SCItems.jinhuihejin, 250, SCItems.feijing, 225,
                SCItems.gutaineng, 185, SCItems.lvgang, 200, SCItems.hejing2, 200 }));
      }
    };
  }
}
