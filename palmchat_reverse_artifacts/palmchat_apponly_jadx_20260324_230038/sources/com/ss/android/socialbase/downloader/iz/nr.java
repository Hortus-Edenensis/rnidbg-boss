package com.ss.android.socialbase.downloader.iz;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class nr implements b, fx, pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f10613a;
    private u iz;
    private volatile boolean jk;
    private u n;
    private final int nr;
    private u pn;
    private int t;
    private final int u;
    private u x;
    private final Object fx = new Object();
    private final Object b = new Object();

    public nr(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.u = i;
        this.nr = i2;
    }

    public void fx() {
        this.jk = true;
        synchronized (this.fx) {
            this.fx.notifyAll();
        }
        synchronized (this.b) {
            this.b.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.fx
    @NonNull
    public u nr() throws my, InterruptedException {
        synchronized (this.fx) {
            if (this.jk) {
                throw new my("obtain");
            }
            u uVar = this.pn;
            if (uVar == null) {
                int i = this.t;
                if (i < this.u) {
                    this.t = i + 1;
                    return new u(this.nr);
                }
                do {
                    this.fx.wait();
                    if (this.jk) {
                        throw new my("obtain");
                    }
                    uVar = this.pn;
                } while (uVar == null);
            }
            this.pn = uVar.b;
            if (uVar == this.iz) {
                this.iz = null;
            }
            uVar.b = null;
            return uVar;
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.b
    @NonNull
    public u u() throws my, InterruptedException {
        u uVar;
        u uVar2 = this.f10613a;
        if (uVar2 != null) {
            this.f10613a = uVar2.b;
            uVar2.b = null;
            return uVar2;
        }
        synchronized (this.b) {
            uVar = this.x;
            while (uVar == null) {
                if (this.jk) {
                    throw new my("read");
                }
                this.b.wait();
                uVar = this.x;
            }
            this.f10613a = uVar.b;
            this.n = null;
            this.x = null;
            uVar.b = null;
        }
        return uVar;
    }

    @Override // com.ss.android.socialbase.downloader.iz.fx
    public void u(@NonNull u uVar) {
        synchronized (this.fx) {
            u uVar2 = this.iz;
            if (uVar2 == null) {
                this.iz = uVar;
                this.pn = uVar;
            } else {
                uVar2.b = uVar;
                this.iz = uVar;
            }
            this.fx.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.pn
    public void nr(@NonNull u uVar) {
        synchronized (this.b) {
            u uVar2 = this.n;
            if (uVar2 == null) {
                this.n = uVar;
                this.x = uVar;
                this.b.notify();
            } else {
                uVar2.b = uVar;
                this.n = uVar;
            }
        }
    }
}
