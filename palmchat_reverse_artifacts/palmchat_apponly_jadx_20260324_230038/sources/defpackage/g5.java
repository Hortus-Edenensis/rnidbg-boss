package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class g5<T> implements o54<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c5<? super T> f17648a;
    public final c5<? super Throwable> b;
    public final b5 c;

    public g5(c5<? super T> c5Var, c5<? super Throwable> c5Var2, b5 b5Var) {
        this.f17648a = c5Var;
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
        this.f17648a.call(t);
    }
}
