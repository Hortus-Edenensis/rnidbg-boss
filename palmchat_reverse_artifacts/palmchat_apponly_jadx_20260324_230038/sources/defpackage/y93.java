package defpackage;

import com.zenmen.palmchat.sync.dynamic.DynamicItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y93 implements tm2 {
    @Override // defpackage.tm2
    public String a(String str) {
        DynamicItem dynamicItem = rl0.h().d().getConfigMap().get(str);
        if (dynamicItem != null && dynamicItem.isEnable()) {
            return dynamicItem.getExtra();
        }
        ma3.d("get lx config but dynamic config is null or disable");
        return null;
    }

    @Override // defpackage.tm2
    public boolean b() {
        return nh4.e().h();
    }
}
