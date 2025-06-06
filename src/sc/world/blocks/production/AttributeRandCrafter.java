package sc.world.blocks.production;

import arc.Core;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.Tile;
import mindustry.world.blocks.production.Separator;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Stat;
import sc.game.WaitTime;

public class AttributeRandCrafter extends Separator {
  public Attribute attribute = Attribute.heat;
  public float baseEfficiency = 0f;
  public float boostScale = 1f;
  public float maxBoost = 1f;
  public float minEfficiency = -1f;
  public float displayEfficiencyScale = 1f;
  public boolean displayEfficiency = true;
  public boolean scaleLiquidConsumption = false;
  public Effect craftEffect = Fx.none;

  public AttributeRandCrafter(String name) {
    super(name);
  }

  @Override
  public void drawPlace(int x, int y, int rotation, boolean valid) {
    super.drawPlace(x, y, rotation, valid);
    if (!displayEfficiency)
      return;
    drawPlaceText(Core.bundle.format("bar.efficiency",
        (int) ((baseEfficiency + Math.min(maxBoost, boostScale * sumAttribute(attribute, x, y))) * 100f)), x, y, valid);
  }

  @Override
  public void setBars() {
    super.setBars();

    if (!displayEfficiency)
      return;

    addBar("efficiency", (AttributeRandCrafterBuild entity) -> new Bar(
        () -> Core.bundle.format("bar.efficiency",
            (int) (entity.efficiencyMultiplier() * 100 * displayEfficiencyScale)),
        () -> Pal.lightOrange,
        entity::efficiencyMultiplier));
  }

  @Override
  public boolean canPlaceOn(Tile tile, Team team, int rotation) {
    // make sure there's enough efficiency at this location
    return baseEfficiency + tile.getLinkedTilesAs(this, tempTiles)
        .sumf(other -> other.floor().attributes.get(attribute)) > minEfficiency;
  }

  @Override
  public void setStats() {
    super.setStats();

    stats.add(baseEfficiency <= 0.0001f ? Stat.tiles : Stat.affinities, attribute, floating, boostScale * size * size,
        !displayEfficiency);
  }

  public class AttributeRandCrafterBuild extends SeparatorBuild {
    public float attrsum;

    @Override
    public void updateTile() {
      boolean b = WaitTime.waittime(40f);
      super.updateTile();
      if (b && wasVisible && efficiency > 0) {
        craftEffect.at(x, y);
      }
    }

    @Override
    public float getProgressIncrease(float base) {
      return super.getProgressIncrease(base) * efficiencyMultiplier();
    }

    public float efficiencyMultiplier() {
      return baseEfficiency + Math.min(maxBoost, boostScale * attrsum) + attribute.env();
    }

    @Override
    public float efficiencyScale() {
      return scaleLiquidConsumption ? efficiencyMultiplier() : super.efficiencyScale();
    }

    @Override
    public void pickedUp() {
      attrsum = 0f;
      warmup = 0f;
    }

    @Override
    public void onProximityUpdate() {
      super.onProximityUpdate();

      attrsum = sumAttribute(attribute, tile.x, tile.y);
    }
  }
}
