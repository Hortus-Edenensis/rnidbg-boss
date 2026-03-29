package defpackage;

import defpackage.pd5;
import defpackage.x25;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class k25<T> extends pd5<T> {
    public final T b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> implements pd5.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final nn1 f18558a;
        public final T b;

        public a(nn1 nn1Var, T t) {
            this.f18558a = nn1Var;
            this.b = t;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(ce5<? super T> ce5Var) {
            ce5Var.a(this.f18558a.c(new c(ce5Var, this.b)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<T> implements pd5.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x25 f18559a;
        public final T b;

        public b(x25 x25Var, T t) {
            this.f18559a = x25Var;
            this.b = t;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(ce5<? super T> ce5Var) {
            x25.a aVarA = this.f18559a.a();
            ce5Var.a(aVarA);
            aVarA.a(new c(ce5Var, this.b));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<T> implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ce5<? super T> f18560a;
        public final T b;

        public c(ce5<? super T> ce5Var, T t) {
            this.f18560a = ce5Var;
            this.b = t;
        }

        @Override // defpackage.b5
        public void call() {
            try {
                this.f18560a.c(this.b);
            } catch (Throwable th) {
                this.f18560a.b(th);
            }
        }
    }

    public pd5<T> e(x25 x25Var) {
        return x25Var instanceof nn1 ? pd5.a(new a((nn1) x25Var, this.b)) : pd5.a(new b(x25Var, this.b));
    }
}
