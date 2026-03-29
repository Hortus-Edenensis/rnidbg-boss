package com.zm.fda.oaid.Z200O.ZZ2O0;

import android.content.Context;
import android.util.Log;
import com.zm.fda.oaid.Z200O.ZZ2O0.ZZ00Z;
import com.zm.fda.oaid.Z25O0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z extends com.zm.fda.oaid.ZZ00Z {
    public static final String d = "FDA_OAID_Xiaomi";
    public Class<?> b;
    public Object c;

    public ZZ00Z(Context context) {
        this.f16722a = context;
        try {
            Class<?> cls = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLm1pdWkuZGV2aWNlaWQuSWRlbnRpZmllck1hbmFnZXI="));
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Throwable unused) {
            Log.e(d, "init IdentifierManager err");
        }
    }

    public static /* synthetic */ void a(Z25O0 z25o0, String str) {
        if (z25o0 != null) {
            z25o0.a(str);
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        String strA = a();
        if (!com.zm.fda.oaid.ZZ00Z.a(strA)) {
            super.a(new Z25O0() { // from class: gq6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    ZZ00Z.a(z25o0, str);
                }
            });
            return;
        }
        com.zm.fda.oaid.Z2500.Z25O0.a(d, "getOAID :" + strA);
        z25o0.a(strA);
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        return (this.b == null || this.c == null) ? false : true;
    }

    private String a() {
        if (!isSupport()) {
            return OO22Z.a() ? OO22Z.b(this.f16722a) : "";
        }
        try {
            return (String) this.b.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0T0FJRA=="), Context.class).invoke(this.c, this.f16722a);
        } catch (Throwable unused) {
            return "";
        }
    }
}
