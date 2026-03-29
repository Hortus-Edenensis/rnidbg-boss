package com.vivo.push.restructure.request;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f11281a;
    final /* synthetic */ e b;

    public f(e eVar, b bVar) {
        this.b = eVar;
        this.f11281a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f11281a;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.f11281a.b().a(1003);
    }
}
