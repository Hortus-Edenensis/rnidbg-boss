package cn.jiguang.api;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.tv2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MultiSpHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f2450a;

    public static SharedPreferences a(Context context) {
        if (f2450a == null) {
            b(context);
        }
        return f2450a;
    }

    public static void b(Context context) {
        f2450a = context.getSharedPreferences("cn.jpush.android.user.profile", 0);
    }

    public static SharedPreferences c(Context context) {
        Context contextA = tv2.a(context);
        if (contextA == null) {
            return null;
        }
        contextA.getSharedPreferences("cn.jpush.android.user.profile", 4);
        return contextA.getSharedPreferences("cn.jpush.android.user.profile", 0);
    }

    public static void commitBoolean(Context context, String str, boolean z) {
        a(context).edit().putBoolean(str, z).apply();
    }

    public static void commitInt(Context context, String str, int i) {
        a(context).edit().putInt(str, i).apply();
    }

    public static void commitLong(Context context, String str, long j) {
        a(context).edit().putLong(str, j).apply();
    }

    public static void commitString(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return a(context).getBoolean(str, z);
    }

    public static int getInt(Context context, String str, int i) {
        SharedPreferences sharedPreferencesC;
        return ((str.equals("jpush_register_code") || str.equals("service_stoped")) && (sharedPreferencesC = c(context)) != null) ? sharedPreferencesC.getInt(str, i) : a(context).getInt(str, i);
    }

    public static long getLong(Context context, String str, long j) {
        return a(context).getLong(str, j);
    }

    public static String getString(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }
}
