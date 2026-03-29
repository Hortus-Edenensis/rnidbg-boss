package defpackage;

import com.google.common.collect.ImmutableList;
import defpackage.rr2;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class z42 extends if2 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<V> f22343a;
        public final x42<? super V> b;

        public a(Future<V> future, x42<? super V> x42Var) {
            this.f22343a = future;
            this.b = x42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.f22343a;
            if ((future instanceof yt2) && (thA = zt2.a((yt2) future)) != null) {
                this.b.onFailure(thA);
                return;
            }
            try {
                this.b.onSuccess(z42.c(this.f22343a));
            } catch (ExecutionException e) {
                this.b.onFailure(e.getCause());
            } catch (Throwable th) {
                this.b.onFailure(th);
            }
        }

        public String toString() {
            return fr3.b(this).j(this.b).toString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f22344a;
        public final ImmutableList<r33<? extends V>> b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f22345a;
            public final /* synthetic */ b b;

            public a(b bVar, Runnable runnable) {
                this.f22345a = runnable;
                this.b = bVar;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                this.f22345a.run();
                return null;
            }
        }

        public /* synthetic */ b(boolean z, ImmutableList immutableList, y42 y42Var) {
            this(z, immutableList);
        }

        public <C> r33<C> a(Callable<C> callable, Executor executor) {
            return new ci0(this.b, this.f22344a, executor, callable);
        }

        public r33<?> b(Runnable runnable, Executor executor) {
            return a(new a(this, runnable), executor);
        }

        public b(boolean z, ImmutableList<r33<? extends V>> immutableList) {
            this.f22344a = z;
            this.b = immutableList;
        }
    }

    public static <V> void a(r33<V> r33Var, x42<? super V> x42Var, Executor executor) {
        dm4.o(x42Var);
        r33Var.addListener(new a(r33Var, x42Var), executor);
    }

    public static <V, X extends Exception> V b(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        return (V) d52.f(future, cls, j, timeUnit);
    }

    public static <V> V c(Future<V> future) throws ExecutionException {
        dm4.w(future.isDone(), "Future was expected to be done: %s", future);
        return (V) l46.a(future);
    }

    public static <V> r33<V> d() {
        rr2.a<Object> aVar = rr2.a.h;
        return aVar != null ? aVar : new rr2.a();
    }

    public static <V> r33<V> e(Throwable th) {
        dm4.o(th);
        return new rr2.b(th);
    }

    public static r33<Void> f() {
        return rr2.b;
    }

    public static <V> b<V> g(Iterable<? extends r33<? extends V>> iterable) {
        return new b<>(false, ImmutableList.copyOf(iterable), null);
    }

    @SafeVarargs
    public static <V> b<V> h(r33<? extends V>... r33VarArr) {
        return new b<>(false, ImmutableList.copyOf(r33VarArr), null);
    }
}
