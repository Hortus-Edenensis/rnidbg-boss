package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.nr.bg;
import com.bytedance.adsdk.lottie.model.nr.jk;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s implements u.InterfaceC0166u, mv, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> f5014a;
    private final jk.u b;
    private final com.bytedance.adsdk.lottie.n fx;
    private final boolean iz;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> jk;
    private boolean k;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> l;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> mv;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, PointF> n;
    private final String nr;
    private final boolean pn;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> t;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> x;
    private final Path u = new Path();
    private final nr s = new nr();

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.u.u.s$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[jk.u.values().length];
            u = iArr;
            try {
                iArr[jk.u.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[jk.u.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public s(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.jk jkVar) {
        this.fx = nVar;
        this.nr = jkVar.u();
        jk.u type = jkVar.getType();
        this.b = type;
        this.pn = jkVar.a();
        this.iz = jkVar.jk();
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = jkVar.nr().u();
        this.x = uVarU;
        com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> uVarU2 = jkVar.fx().u();
        this.n = uVarU2;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU3 = jkVar.b().u();
        this.f5014a = uVarU3;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU4 = jkVar.iz().u();
        this.t = uVarU4;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU5 = jkVar.n().u();
        this.mv = uVarU5;
        jk.u uVar = jk.u.STAR;
        if (type == uVar) {
            this.jk = jkVar.pn().u();
            this.l = jkVar.x().u();
        } else {
            this.jk = null;
            this.l = null;
        }
        fxVar.u(uVarU);
        fxVar.u(uVarU2);
        fxVar.u(uVarU3);
        fxVar.u(uVarU4);
        fxVar.u(uVarU5);
        if (type == uVar) {
            fxVar.u(this.jk);
            fxVar.u(this.l);
        }
        uVarU.u(this);
        uVarU2.u(this);
        uVarU3.u(this);
        uVarU4.u(this);
        uVarU5.u(this);
        if (type == uVar) {
            this.jk.u(this);
            this.l.u(this);
        }
    }

    private void fx() {
        int i;
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        double d3;
        float fFloatValue = this.x.x().floatValue();
        double radians = Math.toRadians((this.f5014a == null ? 0.0d : r2.x().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f9 = (float) (6.283185307179586d / d4);
        if (this.iz) {
            f9 *= -1.0f;
        }
        float f10 = f9 / 2.0f;
        float f11 = fFloatValue - ((int) fFloatValue);
        int i2 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f11) * f10);
        }
        float fFloatValue2 = this.t.x().floatValue();
        float fFloatValue3 = this.jk.x().floatValue();
        com.bytedance.adsdk.lottie.u.nr.u<?, Float> uVar = this.l;
        float fFloatValue4 = uVar != null ? uVar.x().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.u.nr.u<?, Float> uVar2 = this.mv;
        float fFloatValue5 = uVar2 != null ? uVar2.x().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f3 = ((fFloatValue2 - fFloatValue3) * f11) + fFloatValue3;
            i = i2;
            double d5 = f3;
            float fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.u.moveTo(fCos, fSin);
            d = radians + ((double) ((f9 * f11) / 2.0f));
            f = fCos;
            f2 = f10;
        } else {
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.u.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f10;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f12 = f2;
        float f13 = f;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 >= dCeil) {
                PointF pointFX = this.n.x();
                this.u.offset(pointFX.x, pointFX.y);
                this.u.close();
                return;
            }
            float f14 = z ? fFloatValue2 : fFloatValue3;
            if (f3 == 0.0f || d7 != dCeil - 2.0d) {
                f4 = f9;
                f5 = f12;
            } else {
                f4 = f9;
                f5 = (f9 * f11) / 2.0f;
            }
            if (f3 == 0.0f || d7 != dCeil - 1.0d) {
                d2 = d7;
                f6 = f3;
                f3 = f14;
            } else {
                d2 = d7;
                f6 = f3;
            }
            double d8 = f3;
            double d9 = dCeil;
            float fCos3 = (float) (d8 * Math.cos(d));
            float fSin3 = (float) (d8 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.u.lineTo(fCos3, fSin3);
                d3 = d;
                f7 = fFloatValue4;
                f8 = fFloatValue5;
            } else {
                f7 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f13) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f8 = fFloatValue5;
                d3 = d;
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f15 = z ? f7 : f8;
                float f16 = z ? f8 : f7;
                float f17 = (z ? fFloatValue3 : fFloatValue2) * f15 * 0.47829f;
                float f18 = fCos4 * f17;
                float f19 = f17 * fSin4;
                float f20 = (z ? fFloatValue2 : fFloatValue3) * f16 * 0.47829f;
                float f21 = fCos5 * f20;
                float f22 = f20 * fSin5;
                if (i != 0) {
                    if (i3 == 0) {
                        f18 *= f11;
                        f19 *= f11;
                    } else if (d2 == d9 - 1.0d) {
                        f21 *= f11;
                        f22 *= f11;
                    }
                }
                this.u.cubicTo(f13 - f18, fSin - f19, fCos3 + f21, fSin3 + f22, fCos3, fSin3);
            }
            d = d3 + ((double) f5);
            z = !z;
            i3++;
            f13 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f8;
            fFloatValue4 = f7;
            f3 = f6;
            f9 = f4;
            dCeil = d9;
        }
    }

    private void nr() {
        this.k = false;
        this.fx.invalidateSelf();
    }

    private void pn() {
        int i;
        double d;
        double d2;
        double d3;
        int iFloor = (int) Math.floor(this.x.x().floatValue());
        double radians = Math.toRadians((this.f5014a == null ? 0.0d : r2.x().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.mv.x().floatValue() / 100.0f;
        float fFloatValue2 = this.t.x().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.u.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.u.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.u.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFX = this.n.x();
        this.u.offset(pointFX.x, pointFX.y);
        this.u.close();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        if (this.k) {
            return this.u;
        }
        this.u.reset();
        if (this.pn) {
            this.k = true;
            return this.u;
        }
        int i = AnonymousClass1.u[this.b.ordinal()];
        if (i == 1) {
            fx();
        } else if (i == 2) {
            pn();
        }
        this.u.close();
        this.s.u(this.u);
        this.k = true;
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
                    this.s.u(dwVar);
                    dwVar.u(this);
                }
            }
        }
    }
}
