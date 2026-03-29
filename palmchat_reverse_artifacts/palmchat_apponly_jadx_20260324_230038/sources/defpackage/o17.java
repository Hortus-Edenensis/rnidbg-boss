package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class o17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f19657a = new Object();
    public static volatile String b = "";
    public static int c = -1;
    public static String d = "";
    public static Context e;
    public static String f;

    public static Context a() {
        return e;
    }

    public static String b(String str, String str2) {
        return (String) kf7.b(kf7.a("android.os.SystemProperties"), "get", new Class[]{String.class, String.class}, new Object[]{str, str2});
    }

    public static void c(Context context) {
        if (context != null) {
            e = context.getApplicationContext();
        }
    }

    public static String d(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static boolean e() {
        return !"cn".equalsIgnoreCase(i());
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(d) && context != null) {
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                if (k17.k()) {
                    e2.printStackTrace();
                }
            }
        }
        return d;
    }

    public static boolean g() {
        return "in".equalsIgnoreCase(i());
    }

    public static int h(Context context) {
        if (-1 == c && context != null) {
            try {
                c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                if (k17.k()) {
                    e2.printStackTrace();
                }
            }
        }
        return c;
    }

    public static String i() {
        if (f == null) {
            k();
        }
        return f;
    }

    public static String j(Context context) {
        if (b != null) {
            return b;
        }
        synchronized (f19657a) {
            if (b != null) {
                return b;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            String str = null;
            Iterator<ActivityManager.RunningAppProcessInfo> it = (runningAppProcesses == null || runningAppProcesses.isEmpty()) ? null : runningAppProcesses.iterator();
            if (it != null) {
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next != null && next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                }
            }
            b = str;
            return str;
        }
    }

    public static void k() {
        String strB = cc7.b();
        if (!TextUtils.isEmpty(strB) && strB.trim().equalsIgnoreCase(hd7.h)) {
            String strB2 = b("persist.sys.oem.region", "CN");
            f = strB2;
            if ("OverSeas".equalsIgnoreCase(strB2)) {
                String country = e.getResources().getConfiguration().locale.getCountry();
                if ("CN".equalsIgnoreCase(country)) {
                    f = "OC";
                    return;
                } else {
                    f = country;
                    return;
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder("persist.sys.");
        String str = hd7.c;
        sb.append(str);
        sb.append(".region");
        String strB3 = b(sb.toString(), "CN");
        f = strB3;
        if ("oc".equalsIgnoreCase(strB3)) {
            if (e.getPackageManager().hasSystemFeature(str + ".version.exp")) {
                return;
            }
            f = "CN";
        }
    }
}
