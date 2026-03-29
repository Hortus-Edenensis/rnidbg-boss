package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class bj {
    private static final v Code = new v(new Handler(Looper.getMainLooper()));

    public static void Code(Runnable runnable) {
        Code.Code(runnable);
    }

    public static void Code(Runnable runnable, long j) {
        Code.Code(runnable, null, j);
    }

    public static void Code(Runnable runnable, String str) {
        Code.Code(runnable, str, 0L);
    }

    public static void Code(Runnable runnable, String str, long j) {
        Code.Code(runnable, str, j);
    }

    public static void Code(String str) {
        Code.Code(str);
    }
}
