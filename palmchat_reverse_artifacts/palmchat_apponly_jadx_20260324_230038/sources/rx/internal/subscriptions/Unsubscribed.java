package rx.internal.subscriptions;

import defpackage.zm5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public enum Unsubscribed implements zm5 {
    INSTANCE;

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
    }
}
