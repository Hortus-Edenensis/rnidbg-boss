package com.baidu.platform.comapi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4237a;
    private static final int b;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f4237a = iAvailableProcessors;
        b = Math.min((iAvailableProcessors * 2) + 1, 8);
    }

    public static ExecutorService a(String str) {
        int i = b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, timeUnit, new LinkedBlockingQueue(), new b(str));
        try {
            threadPoolExecutor.setKeepAliveTime(60L, timeUnit);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        return threadPoolExecutor;
    }
}
