package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2477a;
    final /* synthetic */ String b;

    public g(Context context, String str) {
        this.f2477a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.dGZvcmRQ(this.f2477a, DUHelper.n.toString(), this.b);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
