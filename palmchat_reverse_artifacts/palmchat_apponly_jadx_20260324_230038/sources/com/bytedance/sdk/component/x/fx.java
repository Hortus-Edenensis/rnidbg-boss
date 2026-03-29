package com.bytedance.sdk.component.x;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static volatile Context u;

    public static Context getContext() {
        return u;
    }

    public static void u(Context context) {
        if (u == null && context != null) {
            u = context.getApplicationContext();
        }
    }
}
