package com.bytedance.sdk.component.jk.b;

import com.bytedance.sdk.component.jk.t;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends ScheduledThreadPoolExecutor {
    private final ConcurrentHashMap u;

    public pn(int i, ThreadFactory threadFactory) {
        super(i, new com.bytedance.sdk.component.jk.u.b(threadFactory, 8));
        this.u = new ConcurrentHashMap();
        u();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (!t.nr.pn()) {
            return super.decorateTask(runnable, runnableScheduledFuture);
        }
        RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.u.get(runnable);
        if (runnableScheduledFuture2 != null) {
            return runnableScheduledFuture2;
        }
        RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(runnable, runnableScheduledFuture);
        this.u.put(runnable, runnableScheduledFutureDecorateTask);
        return runnableScheduledFutureDecorateTask;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        if (!t.nr.pn()) {
            return super.schedule(runnable, j, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduledFutureSchedule = super.schedule(runnable, j, timeUnit);
            this.u.remove(runnable);
            return scheduledFutureSchedule;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.jk.b.u.u("PThreadScheduledThreadPoolExecutor");
            t tVar = t.nr;
            tVar.l().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    pn.super.schedule(runnable, j, timeUnit);
                    pn.this.u.remove(runnable);
                }
            }, tVar.b(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.u.get(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (!t.nr.pn()) {
            return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
            this.u.remove(runnable);
            return scheduledFutureScheduleAtFixedRate;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.jk.b.u.u("PThreadScheduledThreadPoolExecutor");
            t tVar = t.nr;
            tVar.l().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.pn.2
                @Override // java.lang.Runnable
                public void run() {
                    pn.super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                    pn.this.u.remove(runnable);
                }
            }, tVar.b(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.u.get(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (!t.nr.pn()) {
            return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
            this.u.remove(runnable);
            return scheduledFutureScheduleWithFixedDelay;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.jk.b.u.u("PThreadScheduledThreadPoolExecutor");
            t tVar = t.nr;
            tVar.l().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.pn.3
                @Override // java.lang.Runnable
                public void run() {
                    pn.super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                    pn.this.u.remove(runnable);
                }
            }, tVar.b(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.u.get(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.jk.u.b(threadFactory, 8));
    }

    private void u() {
        if (!t.nr.pn() || allowsCoreThreadTimeOut()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(timeUnit)), timeUnit);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (t.nr.pn()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.u.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.u.put(callable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) {
        if (t.nr.pn()) {
            try {
                ScheduledFuture scheduledFutureSchedule = super.schedule(callable, j, timeUnit);
                this.u.remove(callable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.jk.b.u.u("PThreadScheduledThreadPoolExecutor");
                t tVar = t.nr;
                tVar.l().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.pn.4
                    @Override // java.lang.Runnable
                    public void run() {
                        pn.super.schedule(callable, j, timeUnit);
                        pn.this.u.remove(callable);
                    }
                }, tVar.b(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.u.get(callable);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }
}
