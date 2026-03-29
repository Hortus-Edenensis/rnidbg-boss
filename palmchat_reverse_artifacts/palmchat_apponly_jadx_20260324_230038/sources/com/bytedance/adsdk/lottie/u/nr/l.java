package com.bytedance.adsdk.lottie.u.nr;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l extends x<com.bytedance.adsdk.lottie.iz.b> {
    private final com.bytedance.adsdk.lottie.iz.b b;

    public l(List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.iz.b>> list) {
        super(list);
        this.b = new com.bytedance.adsdk.lottie.iz.b();
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.iz.b u(com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.iz.b> uVar, float f) {
        com.bytedance.adsdk.lottie.iz.b bVar;
        com.bytedance.adsdk.lottie.iz.b bVar2;
        com.bytedance.adsdk.lottie.iz.b bVar3 = uVar.u;
        if (bVar3 == null || (bVar = uVar.nr) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.iz.b bVar4 = bVar3;
        com.bytedance.adsdk.lottie.iz.b bVar5 = bVar;
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        if (fxVar != 0 && (bVar2 = (com.bytedance.adsdk.lottie.iz.b) fxVar.u(uVar.iz, uVar.x.floatValue(), bVar4, bVar5, f, b(), n())) != null) {
            return bVar2;
        }
        this.b.u(com.bytedance.adsdk.lottie.pn.n.u(bVar4.u(), bVar5.u(), f), com.bytedance.adsdk.lottie.pn.n.u(bVar4.nr(), bVar5.nr(), f));
        return this.b;
    }
}
