package com.bytedance.adsdk.lottie.u.u;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n implements u.InterfaceC0166u, pn, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f5013a;
    private final com.bytedance.adsdk.lottie.model.layer.fx b;
    private final int bg;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> bq;
    private com.bytedance.adsdk.lottie.u.nr.fx dw;
    private final boolean fx;
    private final List<mv> jk;
    private final com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> k;
    private final com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.b, com.bytedance.adsdk.lottie.model.nr.b> l;
    private final com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> mv;
    private com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> my;
    private final Paint n;
    private final String nr;
    private com.bytedance.adsdk.lottie.u.nr.o o;
    private final com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> s;
    private final com.bytedance.adsdk.lottie.n sx;
    private final com.bytedance.adsdk.lottie.model.nr.x t;
    float u;
    private final Path x;
    private final LongSparseArray<LinearGradient> pn = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> iz = new LongSparseArray<>();

    public n(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.pn pnVar) {
        Path path = new Path();
        this.x = path;
        this.n = new com.bytedance.adsdk.lottie.u.u(1);
        this.f5013a = new RectF();
        this.jk = new ArrayList();
        this.u = 0.0f;
        this.b = fxVar;
        this.nr = pnVar.u();
        this.fx = pnVar.n();
        this.sx = nVar;
        this.t = pnVar.nr();
        path.setFillType(pnVar.fx());
        this.bg = (int) (izVar.pn() / 32.0f);
        com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.b, com.bytedance.adsdk.lottie.model.nr.b> uVarU = pnVar.b().u();
        this.l = uVarU;
        uVarU.u(this);
        fxVar.u(uVarU);
        com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVarU2 = pnVar.pn().u();
        this.mv = uVarU2;
        uVarU2.u(this);
        fxVar.u(uVarU2);
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU3 = pnVar.iz().u();
        this.s = uVarU3;
        uVarU3.u(this);
        fxVar.u(uVarU3);
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU4 = pnVar.x().u();
        this.k = uVarU4;
        uVarU4.u(this);
        fxVar.u(uVarU4);
        if (fxVar.l() != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU5 = fxVar.l().u().u();
            this.bq = uVarU5;
            uVarU5.u(this);
            fxVar.u(this.bq);
        }
        if (fxVar.mv() != null) {
            this.dw = new com.bytedance.adsdk.lottie.u.nr.fx(this, fxVar, fxVar.mv());
        }
    }

    private int b() {
        int iRound = Math.round(this.s.n() * this.bg);
        int iRound2 = Math.round(this.k.n() * this.bg);
        int iRound3 = Math.round(this.l.n() * this.bg);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private RadialGradient fx() {
        long jB = b();
        RadialGradient radialGradient = this.iz.get(jB);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFX = this.s.x();
        PointF pointFX2 = this.k.x();
        com.bytedance.adsdk.lottie.model.nr.b bVarX = this.l.x();
        int[] iArrU = u(bVarX.nr());
        float[] fArrU = bVarX.u();
        float f = pointFX.x;
        float f2 = pointFX.y;
        float fHypot = (float) Math.hypot(pointFX2.x - f, pointFX2.y - f2);
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrU, fArrU, Shader.TileMode.CLAMP);
        this.iz.put(jB, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient nr() {
        long jB = b();
        LinearGradient linearGradient = this.pn.get(jB);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFX = this.s.x();
        PointF pointFX2 = this.k.x();
        com.bytedance.adsdk.lottie.model.nr.b bVarX = this.l.x();
        LinearGradient linearGradient2 = new LinearGradient(pointFX.x, pointFX.y, pointFX2.x, pointFX2.y, u(bVarX.nr()), bVarX.u(), Shader.TileMode.CLAMP);
        this.pn.put(jB, linearGradient2);
        return linearGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.sx.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
        for (int i = 0; i < list2.size(); i++) {
            fx fxVar = list2.get(i);
            if (fxVar instanceof mv) {
                this.jk.add((mv) fxVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        Shader shaderFx;
        if (this.fx) {
            return;
        }
        com.bytedance.adsdk.lottie.pn.u("GradientFillContent#draw");
        this.x.reset();
        for (int i2 = 0; i2 < this.jk.size(); i2++) {
            this.x.addPath(this.jk.get(i2).b(), matrix);
        }
        this.x.computeBounds(this.f5013a, false);
        if (this.t == com.bytedance.adsdk.lottie.model.nr.x.LINEAR) {
            shaderFx = nr();
        } else {
            shaderFx = fx();
        }
        shaderFx.setLocalMatrix(matrix);
        this.n.setShader(shaderFx);
        com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> uVar = this.my;
        if (uVar != null) {
            this.n.setColorFilter(uVar.x());
        }
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar2 = this.bq;
        if (uVar2 != null) {
            float fFloatValue = uVar2.x().floatValue();
            if (fFloatValue == 0.0f) {
                this.n.setMaskFilter(null);
            } else if (fFloatValue != this.u) {
                this.n.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.u = fFloatValue;
        }
        com.bytedance.adsdk.lottie.u.nr.fx fxVar = this.dw;
        if (fxVar != null) {
            fxVar.u(this.n);
        }
        this.n.setAlpha(com.bytedance.adsdk.lottie.pn.n.u((int) ((((i / 255.0f) * this.mv.x().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.x, this.n);
        com.bytedance.adsdk.lottie.pn.nr("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        this.x.reset();
        for (int i = 0; i < this.jk.size(); i++) {
            this.x.addPath(this.jk.get(i).b(), matrix);
        }
        this.x.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] u(int[] iArr) {
        com.bytedance.adsdk.lottie.u.nr.o oVar = this.o;
        if (oVar != null) {
            Integer[] numArr = (Integer[]) oVar.x();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}
