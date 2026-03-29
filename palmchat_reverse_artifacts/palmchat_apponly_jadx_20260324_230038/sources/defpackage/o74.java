package defpackage;

import defpackage.n54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class o74<T, R> implements n54.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n54.a<T> f19708a;
    public final n54.b<? extends R, ? super T> b;

    public o74(n54.a<T> aVar, n54.b<? extends R, ? super T> bVar) {
        this.f19708a = aVar;
        this.b = bVar;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super R> sm5Var) {
        try {
            sm5<? super T> sm5VarCall = kz4.j(this.b).call(sm5Var);
            try {
                sm5VarCall.onStart();
                this.f19708a.call(sm5VarCall);
            } catch (Throwable th) {
                yn1.d(th);
                sm5VarCall.onError(th);
            }
        } catch (Throwable th2) {
            yn1.d(th2);
            sm5Var.onError(th2);
        }
    }
}
