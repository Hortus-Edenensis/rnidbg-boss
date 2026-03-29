package com.bytedance.adsdk.lottie.model.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n {
    private final boolean b;
    private final com.bytedance.adsdk.lottie.model.u.b fx;
    private final com.bytedance.adsdk.lottie.model.u.n nr;
    private final u u;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public n(u uVar, com.bytedance.adsdk.lottie.model.u.n nVar, com.bytedance.adsdk.lottie.model.u.b bVar, boolean z) {
        this.u = uVar;
        this.nr = nVar;
        this.fx = bVar;
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.u.b fx() {
        return this.fx;
    }

    public com.bytedance.adsdk.lottie.model.u.n nr() {
        return this.nr;
    }

    public u u() {
        return this.u;
    }
}
