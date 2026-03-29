package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.lottie.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4992a;
    private int jk;
    private Path n;

    public s(com.bytedance.adsdk.lottie.n nVar, n nVar2, Context context) {
        super(nVar, nVar2);
        this.n = null;
        this.f4992a = -1;
        this.jk = -1;
        if (((x) this).x != null) {
            float fU = com.bytedance.adsdk.lottie.pn.a.u();
            this.f4992a = (int) (((x) this).x.u() * fU);
            this.jk = (int) (((x) this).x.nr() * fU);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.f4992a, this.jk);
            Path path = new Path();
            this.n = path;
            float f = fU * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    private static void u(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.x, com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        dw dwVarU = this.nr.u();
        View viewU = dwVarU != null ? dwVarU.u("videoview:", null) : null;
        if (this.f4992a <= 0 || viewU == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        u(i);
        float fN = n();
        u(viewU, this.f4992a, this.jk);
        viewU.setAlpha(fN);
        canvas.clipPath(this.n);
        viewU.draw(canvas);
        canvas.restore();
    }
}
