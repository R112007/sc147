package sc.world.blocks.distribution;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.Rand;
import arc.util.Log;
import arc.util.Time;
import arc.util.Tmp;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.Ranged;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.WallCrafter;
import mindustry.world.blocks.production.Drill.DrillBuild;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import sc.graphics.SCPal;
import sc.world.meta.SCStat;

import static mindustry.Vars.*;

public class DropDrillItem extends Block {
  public float range;
  public float reload;
  public Effect workingeffect;
  public Effect completeeffect;
  public Color baseColor = SCPal.light_blue1;

  public DropDrillItem(String name) {
    super(name);
    this.group = BlockGroup.transportation;
    this.category = Category.distribution;
    this.range = 80f;
    this.reload = 600f;
    this.workingeffect = Fx.none;
    this.completeeffect = Fx.none;
    this.update = true;
    this.solid = true;
    this.hasItems = true;
    this.hasLiquids = false;
    this.itemCapacity = 200;
  }

  @Override
  public void setStats() {
    super.setStats();
    stats.add(Stat.range, this.range / 8, StatUnit.blocks);
    stats.add(SCStat.waittime, this.reload / 60, StatUnit.seconds);
  }

  @Override
  public void setBars() {
    super.setBars();
    addBar("reload",
        (DropDrillItemBuild entity) -> new Bar("dropdrillitem.reload", Pal.accent, () -> entity.timer / reload)
            .blink(Color.white));
  }

  @Override
  public void drawPlace(int x, int y, int rotation, boolean valid) {
    super.drawPlace(x, y, rotation, valid);
    Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, baseColor);
    indexer.eachBlock(player.team(), x * tilesize + offset, y * tilesize + offset, range,
        other -> other.block instanceof Drill || other.block instanceof BeamDrill || other.block instanceof WallCrafter,
        other -> Drawf.selected(other, Tmp.c1.set(baseColor).a(Mathf.absin(4f, 1f))));

  }

  public class DropDrillItemBuild extends Building implements Ranged {
    public float timer = 0f;
    public float timer1 = 0f;
    public Rand rand = new Rand();

    @Override
    public float range() {
      return range;
    }

    @Override
    public void drawLight() {
      Drawf.light(x, y, lightRadius * efficiency, baseColor, 0.7f * efficiency);
    }

    @Override
    public void updateTile() {
      if (efficiency > 0) {
        timer += this.delta() * efficiency;
        timer1 += Time.delta * efficiency;
      }
      if (timer1 >= 20f) {
        workingeffect.at(x + rand.random(size), y + rand.random(size));
        timer1 = 0f;
      }
      if (timer >= reload) {
        timer = 0f;
        indexer.eachBlock(this, range,
            other -> other.block instanceof Drill || other.block instanceof BeamDrill
                || other.block instanceof WallCrafter,
            other -> other.items.each((item, amount) -> {
              if (amount > 0 && this.items.get(item) < itemCapacity) {
                if (other.items.total() >= itemCapacity - this.items.get(item)) {
                  other.items.remove(item, itemCapacity - this.items.get(item));
                  this.items.add(item, itemCapacity - this.items.get(item));

                } else if (other.items.total() < itemCapacity - this.items.get(item)) {
                  other.items.remove(item, amount);
                  this.items.add(item, amount);
                } else if (itemCapacity == this.items.get(item)) {
                  return;
                }
              }
            }));
        completeeffect.at(x + rand.random(size), y + rand.random(size));
      }

      if (this.items.total() > 0) {
        offload(this.items.take());
      }

    }

    @Override
    public void drawSelect() {
      indexer.eachBlock(this, range,
          other -> other.block instanceof Drill || other.block instanceof BeamDrill
              || other.block instanceof WallCrafter,
          other -> Drawf.selected(other, Tmp.c1.set(baseColor).a(Mathf.absin(4f, 1f))));
      Drawf.dashCircle(x, y, range, baseColor);
    }

    @Override
    public void write(Writes write) {
      super.write(write);
      write.f(timer);
    }

    @Override
    public void read(Reads read, byte revision) {
      super.read(read, revision);
      timer = read.f();
    }
  }
}
