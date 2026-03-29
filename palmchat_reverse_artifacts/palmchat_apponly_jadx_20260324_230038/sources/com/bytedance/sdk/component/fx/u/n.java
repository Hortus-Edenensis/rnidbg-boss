package com.bytedance.sdk.component.fx.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n implements bg {
    private final bg u;

    public n(bg bgVar) {
        if (bgVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.u = bgVar;
    }

    @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.u.close();
    }

    public final bg nr() {
        return this.u;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.u.toString() + ")";
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public long u(fx fxVar, long j) throws IOException {
        return this.u.u(fxVar, j);
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public bq u() {
        return this.u.u();
    }
}
