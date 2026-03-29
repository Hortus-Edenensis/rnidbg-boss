package defpackage;

import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishConfig;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishEntranceVo;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishStateVo;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishSuccessVo;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gk4 {
    public static boolean e = false;
    public static volatile gk4 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolishEntranceVo f17741a = null;
    public PolishSuccessVo b = null;
    public PolishStateVo c = null;
    public PolishConfig d = null;

    public static String b() {
        return t66.h().e("LX-68239", "A");
    }

    public static gk4 c() {
        if (f == null) {
            synchronized (gk4.class) {
                if (f == null) {
                    f = new gk4();
                }
            }
        }
        return f;
    }

    public static boolean d() {
        return !b().equals("A") || e;
    }

    public static boolean e() {
        return WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(b()) || e;
    }

    public static boolean f() {
        return false;
    }

    public PolishConfig a() {
        DynamicItem dynamicConfig;
        PolishConfig polishConfig;
        if (this.d == null && (dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SIGN_TASK)) != null && dynamicConfig.isEnable() && (polishConfig = (PolishConfig) dynamicConfig.parseExtra(PolishConfig.class)) != null) {
            this.d = polishConfig;
        }
        if (this.d == null) {
            this.d = PolishConfig.buildDefaultConfig();
        }
        return this.d;
    }
}
