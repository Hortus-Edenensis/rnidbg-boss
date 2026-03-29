package com.tide.host.a;

import com.tide.host.a.v0;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class v0 {
    public static final AtomicInteger b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f10803a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: zl7
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return v0.a(runnable);
        }
    });

    static {
        Logger.getLogger(v0.class.getName());
        b = new AtomicInteger(1);
    }

    public static /* synthetic */ Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("TideThreadPool-" + b.getAndIncrement());
        return thread;
    }
}
