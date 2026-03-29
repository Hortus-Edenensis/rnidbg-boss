package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2463a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ Listener e;
    final /* synthetic */ DUHelper f;

    public a(DUHelper dUHelper, Context context, String str, String str2, int i, Listener listener) {
        this.f = dUHelper;
        this.f2463a = context;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper unused = DUHelper.d;
            DUHelper.g();
            String strA = DUHelper.d.a(this.f2463a, this.b, this.c, this.d);
            if (this.e != null) {
                if (strA == null) {
                    strA = this.f.j(this.f2463a);
                }
                this.e.handler(strA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
