package defpackage;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class de5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17033a;
    public final int b;
    public ThreadPoolExecutor c;
    public long d;
    public final ThreadFactory e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "MAIN_WORK");
            de5.this.d = thread.getId();
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static de5 f17035a = new de5();
    }

    public static de5 b() {
        return b.f17035a;
    }

    public ThreadPoolExecutor c() {
        return this.c;
    }

    public de5() {
        this.f17033a = 1;
        this.b = 60;
        a aVar = new a();
        this.e = aVar;
        this.c = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar, new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
