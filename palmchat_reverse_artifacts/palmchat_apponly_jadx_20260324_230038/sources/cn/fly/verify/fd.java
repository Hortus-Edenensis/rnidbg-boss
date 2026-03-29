package cn.fly.verify;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.fly.verify.fq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fd {
    public static int a(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1001", str)) {
            return -1;
        }
        return applicationInfo.uid;
    }

    public static String b(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1004", str)) {
            return null;
        }
        return applicationInfo.name;
    }

    public static int c(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1005", str)) {
            return -1;
        }
        return applicationInfo.labelRes;
    }

    public static long d(Object obj, String str) {
        if (a("2005", str)) {
            return ((Long) fy.a(obj, bq.a("016]fgejekgi'j3fj7fRgi>jehh=flejegQg"), 0L)).longValue();
        }
        return 0L;
    }

    public static long e(Object obj, String str) {
        if (a("2006", str)) {
            return ((Long) fy.a(obj, bq.a("014he+gi,j7fh%kPedDejgZflejeg'g"), 0L)).longValue();
        }
        return 0L;
    }

    public static int f(Object obj, String str) {
        if (a("2007", str)) {
            return ((Integer) fy.a(obj, bq.a("011?ee^gFekgiejfeGfYhlfeed2g"), 0)).intValue();
        }
        return 0;
    }

    public static long g(Object obj, String str) {
        if (a("2101", str)) {
            return ((Long) fy.a(obj, bq.a("018LffHgjLgdfe1fNffhkYgOekgiejfe7f4hlfeed-g"), 0L, new Object[0])).longValue();
        }
        return 0L;
    }

    public static ApplicationInfo a(Object obj, String str) {
        if (a("2001", str)) {
            return (ApplicationInfo) fy.a(obj, bq.a("015ekkh)ej@dej^ejfe2f<fj7fMfgfe"), (Object) null);
        }
        return null;
    }

    public static Signature[] b(Object obj, String str) {
        if (a("2002", str)) {
            return (Signature[]) fy.a(obj, bq.a("010Igiejff5fejNehek2g$gi"), (Object) null);
        }
        return null;
    }

    public static String c(Object obj, String str) {
        return a("2004", str) ? (String) fy.a(obj, bq.a("011$ee'g5ekgiejfe4f<fiLe[eg,g"), "1.0") : "1.0";
    }

    public static CharSequence d(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1006", str)) {
            return null;
        }
        return applicationInfo.nonLocalizedLabel;
    }

    public static boolean e(ApplicationInfo applicationInfo, String str) {
        return applicationInfo != null && a("1007", str) && applicationInfo.enabled;
    }

    public static String f(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1008", str)) {
            return null;
        }
        return applicationInfo.processName;
    }

    public static CharSequence g(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1101", str)) {
            return null;
        }
        return applicationInfo.loadLabel(ax.g().getPackageManager());
    }

    public static boolean a(String str, String str2) {
        String str3 = (String) by.a(com.kuaishou.weapon.p0.t.p, (Object) null);
        if (str3 == null) {
            return true;
        }
        String[] strArrSplit = str3.split(com.huawei.openalliance.ad.constant.x.aQ);
        if (TextUtils.equals(str2, fq.d.c())) {
            if (strArrSplit.length > 1) {
                return !strArrSplit[1].contains(str);
            }
            return true;
        }
        if (strArrSplit.length > 0) {
            return !strArrSplit[0].contains(str);
        }
        return true;
    }
}
