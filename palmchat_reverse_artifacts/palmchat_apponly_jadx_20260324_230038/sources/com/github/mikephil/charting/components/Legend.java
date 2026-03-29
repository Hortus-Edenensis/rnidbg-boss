package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import defpackage.at1;
import defpackage.nf6;
import defpackage.s86;
import defpackage.zj0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class Legend extends zj0 {
    public com.github.mikephil.charting.components.a[] h;
    public com.github.mikephil.charting.components.a[] g = new com.github.mikephil.charting.components.a[0];
    public boolean i = false;
    public LegendHorizontalAlignment j = LegendHorizontalAlignment.LEFT;
    public LegendVerticalAlignment k = LegendVerticalAlignment.BOTTOM;
    public LegendOrientation l = LegendOrientation.HORIZONTAL;
    public boolean m = false;
    public LegendDirection n = LegendDirection.LEFT_TO_RIGHT;
    public LegendForm o = LegendForm.SQUARE;
    public float p = 8.0f;
    public float q = 3.0f;
    public DashPathEffect r = null;
    public float s = 6.0f;
    public float t = 0.0f;
    public float u = 5.0f;
    public float v = 3.0f;
    public float w = 0.95f;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;
    public float A = 0.0f;
    public boolean B = false;
    public List<at1> C = new ArrayList(16);
    public List<Boolean> D = new ArrayList(16);
    public List<at1> E = new ArrayList(16);

    /* JADX INFO: compiled from: SearchBox */
    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5813a;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            f5813a = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5813a[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Legend() {
        this.e = s86.e(10.0f);
        this.b = s86.e(5.0f);
        this.c = s86.e(3.0f);
    }

    public float A() {
        return this.s;
    }

    public float B() {
        return this.t;
    }

    public boolean C() {
        return this.m;
    }

    public boolean D() {
        return this.i;
    }

    public void E(List<com.github.mikephil.charting.components.a> list) {
        this.g = (com.github.mikephil.charting.components.a[]) list.toArray(new com.github.mikephil.charting.components.a[list.size()]);
    }

    public void h(Paint paint, nf6 nf6Var) {
        float f;
        float f2;
        float f3;
        float fE = s86.e(this.p);
        float fE2 = s86.e(this.v);
        float fE3 = s86.e(this.u);
        float fE4 = s86.e(this.s);
        float fE5 = s86.e(this.t);
        boolean z = this.B;
        com.github.mikephil.charting.components.a[] aVarArr = this.g;
        int length = aVarArr.length;
        this.A = w(paint);
        this.z = v(paint);
        int i = a.f5813a[this.l.ordinal()];
        if (i == 1) {
            float fK = s86.k(paint);
            float fMax = 0.0f;
            float f4 = 0.0f;
            float fD = 0.0f;
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                com.github.mikephil.charting.components.a aVar = aVarArr[i2];
                boolean z3 = aVar.b != LegendForm.NONE;
                float fE6 = Float.isNaN(aVar.c) ? fE : s86.e(aVar.c);
                String str = aVar.f5814a;
                if (!z2) {
                    fD = 0.0f;
                }
                if (z3) {
                    if (z2) {
                        fD += fE2;
                    }
                    fD += fE6;
                }
                if (str != null) {
                    if (z3 && !z2) {
                        fD += fE3;
                    } else if (z2) {
                        fMax = Math.max(fMax, fD);
                        f4 += fK + fE5;
                        fD = 0.0f;
                        z2 = false;
                    }
                    fD += s86.d(paint, str);
                    if (i2 < length - 1) {
                        f4 += fK + fE5;
                    }
                } else {
                    fD += fE6;
                    if (i2 < length - 1) {
                        fD += fE2;
                    }
                    z2 = true;
                }
                fMax = Math.max(fMax, fD);
            }
            this.x = fMax;
            this.y = f4;
        } else if (i == 2) {
            float fK2 = s86.k(paint);
            float fM = s86.m(paint) + fE5;
            float fK3 = nf6Var.k() * this.w;
            this.D.clear();
            this.C.clear();
            this.E.clear();
            int i3 = 0;
            float fMax2 = 0.0f;
            int i4 = -1;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (i3 < length) {
                com.github.mikephil.charting.components.a aVar2 = aVarArr[i3];
                float f7 = fE;
                float f8 = fE4;
                boolean z4 = aVar2.b != LegendForm.NONE;
                float fE7 = Float.isNaN(aVar2.c) ? f7 : s86.e(aVar2.c);
                String str2 = aVar2.f5814a;
                com.github.mikephil.charting.components.a[] aVarArr2 = aVarArr;
                float f9 = fM;
                this.D.add(Boolean.FALSE);
                float f10 = i4 == -1 ? 0.0f : f5 + fE2;
                if (str2 != null) {
                    f = fE2;
                    this.C.add(s86.b(paint, str2));
                    f2 = f10 + (z4 ? fE3 + fE7 : 0.0f) + this.C.get(i3).c;
                } else {
                    f = fE2;
                    float f11 = fE7;
                    this.C.add(at1.b(0.0f, 0.0f));
                    f2 = f10 + (z4 ? f11 : 0.0f);
                    if (i4 == -1) {
                        i4 = i3;
                    }
                }
                if (str2 != null || i3 == length - 1) {
                    float f12 = f6;
                    float f13 = f12 == 0.0f ? 0.0f : f8;
                    if (!z || f12 == 0.0f || fK3 - f12 >= f13 + f2) {
                        f3 = f12 + f13 + f2;
                    } else {
                        this.E.add(at1.b(f12, fK2));
                        float fMax3 = Math.max(fMax2, f12);
                        this.D.set(i4 > -1 ? i4 : i3, Boolean.TRUE);
                        fMax2 = fMax3;
                        f3 = f2;
                    }
                    if (i3 == length - 1) {
                        this.E.add(at1.b(f3, fK2));
                        fMax2 = Math.max(fMax2, f3);
                    }
                    f6 = f3;
                }
                if (str2 != null) {
                    i4 = -1;
                }
                i3++;
                fE2 = f;
                fE = f7;
                fE4 = f8;
                fM = f9;
                f5 = f2;
                aVarArr = aVarArr2;
            }
            float f14 = fM;
            this.x = fMax2;
            this.y = (fK2 * this.E.size()) + (f14 * (this.E.size() == 0 ? 0 : this.E.size() - 1));
        }
        this.y += this.c;
        this.x += this.b;
    }

    public List<Boolean> i() {
        return this.D;
    }

    public List<at1> j() {
        return this.C;
    }

    public List<at1> k() {
        return this.E;
    }

    public LegendDirection l() {
        return this.n;
    }

    public com.github.mikephil.charting.components.a[] m() {
        return this.g;
    }

    public com.github.mikephil.charting.components.a[] n() {
        return this.h;
    }

    public LegendForm o() {
        return this.o;
    }

    public DashPathEffect p() {
        return this.r;
    }

    public float q() {
        return this.q;
    }

    public float r() {
        return this.p;
    }

    public float s() {
        return this.u;
    }

    public LegendHorizontalAlignment t() {
        return this.j;
    }

    public float u() {
        return this.w;
    }

    public float v(Paint paint) {
        float f = 0.0f;
        for (com.github.mikephil.charting.components.a aVar : this.g) {
            String str = aVar.f5814a;
            if (str != null) {
                float fA = s86.a(paint, str);
                if (fA > f) {
                    f = fA;
                }
            }
        }
        return f;
    }

    public float w(Paint paint) {
        float fE = s86.e(this.u);
        float f = 0.0f;
        float f2 = 0.0f;
        for (com.github.mikephil.charting.components.a aVar : this.g) {
            float fE2 = s86.e(Float.isNaN(aVar.c) ? this.p : aVar.c);
            if (fE2 > f2) {
                f2 = fE2;
            }
            String str = aVar.f5814a;
            if (str != null) {
                float fD = s86.d(paint, str);
                if (fD > f) {
                    f = fD;
                }
            }
        }
        return f + f2 + fE;
    }

    public LegendOrientation x() {
        return this.l;
    }

    public float y() {
        return this.v;
    }

    public LegendVerticalAlignment z() {
        return this.k;
    }
}
