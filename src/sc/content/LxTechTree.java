package sc.content;

import static mindustry.content.TechTree.*;

import arc.struct.Seq;
import arc.util.Log;
import mindustry.content.Liquids;
import mindustry.game.Objectives.Research;
import mindustry.game.Objectives.SectorComplete;
import mindustry.type.ItemStack;
import sc.content.blocks.SCBlocksEffects;
import sc.content.blocks.SCDistribution;
import sc.content.blocks.SCDrills;
import sc.content.blocks.SCLiquidBlocks;
import sc.content.blocks.SCLogic;
import sc.content.blocks.SCPower;
import sc.content.blocks.SCTurrets;
import sc.content.blocks.SCUnitBlocks;
import sc.content.blocks.SCWalls;

public class LxTechTree {
  public static void load() {
    SCPlanets.lx.techTree = nodeRoot("lx", SCBlocksEffects.core1, () -> {
      node(SCBlocksEffects.tempcore, () -> {
      });
      node(Test.test4, () -> {
      });
      node(SCLogic.chuliqi1, () -> {
      });
      node(SCUnitBlocks.airfactory, () -> {
        node(SCUnitBlocks.T2unit, () -> {
        });
        node(SCUnitBlocks.groundfactory, () -> {
          node(SCUnits.chujia1, () -> {
            node(SCUnits.chujia2, () -> {
            });
          });
          node(SCUnits.papa1, () -> {
            node(SCUnits.papa2, () -> {
            });
          });
          node(SCUnits.zhuhuo1, () -> {
          });
        });
        node(SCUnits.liekong1, () -> {
          node(SCUnits.liekong2, () -> {
          });
        });
        node(SCUnits.miner1, () -> {
          node(SCUnits.miner2, () -> {
          });
        });
      });
      node(LxMaps.jianglindian, () -> {
        node(LxMaps.baoziliegu, Seq.with(new SectorComplete(LxMaps.jianglindian)), () -> {
          node(LxMaps.xiji, Seq.with(new SectorComplete(LxMaps.baoziliegu)), () -> {
          });
          node(LxMaps.jiaocuolianfeng, Seq.with(new SectorComplete(LxMaps.baoziliegu)), () -> {
          });
        });
      });
      node(SCDistribution.lvconveyor, () -> {
        node(SCDistribution.lvlianjieqi, () -> {
          node(SCDistribution.lvluyouqi, () -> {
            node(SCBlocksEffects.lvrongqi, () -> {
              node(SCBlocksEffects.cangku2, () -> {
                node(SCBlocksEffects.cangku3, () -> {
                  node(SCBlocksEffects.cangku4, () -> {
                  });
                });
              });
              node(SCBlocksEffects.weicang, () -> {
                node(SCBlocksEffects.weicang2, () -> {
                });
                node(SCBlocksEffects.juxingcang, () -> {
                  node(SCBlocksEffects.juxingcang2, () -> {
                  });
                });
              });
              node(SCBlocksEffects.lvunloader, () -> {
                node(SCBlocksEffects.unloader2, () -> {
                  node(SCBlocksEffects.unloader3, () -> {
                    node(SCBlocksEffects.unloader4, () -> {
                    });
                  });
                });
              });
            });
            node(SCDistribution.lvbridge, () -> {
              node(SCDistribution.xiconveyor, () -> {
                node(SCDistribution.feijingconveyor, () -> {
                  node(SCDistribution.sujiaoconveyor, () -> {
                    node(SCDistribution.thickconveyor, () -> {
                    });
                  });
                });
                node(SCDistribution.chijinconveyor, () -> {
                  node(SCDistribution.armorchijinconveyor, () -> {
                  });
                });
                node(SCDistribution.armorxiconveyor, () -> {
                });
              });
              node(SCDistribution.xibridge, () -> {
                node(SCDistribution.massdriver1, () -> {
                  node(SCDistribution.massdriver2, () -> {
                  });
                });
                node(SCDistribution.chijinbridge, () -> {
                });
              });
              node(SCDistribution.dropdrill1, () -> {
              });
            });
            node(SCDistribution.lvyiliumeng, () -> {
              node(SCDistribution.lvfanxiangyiliumeng, () -> {
              });
            });
            node(SCDistribution.lvfenleiqi, () -> {
              node(SCDistribution.lvfanxiangfenleiqi, () -> {
              });
            });
            node(SCDistribution.lvfenpeiqi, () -> {
              node(SCDistribution.lvfenliuqi, () -> {
              });
            });
          });
        });
      });
      node(SCTurrets.danguanpao, ItemStack.with(SCItems.lv, 80), () -> {
        node(SCTurrets.duoguanpao, Seq.with(new SectorComplete(LxMaps.jianglindian)), () -> {
          node(SCTurrets.powerair1, () -> {
            node(SCTurrets.chuantou, () -> {
            });
          });
          node(SCTurrets.liuxing, () -> {
            node(SCTurrets.tujin1, () -> {
              node(SCTurrets.tuxi, () -> {
              });
            });
          });
        });
        node(SCTurrets.zhentian, ItemStack.with(SCItems.lv, 200, SCItems.li, 200), () -> {
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
      node(SCDrills.lvdrill, ItemStack.with(SCItems.lv, 50), () -> {
        node(SCLiquidBlocks.beng1, () -> {
          node(SCLiquidBlocks.lvdaoguan, () -> {
            node(SCLiquidBlocks.lvyetijiaochaqi, () -> {
              node(SCLiquidBlocks.lvyetiluyouqi, () -> {
                node(SCLiquidBlocks.yetichuguan, () -> {
                  node(SCLiquidBlocks.shuixiang, () -> {
                  });
                });
                node(SCLiquidBlocks.lvdaoguanqiao, () -> {
                  node(SCLiquidBlocks.xidaoguanqiao, () -> {
                  });
                });
              });
            });
            node(SCLiquidBlocks.xidaoguan, () -> {
            });
          });
          node(SCLiquidBlocks.beng2, () -> {
            node(SCLiquidBlocks.beng3, () -> {
              node(SCLiquidBlocks.beng4, () -> {
              });
            });
          });
        });
        node(SCPower.powernode1, () -> {
          node(SCPower.powernode2, () -> {
          });
          node(SCPower.firepower1, Seq.with(new Research(SCItems.tandanzhi)), () -> {
            node(SCPower.firepower2, () -> {
            });
            node(SCPower.qilunji, Seq.with(new SectorComplete(LxMaps.baoziliegu)), () -> {
            });
          });
          node(SCBlocksEffects.xiuliqi, () -> {
            node(SCUnitBlocks.unitrepair, () -> {
            });
            node(SCBlocksEffects.build1, () -> {
              node(SCBlocksEffects.build2, () -> {
              });
            });
            node(SCBlocksEffects.liqiang1, () -> {
              node(SCBlocksEffects.liqiang2, () -> {
                node(SCBlocksEffects.liqiang3, () -> {
                });
              });
            });
            node(SCBlocksEffects.jiasu1, () -> {
              node(SCBlocksEffects.jiasu2, () -> {
                node(SCBlocksEffects.jiasu3, () -> {
                  node(SCBlocksEffects.jiasu4, () -> {
                  });
                });
              });
            });
            node(SCBlocksEffects.xiuliqi2, () -> {
              node(SCBlocksEffects.repairturret1, () -> {
                node(SCBlocksEffects.repairturret2, () -> {
                });
                node(SCBlocksEffects.xiuliqi3, () -> {
                  node(SCBlocksEffects.xiuliqi4, () -> {
                  });
                });
              });
            });
            node(SCPower.battery1, () -> {
              node(SCPower.battery2, () -> {
              });
            });
            node(SCPower.sun1, Seq.with(new SectorComplete(LxMaps.jianglindian)), () -> {
            });
          });
          node(SCDrills.guijingdrill, () -> {
            node(SCDrills.guijingdrill2, () -> {
              node(SCDrills.jindrill, () -> {
              });
            });
          });
          Log.info("ready2");
          node(SCBlocks.guicuzhiji, () -> {
            node(SCBlocks.cuzhiganguo, () -> {
            });
            Log.info("readyb1");
            node(SCBlocks.lintilianji, () -> {
              node(SCBlocks.baozhahunheji, () -> {
              });
              node(SCBlocks.lintilianji2, () -> {
                node(SCBlocks.lintilianji3, () -> {
                });
              });
            });
            Log.info("ready3");
            node(SCBlocks.guitichunji, () -> {
              node(SCBlocks.lvganggongchang1, () -> {
                node(SCBlocks.nengliangyasuoji, () -> {
                  node(SCBlocks.jinhuihejingongchang1, () -> {
                    node(SCBlocks.jinhuihejingongchang2, () -> {
                    });
                  });
                  Log.info("ready4");
                  node(SCBlocks.chijingongchang, () -> {
                  });
                  node(SCBlocks.hejinggongchang1, () -> {
                    node(SCBlocks.hejinggongchang2, () -> {
                      node(SCBlocks.hejinggongchang3, () -> {
                        node(SCBlocks.hejinggongchang4, () -> {

                        });
                      });
                    });
                  });
                  Log.info("ready5");
                  node(SCBlocks.nengliangliutihunheqi, () -> {
                    node(SCBlocks.nengliangnongsuoji, () -> {
                    });
                  });
                  node(SCBlocks.nengliangchongyaji, () -> {
                  });
                });
                Log.info("ready6");
                node(SCBlocks.sujiaoyasuoji, () -> {
                });
                node(SCBlocks.lvganggongchang2, () -> {
                });
              });
              node(SCBlocks.hunliji, () -> {
              });
              node(SCBlocks.tichunganguo, () -> {
              });
              node(SCBlocks.feijinghechengji1, () -> {
                node(SCBlocks.feijinghechengji2, () -> {
                  node(SCBlocks.feijinghechengji3, () -> {
                  });
                });
                Log.info("ready7");
                node(SCBlocks.feizhafensuiji, () -> {
                  Log.info("readyc1");
                });
              });
            });
            node(SCBlocks.lengdongye1, () -> {
              Log.info("readyc2");
              node(SCBlocks.lengdongye2, () -> {
                Log.info("readyc3");
              });
            });
            node(SCBlocks.kuangzharonglianji, () -> {
              Log.info("readyc4");
              node(SCBlocks.fenhualu, () -> {
                Log.info("readyc5");
              });
            });
            node(SCBlocks.youjiboliji, () -> {
              Log.info("readyc6");
              node(SCBlocks.daxingbolishaozhiji, () -> {
                Log.info("readyc7");
              });
              Log.info("ready8");
              node(SCBlocks.peiyangji, () -> {
                node(SCBlocks.shiyouyasuoji, () -> {
                  node(SCBlocks.shiyoulixinji, () -> {
                  });
                });
                node(SCBlocks.daxingyouzaopeiyangji, () -> {
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
    });
  }
}
