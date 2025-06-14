package sc.util.build;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.Tile;

public class BlocksNext {

  public static int getNextNumber(Building entity) {
    if (entity == null)
      return 0;
    entity.updateProximity();
    Set<Tile> blockset = new HashSet<>();
    blockset.add(entity.tile);
    Block targetBlock = entity.block;
    for (Building neighbor : entity.proximity) {
      if (neighbor.block == targetBlock) {
        blockset.add(neighbor.tile);
      }
    }
    return blockset.size();
  }

  public static int getNextNumber1(Building build) {
    if (build == null)
      return 0;

    Block targetBlock = build.block;
    Team targetTeam = build.team;
    Set<Tile> allTiles = new HashSet<>();
    Set<Tile> visitedTiles = new HashSet<>();
    Queue<Building> bfsQueue = new LinkedList<>();
    collectBuildingTiles(build, allTiles);
    visitedTiles.addAll(allTiles);
    bfsQueue.add(build);
    while (!bfsQueue.isEmpty()) {
      Building current = bfsQueue.poll();
      for (int dir = 0; dir < 4; dir++) {
        Tile neighborTile = current.tile.nearby(dir);
        if (neighborTile == null)
          continue;

        Building neighborBuild = neighborTile.build;
        if (neighborBuild == null)
          continue;

        if (isPartOfBuildingTile(neighborTile, allTiles))
          continue;

        if (neighborBuild.block == targetBlock &&
            neighborBuild.team == targetTeam &&
            !visitedTiles.contains(neighborTile)) {

          Set<Tile> neighborMultiblock = new HashSet<>();
          collectBuildingTiles(neighborBuild, neighborMultiblock);

          if (visitedTiles.addAll(neighborMultiblock)) {
            bfsQueue.add(neighborBuild);
          }
        }
      }
    }

    return visitedTiles.size() / getBuildingTiles(build);
  }

  private static void collectBuildingTiles(Building build, Set<Tile> tiles) {
    build.block.iterateTaken(build.tile.x, build.tile.y, (x, y) -> {
      Tile tile = build.tileOn();
      if (tile != null)
        tiles.add(tile);
    });
  }

  private static boolean isPartOfBuildingTile(Tile tile, Set<Tile> targetTiles) {
    return targetTiles.contains(tile);
  }

  private static int getBuildingTiles(Building build) {
    return build.block.size * build.block.size; // 多块建筑瓷砖数 = size^2
  }
}
