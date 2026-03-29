package com.bytedance.adsdk.lottie.model.u;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.u.nr.my;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l implements com.bytedance.adsdk.lottie.model.nr.fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nr f5001a;
    private final nr b;
    private final x fx;
    private final nr iz;
    private final nr n;
    private final mv<PointF, PointF> nr;
    private final b pn;
    private final pn u;
    private final nr x;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public nr a() {
        return this.x;
    }

    public nr b() {
        return this.b;
    }

    public x fx() {
        return this.fx;
    }

    public nr iz() {
        return this.n;
    }

    public my jk() {
        return new my(this);
    }

    public nr n() {
        return this.iz;
    }

    public mv<PointF, PointF> nr() {
        return this.nr;
    }

    public b pn() {
        return this.pn;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return null;
    }

    public nr x() {
        return this.f5001a;
    }

    public l(pn pnVar, mv<PointF, PointF> mvVar, x xVar, nr nrVar, b bVar, nr nrVar2, nr nrVar3, nr nrVar4, nr nrVar5) {
        this.u = pnVar;
        this.nr = mvVar;
        this.fx = xVar;
        this.b = nrVar;
        this.pn = bVar;
        this.n = nrVar2;
        this.f5001a = nrVar3;
        this.iz = nrVar4;
        this.x = nrVar5;
    }

    public pn u() {
        return this.u;
    }
}
