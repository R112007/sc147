package sc.world.module;

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.world.modules.BlockModule;

public class CrystalModule extends BlockModule {
  // 外部晶能数值
  public float outsideCrysralE = 0.0f;
  // 每帧的晶能数值
  public float insideCrystalE;
  // 最多储存的晶能数值
  public float MaxCrystalE;
  // 分割成几部分
  public int Baramount;
  // 每次消耗的晶能数值
  public float consumeCrystal;

  public CrystalModule(float MaxCrystalE, float consumeCrystal, float insideCrystalE, int Baramount) {
    this.insideCrystalE = insideCrystalE;
    this.MaxCrystalE = MaxCrystalE;
    this.consumeCrystal = consumeCrystal;
    this.Baramount = Baramount;
  }

  // 不同晶能下的效率计算
  public float CrystalEfficiency() {
    if (insideCrystalE >= consumeCrystal) {
      // TODO 向下取整
      return (int) insideCrystalE / consumeCrystal;
    } else if (insideCrystalE > 0f && insideCrystalE < consumeCrystal) {
      return insideCrystalE / consumeCrystal;
    } else {
      return 0f;
    }
  }

  // 爆炸概率
  public float bombChance(float baseChance) {
    if (insideCrystalE >= consumeCrystal) {
      return baseChance * (int) (insideCrystalE / consumeCrystal);
    } else {
      return 0f;
    }
  }

  public void ConsumeCrystalE() {
    insideCrystalE -= consumeCrystal;
  }

  public int crystalMultiplier() {
    return (int) (insideCrystalE / consumeCrystal);
  }

  @Override
  public void write(Writes write) {
    write.f(insideCrystalE);
    write.f(outsideCrysralE);
  }

  @Override
  public void read(Reads read) {
    insideCrystalE = read.f();
    outsideCrysralE = read.f();
  }
}
