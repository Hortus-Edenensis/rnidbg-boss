package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class p54<T> extends sm5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o54<? super T> f19943a;

    public p54(o54<? super T> o54Var) {
        this.f19943a = o54Var;
    }

    @Override // defpackage.o54
    public void onCompleted() {
        this.f19943a.onCompleted();
    }

    @Override // defpackage.o54
    public void onError(Throwable th) {
        this.f19943a.onError(th);
    }

    @Override // defpackage.o54
    public void onNext(T t) {
        this.f19943a.onNext(t);
    }
}
