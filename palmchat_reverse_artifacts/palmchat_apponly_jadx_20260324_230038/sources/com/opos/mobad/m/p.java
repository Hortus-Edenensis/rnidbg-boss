package com.opos.mobad.m;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f9000a;
    private volatile long b = Long.MAX_VALUE;
    private Handler c;

    public p(Handler handler, Runnable runnable) {
        this.c = handler;
        this.f9000a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void b() {
        this.c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.b && (runnable = this.f9000a) != null) {
            runnable.run();
        }
    }

    public void a(long j) {
        long jMax = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + jMax;
        this.c.postDelayed(this, jMax);
    }
}
