package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f11225a;
    final /* synthetic */ d b;

    public h(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.b = dVar;
        this.f11225a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            t.b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.f11225a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context contextB = com.vivo.push.restructure.a.a().b();
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.d.a.a(new com.vivo.push.d.a.b(contextB.getPackageName(), new ArrayList(), 4)), new i(this), (byte) 0));
    }
}
