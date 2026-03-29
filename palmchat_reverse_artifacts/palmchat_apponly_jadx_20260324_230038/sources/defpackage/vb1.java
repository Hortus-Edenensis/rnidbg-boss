package defpackage;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vb1 {
    public static volatile vb1 q;
    public static final Object r = new Object();
    public static String s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient AtomicBoolean f21398a = new AtomicBoolean(false);
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public vb1(Context context) {
        c(context);
    }

    public static vb1 a(Context context) {
        if (q == null) {
            synchronized (r) {
                if (q == null) {
                    q = new vb1(context);
                }
            }
        }
        return q;
    }

    public static String b(Context context) {
        if (s == null) {
            try {
                String strSubstring = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (strSubstring.length() > 30) {
                    strSubstring = strSubstring.substring(0, 30);
                }
                s = strSubstring;
            } catch (Throwable unused) {
                k63.b("DeviceInfo", "NO versionName defined in manifest.");
            }
        }
        String str = s;
        return str == null ? "" : str;
    }

    public final void c(Context context) {
        if (this.f21398a.get() || context == null) {
            return;
        }
        this.c = d(Build.VERSION.RELEASE) + "," + Build.VERSION.SDK_INT;
        this.d = d(Build.MODEL);
        this.e = ad.q(context, "gsm.version.baseband", "baseband");
        this.f = d(Build.DEVICE);
        this.k = d(Build.PRODUCT);
        this.l = d(Build.MANUFACTURER);
        this.m = d(Build.FINGERPRINT);
        this.n = d(Build.BRAND);
        this.b = b(context);
        this.g = fv2.f(context);
        this.h = ad.z(context) ? 1 : 0;
        this.i = ad.r(context);
        this.j = ad.c(context);
        this.o = "";
        this.p = "";
        this.f21398a.set(true);
    }

    public final String d(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }
}
