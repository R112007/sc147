package sc.ui;

import arc.Core;
import arc.Events;
import arc.flabel.FLabel;
import arc.func.Floatp;
import arc.graphics.Color;
import arc.scene.ui.Slider;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Time;
import mindustry.Vars;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.gen.Icon;
import mindustry.ui.Styles;

public class TimeControl {
  static boolean first = true;

  public static void load() {
    Events.on(ClientLoadEvent.class, a -> {
      Vars.ui.hudGroup.fill(null, table -> {
        table.table(null, t -> setup(t)).width(400).padRight(20);
        table.top().left().update(() -> {
          float height = -115;
          if (Vars.state.rules.editor) {
            table.visible = false;
          }
          if (Vars.state.isCampaign()) {
            table.visible = true;
          }
          table.translation.set(0, height);
        });
      });
    });
    Events.on(ClientLoadEvent.class, e -> {
      Vars.ui.settings.game.sliderPref("加速", 100, 0, 10000, 25, i -> {
        if (first) {
          first = false;
          return "";
        }
        float s = i / 100;
        Time.setDeltaProvider(() -> Math.min(Core.graphics.getDeltaTime() * 60 * s, 3 * s));
        return i + "%";
      });
    });
  }

  public static void setup(Table table) {
    table.background(Styles.black6);
    setupSpeedTable(table);
  }

  public static void setupSpeedTable(Table table) {
    final Slider slider = new Slider(-4, 4, 1, false);
    FLabel label = new FLabel("");
    slider.moved(value -> {
      double speed = Math.pow(2, value);
      Floatp temp = () -> (float) Math.min(Core.graphics.getDeltaTime() * 60 * speed, 3 * speed);
      Time.setDeltaProvider(temp);
      DoubleItem b1 = getTextParams(value);
      label.restart(b1.getString(b1));
      label.setColor(b1.getColor(b1));
    });
    slider.setValue(0);
    table.add(label).width(64);
    table.button(Icon.refresh, Styles.clearNonei, 24, () -> {
      slider.setValue(0);
    }).size(72).padLeft(4);
    table.add(slider).height(55).growX();
  }

  public static DoubleItem getTextParams(float value) {
    double speed = Math.pow(2, Math.abs(value));
    String text = "";
    Color color = Color.white;
    Color colorSpeedUp = Color.valueOf("#ffd59e");
    Color colorSpeedDown = Color.valueOf("#99ffff");
    if (value == 0) {
      text = "x";
    } else if (value > 0) {
      text = "{wave}加速x";
      color = colorSpeedUp;
    } else {
      text = "{shake}减速x";
      color = colorSpeedDown;
    }
    DoubleItem b = new DoubleItem(text + speed, color);
    return b;
  }

  public static class DoubleItem {
    public String str;
    public Color color;

    public DoubleItem(String str, Color color) {
      this.color = color;
      this.str = str;
    }

    public String getString(DoubleItem b) {
      return b.str;
    }

    public Color getColor(DoubleItem b) {
      return b.color;
    }
  }
}
