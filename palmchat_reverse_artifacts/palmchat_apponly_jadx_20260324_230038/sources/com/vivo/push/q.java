package com.vivo.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f11257a;
    final /* synthetic */ String b;
    final /* synthetic */ m c;

    public q(m mVar, com.vivo.push.b.b bVar, String str) {
        this.c = mVar;
        this.f11257a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f11257a);
        this.c.c(this.b);
    }
}
