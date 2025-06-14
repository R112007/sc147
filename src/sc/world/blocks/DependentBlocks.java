package sc.world.blocks;

import mindustry.content.Blocks;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.production.GenericCrafter;
import sc.util.build.DependentOtherBlock;

public class DependentBlocks {

  public static class DGenericCrafter extends GenericCrafter {
    public Block[] blocks = new Block[] { Blocks.duo, Blocks.arc };

    public DGenericCrafter(String name) {
      super(name);
    }

    @Override
    public void setStats() {
      super.setStats();
      DependentOtherBlock.stat(blocks, stats);
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
      return DependentOtherBlock.placeable(tile, team, rotation, blocks, this);
    }
  }
}
