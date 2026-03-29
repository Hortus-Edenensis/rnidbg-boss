package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class v57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ExecutorService f21362a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ThreadFactory {
        public a(String str) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "RemoteRequestThread");
        }
    }

    public static void a(Runnable runnable) {
        if (f21362a == null) {
            synchronized (v57.class) {
                if (f21362a == null) {
                    f21362a = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a("RemoteRequestThread"));
                }
            }
        }
        f21362a.execute(runnable);
    }
}
