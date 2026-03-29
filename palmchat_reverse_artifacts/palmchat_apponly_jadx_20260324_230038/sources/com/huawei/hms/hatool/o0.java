package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import defpackage.l8;
import defpackage.pm1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class o0 {
    private static o0 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6781a;
    private String b;

    private String b(String str) {
        return f() ? l8.g("analytics_keystore", str) : n.b(str, e());
    }

    private String c() {
        String strA = d.a(q0.i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(strA)) {
            return a(strA);
        }
        String strD = pm1.d(16);
        c(b(strD));
        return strD;
    }

    public static o0 d() {
        if (c == null) {
            g();
        }
        return c;
    }

    private String e() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = new x().a();
        }
        return this.b;
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static synchronized void g() {
        if (c == null) {
            c = new o0();
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f6781a)) {
            this.f6781a = c();
        }
        return this.f6781a;
    }

    private String a(String str) {
        String strD = f() ? l8.d("analytics_keystore", str) : "";
        if (TextUtils.isEmpty(strD)) {
            v.c("hmsSdk", "deCrypt work key first");
            strD = n.a(str, e());
            if (TextUtils.isEmpty(strD)) {
                strD = pm1.d(16);
                c(b(strD));
                if (f()) {
                    x.c();
                }
            } else if (f()) {
                c(b(strD));
                x.c();
            }
        }
        return strD;
    }

    private boolean c(String str) {
        v.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        d.b(q0.i(), "Privacy_MY", "PrivacyData", str);
        d.b(q0.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public void b() {
        String strD = pm1.d(16);
        if (c(b(strD))) {
            this.f6781a = strD;
        }
    }
}
