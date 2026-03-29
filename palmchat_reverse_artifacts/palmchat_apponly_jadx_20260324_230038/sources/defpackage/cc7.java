package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1951a = "";
    public static String b = null;
    public static int c = -1;

    public static String a() {
        return (d() || f()) ? g() : e() ? j87.c() : GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String strH;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String str = Build.BRAND;
        if (hd7.b.equalsIgnoreCase(str)) {
            strH = h();
            if (!hd7.e.equalsIgnoreCase(strH)) {
                strH = str;
            }
        } else if (!hd7.e.equalsIgnoreCase(str)) {
            strH = hd7.g;
            if (!strH.equalsIgnoreCase(str)) {
                try {
                } catch (Throwable th) {
                    if (k17.k()) {
                        th.printStackTrace();
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    if (!o17.a().getPackageManager().hasSystemFeature("com." + hd7.h + ".mobilephone")) {
                        strH = null;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(strH)) {
            str = strH;
        }
        b = str;
        return str;
    }

    public static String c() {
        return String.valueOf((d() || f()) ? i() : e() ? j87.a() : -1);
    }

    public static boolean d() {
        return hd7.b.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    public static boolean e() {
        return hd7.g.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    public static boolean f() {
        return hd7.e.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    public static String g() {
        if (TextUtils.isEmpty(f1951a)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f1951a = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.version." + hd7.c + "rom", "0");
            } catch (Exception e) {
                if (k17.k()) {
                    e.printStackTrace();
                }
            }
        }
        return f1951a;
    }

    public static String h() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.brand.sub", "");
        } catch (Exception e) {
            if (!k17.k()) {
                return "";
            }
            e.printStackTrace();
            return "";
        }
    }

    public static int i() {
        int iIntValue;
        String str;
        StringBuilder sb;
        int i = c;
        if (i >= 0) {
            return i;
        }
        try {
            if (Build.VERSION.SDK_INT > 29) {
                str = "com.oplus.os.OplusBuild";
                sb = new StringBuilder("get");
                sb.append(hd7.o);
                sb.append("VERSION");
            } else {
                str = "com." + hd7.m + ".os." + hd7.n;
                sb = new StringBuilder("get");
                sb.append(hd7.i);
                sb.append("VERSION");
            }
            iIntValue = ((Integer) kf7.b(kf7.a(str), sb.toString(), null, null)).intValue();
        } catch (Exception e) {
            if (k17.k()) {
                e.printStackTrace();
            }
            iIntValue = 0;
        }
        if (iIntValue == 0) {
            try {
                String strA = a();
                if (strA.startsWith("V1.4")) {
                    return 3;
                }
                if (strA.startsWith("V2.0")) {
                    return 4;
                }
                if (strA.startsWith("V2.1")) {
                    return 5;
                }
            } catch (Exception e2) {
                if (k17.k()) {
                    e2.printStackTrace();
                }
            }
        }
        c = iIntValue;
        return iIntValue;
    }
}
