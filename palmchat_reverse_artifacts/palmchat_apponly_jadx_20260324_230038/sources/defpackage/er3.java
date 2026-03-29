package defpackage;

import defpackage.e1;
import defpackage.m12;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class er3 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends l1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f17345a;

        public a(ExecutorService executorService) {
            this.f17345a = (ExecutorService) dm4.o(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f17345a.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f17345a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f17345a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f17345a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f17345a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f17345a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f17345a + "]";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends a implements ScheduledExecutorService {
        public final ScheduledExecutorService b;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a<V> extends m12.a<V> implements s33<V> {
            public final ScheduledFuture<?> b;

            public a(r33<V> r33Var, ScheduledFuture<?> scheduledFuture) {
                super(r33Var);
                this.b = scheduledFuture;
            }

            @Override // defpackage.k12, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boolean zCancel = super.cancel(z);
                if (zCancel) {
                    this.b.cancel(z);
                }
                return zCancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.b.getDelay(timeUnit);
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.b.compareTo(delayed);
            }
        }

        /* JADX INFO: renamed from: er3$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class RunnableC1190b extends e1.j<Void> implements Runnable {
            public final Runnable h;

            public RunnableC1190b(Runnable runnable) {
                this.h = (Runnable) dm4.o(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.h.run();
                } catch (Throwable th) {
                    B(th);
                    throw th;
                }
            }

            @Override // defpackage.e1
            public String x() {
                return "task=[" + this.h + "]";
            }
        }

        public b(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.b = (ScheduledExecutorService) dm4.o(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s33<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            b26 b26VarE = b26.E(runnable, null);
            return new a(b26VarE, this.b.schedule(b26VarE, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public <V> s33<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            b26 b26VarF = b26.F(callable);
            return new a(b26VarF, this.b.schedule(b26VarF, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public s33<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            RunnableC1190b runnableC1190b = new RunnableC1190b(runnable);
            return new a(runnableC1190b, this.b.scheduleAtFixedRate(runnableC1190b, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public s33<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            RunnableC1190b runnableC1190b = new RunnableC1190b(runnable);
            return new a(runnableC1190b, this.b.scheduleWithFixedDelay(runnableC1190b, j, j2, timeUnit));
        }
    }

    public static Executor a() {
        return kd1.INSTANCE;
    }

    public static c43 b(ExecutorService executorService) {
        if (executorService instanceof c43) {
            return (c43) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new b((ScheduledExecutorService) executorService) : new a(executorService);
    }
}
