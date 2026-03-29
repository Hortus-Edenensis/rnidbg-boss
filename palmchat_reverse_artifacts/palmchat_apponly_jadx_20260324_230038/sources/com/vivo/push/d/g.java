package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f11224a;
    final /* synthetic */ d b;

    public g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.b = dVar;
        this.f11224a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("delete all profileIds");
        d.a(this.b, "", this.f11224a, 3);
    }
}
