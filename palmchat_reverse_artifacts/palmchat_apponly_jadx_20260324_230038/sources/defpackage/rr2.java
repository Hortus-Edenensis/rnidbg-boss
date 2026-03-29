package defpackage;

import defpackage.e1;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class rr2<V> implements r33<V> {
    public static final r33<?> b = new rr2(null);
    public static final s13 c = new s13(rr2.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f20556a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<V> extends e1.j<V> {
        public static final a<Object> h;

        static {
            h = e1.d ? null : new a<>();
        }

        public a() {
            cancel(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<V> extends e1.j<V> {
        public b(Throwable th) {
            B(th);
        }
    }

    public rr2(V v) {
        this.f20556a = v;
    }

    @Override // defpackage.r33
    public void addListener(Runnable runnable, Executor executor) {
        dm4.p(runnable, "Runnable was null.");
        dm4.p(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.f20556a;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.f20556a + "]]";
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        dm4.o(timeUnit);
        return get();
    }
}
