package defpackage;

import defpackage.x25;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class pd5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f19996a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x25 f19997a;

        /* JADX INFO: renamed from: pd5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1261a implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ce5 f19998a;
            public final /* synthetic */ x25.a b;

            /* JADX INFO: renamed from: pd5$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1262a extends ce5<T> {
                public C1262a() {
                }

                @Override // defpackage.ce5
                public void b(Throwable th) {
                    try {
                        C1261a.this.f19998a.b(th);
                    } finally {
                        C1261a.this.b.unsubscribe();
                    }
                }

                @Override // defpackage.ce5
                public void c(T t) {
                    try {
                        C1261a.this.f19998a.c(t);
                    } finally {
                        C1261a.this.b.unsubscribe();
                    }
                }
            }

            public C1261a(ce5 ce5Var, x25.a aVar) {
                this.f19998a = ce5Var;
                this.b = aVar;
            }

            @Override // defpackage.b5
            public void call() {
                C1262a c1262a = new C1262a();
                this.f19998a.a(c1262a);
                pd5.this.c(c1262a);
            }
        }

        public a(x25 x25Var) {
            this.f19997a = x25Var;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(ce5<? super T> ce5Var) {
            x25.a aVarA = this.f19997a.a();
            ce5Var.a(aVarA);
            aVarA.a(new C1261a(ce5Var, aVarA));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T> extends c5<ce5<? super T>> {
    }

    public pd5(b<T> bVar) {
        this.f19996a = kz4.f(bVar);
    }

    public static <T> pd5<T> a(b<T> bVar) {
        return new pd5<>(bVar);
    }

    public final pd5<T> b(x25 x25Var) {
        if (this instanceof k25) {
            return ((k25) this).e(x25Var);
        }
        if (x25Var != null) {
            return a(new vd5(this.f19996a, x25Var));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final zm5 c(ce5<? super T> ce5Var) {
        if (ce5Var == null) {
            throw new IllegalArgumentException("te is null");
        }
        try {
            kz4.p(this, this.f19996a).call(ce5Var);
            return kz4.o(ce5Var);
        } catch (Throwable th) {
            yn1.d(th);
            try {
                ce5Var.b(kz4.n(th));
                return cn5.b();
            } catch (Throwable th2) {
                yn1.d(th2);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                kz4.n(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final pd5<T> d(x25 x25Var) {
        return this instanceof k25 ? ((k25) this).e(x25Var) : a(new a(x25Var));
    }
}
