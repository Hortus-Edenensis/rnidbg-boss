package com.vivo.push.util;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f11307a;
    final /* synthetic */ o b;

    public p(o oVar, List list) {
        this.b = oVar;
        this.f11307a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.b != null) {
            ac.c().a("com.vivo.push.notify_key", this.b.c);
            NotifyAdapterUtil.pushNotification(this.b.f11306a, this.f11307a, this.b.b, this.b.c, this.b.e, this.b.f, this.b.g);
        }
    }
}
