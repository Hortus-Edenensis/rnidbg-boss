package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushQueryActionListener f11194a;
    final /* synthetic */ a b;

    public b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.b = aVar;
        this.f11194a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.f11194a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(strB);
        }
    }
}
