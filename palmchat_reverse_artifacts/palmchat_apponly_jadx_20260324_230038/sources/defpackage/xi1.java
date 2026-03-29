package defpackage;

import com.zenmen.palmchat.framework.config.DynamicVo;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xi1 implements pl2 {
    @Override // defpackage.pl2
    public String a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.RISK_USER);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return null;
        }
        return dynamicConfig.getExtra();
    }

    @Override // defpackage.pl2
    public boolean b() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.WIFIGUIDE);
        if (dynamicConfig == null) {
            return false;
        }
        return dynamicConfig.isEnable();
    }

    @Override // defpackage.pl2
    public boolean c() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MOMENTS);
        if (dynamicConfig == null) {
            return false;
        }
        return dynamicConfig.isEnable();
    }

    @Override // defpackage.pl2
    public String d() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.WIFIGUIDE);
        return dynamicConfig == null ? "" : dynamicConfig.getExtra();
    }

    @Override // defpackage.pl2
    public DynamicVo e(String str) {
        return rl0.h().d().getDynamicConfig(str);
    }
}
