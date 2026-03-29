package com.vivo.push;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f11314a = -1;

    public final synchronized boolean a() {
        boolean z;
        long j = this.f11314a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z = j != -1 && jElapsedRealtime > j && jElapsedRealtime < j + 2000;
        this.f11314a = SystemClock.elapsedRealtime();
        return z;
    }
}
