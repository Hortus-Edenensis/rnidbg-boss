package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kj7 {
    public static void a(Object obj) {
        if (x97.o().isDebugMode()) {
            Log.i("npth", String.valueOf(obj));
        }
    }

    public static void b(String str) {
        if (x97.o().isDebugMode()) {
            Log.w("npth", str);
        }
    }

    public static void c(String str, Object obj) {
        if (x97.o().isDebugMode()) {
            Log.i("npth", str + " " + obj);
        }
    }

    public static void d(String str, Object obj, Throwable th) {
        if (x97.o().isDebugMode()) {
            Log.e("npth", str + " " + obj, th);
        }
    }

    public static void e(String str, Throwable th) {
        if (x97.o().isDebugMode()) {
            Log.e("npth", str + " NPTH Catch Error", th);
        }
    }

    public static void f(Throwable th) {
        if (x97.o().isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void g(Throwable th) {
        if (x97.o().isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
