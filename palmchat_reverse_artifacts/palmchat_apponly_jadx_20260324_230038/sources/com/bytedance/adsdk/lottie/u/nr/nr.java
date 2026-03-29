package com.bytedance.adsdk.lottie.u.nr;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends x<Integer> {
    public nr(List<com.bytedance.adsdk.lottie.iz.u<Integer>> list) {
        super(list);
    }

    public int a() {
        return fx(fx(), pn());
    }

    public int fx(com.bytedance.adsdk.lottie.iz.u<Integer> uVar, float f) {
        Integer num;
        if (uVar.u == null || uVar.nr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        return (fxVar == 0 || (num = (Integer) fxVar.u(uVar.iz, uVar.x.floatValue(), uVar.u, uVar.nr, f, b(), n())) == null) ? com.bytedance.adsdk.lottie.pn.fx.u(com.bytedance.adsdk.lottie.pn.n.nr(f, 0.0f, 1.0f), uVar.u.intValue(), uVar.nr.intValue()) : num.intValue();
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public Integer u(com.bytedance.adsdk.lottie.iz.u<Integer> uVar, float f) {
        return Integer.valueOf(fx(uVar, f));
    }
}
