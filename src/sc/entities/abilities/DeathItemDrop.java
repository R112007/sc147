package sc.entities.abilities;

import arc.Core;
import arc.scene.ui.layout.Table;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.meta.StatValues;

/** 也是玩上塔防模式了 **/
public class DeathItemDrop extends Ability {
  public ItemStack[] drops;
  int a = 0;

  public DeathItemDrop(ItemStack[] drops) {
    this.drops = drops;
  }

  DeathItemDrop() {
  }

  @Override
  public void addStats(Table t) {
    t.add("掉落物品∶");
    t.row();
    for (ItemStack i : this.drops) {
      t.add(StatValues.displayItem(i.item, i.amount, true));
      t.row();
    }

  }

  @Override
  public void death(Unit unit) {
    if (unit.closestEnemyCore() != null) {
      Building core = unit.closestEnemyCore();
      for (ItemStack i : this.drops) {
        if (i.amount <= elseItem(core, i.item)) {
          unit.closestEnemyCore().items.add(i.item, i.amount);
        } else if (elseItem(core, i.item) > 0 && i.amount > elseItem(core, i.item)) {
          for (int a = 0; a <= elseItem(core, i.item); a++) {
            unit.closestEnemyCore().items.add(i.item, 1);
          }
        } else {
          unit.closestEnemyCore().items.add(i.item, 0);
        }
      }
    } else
      return;
  }

  public int elseItem(Building core, Item item) {
    return core.block.itemCapacity - core.items.get(item);
  }

  @Override
  public String localized() {
    return Core.bundle.get("ability.deathitemdrop");
  }
}
