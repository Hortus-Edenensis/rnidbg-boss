package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.adsdk.utils.LxAdOSUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10858a = "";
    private static String b = "";
    private static final String c = "hw_sc.build.platform.version";
    private static final String d = "ro.build.version.emui";
    private static final String e = "ro.build.version.magic";
    private static final String f = "ro.miui.ui.version.name";
    private static final String g = "ro.build.version.opporom";
    private static final String h = "ro.vivo.os.name";
    private static final String i = "ro.vivo.os.version";
    private static final String j = "ro.build.version.oplusrom";
    private static final String k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(f10858a)) {
            e(str);
        }
        return b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(String str) {
        try {
            switch (c(str)) {
                case "HUAWEI":
                    if (!a()) {
                        f10858a = LxAdOSUtils.ROM_EMUI;
                        b = d("ro.build.version.emui");
                        break;
                    } else {
                        b = d(c);
                        f10858a = "HarmonyOS";
                        break;
                    }
                    break;
                case "HONOR":
                    if (!TextUtils.isEmpty(d(e))) {
                        f10858a = "MagicUI";
                        b = d(e);
                        break;
                    } else {
                        f10858a = LxAdOSUtils.ROM_EMUI;
                        b = d("ro.build.version.emui");
                        break;
                    }
                    break;
                case "XIAOMI":
                case "REDMI":
                    f10858a = LxAdOSUtils.ROM_MIUI;
                    b = d(f);
                    break;
                case "REALME":
                case "OPPO":
                    f10858a = "ColorOS";
                    b = d("ro.build.version.opporom");
                    break;
                case "VIVO":
                    f10858a = "Funtouch";
                    b = d(i);
                    break;
                case "ONEPLUS":
                    f10858a = "HydrogenOS";
                    String strD = d(k);
                    if (TextUtils.isEmpty(strD)) {
                        f10858a = "ColorOS";
                        strD = d(j);
                    }
                    b = strD;
                    break;
                default:
                    f10858a = AnalyticsConstants.SDK_TYPE;
                    b = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(f10858a)) {
            e(str);
        }
        return f10858a;
    }
}
