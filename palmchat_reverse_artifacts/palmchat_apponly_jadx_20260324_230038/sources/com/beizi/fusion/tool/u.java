package com.beizi.fusion.tool;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f4749a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        f4749a.postDelayed(runnable, j);
    }
}
