package com.kwad.sdk.utils;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bv {
    private long bgB;
    private long bgC;
    private boolean bgD;

    public bv() {
        reset();
    }

    private void reset() {
        this.bgB = 0L;
        this.bgC = -1L;
    }

    public final void Ud() {
        if (this.bgD && this.bgC < 0) {
            this.bgC = SystemClock.elapsedRealtime();
        }
    }

    public final void Ue() {
        if (this.bgD && this.bgC > 0) {
            this.bgB += SystemClock.elapsedRealtime() - this.bgC;
            this.bgC = -1L;
        }
    }

    public final long Uf() {
        if (!this.bgD) {
            return 0L;
        }
        this.bgD = false;
        if (this.bgC > 0) {
            this.bgB += SystemClock.elapsedRealtime() - this.bgC;
            this.bgC = -1L;
        }
        return this.bgB;
    }

    public final long getTime() {
        return this.bgC > 0 ? (this.bgB + SystemClock.elapsedRealtime()) - this.bgC : this.bgB;
    }

    public final void startTiming() {
        reset();
        this.bgD = true;
        this.bgC = SystemClock.elapsedRealtime();
    }
}
