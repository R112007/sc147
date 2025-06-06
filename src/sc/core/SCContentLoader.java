package sc.core;

import arc.struct.Seq;
import mindustry.core.ContentLoader;
import mindustry.ctype.Content;
import sc.ctype.SCContentType;
import sc.type.SCSectorPreset;

@SuppressWarnings("unchecked")
public class SCContentLoader extends ContentLoader {
  private Seq<Content>[] contentMap = new Seq[SCContentType.all.length];

  public <T extends Content> Seq<T> getBy(SCContentType type) {
    return (Seq<T>) contentMap[type.ordinal()];
  }

  public Seq<SCSectorPreset> scsectors() {
    return getBy(SCContentType.scsector);
  }
}
