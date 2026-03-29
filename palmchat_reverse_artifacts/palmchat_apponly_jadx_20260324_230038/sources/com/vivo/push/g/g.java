package com.vivo.push.g;

import com.vivo.push.model.UPSNotificationMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f11237a;
    final /* synthetic */ e b;

    public g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = eVar;
        this.f11237a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.b;
        ((aa) eVar).b.onNotificationMessageClicked(((com.vivo.push.s) eVar).f11282a, this.f11237a);
    }
}
