package sc.core;

import arc.ApplicationListener;
import sc.ui.dialogs.SCPlanetDialog;
import sc.ui.dialogs.SCResearchDialog;

public class UI implements ApplicationListener {
  public SCPlanetDialog scplanet;
  public SCResearchDialog scresearch;

  @Override
  public void init() {
    scresearch = new SCResearchDialog();
    scplanet = new SCPlanetDialog();
  }
}
