package com.ss.android.downloadlib;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    private static volatile x u;
    private com.ss.android.download.api.config.iz nr = null;

    private x() {
    }

    public static x u() {
        if (u == null) {
            synchronized (x.class) {
                if (u == null) {
                    u = new x();
                }
            }
        }
        return u;
    }

    public com.ss.android.download.api.config.iz nr() {
        return this.nr;
    }
}
