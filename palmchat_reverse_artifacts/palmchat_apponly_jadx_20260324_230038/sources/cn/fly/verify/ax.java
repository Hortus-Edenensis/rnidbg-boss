package cn.fly.verify;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2078a;
    public static final String b;
    private static volatile Context c;

    static {
        int i;
        String strReplace = "1.0.0";
        try {
            strReplace = "2024-09-10".replace("-", ".");
            i = Integer.parseInt("2024-09-10".replace("-", ""));
        } catch (Throwable unused) {
            i = 1;
        }
        f2078a = i;
        b = strReplace;
    }

    public static bb a() {
        return ec.e == null ? bb.DEFAULT : ec.e;
    }

    public static boolean b() {
        return ec.f;
    }

    public static boolean c() {
        return ec.g;
    }

    public static String d() {
        if (ei.h()) {
            return ef.a();
        }
        return null;
    }

    public static String e() {
        return TextUtils.isEmpty(ec.b) ? ec.d : ec.b;
    }

    public static Context f() {
        return c;
    }

    public static Context g() {
        if (c == null) {
            try {
                Context contextA = eg.a();
                if (contextA != null) {
                    a(contextA);
                }
            } catch (Throwable unused) {
            }
        }
        return c;
    }

    public static final boolean h() {
        return ef.c();
    }

    public static int i() {
        return ei.c();
    }

    @Deprecated
    public static String a(String str) {
        return eg.a(str);
    }

    public static String a(String str, String str2, String str3, boolean z) {
        return ef.a(str, str2, str3, z);
    }

    public static synchronized void a(Context context) {
        a(context, null, null);
    }

    public static synchronized void a(Context context, String str, String str2) {
        if (context == null) {
            Log.e("SDK", "Init error, context is null");
            return;
        }
        if (c == null) {
            c = context.getApplicationContext();
            ec.f2222a = str;
            ec.b = str2;
            ef.a(false);
        } else if (!TextUtils.isEmpty(str) && !str.equals(ec.f2222a)) {
            ec.f2222a = str;
            ec.b = str2;
            ef.a(true);
        }
    }

    public static void a(aw awVar) {
        az.a().a(awVar);
    }

    public static void a(aw awVar, boolean z) {
        ei.b(z);
        a(awVar);
    }

    public static void a(boolean z) {
        a(null, z);
    }
}
