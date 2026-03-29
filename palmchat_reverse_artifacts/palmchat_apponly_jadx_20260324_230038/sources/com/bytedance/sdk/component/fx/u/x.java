package com.bytedance.sdk.component.fx.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x implements sx {
    private final sx u;

    public x(sx sxVar) {
        if (sxVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.u = sxVar;
    }

    @Override // com.bytedance.sdk.component.fx.u.sx
    public void a_(fx fxVar, long j) throws IOException {
        this.u.a_(fxVar, j);
    }

    @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.u.close();
    }

    @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
    public void flush() throws IOException {
        this.u.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.u.toString() + ")";
    }

    @Override // com.bytedance.sdk.component.fx.u.sx
    public bq u() {
        return this.u.u();
    }
}
