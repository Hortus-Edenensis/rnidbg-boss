package rx.internal.producers;

import defpackage.kn4;
import defpackage.sm5;
import defpackage.yn1;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class SingleProducer<T> extends AtomicBoolean implements kn4 {
    private static final long serialVersionUID = -3353584923995471404L;
    final sm5<? super T> child;
    final T value;

    public SingleProducer(sm5<? super T> sm5Var, T t) {
        this.child = sm5Var;
        this.value = t;
    }

    @Override // defpackage.kn4
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0 && compareAndSet(false, true)) {
            sm5<? super T> sm5Var = this.child;
            if (sm5Var.isUnsubscribed()) {
                return;
            }
            T t = this.value;
            try {
                sm5Var.onNext(t);
                if (sm5Var.isUnsubscribed()) {
                    return;
                }
                sm5Var.onCompleted();
            } catch (Throwable th) {
                yn1.f(th, sm5Var, t);
            }
        }
    }
}
