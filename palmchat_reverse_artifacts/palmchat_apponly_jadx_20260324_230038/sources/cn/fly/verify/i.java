package cn.fly.verify;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2399a;
    private static String b;
    private static String c;
    private static String d;

    public static String a() {
        if (TextUtils.isEmpty(f2399a)) {
            f2399a = "api-auth.zztfly.com";
        }
        return f2399a;
    }

    public static String b() {
        if (TextUtils.isEmpty(b)) {
            b = "conf-auth.zztfly.com";
        }
        return b;
    }

    public static String c() {
        if (TextUtils.isEmpty(c)) {
            c = "cdn-api-auth.zztfly.com";
        }
        return c;
    }

    public static String d() {
        if (TextUtils.isEmpty(d)) {
            d = "log-auth.zztfly.com";
        }
        return d;
    }

    public static String a(int i) {
        StringBuilder sb;
        String strA;
        String str;
        if (i != 1) {
            if (i == 2) {
                strA = a("https://" + b());
                str = "conf";
            } else if (i == 3) {
                strA = a("https://" + c());
                str = "cdn";
            } else if (i == 4) {
                strA = a("https://" + d());
                str = "log";
            } else {
                sb = new StringBuilder();
            }
            return a(strA, str, false);
        }
        sb = new StringBuilder();
        sb.append("https://");
        sb.append(a());
        return a(a(sb.toString()), "api", false);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    private static String a(String str, String str2, boolean z) {
        String strA;
        try {
            strA = ax.a(FlyVerify.sdkTag, str2, str, z);
        } catch (Throwable th) {
            f.a().a(th);
            strA = null;
        }
        if (TextUtils.isEmpty(strA)) {
            strA = str;
        }
        if (!strA.startsWith("https://")) {
            strA = a("https://" + strA);
        }
        try {
            return ax.a(strA);
        } catch (Throwable th2) {
            f.a().a(th2);
            return "https://" + str;
        }
    }
}
