package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    private static volatile Handler u;

    public static Handler fx() {
        return com.bytedance.sdk.component.jk.nr.u.u().fx();
    }

    public static Handler nr() {
        if (u == null) {
            synchronized (jk.class) {
                if (u == null) {
                    u = new Handler(Looper.getMainLooper());
                }
            }
        }
        return u;
    }

    public static Handler u() {
        return com.bytedance.sdk.component.jk.nr.u.u().nr();
    }
}
