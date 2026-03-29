package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class no {
    public static int a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 200);
        } catch (Throwable th) {
            nl.a(th, "SpUtil", "getPrefsInt");
            return 200;
        }
    }

    private static String b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            nl.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : b(context, "pref", "smac", "00:00:00:00:00:00");
    }

    private static void b(final SharedPreferences.Editor editor) {
        try {
            new AsyncTask<Void, Void, Void>() { // from class: com.amap.api.col.2sl.no.1
                private Void a() {
                    try {
                        SharedPreferences.Editor editor2 = editor;
                        if (editor2 == null) {
                            return null;
                        }
                        editor2.commit();
                        return null;
                    } catch (Throwable th) {
                        nl.a(th, "SpUtil", "commit");
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                public final /* synthetic */ Void doInBackground(Void[] voidArr) {
                    return a();
                }
            }.execute(null, null, null);
        } catch (Throwable th) {
            nl.a(th, "SpUtil", "commit1");
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        a(context, "pref", "smac", str);
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (Throwable th) {
            nl.a(th, "SpUtil", "getPrefsBoolean");
            return true;
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString(str2, str3);
            a(editorEdit);
        } catch (Throwable th) {
            nl.a(th, "SpUtil", "setPrefsStr");
        }
    }

    @SuppressLint({"NewApi"})
    private static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }
}
