package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class aw {
    private static volatile aw bfd = new aw();
    private volatile boolean bfe;
    private volatile long bff = 0;
    private volatile PowerManager bfg;

    public static aw SX() {
        return bfd;
    }

    public final boolean dx(Context context) {
        if (this.bff > 0 && SystemClock.elapsedRealtime() - this.bff < 600) {
            return this.bfe;
        }
        if (this.bfg == null && context != null) {
            synchronized (this) {
                if (this.bfg == null) {
                    this.bfg = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        this.bfe = this.bfg != null ? this.bfg.isInteractive() : false;
        this.bff = SystemClock.elapsedRealtime();
        return this.bfe;
    }
}
