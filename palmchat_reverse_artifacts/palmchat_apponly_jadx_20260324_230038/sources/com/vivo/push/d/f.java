package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11223a;
    final /* synthetic */ IPushRequestCallback b;
    final /* synthetic */ d c;

    public f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.c = dVar;
        this.f11223a = str;
        this.b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("delete profileId");
        d.a(this.c, this.f11223a, this.b, 2);
    }
}
