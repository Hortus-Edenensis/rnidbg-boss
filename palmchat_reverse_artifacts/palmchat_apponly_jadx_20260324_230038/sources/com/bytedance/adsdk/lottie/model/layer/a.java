package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends fx {
    public a(com.bytedance.adsdk.lottie.n nVar, n nVar2) {
        super(nVar, nVar2);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        super.nr(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx, com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        super.u(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
