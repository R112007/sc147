package hzr.content;

import static mindustry.content.TechTree.*;

import mindustry.type.ItemStack;

public class HTechTree {
  public static void load() {
    HPlanets.hzr.techTree = nodeRoot("hzr", HStorage.hcore1, () -> {
      node(Hsectorpresets.jizhanshifadian1, () -> {
      });
      node(Hdistribution.gaoconveyor1, ItemStack.with(HItems.gao, 30), () -> {
        node(Hdistribution.gaolianjieqi, () -> {
          node(Hdistribution.gaoluyouqi, () -> {
          });
        });
        node(Hdistribution.gaofenleiqi, () -> {
          node(Hdistribution.gaofanxiangfenleiqi, () -> {
          });
          node(Hdistribution.gaoyiliumeng, () -> {
            node(Hdistribution.gaofanxiangyiliumeng, () -> {
            });
          });
        });
        node(Hdistribution.gaoconveyor, ItemStack.with(HItems.gao, 30), () -> {
          node(Hdistribution.gaobridge, () -> {
          });
        });
      });
      node(Hturret.jianglin, ItemStack.with(HItems.gao, 250), () -> {
        node(HWall.gaowall1, ItemStack.with(HItems.gao, 50), () -> {
          node(HWall.gaowall2, () -> {
          });
        });
      });
      node(HDrills.turretdrill1, ItemStack.with(HItems.gao, 30), () -> {
        node(HDrills.wastedrop, ItemStack.with(HItems.gao, 60), () -> {
        });
      });
      nodeProduce(HItems.gao, () -> {
        nodeProduce(HItems.brokenA, () -> {
          nodeProduce(HItems.brokenB, () -> {
            nodeProduce(HItems.brokenC, () -> {
            });
          });
        });
      });
    });
  }
}
