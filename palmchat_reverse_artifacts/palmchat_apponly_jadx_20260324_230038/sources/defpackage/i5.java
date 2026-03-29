package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class i5<T> extends sm5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c5<? super T> f18100a;
    public final c5<Throwable> b;
    public final b5 c;

    public i5(c5<? super T> c5Var, c5<Throwable> c5Var2, b5 b5Var) {
        this.f18100a = c5Var;
        this.b = c5Var2;
        this.c = b5Var;
    }

    @Override // defpackage.o54
    public void onCompleted() {
        this.c.call();
    }

    @Override // defpackage.o54
    public void onError(Throwable th) {
        this.b.call(th);
    }

    @Override // defpackage.o54
    public void onNext(T t) {
        this.f18100a.call(t);
    }
}
