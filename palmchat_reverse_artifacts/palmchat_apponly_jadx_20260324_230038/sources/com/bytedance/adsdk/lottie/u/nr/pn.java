package com.bytedance.adsdk.lottie.u.nr;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends x<com.bytedance.adsdk.lottie.model.nr.b> {
    private final com.bytedance.adsdk.lottie.model.nr.b b;

    public pn(List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b>> list) {
        super(list);
        com.bytedance.adsdk.lottie.model.nr.b bVar = list.get(0).u;
        int iFx = bVar != null ? bVar.fx() : 0;
        this.b = new com.bytedance.adsdk.lottie.model.nr.b(new float[iFx], new int[iFx]);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.nr.b u(com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b> uVar, float f) {
        this.b.u(uVar.u, uVar.nr, f);
        return this.b;
    }
}
