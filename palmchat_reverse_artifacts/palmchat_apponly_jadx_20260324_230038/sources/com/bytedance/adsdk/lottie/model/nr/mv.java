package com.bytedance.adsdk.lottie.model.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv implements fx {
    private final com.bytedance.adsdk.lottie.model.u.mv<Float, Float> nr;
    private final String u;

    public mv(String str, com.bytedance.adsdk.lottie.model.u.mv<Float, Float> mvVar) {
        this.u = str;
        this.nr = mvVar;
    }

    public com.bytedance.adsdk.lottie.model.u.mv<Float, Float> nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.o(nVar, fxVar, this);
    }
}
