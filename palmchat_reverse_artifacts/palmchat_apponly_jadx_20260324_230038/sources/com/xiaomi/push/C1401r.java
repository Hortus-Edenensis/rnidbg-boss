package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOppoDevice;

/* JADX INFO: renamed from: com.xiaomi.push.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class C1401r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f11661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f858a;

    public static void a(Context context) {
        f11661a = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m664b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static String c() {
        String strA = q.a(LxAdOppoDevice.PROP_VERSION, "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("ColorOS_")) {
            f858a = "ColorOS_" + strA;
        }
        return f858a;
    }

    private static String d() {
        String strA = q.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("FuntouchOS_")) {
            f858a = "FuntouchOS_" + strA;
        }
        return f858a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Context m660a() {
        return f11661a;
    }

    public static int a() {
        try {
            Class<?> clsA = a(null, "miui.os.Build");
            if (clsA.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return clsA.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String b() {
        String strA = q.a(LxAdEmuiDevice.PROP_VERSION, "");
        f858a = strA;
        return strA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m663a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m662a() {
        return TextUtils.equals((String) aw.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized String m661a() {
        String str = f858a;
        if (str != null) {
            return str;
        }
        String strValueOf = Build.VERSION.INCREMENTAL;
        if (a() <= 0) {
            String strB = b();
            if (TextUtils.isEmpty(strB)) {
                strB = c();
                if (TextUtils.isEmpty(strB)) {
                    strB = d();
                    if (TextUtils.isEmpty(strB)) {
                        strValueOf = String.valueOf(q.a(SystemUtils.PRODUCT_BRAND, AnalyticsConstants.SDK_TYPE) + "_" + strValueOf);
                    }
                }
                strValueOf = strB;
            } else {
                strValueOf = strB;
            }
        }
        f858a = strValueOf;
        return strValueOf;
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        if (str != null && str.trim().length() != 0) {
            boolean z = context != null;
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m74a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }
}
