package cn.shuzilm.core;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2476a;
    final /* synthetic */ boolean b;
    final /* synthetic */ int c;
    final /* synthetic */ Listener d;
    final /* synthetic */ Context e;

    public e(Context context, boolean z, int i, Listener listener, Context context2) {
        this.f2476a = context;
        this.b = z;
        this.c = i;
        this.d = listener;
        this.e = context2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.h.lock();
            if (DUHelper.c == null) {
                AIClient unused = DUHelper.c = new AIClient(this.f2476a);
                if (this.b) {
                    DUHelper.c.asynAI(2);
                }
            }
            AIClient unused2 = DUHelper.c;
            if (!AIClient.isf && this.b) {
                DUHelper.c.asynAI(2);
            }
            AIClient unused3 = DUHelper.c;
            if (AIClient.isf || !this.b) {
                String upperCase = Build.MANUFACTURER.toUpperCase();
                if (this.c == 1) {
                    upperCase = "HUAWEI";
                }
                String strZZVTFJRA = DUHelper.zZVTFJRA(this.f2476a, DUHelper.c.cm(upperCase));
                if (strZZVTFJRA == null) {
                    strZZVTFJRA = "NA";
                }
                if (DUHelper.c.isOaidCollectAllowed(3)) {
                    this.d.handler(strZZVTFJRA);
                } else {
                    this.d.handler("NA");
                }
            } else {
                this.d.handler("NA");
            }
        } catch (Throwable th) {
            try {
                Listener listener = this.d;
                if (listener != null) {
                    listener.handler("NA");
                }
                th.printStackTrace();
            } finally {
                DUHelper.h.unlock();
                DUHelper.l(this.e);
            }
        }
    }
}
