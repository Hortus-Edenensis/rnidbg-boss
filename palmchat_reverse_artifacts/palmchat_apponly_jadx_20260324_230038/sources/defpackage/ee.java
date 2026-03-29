package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"NewApi"})
public class ee extends de {
    public static l54<ee> t = l54.a(8, new ee(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));
    public float m;
    public float n;
    public float o;
    public float p;
    public YAxis q;
    public float r;
    public Matrix s;

    @SuppressLint({"NewApi"})
    public ee(nf6 nf6Var, View view, h16 h16Var, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
        super(nf6Var, f2, f3, h16Var, view, f4, f5, j);
        this.s = new Matrix();
        this.o = f6;
        this.p = f7;
        this.m = f8;
        this.n = f9;
        this.i.addListener(this);
        this.q = yAxis;
        this.r = f;
    }

    public static ee d(nf6 nf6Var, View view, h16 h16Var, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
        ee eeVar = (ee) t.b();
        eeVar.d = nf6Var;
        eeVar.e = f2;
        eeVar.f = f3;
        eeVar.g = h16Var;
        eeVar.h = view;
        eeVar.k = f4;
        eeVar.l = f5;
        eeVar.q = yAxis;
        eeVar.r = f;
        eeVar.c();
        eeVar.i.setDuration(j);
        return eeVar;
    }

    @Override // l54.a
    public l54.a a() {
        return new ee(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // defpackage.de, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.h).calculateOffsets();
        this.h.postInvalidate();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = this.k;
        float f2 = this.e - f;
        float f3 = this.j;
        float f4 = f + (f2 * f3);
        float f5 = this.l;
        float f6 = f5 + ((this.f - f5) * f3);
        Matrix matrix = this.s;
        this.d.X(f4, f6, matrix);
        this.d.L(matrix, this.h, false);
        float fS = this.q.I / this.d.s();
        float fR = this.r / this.d.r();
        float[] fArr = this.c;
        float f7 = this.m;
        float f8 = (this.o - (fR / 2.0f)) - f7;
        float f9 = this.j;
        fArr[0] = f7 + (f8 * f9);
        float f10 = this.n;
        fArr[1] = f10 + (((this.p + (fS / 2.0f)) - f10) * f9);
        this.g.k(fArr);
        this.d.Y(this.c, matrix);
        this.d.L(matrix, this.h, true);
    }

    @Override // defpackage.de
    public void b() {
    }

    @Override // defpackage.de, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // defpackage.de, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // defpackage.de, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
