package com.bytedance.sdk.component.jk.b;

import com.bytedance.sdk.component.jk.t;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.jk.u.u(blockingQueue), new com.bytedance.sdk.component.jk.u.b(threadFactory, 2));
        u();
    }

    private ExecutorService nr() {
        com.bytedance.sdk.component.jk.b bVar = com.bytedance.sdk.component.jk.b.u;
        return bVar.u("PThreadPoolExecutor", bVar.u(getQueue()));
    }

    private void u() {
        if (t.nr.pn()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(u(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.jk.b.u.u(this);
        }
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.jk.nr
    public void execute(Runnable runnable) {
        if (!t.nr.pn()) {
            super.execute(runnable);
            return;
        }
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            ExecutorService executorServiceNr = nr();
            if (executorServiceNr == null) {
                throw e;
            }
            executorServiceNr.execute(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.jk.b.u.nr(this);
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.jk.u.b(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.jk.b.u.nr(this);
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public List shutdownNow() {
        com.bytedance.sdk.component.jk.b.u.nr(this);
        return super.shutdownNow();
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public <T> Future<T> submit(Callable<T> callable) {
        if (!t.nr.pn()) {
            return super.submit(callable);
        }
        try {
            return super.submit(callable);
        } catch (OutOfMemoryError e) {
            ExecutorService executorServiceNr = nr();
            if (executorServiceNr != null) {
                return executorServiceNr.submit(callable);
            }
            throw e;
        }
    }

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.jk.u.u(blockingQueue), new com.bytedance.sdk.component.jk.u.b(threadFactory, 2), rejectedExecutionHandler);
        u();
    }

    private long u(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (t.nr.pn()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceNr = nr();
                if (executorServiceNr != null) {
                    return executorServiceNr.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.jk.nr
    public Future submit(Runnable runnable) {
        if (t.nr.pn()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceNr = nr();
                if (executorServiceNr != null) {
                    return executorServiceNr.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.bytedance.sdk.component.jk.b.u, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.jk.nr
    public void allowCoreThreadTimeOut(boolean z) {
    }
}
