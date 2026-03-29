package com.bytedance.adsdk.lottie.model.nr;

import com.bytedance.adsdk.lottie.model.nr.sx;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz implements fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sx.nr f4997a;
    private final com.bytedance.adsdk.lottie.model.u.b b;
    private final com.bytedance.adsdk.lottie.model.u.fx fx;
    private final com.bytedance.adsdk.lottie.model.u.iz iz;
    private final float jk;
    private final com.bytedance.adsdk.lottie.model.u.nr l;
    private final boolean mv;
    private final sx.u n;
    private final x nr;
    private final com.bytedance.adsdk.lottie.model.u.iz pn;
    private final List<com.bytedance.adsdk.lottie.model.u.nr> t;
    private final String u;
    private final com.bytedance.adsdk.lottie.model.u.nr x;

    public iz(String str, x xVar, com.bytedance.adsdk.lottie.model.u.fx fxVar, com.bytedance.adsdk.lottie.model.u.b bVar, com.bytedance.adsdk.lottie.model.u.iz izVar, com.bytedance.adsdk.lottie.model.u.iz izVar2, com.bytedance.adsdk.lottie.model.u.nr nrVar, sx.u uVar, sx.nr nrVar2, float f, List<com.bytedance.adsdk.lottie.model.u.nr> list, com.bytedance.adsdk.lottie.model.u.nr nrVar3, boolean z) {
        this.u = str;
        this.nr = xVar;
        this.fx = fxVar;
        this.b = bVar;
        this.pn = izVar;
        this.iz = izVar2;
        this.x = nrVar;
        this.n = uVar;
        this.f4997a = nrVar2;
        this.jk = f;
        this.t = list;
        this.l = nrVar3;
        this.mv = z;
    }

    public sx.nr a() {
        return this.f4997a;
    }

    public com.bytedance.adsdk.lottie.model.u.b b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.u.fx fx() {
        return this.fx;
    }

    public com.bytedance.adsdk.lottie.model.u.iz iz() {
        return this.iz;
    }

    public List<com.bytedance.adsdk.lottie.model.u.nr> jk() {
        return this.t;
    }

    public float l() {
        return this.jk;
    }

    public boolean mv() {
        return this.mv;
    }

    public sx.u n() {
        return this.n;
    }

    public x nr() {
        return this.nr;
    }

    public com.bytedance.adsdk.lottie.model.u.iz pn() {
        return this.pn;
    }

    public com.bytedance.adsdk.lottie.model.u.nr t() {
        return this.l;
    }

    public String u() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.u.nr x() {
        return this.x;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.a(nVar, fxVar, this);
    }
}
