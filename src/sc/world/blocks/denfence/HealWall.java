package sc.world.blocks.denfence;

import mindustry.entities.TargetPriority;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;
import mindustry.world.meta.StatUnit;
import sc.world.meta.SCStat;

public class HealWall extends Wall {
  public float healpercent;

  public HealWall(String name) {
    super(name);
    healpercent = 1f;
    solid = true;
    destructible = true;
    update = true;
    group = BlockGroup.walls;
    buildCostMultiplier = 6f;
    canOverdrive = false;
    drawDisabled = false;
    crushDamageMultiplier = 5f;
    priority = TargetPriority.wall;
    envEnabled = Env.any;
  }

  @Override
  public void setStats() {
    super.setStats();
    stats.add(SCStat.healpercent, this.healpercent * 60f);
  }

  public class HealWallBuild extends WallBuild {
    @Override
    public void updateTile() {
      if (health < maxHealth) {
        heal(healpercent);
      }
    }
  }
}
