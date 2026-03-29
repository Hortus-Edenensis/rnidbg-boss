package com.opos.cmn.an.c;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7736a;
    public static final String b;
    public static final String c;
    public static final String d;
    private static String e;
    private static String f;
    private static final String g;
    private static final String h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("ro.build.version.");
        String str = com.opos.cmn.an.b.a.c;
        sb.append(str);
        sb.append("rom");
        g = sb.toString();
        h = "persist.sys." + str + ".region";
        f7736a = com.opos.cmn.an.b.b.a("Z2V0Q29sb3JPU1ZFUlNJT04=");
        b = com.opos.cmn.an.b.b.a("Y29tLmNvbG9yLm9zLkNvbG9yQnVpbGQ=");
        c = com.opos.cmn.an.b.b.a("Z2V0Q29sb3JPU1Zlck5hbWU=");
        d = com.opos.cmn.an.b.b.a("Z2V0Q29sb3JPU1ZlckNvZGU=");
    }

    public static String a() {
        if (e == null) {
            try {
                e = SystemProperties.get("ro.build.display.id");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSPropertyTool", "getOSVerName", e2);
            }
        }
        String str = e;
        return str != null ? str : "";
    }

    public static String b() {
        if (f == null) {
            if (Build.VERSION.SDK_INT > 29) {
                try {
                    f = SystemProperties.get("ro.build.version.oplusrom");
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(f)) {
                try {
                    f = SystemProperties.get(g);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("OSPropertyTool", c, e2);
                }
            }
        }
        String str = f;
        return str != null ? str : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c() {
        Throwable th;
        int iIntValue;
        Object objInvoke;
        try {
            if (Build.VERSION.SDK_INT > 29) {
                try {
                    objInvoke = Class.forName("com.oplus.os.OplusBuild").getMethod("getOplusOSVERSION", new Class[0]).invoke(null, new Object[0]);
                } catch (Throwable unused) {
                }
                iIntValue = objInvoke instanceof Integer ? ((Integer) objInvoke).intValue() : 0;
                if (iIntValue > 0) {
                    return iIntValue;
                }
                try {
                    Object objInvoke2 = Class.forName(b).getMethod(f7736a, new Class[0]).invoke(null, new Object[0]);
                    return objInvoke2 instanceof Integer ? ((Integer) objInvoke2).intValue() : iIntValue;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            iIntValue = 0;
        }
        com.opos.cmn.an.f.a.c("OSPropertyTool", d, th);
        return iIntValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d() {
        String str;
        if (Build.VERSION.SDK_INT > 29) {
            str = c() >= 22 ? SystemProperties.get("persist.sys.oplus.region", "cn") : "";
        }
        if (TextUtils.isEmpty(str)) {
            try {
                String strD = c.d();
                str = SystemProperties.get((com.opos.cmn.an.d.b.a(strD) || !strD.trim().equalsIgnoreCase(com.opos.cmn.an.b.a.f7732a)) ? h : "persist.sys.oem.region", "cn");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSPropertyTool", "getRegion", e2);
            }
        }
        return str != null ? str : "";
    }
}
