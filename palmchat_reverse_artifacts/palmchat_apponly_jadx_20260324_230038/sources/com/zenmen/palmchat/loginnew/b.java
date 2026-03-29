package com.zenmen.palmchat.loginnew;

import android.app.Activity;
import android.text.TextUtils;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.openapi.OAuthApi;
import com.lantern.auth.openapi.WkOAuthConst;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.ch;
import defpackage.cl6;
import defpackage.e73;
import defpackage.hx3;
import defpackage.q05;
import defpackage.x63;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final String l = "b";
    public static volatile b m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14483a;
    public int b;
    public int c;
    public PreLoginResult d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BLCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14484a;

        public a(int i) {
            this.f14484a = i;
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            int i2 = 0;
            b.this.f = false;
            LogUtil.d(b.l, "mobile preLogin result : " + i);
            PreLoginResult preLoginResult = obj != null ? (PreLoginResult) obj : null;
            int i3 = preLoginResult == null ? this.f14484a : preLoginResult.mLoginType;
            int iD = b.this.D(i3, false);
            b05.d("取号返回的type=" + iD);
            HashMap<String, Object> mapD = x63.d();
            mapD.put("duration", Long.valueOf(b.this.j != 0 ? System.currentTimeMillis() - b.this.j : 0L));
            if (i == 1 && obj != null) {
                i2 = 1;
            }
            mapD.put("result", Integer.valueOf(i2));
            mapD.put("type", Integer.valueOf(iD));
            LogUtil.uploadInfoImmediate("lx_client_login_mobile_return", mapD);
            zn6.j("lx_client_login_mobile_return", null, mapD);
            if (b.this.f14483a <= 0 && i == 1 && obj != null) {
                b.this.d = (PreLoginResult) obj;
                LogUtil.d(b.l, "mobile preLogin mPreLoginResult : " + b.this.d.toString());
                b bVar = b.this;
                bVar.e = bVar.d.mMaskPhone;
                if (TextUtils.isEmpty(b.this.e)) {
                    return;
                }
                b.this.f14483a = iD;
                b bVar2 = b.this;
                bVar2.c = bVar2.D(i3, true);
                b.this.B();
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.loginnew.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1071b implements BLCallback {
        public C1071b() {
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            b.this.g = false;
            LogUtil.d(b.l, "wifi getSimpleProfile result : " + i);
            HashMap<String, Object> mapD = x63.d();
            mapD.put("duration", Long.valueOf(b.this.k != 0 ? System.currentTimeMillis() - b.this.k : 0L));
            mapD.put("result", Integer.valueOf(i == 1 ? 1 : 0));
            LogUtil.uploadInfoImmediate("lx_client_login_wifi_return", mapD);
            zn6.j("lx_client_login_wifi_return", null, mapD);
            if (b.this.f14483a <= 0 && i == 1) {
                try {
                    b.this.e = ((JSONObject) obj).optString("mobile");
                    b.this.f14483a = 4;
                    b.this.b = 4;
                    b.this.c = 4;
                    b.this.B();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements BLCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f14486a;

        public c(e eVar) {
            this.f14486a = eVar;
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            if (i != 1) {
                this.f14486a.a(0, b.this.f14483a, null);
            } else if (TextUtils.isEmpty(str)) {
                this.f14486a.a(0, b.this.f14483a, null);
            } else {
                this.f14486a.a(1, b.this.f14483a, str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements BLCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f14487a;

        public d(e eVar) {
            this.f14487a = eVar;
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            if (i == 1) {
                this.f14487a.a(1, b.this.f14483a, obj);
            } else {
                this.f14487a.a(0, b.this.f14483a, obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(int i, int i2, Object obj);
    }

    public static b u() {
        if (m == null) {
            synchronized (b.class) {
                if (m == null) {
                    m = new b();
                }
            }
        }
        return m;
    }

    public boolean A() {
        return this.f14483a == 0 && !(this.h && this.i);
    }

    public final void B() {
        ch.s().Y();
    }

    public void C() {
        q();
        r();
    }

    public int D(int i, boolean z) {
        if (i == 1) {
            if (!z) {
                return 1;
            }
            this.b = 1;
            return 1;
        }
        if (i == 4) {
            if (!z) {
                return 2;
            }
            this.b = 2;
            return 2;
        }
        if (i == 8) {
            if (!z) {
                return 3;
            }
            this.b = 3;
            return 3;
        }
        if ((i & 16) != 16) {
            return 0;
        }
        this.b = D(OAuthApi.getOperatorType(i), z);
        return 8;
    }

    public void o() {
        this.f14483a = 0;
        this.b = 0;
        this.c = 0;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.e = null;
        this.d = null;
        this.j = 0L;
        this.k = 0L;
    }

    public void p(Activity activity, e eVar) {
        PreLoginResult preLoginResult;
        int i = this.f14483a;
        if (i == 4) {
            cl6.g(new c(eVar));
        } else if (i == 0 || (preLoginResult = this.d) == null) {
            eVar.a(0, 0, null);
        } else {
            cl6.a(activity, preLoginResult, new d(eVar));
        }
    }

    public void q() {
        if (this.h || this.f || !hx3.m(AppContext.getContext()) || !cl6.h()) {
            return;
        }
        this.f = true;
        this.h = true;
        int loginTypeByFilter = WkSDKManager.getSdkConfig().getLoginTypeByFilter(WkOAuthConst.ENTRANCE_IMPLICIT, true);
        cl6.b(new a(loginTypeByFilter));
        HashMap<String, Object> mapD = x63.d();
        mapD.put("type", Integer.valueOf(D(loginTypeByFilter, false)));
        b05.d("开始取号的type=" + mapD.get("type"));
        LogUtil.uploadInfoImmediate("lx_client_login_mobile_start", mapD);
        zn6.j("lx_client_login_mobile_start", null, mapD);
        this.j = System.currentTimeMillis();
        LogUtil.d(l, "do mobile preLogin...");
    }

    public void r() {
        if (this.i || this.g || !e73.p() || !cl6.i()) {
            return;
        }
        this.g = true;
        this.i = true;
        cl6.d(new C1071b());
        HashMap<String, Object> mapD = x63.d();
        LogUtil.uploadInfoImmediate("lx_client_login_wifi_start", mapD);
        zn6.j("lx_client_login_wifi_start", null, mapD);
        this.k = System.currentTimeMillis();
        LogUtil.d(l, "do wifi getSimpleProfile ...");
    }

    public int s() {
        return this.f14483a;
    }

    public int t() {
        return this.b;
    }

    public int v() {
        return this.c;
    }

    public String w() {
        return this.e;
    }

    public boolean x() {
        return this.f || this.g;
    }

    public Boolean y() {
        boolean zOptBoolean = true;
        try {
            zOptBoolean = q05.f("verifylogin").optBoolean("quicklogin_error", true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Boolean.valueOf(zOptBoolean);
    }

    public Boolean z() {
        boolean zOptBoolean = true;
        try {
            zOptBoolean = q05.f("verifylogin").optBoolean("messagelogin", true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Boolean.valueOf(zOptBoolean);
    }
}
