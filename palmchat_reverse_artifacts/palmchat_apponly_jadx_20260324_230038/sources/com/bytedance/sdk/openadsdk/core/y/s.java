package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.ex;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
    private static String b = null;
    private static Boolean fx = null;
    private static Boolean iz = null;
    private static int n = 1;
    private static String nr = null;
    private static String pn = null;
    private static String u = null;
    private static int x = 1;

    public static boolean a() {
        return t() == 0 && jk();
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toUpperCase().startsWith("HONOR")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toUpperCase().startsWith("HONOR");
    }

    public static boolean fx() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toUpperCase().startsWith("HUAWEI")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toUpperCase().startsWith("HUAWEI");
    }

    public static String iz() {
        return nr;
    }

    public static boolean jk() {
        return l() && u(iz(), pn()) && mv() == 0;
    }

    public static boolean l() {
        Boolean bool = iz;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static int mv() {
        return n;
    }

    public static String n() {
        return b;
    }

    public static boolean nr() {
        Boolean bool = fx;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static String pn() {
        return u;
    }

    public static int t() {
        return x;
    }

    public static void u() {
        if (fx == null) {
            if (!b() && !fx()) {
                fx = Boolean.FALSE;
                return;
            }
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                fx = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                fx = Boolean.FALSE;
            }
            if (u == null) {
                u = u("getApiVersion");
            }
            if (nr == null) {
                nr = u("getVersion");
            }
            if (pn == null) {
                pn = u("getReleaseType");
            }
            if (b == null) {
                b = u("getBuildVersion");
            }
            if (iz == null) {
                iz = Boolean.FALSE;
                try {
                    iz = Boolean.valueOf("156".equals(nr("ro.config.hw_optb", "0")) && ex.Code.equals(nr("hw_mc.pure_mode.enable", ex.V)));
                } catch (Exception unused2) {
                }
            }
            try {
                x = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.dw.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
            } catch (Throwable unused3) {
            }
            try {
                Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                n = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
            } catch (Throwable unused4) {
            }
        }
    }

    public static String x() {
        return pn;
    }

    private static int nr(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static String nr(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
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

    public static boolean u(Context context) {
        return context != null && nr(context) == 0 && l();
    }

    public static void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", a() ? 1 : 2);
            if (!jk()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable unused) {
        }
    }

    private static boolean u(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }
}
