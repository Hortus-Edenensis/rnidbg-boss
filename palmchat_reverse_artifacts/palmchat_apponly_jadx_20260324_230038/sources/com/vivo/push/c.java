package com.vivo.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f11217a;
    final /* synthetic */ a b;

    public c(a aVar, IPushActionListener iPushActionListener) {
        this.b = aVar;
        this.f11217a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iA = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.f11217a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(iA);
        }
    }
}
