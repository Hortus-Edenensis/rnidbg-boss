package com.lantern.auth.android;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLSettings {
    public static boolean getBooleanValue(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 4).getBoolean(str2, z);
    }

    public static boolean getBooleanValuePrivate(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static int getIntValue(Context context, String str, String str2, int i) {
        return context.getSharedPreferences(str, 4).getInt(str2, i);
    }

    public static int getIntValuePrivate(Context context, String str, String str2, int i) {
        return context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static long getLongValue(Context context, String str, String str2, long j) {
        return context.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public static long getLongValuePrivate(Context context, String str, String str2, long j) {
        return context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static String getStringValue(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public static String getStringValuePrivate(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static boolean setBooleanValue(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putBoolean(str2, z);
        return editorEdit.commit();
    }

    public static boolean setBooleanValuePrivate(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putBoolean(str2, z);
        return editorEdit.commit();
    }

    public static boolean setIntValue(Context context, String str, String str2, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putInt(str2, i);
        return editorEdit.commit();
    }

    public static boolean setIntValuePrivate(Context context, String str, String str2, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putInt(str2, i);
        return editorEdit.commit();
    }

    public static boolean setLongValue(Context context, String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j);
        return editorEdit.commit();
    }

    public static boolean setLongValuePrivate(Context context, String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putLong(str2, j);
        return editorEdit.commit();
    }

    public static boolean setStringValue(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        return editorEdit.commit();
    }

    public static boolean setStringValuePrivate(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        return editorEdit.commit();
    }
}
