package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class uh7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f21215a = null;
    public static long b = 0;
    public static String c = "default";
    public static boolean d = false;

    @SuppressLint({"StaticFieldLeak"})
    public static fl7 e;
    public static volatile ConcurrentHashMap<Integer, String> h;
    public static volatile int j;
    public static volatile String k;
    public static ti7 f = new ti7();
    public static mi7 g = new mi7();
    public static wh7 i = null;

    public static ConcurrentHashMap<Integer, String> a() {
        return h;
    }

    public static Context b() {
        return f21215a;
    }

    public static wh7 c() {
        if (i == null) {
            synchronized (uh7.class) {
                i = new wh7(f21215a);
            }
        }
        return i;
    }

    public static long d() {
        return b;
    }

    public static int e() {
        return j;
    }

    public static boolean f() {
        return d;
    }

    public static mi7 g() {
        return g;
    }

    public static ti7 h() {
        return f;
    }

    public static String i() {
        return k;
    }

    public static fl7 j() {
        return e;
    }

    public static void k(Context context, ij7 ij7Var) {
        b = System.currentTimeMillis();
        f21215a = context;
        e = new fl7(context, ij7Var);
    }

    public static String l() {
        return c;
    }
}
