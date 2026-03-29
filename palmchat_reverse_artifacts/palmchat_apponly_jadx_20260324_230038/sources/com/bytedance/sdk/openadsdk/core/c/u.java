package com.bytedance.sdk.openadsdk.core.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum u {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    private long iz;
    private long pn;

    u(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.pn = 1 << i;
        this.iz = i;
    }

    public long u() {
        return this.pn;
    }
}
