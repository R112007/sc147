package sc.world.consume;

import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.consumers.Consume;

public class ConsumeCrystalEnergy extends Consume {
  public float consumeCrystal;

  public ConsumeCrystalEnergy(float consumeCrystal) {
    this.consumeCrystal = consumeCrystal;
  }

  public ConsumeCrystalEnergy() {
    this(1f);
  }

  @Override
  public void apply(Block block) {
    super.apply(block);
  }

  @Override
  public void trigger(Building b) {
    super.trigger(b);
  }

  @Override
  public float efficiency(Building build) {
    return super.efficiency(build);
  }

}
