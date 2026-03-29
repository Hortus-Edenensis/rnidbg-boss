package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.Path;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.u.nr f4999a;
    private final com.bytedance.adsdk.lottie.model.u.b b;
    private final com.bytedance.adsdk.lottie.model.u.fx fx;
    private final com.bytedance.adsdk.lottie.model.u.iz iz;
    private final boolean jk;
    private final com.bytedance.adsdk.lottie.model.u.nr n;
    private final Path.FillType nr;
    private final com.bytedance.adsdk.lottie.model.u.iz pn;
    private final x u;
    private final String x;

    public pn(String str, x xVar, Path.FillType fillType, com.bytedance.adsdk.lottie.model.u.fx fxVar, com.bytedance.adsdk.lottie.model.u.b bVar, com.bytedance.adsdk.lottie.model.u.iz izVar, com.bytedance.adsdk.lottie.model.u.iz izVar2, com.bytedance.adsdk.lottie.model.u.nr nrVar, com.bytedance.adsdk.lottie.model.u.nr nrVar2, boolean z) {
        this.u = xVar;
        this.nr = fillType;
        this.fx = fxVar;
        this.b = bVar;
        this.pn = izVar;
        this.iz = izVar2;
        this.x = str;
        this.n = nrVar;
        this.f4999a = nrVar2;
        this.jk = z;
    }

    public com.bytedance.adsdk.lottie.model.u.fx b() {
        return this.fx;
    }

    public Path.FillType fx() {
        return this.nr;
    }

    public com.bytedance.adsdk.lottie.model.u.iz iz() {
        return this.pn;
    }

    public boolean n() {
        return this.jk;
    }

    public x nr() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.u.b pn() {
        return this.b;
    }

    public String u() {
        return this.x;
    }

    public com.bytedance.adsdk.lottie.model.u.iz x() {
        return this.iz;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.n(nVar, izVar, fxVar, this);
    }
}
