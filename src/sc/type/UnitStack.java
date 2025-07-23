package sc.type;

import arc.math.Mathf;
import arc.struct.Seq;
import mindustry.content.UnitTypes;
import mindustry.type.UnitType;

/**
 * UnitStack
 */
public class UnitStack implements Comparable<UnitStack> {
  public static final UnitStack[] empty = {};

  public UnitType unit;
  public int amount = 0;

  public UnitStack(UnitType unit, int amount) {
    if (unit == null)
      unit = UnitTypes.dagger;
    this.unit = unit;
    this.amount = amount;
  }

  public UnitStack() {
    this.unit = UnitTypes.dagger;
  }

  public UnitStack set(UnitType unit, int amount) {
    this.unit = unit;
    this.amount = amount;
    return this;
  }

  public UnitStack copy() {
    return new UnitStack(unit, amount);
  }

  public boolean equals(UnitStack other) {
    return other != null && other.unit == unit && other.amount == amount;
  }

  public static UnitStack[] mult(UnitStack[] stacks, float amount) {
    var copy = new UnitStack[stacks.length];
    for (int i = 0; i < copy.length; i++) {
      copy[i] = new UnitStack(stacks[i].unit, Mathf.round(stacks[i].amount * amount));
    }
    return copy;
  }

  public static UnitStack[] with(Object... units) {
    var stacks = new UnitStack[units.length / 2];
    for (int i = 0; i < units.length; i += 2) {
      stacks[i / 2] = new UnitStack((UnitType) units[i], ((Number) units[i + 1]).intValue());
    }
    return stacks;
  }

  public static Seq<UnitStack> list(Object... units) {
    Seq<UnitStack> stacks = new Seq<>(units.length / 2);
    for (int i = 0; i < units.length; i += 2) {
      stacks.add(new UnitStack((UnitType) units[i], ((Number) units[i + 1]).intValue()));
    }
    return stacks;
  }

  public static UnitStack[] copy(UnitStack[] stacks) {
    var out = new UnitStack[stacks.length];
    for (int i = 0; i < out.length; i++) {
      out[i] = stacks[i].copy();
    }
    return out;
  }

  @Override
  public int compareTo(UnitStack unitStack) {
    return unit.compareTo(unitStack.unit);
  }

  @Override
  public boolean equals(Object o) {
    return this == o || (o instanceof UnitStack stack && stack.amount == amount && unit == stack.unit);
  }

  @Override
  public String toString() {
    return unit + ": " + amount;
  }
}
