package sc.type;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Tmp;
import mindustry.graphics.g3d.PlanetGrid.Ptile;
import mindustry.type.Planet;
import mindustry.type.Sector;

public class SCSector extends Sector {
  public SCSector(Planet planet, Ptile tile) {
    super(planet, tile);

  }

  public String displayThreat() {
    float step = 0.25f;
    String color = Tmp.c1.set(Color.white).lerp(Color.scarlet, Mathf.round(threat, step)).toString();
    String[] threats = { "low", "medium", "high", "extreme", "eradication" };
    int index = Math.min((int) (threat / step), threats.length - 1);
    return "[#" + color + "]" + Core.bundle.get("threat." + threats[index]);
  }
}
