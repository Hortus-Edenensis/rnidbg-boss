package com.bytedance.sdk.component.fx.u;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends bq {
    private bq u;

    public a(bq bqVar) {
        if (bqVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.u = bqVar;
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public long f_() {
        return this.u.f_();
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public boolean fx() {
        return this.u.fx();
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public long g_() {
        return this.u.g_();
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public bq iz() {
        return this.u.iz();
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public bq pn() {
        return this.u.pn();
    }

    public final bq u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public void x() throws IOException {
        this.u.x();
    }

    public final a u(bq bqVar) {
        if (bqVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.u = bqVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public bq u(long j, TimeUnit timeUnit) {
        return this.u.u(j, timeUnit);
    }

    @Override // com.bytedance.sdk.component.fx.u.bq
    public bq u(long j) {
        return this.u.u(j);
    }
}
