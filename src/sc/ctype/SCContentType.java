package sc.ctype;

import arc.util.Nullable;
import mindustry.ctype.Content;
import sc.type.SCSectorPreset;

public enum SCContentType {
  scsector(SCSectorPreset.class);

  public static final SCContentType[] all = values();

  public final @Nullable Class<? extends Content> contentClass;

  SCContentType(Class<? extends Content> contentClass) {
    this.contentClass = contentClass;
  }
}
