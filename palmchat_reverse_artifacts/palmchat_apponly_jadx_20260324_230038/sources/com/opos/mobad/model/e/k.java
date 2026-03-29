package com.opos.mobad.model.e;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class k extends m {
    private boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f9102a = new l();
    private long b = SystemClock.elapsedRealtime();
    private long c = 0;

    private void d(boolean z) {
        if (z) {
            return;
        }
        this.d = false;
    }

    public void a(boolean z) {
        d(z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9102a.a("6", String.valueOf(j));
        this.c += j;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return com.opos.cmn.i.o.a(this.f9102a.a());
    }

    public boolean a() {
        return this.d;
    }

    public void b(boolean z) {
        d(z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9102a.a("7", String.valueOf(j));
        this.c += j;
    }

    public void c(boolean z) {
        d(z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9102a.a("8", String.valueOf(j));
        this.c += j;
    }
}
