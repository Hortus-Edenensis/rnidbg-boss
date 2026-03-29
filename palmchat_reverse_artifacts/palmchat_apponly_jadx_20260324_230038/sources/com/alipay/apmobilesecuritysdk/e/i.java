package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import defpackage.xu6;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2565a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static Map<String, String> f = new HashMap();

    public static synchronized String a(String str) {
        String str2 = "apdidTokenCache" + str;
        if (f.containsKey(str2)) {
            String str3 = f.get(str2);
            if (xu6.f(str3)) {
                return str3;
            }
        }
        return "";
    }

    public static synchronized String b() {
        return f2565a;
    }

    public static synchronized String c() {
        return b;
    }

    public static synchronized String d() {
        return d;
    }

    public static synchronized String e() {
        return e;
    }

    public static synchronized String f() {
        return c;
    }

    public static synchronized c g() {
        return new c(f2565a, b, c, d, e);
    }

    public static void h() {
        f.clear();
        f2565a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }

    public static synchronized void a() {
    }

    public static void b(String str) {
        f2565a = str;
    }

    public static void c(String str) {
        b = str;
    }

    public static void d(String str) {
        c = str;
    }

    public static void e(String str) {
        d = str;
    }

    public static void f(String str) {
        e = str;
    }

    public static synchronized void a(b bVar) {
        if (bVar != null) {
            f2565a = bVar.f2561a;
            b = bVar.b;
            c = bVar.c;
        }
    }

    public static synchronized void a(c cVar) {
        if (cVar != null) {
            f2565a = cVar.f2562a;
            b = cVar.b;
            d = cVar.d;
            e = cVar.e;
            c = cVar.c;
        }
    }

    public static synchronized void a(String str, String str2) {
        String str3 = "apdidTokenCache" + str;
        if (f.containsKey(str3)) {
            f.remove(str3);
        }
        f.put(str3, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        long jA;
        try {
            jA = h.a(context);
        } catch (Throwable unused) {
        }
        if (jA < 0) {
            jA = 86400000;
        }
        try {
            if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < jA) {
                return true;
            }
        } finally {
        }
        return false;
    }
}
