package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mp extends tp {
    public op h;
    public RectF i;
    public lp[] j;
    public Paint k;
    public Paint l;
    public RectF m;

    public mp(op opVar, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.i = new RectF();
        this.m = new RectF();
        this.h = opVar;
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setColor(Color.rgb(0, 0, 0));
        this.d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.k = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // defpackage.su0
    public void b(Canvas canvas) {
        np barData = this.h.getBarData();
        for (int i = 0; i < barData.f(); i++) {
            lk2 lk2Var = (lk2) barData.e(i);
            if (lk2Var.isVisible()) {
                j(canvas, lk2Var, i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        float y;
        float f;
        np barData = this.h.getBarData();
        for (vh2 vh2Var : vh2VarArr) {
            lk2 lk2Var = (lk2) barData.e(vh2Var.d());
            if (lk2Var != null && lk2Var.O()) {
                BarEntry barEntry = (BarEntry) lk2Var.o0(vh2Var.h(), vh2Var.j());
                if (h(barEntry, lk2Var)) {
                    h16 transformer = this.h.getTransformer(lk2Var.i0());
                    this.d.setColor(lk2Var.J0());
                    this.d.setAlpha(lk2Var.H0());
                    if (!(vh2Var.g() >= 0 && barEntry.isStacked())) {
                        y = barEntry.getY();
                        f = 0.0f;
                    } else if (this.h.isHighlightFullBarEnabled()) {
                        float positiveSum = barEntry.getPositiveSum();
                        f = -barEntry.getNegativeSum();
                        y = positiveSum;
                    } else {
                        xs4 xs4Var = barEntry.getRanges()[vh2Var.g()];
                        y = xs4Var.f22043a;
                        f = xs4Var.b;
                    }
                    l(barEntry.getX(), y, f, barData.u() / 2.0f, transformer);
                    m(vh2Var, this.i);
                    canvas.drawRect(this.i, this.d);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void e(Canvas canvas) {
        List list;
        vb3 vb3Var;
        int i;
        float f;
        boolean z;
        float[] fArr;
        h16 h16Var;
        int i2;
        float f2;
        int i3;
        BarEntry barEntry;
        float[] fArr2;
        float f3;
        float f4;
        float f5;
        BarEntry barEntry2;
        float f6;
        boolean z2;
        int i4;
        h96 h96Var;
        List list2;
        vb3 vb3Var2;
        BarEntry barEntry3;
        float f7;
        if (g(this.h)) {
            List listH = this.h.getBarData().h();
            float fE = s86.e(4.5f);
            boolean zIsDrawValueAboveBarEnabled = this.h.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.h.getBarData().f()) {
                lk2 lk2Var = (lk2) listH.get(i5);
                if (i(lk2Var)) {
                    a(lk2Var);
                    boolean zIsInverted = this.h.isInverted(lk2Var.i0());
                    float fA = s86.a(this.f, "8");
                    float f8 = zIsDrawValueAboveBarEnabled ? -fE : fA + fE;
                    float f9 = zIsDrawValueAboveBarEnabled ? fA + fE : -fE;
                    if (zIsInverted) {
                        f8 = (-f8) - fA;
                        f9 = (-f9) - fA;
                    }
                    float f10 = f8;
                    float f11 = f9;
                    lp lpVar = this.j[i5];
                    float fI = this.b.i();
                    h96 h96VarZ = lk2Var.Z();
                    vb3 vb3VarD = vb3.d(lk2Var.L0());
                    vb3VarD.c = s86.e(vb3VarD.c);
                    vb3VarD.d = s86.e(vb3VarD.d);
                    if (lk2Var.K()) {
                        list = listH;
                        vb3Var = vb3VarD;
                        h16 transformer = this.h.getTransformer(lk2Var.i0());
                        int i6 = 0;
                        int length = 0;
                        while (i6 < lk2Var.K0() * this.b.h()) {
                            BarEntry barEntry4 = (BarEntry) lk2Var.h(i6);
                            float[] yVals = barEntry4.getYVals();
                            float[] fArr3 = lpVar.b;
                            float f12 = (fArr3[length] + fArr3[length + 2]) / 2.0f;
                            int iL = lk2Var.l(i6);
                            if (yVals != null) {
                                BarEntry barEntry5 = barEntry4;
                                i = i6;
                                f = fE;
                                z = zIsDrawValueAboveBarEnabled;
                                fArr = yVals;
                                h16Var = transformer;
                                float f13 = f12;
                                int length2 = fArr.length * 2;
                                float[] fArr4 = new float[length2];
                                float f14 = -barEntry5.getNegativeSum();
                                int i7 = 0;
                                int i8 = 0;
                                float f15 = 0.0f;
                                while (i7 < length2) {
                                    float f16 = fArr[i8];
                                    if (f16 == 0.0f && (f15 == 0.0f || f14 == 0.0f)) {
                                        float f17 = f14;
                                        f14 = f16;
                                        f4 = f17;
                                    } else if (f16 >= 0.0f) {
                                        f15 += f16;
                                        f4 = f14;
                                        f14 = f15;
                                    } else {
                                        f4 = f14 - f16;
                                    }
                                    fArr4[i7 + 1] = f14 * fI;
                                    i7 += 2;
                                    i8++;
                                    f14 = f4;
                                }
                                h16Var.k(fArr4);
                                int i9 = 0;
                                while (i9 < length2) {
                                    float f18 = fArr[i9 / 2];
                                    float f19 = fArr4[i9 + 1] + (((f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) == 0 && (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1)) == 0 && (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1)) > 0) || (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) < 0 ? f11 : f10);
                                    int i10 = i9;
                                    if (!this.f20113a.C(f13)) {
                                        break;
                                    }
                                    if (this.f20113a.F(f19) && this.f20113a.B(f13)) {
                                        if (lk2Var.h0()) {
                                            BarEntry barEntry6 = barEntry5;
                                            f3 = f19;
                                            i3 = i10;
                                            barEntry = barEntry6;
                                            fArr2 = fArr4;
                                            i2 = length2;
                                            f2 = f13;
                                            k(canvas, h96VarZ.c(f18, barEntry6), f13, f3, iL);
                                        } else {
                                            f3 = f19;
                                            i2 = length2;
                                            f2 = f13;
                                            i3 = i10;
                                            barEntry = barEntry5;
                                            fArr2 = fArr4;
                                        }
                                        if (barEntry.getIcon() != null && lk2Var.B()) {
                                            Drawable icon = barEntry.getIcon();
                                            s86.f(canvas, icon, (int) (f2 + vb3Var.c), (int) (f3 + vb3Var.d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = length2;
                                        f2 = f13;
                                        i3 = i10;
                                        barEntry = barEntry5;
                                        fArr2 = fArr4;
                                    }
                                    i9 = i3 + 2;
                                    fArr4 = fArr2;
                                    barEntry5 = barEntry;
                                    length2 = i2;
                                    f13 = f2;
                                }
                            } else {
                                if (!this.f20113a.C(f12)) {
                                    break;
                                }
                                int i11 = length + 1;
                                if (this.f20113a.F(lpVar.b[i11]) && this.f20113a.B(f12)) {
                                    if (lk2Var.h0()) {
                                        f5 = f12;
                                        f = fE;
                                        fArr = yVals;
                                        barEntry2 = barEntry4;
                                        i = i6;
                                        z = zIsDrawValueAboveBarEnabled;
                                        h16Var = transformer;
                                        k(canvas, h96VarZ.b(barEntry4), f5, lpVar.b[i11] + (barEntry4.getY() >= 0.0f ? f10 : f11), iL);
                                    } else {
                                        f5 = f12;
                                        i = i6;
                                        f = fE;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barEntry2 = barEntry4;
                                        h16Var = transformer;
                                    }
                                    if (barEntry2.getIcon() != null && lk2Var.B()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        s86.f(canvas, icon2, (int) (vb3Var.c + f5), (int) (lpVar.b[i11] + (barEntry2.getY() >= 0.0f ? f10 : f11) + vb3Var.d), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer = transformer;
                                    zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
                                    fE = fE;
                                    i6 = i6;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i6 = i + 1;
                            transformer = h16Var;
                            zIsDrawValueAboveBarEnabled = z;
                            fE = f;
                        }
                    } else {
                        int i12 = 0;
                        while (i12 < lpVar.b.length * this.b.h()) {
                            float[] fArr5 = lpVar.b;
                            float f20 = (fArr5[i12] + fArr5[i12 + 2]) / 2.0f;
                            if (!this.f20113a.C(f20)) {
                                break;
                            }
                            int i13 = i12 + 1;
                            if (this.f20113a.F(lpVar.b[i13]) && this.f20113a.B(f20)) {
                                int i14 = i12 / 4;
                                BarEntry barEntry7 = (BarEntry) lk2Var.h(i14);
                                float y = barEntry7.getY();
                                if (lk2Var.h0()) {
                                    String strB = h96VarZ.b(barEntry7);
                                    float[] fArr6 = lpVar.b;
                                    barEntry3 = barEntry7;
                                    f7 = f20;
                                    i4 = i12;
                                    list2 = listH;
                                    vb3Var2 = vb3VarD;
                                    float f21 = y >= 0.0f ? fArr6[i13] + f10 : fArr6[i12 + 3] + f11;
                                    h96Var = h96VarZ;
                                    k(canvas, strB, f7, f21, lk2Var.l(i14));
                                } else {
                                    barEntry3 = barEntry7;
                                    f7 = f20;
                                    i4 = i12;
                                    h96Var = h96VarZ;
                                    list2 = listH;
                                    vb3Var2 = vb3VarD;
                                }
                                if (barEntry3.getIcon() != null && lk2Var.B()) {
                                    Drawable icon3 = barEntry3.getIcon();
                                    s86.f(canvas, icon3, (int) (f7 + vb3Var2.c), (int) ((y >= 0.0f ? lpVar.b[i13] + f10 : lpVar.b[i4 + 3] + f11) + vb3Var2.d), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i12;
                                h96Var = h96VarZ;
                                list2 = listH;
                                vb3Var2 = vb3VarD;
                            }
                            i12 = i4 + 4;
                            vb3VarD = vb3Var2;
                            h96VarZ = h96Var;
                            listH = list2;
                        }
                        list = listH;
                        vb3Var = vb3VarD;
                    }
                    f6 = fE;
                    z2 = zIsDrawValueAboveBarEnabled;
                    vb3.f(vb3Var);
                } else {
                    list = listH;
                    f6 = fE;
                    z2 = zIsDrawValueAboveBarEnabled;
                }
                i5++;
                zIsDrawValueAboveBarEnabled = z2;
                listH = list;
                fE = f6;
            }
        }
    }

    @Override // defpackage.su0
    public void f() {
        np barData = this.h.getBarData();
        this.j = new lp[barData.f()];
        for (int i = 0; i < this.j.length; i++) {
            lk2 lk2Var = (lk2) barData.e(i);
            this.j[i] = new lp(lk2Var.K0() * 4 * (lk2Var.K() ? lk2Var.m() : 1), barData.f(), lk2Var.K());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(Canvas canvas, lk2 lk2Var, int i) {
        h16 transformer = this.h.getTransformer(lk2Var.i0());
        this.l.setColor(lk2Var.V());
        this.l.setStrokeWidth(s86.e(lk2Var.C()));
        boolean z = lk2Var.C() > 0.0f;
        float fH = this.b.h();
        float fI = this.b.i();
        if (this.h.isDrawBarShadowEnabled()) {
            this.k.setColor(lk2Var.A0());
            float fU = this.h.getBarData().u() / 2.0f;
            int iMin = Math.min((int) Math.ceil(lk2Var.K0() * fH), lk2Var.K0());
            for (int i2 = 0; i2 < iMin; i2++) {
                float x = ((BarEntry) lk2Var.h(i2)).getX();
                RectF rectF = this.m;
                rectF.left = x - fU;
                rectF.right = x + fU;
                transformer.p(rectF);
                if (this.f20113a.B(this.m.right)) {
                    if (!this.f20113a.C(this.m.left)) {
                        break;
                    }
                    this.m.top = this.f20113a.j();
                    this.m.bottom = this.f20113a.f();
                    canvas.drawRect(this.m, this.k);
                }
            }
        }
        lp lpVar = this.j[i];
        lpVar.b(fH, fI);
        lpVar.g(i);
        lpVar.h(this.h.isInverted(lk2Var.i0()));
        lpVar.f(this.h.getBarData().u());
        lpVar.e(lk2Var);
        transformer.k(lpVar.b);
        boolean z2 = lk2Var.e0().size() == 1;
        if (z2) {
            this.c.setColor(lk2Var.getColor());
        }
        for (int i3 = 0; i3 < lpVar.c(); i3 += 4) {
            int i4 = i3 + 2;
            if (this.f20113a.B(lpVar.b[i4])) {
                if (!this.f20113a.C(lpVar.b[i3])) {
                    return;
                }
                if (!z2) {
                    this.c.setColor(lk2Var.z0(i3 / 4));
                }
                lk2Var.r0();
                if (lk2Var.q() != null) {
                    float[] fArr = lpVar.b;
                    float f = fArr[i3];
                    float f2 = fArr[i3 + 3];
                    float f3 = fArr[i3 + 1];
                    lk2Var.M0(i3 / 4);
                    throw null;
                }
                float[] fArr2 = lpVar.b;
                int i5 = i3 + 1;
                int i6 = i3 + 3;
                canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i4], fArr2[i6], this.c);
                if (z) {
                    float[] fArr3 = lpVar.b;
                    canvas.drawRect(fArr3[i3], fArr3[i5], fArr3[i4], fArr3[i6], this.l);
                }
            }
        }
    }

    public void k(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    public void l(float f, float f2, float f3, float f4, h16 h16Var) {
        this.i.set(f - f4, f2, f + f4, f3);
        h16Var.n(this.i, this.b.i());
    }

    public void m(vh2 vh2Var, RectF rectF) {
        vh2Var.m(rectF.centerX(), rectF.top);
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
    }
}
