package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class n implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m.a f11254a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ m d;

    public n(m mVar, m.a aVar, String str, String str2) {
        this.d = mVar;
        this.f11254a = aVar;
        this.b = str;
        this.c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i != 0) {
            com.vivo.push.restructure.a.a().h().a("");
            return;
        }
        Object[] objArrB = this.f11254a.b();
        if (objArrB == null || objArrB.length == 0) {
            com.vivo.push.util.t.a("PushClientManager", "bind app result is null");
        } else {
            com.vivo.push.restructure.a.a().h().a((String) this.f11254a.b()[0], this.b, this.c);
        }
    }
}
