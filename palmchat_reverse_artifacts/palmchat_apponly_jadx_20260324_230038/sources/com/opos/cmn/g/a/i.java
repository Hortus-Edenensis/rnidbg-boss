package com.opos.cmn.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class i {
    public static String a(Context context) {
        SharedPreferences sharedPreferencesE = e(context);
        return sharedPreferencesE != null ? sharedPreferencesE.getString("ouid", "") : "";
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferencesE = e(context);
        return sharedPreferencesE != null ? sharedPreferencesE.getString("duid", "") : "";
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferencesE = e(context);
        return sharedPreferencesE != null ? sharedPreferencesE.getString("gaid", "") : "";
    }

    public static boolean d(Context context) {
        SharedPreferences sharedPreferencesE = e(context);
        if (sharedPreferencesE != null) {
            return sharedPreferencesE.getBoolean("ouid_status", false);
        }
        return false;
    }

    private static final SharedPreferences e(Context context) {
        return context.getSharedPreferences("com.opos.cmn.third.id.prefs", 0);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferencesE;
        if (TextUtils.isEmpty(str) || (sharedPreferencesE = e(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
        editorEdit.putString("ouid", str);
        editorEdit.apply();
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferencesE;
        if (TextUtils.isEmpty(str) || (sharedPreferencesE = e(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
        editorEdit.putString("duid", str);
        editorEdit.apply();
    }

    public static void c(Context context, String str) {
        SharedPreferences sharedPreferencesE;
        if (TextUtils.isEmpty(str) || (sharedPreferencesE = e(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
        editorEdit.putString("gaid", str);
        editorEdit.apply();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences sharedPreferencesE = e(context);
        if (sharedPreferencesE != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
            editorEdit.putBoolean("ouid_status", z);
            editorEdit.apply();
        }
    }

    public static void b(Context context, boolean z) {
        SharedPreferences sharedPreferencesE = e(context);
        if (sharedPreferencesE != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
            editorEdit.putBoolean("gaid_status", z);
            editorEdit.apply();
        }
    }
}
