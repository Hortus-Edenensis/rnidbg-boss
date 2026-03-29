package com.bytedance.sdk.openadsdk.core.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements com.bytedance.sdk.component.b.u.fx {
    public final long fx;
    public final float nr;
    public final float u;

    public fx(float f, float f2, long j) {
        this.u = f;
        this.nr = f2;
        this.fx = j;
    }

    @Override // com.bytedance.sdk.component.b.u.fx
    public long getLastTime() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.b.u.fx
    public float getLatitude() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.b.u.fx
    public float getLongitude() {
        return this.nr;
    }
}
