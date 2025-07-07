package sc.entities.comp;

import ent.anno.Annotations.EntityComponent;
import ent.anno.Annotations.Import;
import ent.anno.Annotations.SyncLocal;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.units.BuildPlan;
import mindustry.game.Team;
import mindustry.gen.Bullet;
import mindustry.gen.Groups;
import mindustry.gen.Unitc;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import sc.game.WaitTime;
import sc.type.BuildShieldUnitType;

import static mindustry.Vars.*;

import arc.func.Cons;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.util.Log;
import arc.util.Time;
import arc.util.Tmp;

@EntityComponent
abstract class ShieldBuilderComp implements Unitc {
  @Import
  UnitType type;
  @Import
  Team team;
  @Import
  float x, y, rotation, buildSpeedMultiplier;

  @SyncLocal
  transient float shieldHealth = 10000f;
  @SyncLocal
  transient float shieldMaxHealth = 10000f;
  @SyncLocal
  transient float regenRate = 1f;
  @SyncLocal
  transient float cooldown = 600f, temp;
  @SyncLocal
  transient float widthScale = 0.8f, alpha, angle = 365f;
  @SyncLocal
  transient boolean open = true;

  protected transient BuildPlan last;
  transient BuildPlan currentPlan;
  public boolean drawArc = true;
  protected static Vec2 paramPos = new Vec2();
  protected Cons<Bullet> bulletc;

  @Override
  public void setType(UnitType type) {
    if (!(type instanceof BuildShieldUnitType)) {
      throw new IllegalArgumentException("ShieldBuilderUnit must use ShieldBuilderUnitType");
    }
    bulletc = b -> {
      if (b.team != this.team &&
          b.type.absorbable &&
          currentPlan != null &&
          !(b.within(paramPos, getRange(currentPlan) - getWidth(currentPlan) / 2) &&
              paramPos.within(b.x - b.deltaX, b.y - b.deltaY, getRange(currentPlan) - getWidth(currentPlan) / 2f))
          &&
          (Tmp.v1.set(b).add(b.deltaX, b.deltaY).within(paramPos, getRange(currentPlan) + getWidth(currentPlan) / 2f)
              || b.within(paramPos, getRange(currentPlan) + getWidth(currentPlan) / 2f))
          &&
          (Angles.within(paramPos.angleTo(b), 0f, angle / 2f)
              || Angles.within(paramPos.angleTo(b.x + b.deltaX, b.y + b.deltaY), 0f, angle / 2f))) {
        b.absorb();
        Fx.absorb.at(b);
        if (shieldHealth <= b.damage()) {
          shieldHealth -= cooldown * regenRate;

          Fx.arcShieldBreak.at(paramPos.x, paramPos.y, 0,
              Color.valueOf("ff0000").shiftHue((Time.time * 0.2f) + (1f * (360 / 16))));
        }

        shieldHealth -= b.damage();
        alpha = 1f;
      }
    };
  }

  @Override
  public void update() {
    if (!open) {
      boolean b = WaitTime.waittime(cooldown);
      if (b)
        open = true;
      return;
    }
    if (shieldHealth <= 0.01) {
      open = false;
      return;
    }
    currentPlan = buildPlan();
    if (shieldHealth < shieldMaxHealth)
      shieldHealth += regenRate;

    boolean active = activelyBuilding() && shieldHealth > 0;
    alpha = Math.max(alpha - Time.delta / 10f, 0f);
    if (active && currentPlan != null) {
      widthScale = Mathf.lerpDelta(widthScale, 1f, 0.06f);
      int tileX = currentPlan.x;
      int tileY = currentPlan.y;
      float worldX = tileX * tilesize + currentPlan.block.offset;
      float worldY = tileY * tilesize + currentPlan.block.offset;
      paramPos.set(worldX, worldY);
      float reach = getRange(currentPlan) + getWidth(currentPlan) / 2f;
      Groups.bullet.intersect(paramPos.x - reach, paramPos.y - reach, reach * 2f, reach * 2f, bulletc);
    } else {
      widthScale = Mathf.lerpDelta(widthScale, 0f, 0.11f);
    }
  }

  @Override
  public void drawBuildingBeam(float px, float py) {
    currentPlan = buildPlan();
    boolean active = activelyBuilding() && shieldHealth > 0;
    if (!active && last == null) {
      return;
    }
    if (currentPlan != null) {
      int tileX = currentPlan.x;
      int tileY = currentPlan.y;
      int worldX = tileX * tilesize;
      int worldY = tileY * tilesize;
      if (widthScale > 0.001f) {
        Draw.z(Layer.shields);
        Draw.color(Color.valueOf("ff0000").shiftHue((Time.time * 0.2f) + (1f * (360f / 16f))), Color.white,
            Mathf.clamp(this.alpha));// 变色
        if (!Vars.renderer.animateShields) {
          Draw.alpha(0.4f);
        }
        if (drawArc) {
          Lines.stroke(currentPlan.block.size * 2 * widthScale);
          Lines.arc(worldX + currentPlan.block.offset, worldY + currentPlan.block.offset, getRange(currentPlan),
              angle / 360f);
        } /*
           * Draw.color(Color.red);
           * Fill.rect(worldX + currentPlan.block.offset,
           * worldY + 2 * currentPlan.block.offset + getRange(currentPlan) + 10f,
           * getRange(currentPlan) * 2, 4f);
           * Draw.color(Color.green);
           * Fill.rect(worldX + currentPlan.block.offset,
           * worldY + 2 * currentPlan.block.offset + getRange(currentPlan) + 10f,
           * getRange(currentPlan) * 2 * (shieldHealth / shieldMaxHealth), 4f);
           */
        Draw.reset();
      }
    } else {
      return;
    }
  }

  public float getWidth(BuildPlan currentPlan) {
    return currentPlan.block.size * 2 * widthScale;
  }

  public float getRange(BuildPlan currentPlan) {
    return currentPlan.block.size * (tilesize + 1);
  }
}
