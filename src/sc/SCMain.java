package sc;

import sc.content.SCUnits;
import sc.content.Test;
import sc.ui.TimeControl;
import sc.ui.Tips;
import sc.world.SCAttributes;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.fragments.HintsFragment;
import sc.content.SCItems;
import sc.content.SCLiquids;
import sc.content.SCLoadouts;
import sc.content.SCOre;
import sc.content.SCPlanets;
import sc.content.SCStatusEffects;
import arc.Core;
import arc.Events;
import arc.graphics.Color;
import arc.util.Log;
import hzr.content.Hload;
import sc.content.SCBlocks;
import sc.content.SCIcon;
import mindustry.game.EventType;
import mindustry.game.EventType.Trigger;
import mindustry.gen.Icon;
import sc.content.LxMaps;
import sc.content.LxTechTree;
import mindustry.Vars;

public class SCMain extends Mod {
  public static BaseDialog welcomeDialog;
  public static final String scqq = "http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=Rrju8RLWbsJstJ3rcJxWyrtop4u7uRb9&authKey=gdngZkPeYxZPhYTmjQUTjPos%2FJKckD02YSFnYLmdVojPZIzZw1T%2FbtubSoyuw2LA&noverify=0&group_code=756820891";

  public SCMain() {
    Log.info("Loaded Synthetic Crystal Mod Constructor.");
    closeMod("HF");

    Events.on(mindustry.game.EventType.ClientLoadEvent.class, (e) -> {
      welcomeDialog = new BaseDialog(Core.bundle.get("sc.welcome"));
      welcomeDialog.cont.image(Core.atlas.find("sc-crystal-core")).size(310f).pad(5.0f).row();
      welcomeDialog.cont.pane(t -> {
        t.add(Core.bundle.get("sc.text1")).row();
      }).row();
      welcomeDialog.addCloseButton();
      welcomeDialog.cont.pane((c) -> {
        c.button(Core.bundle.get("sc.qq"), () -> {
          if (!Core.app.openURI(scqq)) {
            Vars.ui.showErrorMessage("@linkfail");
            Core.app.setClipboardText(scqq);
          }
        }).color(Color.valueOf("#556352")).size(120.0f, 50.0f);
      }).pad(3f).row();
      welcomeDialog.show();
    });
  }

  @Override
  public void init() {
    Log.info("loaded init");
    SCVars.scui.init();
    SCIcon.load();
    Events.on(mindustry.game.EventType.ClientLoadEvent.class, (e) -> {
      Events.run(Trigger.update, () -> {
        if (Vars.ui.planet.isShown()) {
          Vars.ui.planet.hide();
          if (!SCVars.scui.scplanet.isShown()) {
            SCVars.scui.scplanet.show();
          }
        }
        if (Vars.ui.research.isShown()) {
          Vars.ui.research.hide();
          if (!SCVars.scui.scresearch.isShown()) {
            SCVars.scui.scresearch.show();
          }
        }
      });
      Vars.ui.menufrag.addButton("研究", Icon.tree, () -> {
        SCVars.scui.scresearch.show();
      });
      Vars.ui.menufrag.addButton("小梓", SCIcon.crystalCore, () -> {
        welcomeDialog.show();
      });
    });
    HintsFragment hintsFragment = Vars.ui.hints;
    for (Tips hint : Tips.values()) {
      hintsFragment.hints.add(hint);
    }
  }

  @Override
  public void loadContent() {
    Log.info("Start to Load Contents");
    SCStatusEffects.load();
    SCAttributes.load();
    SCLiquids.load();
    SCItems.load();
    SCOre.load();
    SCUnits.load();
    SCBlocks.load();
    SCLoadouts.load();
    SCPlanets.load();
    LxMaps.load();
    Test.load();
    LxTechTree.load();
    Hload.load();
    TimeControl.load();
  }

  public void closeMod(String name) {
    Events.on(EventType.ClientLoadEvent.class, (e) -> {
      if (Vars.mods.getMod(name) != null)
        Vars.mods.removeMod(Vars.mods.getMod(name));
    });
  }
}
