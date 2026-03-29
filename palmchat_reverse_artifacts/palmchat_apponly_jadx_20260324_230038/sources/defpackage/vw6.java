package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import defpackage.d37;
import defpackage.e37;
import defpackage.me7;
import defpackage.tz6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class vw6 {
    public static Context a(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static boolean b() {
        return p87.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context) {
        String str;
        boolean z;
        String str2;
        tz6 tz6Var;
        String str3;
        PackageInfo packageInfo;
        Context contextA = a(context);
        p87.d = contextA;
        lx6.d(contextA);
        d37 d37Var = d37.b.f16969a;
        d37Var.h = p87.d;
        be7.a("2008");
        boolean z2 = false;
        try {
            packageInfo = d37Var.h.getPackageManager().getPackageInfo("com.oplus.stdid", 8);
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str = "1078";
            be7.b(str, e);
        } catch (Exception e2) {
            e = e2;
            str = "1079";
            be7.b(str, e);
        }
        if (packageInfo == null || packageInfo.versionCode < 1) {
            z = false;
        } else if (lx6.i(d37Var.h, "com.oplus.stdid")) {
            z = true;
        }
        p87.b = z;
        if (z) {
            p87.c = true;
        } else {
            p87.c = false;
            v87.d = p87.d;
            boolean zJ = e37.b.f17209a.j(v87.d);
            v87.b = zJ;
            if (zJ) {
                tz6Var = tz6.b.f21101a;
                str3 = "OP_APP";
            } else {
                me7 me7Var = me7.b.f19204a;
                me7Var.h = v87.d;
                String strC = lx6.c("Y29tLmNvbG9yb3MubWNz");
                be7.a("2008:" + strC);
                try {
                    PackageInfo packageInfo2 = me7Var.h.getPackageManager().getPackageInfo(strC, 0);
                    if (packageInfo2 != null) {
                        int i = Build.VERSION.SDK_INT;
                        if (i > 28) {
                            be7.a("2008: > P");
                        } else {
                            long longVersionCode = i == 28 ? packageInfo2.getLongVersionCode() : packageInfo2.versionCode;
                            be7.a("2008: " + longVersionCode);
                            if (longVersionCode >= 11200) {
                                if (longVersionCode >= 11609) {
                                    me7Var.j = true;
                                }
                                z2 = true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    str2 = "1072";
                    be7.b(str2, e);
                } catch (Exception e4) {
                    e = e4;
                    str2 = "1073";
                    be7.b(str2, e);
                }
                v87.c = z2;
                tz6Var = tz6.b.f21101a;
                str3 = "MCS_APP";
            }
            tz6Var.b = str3;
            v87.f21382a = true;
        }
        p87.f19962a = true;
    }

    @Deprecated
    public static boolean d(Context context) {
        be7.a("2002");
        if (!p87.f19962a) {
            Log.e("IDHelper", "1001");
            return false;
        }
        if (p87.c) {
            return false;
        }
        HashMap<String, String> mapA = v87.a(32);
        return "TRUE".equalsIgnoreCase(mapA.get("OUID_STATUS") == null ? "FALSE" : mapA.get("OUID_STATUS"));
    }

    @Deprecated
    public static String e(Context context) {
        be7.a("2003");
        return p87.a(8, "OUID");
    }

    @Deprecated
    public static String f(Context context) {
        be7.a("2004");
        return p87.a(4, "DUID");
    }
}
