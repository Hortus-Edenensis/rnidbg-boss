package defpackage;

import defpackage.pd5;
import defpackage.x25;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class vd5<T> implements pd5.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd5.b<T> f21411a;
    public final x25 b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> extends ce5<T> implements b5 {
        public final ce5<? super T> b;
        public final x25.a c;
        public T d;
        public Throwable e;

        public a(ce5<? super T> ce5Var, x25.a aVar) {
            this.b = ce5Var;
            this.c = aVar;
        }

        @Override // defpackage.ce5
        public void b(Throwable th) {
            this.e = th;
            this.c.a(this);
        }

        @Override // defpackage.ce5
        public void c(T t) {
            this.d = t;
            this.c.a(this);
        }

        @Override // defpackage.b5
        public void call() {
            try {
                Throwable th = this.e;
                if (th != null) {
                    this.e = null;
                    this.b.b(th);
                } else {
                    T t = this.d;
                    this.d = null;
                    this.b.c(t);
                }
            } finally {
                this.c.unsubscribe();
            }
        }
    }

    public vd5(pd5.b<T> bVar, x25 x25Var) {
        this.f21411a = bVar;
        this.b = x25Var;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(ce5<? super T> ce5Var) {
        x25.a aVarA = this.b.a();
        a aVar = new a(ce5Var, aVarA);
        ce5Var.a(aVarA);
        ce5Var.a(aVar);
        this.f21411a.call(aVar);
    }
}
