package com.bytedance.adsdk.lottie.model.nr;

import com.bytedance.adsdk.lottie.u.u.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bg implements fx {
    private final com.bytedance.adsdk.lottie.model.u.nr b;
    private final com.bytedance.adsdk.lottie.model.u.nr fx;
    private final boolean iz;
    private final u nr;
    private final com.bytedance.adsdk.lottie.model.u.nr pn;
    private final String u;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static u u(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public bg(String str, u uVar, com.bytedance.adsdk.lottie.model.u.nr nrVar, com.bytedance.adsdk.lottie.model.u.nr nrVar2, com.bytedance.adsdk.lottie.model.u.nr nrVar3, boolean z) {
        this.u = str;
        this.nr = uVar;
        this.fx = nrVar;
        this.b = nrVar2;
        this.pn = nrVar3;
        this.iz = z;
    }

    public com.bytedance.adsdk.lottie.model.u.nr b() {
        return this.pn;
    }

    public com.bytedance.adsdk.lottie.model.u.nr fx() {
        return this.fx;
    }

    public u getType() {
        return this.nr;
    }

    public com.bytedance.adsdk.lottie.model.u.nr nr() {
        return this.b;
    }

    public boolean pn() {
        return this.iz;
    }

    public String toString() {
        return "Trim Path: {start: " + this.fx + ", end: " + this.b + ", offset: " + this.pn + "}";
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new dw(fxVar, this);
    }
}
