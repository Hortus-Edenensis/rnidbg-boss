package rx.internal.operators;

import defpackage.n54;
import defpackage.sm5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public enum NeverObservableHolder implements n54.a<Object> {
    INSTANCE;

    static final n54<Object> NEVER = n54.a(INSTANCE);

    public static <T> n54<T> instance() {
        return (n54<T>) NEVER;
    }

    @Override // defpackage.c5
    public void call(sm5<? super Object> sm5Var) {
    }
}
