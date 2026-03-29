package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bq extends u {
    private final com.bytedance.adsdk.lottie.model.layer.fx b;
    private final boolean iz;
    private com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> n;
    private final String pn;
    private final com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> x;

    public bq(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.sx sxVar) {
        super(nVar, fxVar, sxVar.x().u(), sxVar.n().u(), sxVar.a(), sxVar.fx(), sxVar.b(), sxVar.pn(), sxVar.iz());
        this.b = fxVar;
        this.pn = sxVar.u();
        this.iz = sxVar.jk();
        com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVarU = sxVar.nr().u();
        this.x = uVarU;
        uVarU.u(this);
        fxVar.u(uVarU);
    }

    @Override // com.bytedance.adsdk.lottie.u.u.u, com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        if (this.iz) {
            return;
        }
        this.nr.setColor(((com.bytedance.adsdk.lottie.u.nr.nr) this.x).a());
        com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> uVar = this.n;
        if (uVar != null) {
            this.nr.setColorFilter(uVar.x());
        }
        super.u(canvas, matrix, i);
    }
}
