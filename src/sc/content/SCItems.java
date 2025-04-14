
package sc.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;
import sc.graphics.SCPal;
import sc.type.SCItemType;
import sc.type.SCchangeitem;

public class SCItems {
  public static Item lv;
  public static Item li;
  public static Item feizha;
  public static Item tandanzhi;
  public static Item cuguijing;
  public static Item chunguijing;
  public static Item feijing;
  public static Item boli;
  public static Item lin;
  public static Item youzao;
  public static Item zhayao;
  public static Item xi;
  public static Item jin;
  public static Item chijin;
  public static Item you;
  public static Item lvgang;
  public static Item sujiao;
  public static Item gutaineng;
  public static Item ningnengjing;
  public static Item jinhuihejin;
  public static Item hejing1;
  public static Item hejing2;
  public static Item hejing3;
  public static Item hejing4;
  public static Item hejing5;
  public static Item cuowu;
  public static Item gao;
  public static Item gai;
  public static Item huangyu;
  public static Item zhiwu;
  public static Item mutan;
  public static Item ningjiao;
  public static Item tuoerman;
  public static Item xin;
  public static Item a;
  public static final Seq lxitems = new Seq();
  public static final Seq hzritems = new Seq();

  public static void load() {
    SCItems.a = new SCchangeitem("a", SCPal.blue1);
    SCItems.lv = new SCItemType("lv", Color.valueOf("#E5F0E8")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.li = new SCItemType("li", Color.valueOf("#E5F0E8")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.feizha = new SCItemType("feizha", Color.valueOf("#cccccc")) {
      {
        this.hardness = 2;
        this.cost = 1.5f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.1f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.tandanzhi = new SCItemType("tandanzhi", Color.valueOf("#000000")) {
      {
        this.hardness = 2;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 1.2f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.2f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.cuguijing = new SCItemType("cuguijing", Color.valueOf("#E5F0E8")) {
      {
        this.hardness = 1;
        this.cost = 1.8f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 1.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.chunguijing = new SCItemType("chunguijing", Color.valueOf("#E5F0E8")) {
      {
        this.hardness = 1;
        this.cost = 5.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 3.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.feijing = new SCItemType("feijing", Color.valueOf("DEDEDEFF")) {
      {
        this.hardness = 1;
        this.cost = 4.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 6.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.boli = new SCItemType("boli", Color.valueOf("#ffffff")) {
      {
        this.hardness = 1;
        this.cost = 2.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.8f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.lin = new SCItemType("lin", Color.valueOf("#E5F0E8")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 4.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.6f;
        this.explosiveness = 0.6f;
      }
    };
    SCItems.youzao = new SCItemType("youzao", Color.valueOf("#434343")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 1.5f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.1f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.zhayao = new SCItemType("zhayao", Color.valueOf("#ff0000")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.5f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.3f;
        this.explosiveness = 2.0f;
      }
    };
    SCItems.xi = new Item("xi", Color.valueOf("#00ffff")) {
      {
        this.hardness = 3;
        this.cost = 5.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.jin = new SCItemType("jin", Color.valueOf("#ffff00")) {
      {
        this.hardness = 4;
        this.cost = 7.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 2.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.chijin = new SCItemType("chijin", Color.valueOf("#ff9900")) {
      {
        this.hardness = 7;
        this.cost = 10.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 8.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.you = new SCItemType("you", Color.valueOf("#d9d9d9")) {
      {
        this.hardness = 4;
        this.cost = 7.0f;
        this.radioactivity = 1.5f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 3.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.lvgang = new SCItemType("lvgang", Color.valueOf("#a8c1eb")) {
      {
        this.hardness = 1;
        this.cost = 6.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 2.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.sujiao = new SCItemType("sujiao", Color.valueOf("#25e79d")) {
      {
        this.hardness = 1;
        this.cost = 5.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 3.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.gutaineng = new SCItemType("gutaineng", Color.valueOf("#4a86e8")) {
      {
        this.hardness = 8;
        this.cost = 8.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 5.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.ningnengjing = new SCItemType("ningnengjing", Color.valueOf("#4a86e8")) {
      {
        this.hardness = 1;
        this.cost = 11.5f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 10.0f;
        this.explosiveness = 0.0f;
        this.frames = 4;
        this.transitionFrames = 3;
        this.frameTime = 3.0f;
      }
    };
    SCItems.jinhuihejin = new SCItemType("jinhuihejin", Color.valueOf("#ffde00")) {
      {
        this.hardness = 8;
        this.cost = 8.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 2.0f;
        this.crystalEnergy = 8.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.hejing1 = new SCItemType("hejing1", Color.valueOf("#4a86e8")) {
      {
        this.hardness = 1;
        this.cost = 5.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 1.0f;
        this.crystalEnergy = 9.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.hejing2 = new SCItemType("hejing2", Color.valueOf("#ff0000")) {
      {
        this.hardness = 1;
        this.cost = 10.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 5.0f;
        this.crystalEnergy = 20.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.hejing3 = new SCItemType("hejing3", Color.valueOf("#ffde00")) {
      {
        this.hardness = 1;
        this.cost = 15.0f;
        this.radioactivity = 3.0f;
        this.flammability = 0.0f;
        this.charge = 10.0f;
        this.crystalEnergy = 30.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.hejing4 = new SCItemType("hejing4", Color.valueOf("#9900ff")) {
      {
        this.hardness = 1;
        this.cost = 60.0f;
        this.radioactivity = 10.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 40.0f;
        this.explosiveness = 30.0f;
      }
    };
    SCItems.hejing5 = new SCItemType("hejing5", Color.valueOf("#114514")) {
      {
        this.hardness = 1;
        this.cost = 7200.0f;
        this.radioactivity = 60.0f;
        this.flammability = 0.0f;
        this.charge = 100.0f;
        this.crystalEnergy = 100.0f;
        this.explosiveness = 0.0f;
        this.frames = 14;
        this.transitionFrames = 8;
        this.frameTime = 5.0f;
      }
    };
    SCItems.cuowu = new SCItemType("cuowu", Color.valueOf("#123456")) {
      {
        this.hardness = 0;
        this.cost = 0.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 10000000.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.gao = new SCItemType("gao", Color.valueOf("0A72F2FF")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.gai = new SCItemType("gai", Color.valueOf("#E5F0E8")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.huangyu = new SCItemType("huangyu", Color.valueOf("FFC400FF")) {
      {
        this.hardness = 2;
        this.cost = 3.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 1.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.zhiwu = new SCItemType("zhiwu", Color.valueOf("0DFF00FF")) {
      {
        this.hardness = 3;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.8f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.1f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.mutan = new SCItemType("mutan", Color.valueOf("#0000000")) {
      {
        this.hardness = 3;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 1.8f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.2f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.ningjiao = new SCItemType("ningjiao", Color.valueOf("A3D359FF")) {
      {
        this.hardness = 1;
        this.cost = 1.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 0.2f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.tuoerman = new SCItemType("tuoerman", Color.valueOf("99F8FFFF")) {
      {
        this.hardness = 1;
        this.cost = 4.0f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 1.5f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.xin = new SCItemType("xin", Color.valueOf("8598BFFF")) {
      {
        this.hardness = 3;
        this.cost = 3.5f;
        this.radioactivity = 0.0f;
        this.flammability = 0.0f;
        this.charge = 0.0f;
        this.crystalEnergy = 2.0f;
        this.explosiveness = 0.0f;
      }
    };
    SCItems.lxitems.addAll(SCItems.lv, SCItems.li, SCItems.tandanzhi, SCItems.cuguijing, SCItems.chunguijing,
        SCItems.feijing, SCItems.boli, SCItems.lin, SCItems.youzao, SCItems.zhayao, SCItems.xi, SCItems.jin,
        SCItems.chijin, SCItems.you, SCItems.lvgang, SCItems.sujiao, SCItems.gutaineng, SCItems.ningnengjing,
        SCItems.jinhuihejin, SCItems.hejing1, SCItems.hejing2, SCItems.hejing4, SCItems.hejing5);
    SCItems.hzritems.addAll(new Item[] {
        SCItems.gao, SCItems.gai, SCItems.huangyu, SCItems.zhiwu, SCItems.tandanzhi, SCItems.ningjiao, SCItems.tuoerman,
        SCItems.xin
    });
  }
}
