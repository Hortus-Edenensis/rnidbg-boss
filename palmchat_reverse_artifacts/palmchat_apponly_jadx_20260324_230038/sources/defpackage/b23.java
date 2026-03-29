package defpackage;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b23 extends pv4 {
    public Paint b;
    public Paint c;
    public Legend d;
    public List<com.github.mikephil.charting.components.a> e;
    public Paint.FontMetrics f;
    public Path g;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1634a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            d = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            c = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            b = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            f1634a = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1634a[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1634a[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public b23(nf6 nf6Var, Legend legend) {
        super(nf6Var);
        this.e = new ArrayList(16);
        this.f = new Paint.FontMetrics();
        this.g = new Path();
        this.d = legend;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setTextSize(s86.e(9.0f));
        this.b.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(h10<?> h10Var) {
        h10<?> h10Var2;
        h10<?> h10Var3 = h10Var;
        if (!this.d.D()) {
            this.e.clear();
            int i = 0;
            while (i < h10Var.f()) {
                kl2 kl2VarE = h10Var3.e(i);
                List<Integer> listE0 = kl2VarE.e0();
                int iK0 = kl2VarE.K0();
                if (kl2VarE instanceof lk2) {
                    lk2 lk2Var = (lk2) kl2VarE;
                    if (lk2Var.K()) {
                        String[] strArrL = lk2Var.L();
                        for (int i2 = 0; i2 < listE0.size() && i2 < lk2Var.m(); i2++) {
                            this.e.add(new com.github.mikephil.charting.components.a(strArrL[i2 % strArrL.length], kl2VarE.d(), kl2VarE.i(), kl2VarE.E(), kl2VarE.A(), listE0.get(i2).intValue()));
                        }
                        if (lk2Var.getLabel() != null) {
                            this.e.add(new com.github.mikephil.charting.components.a(kl2VarE.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                        }
                        h10Var2 = h10Var3;
                    } else {
                        if (kl2VarE instanceof ao2) {
                            ao2 ao2Var = (ao2) kl2VarE;
                            for (int i3 = 0; i3 < listE0.size() && i3 < iK0; i3++) {
                                this.e.add(new com.github.mikephil.charting.components.a(ao2Var.h(i3).getLabel(), kl2VarE.d(), kl2VarE.i(), kl2VarE.E(), kl2VarE.A(), listE0.get(i3).intValue()));
                            }
                            if (ao2Var.getLabel() != null) {
                                this.e.add(new com.github.mikephil.charting.components.a(kl2VarE.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                            }
                        } else if (kl2VarE instanceof rk2) {
                            rk2 rk2Var = (rk2) kl2VarE;
                            if (rk2Var.Q() != 1122867) {
                                int iQ = rk2Var.Q();
                                int iS = rk2Var.s();
                                this.e.add(new com.github.mikephil.charting.components.a(null, kl2VarE.d(), kl2VarE.i(), kl2VarE.E(), kl2VarE.A(), iQ));
                                this.e.add(new com.github.mikephil.charting.components.a(kl2VarE.getLabel(), kl2VarE.d(), kl2VarE.i(), kl2VarE.E(), kl2VarE.A(), iS));
                            } else {
                                int i4 = 0;
                                while (i4 < listE0.size() && i4 < iK0) {
                                    this.e.add(new com.github.mikephil.charting.components.a((i4 >= listE0.size() + (-1) || i4 >= iK0 + (-1)) ? h10Var.e(i).getLabel() : null, kl2VarE.d(), kl2VarE.i(), kl2VarE.E(), kl2VarE.A(), listE0.get(i4).intValue()));
                                    i4++;
                                }
                            }
                        }
                        h10Var2 = h10Var;
                    }
                }
                i++;
                h10Var3 = h10Var2;
            }
            if (this.d.n() != null) {
                Collections.addAll(this.e, this.d.n());
            }
            this.d.E(this.e);
        }
        Typeface typefaceC = this.d.c();
        if (typefaceC != null) {
            this.b.setTypeface(typefaceC);
        }
        this.b.setTextSize(this.d.b());
        this.b.setColor(this.d.a());
        this.d.h(this.b, this.f20113a);
    }

    public void b(Canvas canvas, float f, float f2, com.github.mikephil.charting.components.a aVar, Legend legend) {
        int i = aVar.f;
        if (i == 1122868 || i == 1122867 || i == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm legendFormO = aVar.b;
        if (legendFormO == Legend.LegendForm.DEFAULT) {
            legendFormO = legend.o();
        }
        this.c.setColor(aVar.f);
        float fE = s86.e(Float.isNaN(aVar.c) ? legend.r() : aVar.c);
        float f3 = fE / 2.0f;
        int i2 = a.d[legendFormO.ordinal()];
        if (i2 == 3 || i2 == 4) {
            this.c.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f3, f2, f3, this.c);
        } else if (i2 == 5) {
            this.c.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, f2 - f3, f + fE, f2 + f3, this.c);
        } else if (i2 == 6) {
            float fE2 = s86.e(Float.isNaN(aVar.d) ? legend.q() : aVar.d);
            DashPathEffect dashPathEffectP = aVar.e;
            if (dashPathEffectP == null) {
                dashPathEffectP = legend.p();
            }
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(fE2);
            this.c.setPathEffect(dashPathEffectP);
            this.g.reset();
            this.g.moveTo(f, f2);
            this.g.lineTo(f + fE, f2);
            canvas.drawPath(this.g, this.c);
        }
        canvas.restoreToCount(iSave);
    }

    public void c(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.b);
    }

    public Paint d() {
        return this.b;
    }

    public void e(Canvas canvas) {
        float f;
        float f2;
        float fN;
        float f3;
        float f4;
        List<Boolean> list;
        List<at1> list2;
        int i;
        float f5;
        float f6;
        float f7;
        float f8;
        float fJ;
        float f9;
        float f10;
        float f11;
        Legend.LegendDirection legendDirection;
        com.github.mikephil.charting.components.a aVar;
        float fD;
        double d;
        if (this.d.f()) {
            Typeface typefaceC = this.d.c();
            if (typefaceC != null) {
                this.b.setTypeface(typefaceC);
            }
            this.b.setTextSize(this.d.b());
            this.b.setColor(this.d.a());
            float fL = s86.l(this.b, this.f);
            float fN2 = s86.n(this.b, this.f) + s86.e(this.d.B());
            float fA = fL - (s86.a(this.b, "ABC") / 2.0f);
            com.github.mikephil.charting.components.a[] aVarArrM = this.d.m();
            float fE = s86.e(this.d.s());
            float fE2 = s86.e(this.d.A());
            Legend.LegendOrientation legendOrientationX = this.d.x();
            Legend.LegendHorizontalAlignment legendHorizontalAlignmentT = this.d.t();
            Legend.LegendVerticalAlignment legendVerticalAlignmentZ = this.d.z();
            Legend.LegendDirection legendDirectionL = this.d.l();
            float fE3 = s86.e(this.d.r());
            float fE4 = s86.e(this.d.y());
            float fE5 = this.d.e();
            float fD2 = this.d.d();
            int i2 = a.f1634a[legendHorizontalAlignmentT.ordinal()];
            float f12 = fE4;
            float f13 = fE2;
            if (i2 == 1) {
                f = fL;
                f2 = fN2;
                if (legendOrientationX != Legend.LegendOrientation.VERTICAL) {
                    fD2 += this.f20113a.h();
                }
                fN = legendDirectionL == Legend.LegendDirection.RIGHT_TO_LEFT ? fD2 + this.d.x : fD2;
            } else if (i2 == 2) {
                f = fL;
                f2 = fN2;
                fN = (legendOrientationX == Legend.LegendOrientation.VERTICAL ? this.f20113a.n() : this.f20113a.i()) - fD2;
                if (legendDirectionL == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    fN -= this.d.x;
                }
            } else if (i2 != 3) {
                f = fL;
                f2 = fN2;
                fN = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                float fN3 = legendOrientationX == legendOrientation ? this.f20113a.n() / 2.0f : this.f20113a.h() + (this.f20113a.k() / 2.0f);
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f2 = fN2;
                fN = fN3 + (legendDirectionL == legendDirection2 ? fD2 : -fD2);
                if (legendOrientationX == legendOrientation) {
                    double d2 = fN;
                    if (legendDirectionL == legendDirection2) {
                        f = fL;
                        d = (((double) (-this.d.x)) / 2.0d) + ((double) fD2);
                    } else {
                        f = fL;
                        d = (((double) this.d.x) / 2.0d) - ((double) fD2);
                    }
                    fN = (float) (d2 + d);
                } else {
                    f = fL;
                }
            }
            int i3 = a.c[legendOrientationX.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                int i4 = a.b[legendVerticalAlignmentZ.ordinal()];
                if (i4 == 1) {
                    fJ = (legendHorizontalAlignmentT == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.f20113a.j()) + fE5;
                } else if (i4 == 2) {
                    fJ = (legendHorizontalAlignmentT == Legend.LegendHorizontalAlignment.CENTER ? this.f20113a.m() : this.f20113a.f()) - (this.d.y + fE5);
                } else if (i4 != 3) {
                    fJ = 0.0f;
                } else {
                    float fM = this.f20113a.m() / 2.0f;
                    Legend legend = this.d;
                    fJ = (fM - (legend.y / 2.0f)) + legend.e();
                }
                float f14 = fJ;
                boolean z = false;
                int i5 = 0;
                float f15 = 0.0f;
                while (i5 < aVarArrM.length) {
                    com.github.mikephil.charting.components.a aVar2 = aVarArrM[i5];
                    boolean z2 = aVar2.b != Legend.LegendForm.NONE;
                    float fE6 = Float.isNaN(aVar2.c) ? fE3 : s86.e(aVar2.c);
                    if (z2) {
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        fD = legendDirectionL == legendDirection3 ? fN + f15 : fN - (fE6 - f15);
                        f10 = fA;
                        f11 = f12;
                        f9 = fN;
                        legendDirection = legendDirectionL;
                        b(canvas, fD, f14 + fA, aVar2, this.d);
                        if (legendDirection == legendDirection3) {
                            fD += fE6;
                        }
                        aVar = aVar2;
                    } else {
                        f9 = fN;
                        f10 = fA;
                        f11 = f12;
                        legendDirection = legendDirectionL;
                        aVar = aVar2;
                        fD = f9;
                    }
                    if (aVar.f5814a != null) {
                        if (z2 && !z) {
                            fD += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? fE : -fE;
                        } else if (z) {
                            fD = f9;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fD -= s86.d(this.b, r1);
                        }
                        float f16 = fD;
                        if (z) {
                            f14 += f + f2;
                            c(canvas, f16, f14 + f, aVar.f5814a);
                        } else {
                            c(canvas, f16, f14 + f, aVar.f5814a);
                        }
                        f14 += f + f2;
                        f15 = 0.0f;
                    } else {
                        f15 += fE6 + f11;
                        z = true;
                    }
                    i5++;
                    legendDirectionL = legendDirection;
                    f12 = f11;
                    fA = f10;
                    fN = f9;
                }
                return;
            }
            float f17 = fN;
            float f18 = f12;
            List<at1> listK = this.d.k();
            List<at1> listJ = this.d.j();
            List<Boolean> listI = this.d.i();
            int i6 = a.b[legendVerticalAlignmentZ.ordinal()];
            if (i6 != 1) {
                fE5 = i6 != 2 ? i6 != 3 ? 0.0f : fE5 + ((this.f20113a.m() - this.d.y) / 2.0f) : (this.f20113a.m() - fE5) - this.d.y;
            }
            int length = aVarArrM.length;
            float f19 = f17;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                float f20 = f18;
                com.github.mikephil.charting.components.a aVar3 = aVarArrM[i7];
                float f21 = f19;
                int i9 = length;
                boolean z3 = aVar3.b != Legend.LegendForm.NONE;
                float fE7 = Float.isNaN(aVar3.c) ? fE3 : s86.e(aVar3.c);
                if (i7 >= listI.size() || !listI.get(i7).booleanValue()) {
                    f3 = f21;
                    f4 = fE5;
                } else {
                    f4 = fE5 + f + f2;
                    f3 = f17;
                }
                if (f3 == f17 && legendHorizontalAlignmentT == Legend.LegendHorizontalAlignment.CENTER && i8 < listK.size()) {
                    f3 += (legendDirectionL == Legend.LegendDirection.RIGHT_TO_LEFT ? listK.get(i8).c : -listK.get(i8).c) / 2.0f;
                    i8++;
                }
                int i10 = i8;
                boolean z4 = aVar3.f5814a == null;
                if (z3) {
                    if (legendDirectionL == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f3 -= fE7;
                    }
                    float f22 = f3;
                    list2 = listK;
                    i = i7;
                    list = listI;
                    b(canvas, f22, f4 + fA, aVar3, this.d);
                    f3 = legendDirectionL == Legend.LegendDirection.LEFT_TO_RIGHT ? f22 + fE7 : f22;
                } else {
                    list = listI;
                    list2 = listK;
                    i = i7;
                }
                if (z4) {
                    f5 = f13;
                    if (legendDirectionL == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f6 = f20;
                        f7 = -f6;
                    } else {
                        f6 = f20;
                        f7 = f6;
                    }
                    f19 = f3 + f7;
                } else {
                    if (z3) {
                        f3 += legendDirectionL == Legend.LegendDirection.RIGHT_TO_LEFT ? -fE : fE;
                    }
                    Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (legendDirectionL == legendDirection4) {
                        f3 -= listJ.get(i).c;
                    }
                    c(canvas, f3, f4 + f, aVar3.f5814a);
                    if (legendDirectionL == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f3 += listJ.get(i).c;
                    }
                    if (legendDirectionL == legendDirection4) {
                        f5 = f13;
                        f8 = -f5;
                    } else {
                        f5 = f13;
                        f8 = f5;
                    }
                    f19 = f3 + f8;
                    f6 = f20;
                }
                f13 = f5;
                f18 = f6;
                i7 = i + 1;
                fE5 = f4;
                length = i9;
                i8 = i10;
                listK = list2;
                listI = list;
            }
        }
    }
}
