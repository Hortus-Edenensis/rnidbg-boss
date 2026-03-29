package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2486a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Listener e;
    final /* synthetic */ DUHelper f;

    public q(DUHelper dUHelper, Context context, String str, String str2, String str3, Listener listener) {
        this.f = dUHelper;
        this.f2486a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String strB = DUHelper.d.b(this.f2486a, this.b, this.c, this.d);
            Listener listener = this.e;
            if (listener != null) {
                listener.handler(strB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
