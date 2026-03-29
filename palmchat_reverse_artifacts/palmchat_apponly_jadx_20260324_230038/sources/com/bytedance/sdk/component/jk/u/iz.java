package com.bytedance.sdk.component.jk.u;

import androidx.media3.common.C;
import com.bytedance.sdk.component.jk.t;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements com.bytedance.sdk.component.jk.nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f5150a;
    private final Condition b;
    private final ReentrantLock fx;
    private volatile ThreadFactory iz;
    private final ThreadPoolExecutor jk;
    private volatile int l;
    private ThreadPoolExecutor mv;
    private volatile long n;
    private final BlockingQueue<Runnable> nr;
    private int pn;
    private boolean t;
    private final AtomicInteger u = new AtomicInteger(u(-536870912, 0));
    private volatile RejectedExecutionHandler x;

    public iz(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.fx = reentrantLock;
        this.b = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.f5150a = i;
        this.l = i2;
        this.nr = blockingQueue;
        this.n = timeUnit.toNanos(j);
        this.iz = threadFactory;
        this.x = rejectedExecutionHandler;
        this.jk = threadPoolExecutor;
    }

    private boolean b(int i) {
        return this.u.compareAndSet(i, i + 1);
    }

    private static boolean fx(int i) {
        return i < 0;
    }

    private void iz(int i) {
        int i2;
        do {
            i2 = this.u.get();
            if (fx(i2, i)) {
                return;
            }
        } while (!this.u.compareAndSet(i2, u(i, nr(i2))));
    }

    private static int nr(int i) {
        return i & 536870911;
    }

    private boolean pn(int i) {
        return this.u.compareAndSet(i, i - 1);
    }

    private static int u(int i) {
        return i & (-536870912);
    }

    private boolean x(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.bytedance.sdk.component.jk.fx.b.b();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void allowCoreThreadTimeOut(boolean z) {
        this.t = true;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public boolean allowsCoreThreadTimeOut() {
        return this.t;
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.fx;
        reentrantLock.lock();
        while (!fx(this.u.get(), C.ENCODING_PCM_32BIT_BIG_ENDIAN)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.b.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        fx fxVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof fx) {
            fxVar = (fx) runnable;
            fxVar.u(this);
        } else {
            fxVar = new fx(runnable, this);
        }
        u(fxVar);
    }

    public void finalize() {
        shutdown();
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public int getActiveCount() {
        return nr(this.u.get());
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public int getCorePoolSize() {
        return this.f5150a;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.n, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public int getMaximumPoolSize() {
        return this.l;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public int getPoolSize() {
        if (fx(this.u.get(), 1073741824)) {
            return 0;
        }
        return nr(this.u.get());
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public BlockingQueue<Runnable> getQueue() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public ThreadFactory getThreadFactory() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !fx(this.u.get());
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return fx(this.u.get(), C.ENCODING_PCM_32BIT_BIG_ENDIAN);
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public boolean isTerminating() {
        int i = this.u.get();
        return !fx(i) && nr(i, C.ENCODING_PCM_32BIT_BIG_ENDIAN);
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.nr;
        try {
            Iterator<Runnable> it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                if ((next instanceof Future) && ((Future) next).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        nr();
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.nr.remove(runnable);
        nr();
        return zRemove;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.n = timeUnit.toNanos(j);
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.f5150a) {
            throw new IllegalArgumentException();
        }
        this.l = i;
        this.u.get();
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.x = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.iz = threadFactory;
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.fx;
        reentrantLock.lock();
        try {
            iz(0);
            reentrantLock.unlock();
            nr();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.fx;
        reentrantLock.lock();
        try {
            iz(536870912);
            List<Runnable> listB = b();
            reentrantLock.unlock();
            nr();
            return listB;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public String toString() {
        int i = this.u.get();
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + (nr(i, 0) ? "Running" : fx(i, C.ENCODING_PCM_32BIT_BIG_ENDIAN) ? "Terminated" : "Shutting down") + ", runnable name = , core size = " + this.f5150a + ", max size = " + this.l + ", worker count = " + nr(i) + ", queued tasks = " + this.nr.size() + "]";
    }

    private List<Runnable> b() {
        BlockingQueue<Runnable> blockingQueue = this.nr;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof fx) {
                        arrayList.add(((fx) runnable).fx);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean fx(int i, int i2) {
        return i >= i2;
    }

    private static boolean nr(int i, int i2) {
        return i < i2;
    }

    private void pn() {
        ReentrantLock reentrantLock = this.fx;
        reentrantLock.lock();
        try {
            fx();
            nr();
        } finally {
            reentrantLock.unlock();
        }
    }

    private static int u(int i, int i2) {
        return i | i2;
    }

    private void fx() {
        while (!pn(this.u.get())) {
        }
    }

    public final void nr() {
        while (true) {
            int i = this.u.get();
            if (fx(i) || fx(i, 1073741824)) {
                return;
            }
            if ((u(i) == 0 && !this.nr.isEmpty()) || nr(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.fx;
            reentrantLock.lock();
            try {
                if (this.u.compareAndSet(i, u(1073741824, 0))) {
                    this.u.set(u(C.ENCODING_PCM_32BIT_BIG_ENDIAN, 0));
                    this.b.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    public ThreadPoolExecutor u() {
        if (this.mv == null) {
            this.mv = t.nr.jk();
        }
        return this.mv;
    }

    @Override // com.bytedance.sdk.component.jk.nr, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    public final void u(Runnable runnable) {
        this.x.rejectedExecution(runnable, this.jk);
    }

    private void u(fx fxVar) {
        int i = this.u.get();
        if (nr(i) < this.f5150a) {
            if (nr((Runnable) fxVar, true)) {
                t.nr.x();
                return;
            }
            i = this.u.get();
        }
        if (nr(i) == 0) {
            if (nr((Runnable) fxVar, false)) {
                t.nr.x();
                return;
            }
            i = this.u.get();
        }
        if (fx(i) && this.nr.offer(fxVar)) {
            if (!fx(this.u.get()) && remove(fxVar)) {
                u(fxVar.u());
                t.nr.x();
                return;
            } else {
                t.nr.x();
                return;
            }
        }
        if (nr(i) < this.l && nr((Runnable) fxVar, false)) {
            t.nr.x();
        } else {
            u(fxVar.u());
            t.nr.x();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean nr(Runnable runnable, boolean z) {
        loop0: while (true) {
            int i = this.u.get();
            int iU = u(i);
            boolean z2 = false;
            if (iU >= 0 && (iU != 0 || runnable != null || this.nr.isEmpty())) {
                break;
            }
            do {
                int iNr = nr(i);
                if (iNr >= 536870911) {
                    break loop0;
                }
                if (iNr >= (z ? this.f5150a : this.l)) {
                    break loop0;
                }
                if (!b(i)) {
                    i = this.u.get();
                } else {
                    try {
                        ReentrantLock reentrantLock = this.fx;
                        reentrantLock.lock();
                        try {
                            int iU2 = u(this.u.get());
                            if (iU2 < 0 || (iU2 == 0 && runnable == null)) {
                                u().execute(runnable);
                                int iNr2 = nr(this.u.get());
                                if (iNr2 > this.pn) {
                                    this.pn = iNr2;
                                }
                                z2 = true;
                            }
                            if (!z2) {
                            }
                            return z2;
                        } finally {
                            reentrantLock.unlock();
                        }
                    } finally {
                        pn();
                    }
                }
            } while (u(i) == iU);
        }
    }

    @Override // com.bytedance.sdk.component.jk.nr
    public void setCorePoolSize(int i) {
    }

    public void u(Runnable runnable, boolean z) {
        int i = this.u.get();
        int iNr = nr(runnable);
        if (nr(i, 536870912)) {
            do {
                Runnable runnablePoll = this.nr.poll();
                if (runnablePoll != null) {
                    if (x(iNr) && (runnablePoll instanceof fx)) {
                        fx fxVar = (fx) runnablePoll;
                        fxVar.nr();
                        fxVar.u(iNr);
                        fxVar.u((iz) null);
                        runnablePoll.run();
                    } else {
                        u().execute(runnablePoll);
                        return;
                    }
                } else {
                    fx();
                    return;
                }
            } while (nr(i, 536870912));
            nr();
            return;
        }
        nr();
    }

    private int nr(Runnable runnable) {
        if (runnable instanceof fx) {
            return ((fx) runnable).b();
        }
        return 0;
    }
}
