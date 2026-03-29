package com.opos.exoplayer.core.util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8393a;

    public synchronized boolean a() {
        if (this.f8393a) {
            return false;
        }
        this.f8393a = true;
        notifyAll();
        return true;
    }

    public synchronized boolean b() {
        boolean z;
        z = this.f8393a;
        this.f8393a = false;
        return z;
    }

    public synchronized void c() {
        while (!this.f8393a) {
            wait();
        }
    }
}
