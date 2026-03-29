package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.PointF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr implements fx {
    private final boolean b;
    private final com.bytedance.adsdk.lottie.model.u.iz fx;
    private final com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> nr;
    private final boolean pn;
    private final String u;

    public nr(String str, com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVar, com.bytedance.adsdk.lottie.model.u.iz izVar, boolean z, boolean z2) {
        this.u = str;
        this.nr = mvVar;
        this.fx = izVar;
        this.b = z;
        this.pn = z2;
    }

    public boolean b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.u.iz fx() {
        return this.fx;
    }

    public com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.pn;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.iz(nVar, fxVar, this);
    }

    public String u() {
        return this.u;
    }
}
