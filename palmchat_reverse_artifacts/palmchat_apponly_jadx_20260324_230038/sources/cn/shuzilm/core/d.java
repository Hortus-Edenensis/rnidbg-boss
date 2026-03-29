package cn.shuzilm.core;

import android.content.Context;
import android.os.SystemClock;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class d extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2466a;

    public d(Context context) {
        this.f2466a = context;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            DUHelper unused = DUHelper.d;
            if (DUHelper.e <= 0) {
                DUHelper.d.a(this.f2466a, "DefaultChannel", "ZVTFJRA", (Listener) null, 2);
                SystemClock.sleep(20L);
            }
            if (DUHelper.y != null) {
                DUHelper.y.cancel();
                Timer unused2 = DUHelper.y = null;
            }
        } catch (Throwable unused3) {
        }
    }
}
