package sc.content;

import static mindustry.content.TechTree.*;
import static sc.content.SCBlocks.*;
import static sc.content.LxMaps.*;
import static sc.content.blocks.SCPower.*;
import static sc.content.blocks.SCWalls.*;
import static sc.content.blocks.SCTurrets.*;
import static sc.content.blocks.SCDrills.*;
import static sc.content.blocks.SCLiquidBlocks.*;
import static sc.content.blocks.SCDistribution.*;
import static sc.content.blocks.SCBlocksEffects.*;

import arc.struct.Seq;
import arc.util.Log;
import mindustry.content.Liquids;
import mindustry.game.Objectives.Research;
import mindustry.game.Objectives.SectorComplete;
import mindustry.type.ItemStack;

import static sc.content.SCItems.*;
import static sc.content.SCUnits.*;
import static sc.content.SCLiquids.*;

public class LxTechTree {
  public static void load() {
    SCPlanets.lx.techTree = nodeRoot("lx", core1, () -> {
      node(jianglindian, () -> {
        node(baoziliegu, Seq.with(new SectorComplete(jianglindian)), () -> {
        });
      });
      node(lvconveyor, () -> {
        node(lvlianjieqi, () -> {
          node(lvluyouqi, () -> {
            node(lvrongqi, () -> {
              node(weicang, () -> {
                node(juxingcang, () -> {
                });
              });
              node(lvunloader, () -> {
              });
            });
            node(lvbridge, () -> {
              node(dropdrill1, () -> {
              });
            });
            node(lvyiliumeng, () -> {
              node(lvfanxiangyiliumeng, () -> {
              });
            });
            node(lvfenleiqi, () -> {
              node(lvfanxiangfenleiqi, () -> {
              });
            });
            node(lvfenpeiqi, () -> {
            });
          });
        });
      });
      node(danguanpao, ItemStack.with(lv, 80), () -> {
        node(duoguanpao, Seq.with(new SectorComplete(jianglindian)), () -> {
        });
        node(zhentian, ItemStack.with(lv, 200, li, 200), () -> {
        });
        node(lvwall1, () -> {
          node(lvwall4, ItemStack.with(cuowu, 1), () -> {
            node(xiwall4, () -> {
              node(lvgangwall4, () -> {
                node(jinwall4, () -> {
                  node(chijinwall, () -> {
                    node(hejingwall1, () -> {
                      node(hejingwall2, () -> {
                        node(hejingwall3, () -> {
                        });
                      });
                    });
                  });
                });
              });
            });
          });
          node(lvwall2, () -> {
            node(lvwall3, () -> {
            });
          });
          node(xiwall1, () -> {
            node(xiwall2, () -> {
              node(xiwall3, () -> {
              });
            });
            node(lvgangwall1, () -> {
              node(lvgangwall2, () -> {
                node(lvgangwall3, () -> {
                });
              });
              node(jinwall1, () -> {
                node(jinwall2, () -> {
                  node(jinwall3, () -> {
                  });
                });
              });
            });
          });
          node(door1, () -> {
            node(door2, () -> {
            });
          });
        });
      });
      Log.info("ready1");
      node(lvdrill, ItemStack.with(lv, 50), () -> {
        node(beng1, () -> {
          node(lvdaoguan, () -> {
            node(lvyetijiaochaqi, () -> {
              node(lvyetiluyouqi, () -> {
                node(yetichuguan, () -> {
                  node(shuixiang, () -> {
                  });
                });
                node(lvdaoguanqiao, () -> {
                  node(xidaoguanqiao, () -> {
                  });
                });
              });
            });
            node(xidaoguan, () -> {
            });
          });
          node(beng2, () -> {
            node(beng3, () -> {
              node(beng4, () -> {
              });
            });
          });
        });
        node(powernode1, () -> {
          node(firepower1, Seq.with(new Research(tandanzhi)), () -> {
            node(qilunji, Seq.with(new SectorComplete(baoziliegu)), () -> {
            });
          });
          node(xiuliqi, () -> {
          });
          node(battery1, () -> {
          });
          node(sun1, () -> {
          });
        });
        node(guijingdrill, () -> {
          node(guijingdrill2, () -> {
            node(jindrill, () -> {
            });
          });
        });
        Log.info("ready2");
        node(guicuzhiji, () -> {
          node(cuzhiganguo, () -> {
          });
          Log.info("readyb1");
          node(lintilianji, () -> {
            node(baozhahunheji, () -> {
            });
            node(lintilianji2, () -> {
              node(lintilianji3, () -> {
              });
            });
          });
          Log.info("ready3");
          node(guitichunji, () -> {
            node(lvganggongchang1, () -> {
              node(nengliangyasuoji, () -> {
                node(jinhuihejingongchang1, () -> {
                  node(jinhuihejingongchang2, () -> {
                  });
                });
                Log.info("ready4");
                node(chijingongchang, () -> {
                });
                node(hejinggongchang1, () -> {
                  node(hejinggongchang2, () -> {
                    node(hejinggongchang3, () -> {
                      node(hejinggongchang4, () -> {
                      });
                    });
                  });
                });
                Log.info("ready5");
                node(nengliangliutihunheqi, () -> {
                  node(nengliangnongsuoji, () -> {
                  });
                });
                node(nengliangchongyaji, () -> {
                });
              });
              Log.info("ready6");
              node(sujiaoyasuoji, () -> {
              });
              node(lvganggongchang2, () -> {
              });
            });
            node(hunliji, () -> {
            });
            node(tichunganguo, () -> {
            });
            node(feijinghechengji1, () -> {
              node(feijinghechengji2, () -> {
                node(feijinghechengji3, () -> {
                });
              });
              Log.info("ready7");
              node(feizhafensuiji, () -> {
                Log.info("readyc1");
              });
            });
          });
          node(lengdongye1, () -> {
            Log.info("readyc2");
            node(lengdongye2, () -> {
              Log.info("readyc3");
            });
          });
          node(kuangzharonglianji, () -> {
            Log.info("readyc4");
            node(fenhualu, () -> {
              Log.info("readyc5");
            });
          });
          node(youjiboliji, () -> {
            Log.info("readyc6");
            node(daxingbolishaozhiji, () -> {
              Log.info("readyc7");
            });
            Log.info("ready8");
            node(peiyangji, () -> {
              node(shiyouyasuoji, () -> {
                node(shiyoulixinji, () -> {
                });
              });
              node(daxingyouzaopeiyangji, () -> {
              });
            });
          });
        });
      });
      Log.info("ready9");
      nodeProduce(lv, () -> {
        nodeProduce(Liquids.water, () -> {
          nodeProduce(youzao, () -> {
          });
        });
        nodeProduce(feizha, () -> {
          nodeProduce(Liquids.slag, () -> {
          });
        });
        Log.info("a1");
        nodeProduce(li, () -> {
          nodeProduce(cuguijing, () -> {
            nodeProduce(feijing, () -> {
              nodeProduce(gutaineng, () -> {
                nodeProduce(nengliangliuti, () -> {
                });
                Log.info("a2");
                nodeProduce(ningnengjing, () -> {
                  nodeProduce(nongsuonengliangliuti, () -> {
                  });
                });
              });
            });
            nodeProduce(chunguijing, () -> {
            });
            nodeProduce(xi, () -> {
              Log.info("a3");
              nodeProduce(Liquids.cryofluid, () -> {
              });
              nodeProduce(jin, () -> {
                nodeProduce(chijin, () -> {
                });
                nodeProduce(you, () -> {
                });
                nodeProduce(jinhuihejin, () -> {
                  Log.info("a4");
                  nodeProduce(hejing1, () -> {
                    nodeProduce(hejing2, () -> {
                      nodeProduce(hejing3, () -> {
                        nodeProduce(hejing4, () -> {
                          nodeProduce(hejing5, () -> {
                            Log.info("a5");
                          });
                        });
                      });
                    });
                  });
                });
              });
              nodeProduce(lvgang, () -> {
                nodeProduce(Liquids.oil, () -> {
                });
                nodeProduce(sujiao, () -> {
                });
              });
            });
          });
          Log.info("a6");
          nodeProduce(tandanzhi, () -> {
            nodeProduce(lin, () -> {
              nodeProduce(zhayao, () -> {
              });
            });
          });
          nodeProduce(boli, () -> {
            Log.info("a7");
          });
        });
      });
    });
  }
}
