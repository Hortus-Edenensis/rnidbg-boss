package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2465a;
    final /* synthetic */ Context b;

    public c(String str, Context context) {
        this.f2465a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.setConfig("f_pkg", this.f2465a);
            DUHelper.onIEvent(this.b, DUHelper.n.toString(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
