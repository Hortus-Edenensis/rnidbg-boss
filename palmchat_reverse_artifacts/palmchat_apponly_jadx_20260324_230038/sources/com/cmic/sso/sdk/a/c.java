package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.a.b;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.e.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static c f5474a;
    private a b;
    private a c;
    private b d;
    private Context e;

    private c(Context context) {
        this.e = context;
        b();
    }

    public static c a(Context context) {
        if (f5474a == null) {
            synchronized (c.class) {
                if (f5474a == null) {
                    f5474a = new c(context);
                }
            }
        }
        return f5474a;
    }

    private void b() {
        String strB = k.b("sdk_config_version", "");
        if (TextUtils.isEmpty(strB) || !AuthnHelper.SDK_VERSION.equals(strB)) {
            b bVarA = b.a(true);
            this.d = bVarA;
            this.b = bVarA.a();
            if (!TextUtils.isEmpty(strB)) {
                c();
            }
        } else {
            b bVarA2 = b.a(false);
            this.d = bVarA2;
            this.b = bVarA2.b();
        }
        this.d.a(this);
        this.c = this.d.a();
    }

    private void c() {
        com.cmic.sso.sdk.e.c.b("UmcConfigManager", "delete localConfig");
        this.d.c();
    }

    public a a() {
        try {
            return this.b.clone();
        } catch (CloneNotSupportedException unused) {
            return this.c;
        }
    }

    @Override // com.cmic.sso.sdk.a.b.a
    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        this.d.a(aVar);
    }
}
