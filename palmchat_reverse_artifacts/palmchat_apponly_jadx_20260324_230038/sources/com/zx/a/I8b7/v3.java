package com.zx.a.I8b7;

import java.lang.Thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f16874a;
    public ThreadPoolExecutor b;
    public ThreadPoolExecutor c;
    public ThreadPoolExecutor d;
    public ThreadPoolExecutor e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: com.zx.a.I8b7.v3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1180a implements Thread.UncaughtExceptionHandler {
            public C1180a(a aVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sbA = f3.a("caught an exception from ");
                sbA.append(thread.getName());
                r2.a(sbA.toString(), th);
            }
        }

        public a(v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZX-Api-Thread");
            thread.setUncaughtExceptionHandler(new C1180a(this));
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ThreadFactory {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Thread.UncaughtExceptionHandler {
            public a(b bVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sbA = f3.a("caught an exception from ");
                sbA.append(thread.getName());
                r2.a(sbA.toString(), th);
            }
        }

        public b(v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZX-Api-ThreadV2");
            thread.setUncaughtExceptionHandler(new a(this));
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ThreadFactory {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Thread.UncaughtExceptionHandler {
            public a(c cVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sbA = f3.a("caught an exception from ");
                sbA.append(thread.getName());
                r2.a(sbA.toString(), th);
            }
        }

        public c(v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZX-Api-ThreadV3");
            thread.setUncaughtExceptionHandler(new a(this));
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ThreadFactory {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Thread.UncaughtExceptionHandler {
            public a(d dVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sbA = f3.a("caught an exception from ");
                sbA.append(thread.getName());
                r2.a(sbA.toString(), th);
            }
        }

        public d(v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZX-Api-ThreadV4");
            thread.setUncaughtExceptionHandler(new a(this));
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ThreadFactory {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Thread.UncaughtExceptionHandler {
            public a(e eVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sbA = f3.a("caught an exception from ");
                sbA.append(thread.getName());
                r2.a(sbA.toString(), th);
            }
        }

        public e(v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZX-Api-ThreadV5");
            thread.setUncaughtExceptionHandler(new a(this));
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v3 f16875a = new v3();
    }

    public v3() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f16874a = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new a(this));
        this.b = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new b(this));
        this.c = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new c(this));
        this.d = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new d(this));
        this.e = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new e(this));
    }
}
