package defpackage;

import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class oi2 extends lp {
    public oi2(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.lp
    public void e(lk2 lk2Var) {
        float f;
        float fAbs;
        float fAbs2;
        float f2;
        float fK0 = lk2Var.K0() * this.c;
        float f3 = this.k / 2.0f;
        for (int i = 0; i < fK0; i++) {
            BarEntry barEntry = (BarEntry) lk2Var.h(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.i || yVals == null) {
                    float f4 = x - f3;
                    float f5 = x + f3;
                    if (this.j) {
                        f = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    } else {
                        float f6 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                        float f7 = y;
                        y = f6;
                        f = f7;
                    }
                    if (y > 0.0f) {
                        y *= this.d;
                    } else {
                        f *= this.d;
                    }
                    d(f, f5, y, f4);
                } else {
                    float f8 = -barEntry.getNegativeSum();
                    int i2 = 0;
                    float f9 = 0.0f;
                    while (i2 < yVals.length) {
                        float f10 = yVals[i2];
                        if (f10 >= 0.0f) {
                            fAbs = f10 + f9;
                            fAbs2 = f8;
                            f8 = f9;
                            f9 = fAbs;
                        } else {
                            fAbs = Math.abs(f10) + f8;
                            fAbs2 = Math.abs(f10) + f8;
                        }
                        float f11 = x - f3;
                        float f12 = x + f3;
                        if (this.j) {
                            f2 = f8 >= fAbs ? f8 : fAbs;
                            if (f8 > fAbs) {
                                f8 = fAbs;
                            }
                        } else {
                            float f13 = f8 >= fAbs ? f8 : fAbs;
                            if (f8 > fAbs) {
                                f8 = fAbs;
                            }
                            float f14 = f8;
                            f8 = f13;
                            f2 = f14;
                        }
                        float f15 = this.d;
                        d(f2 * f15, f12, f8 * f15, f11);
                        i2++;
                        f8 = fAbs2;
                    }
                }
            }
        }
        a();
    }
}
