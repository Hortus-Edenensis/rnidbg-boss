package com.opos.mobad.service.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.opos.cmn.f.c;
import com.opos.cmn.i.f;
import com.opos.mobad.ad.e;
import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.af;
import com.opos.mobad.b.a.am;
import com.opos.mobad.b.a.e;
import com.opos.mobad.b.a.h;
import com.opos.mobad.b.a.l;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.o;
import com.opos.mobad.b.a.p;
import com.opos.mobad.b.a.q;
import com.opos.mobad.b.a.x;
import com.opos.mobad.service.c.a;
import com.opos.mobad.service.d.d;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static af f9236a;
    private static o b;

    public static final h a(Context context, String str, String str2, String str3) {
        int i;
        int iValueOf;
        int iUnsafeCheckOp;
        HashMap map = new HashMap();
        if (Build.VERSION.SDK_INT <= 33) {
            iValueOf = 1;
        } else {
            int i2 = 0;
            try {
                iUnsafeCheckOp = ((AppOpsManager) context.getSystemService("appops")).unsafeCheckOp("android:direction_sensors", Process.myUid(), context.getPackageName());
                com.opos.cmn.an.f.a.b("ProtocolManager", "unsafeCheckOp:" + iUnsafeCheckOp);
                i = iUnsafeCheckOp == 3 ? 2 : iUnsafeCheckOp == 0 ? 1 : 0;
            } catch (Throwable th) {
                th = th;
            }
            try {
                com.opos.cmn.an.f.a.b("ProtocolManager", "getAppInfo() unsafeCheckOp:", Integer.valueOf(iUnsafeCheckOp));
            } catch (Throwable th2) {
                th = th2;
                i2 = i;
                com.opos.cmn.an.f.a.c("ProtocolManager", "getAppInfo", th);
                i = i2;
            }
            iValueOf = Integer.valueOf(i);
        }
        map.put("accelerationStatus", iValueOf);
        return new h.a().a(str).b(str2).c(str3).a(map).b();
    }

    public static final aa b(Context context) {
        d.b bVarK = d.a().k();
        return new aa.a().a(bVarK.b).a(Integer.valueOf(bVarK.f9228a)).b();
    }

    public static final e c() {
        d.b bVarL = d.a().l();
        if (bVarL == null) {
            return null;
        }
        return new e.a().a(bVarL.b).a(Integer.valueOf(bVarL.f9228a)).b();
    }

    public static final String d() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ProtocolManager", "getUserAgent() fail", e);
            return "";
        }
    }

    public static final af e() {
        if (f9236a == null) {
            f9236a = new af.a().a(Integer.valueOf(d.a().m())).a(d.a().n()).b(Integer.valueOf(d.a().o())).c(Integer.valueOf(c.a().a())).b();
        }
        return f9236a;
    }

    private static final o f() {
        if (b == null) {
            b = new o.a().a(d.a().h()).c(d.a().j()).b(d.a().i()).b();
        }
        return b;
    }

    public static final n a(Context context) {
        m.a aVarM = new m.a().b(com.opos.mobad.service.d.b.a().getAndroidId()).c("").g(com.opos.mobad.service.c.a.a().n()).h(com.opos.mobad.service.c.a.a().i()).i(com.opos.mobad.service.c.a.a().j()).j(com.opos.mobad.service.c.a.a().k()).k(com.opos.mobad.service.d.b.a().isCanUsePhoneState() ? f.a(context) : "").m(com.opos.mobad.service.c.a.a().b());
        a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
        if (c0768aM != null) {
            aVarM.a(c0768aM.f9210a).a((Integer) 1);
        } else {
            aVarM.a("");
        }
        m mVarB = aVarM.b();
        p pVarB = new p.a().a(Float.valueOf(com.opos.cmn.an.h.f.a.f(context))).a(Integer.valueOf(com.opos.cmn.an.h.f.a.c(context))).b(Integer.valueOf(com.opos.cmn.an.h.f.a.b(context))).b();
        double[] dArr = {0.0d, 0.0d};
        e.a location = com.opos.mobad.service.d.b.a().getLocation();
        if (location != null) {
            dArr[0] = location.getLatitude();
            dArr[1] = location.getLongitude();
        }
        return new n.a().a(mVarB).a(f()).a(pVarB).a(new q.a().a(new l.a().b(String.valueOf(dArr[0])).a(String.valueOf(dArr[1])).a(Long.valueOf(System.currentTimeMillis())).b()).a(c(context)).a(a(d.a().r())).a(Integer.valueOf(com.opos.cmn.an.h.f.a.i(context))).b()).a(com.opos.cmn.an.c.c.a()).b(d()).c(com.opos.cmn.an.c.a.a(context)).d(com.opos.mobad.service.c.a.a().d()).e(com.opos.mobad.service.c.a.a().e()).a(Boolean.valueOf(com.opos.cmn.an.f.a.b(context))).b();
    }

    public static final am b() {
        return new am.a().a(Boolean.valueOf(d.a().e())).a(d.a().f()).b(d.a().g()).b();
    }

    private static final q.b c(Context context) {
        q.b bVar;
        bVar = q.b.CONNECTION_UNKNOWN;
        String strH = com.opos.cmn.an.h.c.a.h(context);
        strH.hashCode();
        switch (strH) {
            case "2g":
                return q.b.CELL_2G;
            case "3g":
                return q.b.CELL_3G;
            case "4g":
                return q.b.CELL_4G;
            case "5g":
                return q.b.CELL_5G;
            case "wifi":
                return q.b.WIFI;
            default:
                return bVar;
        }
    }

    private static final q.c a(String str) {
        q.c cVar = q.c.UNKNOWN_OPERATOR;
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        str.hashCode();
        switch (str) {
            case "telecom":
                return q.c.CHINA_TELECOM;
            case "mobile":
                return q.c.CHINA_MOBILE;
            case "unicom":
                return q.c.CHINA_UNICOM;
            default:
                return cVar;
        }
    }

    public static final x a() {
        return new x.a().a(Boolean.valueOf(d.a().c())).a(d.a().d()).b(d.a().b()).a(Long.valueOf(d.a().q())).b();
    }
}
