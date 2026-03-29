package defpackage;

import rx.internal.producers.SingleProducer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class rd5<T> extends ce5<T> {
    public final sm5<? super T> b;

    public rd5(sm5<? super T> sm5Var) {
        this.b = sm5Var;
    }

    @Override // defpackage.ce5
    public void b(Throwable th) {
        this.b.onError(th);
    }

    @Override // defpackage.ce5
    public void c(T t) {
        this.b.setProducer(new SingleProducer(this.b, t));
    }
}
