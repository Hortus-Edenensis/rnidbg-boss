package defpackage;

import com.igexin.push.core.b;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.GlobalConfig;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.Vo.GroupCateConfig;
import com.zenmen.palmchat.Vo.MomentsConfig;
import com.zenmen.palmchat.Vo.MucConfig;
import com.zenmen.palmchat.Vo.UrlWhiteConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class rl0 {
    public static rl0 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yl0 f20501a;

    public rl0() {
        this.f20501a = null;
        String strP = AccountUtils.p(AppContext.getContext());
        if (am0.b()) {
            this.f20501a = new ms2();
        } else {
            this.f20501a = new bq();
        }
        l(strP);
    }

    public static rl0 h() {
        if (b == null) {
            synchronized (rl0.class) {
                if (b == null) {
                    b = new rl0();
                }
            }
        }
        return b;
    }

    public void a(String str) {
        l(str);
    }

    public yl0 b() {
        return this.f20501a;
    }

    public kn0 c() {
        return b().c();
    }

    public DynamicConfig d() {
        return b().f();
    }

    public GlobalConfig e() {
        return b().a();
    }

    public GreetConfig f() {
        return b().g();
    }

    public GroupCateConfig g() {
        return b().b();
    }

    public MomentsConfig i() {
        return MomentsConfig.c();
    }

    public MucConfig j() {
        return b().h();
    }

    public UrlWhiteConfig k() {
        return b().d();
    }

    public final void l(String str) {
        this.f20501a.init(str);
    }

    public void m(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateConfigs=");
        sb.append(jSONObject == null ? b.m : jSONObject.toString());
        LogUtil.i("ConfigHelper", sb.toString());
        this.f20501a.e(str, jSONObject);
    }
}
