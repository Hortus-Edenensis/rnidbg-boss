package com.heytap.mspsdk.executor;

import com.heytap.mspsdk.log.MspLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f6396a;
    private static final TimeUnit b = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> c = new LinkedBlockingQueue(30);
    private final ThreadPoolExecutor d;
    private com.heytap.mspsdk.util.d<Throwable> e;
    private final AtomicLong f = new AtomicLong(0);

    private b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 15, 60L, b, c, b(), c());
        this.d = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static a a() {
        if (f6396a == null) {
            f6396a = new b();
        }
        return f6396a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Thread b(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.heytap.mspsdk.executor.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f6397a.c(runnable);
            }
        }, "MSPSDK-Pool-" + this.f.incrementAndGet());
        thread.setDaemon(false);
        return thread;
    }

    private RejectedExecutionHandler c() {
        return new RejectedExecutionHandler() { // from class: com.heytap.mspsdk.executor.e
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                this.f6399a.a(runnable, threadPoolExecutor);
            }
        };
    }

    private ThreadFactory b() {
        return new ThreadFactory() { // from class: com.heytap.mspsdk.executor.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return this.f6398a.b(runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            com.heytap.mspsdk.util.d<Throwable> dVar = this.e;
            if (dVar == null) {
                throw th;
            }
            dVar.a(th);
        }
    }

    @Override // com.heytap.mspsdk.executor.a
    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.d;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor.isShutdown()) {
            return;
        }
        threadPoolExecutor.getQueue().poll();
        threadPoolExecutor.execute(runnable);
        com.heytap.mspsdk.util.d<Throwable> dVar = this.e;
        if (dVar != null) {
            dVar.a(new IllegalStateException("Task rejected"));
        } else {
            MspLog.v("ThreadExecutor", "Task rejected");
        }
    }
}
