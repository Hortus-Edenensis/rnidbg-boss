package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.CandleEntry;
import defpackage.tp;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jz extends u23 {
    public iz i;
    public float[] j;
    public float[] k;
    public float[] l;
    public float[] m;
    public float[] n;

    public jz(iz izVar, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.j = new float[8];
        this.k = new float[4];
        this.l = new float[4];
        this.m = new float[4];
        this.n = new float[4];
        this.i = izVar;
    }

    @Override // defpackage.su0
    public void b(Canvas canvas) {
        for (T t : this.i.getCandleData().h()) {
            if (t.isVisible()) {
                k(canvas, t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        hz candleData = this.i.getCandleData();
        for (vh2 vh2Var : vh2VarArr) {
            jm2 jm2Var = (rk2) candleData.e(vh2Var.d());
            if (jm2Var != null && jm2Var.O()) {
                CandleEntry candleEntry = (CandleEntry) jm2Var.o0(vh2Var.h(), vh2Var.j());
                if (h(candleEntry, jm2Var)) {
                    ub3 ub3VarE = this.i.getTransformer(jm2Var.i0()).e(candleEntry.getX(), ((candleEntry.getLow() * this.b.i()) + (candleEntry.getHigh() * this.b.i())) / 2.0f);
                    vh2Var.m((float) ub3VarE.c, (float) ub3VarE.d);
                    j(canvas, (float) ub3VarE.c, (float) ub3VarE.d, jm2Var);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void e(Canvas canvas) {
        rk2 rk2Var;
        CandleEntry candleEntry;
        float f;
        if (g(this.i)) {
            List<T> listH = this.i.getCandleData().h();
            for (int i = 0; i < listH.size(); i++) {
                rk2 rk2Var2 = (rk2) listH.get(i);
                if (i(rk2Var2) && rk2Var2.K0() >= 1) {
                    a(rk2Var2);
                    h16 transformer = this.i.getTransformer(rk2Var2.i0());
                    this.g.a(this.i, rk2Var2);
                    float fH = this.b.h();
                    float fI = this.b.i();
                    tp.a aVar = this.g;
                    float[] fArrB = transformer.b(rk2Var2, fH, fI, aVar.f21030a, aVar.b);
                    float fE = s86.e(5.0f);
                    h96 h96VarZ = rk2Var2.Z();
                    vb3 vb3VarD = vb3.d(rk2Var2.L0());
                    vb3VarD.c = s86.e(vb3VarD.c);
                    vb3VarD.d = s86.e(vb3VarD.d);
                    int i2 = 0;
                    while (i2 < fArrB.length) {
                        float f2 = fArrB[i2];
                        float f3 = fArrB[i2 + 1];
                        if (!this.f20113a.C(f2)) {
                            break;
                        }
                        if (this.f20113a.B(f2) && this.f20113a.F(f3)) {
                            int i3 = i2 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) rk2Var2.h(this.g.f21030a + i3);
                            if (rk2Var2.h0()) {
                                candleEntry = candleEntry2;
                                f = f3;
                                rk2Var = rk2Var2;
                                l(canvas, h96VarZ.e(candleEntry2), f2, f3 - fE, rk2Var2.l(i3));
                            } else {
                                candleEntry = candleEntry2;
                                f = f3;
                                rk2Var = rk2Var2;
                            }
                            if (candleEntry.getIcon() != null && rk2Var.B()) {
                                Drawable icon = candleEntry.getIcon();
                                s86.f(canvas, icon, (int) (f2 + vb3VarD.c), (int) (f + vb3VarD.d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        } else {
                            rk2Var = rk2Var2;
                        }
                        i2 += 2;
                        rk2Var2 = rk2Var;
                    }
                    vb3.f(vb3VarD);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(Canvas canvas, rk2 rk2Var) {
        h16 transformer = this.i.getTransformer(rk2Var.i0());
        float fI = this.b.i();
        float fU0 = rk2Var.u0();
        boolean zT = rk2Var.t();
        this.g.a(this.i, rk2Var);
        this.c.setStrokeWidth(rk2Var.n0());
        int i = this.g.f21030a;
        while (true) {
            tp.a aVar = this.g;
            if (i > aVar.c + aVar.f21030a) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) rk2Var.h(i);
            if (candleEntry != null) {
                float x = candleEntry.getX();
                float open = candleEntry.getOpen();
                float close = candleEntry.getClose();
                float high = candleEntry.getHigh();
                float low = candleEntry.getLow();
                if (zT) {
                    float[] fArr = this.j;
                    fArr[0] = x;
                    fArr[2] = x;
                    fArr[4] = x;
                    fArr[6] = x;
                    if (open > close) {
                        fArr[1] = high * fI;
                        fArr[3] = open * fI;
                        fArr[5] = low * fI;
                        fArr[7] = close * fI;
                    } else if (open < close) {
                        fArr[1] = high * fI;
                        fArr[3] = close * fI;
                        fArr[5] = low * fI;
                        fArr[7] = open * fI;
                    } else {
                        fArr[1] = high * fI;
                        float f = open * fI;
                        fArr[3] = f;
                        fArr[5] = low * fI;
                        fArr[7] = f;
                    }
                    transformer.k(fArr);
                    if (!rk2Var.d0()) {
                        this.c.setColor(rk2Var.I0() == 1122867 ? rk2Var.z0(i) : rk2Var.I0());
                    } else if (open > close) {
                        this.c.setColor(rk2Var.Q() == 1122867 ? rk2Var.z0(i) : rk2Var.Q());
                    } else if (open < close) {
                        this.c.setColor(rk2Var.s() == 1122867 ? rk2Var.z0(i) : rk2Var.s());
                    } else {
                        this.c.setColor(rk2Var.k0() == 1122867 ? rk2Var.z0(i) : rk2Var.k0());
                    }
                    this.c.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.j, this.c);
                    float[] fArr2 = this.k;
                    fArr2[0] = (x - 0.5f) + fU0;
                    fArr2[1] = close * fI;
                    fArr2[2] = (x + 0.5f) - fU0;
                    fArr2[3] = open * fI;
                    transformer.k(fArr2);
                    if (open > close) {
                        if (rk2Var.Q() == 1122867) {
                            this.c.setColor(rk2Var.z0(i));
                        } else {
                            this.c.setColor(rk2Var.Q());
                        }
                        this.c.setStyle(rk2Var.s0());
                        float[] fArr3 = this.k;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.c);
                    } else if (open < close) {
                        if (rk2Var.s() == 1122867) {
                            this.c.setColor(rk2Var.z0(i));
                        } else {
                            this.c.setColor(rk2Var.s());
                        }
                        this.c.setStyle(rk2Var.G());
                        float[] fArr4 = this.k;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.c);
                    } else {
                        if (rk2Var.k0() == 1122867) {
                            this.c.setColor(rk2Var.z0(i));
                        } else {
                            this.c.setColor(rk2Var.k0());
                        }
                        float[] fArr5 = this.k;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.c);
                    }
                } else {
                    float[] fArr6 = this.l;
                    fArr6[0] = x;
                    fArr6[1] = high * fI;
                    fArr6[2] = x;
                    fArr6[3] = low * fI;
                    float[] fArr7 = this.m;
                    fArr7[0] = (x - 0.5f) + fU0;
                    float f2 = open * fI;
                    fArr7[1] = f2;
                    fArr7[2] = x;
                    fArr7[3] = f2;
                    float[] fArr8 = this.n;
                    fArr8[0] = (0.5f + x) - fU0;
                    float f3 = close * fI;
                    fArr8[1] = f3;
                    fArr8[2] = x;
                    fArr8[3] = f3;
                    transformer.k(fArr6);
                    transformer.k(this.m);
                    transformer.k(this.n);
                    this.c.setColor(open > close ? rk2Var.Q() == 1122867 ? rk2Var.z0(i) : rk2Var.Q() : open < close ? rk2Var.s() == 1122867 ? rk2Var.z0(i) : rk2Var.s() : rk2Var.k0() == 1122867 ? rk2Var.z0(i) : rk2Var.k0());
                    float[] fArr9 = this.l;
                    canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.c);
                    float[] fArr10 = this.m;
                    canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.c);
                    float[] fArr11 = this.n;
                    canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.c);
                }
            }
            i++;
        }
    }

    public void l(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    @Override // defpackage.su0
    public void f() {
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
    }
}
