package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.Path;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k implements fx {
    private final com.bytedance.adsdk.lottie.model.u.u b;
    private final String fx;
    private final boolean iz;
    private final Path.FillType nr;
    private final com.bytedance.adsdk.lottie.model.u.b pn;
    private final boolean u;

    public k(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.lottie.model.u.u uVar, com.bytedance.adsdk.lottie.model.u.b bVar, boolean z2) {
        this.fx = str;
        this.u = z;
        this.nr = fillType;
        this.b = uVar;
        this.pn = bVar;
        this.iz = z2;
    }

    public Path.FillType b() {
        return this.nr;
    }

    public com.bytedance.adsdk.lottie.model.u.b fx() {
        return this.pn;
    }

    public com.bytedance.adsdk.lottie.model.u.u nr() {
        return this.b;
    }

    public boolean pn() {
        return this.iz;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.u + '}';
    }

    public String u() {
        return this.fx;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.x(nVar, fxVar, this);
    }
}
