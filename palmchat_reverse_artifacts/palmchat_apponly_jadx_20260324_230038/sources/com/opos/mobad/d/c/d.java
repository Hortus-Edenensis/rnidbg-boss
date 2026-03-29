package com.opos.mobad.d.c;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f8758a;
    private volatile long b = Long.MAX_VALUE;
    private Handler c;

    public d(Handler handler, Runnable runnable) {
        this.c = handler;
        this.f8758a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void b() {
        this.c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis >= this.b) {
            Runnable runnable = this.f8758a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("", "run but outline:" + this.b + ",current:" + jUptimeMillis);
    }

    public void a(long j) {
        long jMax = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + jMax;
        this.c.postDelayed(this, jMax);
    }
}
