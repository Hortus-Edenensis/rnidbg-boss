package com.opos.mobad.f.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f8885a;
    private volatile long b = Long.MAX_VALUE;

    public p(Runnable runnable) {
        this.f8885a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.b && (runnable = this.f8885a) != null) {
            runnable.run();
        }
    }

    public void a(long j) {
        long jMax = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + jMax;
        com.opos.mobad.service.c.a(this, jMax);
    }
}
