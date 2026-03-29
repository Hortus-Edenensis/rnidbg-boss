package com.zm.fda.oaid.Z2500;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class Z0225 {
    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            Log.e(ZZ00Z.f16721a, e.getMessage(), e);
            str3 = null;
        }
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public static boolean b() {
        return Build.MANUFACTURER.toUpperCase().contains("ASUS") || Build.BRAND.toUpperCase().contains("ASUS");
    }

    public static boolean c() {
        return Build.MANUFACTURER.toUpperCase().contains("BLACKSHARK") || Build.BRAND.toUpperCase().contains("BLACKSHARK");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a(LxAdEmuiDevice.PROP_VERSION, ""));
    }

    public static boolean e() {
        return Build.BRAND.toUpperCase().contains("HONOR") && !f();
    }

    public static boolean f() {
        return !TextUtils.isEmpty(a(LxAdEmuiDevice.PROP_VERSION));
    }

    public static boolean g() {
        if (!Build.MANUFACTURER.toUpperCase().contains("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.toUpperCase().contains("HUAWEI") && !str.toUpperCase().contains("HONOR") && !d()) {
                return false;
            }
        }
        return true;
    }

    public static boolean h() {
        if (!Build.MANUFACTURER.toUpperCase().contains("LENOVO")) {
            String str = Build.BRAND;
            if (!str.toUpperCase().contains("LENOVO") && !k() && !str.toUpperCase().contains("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean i() {
        return Build.MANUFACTURER.toUpperCase().contains("MEIZU") || Build.BRAND.toUpperCase().contains("MEIZU") || Build.DISPLAY.toUpperCase().contains(LxAdOSUtils.ROM_FLYME);
    }

    public static boolean j() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean k() {
        return Build.MANUFACTURER.toUpperCase().contains("MOTOROLA") || Build.BRAND.toUpperCase().contains("MOTOROLA");
    }

    public static boolean l() {
        return Build.MANUFACTURER.toUpperCase().contains("NUBIA") || Build.BRAND.toUpperCase().contains("NUBIA");
    }

    public static boolean m() {
        return Build.MANUFACTURER.toUpperCase().contains("ONEPLUS") || Build.BRAND.toUpperCase().contains("ONEPLUS");
    }

    public static boolean n() {
        if (!Build.MANUFACTURER.toUpperCase().contains("OPPO")) {
            String str = Build.BRAND;
            if (!str.toUpperCase().contains("OPPO") && !str.toUpperCase().contains("REALME") && TextUtils.isEmpty(a(LxAdOppoDevice.PROP_VERSION, "")) && !m()) {
                return false;
            }
        }
        return true;
    }

    public static boolean o() {
        return Build.MANUFACTURER.toUpperCase().contains("SAMSUNG") || Build.BRAND.toUpperCase().contains("SAMSUNG");
    }

    public static boolean p() {
        return Build.MANUFACTURER.toUpperCase().contains(LxAdOSUtils.ROM_VIVO) || Build.BRAND.toUpperCase().contains(LxAdOSUtils.ROM_VIVO) || !TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public static boolean q() {
        if (!Build.MANUFACTURER.toUpperCase().contains("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.toUpperCase().contains("XIAOMI") && !str.toUpperCase().contains("REDMI") && !j() && !c()) {
                return false;
            }
        }
        return true;
    }

    public static boolean r() {
        return Build.MANUFACTURER.toUpperCase().contains("ZTE") || Build.BRAND.toUpperCase().contains("ZTE");
    }

    public static boolean b(Context context) {
        String str = Build.MANUFACTURER;
        return str.toUpperCase().contains("GOOGLE") || str.toUpperCase().contains("PIXEL") || Build.MODEL.toUpperCase().contains("GOOGLE") || c(context);
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.google.android.gms.GoogleApiAvailability");
            return ((Boolean) cls.getDeclaredMethod("isGooglePlayServicesAvailable", Context.class).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), context)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a() {
        return !TextUtils.isEmpty(a("ro.build.uiversion", ""));
    }

    public static String a(String str) {
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (ClassNotFoundException e) {
            Log.e("HONOR", "getBuildVersion ClassNotFoundException" + e.getMessage());
            str2 = "";
        } catch (IllegalAccessException e2) {
            Log.e("HONOR", "getBuildVersion IllegalAccessException" + e2.getMessage());
            str2 = "";
        } catch (NoSuchMethodException e3) {
            Log.e("HONOR", "getBuildVersion NoSuchMethodException" + e3.getMessage());
            str2 = "";
        } catch (InvocationTargetException e4) {
            Log.e("HONOR", "getBuildVersion InvocationTargetException" + e4.getMessage());
            str2 = "";
        } catch (Exception e5) {
            Log.e("HONOR", "getBuildVersion Exception" + e5.getMessage());
            str2 = "";
        }
        Log.i("HONOR", "getBuildVersion: " + str2);
        return str2;
    }
}
