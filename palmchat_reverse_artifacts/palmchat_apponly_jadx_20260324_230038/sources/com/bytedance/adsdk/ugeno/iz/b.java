package com.bytedance.adsdk.ugeno.iz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    @SuppressLint({"StaticFieldLeak"})
    private static Context fx;
    private static Resources nr;
    private static String u;

    public static int fx(Context context, String str) {
        return u(context, str, "id");
    }

    public static int nr(Context context, String str) {
        return u(context, str, "drawable");
    }

    private static String u(Context context) {
        if (u == null) {
            u = context.getPackageName();
        }
        return u;
    }

    private static int u(Context context, String str, String str2) {
        if (nr == null) {
            nr = context.getResources();
        }
        return nr.getIdentifier(str, str2, u(context));
    }

    public static int u(Context context, String str) {
        return u(context, str, "raw");
    }
}
