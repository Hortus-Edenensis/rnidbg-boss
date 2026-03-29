package com.zm.fda.oaid.Z200O.O2O5Z;

import android.content.Context;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O2O5Z.ZZ00Z;
import com.zm.fda.oaid.Z25O0;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z extends com.zm.fda.oaid.ZZ00Z {
    public static final String e = "FDA_OAID_Honor";
    public Class<?> b;
    public Class<?> c;
    public Object d;

    public ZZ00Z(Context context) {
        this.f16722a = context;
        try {
            this.b = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmhpaG9ub3IuYWRzLmlkZW50aWZpZXIuQWR2ZXJ0aXNpbmdJZENsaWVudA=="));
            this.c = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmhpaG9ub3IuYWRzLmlkZW50aWZpZXIuQWR2ZXJ0aXNpbmdJZENsaWVudCRJbmZv"));
            this.d = this.b.newInstance();
        } catch (Exception unused) {
            Log.e(e, "not have AdvertisingIdClient");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Z25O0 z25o0, String str) {
        if (!com.zm.fda.oaid.ZZ00Z.a(str)) {
            super.a(new Z25O0() { // from class: lq6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str2) {
                    ZZ00Z.b(z25o0, str2);
                }
            });
            return;
        }
        if (z25o0 != null) {
            com.zm.fda.oaid.Z2500.Z25O0.a(e, "get oaid from inner api:" + str);
            z25o0.a(str);
        }
    }

    public static /* synthetic */ void b(Z25O0 z25o0, String str) {
        if (z25o0 != null) {
            z25o0.a(str);
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final Z25O0 z25o0) {
        d(new Z25O0() { // from class: fq6
            @Override // com.zm.fda.oaid.Z25O0
            public final void a(String str) {
                this.f17582a.a(z25o0, str);
            }
        });
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        if (this.f16722a != null && this.b != null && this.d != null && this.c != null) {
            try {
                return a();
            } catch (Throwable th) {
                Log.e(e, "api not support err", th);
            }
        }
        return false;
    }

    private void d(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (!isSupport()) {
            com.zm.fda.oaid.Z2500.Z25O0.b(e, "未集成honor sdk，将从honor Settings.Global获取oaid");
            OO22Z.a(this.f16722a, z25o0);
        } else {
            try {
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: oq6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19814a.e(z25o0);
                    }
                });
            } catch (Throwable unused) {
                z25o0.a("");
                Log.e(e, "oaid thread is err");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Z25O0 z25o0) {
        String str;
        Throwable th;
        if (z25o0 == null) {
            return;
        }
        try {
            str = (String) this.c.getDeclaredField(com.zm.fda.oaid.Z2500.OO22Z.a("aWQ=")).get(this.b.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0QWR2ZXJ0aXNpbmdJZEluZm8="), Context.class).invoke(this.d, this.f16722a));
        } catch (Throwable th2) {
            str = "";
            th = th2;
        }
        try {
            com.zm.fda.oaid.Z2500.Z25O0.a(e, "getOAIDBySelf oaid获取成功:" + str);
        } catch (Throwable th3) {
            th = th3;
            com.zm.fda.oaid.Z2500.Z25O0.b(e, "getOAIDBySelf oaid获取失败" + th.getMessage());
        }
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            OO22Z.a(this.f16722a, z25o0);
        }
    }

    private boolean a() {
        Class<?> cls = this.b;
        if (cls == null && this.d == null) {
            com.zm.fda.oaid.Z2500.Z25O0.b(e, "advertisingIdClass is null, 未集成荣耀sdk");
            return false;
        }
        try {
            return ((Boolean) cls.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("aXNBZHZlcnRpc2luZ0lkQXZhaWxhYmxl"), Context.class).invoke(this.d, this.f16722a)).booleanValue();
        } catch (Throwable th) {
            com.zm.fda.oaid.Z2500.Z25O0.b(e, "honor isAdvertisingIdAvailable err" + th.getMessage());
            return false;
        }
    }
}
