package defpackage;

import defpackage.n54;
import defpackage.pd5;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class qd5<T> implements pd5.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n54.a<T> f20234a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> extends sm5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ce5<? super T> f20235a;
        public T b;
        public int c;

        public a(ce5<? super T> ce5Var) {
            this.f20235a = ce5Var;
        }

        @Override // defpackage.o54
        public void onCompleted() {
            int i = this.c;
            if (i == 0) {
                this.f20235a.b(new NoSuchElementException());
            } else if (i == 1) {
                this.c = 2;
                T t = this.b;
                this.b = null;
                this.f20235a.c(t);
            }
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            if (this.c == 2) {
                kz4.g(th);
            } else {
                this.b = null;
                this.f20235a.b(th);
            }
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            int i = this.c;
            if (i == 0) {
                this.c = 1;
                this.b = t;
            } else if (i == 1) {
                this.c = 2;
                this.f20235a.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public qd5(n54.a<T> aVar) {
        this.f20234a = aVar;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(ce5<? super T> ce5Var) {
        a aVar = new a(ce5Var);
        ce5Var.a(aVar);
        this.f20234a.call(aVar);
    }
}
