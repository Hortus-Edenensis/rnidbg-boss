package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class be1 extends g13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f1699a = null;
    public final Object b = new Object();

    public be1(String str) {
        setName(str);
        start();
    }

    public void a(Runnable runnable) {
        b(runnable, 0L);
    }

    public void b(Runnable runnable, long j) {
        if (this.f1699a == null) {
            synchronized (this.b) {
                if (this.f1699a == null) {
                    try {
                        this.b.wait();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (this.f1699a != null) {
            if (j <= 0) {
                this.f1699a.post(runnable);
            } else {
                this.f1699a.postDelayed(runnable, j);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        synchronized (this.b) {
            this.f1699a = new Handler();
            this.b.notify();
        }
        Looper.loop();
    }
}
