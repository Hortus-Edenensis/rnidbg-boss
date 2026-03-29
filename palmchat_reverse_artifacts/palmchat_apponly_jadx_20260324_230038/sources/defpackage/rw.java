package defpackage;

import defpackage.x25;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class rw extends x25 implements z25 {
    public static final long d;
    public static final TimeUnit e = TimeUnit.SECONDS;
    public static final c f;
    public static final a g;
    public final ThreadFactory b;
    public final AtomicReference<a> c = new AtomicReference<>(g);

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f20589a;
        public final long b;
        public final ConcurrentLinkedQueue<c> c;
        public final hk0 d;
        public final ScheduledExecutorService e;
        public final Future<?> f;

        /* JADX INFO: renamed from: rw$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ThreadFactoryC1272a implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f20590a;

            public ThreadFactoryC1272a(ThreadFactory threadFactory) {
                this.f20590a = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = this.f20590a.newThread(runnable);
                threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
                return threadNewThread;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        }

        public a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.f20589a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.b = nanos;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new hk0();
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC1272a(threadFactory));
                xx3.j(scheduledExecutorServiceNewScheduledThreadPool);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.e = scheduledExecutorServiceNewScheduledThreadPool;
            this.f = scheduledFutureScheduleWithFixedDelay;
        }

        public void a() {
            if (this.c.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.c) {
                if (cVar.k() > jC) {
                    return;
                }
                if (this.c.remove(cVar)) {
                    this.d.b(cVar);
                }
            }
        }

        public c b() {
            if (this.d.isUnsubscribed()) {
                return rw.f;
            }
            while (!this.c.isEmpty()) {
                c cVarPoll = this.c.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f20589a);
            this.d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.l(c() + this.b);
            this.c.offer(cVar);
        }

        public void e() {
            try {
                Future<?> future = this.f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.d.unsubscribe();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends x25.a implements b5 {
        public final a b;
        public final c c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hk0 f20592a = new hk0();
        public final AtomicBoolean d = new AtomicBoolean();

        /* JADX INFO: compiled from: SearchBox */
        public class a implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b5 f20593a;

            public a(b5 b5Var) {
                this.f20593a = b5Var;
            }

            @Override // defpackage.b5
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f20593a.call();
            }
        }

        public b(a aVar) {
            this.b = aVar;
            this.c = aVar.b();
        }

        @Override // x25.a
        public zm5 a(b5 b5Var) {
            return b(b5Var, 0L, null);
        }

        @Override // x25.a
        public zm5 b(b5 b5Var, long j, TimeUnit timeUnit) {
            if (this.f20592a.isUnsubscribed()) {
                return cn5.c();
            }
            ScheduledAction scheduledActionG = this.c.g(new a(b5Var), j, timeUnit);
            this.f20592a.a(scheduledActionG);
            scheduledActionG.addParent(this.f20592a);
            return scheduledActionG;
        }

        @Override // defpackage.b5
        public void call() {
            this.b.d(this.c);
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.f20592a.isUnsubscribed();
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            if (this.d.compareAndSet(false, true)) {
                this.c.a(this);
            }
            this.f20592a.unsubscribe();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends xx3 {
        public long i;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.i = 0L;
        }

        public long k() {
            return this.i;
        }

        public void l(long j) {
            this.i = j;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.NONE);
        f = cVar;
        cVar.unsubscribe();
        a aVar = new a(null, 0L, null);
        g = aVar;
        aVar.e();
        d = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public rw(ThreadFactory threadFactory) {
        this.b = threadFactory;
        c();
    }

    @Override // defpackage.x25
    public x25.a a() {
        return new b(this.c.get());
    }

    public void c() {
        a aVar = new a(this.b, d, e);
        if (g23.a(this.c, g, aVar)) {
            return;
        }
        aVar.e();
    }

    @Override // defpackage.z25
    public void shutdown() {
        a aVar;
        a aVar2;
        do {
            aVar = this.c.get();
            aVar2 = g;
            if (aVar == aVar2) {
                return;
            }
        } while (!g23.a(this.c, aVar, aVar2));
        aVar.e();
    }
}
