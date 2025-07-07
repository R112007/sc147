package sc.type;

import ent.anno.Annotations.SyncField;
import mindustry.game.Team;
import mindustry.gen.Unit;
import mindustry.type.UnitType;
import sc.gen.ShieldBuilderc;

public class BuildShieldUnitType extends UnitType {
  @SyncField(value = true)
  public float shieldHealth = 1200f; // 护盾最大生命值
  @SyncField(value = true)
  public float shieldRegenRate = 3f; // 护盾再生速率
  @SyncField(value = true)
  public int shieldSegments = 36; // 护盾分段数

  public BuildShieldUnitType(String name) {
    super(name);
    this.buildSpeed = 1f;
  }

}
