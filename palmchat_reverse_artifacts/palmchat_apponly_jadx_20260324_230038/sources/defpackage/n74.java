package defpackage;

import defpackage.n54;
import java.util.Arrays;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class n74<T> implements n54.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o54<? super T> f19453a;
    public final n54<T> b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> extends sm5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sm5<? super T> f19454a;
        public final o54<? super T> b;
        public boolean c;

        public a(sm5<? super T> sm5Var, o54<? super T> o54Var) {
            super(sm5Var);
            this.f19454a = sm5Var;
            this.b = o54Var;
        }

        @Override // defpackage.o54
        public void onCompleted() {
            if (this.c) {
                return;
            }
            try {
                this.b.onCompleted();
                this.c = true;
                this.f19454a.onCompleted();
            } catch (Throwable th) {
                yn1.e(th, this);
            }
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            if (this.c) {
                kz4.g(th);
                return;
            }
            this.c = true;
            try {
                this.b.onError(th);
                this.f19454a.onError(th);
            } catch (Throwable th2) {
                yn1.d(th2);
                this.f19454a.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            if (this.c) {
                return;
            }
            try {
                this.b.onNext(t);
                this.f19454a.onNext(t);
            } catch (Throwable th) {
                yn1.f(th, this, t);
            }
        }
    }

    public n74(n54<T> n54Var, o54<? super T> o54Var) {
        this.b = n54Var;
        this.f19453a = o54Var;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super T> sm5Var) {
        this.b.x(new a(sm5Var, this.f19453a));
    }
}
