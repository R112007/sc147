package sc.util.build;

import arc.struct.Seq;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.Stats;
import sc.world.meta.SCStat;
import sc.world.meta.SCStatValues;

public class DependentOtherBlock extends Block {
  public DependentOtherBlock(String name) {
    super(name);
  }

  public static void stat(Block[] blocks, Stats stats) {
    stats.add(SCStat.dependbuild, SCStatValues.contents(blocks));
  }

  public static boolean placeable(Tile tile, Team team, int rotation, Block[] blocks, Block entity) {
    Seq<Tile> everytiles = tile.getLinkedTilesAs(entity, tempTiles);
    a: for (int i = 0; i < blocks.length; i++) {
      b: for (Tile t : everytiles) {
        c: for (int j = 0; j < 4; j++) {
          Tile next = t.nearby(j);
          if (next == null)
            continue c;
          if (next.build.block == blocks[i]) {
            continue a;
          }
        }
      }
      return false;
    }
    return true;
  }
}
