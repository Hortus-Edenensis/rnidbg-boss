package a.a.c.a.e.f;

import a.a.c.a.e.c;
import android.annotation.SuppressLint;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1125a = Runtime.getRuntime().availableProcessors();
    public static final c<ExecutorService> b;

    /* JADX INFO: renamed from: a.a.c.a.e.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0014a extends c<ExecutorService> {
        @Override // a.a.c.a.e.c
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        public ExecutorService a(Object[] objArr) {
            return new ThreadPoolExecutor((int) (((double) a.f1125a) * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue());
        }
    }

    static {
        new AtomicBoolean(false);
        b = new C0014a();
    }
}
