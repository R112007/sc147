package sc.game;

import arc.struct.ObjectMap;
import arc.util.serialization.Json;
import arc.util.serialization.JsonValue;
import arc.util.serialization.Json.Serializer;

/**
 * UnitInfoSerializer
 */
public class UnitInfoSerializer implements Serializer<UnitInfo> {
  @Override
  public void write(Json json, UnitInfo object, Class knownType) {
    json.writeObjectStart();
    json.writeField(object, "planetName", "planetName");
    json.writeField(object, "sectorId", "sectorId");
    json.writeField(object, "id", "id");
    json.writeField(object, "export", "export");
    json.writeField(object, "imports", "imports");
    json.writeObjectEnd();
  }

  @Override
  public UnitInfo read(Json json, JsonValue jsonData, Class type) {
    // 1. 读取JSON中的字段值
    String planetName = jsonData.getString("planetName");
    int sectorId = jsonData.getInt("sectorId");
    int id = jsonData.getInt("id");

    // 2. 手动创建UnitInfo实例（通过反射绕过final字段初始化限制）
    UnitInfo unitInfo;
    try {
      // 使用反射创建实例，跳过构造函数（适用于final字段）
      unitInfo = (UnitInfo) UnitInfo.class.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException("创建UnitInfo实例失败", e);
    }

    // 3. 手动设置字段值（包括final字段，需通过反射突破访问限制）
    try {
      // 设置final字段（需反射修改字段的访问权限）
      setFinalField(UnitInfo.class, unitInfo, "planetName", planetName);
      setFinalField(UnitInfo.class, unitInfo, "sectorId", sectorId);
      setFinalField(UnitInfo.class, unitInfo, "id", id);

      unitInfo.export = json.readValue("export", ObjectMap.class, jsonData);
      unitInfo.imports = json.readValue("imports", ObjectMap.class, jsonData);
    } catch (Exception e) {
      throw new RuntimeException("设置UnitInfo字段失败", e);
    }

    return unitInfo;
  }

  private void setFinalField(Class<?> clazz, Object obj, String fieldName, Object value) throws Exception {
    java.lang.reflect.Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true); // 突破private限制
    java.lang.reflect.Field modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
    field.set(obj, value);
  }
}
