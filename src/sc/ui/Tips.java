package sc.ui;

import arc.Core;
import arc.func.Boolp;
import arc.struct.Seq;
import arc.util.Structs;
import mindustry.Vars;
import mindustry.ui.fragments.HintsFragment.Hint;
import sc.world.blocks.production.DrillTurret;

public enum Tips implements Hint {
  drillturret(
      () -> false,
      () -> Vars.state.rules.defaultTeam.data().buildings.contains(b -> b.block instanceof DrillTurret));

  static final String modName = "sc-";
  final Boolp complete;
  Boolp shown = () -> true;
  int visibility = visibleAll;
  boolean cached, finished;
  Tips[] requirements;

  public static void addHints() {
    Vars.ui.hints.hints.add(Seq.with(Tips.values()).removeAll(
        hint -> Core.settings.getBool(modName + hint.name() + "-hint-done", false)));
  }

  Tips(Boolp complete) {
    this.complete = complete;
  }

  Tips(Boolp complete, Boolp shown) {
    this(complete);
    this.shown = shown;
  }

  Tips(Boolp complete, Boolp shown, Tips... requirements) {
    this(complete, shown);
    this.requirements = requirements;
  }

  @Override
  public boolean complete() {
    return complete.get();
  }

  @Override
  public boolean show() {
    return shown.get()
        && (requirements == null || (requirements.length == 0 || !Structs.contains(requirements, d -> !d.finished())));
  }

  @Override
  public void finish() {
    Core.settings.put(modName + name() + "-hint-done", finished = true);
  }

  @Override
  public boolean finished() {
    if (!cached) {
      cached = true;
      finished = Core.settings.getBool(modName + name() + "-hint-done", false);
    }
    return finished;
  }

  @Override
  public int order() {
    return ordinal();
  }

  public static void reset() {
    for (Tips hint : values()) {

      Core.settings.put(modName + hint.name() + "-hint-done", hint.finished = false);
    }
    addHints();
  }

  @Override
  public String text() {
    return Core.bundle.get("hint." + modName + name(), "Missing bundle for hint: hint." + modName + name());
  }

  @Override
  public boolean valid() {
    return (Vars.mobile && (visibility & visibleMobile) != 0) || (!Vars.mobile && (visibility & visibleDesktop) != 0);
  }
}
