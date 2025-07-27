package sc.game;

import arc.files.Fi;
import arc.util.Log;
import arc.util.serialization.Json;
import mindustry.Vars;

public class UnitInfoFileStorage {

  private static final Fi saveFile = Vars.dataDirectory.child("unitinfo.bin");
  private static final Json json = new Json();

  public static void saveAll() {
    try {
      String jsonData = json.toJson(UnitInfo.all);
      saveFile.writeString(jsonData, false);
      Log.info("UnitInfo.all 保存成功，路径：" + saveFile.absolutePath());
    } catch (Exception e) {
      Log.err("UnitInfo.all 保存失败", e);
    }
  }

  public static void loadAll() {
    if (!saveFile.exists()) {
      Log.info("UnitInfo 存储文件不存在，初始化空数组");
      UnitInfo.all = new UnitInfo[2000];
      return;
    }
    try {
      String jsonData = saveFile.readString();
      UnitInfo[] restored = json.fromJson(UnitInfo[].class, jsonData);
      if (restored.length != UnitInfo.all.length) {
        Log.warn("恢复的数组长度不匹配，使用空数组");
        UnitInfo.all = new UnitInfo[2000];
      } else {
        UnitInfo.all = restored;
        Log.info("UnitInfo.all 恢复成功，共 " + countValidEntries() + " 条有效数据");
      }
    } catch (Exception e) {
      Log.err("UnitInfo.all 恢复失败，使用空数组", e);
      UnitInfo.all = new UnitInfo[2000];
    }
  }

  private static int countValidEntries() {
    int count = 0;
    for (UnitInfo info : UnitInfo.all) {
      if (info != null)
        count++;
    }
    return count;
  }
}
