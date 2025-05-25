package hzr.generator;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.world.Block;

public class HzrPlanetGenerator extends PlanetGenerator {
  public float heightScl = 1f, octaves = 8, persistence = 0.7f;
  Block[] terrain = { Blocks.grass, Blocks.cryofluid, Blocks.ice, Blocks.snow };

  public Block getBlock(Vec3 position) {
    float height = getHeight(position);
    Block result = terrain[Mathf.clamp((int) (height * terrain.length), 0, terrain.length - 1)];
    if (Mathf.zero(height))
      result = Blocks.cryofluid;
    return result;
  }

  public float rawHeight(Vec3 position) {
    return Simplex.noise3d(seed, octaves, persistence, 1f / heightScl, 10f + position.x, 10f + position.y,
        10f + position.z) - 0.6f;
  }

  @Override
  public float getHeight(Vec3 position) {
    return 5 * Math.max(0, rawHeight(position));
  }

  @Override
  public Color getColor(Vec3 position) {
    return getBlock(position).mapColor;
  }

  @Override
  public boolean allowLanding(Sector sector) {
    return true;
  }
}
