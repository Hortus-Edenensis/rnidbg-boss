package defpackage;

import defpackage.n54;
import defpackage.pd5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class fe5<T> implements n54.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd5.b<T> f17519a;

    public fe5(pd5.b<T> bVar) {
        this.f17519a = bVar;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super T> sm5Var) {
        rd5 rd5Var = new rd5(sm5Var);
        sm5Var.add(rd5Var);
        this.f17519a.call(rd5Var);
    }
}
