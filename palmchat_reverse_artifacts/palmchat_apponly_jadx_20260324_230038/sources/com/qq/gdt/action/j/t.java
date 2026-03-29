package com.qq.gdt.action.j;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t {
    private static long a(Context context, String str) {
        return context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.SessionTimePref", 0).getLong(str, 0L);
    }

    public static void b(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("SessionStartTimeV1", j);
        editorEdit.apply();
    }

    public static long c(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("ActivateTimeRevised", -1L);
    }

    public static long d(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("AppStartTime", -1L);
    }

    public static long e(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("AppStartTimeRevised", -1L);
    }

    public static synchronized void f(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a(), 0);
            if (sharedPreferences.getInt("version", 0) == 0) {
                long jA = a(context, "SessionStartTime");
                long jA2 = a(context, "ActivateTimeRevised");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putInt("version", 1);
                if (jA > 0) {
                    editorEdit.putLong("AppStartTime", jA);
                    if (jA2 <= 0) {
                        editorEdit.putLong("ActivateTimeRevised", jA);
                    }
                    editorEdit.putBoolean("ActivateWithImei", true);
                    editorEdit.putBoolean("ActivateWithOaid", true);
                }
                editorEdit.apply();
            }
        } catch (Throwable unused) {
            o.c("Exception while upgrade preference");
        }
    }

    public static boolean g(Context context) {
        return System.currentTimeMillis() - i(context) > 2592000000L;
    }

    public static boolean h(Context context) {
        return System.currentTimeMillis() - j(context) > 2592000000L;
    }

    private static long i(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("RefreshTraceIdTime", -1L);
    }

    private static long j(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("RefreshOpenUrlTime", -1L);
    }

    public static String a() {
        return "com.qq.gdt.action.SessionTimePref_" + u.a(com.qq.gdt.action.d.a().r());
    }

    public static void b(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putBoolean("ActivateWithOaid", z);
        editorEdit.apply();
    }

    public static void c(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("SessionEndTimeV1", j);
        editorEdit.apply();
    }

    public static void d(Context context, long j) {
        o.a("setLastRefreshTraceIdTime:" + j, new Object[0]);
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("RefreshTraceIdTime", j);
        editorEdit.apply();
    }

    public static void e(Context context, long j) {
        o.a("setLastRefreshOpenUrlTime:" + j, new Object[0]);
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("RefreshOpenUrlTime", j);
        editorEdit.apply();
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        if (j > 0) {
            editorEdit.putLong("ActivateTimeRevised", j);
        }
        editorEdit.apply();
    }

    public static boolean b(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getBoolean("ActivateWithOaid", false);
    }

    public static void a(Context context, long j, long j2) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("AppStartTime", j);
        if (j2 > 0) {
            editorEdit.putLong("AppStartTimeRevised", j2);
        }
        editorEdit.apply();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putBoolean("ActivateWithImei", z);
        editorEdit.apply();
    }

    public static boolean a(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getBoolean("ActivateWithImei", false);
    }
}
