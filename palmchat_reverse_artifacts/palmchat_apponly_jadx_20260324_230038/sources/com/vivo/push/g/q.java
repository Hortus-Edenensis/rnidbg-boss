package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.m f11241a;
    final /* synthetic */ p b;

    public q(p pVar, com.vivo.push.b.m mVar) {
        this.b = pVar;
        this.f11241a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.b;
        ((aa) pVar).b.onListTags(((com.vivo.push.s) pVar).f11282a, this.f11241a.i(), this.f11241a.d(), this.f11241a.h());
    }
}
