package sc.type;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Tmp;
import mindustry.graphics.g3d.PlanetGrid.Ptile;
import mindustry.type.Planet;
import mindustry.type.Sector;
import sc.SCVars;

public class SCSector extends Sector {
  public SCSector(Planet planet, Ptile tile) {
    super(planet, tile);

  }

  public String displayThreat() {
    float step = 0.25F;
    String color = Tmp.c1.set(Color.white).lerp(Color.scarlet, Mathf.round(this.threat, step)).toString();
    String[] threats = SCVars.threats;
    int index = Math.min((int) (this.threat / step), threats.length - 1);
    return "[#" + color + "]" + Core.bundle.get("threat." + threats[index]);
  }
}
