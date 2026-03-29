package com.unicom.online.account.kernel;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f11148a;
    private static DisplayMetrics b;
    private static float c;

    public static void a(Context context) {
        b = new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        b = displayMetrics;
        float f = displayMetrics.densityDpi;
        f11148a = f;
        c = f / 160.0f;
    }

    public final String toString() {
        return " dmDensityDpi:" + f11148a;
    }
}
