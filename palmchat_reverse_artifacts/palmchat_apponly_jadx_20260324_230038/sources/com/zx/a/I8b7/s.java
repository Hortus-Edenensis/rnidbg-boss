package com.zx.a.I8b7;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f16857a;

    public static int a(Context context, float f) {
        if (f16857a == 0.0f) {
            f16857a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * f16857a) + 0.5f);
    }
}
