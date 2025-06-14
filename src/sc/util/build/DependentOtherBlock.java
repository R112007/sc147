package sc.util.build;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.StatValues;
import mindustry.world.meta.Stats;
import sc.world.meta.SCStat;
import sc.world.meta.SCStatValues;

public class DependentOtherBlock {

  public static void stat(Block[] blocks, Stats stats) {
    stats.add(SCStat.dependbuild, SCStatValues.contents(blocks));
  }

  public static boolean placeable(Tile tile, Team team, int rotation, Block[] blocks, Block entity) {
    Block[] allowedNeighbors = new Block[blocks.length];
    Point2[] directions = Geometry.d4;
    Set<Block> allowedSet = new HashSet<>();
    for (int i = 0; i < blocks.length; i++) {
      Block block = blocks[i];
      if (block == null)
        throw new IllegalArgumentException("Invalid block: " + blocks[i]);
      allowedNeighbors[i] = block;
      allowedSet.add(block);
    }
    if (allowedSet.isEmpty())
      return false;
    Set<Block> foundBlocks = new HashSet<>();
    int centerX = tile.x + (entity.size - 1) / 2;
    int centerY = tile.y + (entity.size - 1) / 2;
    for (Point2 dir : directions) {
      int x = centerX + dir.x;
      int y = centerY + dir.y;
      Tile neighborTile = Vars.world.tile(x, y);
      if (neighborTile != null && neighborTile.build != null) {
        Block neighborBlock = neighborTile.build.block;
        if (allowedSet.contains(neighborBlock)) {
          foundBlocks.add(neighborBlock); // 记录找到的类型
        }
      }
    }

    // 检查是否包含所有允许的类型（交集大小等于允许的类型数量）
    return foundBlocks.containsAll(allowedSet);
  }
}
