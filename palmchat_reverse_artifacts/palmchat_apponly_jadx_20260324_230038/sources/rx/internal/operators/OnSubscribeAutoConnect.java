package rx.internal.operators;

import defpackage.c5;
import defpackage.im0;
import defpackage.n54;
import defpackage.sm5;
import defpackage.ym5;
import defpackage.zm5;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements n54.a<T> {
    final c5<? super zm5> connection;
    final int numberOfSubscribers;
    final im0<? extends T> source;

    public OnSubscribeAutoConnect(im0<? extends T> im0Var, int i, c5<? super zm5> c5Var) {
        if (i <= 0) {
            throw new IllegalArgumentException("numberOfSubscribers > 0 required");
        }
        this.source = im0Var;
        this.numberOfSubscribers = i;
        this.connection = c5Var;
    }

    @Override // defpackage.c5
    public void call(sm5<? super T> sm5Var) {
        this.source.x(ym5.a(sm5Var));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.y(this.connection);
        }
    }
}
