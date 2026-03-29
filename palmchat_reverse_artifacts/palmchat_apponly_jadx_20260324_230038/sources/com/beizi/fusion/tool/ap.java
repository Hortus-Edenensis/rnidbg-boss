package com.beizi.fusion.tool;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4719a = "SystemUtil";

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static long b(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String d(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int e(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean f(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static float i(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static float j(Context context) {
        return b(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static float k(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float l(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int m(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int n(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(Context context) {
        boolean z;
        Object obj;
        Object obj2;
        try {
            Object objInvoke = ActivityManager.class.getMethod(b.b(y.a(), "alE/Wd6TQF6QDt5MOuPgTJhj5qydYaJMv1s3ioRo108="), new Class[0]).invoke((ActivityManager) context.getSystemService("activity"), new Object[0]);
            if (!(objInvoke instanceof List)) {
                return true;
            }
            String str = context.getApplicationInfo().packageName;
            Iterator it = ((List) objInvoke).iterator();
            if (!it.hasNext()) {
                return true;
            }
            Object next = it.next();
            Class<?> cls = next.getClass();
            try {
                Field declaredField = cls.getDeclaredField(b.b(y.a(), "HmbXL1RJ0QhOMpVM8sDB4g=="));
                declaredField.setAccessible(true);
                obj2 = declaredField.get(next);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean zEquals = obj2 != null ? obj2.equals(str) : true;
            try {
                Field declaredField2 = cls.getDeclaredField(b.b(y.a(), "Qw020bKiuI4Tpk03J/klVA=="));
                declaredField2.setAccessible(true);
                obj = declaredField2.get(next);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                z = iIntValue == 100 || iIntValue == 200;
            }
            return zEquals && z;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return true;
        }
    }

    public static Long p(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return Long.valueOf(packageInfo.lastUpdateTime);
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static long a(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    private static boolean c(String str) {
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec("ls -l " + str);
                String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
                if (line != null && line.length() >= 4) {
                    char cCharAt = line.charAt(3);
                    if (cCharAt == 's' || cCharAt == 'x') {
                        processExec.destroy();
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (processExec == null) {
                    return false;
                }
            }
            processExec.destroy();
            return false;
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    public static boolean b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("tun0".equals(networkInterfaceNextElement.getName()) || "ppp0".equals(networkInterfaceNextElement.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String a() {
        return (new File("/system/bin/su").exists() && c("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && c("/system/xbin/su")) ? "yes" : "no";
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void b(String str) {
        new IllegalArgumentException(str).printStackTrace();
    }
}
