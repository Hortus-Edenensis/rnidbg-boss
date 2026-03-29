package rx.internal.operators;

import defpackage.n54;
import defpackage.sm5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public enum EmptyObservableHolder implements n54.a<Object> {
    INSTANCE;

    static final n54<Object> EMPTY = n54.a(INSTANCE);

    public static <T> n54<T> instance() {
        return (n54<T>) EMPTY;
    }

    @Override // defpackage.c5
    public void call(sm5<? super Object> sm5Var) {
        sm5Var.onCompleted();
    }
}
