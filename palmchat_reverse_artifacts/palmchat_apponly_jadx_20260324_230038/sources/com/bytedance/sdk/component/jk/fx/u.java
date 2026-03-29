package com.bytedance.sdk.component.jk.fx;

import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.jk.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends ThreadPoolExecutor {
    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.jk.b.u.u);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        u(runnable);
    }

    public int nr() {
        return 0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            e.getMessage();
        } catch (OutOfMemoryError e2) {
            u(null, e2);
        }
    }

    public boolean u() {
        return false;
    }

    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void u(Runnable runnable) {
        try {
            com.bytedance.sdk.component.jk.u.fx fxVar = runnable instanceof com.bytedance.sdk.component.jk.u.fx ? (com.bytedance.sdk.component.jk.u.fx) runnable : new com.bytedance.sdk.component.jk.u.fx(runnable);
            fxVar.nr();
            t tVar = t.nr;
            if (tVar.s()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    fxVar.u(3);
                    tVar.l().submit(fxVar);
                    return;
                }
            }
            fxVar.u(nr());
            super.execute(fxVar);
        } catch (OutOfMemoryError e) {
            if (t.nr.nr()) {
                x.u(false);
            }
            u(runnable, e);
        }
    }

    public void u(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.bytedance.sdk.component.jk.u.fx.nr = true;
    }
}
