package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class j implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f11227a;
    final /* synthetic */ int b;
    final /* synthetic */ d c;

    public j(d dVar, IPushRequestCallback iPushRequestCallback, int i) {
        this.c = dVar;
        this.f11227a = iPushRequestCallback;
        this.b = i;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i) {
        if (this.f11227a != null) {
            t.b(this.b + " sync err : " + i);
            this.f11227a.onError(i);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        if (this.f11227a != null) {
            t.b(this.b + " sync success");
            this.f11227a.onSuccess(0);
        }
    }
}
