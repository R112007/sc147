package sc.world.blocks.crystal;

import arc.math.Rand;
import arc.util.Log;
import arc.util.Time;
import mindustry.entities.Damage;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawDefault;
import sc.world.meta.SCStat;
import sc.world.module.CrystalModule;
import static mindustry.Vars.*;

public class CrystalBlock extends Block {
  public boolean hasCrystal;
  public float consumeCrystalE;
  public float MaxCrystalE;
  public int BarAmount;
  public DrawBlock drawer = new DrawDefault();

  public CrystalBlock(String name) {
    super(name);
    this.update = true;
    this.solid = true;
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

  @Override
  public void setStats() {
    super.setStats();
    stats.add(SCStat.hasCrystal, this.hasCrystal);
    if (this.hasCrystal) {
      stats.add(SCStat.MaxCrystalE, this.MaxCrystalE);
      stats.add(SCStat.consumeCrystalE, this.consumeCrystalE);
    }
  }

  public class CrystalBuild extends Building {
    public float insideCrystalE;
    public Rand rand = new Rand();
    CrystalModule cry = new CrystalModule(MaxCrystalE, consumeCrystalE, insideCrystalE, BarAmount);
    float timer = 0f;

    @Override
    public void updateTile() {
      timer += Time.delta;
      this.efficiency *= cry.CrystalEfficiency();
      if (rand.chance(finallyBombXhance())) {
        bomb();
        kill();
      }
      /**
       * if (timer >= 600f) {
       * bomb();
       * kill();
       * }
       */
    }

    public float finallyBombXhance() {
      if (cry.crystalMultiplier() > 0.9 && cry.crystalMultiplier() < 1.25) {
        return 0f;
      }
      if (armor > 0) {
        float baseChance = 1 / 100 * armor;
        return cry.bombChance(baseChance);
      } else {
        return cry.bombChance(0.002f);
      }
    }

    public void bomb() {
      int range = 8 * size * size * cry.crystalMultiplier();
      int damage = 100 * size * cry.crystalMultiplier();
      Damage.damage(Team.all[255], this.x, this.y, range, damage, true, true,
          false);
      Damage.damage(Team.all[255], this.x, this.y, range, damage, true, true,
          true);

    }
  }

}
