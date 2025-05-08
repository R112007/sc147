package sc.world.blocks.denfence;

import arc.util.Log;
import arc.util.Time;
import mindustry.gen.Building;
import mindustry.world.blocks.defense.Wall;
import sc.ai.BlocksNext;

public class LinkWall extends Wall {
  public LinkWall(String name) {
    super(name);
    this.solid = true;
    this.update = true;
  }

  public class LinkWallBuild extends Building {
    float timer;

    @Override
    public void updateTile() {
      timer += Time.delta;
      if (timer >= 120) {
        int a = BlocksNext.getNextNumber(this);
        Log.info(a);
        timer = 0f;
      }
    }
  }
}
