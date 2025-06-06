package sc.world.blocks.distribution;

import arc.audio.Sound;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.scene.ui.layout.Table;
import arc.struct.EnumSet;
import arc.util.Nullable;
import mindustry.Vars;
import mindustry.content.Liquids;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.gen.Player;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Liquid;
import mindustry.ui.Bar;
import mindustry.ui.ReqImage;
import mindustry.ui.Styles;
import mindustry.world.Block;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.Stats;
import sc.annotations.Annotations.Load;

public class SCLaunchPad extends Block {

    public float launchTime = 150f;
    public Sound launchSound = Sounds.none;
    public @Load("@-light") TextureRegion lightRegion;
    public @Load(value = "@-pod", fallback = "launchpod") TextureRegion podRegion;
    public Color lightColor = Color.valueOf("eab678");
    public boolean acceptMultipleItems = true;
    public @Nullable float consumeLiquidAmount;
    public @Nullable Liquid consumeLiquid;
    public float liquidPad = 2f;
    public Color bottomColor = Pal.darkerMetal;

    public SCLaunchPad(String name) {
        super(name);
        hasItems = true;
        solid = true;
        update = true;
        configurable = true;
        flags = EnumSet.of(BlockFlag.launchPad);
        acceptsItems = true;
        canOverdrive = true;
        emitLight = true;
        lightRadius = 60f;
        itemCapacity = 500;
    }

    @Override
    public void init() {
        if (consumeLiquid != null && consumeLiquidAmount > 0) {
            hasLiquids = true;
            consume(new ConsumeLiquid(consumeLiquid, consumeLiquidAmount) {

                @Override
                public void build(Building build, Table table) {
                    table.add(new ReqImage(liquid.uiIcon, () -> build.liquids.get(liquid) >= amount)).size(8 * 4f).top()
                            .left();
                }

                @Override
                public float efficiency(Building build) {
                    return build.liquids.get(consumeLiquid) >= amount ? 1f : 0f;
                }

                @Override
                public void display(Stats stats) {
                    stats.add(Stat.input, liquid, amount, false);
                }
            }).update(false);
        } else if (consumeLiquid != null && consumeLiquidAmount == 0f) {
            hasLiquids = true;
            consumeLiquidAmount = 500f;
            consume(new ConsumeLiquid(consumeLiquid, consumeLiquidAmount) {

                @Override
                public void build(Building build, Table table) {
                    table.add(new ReqImage(liquid.uiIcon, () -> build.liquids.get(liquid) >= amount)).size(8 * 4f).top()
                            .left();
                }

                @Override
                public float efficiency(Building build) {
                    return build.liquids.get(consumeLiquid) >= amount ? 1f : 0f;
                }

                @Override
                public void display(Stats stats) {
                    stats.add(Stat.input, liquid, amount, false);
                }
            }).update(false);
        } else {
            hasLiquids = true;
            consumeLiquid = Liquids.water;
            consume(new ConsumeLiquid(consumeLiquid, consumeLiquidAmount) {

                @Override
                public void build(Building build, Table table) {
                    table.add(new ReqImage(liquid.uiIcon, () -> build.liquids.get(liquid) >= amount)).size(8 * 4f).top()
                            .left();
                }

                @Override
                public float efficiency(Building build) {
                    return build.liquids.get(consumeLiquid) >= amount ? 1f : 0f;
                }

                @Override
                public void display(Stats stats) {
                    stats.add(Stat.input, liquid, amount, false);
                }
            }).update(false);
        }
        if (liquidCapacity < consumeLiquidAmount) {
            liquidCapacity = 2 * consumeLiquidAmount;
        }
        super.init();
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
    public void setBars() {
        super.setBars();

    }

    public class SCLaunchPadBuild extends Building {

    }
}
