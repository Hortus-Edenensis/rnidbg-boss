package com.beizi.fusion.tool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4733a;
    private static final int b;
    private static final LinkedBlockingQueue<Runnable> c;
    private static final LinkedBlockingQueue<Runnable> d;
    private static final LinkedBlockingQueue<Runnable> e;
    private static final ArrayBlockingQueue<Runnable> f;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f4733a = iAvailableProcessors;
        b = Math.max((iAvailableProcessors / 2) + 1, 4);
        c = new LinkedBlockingQueue<>();
        d = new LinkedBlockingQueue<>();
        e = new LinkedBlockingQueue<>();
        f = new ArrayBlockingQueue<>(200);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, c, new h(5, "afAd-"), e());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, d, new h(5, "afHb-"), e());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(2, 20, 20L, TimeUnit.SECONDS, f, new h(5, "afFu-"), e());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, b, 20L, TimeUnit.SECONDS, e, new h(5, "afIt-"), e());
    }

    public static RejectedExecutionHandler e() {
        return new RejectedExecutionHandler() { // from class: com.beizi.fusion.tool.i.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
