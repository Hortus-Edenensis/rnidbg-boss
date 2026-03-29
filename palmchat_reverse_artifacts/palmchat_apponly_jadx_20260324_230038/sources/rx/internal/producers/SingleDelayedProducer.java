package rx.internal.producers;

import defpackage.kn4;
import defpackage.sm5;
import defpackage.yn1;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements kn4 {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final sm5<? super T> child;
    T value;

    public SingleDelayedProducer(sm5<? super T> sm5Var) {
        this.child = sm5Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void emit(sm5<? super T> sm5Var, T t) {
        if (sm5Var.isUnsubscribed()) {
            return;
        }
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

    @Override // defpackage.kn4
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j == 0) {
            return;
        }
        do {
            int i = get();
            if (i != 0) {
                if (i == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(T t) {
        do {
            int i = get();
            if (i != 0) {
                if (i == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t);
                    return;
                }
                return;
            }
            this.value = t;
        } while (!compareAndSet(0, 1));
    }
}
