package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class s implements Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2488a;
    final /* synthetic */ int b;
    final /* synthetic */ Listener c;

    public s(Context context, int i, Listener listener) {
        this.f2488a = context;
        this.b = i;
        this.c = listener;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        String strB = DUHelper.d.b(this.f2488a, this.b);
        Listener listener = this.c;
        if (listener != null) {
            listener.handler(strB);
        }
    }
}
