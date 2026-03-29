package com.bytedance.adsdk.lottie.u.nr;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends x<Float> {
    public b(List<com.bytedance.adsdk.lottie.iz.u<Float>> list) {
        super(list);
    }

    public float a() {
        return fx(fx(), pn());
    }

    public float fx(com.bytedance.adsdk.lottie.iz.u<Float> uVar, float f) {
        Float f2;
        if (uVar.u == null || uVar.nr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        return (fxVar == 0 || (f2 = (Float) fxVar.u(uVar.iz, uVar.x.floatValue(), uVar.u, uVar.nr, f, b(), n())) == null) ? com.bytedance.adsdk.lottie.pn.n.u(uVar.iz(), uVar.x(), f) : f2.floatValue();
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public Float u(com.bytedance.adsdk.lottie.iz.u<Float> uVar, float f) {
        return Float.valueOf(fx(uVar, f));
    }
}
