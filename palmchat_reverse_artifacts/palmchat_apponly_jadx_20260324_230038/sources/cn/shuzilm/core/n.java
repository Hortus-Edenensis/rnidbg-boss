package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2483a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    public n(Context context, String str, String str2) {
        this.f2483a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.setConfig("apiKey", DUHelper.k);
            DUHelper.d.a(this.f2483a, DUHelper.n, this.b);
            DUHelper.d.a(DUHelper.m, this.c);
            DUHelper.run(this.f2483a, DUHelper.n.toString(), DUHelper.m.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
