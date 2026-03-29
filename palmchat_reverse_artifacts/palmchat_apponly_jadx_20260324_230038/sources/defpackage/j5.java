package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18327a = new b();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> implements c5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b5 f18328a;

        public a(b5 b5Var) {
            this.f18328a = b5Var;
        }

        @Override // defpackage.c5
        public void call(T t) {
            this.f18328a.call();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements b5, c5<T0>, d5<T0, T1> {
        @Override // defpackage.b5
        public void call() {
        }

        @Override // defpackage.c5
        public void call(T0 t0) {
        }

        @Override // defpackage.d5
        public void a(T0 t0, T1 t1) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> b<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return f18327a;
    }

    public static <T> c5<T> b(b5 b5Var) {
        return new a(b5Var);
    }
}
