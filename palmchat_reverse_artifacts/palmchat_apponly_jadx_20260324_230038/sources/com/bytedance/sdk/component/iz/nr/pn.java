package com.bytedance.sdk.component.iz.nr;

import com.bytedance.sdk.component.iz.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements n {
    private long fx;
    private long nr;
    private long u;

    public void fx(long j) {
        this.fx = j;
    }

    @Override // com.bytedance.sdk.component.iz.n
    public long getEndRequestTime() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.n
    public long getFirstFrameTime() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.n
    public long getStartRequestTime() {
        return this.u;
    }

    public void nr(long j) {
        this.nr = j;
    }

    public void u(long j) {
        this.u = j;
    }
}
