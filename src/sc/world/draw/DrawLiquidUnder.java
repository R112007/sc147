package sc.world.draw;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import sc.world.blocks.power.LiquidFloorGenerator;
import sc.world.blocks.power.LiquidFloorGenerator.LiquidFloorGeneratorBuild;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;

public class DrawLiquidUnder extends DrawBlock {
  public Liquid drawLiquid;
  public TextureRegion liquid;
  public String suffix = "-liquid";
  public float alpha = 1f;

  public DrawLiquidUnder() {
  }

  @Override
  public void draw(Building build) {
    LiquidFloorGeneratorBuild entity = (LiquidFloorGeneratorBuild) build;
    drawLiquid = entity.maxLiquid();
    Drawf.liquid(liquid, build.x, build.y,
        Mathf.clamp(entity.productionEfficiency, 0f, 1f),
        drawLiquid.color);
  }

  @Override
  public void load(Block block) {
    if (!(block instanceof LiquidFloorGenerator)) {
      throw new RuntimeException(
          "Block '" + block + "' has a DrawLiquidUnder region,but its type is not LiquidFloorGenerator");
    }
    liquid = Core.atlas.find(block.name + suffix);
  }
}
