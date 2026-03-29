package com.zm.fda.oaid.Z200O;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {
    public static com.zm.fda.oaid.ZZ00Z a(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (com.zm.fda.oaid.Z2500.Z0225.e()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "honor device");
            return new com.zm.fda.oaid.Z200O.O2O5Z.ZZ00Z(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.g()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "huawei device");
            return new com.zm.fda.oaid.Z200O.O20O5.ZZ00Z(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.n()) {
            ZZ0O5 zz0o5 = new ZZ0O5(applicationContext);
            return zz0o5.isSupport() ? zz0o5 : new Z0O00(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.p()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "vivo device");
            return new ZZ050(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.q()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "xiaomi device");
            return new com.zm.fda.oaid.Z200O.ZZ2O0.ZZ00Z(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.i()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "meiZu device");
            return new Z200O(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.o()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "samsung device");
            return new O52OZ(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.h()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "lenovo device");
            return new Z0225(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.l()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "nubia device");
            return new Z2500(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.a()) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "360 device");
            return new com.zm.fda.oaid.Z200O.Z22Z5.OO22Z(applicationContext);
        }
        if (com.zm.fda.oaid.Z2500.Z0225.a(applicationContext)) {
            com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "coolpad device");
            return new OO22Z(applicationContext);
        }
        com.zm.fda.oaid.Z2500.Z25O0.a(com.zm.fda.oaid.Z2500.ZZ00Z.f16721a, "other device");
        return new OOZ20(applicationContext);
    }
}
