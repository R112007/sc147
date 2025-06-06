package hzr.content;

import static mindustry.content.TechTree.*;

import mindustry.type.ItemStack;

public class HTechTree {
  public static void load() {
    HPlanets.hzr.techTree = nodeRoot("hzr", HStorage.hcore1, () -> {
      node(Hdistribution.gaoconveyor, ItemStack.with(HItems.gao, 30), () -> {
        node(Hdistribution.gaobridge, () -> {
        });
      });
      node(Hturret.jianglin, ItemStack.with(HItems.gao, 250), () -> {
      });
      node(HDrills.turretdrill1, ItemStack.with(HItems.gao, 30), () -> {
        node(HDrills.wastedrop, ItemStack.with(HItems.gao, 60), () -> {
        });
      });
      nodeProduce(HItems.gao, () -> {
        nodeProduce(HItems.brokenA, () -> {
        });
        nodeProduce(HItems.brokenB, () -> {
        });
      });
    });
  }
}
