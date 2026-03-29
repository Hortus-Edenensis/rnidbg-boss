package com.vivo.push;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class z implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y f11315a = new y();
    private y b = new y();
    private com.vivo.push.c.a c;
    private volatile String d;
    private com.vivo.push.restructure.b.a e;

    public z(com.vivo.push.c.a aVar, com.vivo.push.restructure.b.a aVar2) {
        this.c = aVar;
        this.e = aVar2;
    }

    private void d(String str) {
        this.d = str;
        this.e.c(this.d);
    }

    @Override // com.vivo.push.k
    public final String b() throws Throwable {
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            strD = this.e.f();
            t.c(new aa(this, strD));
        }
        this.d = strD;
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(strD)));
        return strD;
    }

    @Override // com.vivo.push.k
    public final void c(String str) {
        d(str);
    }

    private int c() throws Throwable {
        if (!this.c.d()) {
            return 8013;
        }
        if (this.b.a()) {
            com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
            return 1002;
        }
        int i = 1;
        try {
            String strA = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(strA)));
            String strA2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), strA);
            com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(strA2)));
            if (!TextUtils.isEmpty(strA2)) {
                i = 1 ^ (Boolean.parseBoolean(g.f11232a.a(strA2).b()) ? 1 : 0);
            }
        } catch (Exception e) {
            com.vivo.push.util.t.a("SubscribeImpl", "isAppSubscribe", e);
        }
        com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i)));
        return i;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.c.c() || iPushActionListener == null) {
            m.a().b(iPushActionListener, str, str2);
        } else {
            iPushActionListener.onStateChanged(8012);
        }
    }

    private String d() throws Throwable {
        String strB = "";
        if (!this.c.d()) {
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
            return "";
        }
        if (this.f11315a.a()) {
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
            return "";
        }
        try {
            String strA = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(strA)));
            String strA2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), strA);
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(strA2)));
            if (!TextUtils.isEmpty(strA2)) {
                strB = g.f11232a.a(strA2).b();
            }
        } catch (Exception e) {
            com.vivo.push.util.t.a("SubscribeImpl", "getRegidByCoreSdk", e);
        }
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(strB)));
        return strB;
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    @Override // com.vivo.push.k
    public final void a(String str, String str2, String str3) {
        d(str);
        this.e.a(str2);
        this.e.b(str3);
    }

    @Override // com.vivo.push.k
    public final void a(String str) {
        d(str);
        this.e.d();
        this.e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String str) {
        d(str);
        m.a().e();
        this.e.h();
        this.e.d();
        this.e.b();
    }
}
