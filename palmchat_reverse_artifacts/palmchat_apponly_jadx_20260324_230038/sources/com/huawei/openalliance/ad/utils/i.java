package com.huawei.openalliance.ad.utils;

import android.os.Looper;
import com.huawei.hms.ads.fh;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class i {
    private static Map<a, ExecutorService> B = null;
    private static final String Code = "AsyncExec";
    private static final int I = 5;
    private static final int V = 3;
    private static final int Z = 60;

    /* JADX INFO: compiled from: SearchBox */
    @com.huawei.openalliance.ad.annotations.b
    public enum a {
        IO,
        NETWORK,
        CALCULATION,
        SEQUENCE,
        SYNC_CALL,
        SPLASH_NET,
        COLLECT_SEQUENCE
    }

    static {
        Code();
    }

    public static void B(Runnable runnable) {
        Code(runnable, a.COLLECT_SEQUENCE, false);
    }

    public static <V> Future<V> Code(Callable<V> callable, a aVar) {
        return B.get(aVar).submit(callable);
    }

    public static void I(Runnable runnable) {
        Code(runnable, a.CALCULATION, false);
    }

    public static void V(Runnable runnable) {
        Code(runnable, a.NETWORK, false);
    }

    public static void Z(Runnable runnable) {
        Code(runnable, a.SEQUENCE, false);
    }

    private static synchronized void Code() {
        if (B == null) {
            HashMap map = new HashMap();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new j("IO"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new j("Net"));
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new j("Cal"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new j("Seq"));
            ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new j("SyncCall", 10));
            ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(0, 3, 60L, timeUnit, new LinkedBlockingQueue(), new j("SplashNet", 10));
            ThreadPoolExecutor threadPoolExecutor7 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new j("ClctSeq"));
            map.put(a.IO, threadPoolExecutor);
            map.put(a.NETWORK, threadPoolExecutor2);
            map.put(a.CALCULATION, threadPoolExecutor3);
            map.put(a.SEQUENCE, threadPoolExecutor4);
            map.put(a.SYNC_CALL, threadPoolExecutor5);
            map.put(a.SPLASH_NET, threadPoolExecutor6);
            map.put(a.COLLECT_SEQUENCE, threadPoolExecutor7);
            B = map;
        }
    }

    private static boolean V() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && Thread.currentThread() == mainLooper.getThread();
    }

    public static void Code(Runnable runnable) {
        Code(runnable, a.IO, false);
    }

    public static void Code(Runnable runnable, a aVar, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !V()) {
            new bh(runnable).run();
            return;
        }
        ExecutorService executorService = B.get(aVar);
        if (executorService != null) {
            executorService.execute(new bh(runnable));
        } else {
            fh.I(Code, "no executor for type: %s", aVar);
        }
    }
}
