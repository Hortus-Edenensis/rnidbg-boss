package rx.internal.producers;

import defpackage.kn4;
import defpackage.s46;
import defpackage.sm5;
import defpackage.so;
import defpackage.th5;
import defpackage.uh5;
import defpackage.yn1;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements kn4 {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final sm5<? super T> child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedValueProducer(sm5<? super T> sm5Var) {
        this(sm5Var, s46.b() ? new uh5() : new th5());
    }

    private void drain() {
        Object objPoll;
        if (this.wip.getAndIncrement() == 0) {
            sm5<? super T> sm5Var = this.child;
            Queue<Object> queue = this.queue;
            while (!sm5Var.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (objPoll = queue.poll()) != null) {
                    try {
                        if (objPoll == NULL_SENTINEL) {
                            sm5Var.onNext(null);
                        } else {
                            sm5Var.onNext(objPoll);
                        }
                        if (sm5Var.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (objPoll == NULL_SENTINEL) {
                            objPoll = null;
                        }
                        yn1.f(th, sm5Var, objPoll);
                        return;
                    }
                }
                if (j2 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j2);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t) {
        if (t == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // defpackage.kn4
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j > 0) {
            so.b(this, j);
            drain();
        }
    }

    public QueuedValueProducer(sm5<? super T> sm5Var, Queue<Object> queue) {
        this.child = sm5Var;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
