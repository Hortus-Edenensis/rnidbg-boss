package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class sm5<T> implements o54<T>, zm5 {
    private static final long NOT_SET = Long.MIN_VALUE;
    private kn4 producer;
    private long requested;
    private final sm5<?> subscriber;
    private final bn5 subscriptions;

    public sm5() {
        this(null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    public final void add(zm5 zm5Var) {
        this.subscriptions.a(zm5Var);
    }

    @Override // defpackage.zm5
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
        synchronized (this) {
            kn4 kn4Var = this.producer;
            if (kn4Var != null) {
                kn4Var.request(j);
            } else {
                addToRequested(j);
            }
        }
    }

    public void setProducer(kn4 kn4Var) {
        long j;
        sm5<?> sm5Var;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = kn4Var;
            sm5Var = this.subscriber;
            z = sm5Var != null && j == Long.MIN_VALUE;
        }
        if (z) {
            sm5Var.setProducer(kn4Var);
        } else if (j == Long.MIN_VALUE) {
            kn4Var.request(Long.MAX_VALUE);
        } else {
            kn4Var.request(j);
        }
    }

    @Override // defpackage.zm5
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public sm5(sm5<?> sm5Var) {
        this(sm5Var, true);
    }

    public sm5(sm5<?> sm5Var, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = sm5Var;
        this.subscriptions = (!z || sm5Var == null) ? new bn5() : sm5Var.subscriptions;
    }

    public void onStart() {
    }
}
