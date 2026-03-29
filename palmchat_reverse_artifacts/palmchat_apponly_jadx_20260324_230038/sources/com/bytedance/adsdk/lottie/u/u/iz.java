package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.nr.bg;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz implements u.InterfaceC0166u, mv, t {
    private final com.bytedance.adsdk.lottie.u.nr.u<?, PointF> b;
    private final com.bytedance.adsdk.lottie.n fx;
    private final com.bytedance.adsdk.lottie.model.nr.nr iz;
    private boolean n;
    private final String nr;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, PointF> pn;
    private final Path u = new Path();
    private final nr x = new nr();

    public iz(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.nr nrVar) {
        this.nr = nrVar.u();
        this.fx = nVar;
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU = nrVar.fx().u();
        this.b = uVarU;
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU2 = nrVar.nr().u();
        this.pn = uVarU2;
        this.iz = nrVar;
        fxVar.u(uVarU);
        fxVar.u(uVarU2);
        uVarU.u(this);
        uVarU2.u(this);
    }

    private void nr() {
        this.n = false;
        this.fx.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        if (this.n) {
            return this.u;
        }
        this.u.reset();
        if (this.iz.pn()) {
            this.n = true;
            return this.u;
        }
        PointF pointFX = this.b.x();
        float f = pointFX.x / 2.0f;
        float f2 = pointFX.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.u.reset();
        if (this.iz.b()) {
            float f5 = -f2;
            this.u.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.u.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.u.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.u.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.u.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.u.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.u.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.u.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.u.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.u.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFX2 = this.pn.x();
        this.u.offset(pointFX2.x, pointFX2.y);
        this.u.close();
        this.x.u(this.u);
        this.n = true;
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        nr();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
        for (int i = 0; i < list.size(); i++) {
            fx fxVar = list.get(i);
            if (fxVar instanceof dw) {
                dw dwVar = (dw) fxVar;
                if (dwVar.getType() == bg.u.SIMULTANEOUSLY) {
                    this.x.u(dwVar);
                    dwVar.u(this);
                }
            }
        }
    }
}
