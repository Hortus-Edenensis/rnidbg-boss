package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2484a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    public o(Context context, String str, String str2) {
        this.f2484a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.setConfig("apiKey", DUHelper.k);
            DUHelper.d.a(this.f2484a, DUHelper.n, this.b);
            DUHelper.d.a(DUHelper.m, this.c);
            DUHelper.reportRun(this.f2484a, DUHelper.n.toString(), DUHelper.m.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
