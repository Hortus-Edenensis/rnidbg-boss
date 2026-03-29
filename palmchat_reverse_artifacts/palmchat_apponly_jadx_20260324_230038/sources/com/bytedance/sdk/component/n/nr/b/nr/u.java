package com.bytedance.sdk.component.n.nr.b.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int nr;
    private int u;

    public u(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.u = i;
        this.nr = i2;
    }

    public static u fx() {
        return new u(1, 100, 172800000L);
    }

    public int nr() {
        return this.nr;
    }

    public int u() {
        return this.u;
    }

    public static u u(int i, int i2) {
        return new u(i, i2, 172800000L);
    }
}
