package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.PointF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jk implements fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.u.nr f4998a;
    private final com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> b;
    private final com.bytedance.adsdk.lottie.model.u.nr fx;
    private final com.bytedance.adsdk.lottie.model.u.nr iz;
    private final boolean jk;
    private final com.bytedance.adsdk.lottie.model.u.nr n;
    private final u nr;
    private final com.bytedance.adsdk.lottie.model.u.nr pn;
    private final boolean t;
    private final String u;
    private final com.bytedance.adsdk.lottie.model.u.nr x;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        STAR(1),
        POLYGON(2);

        private final int fx;

        u(int i) {
            this.fx = i;
        }

        public static u u(int i) {
            for (u uVar : values()) {
                if (uVar.fx == i) {
                    return uVar;
                }
            }
            return null;
        }
    }

    public jk(String str, u uVar, com.bytedance.adsdk.lottie.model.u.nr nrVar, com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVar, com.bytedance.adsdk.lottie.model.u.nr nrVar2, com.bytedance.adsdk.lottie.model.u.nr nrVar3, com.bytedance.adsdk.lottie.model.u.nr nrVar4, com.bytedance.adsdk.lottie.model.u.nr nrVar5, com.bytedance.adsdk.lottie.model.u.nr nrVar6, boolean z, boolean z2) {
        this.u = str;
        this.nr = uVar;
        this.fx = nrVar;
        this.b = mvVar;
        this.pn = nrVar2;
        this.iz = nrVar3;
        this.x = nrVar4;
        this.n = nrVar5;
        this.f4998a = nrVar6;
        this.jk = z;
        this.t = z2;
    }

    public boolean a() {
        return this.jk;
    }

    public com.bytedance.adsdk.lottie.model.u.nr b() {
        return this.pn;
    }

    public com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> fx() {
        return this.b;
    }

    public u getType() {
        return this.nr;
    }

    public com.bytedance.adsdk.lottie.model.u.nr iz() {
        return this.x;
    }

    public boolean jk() {
        return this.t;
    }

    public com.bytedance.adsdk.lottie.model.u.nr n() {
        return this.f4998a;
    }

    public com.bytedance.adsdk.lottie.model.u.nr nr() {
        return this.fx;
    }

    public com.bytedance.adsdk.lottie.model.u.nr pn() {
        return this.iz;
    }

    public String u() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.u.nr x() {
        return this.n;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.s(nVar, fxVar, this);
    }
}
