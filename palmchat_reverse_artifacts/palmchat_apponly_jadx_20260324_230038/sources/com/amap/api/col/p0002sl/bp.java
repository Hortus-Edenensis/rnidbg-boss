package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bp f2656a;
    private static SharedPreferences b;

    private bp() {
    }

    public static void a(Context context) {
        f2656a = new bp();
        b = context.getSharedPreferences("amap_preferences", 0);
    }

    public static String b(String str) {
        return b.getString(str, null);
    }

    public static boolean c(String str) {
        return b.getBoolean(str, false);
    }

    public static void b(String str, int i) {
        SharedPreferences.Editor editorEdit = b.edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static bp a() {
        if (f2656a == null) {
            f2656a = new bp();
        }
        return f2656a;
    }

    public static String a(String str) {
        return b.getString(str, null);
    }

    public static void a(String str, boolean z) {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).commit();
        }
    }

    public static int a(String str, int i) {
        return b.getInt(str, i);
    }

    public static void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = b.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }
}
