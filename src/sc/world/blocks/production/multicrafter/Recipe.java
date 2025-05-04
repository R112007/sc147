package sc.world.blocks.production.multicrafter;

import arc.func.Prov;
import arc.graphics.Color;
import arc.util.Nullable;
import mindustry.content.Fx;
import mindustry.entities.Effect;

public class Recipe {
  public IO input;
  public IO output;
  public float craftTime;
  @Nullable
  public Prov icon;
  @Nullable
  public Color iconColor;
  public Effect craftEffect;

  public Recipe(IO input, IO output, float craftTime) {
    this.craftEffect = Fx.none;
    this.input = input;
    this.output = output;
    this.craftTime = craftTime;
  }

  public Recipe() {
    this.craftEffect = Fx.none;
  }

  public void getSet() {
    this.input.getSet();
    this.output.getSet();
  }

  public boolean isAnyEmpty() {
    if (this.input != null && this.output != null) {
      return this.input.isEmpty() || this.output.isEmpty();
    } else {
      return true;
    }
  }

  public boolean isOutputLiquid() {
    return this.output.liquids.length != 0;
  }

  public boolean isOutputItem() {
    return this.output.items.length != 0;
  }

  public boolean isConsumeLiquid() {
    return this.input.liquids.length != 0;
  }

  public boolean isConsumeItem() {
    return this.input.items.length != 0;
  }

  public boolean isConsumePower() {
    return this.input.power > 0.0f;
  }

  public boolean isOutputPower() {
    return this.output.power > 0.0f;
  }

  public boolean isConsumeCrystal() {
    return this.input.crystal > 0.0f;
  }

  public boolean isOutputCrystal() {
    return this.output.crystal > 0.0f;
  }

  public boolean isConsumeHeat() {
    return this.input.heat > 0.0f;
  }

  public boolean isOutputHeat() {
    return this.output.heat > 0.0f;
  }

  public boolean hasItem() {
    return this.isConsumeItem() || this.isOutputItem();
  }

  public boolean hasLiquid() {
    return this.isConsumeLiquid() || this.isOutputLiquid();
  }

  public boolean hasPower() {
    return this.isConsumePower() || this.isOutputPower();
  }

  public boolean hasCrystal() {
    return this.isConsumeCrystal() || this.isOutputCrystal();
  }

  public boolean hasHeat() {
    return this.isConsumeHeat() || this.isOutputHeat();
  }

  public int maxItemAmount() {
    return Math.max(this.input.maxItemAmount(), this.output.maxItemAmount());
  }

  public float maxLiquidAmount() {
    return Math.max(this.input.maxLiquidAmount(), this.output.maxLiquidAmount());
  }

  public float maxPower() {
    return Math.max(this.input.power, this.output.power);
  }

  public float maxCrystal() {
    return Math.max(this.input.crystal, this.output.crystal);
  }

  public float maxHeat() {
    return Math.max(this.input.heat, this.output.heat);
  }

  public String toString() {
    return "Recipe{input=" +
        this.input + "output=" +
        this.output + "craftTime" +
        this.craftTime + "}";
  }
}
