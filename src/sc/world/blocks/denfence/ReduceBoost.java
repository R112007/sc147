package sc.world.blocks.denfence;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import sc.world.meta.SCStat;
import sc.world.meta.SCStatUnit;

import static mindustry.Vars.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Log;
import arc.util.Time;
import arc.util.Tmp;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.Ranged;
import mindustry.ui.Bar;

public class ReduceBoost extends Block {
  public float range;
  public float percent;
  public Color baseColor;
  int temp = 1;

  public ReduceBoost(String name) {
    super(name);
    this.update = true;
    this.solid = true;
    this.hasPower = true;
    this.consumePower(10f);
    this.range = 100f;
    this.percent = 0.1f;
    this.category = Category.effect;
    this.baseColor = Pal.accent;
  }

  @Override
  public void setStats() {
    super.setStats();
    stats.add(Stat.range, this.range / 8, StatUnit.blocks);
    stats.add(SCStat.reducepercent, this.percent * 100 + "%", SCStatUnit.reduce);
  }

  @Override
  public void setBars() {
    super.setBars();
    addBar("boost",
        (ReduceBoostBuild entity) -> new Bar(
            () -> Core.bundle.format("bar.reduceboost", Mathf.round(Math.max(entity.realpercent() * 100f, 0))),
            () -> Pal.accent, () -> percent / entity.realpercent()));
  }

  @Override
  public boolean outputsItems() {
    return false;
  }

  @Override
  public void drawPlace(int x, int y, int rotation, boolean valid) {
    super.drawPlace(x, y, rotation, valid);
    Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, baseColor);
    for (Team t : getteam()) {
      indexer.eachBlock(t, x * tilesize + offset, y * tilesize + offset, range,
          other -> other.block.health > 0,
          other -> Drawf.selected(other, Tmp.c1.set(baseColor).a(Mathf.absin(4f, 1f))));
    }
  }

  public static Team[] getteam() {
    List<Team> otherteam = new ArrayList<>();

    for (Team team : Team.all) {
      if (team.id != player.team().id && team != null) {
        otherteam.add(team);
      }
    }
    return otherteam.toArray(new Team[0]);
  }

  public class ReduceBoostBuild extends Building implements Ranged {
    float timer = 0f;
    Team[] teamarray = new Team[256];

    @Override
    public float range() {
      return range;
    }

    @Override
    public void updateTile() {
      if (temp == 1) {
        teamarray = getteam();
        temp = 0;
        remove(teamarray);
      }
      if (efficiency > 0) {
        for (Team t : teamarray) {
          indexer.eachBlock(t, getX(), getY(), range * efficiency,
              other -> other.block.health > 0,
              other -> other.applySlowdown(realpercent(), 61f));
        }
      }
    }

    public float realpercent() {
      return 1f - ((1f - percent) * efficiency);
    }

    public Team[] remove(Team[] t) {
      int index = -1;
      for (int i = 0; i < t.length; i++) {
        if (t[i].id == player.team().id) {
          index = i;
          break;
        }
      }
      if (index == -1) {
        return t;
      }
      Team[] returnarray = new Team[t.length - 1];
      for (int j = 0; j < index; j++) {
        returnarray[j] = t[j];
      }
      for (int j = index; j < returnarray.length; j++) {
        returnarray[j] = t[j + 1];
      }
      return returnarray;
    }

    @Override
    public void drawLight() {
      Drawf.light(x, y, lightRadius * efficiency, baseColor, 0.7f * efficiency);
    }

    @Override
    public void drawSelect() {
      for (Team t : teamarray) {
        indexer.eachBlock(t, getX(), getY(), range * efficiency,
            other -> other.block.health > 0,
            other -> Drawf.selected(other, Tmp.c1.set(baseColor).a(Mathf.absin(4f, 1f))));
      }
      Drawf.dashCircle(x, y, range * efficiency, baseColor);
    }

    @Override
    public void write(Writes write) {
      super.write(write);
      write.i(teamarray.length);
      for (Team team : teamarray) {
        if (team != null) {
          write.i(team.id);
        }
      }
    }

    @Override
    public void read(Reads read, byte revision) {
      super.read(read, revision);
      int length = read.i();
      teamarray = new Team[length];
      for (int i = 0; i < length; i++) {
        int id = read.i();
        teamarray[i] = Team.get(id);
      }
    }
  }
}
