package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class af implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f11235a;
    final /* synthetic */ ae b;

    public af(ae aeVar, com.vivo.push.b.i iVar) {
        this.b = aeVar;
        this.f11235a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ae aeVar = this.b;
        ((aa) aeVar).b.onUnBind(((com.vivo.push.s) aeVar).f11282a, this.f11235a.i(), this.f11235a.d());
    }
}
