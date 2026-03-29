package rx.internal.subscriptions;

import defpackage.kz4;
import defpackage.yn1;
import defpackage.yy;
import defpackage.zm5;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class CancellableSubscription extends AtomicReference<yy> implements zm5 {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(yy yyVar) {
        super(yyVar);
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return get() == null;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        yy andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            yn1.d(e);
            kz4.g(e);
        }
    }
}
