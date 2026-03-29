package com.zm.fda.oaid.Z200O.O20O5;

import android.content.Context;
import android.util.Log;
import com.zm.fda.oaid.Z25O0;
import defpackage.nq6;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z extends com.zm.fda.oaid.ZZ00Z {
    public static final String e = "FDA_OAID_HW";
    public Class<?> b;
    public Class<?> c;
    public Object d;

    public ZZ00Z(Context context) {
        this.f16722a = context;
        try {
            this.b = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmh1YXdlaS5obXMuYWRzLmlkZW50aWZpZXIuQWR2ZXJ0aXNpbmdJZENsaWVudA=="));
            this.c = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmh1YXdlaS5obXMuYWRzLmlkZW50aWZpZXIuQWR2ZXJ0aXNpbmdJZENsaWVudCRJbmZv"));
            this.d = this.b.newInstance();
        } catch (Throwable unused) {
            Log.e(e, "not have AdvertisingIdClient");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Z25O0 z25o0) {
        String str;
        try {
            str = (String) this.c.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0SWQ="), new Class[0]).invoke(this.b.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0QWR2ZXJ0aXNpbmdJZEluZm8="), Context.class).invoke(this.d, this.f16722a), new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "HW msg:" + th.getMessage());
            str = "";
        }
        Log.e(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "HW oaid:" + str);
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            e(z25o0);
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        d(new Z25O0() { // from class: kq6
            @Override // com.zm.fda.oaid.Z25O0
            public final void a(String str) {
                this.f18811a.a(z25o0, str);
            }
        });
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        if (this.f16722a == null) {
            return false;
        }
        try {
            return a();
        } catch (Throwable th) {
            Log.e(e, "not support api or not have huawei-hms", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Z25O0 z25o0, String str) {
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            z25o0.getClass();
            super.a(new nq6(z25o0));
        }
    }

    private void d(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (isSupport()) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: eq6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17341a.f(z25o0);
                }
            });
        } else {
            e(z25o0);
        }
    }

    private void e(Z25O0 z25o0) {
        com.zm.fda.oaid.Z2500.Z25O0.b(e, "未集成hms,走内部获取流程");
        if (OO22Z.a(this.f16722a)) {
            OO22Z.a(this.f16722a, z25o0);
        } else {
            com.zm.fda.oaid.Z2500.Z25O0.b(e, "huawei内部获取失败，系统获取oaid返回空");
            z25o0.a("");
        }
    }

    private boolean a() {
        Class<?> cls = this.b;
        if (cls != null) {
            return ((Boolean) cls.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("aXNBZHZlcnRpc2luZ0lkQXZhaWxhYmxl"), Context.class).invoke(this.d, this.f16722a)).booleanValue();
        }
        com.zm.fda.oaid.Z2500.Z25O0.b(e, "isSupportWithApi: advertisingIdClass is none,未集成hms套件");
        return false;
    }
}
