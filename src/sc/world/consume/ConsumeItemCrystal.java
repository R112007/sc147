package sc.world.consume;

import mindustry.world.consumers.ConsumeItemEfficiency;

public class ConsumeItemCrystal extends ConsumeItemEfficiency {
  public float minCrystal;

  public ConsumeItemCrystal(float minCrystal) {
    this.minCrystal = minCrystal;
    filter = item -> item.flammability >= this.minCrystal;
  }

}
