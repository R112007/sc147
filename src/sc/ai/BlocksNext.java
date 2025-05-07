package sc.ai;

import java.util.HashSet;
import java.util.Set;

import mindustry.gen.Building;
import mindustry.world.Tile;

public class BlocksNext {

  public static Set<Building> getTouchBuildings(Building target) {
    Set<Building> touchBuildings = new HashSet<>();
    Tile[] targetTiles = target.get;
  }

  public boolean isTouch(Tile[] tile1, Tile[] tile2) {
    for (Tile t1 : tile1) {
      for (Tile t2 : tile2) {
        if (t1.adjacentTo(t2)) {
          return true;
        }
      }
    }
    return false;
  }
}
