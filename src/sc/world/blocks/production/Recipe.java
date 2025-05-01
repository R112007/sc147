package sc.world.blocks.production;

import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;

public class Recipe {
  public static class InputContents {
    public final ItemStack[] items;
    public final LiquidStack[] liquids;
    public final float power;
    public final float crystalE;

    public InputContents(ItemStack[] items, float crystalE, LiquidStack[] liquids, float power) {
      this.items = items;
      this.liquids = liquids;
      this.power = power;
      this.crystalE = crystalE;
    }

    public InputContents(ItemStack[] items, LiquidStack[] liquids, float power) {
      this(items, 0.0f, liquids, power);
    }

    public InputContents(ItemStack[] items, float crystalE, float power) {
      this(items, crystalE, new LiquidStack[0], power);
    }

    public InputContents(float crystalE, LiquidStack[] liquids, float power) {
      this(ItemStack.with(new Object[0]), crystalE, liquids, power);
    }

    public InputContents(ItemStack[] items, float crystalE, LiquidStack[] liquids) {
      this(items, crystalE, liquids, 0.0f);
    }
  }

  public static class OutputContents {
    public final ItemStack[] items;
    public final LiquidStack[] liquids;
    public final float power;
    public final float crystalE;

    public OutputContents(ItemStack[] items, float crystalE, LiquidStack[] liquids, float power) {
      this.items = items;
      this.liquids = liquids;
      this.power = power;
      this.crystalE = crystalE;
    }

    public OutputContents(ItemStack[] items, LiquidStack[] liquids, float power) {
      this(items, 0.0f, liquids, power);
    }

    public OutputContents(ItemStack[] items, float crystalE, float power) {
      this(items, crystalE, new LiquidStack[0], power);
    }

    public OutputContents(float crystalE, LiquidStack[] liquids, float power) {
      this(ItemStack.with(new Object[0]), crystalE, liquids, power);
    }

    public OutputContents(ItemStack[] items, float crystalE, LiquidStack[] liquids) {
      this(items, crystalE, liquids, 0.0f);
    }
  }
}
