package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.n f11242a;
    final /* synthetic */ r b;

    public s(r rVar, com.vivo.push.b.n nVar) {
        this.b = rVar;
        this.f11242a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.b;
        ((aa) rVar).b.onLog(((com.vivo.push.s) rVar).f11282a, this.f11242a.d(), this.f11242a.e(), this.f11242a.f());
    }
}
