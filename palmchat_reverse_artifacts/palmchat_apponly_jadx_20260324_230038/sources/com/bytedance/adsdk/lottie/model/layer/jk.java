package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.nr.my;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jk extends fx {
    private final b n;
    private final com.bytedance.adsdk.lottie.u.u.b x;

    public jk(com.bytedance.adsdk.lottie.n nVar, n nVar2, b bVar, com.bytedance.adsdk.lottie.iz izVar) {
        super(nVar, nVar2);
        this.n = bVar;
        com.bytedance.adsdk.lottie.u.u.b bVar2 = new com.bytedance.adsdk.lottie.u.u.b(nVar, this, new my("__container", nVar2.s(), false), izVar);
        this.x = bVar2;
        bVar2.u(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public com.bytedance.adsdk.lottie.model.nr.u l() {
        com.bytedance.adsdk.lottie.model.nr.u uVarL = super.l();
        return uVarL != null ? uVarL : this.n.l();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public com.bytedance.adsdk.lottie.b.jk mv() {
        com.bytedance.adsdk.lottie.b.jk jkVarMv = super.mv();
        return jkVarMv != null ? jkVarMv : this.n.mv();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        super.nr(canvas, matrix, i);
        this.x.u(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx, com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        super.u(rectF, matrix, z);
        this.x.u(rectF, this.u, z);
    }
}
