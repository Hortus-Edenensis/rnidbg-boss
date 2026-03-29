package com.bytedance.adsdk.lottie.model.nr;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class my implements fx {
    private final boolean fx;
    private final List<fx> nr;
    private final String u;

    public my(String str, List<fx> list, boolean z) {
        this.u = str;
        this.nr = list;
        this.fx = z;
    }

    public boolean fx() {
        return this.fx;
    }

    public List<fx> nr() {
        return this.nr;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.u + "' Shapes: " + Arrays.toString(this.nr.toArray()) + '}';
    }

    public String u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new com.bytedance.adsdk.lottie.u.u.b(nVar, fxVar, this, izVar);
    }
}
