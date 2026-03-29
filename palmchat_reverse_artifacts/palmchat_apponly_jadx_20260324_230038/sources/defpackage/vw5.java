package defpackage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vw5 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ThreadFactory {
        public static final AtomicInteger d = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f21548a;
        public final AtomicInteger b = new AtomicInteger(1);
        public final String c;

        public a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f21548a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = str + "-" + d.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f21548a, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements ThreadFactory {
        public static final AtomicInteger c = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f21549a = new AtomicInteger(1);
        public final String b;

        public b(String str) {
            System.getSecurityManager();
            this.b = str + "-" + c.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.b + this.f21549a.getAndIncrement());
        }
    }

    public static ExecutorService a(String str) {
        if (!g()) {
            return Executors.newCachedThreadPool();
        }
        return Executors.newCachedThreadPool(new a("LXTP#C_" + str));
    }

    public static ExecutorService b(String str, int i) {
        if (!g()) {
            return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        }
        return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new a("LXTP#C_" + str));
    }

    public static ExecutorService c(int i, String str) {
        if (!g()) {
            return Executors.newFixedThreadPool(i);
        }
        return Executors.newFixedThreadPool(i, new a("LXTP#F_" + str));
    }

    public static ExecutorService d(String str) {
        if (!g()) {
            return Executors.newSingleThreadExecutor();
        }
        return Executors.newSingleThreadExecutor(new a("LXTP#S_" + str));
    }

    public static ScheduledExecutorService e(String str) {
        if (!g()) {
            return Executors.newSingleThreadScheduledExecutor();
        }
        return Executors.newSingleThreadScheduledExecutor(new a("LXTP#SS_" + str));
    }

    public static ThreadPoolExecutor f(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, String str) {
        return new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue, new b("LXTP#" + str));
    }

    public static boolean g() {
        if (vs0.a() != null) {
            return vs0.a().e("threadFactoryCustomSwitch", false);
        }
        return true;
    }
}
