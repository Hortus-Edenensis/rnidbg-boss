package com.opos.cmn.biz.a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f {
    public static String a(Context context) {
        SharedPreferences sharedPreferencesC = c(context);
        return sharedPreferencesC != null ? sharedPreferencesC.getString("LAST_BRAND", "") : "";
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferencesC = c(context);
        return sharedPreferencesC != null ? sharedPreferencesC.getString("LAST_REGION", "") : "";
    }

    private static final SharedPreferences c(Context context) {
        return context.getSharedPreferences("com.opos.cmn.biz.ext.prefs", 0);
    }

    public static void a(Context context, String str) {
        try {
            SharedPreferences sharedPreferencesC = c(context);
            if (sharedPreferencesC == null || str == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putString("LAST_BRAND", str);
            editorEdit.commit();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPUtils", "setLastBrand", e);
        }
    }

    public static void b(Context context, String str) {
        try {
            SharedPreferences sharedPreferencesC = c(context);
            if (sharedPreferencesC == null || str == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putString("LAST_REGION", str);
            editorEdit.commit();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPUtils", "setLastRegion", e);
        }
    }
}
