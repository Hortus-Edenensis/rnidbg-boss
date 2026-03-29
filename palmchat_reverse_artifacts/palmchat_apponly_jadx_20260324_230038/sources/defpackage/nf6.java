package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nf6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f19506a = new Matrix();
    public RectF b = new RectF();
    public float c = 0.0f;
    public float d = 0.0f;
    public float e = 1.0f;
    public float f = Float.MAX_VALUE;
    public float g = 1.0f;
    public float h = Float.MAX_VALUE;
    public float i = 1.0f;
    public float j = 1.0f;
    public float k = 0.0f;
    public float l = 0.0f;
    public float m = 0.0f;
    public float n = 0.0f;
    public float[] o = new float[9];
    public Matrix p = new Matrix();
    public final float[] q = new float[9];

    public boolean A(float f) {
        return this.b.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public boolean B(float f) {
        return this.b.left <= f + 1.0f;
    }

    public boolean C(float f) {
        return this.b.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean D(float f) {
        return this.b.top <= f;
    }

    public boolean E(float f) {
        return B(f) && C(f);
    }

    public boolean F(float f) {
        return D(f) && A(f);
    }

    public void G(Matrix matrix, RectF rectF) {
        float fWidth;
        float fHeight;
        matrix.getValues(this.q);
        float[] fArr = this.q;
        float f = fArr[2];
        float f2 = fArr[0];
        float f3 = fArr[5];
        float f4 = fArr[4];
        this.i = Math.min(Math.max(this.g, f2), this.h);
        this.j = Math.min(Math.max(this.e, f4), this.f);
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fWidth = 0.0f;
            fHeight = 0.0f;
        }
        this.k = Math.min(Math.max(f, ((-fWidth) * (this.i - 1.0f)) - this.m), this.m);
        float fMax = Math.max(Math.min(f3, (fHeight * (this.j - 1.0f)) + this.n), -this.n);
        this.l = fMax;
        float[] fArr2 = this.q;
        fArr2[2] = this.k;
        fArr2[0] = this.i;
        fArr2[5] = fMax;
        fArr2[4] = this.j;
        matrix.setValues(fArr2);
    }

    public float H() {
        return this.d - this.b.bottom;
    }

    public float I() {
        return this.b.left;
    }

    public float J() {
        return this.c - this.b.right;
    }

    public float K() {
        return this.b.top;
    }

    public Matrix L(Matrix matrix, View view, boolean z) {
        this.f19506a.set(matrix);
        G(this.f19506a, this.b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f19506a);
        return matrix;
    }

    public void M(Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void N(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, this.c - f3, this.d - f4);
    }

    public void O(float f, float f2) {
        float fI = I();
        float fK = K();
        float fJ = J();
        float fH = H();
        this.d = f2;
        this.c = f;
        N(fI, fK, fJ, fH);
    }

    public void P(float f) {
        this.m = s86.e(f);
    }

    public void Q(float f) {
        this.n = s86.e(f);
    }

    public void R(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.h = f;
        G(this.f19506a, this.b);
    }

    public void S(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.f = f;
        G(this.f19506a, this.b);
    }

    public void T(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.g = f;
        this.h = f2;
        G(this.f19506a, this.b);
    }

    public void U(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.e = f;
        this.f = f2;
        G(this.f19506a, this.b);
    }

    public void V(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.g = f;
        G(this.f19506a, this.b);
    }

    public void W(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.e = f;
        G(this.f19506a, this.b);
    }

    public void X(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.setScale(f, f2);
    }

    public void Y(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postTranslate(-(fArr[0] - I()), -(fArr[1] - K()));
    }

    public void Z(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postScale(f, f2, f3, f4);
    }

    public boolean a() {
        return this.i < this.h;
    }

    public void a0(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postScale(f, f2);
    }

    public boolean b() {
        return this.j < this.f;
    }

    public void b0(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postScale(1.4f, 1.4f, f, f2);
    }

    public boolean c() {
        return this.i > this.g;
    }

    public void c0(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postScale(0.7f, 0.7f, f, f2);
    }

    public boolean d() {
        return this.j > this.e;
    }

    public void e(float[] fArr, View view) {
        Matrix matrix = this.p;
        matrix.reset();
        matrix.set(this.f19506a);
        matrix.postTranslate(-(fArr[0] - I()), -(fArr[1] - K()));
        L(matrix, view, true);
    }

    public float f() {
        return this.b.bottom;
    }

    public float g() {
        return this.b.height();
    }

    public float h() {
        return this.b.left;
    }

    public float i() {
        return this.b.right;
    }

    public float j() {
        return this.b.top;
    }

    public float k() {
        return this.b.width();
    }

    public void l(Matrix matrix) {
        this.g = 1.0f;
        this.e = 1.0f;
        matrix.set(this.f19506a);
        float[] fArr = this.o;
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public float m() {
        return this.d;
    }

    public float n() {
        return this.c;
    }

    public vb3 o() {
        return vb3.c(this.b.centerX(), this.b.centerY());
    }

    public RectF p() {
        return this.b;
    }

    public Matrix q() {
        return this.f19506a;
    }

    public float r() {
        return this.i;
    }

    public float s() {
        return this.j;
    }

    public float t() {
        return Math.min(this.b.width(), this.b.height());
    }

    public boolean u() {
        return this.d > 0.0f && this.c > 0.0f;
    }

    public boolean v() {
        return this.m <= 0.0f && this.n <= 0.0f;
    }

    public boolean w() {
        return x() && y();
    }

    public boolean x() {
        float f = this.i;
        float f2 = this.g;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean y() {
        float f = this.j;
        float f2 = this.e;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean z(float f, float f2) {
        return E(f) && F(f2);
    }
}
