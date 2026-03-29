package defpackage;

import android.os.Process;
import com.wft.wknet.e;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g27 extends ThreadPoolExecutor {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends FutureTask<o47> implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o47 f17641a;

        public a(o47 o47Var) {
            super(o47Var, null);
            this.f17641a = o47Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            e eVarB = this.f17641a.b();
            e eVarB2 = aVar.f17641a.b();
            return eVarB == eVarB2 ? this.f17641a.d - aVar.f17641a.d : eVarB2.ordinal() - eVarB.ordinal();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends Thread {
        public b(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new b(runnable);
        }
    }

    public g27() {
        super(5, 30, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((o47) runnable);
        execute(aVar);
        return aVar;
    }
}
