package defpackage;

import com.wifi.ad.core.WifiNestAd;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nh4 {
    public static nh4 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19512a;
    public boolean b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("sw", Boolean.valueOf(nh4.this.b));
            put("conf", Boolean.valueOf(nh4.this.f()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("sw", Boolean.valueOf(nh4.this.c));
            put("conf", Boolean.valueOf(nh4.this.j()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("sw", Boolean.valueOf(nh4.this.b));
            put("conf", Boolean.valueOf(nh4.this.f()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("sw", Boolean.valueOf(nh4.this.c));
            put("conf", Boolean.valueOf(nh4.this.j()));
        }
    }

    public nh4() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        this.b = sPUtil.a(scene, "key_settings_privacy_personalized_ad_new", false);
        this.f19512a = sPUtil.a(scene, "key_settings_privacy_personalized_content", true);
        this.c = sPUtil.a(scene, "key_settings_privacy_personalized_smallvideo", true);
    }

    public static nh4 e() {
        if (d == null) {
            synchronized (nh4.class) {
                if (d == null) {
                    d = new nh4();
                }
            }
        }
        return d;
    }

    public final boolean f() {
        JSONObject jSONObjectU = ts0.o().u();
        return jSONObjectU != null && jSONObjectU.optBoolean("personalized_ad");
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.f19512a;
    }

    public boolean i(boolean z) {
        boolean zB = jo6.B();
        if (zB && z) {
            LogUtil.uploadInfoImmediate("personalized_ad_show", new a());
            LogUtil.uploadInfoImmediate("personalized_smallvideo_show", new b());
        }
        return zB;
    }

    public final boolean j() {
        JSONObject jSONObjectU = ts0.o().u();
        return jSONObjectU != null && jSONObjectU.optBoolean("personalized_smallvideo");
    }

    public boolean k() {
        return this.c;
    }

    public void l(boolean z) {
        this.b = z;
        tu3.A(z);
        if (tu3.x()) {
            WifiNestAd.INSTANCE.updatePersonAd(this.b);
        }
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_settings_privacy_personalized_ad_new", Boolean.valueOf(this.b));
        LogUtil.uploadInfoImmediate("personalized_ad", new c());
    }

    public void m(boolean z) {
        this.f19512a = z;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_settings_privacy_personalized_content", Boolean.valueOf(z));
    }

    public void n(boolean z) {
        this.c = z;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_settings_privacy_personalized_smallvideo", Boolean.valueOf(z));
        LogUtil.uploadInfoImmediate("personalized_smallvideo", new d());
    }
}
