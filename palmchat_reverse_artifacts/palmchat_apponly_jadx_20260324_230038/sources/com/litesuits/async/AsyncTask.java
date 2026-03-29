package com.litesuits.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import defpackage.oh;
import defpackage.vw5;
import defpackage.z53;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AsyncTask<Params, Progress, Result> {
    public static int f = Runtime.getRuntime().availableProcessors();
    public static final int g;
    public static final BlockingQueue<Runnable> h;
    public static final ThreadPoolExecutor i;
    public static final Executor j;
    public static final e k;
    public static volatile Executor l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<Params, Result> f7542a;
    public final FutureTask<Result> b;
    public volatile Status c = Status.PENDING;
    public final AtomicBoolean d = new AtomicBoolean();
    public final AtomicBoolean e = new AtomicBoolean();

    /* JADX INFO: compiled from: SearchBox */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends g<Params, Result> {
        public a() {
            super();
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            AsyncTask.this.e.set(true);
            Process.setThreadPriority(10);
            AsyncTask asyncTask = AsyncTask.this;
            return (Result) asyncTask.q(asyncTask.g(this.f7548a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends FutureTask<Result> {
        public b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AsyncTask.this.r(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException unused) {
                AsyncTask.this.r(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7544a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Status.values().length];
            b = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[f.b.values().length];
            f7544a = iArr2;
            try {
                iArr2[f.b.LIFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7544a[f.b.FIFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AsyncTask f7545a;
        public final Data[] b;

        public d(AsyncTask asyncTask, Data... dataArr) {
            this.f7545a = asyncTask;
            this.b = dataArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i = message.what;
            if (i == 1) {
                dVar.f7545a.j(dVar.b[0]);
            } else {
                if (i != 2) {
                    return;
                }
                dVar.f7545a.p(dVar.b);
            }
        }

        public e(Looper looper) {
            super(looper);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements Executor {
        public static int d;
        public static int e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public oh<Runnable> f7546a = new oh<>(e);
        public b b = b.LIFO;
        public int c = AsyncTask.f;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f7547a;

            public a(Runnable runnable) {
                this.f7547a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7547a.run();
                f.this.a();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b {
            LIFO,
            FIFO
        }

        public f() {
            b(AsyncTask.f);
        }

        public synchronized void a() {
            int i = c.f7544a[this.b.ordinal()];
            Runnable runnableF = (i == 1 || i != 2) ? this.f7546a.f() : this.f7546a.e();
            if (runnableF != null) {
                AsyncTask.i.execute(runnableF);
            }
        }

        public final void b(int i) {
            this.c = i;
            d = i;
            e = (i + 3) * 16;
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            a aVar = new a(runnable);
            ThreadPoolExecutor threadPoolExecutor = AsyncTask.i;
            if (threadPoolExecutor.getActiveCount() < d) {
                threadPoolExecutor.execute(aVar);
            } else {
                if (this.f7546a.g() >= e) {
                    this.f7546a.e();
                }
                this.f7546a.d(aVar);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class g<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Params[] f7548a;

        public g() {
        }
    }

    static {
        z53.d("AsyncTask", "CPU ： " + f);
        int i2 = f + 1;
        g = i2;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        h = synchronousQueue;
        ThreadPoolExecutor threadPoolExecutorF = vw5.f(i2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, synchronousQueue, "AsyncTask");
        i = threadPoolExecutorF;
        j = new f();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            k = new e(Looper.getMainLooper());
        } else {
            k = new e();
        }
        l = threadPoolExecutorF;
    }

    public AsyncTask() {
        a aVar = new a();
        this.f7542a = aVar;
        this.b = new b(aVar);
    }

    public final boolean f(boolean z) {
        this.d.set(true);
        return this.b.cancel(z);
    }

    public abstract Result g(Params... paramsArr);

    public final AsyncTask<Params, Progress, Result> h(Params... paramsArr) {
        return i(l, paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> i(Executor executor, Params... paramsArr) {
        if (this.c != Status.PENDING) {
            int i2 = c.b[this.c.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.c = Status.RUNNING;
        o();
        this.f7542a.f7548a = paramsArr;
        executor.execute(this.b);
        return this;
    }

    public final void j(Result result) {
        if (k()) {
            m(result);
        } else {
            n(result);
        }
        this.c = Status.FINISHED;
    }

    public final boolean k() {
        return this.d.get();
    }

    public void m(Result result) {
        l();
    }

    public final Result q(Result result) {
        k.obtainMessage(1, new d(this, result)).sendToTarget();
        return result;
    }

    public final void r(Result result) {
        if (this.e.get()) {
            return;
        }
        q(result);
    }

    public void l() {
    }

    public void o() {
    }

    public void n(Result result) {
    }

    public void p(Progress... progressArr) {
    }
}
