package com.igexin.base.api;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class GTBase {
    public static Context context;

    public static boolean init(Context context2) {
        if (context2 == null) {
            return false;
        }
        context = context2;
        SharedPreferencesManager.init(context2);
        return true;
    }
}
