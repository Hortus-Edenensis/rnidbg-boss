package com.vivo.push.sdk;

import com.vivo.push.ab;
import com.vivo.push.m;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.restructure.a.a f11283a;
    final /* synthetic */ a b;

    public b(a aVar, com.vivo.push.restructure.a.a aVar2) {
        this.b = aVar;
        this.f11283a = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.vivo.push.restructure.a.a().a(((ab) this.b).f11192a);
        t.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f11283a.j())));
        m.a().a(((ab) this.b).f11192a);
        com.vivo.push.restructure.a.a().d().a(this.f11283a);
    }
}
