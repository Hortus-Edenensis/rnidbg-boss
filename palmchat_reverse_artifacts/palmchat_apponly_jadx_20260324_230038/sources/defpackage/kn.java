package defpackage;

import android.graphics.Paint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class kn extends pv4 {
    public jn b;
    public h16 c;
    public Paint d;
    public Paint e;
    public Paint f;
    public Paint g;

    public kn(nf6 nf6Var, h16 h16Var, jn jnVar) {
        super(nf6Var);
        this.c = h16Var;
        this.b = jnVar;
        if (this.f20113a != null) {
            this.e = new Paint(1);
            Paint paint = new Paint();
            this.d = paint;
            paint.setColor(-7829368);
            this.d.setStrokeWidth(1.0f);
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setAlpha(90);
            Paint paint2 = new Paint();
            this.f = paint2;
            paint2.setColor(-16777216);
            this.f.setStrokeWidth(1.0f);
            this.f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.g = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        nf6 nf6Var = this.f20113a;
        if (nf6Var != null && nf6Var.k() > 10.0f && !this.f20113a.y()) {
            ub3 ub3VarG = this.c.g(this.f20113a.h(), this.f20113a.j());
            ub3 ub3VarG2 = this.c.g(this.f20113a.h(), this.f20113a.f());
            if (z) {
                f3 = (float) ub3VarG.d;
                d = ub3VarG2.d;
            } else {
                f3 = (float) ub3VarG2.d;
                d = ub3VarG.d;
            }
            ub3.c(ub3VarG);
            ub3.c(ub3VarG2);
            f = f3;
            f2 = (float) d;
        }
        b(f, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    public void b(float f, float f2) {
        float f3 = f;
        int iR = this.b.r();
        double dAbs = Math.abs(f2 - f3);
        if (iR == 0 || dAbs <= 0.0d || Double.isInfinite(dAbs)) {
            jn jnVar = this.b;
            jnVar.l = new float[0];
            jnVar.m = new float[0];
            jnVar.n = 0;
            return;
        }
        double dY = s86.y(dAbs / ((double) iR));
        if (this.b.C() && dY < this.b.n()) {
            dY = this.b.n();
        }
        double dY2 = s86.y(Math.pow(10.0d, (int) Math.log10(dY)));
        if (((int) (dY / dY2)) > 5) {
            dY = Math.floor(dY2 * 10.0d);
        }
        int iV = this.b.v();
        if (this.b.B()) {
            dY = ((float) dAbs) / (iR - 1);
            jn jnVar2 = this.b;
            jnVar2.n = iR;
            if (jnVar2.l.length < iR) {
                jnVar2.l = new float[iR];
            }
            for (int i = 0; i < iR; i++) {
                this.b.l[i] = f3;
                f3 = (float) (((double) f3) + dY);
            }
        } else {
            double dCeil = dY == 0.0d ? 0.0d : Math.ceil(((double) f3) / dY) * dY;
            if (this.b.v()) {
                dCeil -= dY;
            }
            double dW = dY == 0.0d ? 0.0d : s86.w(Math.floor(((double) f2) / dY) * dY);
            if (dY != 0.0d) {
                double d = dCeil;
                iV = iV;
                while (d <= dW) {
                    d += dY;
                    iV++;
                }
            }
            jn jnVar3 = this.b;
            jnVar3.n = iV;
            if (jnVar3.l.length < iV) {
                jnVar3.l = new float[iV];
            }
            for (int i2 = 0; i2 < iV; i2++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                this.b.l[i2] = (float) dCeil;
                dCeil += dY;
            }
            iR = iV;
        }
        if (dY < 1.0d) {
            this.b.o = (int) Math.ceil(-Math.log10(dY));
        } else {
            this.b.o = 0;
        }
        if (this.b.v()) {
            jn jnVar4 = this.b;
            if (jnVar4.m.length < iR) {
                jnVar4.m = new float[iR];
            }
            float f4 = ((float) dY) / 2.0f;
            for (int i3 = 0; i3 < iR; i3++) {
                jn jnVar5 = this.b;
                jnVar5.m[i3] = jnVar5.l[i3] + f4;
            }
        }
    }

    public Paint c() {
        return this.e;
    }
}
