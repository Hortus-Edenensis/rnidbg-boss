package com.zm.fissionsdk;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class WVVzW {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16733a = "AdxSdk";
    public static final String b = "TRACE";
    public static final boolean c = e("WfSdk");
    public static boolean d = true;

    /* JADX INFO: compiled from: SearchBox */
    public interface zZZ2W {
        String a();
    }

    public static String a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void b(String str) {
        if (a()) {
            a(f16733a, str);
        }
    }

    public static void c(String str) {
        if (a()) {
            b(f16733a, str);
        }
    }

    public static void d(String str) {
        if (a()) {
            c(f16733a, str);
        }
    }

    public static boolean e(String str) {
        try {
            return Log.isLoggable(str, 2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void f(String str) {
        if (a()) {
            f(f16733a, str);
        }
    }

    public static void g(String str) {
        if (a()) {
            g(f16733a, str);
        }
    }

    public static void e(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.v(a(str), " \n【Log msg start】------------------------------------------------------------------------------------------------------------------------------------------\n" + a(strArr));
    }

    public static void b(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.e(a(str), a(strArr));
    }

    public static void c(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.i(a(str), a(strArr));
    }

    public static void d(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.v(a(str), a(strArr) + "\n【Log msg end】------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public static void f(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.v(a(str), a(strArr));
    }

    public static void g(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.w(a(str), a(strArr));
    }

    public static void b(String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.w(a(b), a(strArr));
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return f16733a;
        }
        return f16733a + "-" + str;
    }

    public static void b(String str, String str2, Throwable th) {
        if (!a() || str2 == null) {
            return;
        }
        Log.e(a(str), str2, th);
    }

    public static boolean a() {
        return c || d;
    }

    public static void a(zZZ2W zzz2w) {
        if (!a() || zzz2w == null) {
            return;
        }
        c(f16733a, zzz2w.a());
    }

    public static void a(Throwable th) {
        if (a()) {
            b(f16733a, th.toString());
        }
    }

    public static void a(String str, String... strArr) {
        if (!a() || strArr == null) {
            return;
        }
        Log.d(a(str), a(strArr));
    }

    public static void a(String str, String str2, Throwable th) {
        if (!a() || str2 == null) {
            return;
        }
        Log.d(a(str), str2, th);
    }
}
