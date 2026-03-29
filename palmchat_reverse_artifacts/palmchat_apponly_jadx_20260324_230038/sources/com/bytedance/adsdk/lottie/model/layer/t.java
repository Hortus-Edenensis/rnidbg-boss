package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t extends fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f4993a;
    private final Path jk;
    private com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> l;
    private final Paint n;
    private final n t;
    private final RectF x;

    public t(com.bytedance.adsdk.lottie.n nVar, n nVar2) {
        super(nVar, nVar2);
        this.x = new RectF();
        com.bytedance.adsdk.lottie.u.u uVar = new com.bytedance.adsdk.lottie.u.u();
        this.n = uVar;
        this.f4993a = new float[8];
        this.jk = new Path();
        this.t = nVar2;
        uVar.setAlpha(0);
        uVar.setStyle(Paint.Style.FILL);
        uVar.setColor(nVar2.my());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        super.nr(canvas, matrix, i);
        int iAlpha = Color.alpha(this.t.my());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.b.u() == null ? 100 : this.b.u().x().intValue())) / 100.0f) * 255.0f);
        this.n.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> uVar = this.l;
        if (uVar != null) {
            this.n.setColorFilter(uVar.x());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f4993a;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.t.sx();
            float[] fArr2 = this.f4993a;
            fArr2[3] = 0.0f;
            fArr2[4] = this.t.sx();
            this.f4993a[5] = this.t.o();
            float[] fArr3 = this.f4993a;
            fArr3[6] = 0.0f;
            fArr3[7] = this.t.o();
            matrix.mapPoints(this.f4993a);
            this.jk.reset();
            Path path = this.jk;
            float[] fArr4 = this.f4993a;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.jk;
            float[] fArr5 = this.f4993a;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.jk;
            float[] fArr6 = this.f4993a;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.jk;
            float[] fArr7 = this.f4993a;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.jk;
            float[] fArr8 = this.f4993a;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.jk.close();
            canvas.drawPath(this.jk, this.n);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx, com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        super.u(rectF, matrix, z);
        this.x.set(0.0f, 0.0f, this.t.sx(), this.t.o());
        this.u.mapRect(this.x);
        rectF.set(this.x);
    }
}
