package com.bytedance.sdk.component.jk.b;

import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.jk.u.iz;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends ThreadPoolExecutor implements com.bytedance.sdk.component.jk.nr {
    public static final RejectedExecutionHandler u = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.jk.b.u.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                t tVar = t.nr;
                ScheduledExecutorService scheduledExecutorServiceL = tVar.l();
                if (scheduledExecutorServiceL.isShutdown() || scheduledExecutorServiceL.isTerminated()) {
                    tVar.a().execute(runnable);
                } else {
                    scheduledExecutorServiceL.execute(runnable);
                }
            } else {
                t.nr.a().execute(runnable);
            }
            t.nr.x();
        }
    };
    private com.bytedance.sdk.component.jk.nr nr;

    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, u);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void allowCoreThreadTimeOut(boolean z) {
        this.nr.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public boolean allowsCoreThreadTimeOut() {
        return this.nr.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.nr.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.jk.nr
    public void execute(Runnable runnable) {
        this.nr.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public int getActiveCount() {
        return this.nr.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public long getCompletedTaskCount() {
        return this.nr.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public int getCorePoolSize() {
        return this.nr.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.nr.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public int getLargestPoolSize() {
        return this.nr.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public int getMaximumPoolSize() {
        return this.nr.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public int getPoolSize() {
        return this.nr.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public BlockingQueue<Runnable> getQueue() {
        return this.nr.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.nr.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public long getTaskCount() {
        return this.nr.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public ThreadFactory getThreadFactory() {
        return this.nr.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public boolean isShutdown() {
        return this.nr.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public boolean isTerminated() {
        return this.nr.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public boolean isTerminating() {
        return this.nr.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public int prestartAllCoreThreads() {
        return this.nr.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public boolean prestartCoreThread() {
        return this.nr.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void purge() {
        this.nr.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public boolean remove(Runnable runnable) {
        return this.nr.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void setCorePoolSize(int i) {
        this.nr.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.nr.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void setMaximumPoolSize(int i) {
        this.nr.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.nr.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.nr.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public void shutdown() {
        com.bytedance.sdk.component.jk.nr nrVar = this.nr;
        if (nrVar != null) {
            nrVar.shutdown();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public List<Runnable> shutdownNow() {
        return this.nr.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public Future<?> submit(Runnable runnable) {
        return this.nr.submit(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public String toString() {
        com.bytedance.sdk.component.jk.nr nrVar = this.nr;
        return nrVar != null ? nrVar.toString() : super.toString();
    }

    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.nr = new iz(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        t.nr.x();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public <T> Future<T> submit(Callable<T> callable) {
        return this.nr.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.nr.submit(runnable, t);
    }
}
