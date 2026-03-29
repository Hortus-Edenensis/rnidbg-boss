package com.bytedance.adsdk.lottie.model.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l implements fx {
    private final com.bytedance.adsdk.lottie.model.u.l b;
    private final com.bytedance.adsdk.lottie.model.u.nr fx;
    private final com.bytedance.adsdk.lottie.model.u.nr nr;
    private final boolean pn;
    private final String u;

    public l(String str, com.bytedance.adsdk.lottie.model.u.nr nrVar, com.bytedance.adsdk.lottie.model.u.nr nrVar2, com.bytedance.adsdk.lottie.model.u.l lVar, boolean z) {
        this.u = str;
        this.nr = nrVar;
        this.fx = nrVar2;
        this.b = lVar;
        this.pn = z;
    }

    public com.bytedance.adsdk.lottie.model.u.l b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.u.nr fx() {
        return this.fx;
    }

    public com.bytedance.adsdk.lottie.model.u.nr nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.pn;
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.my(nVar, fxVar, this);
    }
}
