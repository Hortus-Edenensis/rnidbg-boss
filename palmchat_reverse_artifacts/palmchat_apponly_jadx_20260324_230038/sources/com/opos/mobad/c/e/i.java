package com.opos.mobad.c.e;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8602a = 0;
    private int b;

    public i(int i) {
        this.b = i;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(Object obj) {
        long j = this.f8602a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (j <= 0) {
            this.f8602a = jElapsedRealtime;
            return false;
        }
        if (jElapsedRealtime - this.f8602a < this.b) {
            return false;
        }
        this.f8602a = SystemClock.elapsedRealtime();
        return true;
    }
}
