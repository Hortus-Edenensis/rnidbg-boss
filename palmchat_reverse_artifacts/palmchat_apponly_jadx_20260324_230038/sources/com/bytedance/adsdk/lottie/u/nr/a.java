package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.bytedance.adsdk.lottie.iz.u<PointF> {
    private Path jk;
    private final com.bytedance.adsdk.lottie.iz.u<PointF> t;

    public a(com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.iz.u<PointF> uVar) {
        super(izVar, uVar.u, uVar.nr, uVar.fx, uVar.b, uVar.pn, uVar.iz, uVar.x);
        this.t = uVar;
        u();
    }

    public Path nr() {
        return this.jk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u() {
        T t;
        T t2;
        T t3 = this.nr;
        boolean z = (t3 == 0 || (t2 = this.u) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.u;
        if (t4 == 0 || (t = this.nr) == 0 || z) {
            return;
        }
        com.bytedance.adsdk.lottie.iz.u<PointF> uVar = this.t;
        this.jk = com.bytedance.adsdk.lottie.pn.a.u((PointF) t4, (PointF) t, uVar.n, uVar.f4983a);
    }
}
