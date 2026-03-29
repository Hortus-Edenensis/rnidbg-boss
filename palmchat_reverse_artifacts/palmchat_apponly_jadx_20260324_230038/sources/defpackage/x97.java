package defpackage;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.runtime.ConfigManager;
import com.baidu.platform.comapi.map.MapController;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class x97 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f21908a = null;
    public static Application b = null;
    public static long c = 0;
    public static boolean d = false;

    @SuppressLint({"StaticFieldLeak"})
    public static a87 e;
    public static volatile ConcurrentHashMap<Integer, String> h;
    public static volatile String m;
    public static ConfigManager f = new ConfigManager();
    public static yu6 g = new yu6();
    public static jj7 i = null;
    public static volatile String j = null;
    public static Object k = new Object();
    public static volatile int l = 0;
    public static int n = 0;
    public static boolean o = true;
    public static boolean p = false;
    public static boolean q = true;

    public static a87 a() {
        if (e == null) {
            e = le7.a(f21908a);
        }
        return e;
    }

    public static String b(long j2, CrashType crashType, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j2);
        sb.append("_");
        sb.append(crashType.getName());
        sb.append('_');
        sb.append(l());
        sb.append('_');
        sb.append(z ? "oom_" : "normal_");
        sb.append(p());
        sb.append('_');
        sb.append(z2 ? "ignore_" : "normal_");
        sb.append(Long.toHexString(new Random().nextLong()));
        sb.append(WkAdxAdConfigMg.DSP_NAME_GDT);
        return sb.toString();
    }

    public static void c(Application application, Context context) {
        if (b == null) {
            c = System.currentTimeMillis();
            f21908a = context;
            b = application;
            j = Long.toHexString(new Random().nextLong()) + WkAdxAdConfigMg.DSP_NAME_GDT;
        }
    }

    public static void d(a87 a87Var) {
        e = a87Var;
    }

    public static void e(boolean z) {
        o = z;
    }

    public static yu6 f() {
        return g;
    }

    public static void g(boolean z) {
        p = z;
    }

    public static jj7 h() {
        if (i == null) {
            synchronized (x97.class) {
                i = new jj7(f21908a);
            }
        }
        return i;
    }

    public static void i(boolean z) {
        q = z;
    }

    public static boolean j() {
        return o().isDebugMode() && t().contains("local_test");
    }

    public static String k() {
        return l() + '_' + Long.toHexString(new Random().nextLong()) + WkAdxAdConfigMg.DSP_NAME_GDT;
    }

    public static String l() {
        if (j == null) {
            synchronized (k) {
                if (j == null) {
                    j = Long.toHexString(new Random().nextLong()) + "U";
                }
            }
        }
        return j;
    }

    public static Context m() {
        return f21908a;
    }

    public static Application n() {
        return b;
    }

    public static ConfigManager o() {
        return f;
    }

    public static long p() {
        return c;
    }

    public static String q() {
        return MapController.DEFAULT_LAYER_TAG;
    }

    public static int r() {
        return n;
    }

    public static boolean s() {
        return d;
    }

    public static String t() {
        Object obj = a().b().get("channel");
        return obj == null ? "unknown" : String.valueOf(obj);
    }

    public static ConcurrentHashMap<Integer, String> u() {
        return h;
    }

    public static int v() {
        return l;
    }

    public static String w() {
        return m;
    }

    public static boolean x() {
        return p;
    }

    public static boolean y() {
        return q;
    }

    public static boolean z() {
        return o;
    }
}
