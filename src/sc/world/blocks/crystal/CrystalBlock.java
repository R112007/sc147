package sc.world.blocks.crystal;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawDefault;

public class CrystalBlock extends Block {
  public boolean hasCrystal;
  public float consumeCrystalE;
  public float MaxCrystalE;
  public int BarAmount;
  public DrawBlock drawer = new DrawDefault();

  public CrystalBlock(String name) {
    super(name);
    this.size = 2;
    this.health = 300;
    this.hasCrystal = true;
    this.MaxCrystalE = 500f;
    this.consumeCrystalE = 100f;
    this.BarAmount = 4;
    this.category = Category.crafting;
  }

  @Override
  public void load() {
    super.load();
    drawer.load(this);
  }
}
