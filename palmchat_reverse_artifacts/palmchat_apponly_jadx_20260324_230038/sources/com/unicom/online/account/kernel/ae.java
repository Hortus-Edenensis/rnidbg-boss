package com.unicom.online.account.kernel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"ApplySharedPref"})
public final class ae {
    public static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("cuAuthCacheName", 0).getString(str, "");
        } catch (Exception e) {
            ab.c(e.getMessage());
            return "";
        }
    }

    public static Long b(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("cuAuthCacheName", 0).getLong(str, 0L);
        } catch (Exception e) {
            ab.c(e.getMessage());
        }
        return Long.valueOf(j);
    }

    public static void a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            editorEdit.putLong(str, l.longValue());
            editorEdit.commit();
        } catch (Exception e) {
            ab.c(e.getMessage());
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            editorEdit.putString(str, str2);
            return editorEdit.commit();
        } catch (Exception e) {
            ab.c(e.getMessage());
            return false;
        }
    }
}
