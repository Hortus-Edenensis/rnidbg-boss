package rx.internal.util;

import defpackage.kn4;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class BackpressureDrainManager extends AtomicLong implements kn4 {
    private static final long serialVersionUID = 2826241102729529449L;
    final a actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public BackpressureDrainManager(a aVar) {
    }

    public void drain() {
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            this.emitting = true;
            boolean z = this.terminated;
            try {
                if (get() <= 0 && !z) {
                    synchronized (this) {
                        throw null;
                    }
                }
                if (!z) {
                    throw null;
                }
                throw null;
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // defpackage.kn4
    public void request(long j) {
        boolean z;
        long j2;
        if (j == 0) {
            return;
        }
        while (true) {
            long j3 = get();
            boolean z2 = true;
            z = j3 == 0;
            if (j3 == Long.MAX_VALUE) {
                break;
            }
            if (j == Long.MAX_VALUE) {
                j2 = j;
            } else {
                j2 = j3 <= Long.MAX_VALUE - j ? j3 + j : Long.MAX_VALUE;
                z2 = z;
            }
            if (compareAndSet(j3, j2)) {
                z = z2;
                break;
            }
        }
        if (z) {
            drain();
        }
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminate(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
    }

    public void terminateAndDrain(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
        drain();
    }
}
