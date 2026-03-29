package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.nr.bg;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u implements u.InterfaceC0166u, pn, t {
    float fx;
    private final float[] jk;
    private com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> k;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Integer> l;
    private final List<com.bytedance.adsdk.lottie.u.nr.u<?, Float>> mv;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> my;
    private final com.bytedance.adsdk.lottie.n n;
    final Paint nr;
    private com.bytedance.adsdk.lottie.u.nr.fx o;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> s;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> t;
    protected final com.bytedance.adsdk.lottie.model.layer.fx u;
    private final PathMeasure b = new PathMeasure();
    private final Path pn = new Path();
    private final Path iz = new Path();
    private final RectF x = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0167u> f5015a = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.u.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0167u {
        private final dw nr;
        private final List<mv> u;

        private C0167u(dw dwVar) {
            this.u = new ArrayList();
            this.nr = dwVar;
        }
    }

    public u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.lottie.model.u.b bVar, com.bytedance.adsdk.lottie.model.u.nr nrVar, List<com.bytedance.adsdk.lottie.model.u.nr> list, com.bytedance.adsdk.lottie.model.u.nr nrVar2) {
        com.bytedance.adsdk.lottie.u.u uVar = new com.bytedance.adsdk.lottie.u.u(1);
        this.nr = uVar;
        this.fx = 0.0f;
        this.n = nVar;
        this.u = fxVar;
        uVar.setStyle(Paint.Style.STROKE);
        uVar.setStrokeCap(cap);
        uVar.setStrokeJoin(join);
        uVar.setStrokeMiter(f);
        this.l = bVar.u();
        this.t = nrVar.u();
        if (nrVar2 == null) {
            this.s = null;
        } else {
            this.s = nrVar2.u();
        }
        this.mv = new ArrayList(list.size());
        this.jk = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.mv.add(list.get(i).u());
        }
        fxVar.u(this.l);
        fxVar.u(this.t);
        for (int i2 = 0; i2 < this.mv.size(); i2++) {
            fxVar.u(this.mv.get(i2));
        }
        com.bytedance.adsdk.lottie.u.nr.u<?, Float> uVar2 = this.s;
        if (uVar2 != null) {
            fxVar.u(uVar2);
        }
        this.l.u(this);
        this.t.u(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.mv.get(i3).u(this);
        }
        com.bytedance.adsdk.lottie.u.nr.u<?, Float> uVar3 = this.s;
        if (uVar3 != null) {
            uVar3.u(this);
        }
        if (fxVar.l() != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = fxVar.l().u().u();
            this.my = uVarU;
            uVarU.u(this);
            fxVar.u(this.my);
        }
        if (fxVar.mv() != null) {
            this.o = new com.bytedance.adsdk.lottie.u.nr.fx(this, fxVar, fxVar.mv());
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.n.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.bytedance.adsdk.lottie.u.u.fx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(List<fx> list, List<fx> list2) {
        dw dwVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            fx fxVar = list.get(size);
            if (fxVar instanceof dw) {
                dw dwVar2 = (dw) fxVar;
                if (dwVar2.getType() == bg.u.INDIVIDUALLY) {
                    dwVar = dwVar2;
                }
            }
        }
        if (dwVar != null) {
            dwVar.u(this);
        }
        C0167u c0167u = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            fx fxVar2 = list2.get(size2);
            if (fxVar2 instanceof dw) {
                dw dwVar3 = (dw) fxVar2;
                if (dwVar3.getType() == bg.u.INDIVIDUALLY) {
                    if (c0167u != null) {
                        this.f5015a.add(c0167u);
                    }
                    c0167u = new C0167u(dwVar3);
                    dwVar3.u(this);
                } else if (fxVar2 instanceof mv) {
                    if (c0167u == null) {
                        c0167u = new C0167u(dwVar);
                    }
                    c0167u.u.add((mv) fxVar2);
                }
            }
        }
        if (c0167u != null) {
            this.f5015a.add(c0167u);
        }
    }

    public void u(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.lottie.pn.u("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.pn.a.nr(matrix)) {
            com.bytedance.adsdk.lottie.pn.nr("StrokeContent#draw");
            return;
        }
        this.nr.setAlpha(com.bytedance.adsdk.lottie.pn.n.u((int) ((((i / 255.0f) * ((com.bytedance.adsdk.lottie.u.nr.iz) this.l).a()) / 100.0f) * 255.0f), 0, 255));
        this.nr.setStrokeWidth(((com.bytedance.adsdk.lottie.u.nr.b) this.t).a() * com.bytedance.adsdk.lottie.pn.a.u(matrix));
        if (this.nr.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.pn.nr("StrokeContent#draw");
            return;
        }
        u(matrix);
        com.bytedance.adsdk.lottie.u.nr.u<ColorFilter, ColorFilter> uVar = this.k;
        if (uVar != null) {
            this.nr.setColorFilter(uVar.x());
        }
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar2 = this.my;
        if (uVar2 != null) {
            float fFloatValue = uVar2.x().floatValue();
            if (fFloatValue == 0.0f) {
                this.nr.setMaskFilter(null);
            } else if (fFloatValue != this.fx) {
                this.nr.setMaskFilter(this.u.nr(fFloatValue));
            }
            this.fx = fFloatValue;
        }
        com.bytedance.adsdk.lottie.u.nr.fx fxVar = this.o;
        if (fxVar != null) {
            fxVar.u(this.nr);
        }
        for (int i2 = 0; i2 < this.f5015a.size(); i2++) {
            C0167u c0167u = this.f5015a.get(i2);
            if (c0167u.nr != null) {
                u(canvas, c0167u, matrix);
            } else {
                com.bytedance.adsdk.lottie.pn.u("StrokeContent#buildPath");
                this.pn.reset();
                for (int size = c0167u.u.size() - 1; size >= 0; size--) {
                    this.pn.addPath(((mv) c0167u.u.get(size)).b(), matrix);
                }
                com.bytedance.adsdk.lottie.pn.nr("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.pn.u("StrokeContent#drawPath");
                canvas.drawPath(this.pn, this.nr);
                com.bytedance.adsdk.lottie.pn.nr("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.pn.nr("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(Canvas canvas, C0167u c0167u, Matrix matrix) {
        float f;
        float fMin;
        com.bytedance.adsdk.lottie.pn.u("StrokeContent#applyTrimPath");
        if (c0167u.nr == null) {
            com.bytedance.adsdk.lottie.pn.nr("StrokeContent#applyTrimPath");
            return;
        }
        this.pn.reset();
        for (int size = c0167u.u.size() - 1; size >= 0; size--) {
            this.pn.addPath(((mv) c0167u.u.get(size)).b(), matrix);
        }
        float fFloatValue = c0167u.nr.nr().x().floatValue() / 100.0f;
        float fFloatValue2 = c0167u.nr.fx().x().floatValue() / 100.0f;
        float fFloatValue3 = c0167u.nr.b().x().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.pn, this.nr);
            com.bytedance.adsdk.lottie.pn.nr("StrokeContent#applyTrimPath");
            return;
        }
        this.b.setPath(this.pn, false);
        float length = this.b.getLength();
        while (this.b.nextContour()) {
            length += this.b.getLength();
        }
        float f2 = fFloatValue3 * length;
        float f3 = (fFloatValue * length) + f2;
        float fMin2 = Math.min((fFloatValue2 * length) + f2, (f3 + length) - 1.0f);
        float f4 = 0.0f;
        for (int size2 = c0167u.u.size() - 1; size2 >= 0; size2--) {
            this.iz.set(((mv) c0167u.u.get(size2)).b());
            this.iz.transform(matrix);
            this.b.setPath(this.iz, false);
            float length2 = this.b.getLength();
            if (fMin2 > length) {
                float f5 = fMin2 - length;
                if (f5 >= f4 + length2 || f4 >= f5) {
                    float f6 = f4 + length2;
                    if (f6 >= f3 && f4 <= fMin2) {
                        if (f6 > fMin2 || f3 >= f4) {
                            f = f3 < f4 ? 0.0f : (f3 - f4) / length2;
                            fMin = fMin2 > f6 ? 1.0f : (fMin2 - f4) / length2;
                        } else {
                            canvas.drawPath(this.iz, this.nr);
                        }
                    }
                } else {
                    f = f3 > length ? (f3 - length) / length2 : 0.0f;
                    fMin = Math.min(f5 / length2, 1.0f);
                }
                com.bytedance.adsdk.lottie.pn.a.u(this.iz, f, fMin, 0.0f);
                canvas.drawPath(this.iz, this.nr);
            }
            f4 += length2;
        }
        com.bytedance.adsdk.lottie.pn.nr("StrokeContent#applyTrimPath");
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.lottie.pn.u("StrokeContent#getBounds");
        this.pn.reset();
        for (int i = 0; i < this.f5015a.size(); i++) {
            C0167u c0167u = this.f5015a.get(i);
            for (int i2 = 0; i2 < c0167u.u.size(); i2++) {
                this.pn.addPath(((mv) c0167u.u.get(i2)).b(), matrix);
            }
        }
        this.pn.computeBounds(this.x, false);
        float fA = ((com.bytedance.adsdk.lottie.u.nr.b) this.t).a();
        RectF rectF2 = this.x;
        float f = fA / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.x);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.pn.nr("StrokeContent#getBounds");
    }

    private void u(Matrix matrix) {
        com.bytedance.adsdk.lottie.pn.u("StrokeContent#applyDashPattern");
        if (this.mv.isEmpty()) {
            com.bytedance.adsdk.lottie.pn.nr("StrokeContent#applyDashPattern");
            return;
        }
        float fU = com.bytedance.adsdk.lottie.pn.a.u(matrix);
        for (int i = 0; i < this.mv.size(); i++) {
            this.jk[i] = this.mv.get(i).x().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.jk;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.jk;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.jk;
            fArr3[i] = fArr3[i] * fU;
        }
        com.bytedance.adsdk.lottie.u.nr.u<?, Float> uVar = this.s;
        this.nr.setPathEffect(new DashPathEffect(this.jk, uVar == null ? 0.0f : fU * uVar.x().floatValue()));
        com.bytedance.adsdk.lottie.pn.nr("StrokeContent#applyDashPattern");
    }
}
