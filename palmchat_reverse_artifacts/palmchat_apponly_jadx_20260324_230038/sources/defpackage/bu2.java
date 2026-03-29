package defpackage;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class bu2<T> extends AtomicReference<Runnable> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Runnable f1820a;
    public static final Runnable b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends AbstractOwnableSynchronizer implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu2<?> f1821a;

        public final void b(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        public String toString() {
            return this.f1821a.toString();
        }

        public b(bu2<?> bu2Var) {
            this.f1821a = bu2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        f1820a = new c();
        b = new c();
    }

    public abstract void a(Throwable th);

    public abstract void b(T t);

    public final void o() {
        Runnable runnable = get();
        if (runnable instanceof Thread) {
            b bVar = new b();
            bVar.b(Thread.currentThread());
            if (compareAndSet(runnable, bVar)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(f1820a) == b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    public abstract boolean p();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objS = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z = !p();
            if (z) {
                try {
                    objS = s();
                } catch (Throwable th) {
                    try {
                        dj4.a(th);
                        if (!compareAndSet(threadCurrentThread, f1820a)) {
                            v(threadCurrentThread);
                        }
                        if (z) {
                            a(th);
                            return;
                        }
                        return;
                    } finally {
                        if (!compareAndSet(threadCurrentThread, f1820a)) {
                            v(threadCurrentThread);
                        }
                        if (z) {
                            b(b44.a(null));
                        }
                    }
                }
            }
        }
    }

    public abstract T s() throws Exception;

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f1820a) {
            str = "running=[DONE]";
        } else if (runnable instanceof b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + u();
    }

    public abstract String u();

    public final void v(Thread thread) {
        Runnable runnable = get();
        b bVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = runnable instanceof b;
            if (!z2 && runnable != b) {
                break;
            }
            if (z2) {
                bVar = (b) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(bVar);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
