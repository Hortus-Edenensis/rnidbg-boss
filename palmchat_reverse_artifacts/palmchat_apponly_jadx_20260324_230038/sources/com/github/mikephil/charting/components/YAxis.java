package com.github.mikephil.charting.components;

import android.graphics.Paint;
import defpackage.jn;
import defpackage.s86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class YAxis extends jn {
    public AxisDependency U;
    public boolean J = true;
    public boolean K = true;
    public boolean L = false;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;
    public int P = -7829368;
    public float Q = 1.0f;
    public float R = 10.0f;
    public float S = 10.0f;
    public YAxisLabelPosition T = YAxisLabelPosition.OUTSIDE_CHART;
    public float V = 0.0f;
    public float W = Float.POSITIVE_INFINITY;

    /* JADX INFO: compiled from: SearchBox */
    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis(AxisDependency axisDependency) {
        this.U = axisDependency;
        this.c = 0.0f;
    }

    public AxisDependency H() {
        return this.U;
    }

    public YAxisLabelPosition I() {
        return this.T;
    }

    public float J() {
        return this.W;
    }

    public float K() {
        return this.V;
    }

    public float L(Paint paint) {
        paint.setTextSize(this.e);
        return s86.a(paint, t()) + (e() * 2.0f);
    }

    public float M(Paint paint) {
        paint.setTextSize(this.e);
        float fD = s86.d(paint, t()) + (d() * 2.0f);
        float fK = K();
        float fJ = J();
        if (fK > 0.0f) {
            fK = s86.e(fK);
        }
        if (fJ > 0.0f && fJ != Float.POSITIVE_INFINITY) {
            fJ = s86.e(fJ);
        }
        if (fJ <= 0.0d) {
            fJ = fD;
        }
        return Math.max(fK, Math.min(fD, fJ));
    }

    public float N() {
        return this.S;
    }

    public float O() {
        return this.R;
    }

    public int P() {
        return this.P;
    }

    public float Q() {
        return this.Q;
    }

    public boolean R() {
        return this.J;
    }

    public boolean S() {
        return this.K;
    }

    public boolean T() {
        return this.M;
    }

    public boolean U() {
        return this.L;
    }

    public boolean V() {
        return f() && z() && I() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    @Override // defpackage.jn
    public void h(float f, float f2) {
        if (Math.abs(f2 - f) == 0.0f) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        float fAbs = Math.abs(f2 - f);
        this.H = this.E ? this.H : f - ((fAbs / 100.0f) * N());
        float fO = this.F ? this.G : f2 + ((fAbs / 100.0f) * O());
        this.G = fO;
        this.I = Math.abs(this.H - fO);
    }
}
