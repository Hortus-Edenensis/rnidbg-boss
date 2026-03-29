package defpackage;

import defpackage.n54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class q74<T> implements n54.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f20195a;

    public q74(Throwable th) {
        this.f20195a = th;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super T> sm5Var) {
        sm5Var.onError(this.f20195a);
    }
}
