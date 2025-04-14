package sc.type;

import arc.graphics.Color;
import mindustry.type.Item;
import sc.world.meta.SCStat;

public class SCItemType extends Item {
  public float crystalEnergy;

  public SCItemType(String name, Color color) {
    super(name);
    this.color = color;
    this.crystalEnergy = 0.0f;
  }

  public SCItemType(String name) {
    super(name);
    this.color = Color.valueOf("#114514");
    this.crystalEnergy = 0.0f;
  }

  public SCItemType() {
    super("byd名字都不写是吧");
    this.color = Color.valueOf("#114514");
    this.crystalEnergy = 0.0f;
  }

  @Override
  public void setStats() {
    super.setStats();
    stats.add(SCStat.crystalEnergy, crystalEnergy);
  }

  @Override
  public void init() {
    super.init();
  }
}
