package com.opos.mobad.f.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class o<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f8884a;
    private a<T> b;
    private volatile long c = Long.MAX_VALUE;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T> {
        void a(T t);
    }

    public o(a<T> aVar) {
        this.b = aVar;
    }

    public void a() {
        this.c = Long.MAX_VALUE;
        this.f8884a = null;
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
        this.f8884a = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        a<T> aVar;
        if (SystemClock.uptimeMillis() >= this.c && (aVar = this.b) != null) {
            aVar.a(this.f8884a);
        }
    }

    public void a(long j, T t) {
        long jMax = Math.max(0L, j);
        this.c = SystemClock.uptimeMillis() + jMax;
        this.f8884a = t;
        com.opos.mobad.service.c.a(this, jMax);
    }
}
