package defpackage;

import defpackage.n54;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class p74<T, R> implements n54.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n54<T> f19955a;
    public final s42<? super T, ? extends R> b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T, R> extends sm5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sm5<? super R> f19956a;
        public final s42<? super T, ? extends R> b;
        public boolean c;

        public a(sm5<? super R> sm5Var, s42<? super T, ? extends R> s42Var) {
            this.f19956a = sm5Var;
            this.b = s42Var;
        }

        @Override // defpackage.o54
        public void onCompleted() {
            if (this.c) {
                return;
            }
            this.f19956a.onCompleted();
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            if (this.c) {
                kz4.g(th);
            } else {
                this.c = true;
                this.f19956a.onError(th);
            }
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            try {
                this.f19956a.onNext(this.b.call(t));
            } catch (Throwable th) {
                yn1.d(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // defpackage.sm5
        public void setProducer(kn4 kn4Var) {
            this.f19956a.setProducer(kn4Var);
        }
    }

    public p74(n54<T> n54Var, s42<? super T, ? extends R> s42Var) {
        this.f19955a = n54Var;
        this.b = s42Var;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super R> sm5Var) {
        a aVar = new a(sm5Var, this.b);
        sm5Var.add(aVar);
        this.f19955a.x(aVar);
    }
}
