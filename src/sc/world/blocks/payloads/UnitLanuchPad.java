package sc.world.blocks.payloads;

import arc.Core;
import arc.Graphics.Cursor;
import arc.Graphics.Cursor.SystemCursor;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.scene.ui.layout.Table;
import arc.struct.EnumSet;
import arc.struct.ObjectMap;
import arc.util.Log;
import arc.util.Nullable;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.gen.Player;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.LAccess;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.Sector;
import mindustry.type.UnitType;
import mindustry.ui.Bar;
import mindustry.ui.Styles;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.PayloadBlock;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import sc.game.WaitTime;

import static mindustry.Vars.*;

/**
 * UnitLanuchPad
 */
public class UnitLanuchPad extends PayloadBlock {
  public float launchTime = 1f;
  public float payloadsCapacity = 150;
  public Sound launchSound = Sounds.none;
  public TextureRegion lightRegion;
  public TextureRegion podRegion;
  public Color lightColor = Color.valueOf("eab678");
  public float lightStep = 1f;
  public int lightSteps = 3;
  public float liquidPad = 2f;
  public @Nullable Liquid drawLiquid;
  public Color bottomColor = Pal.darkerMetal;

  public UnitLanuchPad(String name) {
    super(name);
    this.solid = true;
    this.update = true;
    this.configurable = true;
    this.hasItems = false;
    // this.outputsPayload = true;
    this.flags = EnumSet.of(BlockFlag.launchPad);
    this.acceptsUnitPayloads = true;
    this.rotate = false;
    this.payloadSpeed = 1.2f;
    this.clipSize = 120;
  }

  @Override
  public void setStats() {
    super.setStats();
    stats.add(Stat.launchTime, launchTime / 60f, StatUnit.seconds);
  }

  @Override
  public boolean outputsItems() {
    return false;
  }

  @Override
  public void load() {
    this.lightRegion = Core.atlas.find(this.name + "-light");
    this.podRegion = Core.atlas.find(this.name + "-pod");
    super.load();
  }

  @Override
  public void setBars() {
    super.setBars();
    addBar("payloadsCapacity",
        (UnitLanuchPadBuild build) -> new Bar(() -> Core.bundle.format("bar.payloadsCapacity", build.payloadsTotal),
            () -> Pal.items, () -> (float) build.payloadsTotal / payloadsCapacity));
    addBar("progress", (UnitLanuchPadBuild build) -> new Bar(() -> Core.bundle.get("bar.launchcooldown"),
        () -> Pal.ammo, () -> Mathf.clamp(build.launchCounter / launchTime)));
  }

  public static class UnitCount {
    public UnitType unittype;
    public int amount;

    public UnitCount(UnitType unit, int amount) {
      this.unittype = unit;
      this.amount = amount;
    }
  }

  public class UnitLanuchPadBuild extends PayloadBlockBuild<Payload> {
    public float payloadsTotal;
    public float launchCounter;
    public ObjectMap<String, UnitCount> unitmap = new ObjectMap<>();

    @Override
    public void updateTile() {
      boolean b = WaitTime.waittime(120);
      super.updateTile();
      if (moveInPayload(false) && efficiency > 0) {
        UnitType payloadUnit = (UnitType) payload;
        addUnit((UnitType) payload);
        payload = null;
        payloadsTotal += payloadUnit.hitSize;
      }
      if (b) {
        for (var unit : unitmap.entries()) {
          Log.info("单位种类 " + unit.key);
          Log.info("单位数量 " + unit.value.amount);
        }

      }
    }

    public void addUnit(UnitType unittype) {
      for (var unit : unitmap.entries()) {
        if (unittype.name == unit.key) {
          unit.value.amount++;
          return;
        }
      }
      unitmap.put(unittype.name, new UnitCount(unittype, 1));
    }

    @Override
    public Cursor getCursor() {
      return !state.isCampaign() || net.client() ? SystemCursor.arrow : super.getCursor();
    }

    @Override
    public boolean shouldConsume() {
      return launchCounter < launchTime;
    }

    @Override
    public boolean acceptUnitPayload(Unit unit) {
      return true;// payloadsCapacity - payloadsTotal >= unit.type.hitSize;
    }

    @Override
    public double sense(LAccess sensor) {
      if (sensor == LAccess.progress)
        return Mathf.clamp(launchCounter / launchTime);
      return super.sense(sensor);
    }

    @Override
    public void draw() {
      super.draw();
      if (lightRegion.found()) {
        Draw.color(lightColor);
        float progress = Math.min((float) items.total() / itemCapacity, launchCounter / launchTime);
        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < lightSteps; j++) {
            float alpha = Mathf.curve(progress, (float) j / lightSteps, (j + 1f) / lightSteps);
            float offset = -(j - 1f) * lightStep;
            Draw.color(Pal.metalGrayDark, lightColor, alpha);
            Draw.rect(lightRegion, x + Geometry.d8edge(i).x * offset, y + Geometry.d8edge(i).y * offset, i * 90);
          }
        }
        Draw.reset();
      }
      Drawf.shadow(x, y, size * tilesize);
      Draw.rect(podRegion, x, y);

      Draw.reset();
    }

    @Override
    public boolean acceptItem(Building source, Item item) {
      return false;
    }

    @Override
    public void display(Table table) {
      super.display(table);

      if (!state.isCampaign() || net.client() || team != player.team())
        return;

      table.row();
      table.label(() -> {
        Sector dest = state.rules.sector == null ? null : state.rules.sector.info.destination;

        return Core.bundle.format("launch.destination",
            dest == null || !dest.hasBase() ? Core.bundle.get("sectors.nonelaunch") : "[accent]" + dest.name());
      }).pad(4).wrap().width(200f).left();
    }

    @Override
    public boolean shouldShowConfigure(Player player) {
      return state.isCampaign();
    }

    @Override
    public void buildConfiguration(Table table) {
      if (!state.isCampaign() || net.client()) {
        deselect();
        return;
      }

      table.button(Icon.upOpen, Styles.cleari, () -> {
        ui.planet.showSelect(state.rules.sector, other -> {
          if (state.isCampaign() && other.planet == state.rules.sector.planet) {
            var prev = state.rules.sector.info.destination;
            state.rules.sector.info.destination = other;
            if (prev != null) {
              prev.info.refreshImportRates(state.getPlanet());
            }
          }
        });
        deselect();
      }).size(40f);
    }

    @Override
    public byte version() {
      return 1;
    }

    @Override
    public void write(Writes write) {
      super.write(write);
      write.f(launchCounter);
    }

    @Override
    public void read(Reads read, byte revision) {
      super.read(read, revision);
      if (revision >= 1) {
        launchCounter = read.f();
      }
    }
  }
}
