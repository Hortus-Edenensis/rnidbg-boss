package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.nr.bg;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k implements u.InterfaceC0166u, mv, t {
    private final boolean b;
    private final String fx;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, PointF> iz;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> n;
    private final com.bytedance.adsdk.lottie.n pn;
    private boolean t;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, PointF> x;
    private final Path u = new Path();
    private final RectF nr = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nr f5011a = new nr();
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> jk = null;

    public k(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.t tVar) {
        this.fx = tVar.u();
        this.b = tVar.pn();
        this.pn = nVar;
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU = tVar.b().u();
        this.iz = uVarU;
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU2 = tVar.fx().u();
        this.x = uVarU2;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU3 = tVar.nr().u();
        this.n = uVarU3;
        fxVar.u(uVarU);
        fxVar.u(uVarU2);
        fxVar.u(uVarU3);
        uVarU.u(this);
        uVarU2.u(this);
        uVarU3.u(this);
    }

    private void nr() {
        this.t = false;
        this.pn.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar;
        if (this.t) {
            return this.u;
        }
        this.u.reset();
        if (this.b) {
            this.t = true;
            return this.u;
        }
        PointF pointFX = this.x.x();
        float f = pointFX.x / 2.0f;
        float f2 = pointFX.y / 2.0f;
        com.bytedance.adsdk.lottie.u.nr.u<?, Float> uVar2 = this.n;
        float fA = uVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.u.nr.b) uVar2).a();
        if (fA == 0.0f && (uVar = this.jk) != null) {
            fA = Math.min(uVar.x().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fA > fMin) {
            fA = fMin;
        }
        PointF pointFX2 = this.iz.x();
        this.u.moveTo(pointFX2.x + f, (pointFX2.y - f2) + fA);
        this.u.lineTo(pointFX2.x + f, (pointFX2.y + f2) - fA);
        if (fA > 0.0f) {
            RectF rectF = this.nr;
            float f3 = pointFX2.x;
            float f4 = fA * 2.0f;
            float f5 = pointFX2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.u.arcTo(this.nr, 0.0f, 90.0f, false);
        }
        this.u.lineTo((pointFX2.x - f) + fA, pointFX2.y + f2);
        if (fA > 0.0f) {
            RectF rectF2 = this.nr;
            float f6 = pointFX2.x;
            float f7 = pointFX2.y;
            float f8 = fA * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.u.arcTo(this.nr, 90.0f, 90.0f, false);
        }
        this.u.lineTo(pointFX2.x - f, (pointFX2.y - f2) + fA);
        if (fA > 0.0f) {
            RectF rectF3 = this.nr;
            float f9 = pointFX2.x;
            float f10 = pointFX2.y;
            float f11 = fA * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.u.arcTo(this.nr, 180.0f, 90.0f, false);
        }
        this.u.lineTo((pointFX2.x + f) - fA, pointFX2.y - f2);
        if (fA > 0.0f) {
            RectF rectF4 = this.nr;
            float f12 = pointFX2.x;
            float f13 = fA * 2.0f;
            float f14 = pointFX2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.u.arcTo(this.nr, 270.0f, 90.0f, false);
        }
        this.u.close();
        this.f5011a.u(this.u);
        this.t = true;
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        nr();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // com.bytedance.adsdk.lottie.u.u.fx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(List<fx> list, List<fx> list2) {
        for (int i = 0; i < list.size(); i++) {
            fx fxVar = list.get(i);
            if (fxVar instanceof dw) {
                dw dwVar = (dw) fxVar;
                if (dwVar.getType() == bg.u.SIMULTANEOUSLY) {
                    this.f5011a.u(dwVar);
                    dwVar.u(this);
                } else if (fxVar instanceof o) {
                    this.jk = ((o) fxVar).nr();
                }
            }
        }
    }
}
