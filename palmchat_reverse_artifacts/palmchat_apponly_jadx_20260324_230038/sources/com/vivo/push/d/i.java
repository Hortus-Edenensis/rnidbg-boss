package com.vivo.push.d;

import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f11226a;

    public i(h hVar) {
        this.f11226a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        com.vivo.push.d.a.b bVar2 = (com.vivo.push.d.a.b) bVar;
        if (this.f11226a.f11225a != null) {
            t.b("query success");
            this.f11226a.f11225a.onSuccess(bVar2.a());
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i) {
        if (this.f11226a.f11225a != null) {
            t.b("query err : ".concat(String.valueOf(i)));
            this.f11226a.f11225a.onError(i);
        }
    }
}
