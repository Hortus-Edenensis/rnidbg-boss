package com.opos.cmn.g.a;

import android.content.Context;
import com.zm.fda.oaid.Z200O.ZZ2O0.OO22Z;
import defpackage.vw6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8016a = false;
    private static volatile com.opos.cmn.g.a.a b;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends com.opos.cmn.g.a.a {
        private b() {
        }

        @Override // com.opos.cmn.g.a.a
        public String a(Context context) {
            return vw6.e(context);
        }

        @Override // com.opos.cmn.g.a.a
        public String b(Context context) {
            return vw6.f(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean c(Context context) {
            return vw6.d(context);
        }

        @Override // com.opos.cmn.g.a.a
        public void d(Context context) {
            vw6.c(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean a() {
            return vw6.b();
        }
    }

    private static synchronized com.opos.cmn.g.a.a a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public static String b(Context context) {
        Exception e;
        String strB;
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            e(context);
            strB = a().a() ? a().b(context) : "";
        } catch (Exception e2) {
            e = e2;
            strB = "";
        }
        try {
            com.opos.cmn.an.f.a.a(OO22Z.f16715a, "getDUID costTime=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result=" + strB);
        } catch (Exception e3) {
            e = e3;
            com.opos.cmn.an.f.a.c(OO22Z.f16715a, "", e);
        }
        return strB;
    }

    public static boolean c(Context context) {
        boolean zA;
        try {
            e(context);
            zA = a().a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(OO22Z.f16715a, "", e);
            zA = false;
        }
        com.opos.cmn.an.f.a.a(OO22Z.f16715a, "isSupportedOpenId " + zA);
        return zA;
    }

    public static boolean d(Context context) {
        boolean zC;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            e(context);
            zC = a().c(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(OO22Z.f16715a, "", e);
            zC = false;
        }
        com.opos.cmn.an.f.a.a(OO22Z.f16715a, "getOUIDStatus costTime=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result=" + zC);
        return zC;
    }

    private static void e(Context context) {
        if (f8016a) {
            return;
        }
        a().d(context);
        f8016a = true;
    }

    public static String a(Context context) {
        Exception e;
        String strA;
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            e(context);
            strA = a().a() ? a().a(context) : "";
        } catch (Exception e2) {
            e = e2;
            strA = "";
        }
        try {
            com.opos.cmn.an.f.a.a(OO22Z.f16715a, "getOUID costTime=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result=" + strA);
        } catch (Exception e3) {
            e = e3;
            com.opos.cmn.an.f.a.c(OO22Z.f16715a, "", e);
        }
        return strA;
    }
}
