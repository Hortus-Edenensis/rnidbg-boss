package com.opos.mobad.model.e;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f9098a = new l();
    private long b = SystemClock.elapsedRealtime();

    public d a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9098a.a("1", String.valueOf(j));
        return this;
    }

    public d b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9098a.a("2", String.valueOf(j));
        return this;
    }

    public d c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9098a.a("3", String.valueOf(j));
        return this;
    }

    public d d() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9098a.a("4", String.valueOf(j));
        return this;
    }

    public d e() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f9098a.a("5", String.valueOf(j));
        return this;
    }

    public String f() {
        return com.opos.cmn.i.o.a(this.f9098a.a());
    }
}
