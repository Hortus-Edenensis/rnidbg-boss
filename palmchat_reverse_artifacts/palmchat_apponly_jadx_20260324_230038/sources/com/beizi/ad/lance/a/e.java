package com.beizi.ad.lance.a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4466a;
    private static final int b;
    private static final LinkedBlockingQueue<Runnable> c;
    private static final LinkedBlockingQueue<Runnable> d;
    private static final ArrayBlockingQueue<Runnable> e;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f4466a = iAvailableProcessors;
        b = Math.max((iAvailableProcessors / 2) + 1, 4);
        c = new LinkedBlockingQueue<>();
        d = new LinkedBlockingQueue<>();
        e = new ArrayBlockingQueue<>(50);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, c, new d(5, "BeiZi-adsdk-adrequest-thread-"), f());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, c, new d(5, "BeiZi-adsdk-adrequest-thread-"), f());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, d, new d(5, "BeiZi-adsdk-heartbeat-thread-"), f());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, 6, 20L, TimeUnit.SECONDS, e, new d(5, "BeiZi-adsdk-file-log-upload-thread-"), f());
    }

    public static ScheduledThreadPoolExecutor e() {
        return (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(4);
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.beizi.ad.lance.a.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
