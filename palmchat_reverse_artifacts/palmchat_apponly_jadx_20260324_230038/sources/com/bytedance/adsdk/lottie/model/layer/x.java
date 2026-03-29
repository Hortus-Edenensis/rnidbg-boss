package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x extends fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f4995a;
    private final Rect jk;
    private com.bytedance.adsdk.lottie.u.nr.u<Bitmap, Bitmap> l;
    private final Paint n;
    private com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> t;
    protected final com.bytedance.adsdk.lottie.a x;

    public x(com.bytedance.adsdk.lottie.n nVar, n nVar2) {
        super(nVar, nVar2);
        this.n = new com.bytedance.adsdk.lottie.u.u(3);
        this.f4995a = new Rect();
        this.jk = new Rect();
        this.x = nVar.iz(nVar2.x());
    }

    private Bitmap s() {
        Bitmap bitmapX;
        com.bytedance.adsdk.lottie.u.nr.u<Bitmap, Bitmap> uVar = this.l;
        if (uVar != null && (bitmapX = uVar.x()) != null) {
            return bitmapX;
        }
        Bitmap bitmapPn = this.nr.pn(this.fx.x());
        if (bitmapPn != null) {
            return bitmapPn;
        }
        com.bytedance.adsdk.lottie.a aVar = this.x;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        super.nr(canvas, matrix, i);
        Bitmap bitmapS = s();
        if (bitmapS == null || bitmapS.isRecycled() || this.x == null) {
            return;
        }
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        this.n.setAlpha(i);
        com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> uVar = this.t;
        if (uVar != null) {
            this.n.setColorFilter(uVar.x());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f4995a.set(0, 0, bitmapS.getWidth(), bitmapS.getHeight());
        if (this.nr.iz()) {
            this.jk.set(0, 0, (int) (this.x.u() * fU), (int) (this.x.nr() * fU));
        } else {
            this.jk.set(0, 0, (int) (bitmapS.getWidth() * fU), (int) (bitmapS.getHeight() * fU));
        }
        canvas.drawBitmap(bitmapS, this.f4995a, this.jk, this.n);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx, com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        super.u(rectF, matrix, z);
        if (this.x != null) {
            float fU = com.bytedance.adsdk.lottie.pn.a.u();
            rectF.set(0.0f, 0.0f, this.x.u() * fU, this.x.nr() * fU);
            this.u.mapRect(rectF);
        }
    }
}
