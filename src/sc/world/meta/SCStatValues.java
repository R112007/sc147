package sc.world.meta;

import java.util.ArrayList;

import arc.scene.ui.Image;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.ctype.UnlockableContent;
import mindustry.world.meta.StatValue;

public class SCStatValues {
  public static StatValue text(String text) {
    return table -> {
      table.row();
      table.add(text + ":");
      table.row();
    };
  }

  public static StatValue contents(UnlockableContent[] contents) {
    return table -> {
      int i = 0;
      for (UnlockableContent content : contents) {
        table.add(new Image(content.uiIcon)).size(Vars.iconSmall).padRight(3);
        table.add(content.localizedName).padRight(3);
        i++;
        if (i % 4 == 0) {
          table.row();
          i = 0;
        }
      }
    };
  }

  public static StatValue listcontents(ArrayList<? extends UnlockableContent> contents) {
    return table -> {
      int i = 0;
      for (UnlockableContent content : contents) {
        table.add(new Image(content.uiIcon)).size(Vars.iconSmall).padRight(3);
        table.add(content.localizedName).padRight(3);
        i++;
        if (i % 4 == 0) {
          table.row();
          i = 0;
        }
      }
    };
  }

  public static StatValue contents(Seq<? extends UnlockableContent> contents) {
    return table -> {
      int i = 0;
      for (UnlockableContent content : contents) {
        table.add(new Image(content.uiIcon)).size(Vars.iconSmall).padRight(3);
        table.add(content.localizedName).padRight(3);
        i++;
        if (i % 4 == 0) {
          table.row();
          i = 0;
        }
      }
    };
  }
}
