package com.bytedance.adsdk.lottie.u.nr;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k extends x<com.bytedance.adsdk.lottie.model.nr> {
    public k(List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr>> list) {
        super(list);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.nr u(com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr> uVar, float f) {
        com.bytedance.adsdk.lottie.model.nr nrVar;
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        if (fxVar == 0) {
            return (f != 1.0f || (nrVar = uVar.nr) == null) ? uVar.u : nrVar;
        }
        float f2 = uVar.iz;
        Float f3 = uVar.x;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        com.bytedance.adsdk.lottie.model.nr nrVar2 = uVar.u;
        com.bytedance.adsdk.lottie.model.nr nrVar3 = uVar.nr;
        return (com.bytedance.adsdk.lottie.model.nr) fxVar.u(f2, fFloatValue, nrVar2, nrVar3 == null ? nrVar2 : nrVar3, f, pn(), n());
    }
}
