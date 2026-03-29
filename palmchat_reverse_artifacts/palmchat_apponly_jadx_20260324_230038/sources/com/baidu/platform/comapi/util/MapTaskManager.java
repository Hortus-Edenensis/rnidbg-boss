package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MapTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f4227a = Executors.newSingleThreadExecutor(new b("Single"));
    private static final ExecutorService b = Executors.newFixedThreadPool(4, new b("FixedPool"));
    private static final Handler c = new Handler(Looper.getMainLooper());
    private static final ExecutorService d = f.a("DefaultPool");

    public static ExecutorService getDefaultThreadPool() {
        return d;
    }

    public static ExecutorService getFixedThreadPool() {
        return b;
    }

    public static ExecutorService getSingleThreadPool() {
        return f4227a;
    }

    public static void postToMainThread(Runnable runnable, long j) {
        c.postDelayed(runnable, j);
    }
}
