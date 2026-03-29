package com.lantern.auth.android;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ResTool {
    public static int getDrawableId(String str, Context context) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getLayoutId(String str, Context context) {
        return context.getResources().getIdentifier(str, "layout", context.getPackageName());
    }

    public static String getString(String str, Context context) {
        return context.getString(getStringId(str, context));
    }

    public static int getStringId(String str, Context context) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    public static int getStyleId(String str, Context context) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    public static int getViewId(String str, Context context) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }
}
