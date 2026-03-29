package com.ss.android.socialbase.appdownloader.iz;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static String b;
    private static String fx;
    private static String nr;
    private static Boolean pn;
    private static String u;

    public static String b() {
        if (b == null) {
            b = u("getBuildVersion");
        }
        return b;
    }

    public static String fx() {
        if (fx == null) {
            fx = u("getReleaseType");
        }
        return fx;
    }

    public static boolean iz() {
        return pn() && nr(nr(), u()) && u(Process.myUid()) == 0;
    }

    public static boolean nr(Context context) {
        return context != null && b(context) == 0 && iz();
    }

    public static boolean pn() {
        if (pn == null) {
            pn = Boolean.FALSE;
            try {
                pn = Boolean.valueOf("156".equals(u("ro.config.hw_optb", "0")) && ex.Code.equals(u("hw_mc.pure_mode.enable", ex.V)));
            } catch (Exception unused) {
            }
        }
        return pn.booleanValue();
    }

    public static boolean u(Context context) {
        return context != null && fx(context) == 0 && pn();
    }

    public static String x() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String nr() {
        if (nr == null) {
            nr = u("getVersion");
        }
        return nr;
    }

    public static String u() {
        if (u == null) {
            u = u("getApiVersion");
        }
        return u;
    }

    public static int b(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static int fx(Context context) {
        if (context == null) {
            return 1;
        }
        if (nr(nr(), u())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    private static boolean nr(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static String u(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int u(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable unused) {
            return 1;
        }
    }

    private static String u(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
