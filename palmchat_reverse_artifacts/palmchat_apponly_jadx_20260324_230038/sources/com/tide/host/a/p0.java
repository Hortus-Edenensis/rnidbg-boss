package com.tide.host.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class p0 {
    public static void a(Context context, String str, int i) {
        if (a(context, str, "plugin_version_prepared")) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putInt("plugin_version_prepared", i);
        editorEdit.commit();
    }

    public static boolean a(Context context, String... strArr) {
        if (context == null) {
            return true;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }
}
