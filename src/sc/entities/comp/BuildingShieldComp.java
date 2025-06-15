package sc.entities.comp;

import arc.graphics.Color;
import ent.anno.Annotations.Import;
import mindustry.entities.units.BuildPlan;
import mindustry.game.Team;
import mindustry.gen.Builderc;

/**
 * BuildingShieldComp
 */
abstract class BuildingShieldComp implements Builderc {
  @Import
  boolean building;
  @Import
  BuildPlan buildPlan;
  @Import
  float x, y;
  @Import
  Team team;
  private float shieldHealth;
  private float shieldRadius;
  private Color shieldColor;
  private float shieldDuration;

}
