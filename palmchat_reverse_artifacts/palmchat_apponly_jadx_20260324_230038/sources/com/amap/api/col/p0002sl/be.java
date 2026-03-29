package com.amap.api.col.p0002sl;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.col.p0002sl.bi;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class be {
    bi.c p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2635a = 256;
    public int b = 256;
    float c = 1.0f;
    private double q = 116.39716d;
    private double r = 39.91669d;
    public double d = 156543.0339d;
    int e = 0;
    double f = -2.003750834E7d;
    double g = 2.003750834E7d;
    public int h = z.d;
    public int i = z.c;
    public float j = 10.0f;
    public double k = 0.0d;
    public af l = null;
    public af m = null;
    public Point n = null;
    public a o = null;
    private double s = 0.01745329251994329d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f2636a;
        float b;
        float c;
        float d;
    }

    public be(bi.c cVar) {
        this.p = cVar;
    }

    private static PointF b(af afVar, af afVar2, Point point, double d) {
        PointF pointF;
        PointF pointF2 = null;
        if (afVar == null || afVar2 == null) {
            return null;
        }
        try {
            pointF = new PointF();
        } catch (Throwable th) {
            th = th;
        }
        try {
            pointF.x = (float) (((afVar.e() - afVar2.e()) / d) + ((double) point.x));
            pointF.y = (float) (((double) point.y) - ((afVar.f() - afVar2.f()) / d));
            return pointF;
        } catch (Throwable th2) {
            th = th2;
            pointF2 = pointF;
            ct.a(th, "MapProjection", "convertProjectionToScreen");
            return pointF2;
        }
    }

    private double[] c(PointF pointF, PointF pointF2) {
        double d = this.k;
        af afVarB = b(pointF, this.l, this.n, d, this.o);
        af afVarB2 = b(pointF2, this.l, this.n, d, this.o);
        double dE = afVarB2.e() - afVarB.e();
        double dF = afVarB2.f() - afVarB.f();
        double dE2 = this.l.e() + dE;
        double dF2 = this.l.f() + dF;
        while (true) {
            a aVar = this.o;
            float f = aVar.f2636a;
            if (dE2 >= f) {
                break;
            }
            dE2 += (double) (aVar.b - f);
        }
        while (true) {
            a aVar2 = this.o;
            float f2 = aVar2.b;
            if (dE2 <= f2) {
                break;
            }
            dE2 -= (double) (f2 - aVar2.f2636a);
        }
        while (true) {
            a aVar3 = this.o;
            float f3 = aVar3.d;
            if (dF2 >= f3) {
                break;
            }
            dF2 += (double) (aVar3.c - f3);
        }
        while (true) {
            a aVar4 = this.o;
            float f4 = aVar4.c;
            if (dF2 <= f4) {
                return new double[]{dE2, dF2};
            }
            dF2 -= (double) (f4 - aVar4.d);
        }
    }

    public final void a() {
        double d = (this.g * 2.0d) / ((double) this.f2635a);
        this.d = d;
        float f = this.j;
        int i = (int) f;
        this.k = (d / ((double) (1 << i))) / ((double) ((f + 1.0f) - i));
        af afVarA = a(new af(this.r, this.q, true));
        this.l = afVarA;
        this.m = afVarA.g();
        this.n = new Point(bi.c.c() / 2, bi.c.d() / 2);
        a aVar = new a();
        this.o = aVar;
        aVar.f2636a = -2.0037508E7f;
        aVar.b = 2.0037508E7f;
        aVar.c = 2.0037508E7f;
        aVar.d = -2.0037508E7f;
    }

    public static af b(af afVar) {
        if (afVar == null) {
            return null;
        }
        return new af((int) (((double) ((float) (((Math.atan(Math.exp((((double) ((float) ((afVar.f() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d))) * 1000000.0d), (int) (((double) ((float) ((afVar.e() * 180.0d) / 2.003750834E7d))) * 1000000.0d));
    }

    private af b(PointF pointF, af afVar, Point point, double d, a aVar) {
        bi.c cVar = this.p;
        if (cVar == null || pointF == null || afVar == null || point == null || aVar == null) {
            return null;
        }
        PointF pointFB = cVar.g().b(pointF);
        float f = pointFB.x - point.x;
        float f2 = pointFB.y - point.y;
        double dE = afVar.e() + (((double) f) * d);
        double dF = afVar.f() - (((double) f2) * d);
        while (true) {
            float f3 = aVar.f2636a;
            if (dE >= f3) {
                break;
            }
            dE += (double) (aVar.b - f3);
        }
        double d2 = dE;
        while (true) {
            float f4 = aVar.b;
            if (d2 <= f4) {
                break;
            }
            d2 -= (double) (f4 - aVar.f2636a);
        }
        while (true) {
            float f5 = aVar.d;
            if (dF >= f5) {
                break;
            }
            dF += (double) (aVar.c - f5);
        }
        double d3 = dF;
        while (true) {
            float f6 = aVar.c;
            if (d3 > f6) {
                d3 -= (double) (f6 - aVar.d);
            } else {
                return new af(d3, d2, false);
            }
        }
    }

    public final void a(Point point) {
        this.n = point;
    }

    public static af a(af afVar) {
        if (afVar == null) {
            return null;
        }
        double dB = ((double) afVar.b()) / 1000000.0d;
        return new af(((Math.log(Math.tan(((dB + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d, ((((double) afVar.a()) / 1000000.0d) * 2.003750834E7d) / 180.0d, false);
    }

    public final af a(PointF pointF, af afVar, Point point, double d, a aVar) {
        return b(b(pointF, afVar, point, d, aVar));
    }

    public final PointF a(af afVar, af afVar2, Point point, double d) {
        if (this.p == null || afVar == null || afVar2 == null || point == null) {
            return null;
        }
        return this.p.g().a(b(a(afVar), afVar2, point, d));
    }

    public final PointF a(int i, int i2) {
        double d;
        int i3 = this.f2635a;
        double d2 = this.k;
        double d3 = (((double) (i * i3)) * d2) + this.f;
        int i4 = this.e;
        if (i4 == 0) {
            d = this.g - (((double) (i2 * i3)) * d2);
        } else {
            d = i4 == 1 ? ((double) ((i2 + 1) * i3)) * d2 : 0.0d;
        }
        return b(new af(d, d3, false), this.l, this.n, this.k);
    }

    public final int b() {
        float f = this.j;
        int i = (int) f;
        return ((double) (f - ((float) i))) < bi.f2640a ? i : i + 1;
    }

    public final ArrayList<cb> a(af afVar, int i, int i2) {
        double d;
        int i3;
        int i4;
        double d2 = this.k;
        double dE = afVar.e();
        double d3 = this.f;
        int i5 = this.f2635a;
        int i6 = (int) ((dE - d3) / (((double) i5) * d2));
        double d4 = (((double) (i5 * i6)) * d2) + d3;
        int i7 = this.e;
        if (i7 == 0) {
            double dF = this.g - afVar.f();
            int i8 = this.f2635a;
            int i9 = (int) (dF / (((double) i8) * d2));
            i3 = i9;
            d = this.g - (((double) (i8 * i9)) * d2);
        } else if (i7 == 1) {
            double dF2 = afVar.f() - this.g;
            int i10 = this.f2635a;
            int i11 = (int) (dF2 / (((double) i10) * d2));
            i3 = i11;
            d = ((double) ((i11 + 1) * i10)) * d2;
        } else {
            d = 0.0d;
            i3 = 0;
        }
        PointF pointFB = b(new af(d, d4, false), afVar, this.n, d2);
        cb cbVar = new cb(i6, i3, b(), -1);
        cbVar.g = pointFB;
        ArrayList<cb> arrayList = new ArrayList<>();
        arrayList.add(cbVar);
        int i12 = 1;
        while (true) {
            int i13 = i6 - i12;
            int i14 = i13;
            boolean z = false;
            while (true) {
                i4 = i6 + i12;
                if (i14 > i4) {
                    break;
                }
                int i15 = i3 + i12;
                int i16 = i3;
                try {
                    PointF pointFA = a(i14, i15, i6, i3, pointFB, i, i2);
                    if (pointFA != null) {
                        boolean z2 = !z ? true : z;
                        cb cbVar2 = new cb(i14, i15, b(), -1);
                        cbVar2.g = pointFA;
                        arrayList.add(cbVar2);
                        z = z2;
                    }
                    int i17 = i16 - i12;
                    PointF pointFA2 = a(i14, i17, i6, i16, pointFB, i, i2);
                    if (pointFA2 != null) {
                        boolean z3 = !z ? true : z;
                        cb cbVar3 = new cb(i14, i17, b(), -1);
                        cbVar3.g = pointFA2;
                        arrayList.add(cbVar3);
                        z = z3;
                    }
                    i14++;
                    i3 = i16;
                } catch (Error e) {
                    ct.a(e, "MapProjection", "getTilesInDomain");
                }
            }
            int i18 = i3;
            int i19 = (i18 + i12) - 1;
            while (i19 > i18 - i12) {
                int i20 = i4;
                PointF pointFA3 = a(i4, i19, i6, i18, pointFB, i, i2);
                if (pointFA3 != null) {
                    boolean z4 = !z ? true : z;
                    cb cbVar4 = new cb(i20, i19, b(), -1);
                    cbVar4.g = pointFA3;
                    arrayList.add(cbVar4);
                    z = z4;
                }
                PointF pointFA4 = a(i13, i19, i6, i18, pointFB, i, i2);
                if (pointFA4 != null) {
                    boolean z5 = !z ? true : z;
                    cb cbVar5 = new cb(i13, i19, b(), -1);
                    cbVar5.g = pointFA4;
                    arrayList.add(cbVar5);
                    z = z5;
                }
                i19--;
                i4 = i20;
            }
            if (!z) {
                break;
            }
            i12++;
            i3 = i18;
        }
        return arrayList;
    }

    public final af b(PointF pointF, PointF pointF2) {
        double[] dArrC = c(pointF, pointF2);
        af afVar = new af(this.l.b(), this.l.a());
        afVar.b(dArrC[1]);
        afVar.a(dArrC[0]);
        return afVar;
    }

    private PointF a(int i, int i2, int i3, int i4, PointF pointF, int i5, int i6) {
        PointF pointF2 = new PointF();
        int i7 = i - i3;
        int i8 = this.f2635a;
        float f = (i7 * i8) + pointF.x;
        pointF2.x = f;
        int i9 = this.e;
        if (i9 == 0) {
            pointF2.y = ((i2 - i4) * i8) + pointF.y;
        } else if (i9 == 1) {
            pointF2.y = pointF.y - ((i2 - i4) * i8);
        }
        if (i8 + f <= 0.0f || f >= i5) {
            return null;
        }
        float f2 = pointF2.y;
        if (i8 + f2 <= 0.0f || f2 >= i6) {
            return null;
        }
        return pointF2;
    }

    public final void a(PointF pointF, PointF pointF2) {
        if (this.l == null) {
            return;
        }
        double[] dArrC = c(pointF, pointF2);
        this.l.b(dArrC[1]);
        this.l.a(dArrC[0]);
    }

    public final float a(af afVar, af afVar2) {
        if (afVar == null || afVar2 == null) {
            return 0.0f;
        }
        double dA = aa.a(afVar.c());
        double dA2 = aa.a(afVar.d());
        double dA3 = aa.a(afVar2.c());
        double dA4 = aa.a(afVar2.d());
        double d = this.s;
        double d2 = dA * d;
        double d3 = dA2 * d;
        double d4 = dA3 * d;
        double d5 = dA4 * d;
        double dSin = Math.sin(d2);
        double dSin2 = Math.sin(d3);
        double dCos = Math.cos(d2);
        double dCos2 = Math.cos(d3);
        double dSin3 = Math.sin(d4);
        double dSin4 = Math.sin(d5);
        double dCos3 = Math.cos(d4);
        double dCos4 = Math.cos(d5);
        double[] dArr = {dCos * dCos2, dCos2 * dSin, dSin2};
        double d6 = dCos3 * dCos4;
        double d7 = dCos4 * dSin3;
        double d8 = dArr[0];
        double d9 = (d8 - d6) * (d8 - d6);
        double d10 = dArr[1];
        double d11 = dArr[2];
        return (float) (Math.asin(Math.sqrt((d9 + ((d10 - d7) * (d10 - d7))) + ((d11 - dSin4) * (d11 - dSin4))) / 2.0d) * 1.27420015798544E7d);
    }
}
