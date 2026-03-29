package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.PointF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t implements fx {
    private final com.bytedance.adsdk.lottie.model.u.nr b;
    private final com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> fx;
    private final com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> nr;
    private final boolean pn;
    private final String u;

    public t(String str, com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVar, com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVar2, com.bytedance.adsdk.lottie.model.u.nr nrVar, boolean z) {
        this.u = str;
        this.nr = mvVar;
        this.fx = mvVar2;
        this.b = nrVar;
        this.pn = z;
    }

    public com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> b() {
        return this.nr;
    }

    public com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> fx() {
        return this.fx;
    }

    public com.bytedance.adsdk.lottie.model.u.nr nr() {
        return this.b;
    }

    public boolean pn() {
        return this.pn;
    }

    public String toString() {
        return "RectangleShape{position=" + this.nr + ", size=" + this.fx + '}';
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.k(nVar, fxVar, this);
    }
}
