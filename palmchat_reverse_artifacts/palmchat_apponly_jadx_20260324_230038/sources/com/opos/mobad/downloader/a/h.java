package com.opos.mobad.downloader.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.mobad.downloader.a.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h implements Runnable {
    private static Handler c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f8773a;
    private volatile long b = Long.MAX_VALUE;
    private int d;

    public h(d.a aVar) {
        this.d = aVar.a();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public int b() {
        return this.d;
    }

    public void c() {
        this.b = Long.MAX_VALUE;
    }

    public void d() {
        c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.elapsedRealtime() >= this.b && (runnable = this.f8773a) != null) {
            runnable.run();
            this.f8773a = null;
        }
    }

    public void a(Runnable runnable, long j) {
        if (this.f8773a != null) {
            com.opos.cmn.an.f.a.b("TimeoutController", "start but is running");
            return;
        }
        this.f8773a = runnable;
        long jMax = Math.max(0L, j);
        this.b = SystemClock.elapsedRealtime() + jMax;
        c.postDelayed(this, jMax);
    }

    public boolean a() {
        return this.f8773a != null;
    }
}
