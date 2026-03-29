package com.bytedance.adsdk.lottie.model.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class o implements fx {
    private final boolean b;
    private final com.bytedance.adsdk.lottie.model.u.n fx;
    private final int nr;
    private final String u;

    public o(String str, int i, com.bytedance.adsdk.lottie.model.u.n nVar, boolean z) {
        this.u = str;
        this.nr = i;
        this.fx = nVar;
        this.b = z;
    }

    public boolean fx() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.u.n nr() {
        return this.fx;
    }

    public String toString() {
        return "ShapePath{name=" + this.u + ", index=" + this.nr + '}';
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.sx(nVar, fxVar, this);
    }
}
