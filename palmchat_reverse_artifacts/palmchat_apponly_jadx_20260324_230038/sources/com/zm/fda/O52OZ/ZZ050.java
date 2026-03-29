package com.zm.fda.O52OZ;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ050 {
    public static int a(Context context, String str, String str2, int i) {
        return context == null ? i : context.getSharedPreferences(str, 4).getInt(str2, i);
    }

    public static boolean b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        return editorEdit.commit();
    }

    public static String a(Context context, String str, String str2, String str3) {
        return context == null ? str3 : context.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public static long a(Context context, String str, String str2, long j) {
        return context == null ? j : context.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public static boolean b(Context context, String str, String str2, int i) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putInt(str2, i);
        return editorEdit.commit();
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        return context == null ? z : context.getSharedPreferences(str, 4).getBoolean(str2, z);
    }

    public static boolean a(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.remove(str2);
        return editorEdit.commit();
    }

    public static boolean b(Context context, String str, String str2, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j);
        return editorEdit.commit();
    }

    public static boolean b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putBoolean(str2, z);
        return editorEdit.commit();
    }
}
