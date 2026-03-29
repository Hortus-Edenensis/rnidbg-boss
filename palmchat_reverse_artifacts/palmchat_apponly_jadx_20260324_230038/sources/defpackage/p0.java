package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.DaemonConfig;
import com.zenmen.palmchat.Vo.GlobalConfig;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.Vo.GroupCateConfig;
import com.zenmen.palmchat.Vo.HbConfig;
import com.zenmen.palmchat.Vo.LbsUploadConfig;
import com.zenmen.palmchat.Vo.LogConfig;
import com.zenmen.palmchat.Vo.MomentsConfig;
import com.zenmen.palmchat.Vo.MucConfig;
import com.zenmen.palmchat.Vo.UrlWhiteConfig;
import com.zenmen.palmchat.Vo.WifiConfig;
import com.zenmen.palmchat.Vo.WkPromptConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p0 implements yl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LogConfig f19908a = new LogConfig();
    public GreetConfig b = new GreetConfig();
    public GlobalConfig c = new GlobalConfig();
    public LbsUploadConfig d = new LbsUploadConfig();
    public WifiConfig e = new WifiConfig();
    public MucConfig f = new MucConfig();
    public HbConfig g = new HbConfig();
    public DynamicConfig h = new DynamicConfig();
    public kn0 i = new kn0();
    public UrlWhiteConfig j = new UrlWhiteConfig();
    public x96 k = new x96();
    public GroupCateConfig l = new GroupCateConfig();
    public DaemonConfig m = new DaemonConfig();
    public WkPromptConfig n = new WkPromptConfig();

    public static void k(JSONObject jSONObject) {
        try {
            Class.forName("com.zenmen.msgprocesslib.Processor").getMethod("a", JSONObject.class, ContentResolver.class, SharedPreferences.class, String.class, String.class).invoke(null, jSONObject, AppContext.getContext().getContentResolver(), r75.j(AppContext.getContext()), pu1.e, AccountUtils.p(AppContext.getContext()));
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.yl0
    public GlobalConfig a() {
        return this.c;
    }

    @Override // defpackage.yl0
    public GroupCateConfig b() {
        return this.l;
    }

    @Override // defpackage.yl0
    public kn0 c() {
        return this.i;
    }

    @Override // defpackage.yl0
    public UrlWhiteConfig d() {
        return this.j;
    }

    @Override // defpackage.yl0
    public DynamicConfig f() {
        return this.h;
    }

    @Override // defpackage.yl0
    public GreetConfig g() {
        return this.b;
    }

    @Override // defpackage.yl0
    public MucConfig h() {
        return this.f;
    }

    public String i(Context context, String str) {
        return xp3.c("wifi_social_new_config").getString(str, "");
    }

    public boolean j(boolean z, String str, JSONObject jSONObject) {
        boolean zIsContainDyConfig;
        LogConfig logConfigD = LogConfig.d(jSONObject);
        if (logConfigD != null) {
            this.f19908a = logConfigD;
            b63.c(logConfigD);
        }
        GroupCateConfig groupCateConfigB = GroupCateConfig.b(jSONObject);
        if (groupCateConfigB != null) {
            this.l = groupCateConfigB;
        }
        GreetConfig greetConfigD = GreetConfig.d(jSONObject);
        if (greetConfigD != null) {
            this.b = greetConfigD;
        }
        GlobalConfig globalConfigH = GlobalConfig.h(jSONObject);
        if (globalConfigH != null) {
            this.c = globalConfigH;
        }
        WifiConfig wifiConfigB = WifiConfig.b(jSONObject);
        if (wifiConfigB != null) {
            this.e = wifiConfigB;
        }
        LbsUploadConfig lbsUploadConfigB = LbsUploadConfig.b(jSONObject);
        if (lbsUploadConfigB != null) {
            this.d = lbsUploadConfigB;
        }
        MucConfig mucConfigB = MucConfig.b(jSONObject);
        if (mucConfigB != null) {
            this.f = mucConfigB;
        }
        HbConfig hbConfigE = HbConfig.e(jSONObject);
        if (hbConfigE != null) {
            HbConfig.f(hbConfigE);
            this.g = hbConfigE;
        }
        DaemonConfig daemonConfigI = DaemonConfig.i(jSONObject);
        if (daemonConfigI != null) {
            this.m = daemonConfigI;
        }
        MomentsConfig momentsConfigK = MomentsConfig.k(jSONObject);
        if (momentsConfigK != null) {
            MomentsConfig.l(momentsConfigK);
        }
        if (z) {
            this.h.updateInfo(jSONObject, false);
            zIsContainDyConfig = false;
        } else {
            zIsContainDyConfig = DynamicConfig.isContainDyConfig(jSONObject);
            if (zIsContainDyConfig) {
                this.h.update(jSONObject);
            }
        }
        kn0 kn0VarE = kn0.e(jSONObject);
        if (kn0VarE != null) {
            this.i = kn0VarE;
        }
        UrlWhiteConfig urlWhiteConfigC = UrlWhiteConfig.c(jSONObject);
        if (urlWhiteConfigC != null) {
            this.j = urlWhiteConfigC;
        }
        WkPromptConfig wkPromptConfigB = WkPromptConfig.b(jSONObject);
        if (wkPromptConfigB != null) {
            this.n = wkPromptConfigB;
        }
        boolean zA = x96.a(jSONObject);
        if (!z) {
            k(jSONObject);
            rp3.f().a(str, jSONObject);
            rp3.f().c(jSONObject);
        }
        return (logConfigD == null && greetConfigD == null && globalConfigH == null && lbsUploadConfigB == null && wifiConfigB == null && mucConfigB == null && hbConfigE == null && kn0VarE == null && urlWhiteConfigC == null && !zA && !zIsContainDyConfig && groupCateConfigB == null) ? false : true;
    }

    public void l(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = xp3.c("wifi_social_new_config").edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
