package com.opos.mobad.splash;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.mobad.ad.g.e f9268a;
        public final AdHelper.AdHelperData b;
        public boolean c;
        private final com.opos.mobad.ad.g.d d;

        private a(com.opos.mobad.ad.g.d dVar, com.opos.mobad.ad.g.e eVar, AdHelper.AdHelperData adHelperData) {
            this.c = false;
            this.d = dVar;
            this.f9268a = eVar;
            this.b = adHelperData;
        }

        public long a() {
            AdHelper.AdHelperData adHelperData = this.b;
            if (adHelperData == null) {
                return 0L;
            }
            return adHelperData.c.q();
        }

        public com.opos.mobad.ad.g.d b() {
            if (!c() || d()) {
                return null;
            }
            return this.d;
        }

        public boolean c() {
            AdHelper.AdHelperData adHelperData = this.b;
            if (adHelperData == null) {
                return true;
            }
            return adHelperData.d.a();
        }

        public boolean d() {
            AdHelper.AdHelperData adHelperData = this.b;
            if (adHelperData == null) {
                return false;
            }
            int iZ = adHelperData.d.Z();
            return iZ == 61 || iZ == 51;
        }

        public String toString() {
            return "SplashVo{bottomArea=" + this.d + ", customSkipView=" + this.f9268a + ", adHelperData=" + this.b + '}';
        }
    }

    public static a a(com.opos.mobad.ad.g.f fVar, AdHelper.AdHelperData adHelperData) {
        if (fVar == null || adHelperData == null) {
            return null;
        }
        return new a(fVar.e, fVar.g, adHelperData);
    }

    public static MaterialFileData b(a aVar) {
        if (c(aVar)) {
            return aVar.b.e;
        }
        return null;
    }

    public static boolean c(a aVar) {
        return (aVar == null || aVar.b == null) ? false : true;
    }

    private static String d(a aVar) {
        return !TextUtils.isEmpty(aVar.b.d.V()) ? aVar.b.d.V() : "点击跳转详情页或第三方应用";
    }

    private static int e(a aVar) {
        int iK = aVar.b.c.K();
        if (!aVar.c() || aVar.d()) {
            iK = 0;
        }
        int i = 1;
        if (iK != 1) {
            i = 2;
            if (iK != 2) {
                return 0;
            }
        }
        return i;
    }

    public static com.opos.mobad.template.d.f a(com.opos.mobad.b bVar, a aVar, com.opos.mobad.template.e eVar, com.opos.mobad.template.d dVar, int i) {
        if (aVar == null) {
            return null;
        }
        MaterialFileData materialFileDataB = b(aVar);
        String strA = materialFileDataB != null ? com.opos.cmn.d.d.a(bVar.b(), materialFileDataB.a()) : "";
        Context contextB = bVar.b();
        AdHelper.AdHelperData adHelperData = aVar.b;
        com.opos.mobad.template.d.f fVarA = com.opos.mobad.model.a.a(contextB, bVar, adHelperData.c, adHelperData.d, false, false, i);
        fVarA.a(aVar.a(), aVar.a()).g(strA, materialFileDataB != null ? materialFileDataB.b() : "").a(eVar).a(dVar).d(d(aVar)).f(e(aVar));
        return fVarA;
    }

    public static boolean a(a aVar) {
        AdData adData;
        com.opos.mobad.ad.g.e eVar;
        return (!c(aVar) || (adData = aVar.b.f9107a) == null || !adData.b() || (eVar = aVar.f9268a) == null || eVar.getSplashSkipView() == null) ? false : true;
    }
}
