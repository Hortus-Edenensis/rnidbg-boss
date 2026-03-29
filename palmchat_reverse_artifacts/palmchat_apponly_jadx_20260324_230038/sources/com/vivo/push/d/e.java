package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11222a;
    final /* synthetic */ IPushRequestCallback b;
    final /* synthetic */ d c;

    public e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.c = dVar;
        this.f11222a = str;
        this.b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("add profileId");
        d.a(this.c, this.f11222a, this.b, 1);
    }
}
