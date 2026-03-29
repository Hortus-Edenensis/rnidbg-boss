package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21739a;
    public final ThreadPoolExecutor b;
    public final Handler c;
    public Object f;
    public final AtomicBoolean d = new AtomicBoolean(true);
    public volatile long e = 0;
    public CountDownLatch g = new CountDownLatch(1);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ThreadPoolExecutor {
        public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, (BlockingQueue<Runnable>) blockingQueue, threadFactory);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // java.util.concurrent.ThreadPoolExecutor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterExecute(Runnable runnable, Throwable th) {
            boolean z;
            if (getActiveCount() <= 1 && getQueue().isEmpty()) {
                z = wk5.this.c.hasMessages(233) ? false : true;
                if (z) {
                    return;
                }
                try {
                    wk5.this.d.set(true);
                    wk5.this.g.countDown();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (z) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f21741a;

        public c(ExecutorService executorService) {
            super(wk5.f());
            this.f21741a = executorService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f21741a.isShutdown()) {
                    k63.l("Step", "executor is shutdown");
                } else {
                    this.f21741a.submit((Callable) message.obj);
                }
            } catch (Throwable th) {
                k63.c("Step", "handleMessage e:" + th);
            }
        }
    }

    public wk5(int i, int i2, ly<Object> lyVar, String str) {
        this.f21739a = i2;
        a aVar = new a(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new cx2(str));
        this.b = aVar;
        this.c = new c(aVar);
    }

    public static Looper f() {
        b bVar = new b("jg_step_thread");
        bVar.start();
        Looper looper = bVar.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public void e() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.b;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().clear();
                this.c.removeMessages(233);
            }
        } catch (Throwable th) {
            Log.w("Step", "clean executor e:" + th);
        }
    }

    public void g(Object obj) {
        if (i() || obj == null) {
            return;
        }
        this.f = obj;
        this.g.countDown();
        j(true);
        k63.a("Step", "done!");
    }

    public final synchronized long h(long j) {
        long j2 = this.e + j;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (j2 < jUptimeMillis) {
            this.e = jUptimeMillis;
            return -1L;
        }
        this.e = j2;
        return j2;
    }

    public boolean i() {
        return this.f != null;
    }

    public void j(boolean z) {
        this.c.removeMessages(233);
        if (!this.b.isShutdown()) {
            if (z) {
                this.b.shutdownNow();
            } else {
                this.b.shutdown();
            }
        }
        try {
            this.c.getLooper().quit();
        } catch (Throwable unused) {
        }
        k63.a("Step", "StepParallelScheduler stop !");
    }

    public void k(Callable<?> callable) {
        try {
            long jH = h(this.f21739a);
            if (jH < 0) {
                this.b.submit(callable);
            } else {
                Message messageObtain = Message.obtain();
                messageObtain.what = 233;
                messageObtain.obj = callable;
                this.c.sendMessageAtTime(messageObtain, jH);
            }
            this.d.set(false);
        } catch (Throwable unused) {
        }
    }

    public synchronized Object l(long j) {
        if (i()) {
            return this.f;
        }
        if (this.d.get()) {
            return null;
        }
        try {
            if (j != -1) {
                this.g.await(j, TimeUnit.MILLISECONDS);
            } else {
                this.g.await();
            }
        } catch (InterruptedException unused) {
        }
        if (this.g.getCount() == 0) {
            this.g = new CountDownLatch(1);
        }
        return this.f;
    }
}
