package sc.type;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Tmp;
import mindustry.graphics.g3d.PlanetGrid;
import mindustry.type.Planet;
import sc.SCVars;

public class SCPlanet extends Planet {
  public SCPlanet(String name, Planet parent, float radius) {
    super(name, parent, radius);
  }

  public SCPlanet(String name, Planet parent, float radius, int sectorSize) {
    super(name, parent, radius);
    if (sectorSize > 0) {
      this.grid = PlanetGrid.create(sectorSize);
      this.sectors.ensureCapacity(this.grid.tiles.length);
      for (int i = 0; i < this.grid.tiles.length; ++i) {
        this.sectors.add(new SCSector(this, this.grid.tiles[i]) {
          public String displayThreat() {
            float step = 0.25F;
            String color = Tmp.c1.set(Color.white).lerp(Color.scarlet, Mathf.round(this.threat, step)).toString();
            String[] threats = SCVars.threats;
            int index = Math.min((int) (this.threat / step), threats.length - 1);
            return "[#" + color + "]" + Core.bundle.get("threat." + threats[index]);
          }
        });
      }
    }
  }

}
