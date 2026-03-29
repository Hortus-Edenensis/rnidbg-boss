package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r25 extends g13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f20382a;

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f20382a = new Handler();
        Looper.loop();
    }
}
