package sc.content;

import arc.scene.style.TextureRegionDrawable;
import static arc.Core.atlas;
import static mindustry.gen.Icon.icons;

public class SCIcon {
  public static TextureRegionDrawable crystalCore;

  public static void load() {
    crystalCore = atlas.getDrawable("sc-crystal-core");
    icons.put("crystalCore", crystalCore);
  }

}
