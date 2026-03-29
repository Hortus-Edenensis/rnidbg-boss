package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.nr.x f5009a;
    private final String b;
    private final LongSparseArray<LinearGradient> iz;
    private final int jk;
    private final com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> l;
    private final com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> mv;
    private final RectF n;
    private final boolean pn;
    private com.bytedance.adsdk.lottie.u.nr.o s;
    private final com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.b, com.bytedance.adsdk.lottie.model.nr.b> t;
    private final LongSparseArray<RadialGradient> x;

    public a(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.iz izVar) {
        super(nVar, fxVar, izVar.n().u(), izVar.a().u(), izVar.l(), izVar.b(), izVar.x(), izVar.jk(), izVar.t());
        this.iz = new LongSparseArray<>();
        this.x = new LongSparseArray<>();
        this.n = new RectF();
        this.b = izVar.u();
        this.f5009a = izVar.nr();
        this.pn = izVar.mv();
        this.jk = (int) (nVar.gi().pn() / 32.0f);
        com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.b, com.bytedance.adsdk.lottie.model.nr.b> uVarU = izVar.fx().u();
        this.t = uVarU;
        uVarU.u(this);
        fxVar.u(uVarU);
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU2 = izVar.pn().u();
        this.l = uVarU2;
        uVarU2.u(this);
        fxVar.u(uVarU2);
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU3 = izVar.iz().u();
        this.mv = uVarU3;
        uVarU3.u(this);
        fxVar.u(uVarU3);
    }

    private int b() {
        int iRound = Math.round(this.l.n() * this.jk);
        int iRound2 = Math.round(this.mv.n() * this.jk);
        int iRound3 = Math.round(this.t.n() * this.jk);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private RadialGradient fx() {
        long jB = b();
        RadialGradient radialGradient = this.x.get(jB);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFX = this.l.x();
        PointF pointFX2 = this.mv.x();
        com.bytedance.adsdk.lottie.model.nr.b bVarX = this.t.x();
        int[] iArrU = u(bVarX.nr());
        float[] fArrU = bVarX.u();
        RadialGradient radialGradient2 = new RadialGradient(pointFX.x, pointFX.y, (float) Math.hypot(pointFX2.x - r7, pointFX2.y - r8), iArrU, fArrU, Shader.TileMode.CLAMP);
        this.x.put(jB, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient nr() {
        long jB = b();
        LinearGradient linearGradient = this.iz.get(jB);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFX = this.l.x();
        PointF pointFX2 = this.mv.x();
        com.bytedance.adsdk.lottie.model.nr.b bVarX = this.t.x();
        LinearGradient linearGradient2 = new LinearGradient(pointFX.x, pointFX.y, pointFX2.x, pointFX2.y, u(bVarX.nr()), bVarX.u(), Shader.TileMode.CLAMP);
        this.iz.put(jB, linearGradient2);
        return linearGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.u, com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        if (this.pn) {
            return;
        }
        u(this.n, matrix, false);
        Shader shaderNr = this.f5009a == com.bytedance.adsdk.lottie.model.nr.x.LINEAR ? nr() : fx();
        shaderNr.setLocalMatrix(matrix);
        this.nr.setShader(shaderNr);
        super.u(canvas, matrix, i);
    }

    private int[] u(int[] iArr) {
        com.bytedance.adsdk.lottie.u.nr.o oVar = this.s;
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
