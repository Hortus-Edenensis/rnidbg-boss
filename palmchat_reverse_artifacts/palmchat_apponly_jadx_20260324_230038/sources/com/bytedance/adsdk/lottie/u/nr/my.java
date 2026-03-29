package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.u.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u<Float, Float> f5007a;
    private final Matrix b;
    private final Matrix fx;
    private u<PointF, PointF> iz;
    private u<Integer, Integer> jk;
    private b l;
    private u<?, Float> mv;
    private u<com.bytedance.adsdk.lottie.iz.b, com.bytedance.adsdk.lottie.iz.b> n;
    private final Matrix nr;
    private final float[] pn;
    private u<?, Float> s;
    private b t;
    private final Matrix u = new Matrix();
    private u<?, PointF> x;

    public my(com.bytedance.adsdk.lottie.model.u.l lVar) {
        this.iz = lVar.u() == null ? null : lVar.u().u();
        this.x = lVar.nr() == null ? null : lVar.nr().u();
        this.n = lVar.fx() == null ? null : lVar.fx().u();
        this.f5007a = lVar.b() == null ? null : lVar.b().u();
        b bVar = lVar.n() == null ? null : (b) lVar.n().u();
        this.t = bVar;
        if (bVar != null) {
            this.nr = new Matrix();
            this.fx = new Matrix();
            this.b = new Matrix();
            this.pn = new float[9];
        } else {
            this.nr = null;
            this.fx = null;
            this.b = null;
            this.pn = null;
        }
        this.l = lVar.a() == null ? null : (b) lVar.a().u();
        if (lVar.pn() != null) {
            this.jk = lVar.pn().u();
        }
        if (lVar.iz() != null) {
            this.mv = lVar.iz().u();
        } else {
            this.mv = null;
        }
        if (lVar.x() != null) {
            this.s = lVar.x().u();
        } else {
            this.s = null;
        }
    }

    private void pn() {
        for (int i = 0; i < 9; i++) {
            this.pn[i] = 0.0f;
        }
    }

    public Matrix b() {
        PointF pointFX;
        PointF pointFX2;
        this.u.reset();
        u<?, PointF> uVar = this.x;
        if (uVar != null && (pointFX2 = uVar.x()) != null) {
            float f = pointFX2.x;
            if (f != 0.0f || pointFX2.y != 0.0f) {
                this.u.preTranslate(f, pointFX2.y);
            }
        }
        u<Float, Float> uVar2 = this.f5007a;
        if (uVar2 != null) {
            float fFloatValue = uVar2 instanceof o ? uVar2.x().floatValue() : ((b) uVar2).a();
            if (fFloatValue != 0.0f) {
                this.u.preRotate(fFloatValue);
            }
        }
        if (this.t != null) {
            float fCos = this.l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.a()) + 90.0f));
            float fSin = this.l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.a()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.a()));
            pn();
            float[] fArr = this.pn;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.nr.setValues(fArr);
            pn();
            float[] fArr2 = this.pn;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.fx.setValues(fArr2);
            pn();
            float[] fArr3 = this.pn;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.b.setValues(fArr3);
            this.fx.preConcat(this.nr);
            this.b.preConcat(this.fx);
            this.u.preConcat(this.b);
        }
        u<com.bytedance.adsdk.lottie.iz.b, com.bytedance.adsdk.lottie.iz.b> uVar3 = this.n;
        if (uVar3 != null) {
            com.bytedance.adsdk.lottie.iz.b bVarX = uVar3.x();
            if (bVarX.u() != 1.0f || bVarX.nr() != 1.0f) {
                this.u.preScale(bVarX.u(), bVarX.nr());
            }
        }
        u<PointF, PointF> uVar4 = this.iz;
        if (uVar4 != null && (((pointFX = uVar4.x()) != null && pointFX.x != 0.0f) || pointFX.y != 0.0f)) {
            this.u.preTranslate(-pointFX.x, -pointFX.y);
        }
        return this.u;
    }

    public u<?, Float> fx() {
        return this.s;
    }

    public u<?, Float> nr() {
        return this.mv;
    }

    public void u(com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        fxVar.u(this.jk);
        fxVar.u(this.mv);
        fxVar.u(this.s);
        fxVar.u(this.iz);
        fxVar.u(this.x);
        fxVar.u(this.n);
        fxVar.u(this.f5007a);
        fxVar.u(this.t);
        fxVar.u(this.l);
    }

    public Matrix nr(float f) {
        u<?, PointF> uVar = this.x;
        PointF pointFX = uVar == null ? null : uVar.x();
        u<com.bytedance.adsdk.lottie.iz.b, com.bytedance.adsdk.lottie.iz.b> uVar2 = this.n;
        com.bytedance.adsdk.lottie.iz.b bVarX = uVar2 == null ? null : uVar2.x();
        this.u.reset();
        if (pointFX != null) {
            this.u.preTranslate(pointFX.x * f, pointFX.y * f);
        }
        if (bVarX != null) {
            double d = f;
            this.u.preScale((float) Math.pow(bVarX.u(), d), (float) Math.pow(bVarX.nr(), d));
        }
        u<Float, Float> uVar3 = this.f5007a;
        if (uVar3 != null) {
            float fFloatValue = uVar3.x().floatValue();
            u<PointF, PointF> uVar4 = this.iz;
            PointF pointFX2 = uVar4 != null ? uVar4.x() : null;
            this.u.preRotate(fFloatValue * f, pointFX2 == null ? 0.0f : pointFX2.x, pointFX2 != null ? pointFX2.y : 0.0f);
        }
        return this.u;
    }

    public void u(u.InterfaceC0166u interfaceC0166u) {
        u<Integer, Integer> uVar = this.jk;
        if (uVar != null) {
            uVar.u(interfaceC0166u);
        }
        u<?, Float> uVar2 = this.mv;
        if (uVar2 != null) {
            uVar2.u(interfaceC0166u);
        }
        u<?, Float> uVar3 = this.s;
        if (uVar3 != null) {
            uVar3.u(interfaceC0166u);
        }
        u<PointF, PointF> uVar4 = this.iz;
        if (uVar4 != null) {
            uVar4.u(interfaceC0166u);
        }
        u<?, PointF> uVar5 = this.x;
        if (uVar5 != null) {
            uVar5.u(interfaceC0166u);
        }
        u<com.bytedance.adsdk.lottie.iz.b, com.bytedance.adsdk.lottie.iz.b> uVar6 = this.n;
        if (uVar6 != null) {
            uVar6.u(interfaceC0166u);
        }
        u<Float, Float> uVar7 = this.f5007a;
        if (uVar7 != null) {
            uVar7.u(interfaceC0166u);
        }
        b bVar = this.t;
        if (bVar != null) {
            bVar.u(interfaceC0166u);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.u(interfaceC0166u);
        }
    }

    public void u(float f) {
        u<Integer, Integer> uVar = this.jk;
        if (uVar != null) {
            uVar.u(f);
        }
        u<?, Float> uVar2 = this.mv;
        if (uVar2 != null) {
            uVar2.u(f);
        }
        u<?, Float> uVar3 = this.s;
        if (uVar3 != null) {
            uVar3.u(f);
        }
        u<PointF, PointF> uVar4 = this.iz;
        if (uVar4 != null) {
            uVar4.u(f);
        }
        u<?, PointF> uVar5 = this.x;
        if (uVar5 != null) {
            uVar5.u(f);
        }
        u<com.bytedance.adsdk.lottie.iz.b, com.bytedance.adsdk.lottie.iz.b> uVar6 = this.n;
        if (uVar6 != null) {
            uVar6.u(f);
        }
        u<Float, Float> uVar7 = this.f5007a;
        if (uVar7 != null) {
            uVar7.u(f);
        }
        b bVar = this.t;
        if (bVar != null) {
            bVar.u(f);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.u(f);
        }
    }

    public u<?, Integer> u() {
        return this.jk;
    }
}
