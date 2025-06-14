package sc.util.build;

import arc.struct.IntMap;
import arc.struct.ObjectSet;
import mindustry.gen.Building;

public class BlockList {
  public ObjectSet<Building> array = new ObjectSet<>();
  public IntMap<Building> listMap = new IntMap<>();

  public void push(Building entity) {
    this.array.add(entity);
    listMap.put(entity.pos(), entity);
  }

  public Building find(Building entity) {
    if (entity == null)
      return null;
    if (array.add(entity)) {
      return listMap.get(entity.pos());
    } else {
      return null;
    }
  }

  public Building findByPos(int pos) {
    return listMap.get(pos);
  }

  public void remove(Building entity) {
    array.remove(entity);
    listMap.remove(entity.pos());
  }

  public static abstract class Data {
    public float health;
    public float maxHealth;

    protected Data() {
    }

    public Data(Building entity) {
      if (entity == null)
        return;
      this.health = entity.health;
      this.maxHealth = entity.block.health;
    }

    public Data set(float h) {
      this.health = h;
      return this;
    }

    public float getHealth() {
      return health;
    }

    public float getMax() {
      return maxHealth;
    }
  }
}
