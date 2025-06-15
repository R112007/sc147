package sc.entities.comp;

import arc.func.Cons;
import arc.graphics.g2d.TextureRegion;
import arc.math.geom.Intersector;
import ent.anno.Annotations.EntityComponent;
import ent.anno.Annotations.Import;
import ent.anno.Annotations.ReadOnly;
import ent.anno.Annotations.Replace;
import mindustry.entities.Effect;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Unitc;
import mindustry.world.Block;

import static mindustry.Vars.*;

@EntityComponent
abstract class SCBlockUnitComp implements Unitc {
  @Import
  Team team;
  @Import
  int sides;
  @Import
  float shieldHealth, radius, cooldown;
  @Import
  Effect paramEffect;
  @ReadOnly
  transient Building tile;

  public void tile(Building tile) {
    this.tile = tile;

    // sets up block stats
    maxHealth(tile.block.health);
    health(tile.health);
    hitSize(tile.block.size * tilesize * 0.7f);
    set(tile);
  }

  @Override
  public void add() {
    if (tile == null) {
      throw new RuntimeException(
          "Do not add BlockUnit entities to the game, they will simply crash. Internal use only.");
    }
  }

  @Override
  public void update() {
    if (tile != null) {
      team = tile.team;
    }
  }

  @Replace
  @Override
  public TextureRegion icon() {
    return tile.block.uiIcon;
  }

  @Override
  public void killed() {
    tile.kill();
  }

  @Replace
  public void damage(float v, boolean b) {
    tile.damage(v, b);
  }

  @Replace
  public boolean dead() {
    return tile == null || tile.dead();
  }

  @Replace
  public boolean isValid() {
    return tile != null && tile.isValid();
  }

  @Replace
  public boolean isAdded() {
    return tile != null && tile.isValid();
  }

  @Replace
  public void team(Team team) {
    if (tile != null && this.team != team) {
      this.team = team;
      if (tile.team != team) {
        tile.changeTeam(team);
      }
    }
  }

}
