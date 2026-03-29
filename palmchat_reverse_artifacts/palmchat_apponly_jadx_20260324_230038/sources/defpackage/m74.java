package defpackage;

import defpackage.n54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class m74<T> implements n54.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r42<? extends n54<? extends T>> f19153a;

    public m74(r42<? extends n54<? extends T>> r42Var) {
        this.f19153a = r42Var;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super T> sm5Var) {
        try {
            this.f19153a.call().x(ym5.a(sm5Var));
        } catch (Throwable th) {
            yn1.e(th, sm5Var);
        }
    }
}
