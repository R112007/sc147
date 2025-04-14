package sc.content;

import sc.content.blocks.SCBlocksEffects;
import sc.content.blocks.SCDistribution;
import sc.content.blocks.SCDrills;
import sc.content.blocks.SCLiquidBlocks;
import sc.content.blocks.SCPower;
import sc.content.blocks.SCTurrets;
import sc.content.blocks.SCWalls;
import sc.graphics.SCPal;
import sc.world.SCAttributes;
import sc.world.blocks.denfence.ReduceBoost;
import sc.world.blocks.distribution.DropDrillItem;

import static sc.content.SCItems.youzao;

import arc.graphics.Color;
import arc.struct.Seq;
import arc.util.Log;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Incinerator;
import mindustry.world.blocks.production.Separator;
import mindustry.world.draw.DrawCultivator;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawLiquidRegion;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.draw.DrawTurret;
import mindustry.world.draw.DrawWeave;
import mindustry.world.meta.Attribute;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;

/** 合晶工业的建筑 */
public class SCBlocks {
  public static Block guicuzhiji;
  public static Block cuzhiganguo;
  public static Block guitichunji;
  public static Block tichunganguo;
  public static Block jingtigongchang;
  public static Block youjiboliji;
  public static Block daxingbolishaozhiji;
  public static Block peiyangji;
  public static Block daxingyouzaopeiyangji;
  public static Block shiyouyasuoji;
  public static Block shiyoulixinji;
  public static Block lintilianji;
  public static Block lintilianji2;
  public static Block lintilianji3;
  public static Block baozhahunheji;
  public static Block lengdongye1;
  public static Block lengdongye2;
  public static Block kuangzharonglianji;
  public static Block feijinghechengji1;
  public static Block feijinghechengji2;
  public static Block feijinghechengji3;
  public static Block feizhafensuiji;
  public static Block hunliji;
  public static Block fenhualu;
  public static Block lvganggongchang1;
  public static Block lvganggongchang2;
  public static Block sujiaoyasuoji;
  public static Block chijingongchang;
  public static Block jinhuihejingongchang1;
  public static Block jinhuihejingongchang2;
  public static Block nengliangyasuoji;
  public static Block nengliangchongyaji;
  public static Block nengliangliutihunheqi;
  public static Block nengliangnongsuoji;
  public static Block ningnengjingyasuoji;
  public static Block hejinggongchang1;
  public static Block hejinggongchang2;
  public static Block hejinggongchang3;
  public static Block hejinggongchang4;
  public static Block cishidaihejinggongchang;
  public static Block tt;
  public static Block t;

  public static void load() {
    SCBlocks.t = new ReduceBoost("t") {
      {
        this.size = 2;
        this.hasPower = true;
        this.consumePower(1f);
        this.requirements(Category.distribution, ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65 }));
      }
    };
    SCTurrets.load();
    SCDistribution.load();
    SCLiquidBlocks.load();
    SCDrills.load();
    Log.info("readya1");
    SCPower.load();
    SCWalls.load();
    Log.info("readya2");
    SCBlocks.guicuzhiji = new GenericCrafter("guicuzhiji") {
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
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
      }
    };
    SCBlocks.cuzhiganguo = new GenericCrafter("cuzhiganguo") {
      {
        this.health = 280;
        this.size = 2;
        this.craftTime = 70.0f;
        this.itemCapacity = 20;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting,
            ItemStack.with(new Object[] { SCItems.lv, 80, SCItems.li, 65, SCItems.xi, 80, SCItems.chunguijing, 30 }));
        this.outputItem = new ItemStack(SCItems.cuguijing, 3);
        this.consumeItems(ItemStack.with(SCItems.lv, 4, SCItems.tandanzhi, 2));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(1.5f);
      }
    };
    SCBlocks.guitichunji = new GenericCrafter("guitichunji") {
      {
        this.health = 210;
        this.size = 2;
        this.craftTime = 60.0f;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting,
            ItemStack.with(new Object[] { SCItems.lv, 75, SCItems.li, 80, SCItems.cuguijing, 35, SCItems.xi, 60 }));
        this.outputItem = new ItemStack(SCItems.chunguijing, 1);
        this.consumeItems(ItemStack.with(SCItems.cuguijing, 2, SCItems.tandanzhi, 1));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(2.0f);
      }
    };
    SCBlocks.tichunganguo = new GenericCrafter("tichunganguo") {
      {
        this.health = 400;
        this.size = 2;
        this.craftTime = 50.0f;
        this.itemCapacity = 20;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack
            .with(new Object[] { SCItems.xi, 175, SCItems.chunguijing, 100, SCItems.lvgang, 80, SCItems.feijing, 60 }));
        this.outputItem = new ItemStack(SCItems.chunguijing, 4);
        this.consumeItems(ItemStack.with(SCItems.cuguijing, 5, SCItems.lin, 3));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(3.5f);
      }
    };
    SCBlocks.jingtigongchang = new GenericCrafter("jingtigongchang") {

      {
        this.health = 850;
        this.size = 2;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 135, SCItems.li, 150, SCItems.xi, 265, SCItems.chunguijing, 150, SCItems.lvgang,
                80 }));
        this.itemCapacity = 20;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.liquidCapacity = 55;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
      }
    };
    SCBlocks.youjiboliji = new GenericCrafter("youjiboliji") {
      {
        this.health = 150;
        this.size = 2;
        this.craftTime = 70.0f;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting,
            ItemStack.with(new Object[] { SCItems.lv, 50, SCItems.li, 60, SCItems.cuguijing, 45 }));
        this.outputItem = new ItemStack(SCItems.boli, 1);
        this.consumeItems(ItemStack.with(SCItems.li, 2));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(1.5f);
      }
    };
    SCBlocks.daxingbolishaozhiji = new GenericCrafter("daxingbolishaozhiji") {
      {
        this.health = 750;
        this.size = 3;
        this.craftTime = 50.0f;
        this.itemCapacity = 20;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.chunguijing, 40, SCItems.lvgang, 60, SCItems.feijing, 45, SCItems.sujiao, 25 }));
        this.outputItem = new ItemStack(SCItems.boli, 3);
        this.consumeItems(ItemStack.with(SCItems.li, 4));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(5.0f);
        this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.peiyangji = new AttributeCrafter("peiyangji") {
      {
        this.health = 160;
        this.size = 2;
        this.craftTime = 120.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 36;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.production,
            ItemStack.with(new Object[] { SCItems.lv, 45, SCItems.li, 45, SCItems.cuguijing, 30, SCItems.boli, 30 }));
        this.outputItem = new ItemStack(SCItems.youzao, 1);
        // this.consumeItems(ItemStack.with(SCItems.lv, 1, SCItems.tandanzhi, 1));
        this.consumePower(1.5f);
        this.consumeLiquid(Liquids.water, 0.4f);
        this.attribute = Attribute.water;
        this.maxBoost = 10.0f;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawCultivator(), new DrawRegion("-top"));
      }
    };
    SCBlocks.daxingyouzaopeiyangji = new AttributeCrafter("daxingyouzaopeiyangji") {
      {
        this.health = 620;
        this.size = 3;
        this.craftTime = 120.0f;
        this.itemCapacity = 20;
        this.liquidCapacity = 80;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.production,
            ItemStack.with(new Object[] { SCItems.lv, 220, SCItems.boli, 120, SCItems.lvgang, 90, SCItems.jin, 60 }));
        this.outputItem = new ItemStack(SCItems.youzao, 4);
        // this.consumeItems(ItemStack.with(SCItems.lv, 1, SCItems.tandanzhi, 1));
        this.consumePower(3.5f);
        this.consumeLiquid(Liquids.water, 0.6f);
        this.attribute = Attribute.water;
        this.maxBoost = 10.0f;
        this.drawer = new DrawMulti(new DrawDefault(), new DrawCultivator(), new DrawRegion("-top"));
      }
    };
    SCBlocks.shiyouyasuoji = new GenericCrafter("shiyouyasuoji") {
      {
        this.health = 350;
        this.size = 2;
        this.craftTime = 20.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 60.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.li, 60, SCItems.chunguijing, 45, SCItems.xi, 35 }));
        // this.outputItem = new ItemStack(SCItems.boli, 3);
        this.outputLiquid = new LiquidStack(Liquids.oil, 0.25f);
        this.consumeItems(ItemStack.with(SCItems.youzao, 1));
        this.drawer = new DrawMulti(new DrawLiquidRegion(Liquids.oil), new DrawDefault(), new DrawRegion("-top"));
        this.consumePower(0.8f);
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.shiyoulixinji = new GenericCrafter("shiyoulixinji") {
      {
        this.health = 280;
        this.size = 2;
        this.craftTime = 30.0f;
        this.itemCapacity = 15;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 80, SCItems.xi, 60, SCItems.chunguijing, 45 }));
        this.outputItem = new ItemStack(SCItems.tandanzhi, 1);
        // this.consumeItems(ItemStack.with(SCItems.li, 4));
        this.drawer = new DrawMulti(new DrawDefault());
        this.consumePower(2.0f);
        this.consumeLiquid(Liquids.oil, 0.15f);
      }
    };
    SCBlocks.lintilianji = new GenericCrafter("lintilianji") {
      {
        this.health = 140;
        this.size = 2;
        this.craftTime = 80.0f;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 80, SCItems.li, 60, SCItems.cuguijing, 45, SCItems.xi, 25 }));
        this.outputItem = new ItemStack(SCItems.lin, 2);
        this.consumeItems(ItemStack.with(SCItems.lv, 2, SCItems.li, 2, SCItems.tandanzhi, 3));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(1.0f);
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.lintilianji2 = new GenericCrafter("lintilianji2") {
      {
        this.health = 580;
        this.size = 3;
        this.craftTime = 60.0f;
        this.itemCapacity = 30;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 200, SCItems.li, 165, SCItems.lvgang, 60, SCItems.chunguijing, 50, SCItems.jin,
                80 }));
        this.outputItem = new ItemStack(SCItems.lin, 5);
        this.consumeItems(ItemStack.with(SCItems.tandanzhi, 8));
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.slag), new DrawDefault(),
            new DrawFlame());
        this.consumePower(7.0f);
        this.consumeLiquid(Liquids.slag, 0.25f);
      }
    };
    SCBlocks.lintilianji3 = new GenericCrafter("lintilianji3") {
      {
        this.health = 1250;
        this.size = 3;
        this.craftTime = 50.0f;
        this.itemCapacity = 50;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.chunguijing, 50, SCItems.lvgang, 60, SCItems.jin, 80, SCItems.gutaineng, 80,
                SCItems.hejing1, 45 }));
        this.outputItem = new ItemStack(SCItems.lin, 7);
        this.consumeItems(ItemStack.with(SCItems.tandanzhi, 10));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(22.0f);
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.baozhahunheji = new GenericCrafter("baozhahunheji") {
      {
        this.health = 180;
        this.size = 2;
        this.craftTime = 60.0f;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.li, 50, SCItems.cuguijing, 60, SCItems.xi, 40 }));
        this.outputItem = new ItemStack(SCItems.zhayao, 2);
        this.consumeItems(ItemStack.with(SCItems.lin, 2, SCItems.youzao, 3));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(2.0f);
        this.craftEffect = Fx.massiveExplosion;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.lengdongye1 = new GenericCrafter("lengdongye1") {
      {
        this.health = 180;
        this.size = 2;
        this.craftTime = 90.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 48.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.li, 85, SCItems.xi, 60, SCItems.cuguijing, 130 }));
        // this.outputItem = new ItemStack(SCItems.lin, 2);
        this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.xi, 1));
        this.consumeLiquid(Liquids.water, 0.45f);
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.cryofluid),
            new DrawDefault());
        this.consumePower(1.3f);
        this.updateEffect = Fx.freezing;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.lengdongye2 = new GenericCrafter("lengdongye2") {
      {
        this.health = 680;
        this.size = 3;
        this.craftTime = 90.0f;
        this.updateEffect = Fx.freezing;
        this.itemCapacity = 20;
        this.liquidCapacity = 108.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.boli, 225, SCItems.xi, 180, SCItems.feijing, 120, SCItems.lvgang, 150, SCItems.you,
                85 }));
        // this.outputItem = new ItemStack(SCItems.lin, 2);
        this.outputLiquid = new LiquidStack(Liquids.cryofluid, 1.0f);
        this.consumeItems(ItemStack.with(SCItems.xi, 4));
        this.consumeLiquid(Liquids.water, 1.2f);
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(Liquids.cryofluid) {
          {
            this.suffix = "-l";
          }
        }, new DrawLiquidRegion(Liquids.water) {
          {
            this.suffix = "-s";
          }
        }, new DrawDefault());
        this.consumePower(5.0f);
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.kuangzharonglianji = new GenericCrafter("kuangzharonglianji") {
      {
        this.health = 100;
        this.size = 1;
        this.craftTime = 20.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 30.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 30, SCItems.li, 30, SCItems.cuguijing, 45 }));
        // this.outputItem = new ItemStack(SCItems.lin, 2);
        this.outputLiquid = new LiquidStack(Liquids.slag, 0.3f);
        this.consumeItems(ItemStack.with(SCItems.feizha, 1));
        // this.consumeLiquid(Liquids.water, 0.45f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawLiquidTile(Liquids.slag));
        this.consumePower(1.1f);
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.feijinghechengji1 = new GenericCrafter("feijinghechengji1") {
      {
        this.health = 340;
        this.size = 3;
        this.craftTime = 60.0f;
        this.itemCapacity = 20;
        // this.liquidCapacity = 48.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 260, SCItems.li, 250, SCItems.cuguijing, 100, SCItems.chunguijing, 80 }));
        this.outputItem = new ItemStack(SCItems.feijing, 2);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.cuguijing, 4, SCItems.feizha, 7));
        // this.consumeLiquid(Liquids.water, 0.45f);
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault(), new DrawDefault());
        this.consumePower(3.5f);
        this.updateEffect = Fx.fuelburn;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.feijinghechengji2 = new GenericCrafter("feijinghechengji2") {
      {
        this.health = 570;
        this.size = 3;
        this.craftTime = 50.0f;
        this.itemCapacity = 30;
        this.liquidCapacity = 48.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.xi, 265, SCItems.lvgang, 135, SCItems.chunguijing, 250, SCItems.feijing, 175,
                SCItems.jin, 80 }));
        this.outputItem = new ItemStack(SCItems.feijing, 5);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.chunguijing, 4, SCItems.feizha, 10));
        this.consumeLiquid(Liquids.water, 0.15f);
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault(), new DrawDefault());
        this.consumePower(10.0f);
        this.updateEffect = Fx.fuelburn;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.feijinghechengji3 = new GenericCrafter("feijinghechengji3") {
      {
        this.health = 1340;
        this.size = 4;
        this.craftTime = 80.0f;
        this.itemCapacity = 30;
        // this.liquidCapacity = 48.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.chunguijing, 100, SCItems.jin, 260, SCItems.you, 250, SCItems.chijin, 80,
                SCItems.hejing1, 40 }));
        this.outputItem = new ItemStack(SCItems.feijing, 8);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.gutaineng, 5));
        // this.consumeLiquid(Liquids.water, 0.45f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawDefault());
        this.consumePower(23.5f);
        this.updateEffect = new ParticleEffect() {
          {
            this.particles = 3;
            this.sizeFrom = 1.5f;
            this.sizeTo = 0.0f;
            this.length = 5.0f;
            this.baseLength = 10;
            this.lifetime = 45.0f;
            this.colorFrom = Color.valueOf("9B928tBFF");
            this.colorTo = Color.valueOf("ffffff");
            this.cone = 360;
          }
        };
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.feizhafensuiji = new GenericCrafter("feizhafensuiji") {
      {
        this.health = 125;
        this.size = 2;
        this.craftTime = 20.0f;
        this.itemCapacity = 10;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 50, SCItems.li, 80, SCItems.cuguijing, 50 }));
        this.outputItem = new ItemStack(SCItems.feizha, 2);
        this.consumeItems(ItemStack.with(SCItems.lv, 1, SCItems.li, 1));
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(1f);
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.hunliji = new Separator("hunliji") {
      {
        this.health = 300;
        this.size = 2;
        this.craftTime = 20.0f;
        this.itemCapacity = 15;
        this.liquidCapacity = 25.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 40, SCItems.cuguijing, 50, SCItems.boli, 40, SCItems.xi, 30 }));
        this.results = ItemStack.with(SCItems.lv, 4, SCItems.cuguijing, 2, SCItems.xi, 1);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        // this.consumeItems(ItemStack.with(SCItems.cuguijing, 4, SCItems.feizha, 7));
        this.consumeLiquid(Liquids.slag, 0.066667f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawLiquidRegion(Liquids.slag),
            new DrawRegion("-spinner", 5));
        this.consumePower(0.65f);
        // this.updateEffect = Fx.fuelburn;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.fenhualu = new Incinerator("fenhualu") {
      {
        this.size = 1;
        this.health = 110;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.consumePower(0.5f);
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 20, SCItems.li, 25 }));
      }
    };
    SCBlocks.lvganggongchang1 = new GenericCrafter("lvganggongchang1") {
      {
        this.health = 510;
        this.size = 2;
        this.craftTime = 80.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 30.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 85, SCItems.li, 70, SCItems.cuguijing, 40, SCItems.xi, 60 }));
        this.outputItem = new ItemStack(SCItems.lvgang, 2);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.lv, 3, SCItems.xi, 2));
        this.consumeLiquid(Liquids.water, 0.1f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawLiquidRegion(), new DrawFlame());
        this.consumePower(2.0f);
        this.updateEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.lvganggongchang2 = new GenericCrafter("lvganggongchang2") {
      {
        this.health = 980;
        this.size = 3;
        this.craftTime = 50.0f;
        this.itemCapacity = 25;
        this.liquidCapacity = 56.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.chunguijing, 85, SCItems.xi, 210, SCItems.lvgang, 130, SCItems.you, 60 }));
        this.outputItem = new ItemStack(SCItems.lvgang, 6);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.lv, 6, SCItems.xi, 4));
        this.consumeLiquid(Liquids.water, 0.4f);
        this.drawer = new DrawMulti(new DrawDefault());
        this.consumePower(5.5f);
        this.updateEffect = Fx.freezing;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.sujiaoyasuoji = new GenericCrafter("sujiaoyasuoji") {
      {
        this.health = 420;
        this.size = 2;
        this.craftTime = 50.0f;
        this.itemCapacity = 20;
        this.liquidCapacity = 36.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.li, 140, SCItems.xi, 70, SCItems.chunguijing, 80, SCItems.jin, 30 }));
        this.outputItem = new ItemStack(SCItems.sujiao, 2);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.lvgang, 3));
        this.consumeLiquid(Liquids.oil, 0.3f);
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault(), new DrawWeave());
        this.consumePower(5.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.shieldApply;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.chijingongchang = new GenericCrafter("chijingongchang") {
      {
        this.health = 420;
        this.size = 3;
        this.craftTime = 55.0f;
        this.itemCapacity = 20;
        // this.liquidCapacity = 36.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 60, SCItems.jin, 70, SCItems.sujiao, 80, SCItems.you, 30 }));
        this.outputItem = new ItemStack(SCItems.chijin, 2);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(ItemStack.with(SCItems.jin, 3, SCItems.lin, 2));
        // this.consumeLiquid(Liquids.oil, 0.3f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(5.8f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.jinhuihejingongchang1 = new GenericCrafter("jinhuihejingongchang1") {
      {
        this.health = 470;
        this.size = 3;
        this.craftTime = 85.0f;
        this.itemCapacity = 20;
        // this.liquidCapacity = 36.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 280, SCItems.jin, 80, SCItems.you, 80, SCItems.feijing, 80, SCItems.lvgang, 150,
                SCItems.chunguijing, 80, SCItems.gutaineng, 10 }));
        this.outputItem = new ItemStack(SCItems.jinhuihejin, 1);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(
            ItemStack.with(SCItems.lvgang, 4, SCItems.feijing, 3, SCItems.chijin, 3, SCItems.gutaineng, 2));
        // this.consumeLiquid(Liquids.oil, 0.3f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(8f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.jinhuihejingongchang2 = new GenericCrafter("jinhuihejingongchang2") {
      {
        this.health = 3000;
        this.size = 4;
        this.craftTime = 60.0f;
        this.itemCapacity = 40;
        // this.liquidCapacity = 36.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 2000, SCItems.jin, 700, SCItems.you, 950, SCItems.feijing, 800, SCItems.lvgang,
                700,
                SCItems.chunguijing, 80, SCItems.chijin, 550, SCItems.hejing2, 120, SCItems.ningnengjing, 80 }));
        this.outputItem = new ItemStack(SCItems.jinhuihejin, 5);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        this.consumeItems(
            ItemStack.with(SCItems.lvgang, 12, SCItems.feijing, 12, SCItems.chijin, 8, SCItems.gutaineng, 6));
        // this.consumeLiquid(Liquids.oil, 0.3f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(20.0f);
        this.updateEffect = Fx.smeltsmoke;
        this.craftEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.nengliangyasuoji = new AttributeCrafter("nengliangyasuoji") {
      {
        this.health = 620;
        this.size = 2;
        this.craftTime = 180.0f;
        this.itemCapacity = 10;
        // this.liquidCapacity = 36.0f;
        this.attribute = SCAttributes.underpower;
        this.maxBoost = 3.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.xi, 80, SCItems.feijing, 65, SCItems.you, 60, SCItems.lvgang, 60 }));
        this.outputItem = new ItemStack(SCItems.gutaineng, 1);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        /*
         * this.consumeItems(
         * ItemStack.with(SCItems.lvgang, 4, SCItems.feijing, 3, SCItems.chijin, 3,
         * SCItems.gutaineng, 2));
         * // this.consumeLiquid(Liquids.oil, 0.3f);
         */
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(30.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.nengliangchongyaji = new AttributeCrafter("nengliangchongyaji") {
      {
        this.health = 1420;
        this.size = 3;
        this.craftTime = 180.0f;
        this.itemCapacity = 20;
        // this.liquidCapacity = 36.0f;
        this.attribute = SCAttributes.underpower;
        this.maxBoost = 5.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = false;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.jin, 80, SCItems.hejing1, 65, SCItems.gutaineng, 60, SCItems.hejing2, 15 }));
        this.outputItem = new ItemStack(SCItems.gutaineng, 3);
        // this.outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
        /*
         * this.consumeItems(
         * ItemStack.with(SCItems.lvgang, 4, SCItems.feijing, 3, SCItems.chijin, 3,
         * SCItems.gutaineng, 2));
         * // this.consumeLiquid(Liquids.oil, 0.3f);
         */
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(30.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.nengliangliutihunheqi = new GenericCrafter("nengliangliutihunheqi") {
      {
        this.health = 620;
        this.size = 2;
        this.craftTime = 100.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 36.0f;
        // this.attribute = Attributes.underpower;
        // this.maxBoost = 3.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lvgang, 80, SCItems.feijing, 85, SCItems.jin, 80, SCItems.gutaineng, 15 }));
        // this.outputItem = new ItemStack(SCItems.gutaineng, 1);
        this.outputLiquid = new LiquidStack(SCLiquids.nengliangliuti, 0.3f);

        this.consumeItems(
            ItemStack.with(SCItems.gutaineng, 1));
        this.consumeLiquid(Liquids.water, 0.6f);

        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(SCLiquids.nengliangliuti),
            new DrawDefault());
        this.consumePower(9.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
        // this.consumeLiquid(Liquids.water, 0.25f);
      }
    };
    SCBlocks.nengliangnongsuoji = new GenericCrafter("nengliangnongsuoji") {
      {
        this.health = 1250;
        this.size = 3;
        this.craftTime = 80.0f;
        this.itemCapacity = 20;
        this.liquidCapacity = 36.0f;
        // this.attribute = Attributes.underpower;
        // this.maxBoost = 3.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.li, 230, SCItems.chunguijing, 120, SCItems.sujiao, 80, SCItems.ningnengjing, 10,
                SCItems.hejing2, 25 }));
        // this.outputItem = new ItemStack(SCItems.ningnengjing, 1);
        this.outputLiquid = new LiquidStack(SCLiquids.nongsuonengliangliuti, 0.2f);

        this.consumeItems(
            ItemStack.with(SCItems.gutaineng, 3, SCItems.ningnengjing, 1));
        this.consumeLiquid(SCLiquids.nengliangliuti, 0.4f);

        this.drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-top"));
        this.consumePower(30.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
      }
    };
    SCBlocks.ningnengjingyasuoji = new GenericCrafter("ningnengjingyasuoji") {
      {
        this.health = 620;
        this.size = 3;
        this.craftTime = 80.0f;
        this.itemCapacity = 20;
        this.liquidCapacity = 36.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.chunguijing, 80, SCItems.feijing, 140, SCItems.jin, 60, SCItems.hejing1, 60,
                SCItems.gutaineng, 40 }));
        this.outputItem = new ItemStack(SCItems.ningnengjing, 1);
        this.consumeItems(
            ItemStack.with(SCItems.gutaineng, 3));
        this.consumeLiquid(SCLiquids.nengliangliuti, 0.4f);
        this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault(), new DrawWeave());
        this.consumePower(40.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.shieldApply;
      }
    };
    SCBlocks.hejinggongchang1 = new GenericCrafter("hejinggongchang1") {
      {
        this.health = 850;
        this.size = 2;
        this.craftTime = 110.0f;
        this.itemCapacity = 10;
        this.liquidCapacity = 36.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.lv, 135, SCItems.li, 160, SCItems.jin, 100, SCItems.chunguijing, 140,
                SCItems.gutaineng, 15 }));
        this.outputItem = new ItemStack(SCItems.hejing1, 1);
        this.consumeItems(
            ItemStack.with(SCItems.jinhuihejin, 2, SCItems.chijin, 3));
        this.consumeLiquid(SCLiquids.nengliangliuti, 0.05f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(2.5f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
      }
    };
    SCBlocks.hejinggongchang2 = new GenericCrafter("hejinggongchang2") {
      {
        this.health = 1850;
        this.size = 3;
        this.craftTime = 90.0f;
        this.itemCapacity = 20;
        this.liquidCapacity = 45.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.chunguijing, 165, SCItems.feijing, 85, SCItems.chijin, 100, SCItems.hejing1, 140,
                SCItems.gutaineng, 40 }));
        this.outputItem = new ItemStack(SCItems.hejing2, 1);
        this.consumeItems(
            ItemStack.with(SCItems.jinhuihejin, 3, SCItems.chijin, 4, SCItems.gutaineng, 4, SCItems.hejing1, 3));
        this.consumeLiquid(SCLiquids.nengliangliuti, 0.3f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(6.0f);
        this.updateEffect = Fx.none;
        this.craftEffect = Fx.none;
      }
    };
    SCBlocks.hejinggongchang3 = new GenericCrafter("hejinggongchang3") {
      {
        this.health = 2560;
        this.size = 4;
        this.craftTime = 360.0f;
        this.itemCapacity = 30;
        this.liquidCapacity = 86.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.hejing1, 260, SCItems.li, 500, SCItems.chijin, 300, SCItems.ningnengjing, 20,
                SCItems.hejing2, 65 }));
        this.outputItem = new ItemStack(SCItems.hejing3, 1);
        this.consumeItems(
            ItemStack.with(SCItems.jinhuihejin, 60, SCItems.hejing1, 50, SCItems.hejing2, 20, SCItems.ningnengjing,
                30));
        this.consumeLiquid(SCLiquids.nongsuonengliangliuti, 0.05f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(15.0f);
        this.updateEffect = new ParticleEffect() {
          {
            this.particles = 7;
            this.sizeFrom = 2.0f;
            this.sizeTo = 0.0f;
            this.length = 20.0f;
            this.baseLength = 30.0f;
            this.lifetime = 60.0f;
            this.colorFrom = Color.valueOf("#ff9900");
            this.colorTo = Color.valueOf("#ffffff");
            this.cone = 360.0f;
          }
        };
        this.craftEffect = Fx.none;
      }
    };
    SCBlocks.hejinggongchang4 = new GenericCrafter("hejinggongchang4") {
      {
        this.health = 5860;
        this.size = 5;
        this.craftTime = 2400.0f;
        this.itemCapacity = 900;
        this.liquidCapacity = 300.0f;
        this.hasItems = true;
        this.hasPower = true;
        this.hasLiquids = true;
        this.requirements(Category.crafting, ItemStack.with(
            new Object[] { SCItems.hejing1, 650, SCItems.hejing2, 200, SCItems.chijin, 1200, SCItems.ningnengjing, 750,
                SCItems.hejing3, 80, SCItems.sujiao, 700, SCItems.jinhuihejin, 800 }));
        this.outputItem = new ItemStack(SCItems.hejing3, 1);
        this.consumeItems(
            ItemStack.with(SCItems.hejing1, 650, SCItems.hejing2, 200, SCItems.chijin, 1200, SCItems.ningnengjing, 750,
                SCItems.hejing3, 80, SCItems.sujiao, 700, SCItems.jinhuihejin, 800));
        this.consumeLiquid(SCLiquids.nongsuonengliangliuti, 0.5f);
        this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
        this.consumePower(15.0f);
        this.updateEffect = new MultiEffect(
            new ParticleEffect() {
              {
                this.particles = 12;
                this.sizeFrom = 4.0f;
                this.sizeTo = 0.0f;
                this.length = 40.0f;
                this.baseLength = 60.0f;
                this.lifetime = 60.0f;
                this.colorFrom = Color.valueOf("AC00FFFF");
                this.colorTo = Color.valueOf("#ffffff");
                this.cone = 360.0f;
              }
            },
            new WaveEffect() {
              {
                this.sizeFrom = 120.0f;
                this.sizeTo = 0.0f;
                this.lifetime = 60.0f;
                this.sides = 4;
                this.colorTo = Color.valueOf("AC00FFFF");
                this.colorFrom = Color.valueOf("AC00FFFF");
                this.strokeTo = 0.0f;
                this.sizeFrom = 4.0f;
              }
            });
        this.craftEffect = Fx.none;
      }
    };
    SCBlocksEffects.load();
  }
}
