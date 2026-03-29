package com.vivo.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f11255a;
    final /* synthetic */ String b;
    final /* synthetic */ m c;

    public o(m mVar, com.vivo.push.b.b bVar, String str) {
        this.c = mVar;
        this.f11255a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f11255a);
        this.c.c(this.b);
    }
}
