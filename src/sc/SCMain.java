package sc;

import sc.content.SCUnits;
import sc.content.Test;
import mindustry.mod.Mod;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import sc.content.SCItems;
import sc.content.SCLiquids;
import sc.content.SCLoadouts;
import sc.content.SCOre;
import sc.content.SCPlanets;
import sc.content.SCStatusEffects;

import java.util.Objects;

import javax.swing.event.HyperlinkEvent.EventType;

import arc.Core;
import arc.Events;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.scene.style.Style;
import arc.scene.ui.ImageButton;
import arc.util.Align;
import arc.util.Log;
import arc.util.Time;
import sc.content.SCBlocks;
import mindustry.core.Renderer;
import sc.content.LxMaps;
import sc.content.LxTechTree;
import mindustry.Vars;

public class SCMain extends Mod {
  public static BaseDialog welcomeDialog;
  public static final String scqq = "http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=Rrju8RLWbsJstJ3rcJxWyrtop4u7uRb9&authKey=gdngZkPeYxZPhYTmjQUTjPos%2FJKckD02YSFnYLmdVojPZIzZw1T%2FbtubSoyuw2LA&noverify=0&group_code=756820891";

  public SCMain() {
    Log.info("Loaded Synthetic Crystal Mod Constructor.");
    Vars.renderer.minZoom = 0.1f;
    Vars.renderer.maxZoom = 30.0f;
    Log.info("缩放");
    Events.on(mindustry.game.EventType.ClientLoadEvent.class, (e) -> {
      welcomeDialog = new BaseDialog(Core.bundle.get("sc.welcome"));
      welcomeDialog.cont.image(Core.atlas.find("sc-crystal-core")).size(310f).pad(5.0f).row();
      welcomeDialog.cont.pane(t -> {
        t.add(Core.bundle.get("sc.text1")).row();
      }).row();
      // welcomeDialog.cont.button("退出", welcomeDialog::hide).size(100.0f, 50.0f);
      welcomeDialog.addCloseButton();
      Log.info("loaded 显示");
      Log.info("dialog is null: " + (welcomeDialog == null));
      Log.info("loaded menu");
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

  public static ImageButton addIcon(String IconName, ImageButton.ImageButtonStyle imageButtonStyle, BaseDialog dialog) {
    TextureRegion A = Core.atlas.find(SCVars.modName + IconName);
    ImageButton buttonA = new ImageButton(A, imageButtonStyle);
    Objects.requireNonNull(dialog);
    buttonA.clicked(dialog::show);
    return buttonA;
  }

  @Override
  public void init() {
    Log.info("loaded init");
    /**
     * ImageButton imagebutton = addIcon("crystal-core", Styles.defaulti,
     * welcomeDialog);
     * Vars.ui.menuGroup.fill((t) -> {
     * t.add(imagebutton).update((b) -> b.color.fromHsv(Time.time % 360.0F, 1.0F,
     * 1.0F)).size(80.0F);
     * t.left();
     * t.row();
     * });
     */
  }

  @Override
  public void loadContent() {
    Log.info("Start to Load Contents");
    SCStatusEffects.load();
    SCLiquids.load();
    Log.info("loaded liquids");
    SCItems.load();
    Log.info("loaded items");
    SCOre.load();
    Log.info("loaded ores");
    SCUnits.load();
    SCBlocks.load();
    Log.info("loaded blocks");
    SCLoadouts.load();
    SCPlanets.load();
    LxMaps.load();
    Test.load();
    LxTechTree.load();
  }
}
