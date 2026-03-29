package com.bytedance.sdk.component.jk.fx;

import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.jk.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    private ScheduledFuture<?> u;

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public static boolean b() {
        ThreadPoolExecutor threadPoolExecutorA = t.nr.a();
        if (threadPoolExecutorA.getQueue().size() != 0 || threadPoolExecutorA.isShutdown() || threadPoolExecutorA.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorA.getActiveCount();
        int corePoolSize = threadPoolExecutorA.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.bytedance.sdk.component.jk.u.fx.u.get() < corePoolSize / 2;
    }

    private boolean iz() {
        BlockingQueue<Runnable> queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, x.u);
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    private void pn() {
        BlockingQueue<Runnable> queue = getQueue();
        int iN = t.nr.n();
        if (getCorePoolSize() == iN || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iN);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (x.pn()) {
            pn();
        }
    }

    @Override // com.bytedance.sdk.component.jk.fx.u, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (x.pn()) {
            iz();
        }
        super.execute(runnable);
    }

    public void fx() {
        ScheduledFuture<?> scheduledFuture = this.u;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // com.bytedance.sdk.component.jk.fx.u
    public int nr() {
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
    @Override // com.bytedance.sdk.component.jk.fx.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.u(runnable, outOfMemoryError);
        boolean z = false;
        if (runnable != null) {
            try {
                zOffer = getQueue().offer(runnable);
                try {
                    allowCoreThreadTimeOut(false);
                } catch (Throwable unused) {
                    z = zOffer;
                    zOffer = z;
                }
            } catch (Throwable unused2) {
                zOffer = z;
                if (!zOffer) {
                }
            }
        } else {
            zOffer = true;
            try {
                x.u(false);
                allowCoreThreadTimeOut(false);
            } catch (Throwable unused3) {
                z = true;
                zOffer = z;
                if (!zOffer) {
                }
            }
        }
        if (!zOffer) {
            throw outOfMemoryError;
        }
    }

    @Override // com.bytedance.sdk.component.jk.fx.u
    public boolean u() {
        BlockingQueue<Runnable> queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }
}
