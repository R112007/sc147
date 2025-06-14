package sc.world.blocks.production;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import arc.util.Nullable;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.input.InputHandler;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.BaseTurret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.consumers.ConsumeLiquidBase;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.*;

public class DrillTurret extends BaseTurret {
    public final int timerTarget = timers++;
    public final float retargetTime = 3f;

    public TextureRegion baseRegion, laser, laserEnd;
    public float laserWidth = 0.75f;
    public Sound shootSound = Sounds.minebeam;
    public float shootSoundVolume = 0.9f;

    /** Drill tiers, inclusive */
    public int minDrillTier = 0, maxDrillTier = 3;
    public float mineSpeed = 0.75f;
    public float laserOffset = 4f, shootCone = 6f;

    public @Nullable ConsumeLiquidBase consumeCoolant;

    public DrillTurret(String name) {
        super(name);

        sync = true;
        hasItems = true;
        outlineIcon = true;
    }

    @Override
    public TextureRegion[] icons() {
        return new TextureRegion[] { baseRegion, region };
    }

    @Override
    public void load() {
        super.load();
        baseRegion = Core.atlas.find(name + "-base", "block-" + size);
        laser = Core.atlas.find(name + "-laser", "minelaser");
        laserEnd = Core.atlas.find(name + "-laser-end", "minelaser-end");
    }

    public boolean canDrill(Floor f) {
        return f.itemDrop != null && f.itemDrop.hardness >= minDrillTier && f.itemDrop.hardness <= maxDrillTier;
    }

    @Override
    public void setStats() {
        super.setStats();

        stats.add(Stat.range, range / tilesize, StatUnit.blocks);
        stats.addPercent(Stat.mineSpeed, mineSpeed);
        stats.add(Stat.drillTier, table -> {
            table.left();
            Seq<Block> list = Vars.content.blocks().select(b -> (b instanceof Floor) && canDrill((Floor) b));

            table.table(l -> {
                l.left();

                for (int i = 0; i < list.size; i++) {
                    Block item = list.get(i);

                    l.image(item.uiIcon).size(8 * 3).padRight(2).padLeft(2).padTop(3).padBottom(3);
                    l.add(item.localizedName).left().padLeft(1).padRight(4);
                    if (i % 5 == 4) {
                        l.row();
                    }
                }
            });
        });
    }

    public class DrillTurretBuild extends BaseTurretBuild {
        public @Nullable Tile mineTile, ore;
        public @Nullable Item targetItem;
        public float mineTimer = 0f, coolant = 1f;
        protected Seq<Tile> proxOres;
        protected Seq<Item> proxItems;
        protected int targetID = -1;

        @Override
        public void created() {
            super.created();
            reMap();
        }

        public void reMap() {
            proxOres = new Seq<>();
            proxItems = new Seq<>();
            ObjectSet<Item> tempItems = new ObjectSet<>();

            Geometry.circle(tile.x, tile.y, (int) (range / tilesize + 0.5f), (x, y) -> {
                Tile other = world.tile(x, y);
                if (other != null && other.drop() != null) {
                    Item drop = other.drop();
                    if (!tempItems.contains(drop)) {
                        tempItems.add(drop);
                        proxItems.add(drop);
                        proxOres.add(other);
                    }
                }
            });
        }

        public void reFind(int i) {
            Item item = proxItems.get(i);

            Geometry.circle(tile.x, tile.y, (int) (range / tilesize + 0.5f), (x, y) -> {
                Tile other = world.tile(x, y);
                if (other != null && other.drop() != null && other.drop() == item && other.block() == Blocks.air) {
                    proxOres.set(i, other);
                }
            });
        }

        public boolean canMine(Item item) {
            return item.hardness >= minDrillTier && item.hardness <= maxDrillTier;
        }

        public float efficiency() {
            return this.efficiency * coolant;
        }

        @Override
        public void draw() {
            Draw.rect(baseRegion, x, y);
            Drawf.shadow(region, x - (size / 2f), y - (size / 2f), rotation - 90);
            Draw.rect(region, x, y, rotation - 90);

            drawMine();
        }

        @Override
        public void updateTile() {
            Building core = state.teams.closestCore(x, y, team);

            // target ore
            targetMine(core);
            if (core == null || mineTile == null || !canConsume()
                    || !Angles.within(rotation, angleTo(mineTile), shootCone)
                    || items.get(mineTile.drop()) >= itemCapacity) {
                mineTile = null;
                mineTimer = 0f;
            }

            if (mineTile != null) {
                // consume coolant
                if (consumeCoolant != null) {
                    float maxUsed = consumeCoolant.amount;

                    Liquid liquid = liquids.current();

                    float used = Math.min(Math.min(liquids.get(liquid), maxUsed * Time.delta),
                            Math.max(0, (1f / coolantMultiplier) / liquid.heatCapacity));

                    liquids.remove(liquid, used);

                    if (Mathf.chance(0.06 * used)) {
                        coolEffect.at(x + Mathf.range(size * tilesize / 2f), y + Mathf.range(size * tilesize / 2f));
                    }

                    coolant = 1f + (used * liquid.heatCapacity * coolantMultiplier);
                }

                // mine tile
                Item item = mineTile.drop();
                mineTimer += Time.delta * mineSpeed * efficiency();

                if (Mathf.chance(0.06 * Time.delta)) {
                    Fx.pulverizeSmall.at(mineTile.worldx() + Mathf.range(tilesize / 2f),
                            mineTile.worldy() + Mathf.range(tilesize / 2f), 0f, item.color);
                }

                if (mineTimer >= 50f + item.hardness * 15f) {
                    mineTimer = 0;

                    if (state.rules.sector != null && team() == state.rules.defaultTeam)
                        state.rules.sector.info.handleProduction(item, 1);

                    // items are synced anyways
                    InputHandler.transferItemTo(null, item, 1,
                            mineTile.worldx() + Mathf.range(tilesize / 2f),
                            mineTile.worldy() + Mathf.range(tilesize / 2f),
                            this);
                }

                if (!headless) {
                    control.sound.loop(shootSound, this, shootSoundVolume);
                }
            }

            if (timer.get(timerDump, dumpTime))
                dump();
        }

        public @Nullable Item iterateMap(Building core) {
            if (proxOres == null || !proxOres.any() || core == null)
                return null;

            Item targetItem = null;
            int minStock = Integer.MAX_VALUE; // 初始化为最大值

            // 遍历所有可开采物品
            for (int i = 0; i < proxItems.size; i++) {
                Item item = proxItems.get(i);

                // 跳过炮塔/核心库存已满的物品
                if (!canMine(item) || core.items.get(item) >= core.block.itemCapacity)
                    continue;

                int coreStock = core.items.get(item);
                if (coreStock < minStock) {
                    // 检查瓷砖是否可开采（空气块）
                    Tile oreTile = proxOres.get(i);
                    if (oreTile.block() == Blocks.air) {
                        minStock = coreStock;
                        targetItem = item;
                        targetID = i; // 记录索引
                    } else {
                        // 尝试重新定位矿石
                        reFind(i);
                        oreTile = proxOres.get(i);
                        if (oreTile.block() == Blocks.air) { // 重新定位成功
                            minStock = coreStock;
                            targetItem = item;
                            targetID = i;
                        }
                    }
                }
            }
            return targetItem;
        }

        @Override
        public void removeFromProximity() {
            // reset when pushed
            targetItem = null;
            targetID = -1;
            mineTile = null;
            super.removeFromProximity();
        }

        public void targetMine(Building core) {
            if (core == null)
                return;
            targetItem = iterateMap(core);
            if (targetItem == null || items.get(targetItem) >= itemCapacity) {
                mineTile = null;
            } else {
                if (canConsume() && timer.get(timerTarget, 60) && targetItem != null && targetID > -1) {
                    ore = proxOres.get(targetID);
                }
                if (ore != null && canConsume()) {
                    float dest = angleTo(ore);
                    rotation = Angles.moveToward(rotation, dest, rotateSpeed * edelta());
                    if (Angles.within(rotation, dest, shootCone)) {
                        mineTile = ore;
                    }
                    if (ore.block() != Blocks.air) {
                        if (targetID > -1)
                            reFind(targetID);
                        targetItem = null;
                        targetID = -1;
                        mineTile = null;
                    }
                }
            }
        }

        public void drawMine() {
            if (mineTile == null)
                return;
            float focusLen = laserOffset / 2f + Mathf.absin(Time.time, 1.1f, 0.5f);
            float swingScl = 12f, swingMag = tilesize / 8f;
            float flashScl = 0.3f;

            float px = x + Angles.trnsx(rotation, focusLen);
            float py = y + Angles.trnsy(rotation, focusLen);

            float ex = mineTile.worldx() + Mathf.sin(Time.time + 48, swingScl, swingMag);
            float ey = mineTile.worldy() + Mathf.sin(Time.time + 48, swingScl + 2f, swingMag);

            Draw.z(Layer.flyingUnit + 0.1f);

            Draw.color(Color.lightGray, Color.white, 1f - flashScl + Mathf.absin(Time.time, 0.5f, flashScl));

            Drawf.laser(laser, laserEnd, px, py, ex, ey, laserWidth);

            Draw.color();
        }

        @Override
        public void write(Writes write) {
            super.write(write);

            write.f(rotation);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);

            rotation = read.f();
        }

        @Override
        public void drawSelect() {
            if (mineTile != null) {
                Lines.stroke(1f, Pal.accent);
                Lines.poly(mineTile.worldx(), mineTile.worldy(), 4, tilesize / 2f * Mathf.sqrt2, Time.time);
                Draw.color();
            }

            super.drawSelect();
        }
    }
}
