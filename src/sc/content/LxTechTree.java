package sc.content;

import static mindustry.content.TechTree.*;
import static sc.content.SCBlocks.*;
import static sc.content.LxMaps.*;
import static sc.content.blocks.SCTurrets.*;
import static sc.content.blocks.SCDrills.*;
import static sc.content.blocks.SCUnitBlocks.*;
import static sc.content.blocks.SCLiquidBlocks.*;
import static sc.content.blocks.SCDistribution.*;

import arc.struct.Seq;
import arc.util.Log;
import mindustry.content.Liquids;
import mindustry.game.Objectives.Research;
import mindustry.game.Objectives.SectorComplete;
import mindustry.type.ItemStack;
import sc.content.blocks.SCBlocksEffects;
import sc.content.blocks.SCPower;
import sc.content.blocks.SCWalls;


public class LxTechTree {
  public static void load() {
    SCPlanets.lx.techTree = nodeRoot("lx", SCBlocksEffects.core1, () -> {
      node(airfactory, () -> {
        node(SCUnits.liekong1, () -> {
        });
        node(SCUnits.miner1, () -> {
        });
      });
      node(jianglindian, () -> {
        node(baoziliegu, Seq.with(new SectorComplete(jianglindian)), () -> {
        node(jiaocuolianfeng, Seq.with(new SectorComplete(baoziliegu)), () -> {
        });
        });
      });
      node(lvconveyor, () -> {
        node(lvlianjieqi, () -> {
          node(lvluyouqi, () -> {
            node(SCBlocksEffects.lvrongqi, () -> {
              node(SCBlocksEffects.weicang, () -> {
                node(SCBlocksEffects.juxingcang, () -> {
                });
              });
              node(SCBlocksEffects.lvunloader, () -> {
              });
            });
            node(lvbridge, () -> {
              node(xiconveyor, () -> {
                node(feijingconveyor, () -> {
                  node(sujiaoconveyor, () -> {
                    node(thickconveyor, () -> {
                    });
                  });
                });
                node(chijinconveyor, () -> {
                  node(armorchijinconveyor, () -> {
                  });
                });
                node(armorxiconveyor, () -> {
                });
              });
              node(xibridge, () -> {
                node(massdriver1, () -> {
                  node(massdriver2, () -> {
                  });
                });
                node(chijinbridge, () -> {
                });
              });
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
              node(lvfenliuqi, () -> {
              });
            });
          });
        });
      });
      node(danguanpao, ItemStack.with(SCItems.lv, 80), () -> {
        node(duoguanpao, Seq.with(new SectorComplete(jianglindian)), () -> {
          node(liuxing, () -> {
          node(tujin1, () -> {
          });
          });
        });
        node(zhentian, ItemStack.with(SCItems.lv, 200, SCItems.li, 200), () -> {
        });
        node(SCWalls.lvwall1, () -> {
          node(SCWalls.lvwall4, ItemStack.with(SCItems.cuowu, 1), () -> {
            node(SCWalls.xiwall4, () -> {
              node(SCWalls.lvgangwall4, () -> {
                node(SCWalls.jinwall4, () -> {
                  node(SCWalls.chijinwall, () -> {
                    node(SCWalls.hejingwall1, () -> {
                      node(SCWalls.hejingwall2, () -> {
                        node(SCWalls.hejingwall3, () -> {
                        });
                      });
                    });
                  });
                });
              });
            });
          });
          node(SCWalls.lvwall2, () -> {
            node(SCWalls.lvwall3, () -> {
            });
          });
          node(SCWalls.xiwall1, () -> {
            node(SCWalls.xiwall2, () -> {
              node(SCWalls.xiwall3, () -> {
              });
            });
            node(SCWalls.lvgangwall1, () -> {
              node(SCWalls.lvgangwall2, () -> {
                node(SCWalls.lvgangwall3, () -> {
                });
              });
              node(SCWalls.jinwall1, () -> {
                node(SCWalls.jinwall2, () -> {
                  node(SCWalls.jinwall3, () -> {
                  });
                });
              });
            });
          });
          node(SCWalls.door1, () -> {
            node(SCWalls.door2, () -> {
            });
          });
        });
      });
      Log.info("ready1");
      node(lvdrill, ItemStack.with(SCItems.lv, 50), () -> {
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
        node(SCPower.powernode1, () -> {
          node(SCPower.firepower1, Seq.with(new Research(SCItems.tandanzhi)), () -> {
            node(SCPower.qilunji, Seq.with(new SectorComplete(baoziliegu)), () -> {
            });
          });
          node(SCBlocksEffects.xiuliqi, () -> {
          });
          node(SCPower.battery1, () -> {
          });
          node(SCPower.sun1,Seq.with(new SectorComplete(jianglindian)), () -> {
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
      nodeProduce(SCItems.lv, () -> {
        nodeProduce(Liquids.water, () -> {
          nodeProduce(SCItems.youzao, () -> {
          });
        });
        nodeProduce(SCItems.feizha, () -> {
          nodeProduce(Liquids.slag, () -> {
          });
        });
        Log.info("a1");
        nodeProduce(SCItems.li, () -> {
          nodeProduce(SCItems.cuguijing, () -> {
            nodeProduce(SCItems.feijing, () -> {
              nodeProduce(SCItems.gutaineng, () -> {
                nodeProduce(SCLiquids.nengliangliuti, () -> {
                });
                Log.info("a2");
                nodeProduce(SCItems.ningnengjing, () -> {
                  nodeProduce(SCLiquids.nongsuonengliangliuti, () -> {
                  });
                });
              });
            });
            nodeProduce(SCItems.chunguijing, () -> {
            });
            nodeProduce(SCItems.xi, () -> {
              Log.info("a3");
              nodeProduce(Liquids.cryofluid, () -> {
              });
              nodeProduce(SCItems.jin, () -> {
                nodeProduce(SCItems.chijin, () -> {
                });
                nodeProduce(SCItems.you, () -> {
                });
                nodeProduce(SCItems.jinhuihejin, () -> {
                  Log.info("a4");
                  nodeProduce(SCItems.hejing1, () -> {
                    nodeProduce(SCItems.hejing2, () -> {
                      nodeProduce(SCItems.hejing3, () -> {
                        nodeProduce(SCItems.hejing4, () -> {
                          nodeProduce(SCItems.hejing5, () -> {
                            Log.info("a5");
                          });
                        });
                      });
                    });
                  });
                });
              });
              nodeProduce(SCItems.lvgang, () -> {
                nodeProduce(Liquids.oil, () -> {
                });
                nodeProduce(SCItems.sujiao, () -> {
                });
              });
            });
          });
          Log.info("a6");
          nodeProduce(SCItems.tandanzhi, () -> {
            nodeProduce(SCItems.lin, () -> {
              nodeProduce(SCItems.zhayao, () -> {
              });
            });
          });
          nodeProduce(SCItems.boli, () -> {
            Log.info("a7");
          });
        });
      });
    });
  }
}
