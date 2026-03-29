package com.vivo.push.g;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11238a;
    final /* synthetic */ com.vivo.push.b.i b;
    final /* synthetic */ h c;

    public i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.c = hVar;
        this.f11238a = str;
        this.b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f11238a)) {
            h hVar = this.c;
            ((aa) hVar).b.onReceiveRegId(((com.vivo.push.s) hVar).f11282a, this.f11238a);
        }
        h hVar2 = this.c;
        ((aa) hVar2).b.onBind(((com.vivo.push.s) hVar2).f11282a, this.b.i(), this.b.d());
    }
}
