package sc.world.blocks.production.multicrafter;

import arc.func.Prov;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.struct.ObjectSet;
import arc.util.Nullable;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;

public class IO {
  public ItemStack[] items;
  public LiquidStack[] liquids;
  public float power;
  public float heat;
  public float crystal;
  public ObjectSet<Item> itemsSet;
  public ObjectSet<Liquid> liquidSet;
  @Nullable
  public Prov<TextureRegion> icon;
  @Nullable
  public Color iconColor;

  public IO(ItemStack[] items, LiquidStack[] liquids, float power, float crystal, float heat) {
    this.items = ItemStack.with(new Object[0]);
    this.liquids = new LiquidStack[0];
    this.power = 0.0f;
    this.heat = 0.0f;
    this.crystal = 0.0f;
    this.itemsSet = new ObjectSet<>();
    this.liquidSet = new ObjectSet<>();
    this.items = items;
    this.liquids = liquids;
    this.power = power;
    this.crystal = crystal;
    this.heat = heat;
  }

  public IO(ItemStack[] items, LiquidStack[] liquids, float power, float crystal) {
    this(items, liquids, power, crystal, 0.0f);
  }

  public IO(ItemStack[] items, LiquidStack[] liquids, float power) {
    this(items, liquids, power, 0.0f, 0.0f);
  }

  public IO(ItemStack[] items, LiquidStack[] liquids) {
    this(items, liquids, 0.0f, 0.0f, 0.0f);
  }

  public IO(ItemStack[] items) {
    this(items, new LiquidStack[0], 0.0f, 0.0f, 0.0f);
  }

  public IO() {
    this.items = ItemStack.with(new Object[0]);
    this.liquids = new LiquidStack[0];
    this.power = 0.0f;
    this.heat = 0.0f;
    this.crystal = 0.0f;
    this.itemsSet = new ObjectSet<>();
    this.liquidSet = new ObjectSet<>();
  }

  public void getSet() {
    for (ItemStack item : items) {
      itemsSet.add(item.item);
    }
    for (LiquidStack liquid : liquids) {
      liquidSet.add(liquid.liquid);
    }
  }

  public boolean isEmpty() {
    return items.length == 0 && liquids.length == 0 && power <= 0f && crystal <= 0f && heat <= 0f;
  }

  public int maxItemAmount() {
    int max = 0;
    for (ItemStack item : items) {
      max = Math.max(item.amount, max);
    }
    return max;
  }

  public float maxLiquidAmount() {
    float max = 0;
    for (LiquidStack liquid : liquids) {
      max = Math.max(liquid.amount, max);
    }
    return max;
  }

  public String toString() {
    return "IO{" +
        "items=" + this.items +
        "liquids=" + this.liquids +
        "power=" + this.power +
        "crystal=" + this.crystal +
        "heat=" + this.heat +
        "}";
  }

}
