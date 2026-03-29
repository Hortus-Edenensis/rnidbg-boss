package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends ThreadPoolExecutor implements c {
    public static volatile boolean aOF = false;
    private final ConcurrentHashMap<Runnable, Long> aOG;
    private long aOH;
    private int aOI;

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.aOG = new ConcurrentHashMap<>();
        this.aOH = 0L;
        this.aOI = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long LC() {
        return this.aOH;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aOF && this.aOG.containsKey(runnable) && this.aOG.get(runnable) != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.aOG.get(runnable).longValue();
            if (jElapsedRealtime >= 0 && jElapsedRealtime < 1800000) {
                long j = this.aOH;
                int i = this.aOI;
                this.aOH = ((j * ((long) i)) + jElapsedRealtime) / ((long) (i + 1));
                this.aOI = i + 1;
            }
            this.aOG.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aOF) {
            this.aOG.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.aOG = new ConcurrentHashMap<>();
        this.aOH = 0L;
        this.aOI = 0;
    }
}
