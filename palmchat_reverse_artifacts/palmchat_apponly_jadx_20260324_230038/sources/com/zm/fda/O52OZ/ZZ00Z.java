package com.zm.fda.O52OZ;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16633a = null;
    public static int b = -1;
    public static String c;
    public static String d;
    public static int e;

    public static String a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String b(Context context) {
        String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, ZZ00Z.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                processName = (String) objInvoke;
            }
        } catch (Throwable unused) {
            Log.e("ProcessUtil", "Unable to check ActivityThread for processName");
        }
        if (context == null) {
            processName = "";
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == iMyPid) {
                            processName = runningAppProcessInfo.processName;
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return processName == null ? "" : processName;
    }

    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            b = packageInfo.versionCode;
            c = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return c;
    }

    public static int c(Context context) {
        int i = b;
        if (i != -1) {
            return i;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            b = packageInfo.versionCode;
            c = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return b;
    }

    public static String a(Context context) {
        String str = f16633a;
        if (str != null) {
            return str;
        }
        if (context != null) {
            f16633a = a(context, context.getPackageName());
        }
        return f16633a;
    }

    public static String a() {
        return O2O5Z.a(d);
    }

    public static void a(String str) {
        d = str;
    }

    public static int b() {
        int i = e;
        if (i > 0) {
            return i;
        }
        int i2 = 0;
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles();
            if (fileArrListFiles != null) {
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (i2 < length) {
                    try {
                        File file = fileArrListFiles[i2];
                        if (file != null) {
                            String name = file.getName();
                            if (!TextUtils.isEmpty(name) && name.matches("cpu[0-9]+")) {
                                i3++;
                            }
                        }
                        i2++;
                    } catch (Throwable unused) {
                    }
                }
                i2 = i3;
            }
        } catch (Throwable unused2) {
        }
        if (i2 < 0) {
            i2 = 4;
        }
        e = i2;
        return i2;
    }
}
