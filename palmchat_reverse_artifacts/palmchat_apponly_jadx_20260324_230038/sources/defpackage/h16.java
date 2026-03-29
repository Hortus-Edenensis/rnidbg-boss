package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class h16 {
    public nf6 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Matrix f17852a = new Matrix();
    public Matrix b = new Matrix();
    public float[] d = new float[1];
    public float[] e = new float[1];
    public float[] f = new float[1];
    public float[] g = new float[1];
    public Matrix h = new Matrix();
    public float[] i = new float[2];
    public Matrix j = new Matrix();
    public Matrix k = new Matrix();

    public h16(nf6 nf6Var) {
        this.c = nf6Var;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry, fq] */
    public float[] a(ok2 ok2Var, float f, int i, int i2) {
        int i3 = ((i2 - i) + 1) * 2;
        if (this.e.length != i3) {
            this.e = new float[i3];
        }
        float[] fArr = this.e;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? H = ok2Var.h((i4 / 2) + i);
            if (H != 0) {
                fArr[i4] = H.getX();
                fArr[i4 + 1] = H.getY() * f;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float[] b(rk2 rk2Var, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.g.length != i3) {
            this.g = new float[i3];
        }
        float[] fArr = this.g;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            CandleEntry candleEntry = (CandleEntry) rk2Var.h((i4 / 2) + i);
            if (candleEntry != null) {
                fArr[i4] = candleEntry.getX();
                fArr[i4 + 1] = candleEntry.getHigh() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, fq] */
    public float[] c(hm2 hm2Var, float f, float f2, int i, int i2) {
        int i3 = (((int) ((i2 - i) * f)) + 1) * 2;
        if (this.f.length != i3) {
            this.f = new float[i3];
        }
        float[] fArr = this.f;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? H = hm2Var.h((i4 / 2) + i);
            if (H != 0) {
                fArr[i4] = H.getX();
                fArr[i4 + 1] = H.getY() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, fq] */
    public float[] d(mo2 mo2Var, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.d.length != i3) {
            this.d = new float[i3];
        }
        float[] fArr = this.d;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? H = mo2Var.h((i4 / 2) + i);
            if (H != 0) {
                fArr[i4] = H.getX();
                fArr[i4 + 1] = H.getY() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public ub3 e(float f, float f2) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        k(fArr);
        float[] fArr2 = this.i;
        return ub3.b(fArr2[0], fArr2[1]);
    }

    public Matrix f() {
        this.j.set(this.f17852a);
        this.j.postConcat(this.c.f19506a);
        this.j.postConcat(this.b);
        return this.j;
    }

    public ub3 g(float f, float f2) {
        ub3 ub3VarB = ub3.b(0.0d, 0.0d);
        h(f, f2, ub3VarB);
        return ub3VarB;
    }

    public void h(float f, float f2, ub3 ub3Var) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        j(fArr);
        float[] fArr2 = this.i;
        ub3Var.c = fArr2[0];
        ub3Var.d = fArr2[1];
    }

    public void i(Path path) {
        path.transform(this.f17852a);
        path.transform(this.c.q());
        path.transform(this.b);
    }

    public void j(float[] fArr) {
        Matrix matrix = this.h;
        matrix.reset();
        this.b.invert(matrix);
        matrix.mapPoints(fArr);
        this.c.q().invert(matrix);
        matrix.mapPoints(fArr);
        this.f17852a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void k(float[] fArr) {
        this.f17852a.mapPoints(fArr);
        this.c.q().mapPoints(fArr);
        this.b.mapPoints(fArr);
    }

    public void l(boolean z) {
        this.b.reset();
        if (!z) {
            this.b.postTranslate(this.c.I(), this.c.m() - this.c.H());
        } else {
            this.b.setTranslate(this.c.I(), -this.c.K());
            this.b.postScale(1.0f, -1.0f);
        }
    }

    public void m(float f, float f2, float f3, float f4) {
        float fK = this.c.k() / f2;
        float fG = this.c.g() / f3;
        if (Float.isInfinite(fK)) {
            fK = 0.0f;
        }
        if (Float.isInfinite(fG)) {
            fG = 0.0f;
        }
        this.f17852a.reset();
        this.f17852a.postTranslate(-f, -f4);
        this.f17852a.postScale(fK, -fG);
    }

    public void n(RectF rectF, float f) {
        rectF.top *= f;
        rectF.bottom *= f;
        this.f17852a.mapRect(rectF);
        this.c.q().mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void o(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.f17852a.mapRect(rectF);
        this.c.q().mapRect(rectF);
        this.b.mapRect(rectF);
    }

    public void p(RectF rectF) {
        this.f17852a.mapRect(rectF);
        this.c.q().mapRect(rectF);
        this.b.mapRect(rectF);
    }
}
