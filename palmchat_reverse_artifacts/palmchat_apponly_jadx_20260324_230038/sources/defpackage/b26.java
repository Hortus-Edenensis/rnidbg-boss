package defpackage;

import defpackage.j02;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b26<V> extends j02.a<V> implements RunnableFuture<V> {
    public volatile bu2<?> h;

    /* JADX INFO: compiled from: SearchBox */
    public final class a extends bu2<V> {
        public final Callable<V> c;

        public a(Callable<V> callable) {
            this.c = (Callable) dm4.o(callable);
        }

        @Override // defpackage.bu2
        public void a(Throwable th) {
            b26.this.B(th);
        }

        @Override // defpackage.bu2
        public void b(V v) {
            b26.this.A(v);
        }

        @Override // defpackage.bu2
        public final boolean p() {
            return b26.this.isDone();
        }

        @Override // defpackage.bu2
        public V s() throws Exception {
            return this.c.call();
        }

        @Override // defpackage.bu2
        public String u() {
            return this.c.toString();
        }
    }

    public b26(Callable<V> callable) {
        this.h = new a(callable);
    }

    public static <V> b26<V> E(Runnable runnable, V v) {
        return new b26<>(Executors.callable(runnable, v));
    }

    public static <V> b26<V> F(Callable<V> callable) {
        return new b26<>(callable);
    }

    @Override // defpackage.e1
    public void m() {
        bu2<?> bu2Var;
        super.m();
        if (D() && (bu2Var = this.h) != null) {
            bu2Var.o();
        }
        this.h = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        bu2<?> bu2Var = this.h;
        if (bu2Var != null) {
            bu2Var.run();
        }
        this.h = null;
    }

    @Override // defpackage.e1
    public String x() {
        bu2<?> bu2Var = this.h;
        if (bu2Var == null) {
            return super.x();
        }
        return "task=[" + bu2Var + "]";
    }
}
