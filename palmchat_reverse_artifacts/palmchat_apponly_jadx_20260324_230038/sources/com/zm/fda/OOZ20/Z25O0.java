package com.zm.fda.OOZ20;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.zm.fda.O52OZ.O2O5Z;
import com.zm.fda.OOZ20.Z25O0;
import com.zm.fda.utils.EventLog;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {

    /* JADX INFO: compiled from: SearchBox */
    public static class O022Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ExecutorService f16642a = new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(200), new RejectedExecutionHandler() { // from class: zp6
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Z25O0.O022Z.a(runnable, threadPoolExecutor);
            }
        });

        public static /* synthetic */ void a(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            EventLog.d("fob_fda", "rejectedExecution");
            try {
                threadPoolExecutor.getQueue().put(runnable);
            } catch (Throwable th) {
                EventLog.e("fob_fda", "rejectedExecution error:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Z0225 implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<Runnable> f16643a;
        public Runnable b;

        /* JADX INFO: compiled from: SearchBox */
        public class OO22Z implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f16644a;

            public OO22Z(Runnable runnable) {
                this.f16644a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f16644a.run();
                } finally {
                    Z0225.this.a();
                }
            }
        }

        public Z0225() {
            this.f16643a = new LinkedList();
        }

        public synchronized void a() {
            Runnable runnablePoll = this.f16643a.poll();
            this.b = runnablePoll;
            if (runnablePoll != null) {
                Z25O0.c().execute(this.b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f16643a.offer(new OO22Z(runnable));
            if (this.b == null) {
                a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Z200O {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ExecutorService f16645a = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Z2500 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HandlerThread f16646a;
        public static Handler b;

        static {
            HandlerThread handlerThread = new HandlerThread("globle_timer");
            f16646a = handlerThread;
            handlerThread.start();
            b = new Handler(f16646a.getLooper());
        }
    }

    /* JADX INFO: renamed from: com.zm.fda.OOZ20.Z25O0$Z25O0, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1164Z25O0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScheduledExecutorService f16647a = Executors.newSingleThreadScheduledExecutor();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HandlerThread f16648a;
        public static Handler b;

        static {
            HandlerThread handlerThread = new HandlerThread("event-thread");
            f16648a = handlerThread;
            handlerThread.start();
            b = new Handler(f16648a.getLooper());
        }
    }

    public static void b(Runnable runnable, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        try {
            e().execute(runnable);
        } catch (Throwable th) {
            if (oo22z != null) {
                oo22z.a(0, "execute task error", th.getMessage());
            }
        }
    }

    public static ExecutorService c() {
        return O022Z.f16642a;
    }

    public static ScheduledExecutorService d() {
        return C1164Z25O0.f16647a;
    }

    public static ExecutorService e() {
        return Z200O.f16645a;
    }

    public static Handler f() {
        return Z2500.b;
    }

    public static Executor g() {
        return new Z0225();
    }

    public static boolean h() {
        int i;
        if (!O2O5Z.d() || (i = Build.VERSION.SDK_INT) < 24 || i > 28) {
            return true;
        }
        try {
            return Thread.getAllStackTraces().size() <= 480;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void a(Runnable runnable, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        if (EventLog.isDebugEnable()) {
            EventLog.d("fob_fda", "ActiveCount:" + ((ThreadPoolExecutor) O022Z.f16642a).getActiveCount());
            EventLog.d("fob_fda", "TaskCount:" + ((ThreadPoolExecutor) O022Z.f16642a).getTaskCount());
            EventLog.d("fob_fda", "PoolSize:" + ((ThreadPoolExecutor) O022Z.f16642a).getPoolSize());
            EventLog.d("fob_fda", "CompletedTaskCount:" + ((ThreadPoolExecutor) O022Z.f16642a).getCompletedTaskCount());
        }
        if (!h()) {
            if (oo22z != null) {
                oo22z.a(0, "huawei phone: app's thread num is over 480", "");
            }
            EventLog.d("fob_fda", "huawei phone: app's thread num is over 480, end the task");
            return;
        }
        try {
            c().execute(runnable);
        } catch (Throwable th) {
            if (oo22z != null) {
                oo22z.a(0, "execute task error", th.getMessage());
            }
            if (EventLog.isDebugEnable()) {
                EventLog.d("fob_fda", "execute task error:" + th.getMessage());
            }
        }
    }

    public static void c(Runnable runnable, long j) {
        f().removeCallbacks(runnable);
        f().postDelayed(runnable, j);
    }

    public static final Future<?> d(Runnable runnable) {
        return c().submit(runnable);
    }

    public static Future<?> e(Runnable runnable) {
        return e().submit(runnable);
    }

    public static ScheduledFuture<?> b(Runnable runnable, long j, long j2) {
        return d().scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> d(Runnable runnable, long j) {
        return d().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public static void b(Runnable runnable) {
        e().execute(runnable);
    }

    public static void c(Runnable runnable) {
        b().post(runnable);
    }

    public static <T> Future<T> b(Runnable runnable, T t) {
        return e().submit(runnable, t);
    }

    public static <T> Future<T> b(Callable<T> callable) {
        return e().submit(callable);
    }

    public static void b(Runnable runnable, long j) {
        f().postDelayed(runnable, j);
    }

    public static Handler b() {
        return ZZ00Z.b;
    }

    public static <T> Future<T> a(Runnable runnable, T t) {
        return c().submit(runnable, t);
    }

    public static final <T> Future<T> a(Callable<T> callable) {
        return c().submit(callable);
    }

    public static final <T> ScheduledFuture<T> a(Callable<T> callable, long j) {
        return d().schedule(callable, j, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> a(Runnable runnable, long j, long j2) {
        return d().scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static void a(Runnable runnable) {
        b(runnable);
    }

    public static void a(Runnable runnable, long j) {
        f().postAtTime(runnable, j);
    }
}
