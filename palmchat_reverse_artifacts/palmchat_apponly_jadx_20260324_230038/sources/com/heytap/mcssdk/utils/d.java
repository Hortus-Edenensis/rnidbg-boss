package com.heytap.mcssdk.utils;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6356a = "mcssdk---";
    private static String b = "MCS";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static String h = "-->";
    private static boolean i = true;

    public static String a() {
        return b;
    }

    public static void b(String str) {
        if (e && i) {
            Log.d(f6356a, b + h + str);
        }
    }

    public static void c(String str) {
        if (d && i) {
            Log.i(f6356a, b + h + str);
        }
    }

    public static void d(String str) {
        if (f && i) {
            Log.w(f6356a, b + h + str);
        }
    }

    public static void e(String str) {
        if (g && i) {
            Log.e(f6356a, b + h + str);
        }
    }

    public static void f(String str) {
        b = str;
    }

    public static void g(String str) {
        h = str;
    }

    public static String h() {
        return h;
    }

    public static void a(Exception exc) {
        if (!g || exc == null) {
            return;
        }
        Log.e(f6356a, exc.getMessage());
    }

    public static void b(String str, String str2) {
        if (e && i) {
            Log.d(str, b + h + str2);
        }
    }

    public static void c(String str, String str2) {
        if (d && i) {
            Log.i(str, b + h + str2);
        }
    }

    public static void d(String str, String str2) {
        if (f && i) {
            Log.w(str, b + h + str2);
        }
    }

    public static void e(String str, String str2) {
        if (g && i) {
            Log.e(str, b + h + str2);
        }
    }

    public static void f(boolean z) {
        i = z;
        boolean z2 = z;
        c = z2;
        e = z2;
        d = z2;
        f = z2;
        g = z2;
    }

    public static boolean g() {
        return i;
    }

    public static void a(String str) {
        if (c && i) {
            Log.v(f6356a, b + h + str);
        }
    }

    public static void b(boolean z) {
        e = z;
    }

    public static void c(boolean z) {
        d = z;
    }

    public static void d(boolean z) {
        f = z;
    }

    public static void e(boolean z) {
        g = z;
    }

    public static boolean f() {
        return g;
    }

    public static void a(String str, String str2) {
        if (c && i) {
            Log.v(str, b + h + str2);
        }
    }

    public static boolean b() {
        return c;
    }

    public static boolean c() {
        return e;
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        return f;
    }

    public static void a(String str, Throwable th) {
        if (g) {
            Log.e(str, th.toString());
        }
    }

    public static void a(boolean z) {
        c = z;
    }
}
