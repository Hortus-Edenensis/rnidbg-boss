package cn.fly.verify;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2243a = "M-" + dx.a("002 dhfi");
    public static final String b = "M-" + dx.a("0030ejdafi");
    public static final ThreadPoolExecutor c;
    public static final ThreadPoolExecutor d;
    public static final ExecutorService e;
    public static final ExecutorService f;
    public static final ExecutorService g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                bq.a().d(500L, runnable);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f2244a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        public b(int i) {
            String str;
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (TextUtils.isEmpty("M-")) {
                str = dx.a("005hBcbcb%eOfi") + f2244a.getAndIncrement() + dx.a("008HfiVgf'bh8db1bafi");
            } else {
                str = ek.b + i + "-" + f2244a.getAndIncrement() + "-";
            }
            this.d = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int iMax = Math.max(2, 5);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        c = new ThreadPoolExecutor(2, iMax, 60L, timeUnit, new SynchronousQueue(), new b(0), new a());
        d = new ThreadPoolExecutor(1, 1, 120L, timeUnit, new LinkedBlockingQueue(), new b(1));
        e = Executors.newCachedThreadPool(new b(2));
        f = Executors.newCachedThreadPool(new b(3));
        g = Executors.newCachedThreadPool(new b(4));
    }
}
