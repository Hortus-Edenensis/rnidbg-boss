package defpackage;

import android.graphics.Canvas;
import android.graphics.Path;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u23 extends tp {
    public Path h;

    public u23(g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.h = new Path();
    }

    public void j(Canvas canvas, float f, float f2, jm2 jm2Var) {
        this.d.setColor(jm2Var.J0());
        this.d.setStrokeWidth(jm2Var.q0());
        this.d.setPathEffect(jm2Var.D0());
        if (jm2Var.u()) {
            this.h.reset();
            this.h.moveTo(f, this.f20113a.j());
            this.h.lineTo(f, this.f20113a.f());
            canvas.drawPath(this.h, this.d);
        }
        if (jm2Var.N0()) {
            this.h.reset();
            this.h.moveTo(this.f20113a.h(), f2);
            this.h.lineTo(this.f20113a.i(), f2);
            canvas.drawPath(this.h, this.d);
        }
    }
}
