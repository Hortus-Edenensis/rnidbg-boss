package defpackage;

import com.google.common.collect.ImmutableCollection;
import defpackage.o8;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ci0<V> extends o8<Object, V> {
    public ci0<V>.b<?> p;

    /* JADX INFO: compiled from: SearchBox */
    public final class a extends ci0<V>.b<V> {
        public final Callable<V> e;

        public a(Callable<V> callable, Executor executor) {
            super(executor);
            this.e = (Callable) dm4.o(callable);
        }

        @Override // defpackage.bu2
        public V s() throws Exception {
            return this.e.call();
        }

        @Override // defpackage.bu2
        public String u() {
            return this.e.toString();
        }

        @Override // ci0.b
        public void x(V v) {
            ci0.this.A(v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class b<T> extends bu2<T> {
        public final Executor c;

        public b(Executor executor) {
            this.c = (Executor) dm4.o(executor);
        }

        @Override // defpackage.bu2
        public final void a(Throwable th) {
            ci0.this.p = null;
            if (th instanceof ExecutionException) {
                ci0.this.B(((ExecutionException) th).getCause());
            } else if (th instanceof CancellationException) {
                ci0.this.cancel(false);
            } else {
                ci0.this.B(th);
            }
        }

        @Override // defpackage.bu2
        public final void b(T t) {
            ci0.this.p = null;
            x(t);
        }

        @Override // defpackage.bu2
        public final boolean p() {
            return ci0.this.isDone();
        }

        public final void w() {
            try {
                this.c.execute(this);
            } catch (RejectedExecutionException e) {
                ci0.this.B(e);
            }
        }

        public abstract void x(T t);
    }

    public ci0(ImmutableCollection<? extends r33<?>> immutableCollection, boolean z, Executor executor, Callable<V> callable) {
        super(immutableCollection, z, false);
        this.p = new a(callable, executor);
        T();
    }

    @Override // defpackage.o8
    public void R() {
        ci0<V>.b<?> bVar = this.p;
        if (bVar != null) {
            bVar.w();
        }
    }

    @Override // defpackage.o8
    public void Z(o8.a aVar) {
        super.Z(aVar);
        if (aVar == o8.a.OUTPUT_FUTURE_DONE) {
            this.p = null;
        }
    }

    @Override // defpackage.e1
    public void w() {
        ci0<V>.b<?> bVar = this.p;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // defpackage.o8
    public void O(int i, Object obj) {
    }
}
