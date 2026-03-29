package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pi2 extends mp {
    public RectF n;

    public pi2(op opVar, g10 g10Var, nf6 nf6Var) {
        super(opVar, g10Var, nf6Var);
        this.n = new RectF();
        this.f.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.mp, defpackage.su0
    public void e(Canvas canvas) {
        List list;
        int i;
        vb3 vb3Var;
        int i2;
        float f;
        float[] fArr;
        float f2;
        int i3;
        float[] fArr2;
        float f3;
        float f4;
        BarEntry barEntry;
        int i4;
        List list2;
        int i5;
        float f5;
        vb3 vb3Var2;
        lp lpVar;
        h96 h96Var;
        if (g(this.h)) {
            List listH = this.h.getBarData().h();
            float fE = s86.e(5.0f);
            boolean zIsDrawValueAboveBarEnabled = this.h.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < this.h.getBarData().f()) {
                lk2 lk2Var = (lk2) listH.get(i6);
                if (i(lk2Var)) {
                    boolean zIsInverted = this.h.isInverted(lk2Var.i0());
                    a(lk2Var);
                    float f6 = 2.0f;
                    float fA = s86.a(this.f, "10") / 2.0f;
                    h96 h96VarZ = lk2Var.Z();
                    lp lpVar2 = this.j[i6];
                    float fI = this.b.i();
                    vb3 vb3VarD = vb3.d(lk2Var.L0());
                    vb3VarD.c = s86.e(vb3VarD.c);
                    vb3VarD.d = s86.e(vb3VarD.d);
                    if (lk2Var.K()) {
                        list = listH;
                        i = i6;
                        vb3Var = vb3VarD;
                        h16 transformer = this.h.getTransformer(lk2Var.i0());
                        int i7 = 0;
                        int length = 0;
                        while (i7 < lk2Var.K0() * this.b.h()) {
                            BarEntry barEntry2 = (BarEntry) lk2Var.h(i7);
                            int iL = lk2Var.l(i7);
                            float[] yVals = barEntry2.getYVals();
                            if (yVals == null) {
                                int i8 = length + 1;
                                if (!this.f20113a.D(lpVar2.b[i8])) {
                                    break;
                                }
                                if (this.f20113a.E(lpVar2.b[length]) && this.f20113a.A(lpVar2.b[i8])) {
                                    String strB = h96VarZ.b(barEntry2);
                                    float fD = s86.d(this.f, strB);
                                    float f7 = zIsDrawValueAboveBarEnabled ? fE : -(fD + fE);
                                    float f8 = zIsDrawValueAboveBarEnabled ? -(fD + fE) : fE;
                                    if (zIsInverted) {
                                        f7 = (-f7) - fD;
                                        f8 = (-f8) - fD;
                                    }
                                    float f9 = f7;
                                    float f10 = f8;
                                    if (lk2Var.h0()) {
                                        float f11 = lpVar2.b[length + 2] + (barEntry2.getY() >= 0.0f ? f9 : f10);
                                        float f12 = lpVar2.b[i8] + fA;
                                        f = fA;
                                        fArr = yVals;
                                        barEntry = barEntry2;
                                        i2 = i7;
                                        k(canvas, strB, f11, f12, iL);
                                    } else {
                                        i2 = i7;
                                        f = fA;
                                        fArr = yVals;
                                        barEntry = barEntry2;
                                    }
                                    if (barEntry.getIcon() != null && lk2Var.B()) {
                                        Drawable icon = barEntry.getIcon();
                                        float f13 = lpVar2.b[length + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f9 = f10;
                                        }
                                        s86.f(canvas, icon, (int) (f13 + f9 + vb3Var.c), (int) (lpVar2.b[i8] + vb3Var.d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i2 = i7;
                                f = fA;
                                fArr = yVals;
                                int length2 = fArr.length * 2;
                                float[] fArr3 = new float[length2];
                                float f14 = -barEntry2.getNegativeSum();
                                int i9 = 0;
                                int i10 = 0;
                                float f15 = 0.0f;
                                while (i9 < length2) {
                                    float f16 = fArr[i10];
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
                                    fArr3[i9] = f14 * fI;
                                    i9 += 2;
                                    i10++;
                                    f14 = f4;
                                }
                                transformer.k(fArr3);
                                int i11 = 0;
                                while (i11 < length2) {
                                    float f18 = fArr[i11 / 2];
                                    String strC = h96VarZ.c(f18, barEntry2);
                                    float fD2 = s86.d(this.f, strC);
                                    float f19 = zIsDrawValueAboveBarEnabled ? fE : -(fD2 + fE);
                                    int i12 = length2;
                                    float f20 = zIsDrawValueAboveBarEnabled ? -(fD2 + fE) : fE;
                                    if (zIsInverted) {
                                        f19 = (-f19) - fD2;
                                        f20 = (-f20) - fD2;
                                    }
                                    boolean z = (f18 == 0.0f && f14 == 0.0f && f15 > 0.0f) || f18 < 0.0f;
                                    float f21 = fArr3[i11];
                                    if (z) {
                                        f19 = f20;
                                    }
                                    float f22 = f21 + f19;
                                    float[] fArr4 = lpVar2.b;
                                    float f23 = (fArr4[length + 1] + fArr4[length + 3]) / 2.0f;
                                    if (!this.f20113a.D(f23)) {
                                        break;
                                    }
                                    if (this.f20113a.E(f22) && this.f20113a.A(f23)) {
                                        if (lk2Var.h0()) {
                                            f2 = f23;
                                            i3 = i11;
                                            fArr2 = fArr3;
                                            f3 = f22;
                                            k(canvas, strC, f22, f23 + f, iL);
                                        } else {
                                            f2 = f23;
                                            i3 = i11;
                                            fArr2 = fArr3;
                                            f3 = f22;
                                        }
                                        if (barEntry2.getIcon() != null && lk2Var.B()) {
                                            Drawable icon2 = barEntry2.getIcon();
                                            s86.f(canvas, icon2, (int) (f3 + vb3Var.c), (int) (f2 + vb3Var.d), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = i11;
                                        fArr2 = fArr3;
                                    }
                                    i11 = i3 + 2;
                                    length2 = i12;
                                    fArr3 = fArr2;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i7 = i2 + 1;
                            fA = f;
                        }
                    } else {
                        int i13 = 0;
                        while (i13 < lpVar2.b.length * this.b.h()) {
                            float[] fArr5 = lpVar2.b;
                            int i14 = i13 + 1;
                            float f24 = fArr5[i14];
                            float f25 = (fArr5[i13 + 3] + f24) / f6;
                            if (!this.f20113a.D(f24)) {
                                break;
                            }
                            if (this.f20113a.E(lpVar2.b[i13]) && this.f20113a.A(lpVar2.b[i14])) {
                                BarEntry barEntry3 = (BarEntry) lk2Var.h(i13 / 4);
                                float y = barEntry3.getY();
                                String strB2 = h96VarZ.b(barEntry3);
                                float fD3 = s86.d(this.f, strB2);
                                float f26 = zIsDrawValueAboveBarEnabled ? fE : -(fD3 + fE);
                                float f27 = zIsDrawValueAboveBarEnabled ? -(fD3 + fE) : fE;
                                if (zIsInverted) {
                                    f26 = (-f26) - fD3;
                                    f27 = (-f27) - fD3;
                                }
                                float f28 = f26;
                                float f29 = f27;
                                if (lk2Var.h0()) {
                                    float f30 = lpVar2.b[i13 + 2];
                                    float f31 = y >= 0.0f ? f28 : f29;
                                    i4 = i13;
                                    list2 = listH;
                                    vb3Var2 = vb3VarD;
                                    f5 = f29;
                                    lpVar = lpVar2;
                                    i5 = i6;
                                    h96Var = h96VarZ;
                                    k(canvas, strB2, f30 + f31, f25 + fA, lk2Var.l(i13 / 2));
                                } else {
                                    i4 = i13;
                                    list2 = listH;
                                    i5 = i6;
                                    f5 = f29;
                                    vb3Var2 = vb3VarD;
                                    lpVar = lpVar2;
                                    h96Var = h96VarZ;
                                }
                                if (barEntry3.getIcon() != null && lk2Var.B()) {
                                    Drawable icon3 = barEntry3.getIcon();
                                    float f32 = lpVar.b[i4 + 2];
                                    if (y < 0.0f) {
                                        f28 = f5;
                                    }
                                    s86.f(canvas, icon3, (int) (f32 + f28 + vb3Var2.c), (int) (f25 + vb3Var2.d), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i13;
                                lpVar = lpVar2;
                                list2 = listH;
                                i5 = i6;
                                vb3Var2 = vb3VarD;
                                h96Var = h96VarZ;
                            }
                            i13 = i4 + 4;
                            vb3VarD = vb3Var2;
                            h96VarZ = h96Var;
                            lpVar2 = lpVar;
                            listH = list2;
                            i6 = i5;
                            f6 = 2.0f;
                        }
                        list = listH;
                        i = i6;
                        vb3Var = vb3VarD;
                    }
                    vb3.f(vb3Var);
                } else {
                    list = listH;
                    i = i6;
                }
                i6 = i + 1;
                listH = list;
            }
        }
    }

    @Override // defpackage.mp, defpackage.su0
    public void f() {
        np barData = this.h.getBarData();
        this.j = new oi2[barData.f()];
        for (int i = 0; i < this.j.length; i++) {
            lk2 lk2Var = (lk2) barData.e(i);
            this.j[i] = new oi2(lk2Var.K0() * 4 * (lk2Var.K() ? lk2Var.m() : 1), barData.f(), lk2Var.K());
        }
    }

    @Override // defpackage.su0
    public boolean g(j10 j10Var) {
        return ((float) j10Var.getData().i()) < ((float) j10Var.getMaxVisibleCount()) * this.f20113a.s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.mp
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
                RectF rectF = this.n;
                rectF.top = x - fU;
                rectF.bottom = x + fU;
                transformer.p(rectF);
                if (this.f20113a.D(this.n.bottom)) {
                    if (!this.f20113a.A(this.n.top)) {
                        break;
                    }
                    this.n.left = this.f20113a.h();
                    this.n.right = this.f20113a.i();
                    canvas.drawRect(this.n, this.k);
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
            int i4 = i3 + 3;
            if (!this.f20113a.D(lpVar.b[i4])) {
                return;
            }
            int i5 = i3 + 1;
            if (this.f20113a.A(lpVar.b[i5])) {
                if (!z2) {
                    this.c.setColor(lk2Var.z0(i3 / 4));
                }
                float[] fArr = lpVar.b;
                int i6 = i3 + 2;
                canvas.drawRect(fArr[i3], fArr[i5], fArr[i6], fArr[i4], this.c);
                if (z) {
                    float[] fArr2 = lpVar.b;
                    canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i6], fArr2[i4], this.l);
                }
            }
        }
    }

    @Override // defpackage.mp
    public void k(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    @Override // defpackage.mp
    public void l(float f, float f2, float f3, float f4, h16 h16Var) {
        this.i.set(f2, f - f4, f3, f + f4);
        h16Var.o(this.i, this.b.i());
    }

    @Override // defpackage.mp
    public void m(vh2 vh2Var, RectF rectF) {
        vh2Var.m(rectF.centerY(), rectF.right);
    }
}
