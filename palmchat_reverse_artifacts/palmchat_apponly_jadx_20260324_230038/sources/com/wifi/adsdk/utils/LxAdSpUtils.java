package com.wifi.adsdk.utils;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdSpUtils {
    public static final String spName = "lxad_ad_sdk_unique";

    public static boolean getBoolean(String str, String str2, boolean z, Context context) {
        return context == null ? z : context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static long getLong(String str, String str2, long j, Context context) {
        return context == null ? j : context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static String getString(String str, String str2, Context context) {
        return context == null ? str2 : context.getSharedPreferences(spName, 0).getString(str, str2);
    }

    public static void setBoolean(String str, String str2, boolean z, Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putBoolean(str2, z).apply();
    }

    public static void setLong(String str, String str2, long j, Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putLong(str2, j).apply();
    }

    public static void setString(String str, String str2, Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(spName, 0).edit().putString(str, str2).apply();
    }

    public static String getString(String str, String str2, String str3, Context context) {
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void setString(String str, String str2, String str3, Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }
}
