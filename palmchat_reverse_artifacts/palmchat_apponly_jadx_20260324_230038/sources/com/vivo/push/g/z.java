package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.r f11245a;
    final /* synthetic */ y b;

    public z(y yVar, com.vivo.push.b.r rVar) {
        this.b = yVar;
        this.f11245a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y yVar = this.b;
        ((aa) yVar).b.onPublish(((com.vivo.push.s) yVar).f11282a, this.f11245a.i(), this.f11245a.h());
    }
}
