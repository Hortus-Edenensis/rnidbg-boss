package com.bytedance.sdk.component.jk.fx;

import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.utils.k;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private AtomicInteger u;

    public nr(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.u = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        Runnable runnablePoll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = t.nr.a().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.u.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.u.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (runnablePoll = queue.poll()) != null) {
                if (runnablePoll instanceof com.bytedance.sdk.component.jk.u.fx) {
                    com.bytedance.sdk.component.jk.u.fx fxVar = (com.bytedance.sdk.component.jk.u.fx) runnablePoll;
                    fxVar.u(nr());
                    fxVar.nr();
                }
                runnablePoll.run();
                activeCount = getActiveCount();
            }
        } finally {
            this.u.getAndDecrement();
        }
    }

    @Override // com.bytedance.sdk.component.jk.fx.u, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof fx) {
            super.execute(runnable);
            return;
        }
        if (u(runnable)) {
            return;
        }
        if (!u()) {
            super.execute(runnable);
            return;
        }
        if (runnable instanceof com.bytedance.sdk.component.jk.u.fx) {
            ((com.bytedance.sdk.component.jk.u.fx) runnable).u(false);
        } else {
            runnable = new fx(runnable);
        }
        t.nr.a().execute(runnable);
    }

    @Override // com.bytedance.sdk.component.jk.fx.u
    public int nr() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.jk.fx.u
    public void u(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.u(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.bytedance.sdk.component.jk.u.fx) {
                ((com.bytedance.sdk.component.jk.u.fx) runnable).u(false);
            } else {
                runnable = new fx(runnable);
            }
            t.nr.a().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            k.u("BigThreadPool", e);
        }
    }

    @Override // com.bytedance.sdk.component.jk.fx.u
    public boolean u() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    private boolean u(Runnable runnable) {
        com.bytedance.sdk.component.jk.u.fx fxVar;
        if (!b.b()) {
            return false;
        }
        if (runnable instanceof com.bytedance.sdk.component.jk.u.fx) {
            fxVar = (com.bytedance.sdk.component.jk.u.fx) runnable;
            if (!fxVar.fx()) {
                return false;
            }
        } else {
            fxVar = new fx(runnable);
        }
        com.bytedance.sdk.component.jk.u.fx.u.incrementAndGet();
        fxVar.u(false);
        t.nr.a().execute(fxVar);
        return true;
    }
}
