package com.lantern.auth.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.lantern.auth.core.BLLog;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLPlatform {
    public static final int FLAG_TRANSLUCENT_NAVIGATION = 134217728;
    public static final int FLAG_TRANSLUCENT_STATUS = 67108864;
    public static final int VERSION_CODES_ICE_CREAM_SANDWICH = 14;
    public static final int VERSION_CODES_ICE_CREAM_SANDWICH_MR1 = 15;
    public static final int VERSION_CODES_JELLY_BEAN = 16;
    public static final int VERSION_CODES_JELLY_BEAN_MR1 = 17;
    public static final int VERSION_CODES_JELLY_BEAN_MR2 = 18;
    public static final int VERSION_CODES_KITKAT = 19;

    public static int getAndroidVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static String getAndroidVersionName() {
        return Build.VERSION.CODENAME;
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            BLLog.e(e);
            BLLog.e("No app version found");
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            BLLog.e(e);
            BLLog.e("No app version found");
            return "0.0";
        }
    }

    public static String getCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        if (networkOperatorName != null && networkOperatorName.length() != 0) {
            return networkOperatorName;
        }
        BLLog.e("No carrier found");
        return "";
    }

    public static String getDefaultLocale() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        if (language != null) {
            language = language.toLowerCase();
        }
        String country = locale.getCountry();
        if (country != null) {
            country = country.toUpperCase();
        }
        if (country == null) {
            return language;
        }
        return language + "-" + country;
    }

    public static int getDensity(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getDensityStr(Context context) {
        int density = getDensity(context);
        return density != 120 ? density != 160 ? density != 213 ? density != 240 ? density != 320 ? density != 400 ? density != 480 ? density != 640 ? "" : "XXXHDPI" : "XXHDPI" : "XMHDPI" : "XHDPI" : "HDPI" : "TVDPI" : "MDPI" : "LDPI";
    }

    public static String getDeviceFingerprint() {
        return Build.FINGERPRINT;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getFirmwareVersion() {
        return getOSVersion();
    }

    public static String getLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static String getOS() {
        return AnalyticsConstants.SDK_TYPE;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getResolution(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Exception e) {
            BLLog.e(e);
            return "";
        }
    }

    public static Point getScreenSize(Context context) {
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        try {
            Point point2 = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point2);
            point.x = point2.x;
            point.y = point2.y;
        } catch (Exception unused) {
        }
        return point;
    }

    public static String getSimSerialNumber(Context context) {
        return PrivInfoManager.INSTANCE.getSimNum();
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isChina() {
        return "CN".equalsIgnoreCase(Locale.getDefault().getCountry());
    }

    public static boolean isIcecreamSandwich4_0() {
        return false;
    }

    public static boolean isIcecreamSandwich4_0_3() {
        return false;
    }

    public static boolean isJellyBean4_1() {
        return false;
    }

    public static boolean isJellyBean4_1OrLater() {
        return true;
    }

    public static boolean isJellyBean4_2() {
        return false;
    }

    public static boolean isJellyBean4_2OrLater() {
        return true;
    }

    public static boolean isJellyBean4_3() {
        return false;
    }

    public static boolean isJellyBean4_3OrLater() {
        return true;
    }

    public static boolean isKITKAT4_4() {
        return false;
    }

    public static boolean isKITKAT4_4OrLater() {
        return true;
    }
}
