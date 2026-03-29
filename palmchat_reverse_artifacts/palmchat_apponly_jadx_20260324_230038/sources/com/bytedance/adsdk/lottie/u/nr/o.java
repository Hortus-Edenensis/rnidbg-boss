package com.bytedance.adsdk.lottie.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class o<K, A> extends u<K, A> {
    private final A b;

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    public float iz() {
        return 1.0f;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    public void nr() {
        if (this.fx != null) {
            super.nr();
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    public void u(float f) {
        this.nr = f;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    public A x() {
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        A a2 = this.b;
        return fxVar.u(0.0f, 0.0f, a2, a2, n(), n(), n());
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    public A u(com.bytedance.adsdk.lottie.iz.u<K> uVar, float f) {
        return x();
    }
}
