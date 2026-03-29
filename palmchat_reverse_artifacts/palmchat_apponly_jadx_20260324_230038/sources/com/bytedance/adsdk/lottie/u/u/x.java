package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x implements u.InterfaceC0166u, pn, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> f5016a;
    private final com.bytedance.adsdk.lottie.model.layer.fx b;
    private final Paint fx;
    private final boolean iz;
    private com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> jk;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> l;
    private com.bytedance.adsdk.lottie.u.nr.fx mv;
    private final com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> n;
    private final Path nr;
    private final String pn;
    private final com.bytedance.adsdk.lottie.n t;
    float u;
    private final List<mv> x;

    public x(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.k kVar) {
        Path path = new Path();
        this.nr = path;
        this.fx = new com.bytedance.adsdk.lottie.u.u(1);
        this.x = new ArrayList();
        this.b = fxVar;
        this.pn = kVar.u();
        this.iz = kVar.pn();
        this.t = nVar;
        if (fxVar.l() != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = fxVar.l().u().u();
            this.l = uVarU;
            uVarU.u(this);
            fxVar.u(this.l);
        }
        if (fxVar.mv() != null) {
            this.mv = new com.bytedance.adsdk.lottie.u.nr.fx(this, fxVar, fxVar.mv());
        }
        if (kVar.nr() == null || kVar.fx() == null) {
            this.n = null;
            this.f5016a = null;
            return;
        }
        path.setFillType(kVar.b());
        com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVarU2 = kVar.nr().u();
        this.n = uVarU2;
        uVarU2.u(this);
        fxVar.u(uVarU2);
        com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVarU3 = kVar.fx().u();
        this.f5016a = uVarU3;
        uVarU3.u(this);
        fxVar.u(uVarU3);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.t.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
        for (int i = 0; i < list2.size(); i++) {
            fx fxVar = list2.get(i);
            if (fxVar instanceof mv) {
                this.x.add((mv) fxVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        if (this.iz) {
            return;
        }
        com.bytedance.adsdk.lottie.pn.u("FillContent#draw");
        this.fx.setColor((com.bytedance.adsdk.lottie.pn.n.u((int) ((((i / 255.0f) * this.f5016a.x().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.u.nr.nr) this.n).a() & 16777215));
        com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> uVar = this.jk;
        if (uVar != null) {
            this.fx.setColorFilter(uVar.x());
        }
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar2 = this.l;
        if (uVar2 != null) {
            float fFloatValue = uVar2.x().floatValue();
            if (fFloatValue == 0.0f) {
                this.fx.setMaskFilter(null);
            } else if (fFloatValue != this.u) {
                this.fx.setMaskFilter(this.b.nr(fFloatValue));
            }
            this.u = fFloatValue;
        }
        com.bytedance.adsdk.lottie.u.nr.fx fxVar = this.mv;
        if (fxVar != null) {
            fxVar.u(this.fx);
        }
        this.nr.reset();
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            this.nr.addPath(this.x.get(i2).b(), matrix);
        }
        canvas.drawPath(this.nr, this.fx);
        com.bytedance.adsdk.lottie.pn.nr("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        this.nr.reset();
        for (int i = 0; i < this.x.size(); i++) {
            this.nr.addPath(this.x.get(i).b(), matrix);
        }
        this.nr.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
