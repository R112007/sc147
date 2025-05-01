package sc.ui.dialogs;

import arc.Core;
import mindustry.ui.dialogs.BaseDialog;

public class General {
  public static BaseDialog general;
  public static BaseDialog update1;
  public static BaseDialog update2;
  public static BaseDialog update3;

  public General() {
    general = new BaseDialog(Core.bundle.get("update.general"));
    update1 = new BaseDialog(Core.bundle.get("u1"));
    update2 = new BaseDialog(Core.bundle.get("u2"));
    update3 = new BaseDialog(Core.bundle.get("u3"));
  }

  public void update1() {
    update1.cont.pane(t -> {
      t.add(Core.bundle.get("u.u1"));
      t.row();
    }).row();
    ;
  }
}
