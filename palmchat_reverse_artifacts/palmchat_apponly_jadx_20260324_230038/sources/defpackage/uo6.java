package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class uo6 extends kn {
    public XAxis h;
    public Path i;
    public float[] j;
    public RectF k;
    public float[] l;
    public RectF m;
    public float[] n;
    public Path o;

    public uo6(nf6 nf6Var, XAxis xAxis, h16 h16Var) {
        super(nf6Var, h16Var, xAxis);
        this.i = new Path();
        this.j = new float[2];
        this.k = new RectF();
        this.l = new float[2];
        this.m = new RectF();
        this.n = new float[4];
        this.o = new Path();
        this.h = xAxis;
        this.e.setColor(-16777216);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(s86.e(10.0f));
    }

    @Override // defpackage.kn
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f20113a.k() > 10.0f && !this.f20113a.x()) {
            ub3 ub3VarG = this.c.g(this.f20113a.h(), this.f20113a.j());
            ub3 ub3VarG2 = this.c.g(this.f20113a.i(), this.f20113a.j());
            if (z) {
                f3 = (float) ub3VarG2.c;
                d = ub3VarG.c;
            } else {
                f3 = (float) ub3VarG.c;
                d = ub3VarG2.c;
            }
            ub3.c(ub3VarG);
            ub3.c(ub3VarG2);
            f = f3;
            f2 = (float) d;
        }
        b(f, f2);
    }

    @Override // defpackage.kn
    public void b(float f, float f2) {
        super.b(f, f2);
        d();
    }

    public void d() {
        String strT = this.h.t();
        this.e.setTypeface(this.h.c());
        this.e.setTextSize(this.h.b());
        at1 at1VarB = s86.b(this.e, strT);
        float f = at1VarB.c;
        float fA = s86.a(this.e, "Q");
        at1 at1VarT = s86.t(f, fA, this.h.H());
        this.h.J = Math.round(f);
        this.h.K = Math.round(fA);
        this.h.L = Math.round(at1VarT.c);
        this.h.M = Math.round(at1VarT.d);
        at1.c(at1VarT);
        at1.c(at1VarB);
    }

    public void e(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(f, this.f20113a.f());
        path.lineTo(f, this.f20113a.j());
        canvas.drawPath(path, this.d);
        path.reset();
    }

    public void f(Canvas canvas, String str, float f, float f2, vb3 vb3Var, float f3) {
        s86.g(canvas, str, f, f2, this.e, vb3Var, f3);
    }

    public void g(Canvas canvas, float f, vb3 vb3Var) {
        float fH = this.h.H();
        boolean zV = this.h.v();
        int i = this.h.n * 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2 += 2) {
            if (zV) {
                fArr[i2] = this.h.m[i2 / 2];
            } else {
                fArr[i2] = this.h.l[i2 / 2];
            }
        }
        this.c.k(fArr);
        for (int i3 = 0; i3 < i; i3 += 2) {
            float fD = fArr[i3];
            if (this.f20113a.E(fD)) {
                h96 h96VarU = this.h.u();
                XAxis xAxis = this.h;
                int i4 = i3 / 2;
                String strA = h96VarU.a(xAxis.l[i4], xAxis);
                if (this.h.J()) {
                    int i5 = this.h.n;
                    if (i4 == i5 - 1 && i5 > 1) {
                        float fD2 = s86.d(this.e, strA);
                        if (fD2 > this.f20113a.J() * 2.0f && fD + fD2 > this.f20113a.n()) {
                            fD -= fD2 / 2.0f;
                        }
                    } else if (i3 == 0) {
                        fD += s86.d(this.e, strA) / 2.0f;
                    }
                }
                f(canvas, strA, fD, f, vb3Var, fH);
            }
        }
    }

    public RectF h() {
        this.k.set(this.f20113a.p());
        this.k.inset(-this.b.q(), 0.0f);
        return this.k;
    }

    public void i(Canvas canvas) {
        if (this.h.f() && this.h.z()) {
            float fE = this.h.e();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            vb3 vb3VarC = vb3.c(0.0f, 0.0f);
            if (this.h.I() == XAxis.XAxisPosition.TOP) {
                vb3VarC.c = 0.5f;
                vb3VarC.d = 1.0f;
                g(canvas, this.f20113a.j() - fE, vb3VarC);
            } else if (this.h.I() == XAxis.XAxisPosition.TOP_INSIDE) {
                vb3VarC.c = 0.5f;
                vb3VarC.d = 1.0f;
                g(canvas, this.f20113a.j() + fE + this.h.M, vb3VarC);
            } else if (this.h.I() == XAxis.XAxisPosition.BOTTOM) {
                vb3VarC.c = 0.5f;
                vb3VarC.d = 0.0f;
                g(canvas, this.f20113a.f() + fE, vb3VarC);
            } else if (this.h.I() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                vb3VarC.c = 0.5f;
                vb3VarC.d = 0.0f;
                g(canvas, (this.f20113a.f() - fE) - this.h.M, vb3VarC);
            } else {
                vb3VarC.c = 0.5f;
                vb3VarC.d = 1.0f;
                g(canvas, this.f20113a.j() - fE, vb3VarC);
                vb3VarC.c = 0.5f;
                vb3VarC.d = 0.0f;
                g(canvas, this.f20113a.f() + fE, vb3VarC);
            }
            vb3.f(vb3VarC);
        }
    }

    public void j(Canvas canvas) {
        if (this.h.w() && this.h.f()) {
            this.f.setColor(this.h.i());
            this.f.setStrokeWidth(this.h.k());
            this.f.setPathEffect(this.h.j());
            if (this.h.I() == XAxis.XAxisPosition.TOP || this.h.I() == XAxis.XAxisPosition.TOP_INSIDE || this.h.I() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f20113a.h(), this.f20113a.j(), this.f20113a.i(), this.f20113a.j(), this.f);
            }
            if (this.h.I() == XAxis.XAxisPosition.BOTTOM || this.h.I() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.h.I() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f20113a.h(), this.f20113a.f(), this.f20113a.i(), this.f20113a.f(), this.f);
            }
        }
    }

    public void k(Canvas canvas) {
        if (this.h.y() && this.h.f()) {
            int iSave = canvas.save();
            canvas.clipRect(h());
            if (this.j.length != this.b.n * 2) {
                this.j = new float[this.h.n * 2];
            }
            float[] fArr = this.j;
            for (int i = 0; i < fArr.length; i += 2) {
                float[] fArr2 = this.h.l;
                int i2 = i / 2;
                fArr[i] = fArr2[i2];
                fArr[i + 1] = fArr2[i2];
            }
            this.c.k(fArr);
            o();
            Path path = this.i;
            path.reset();
            for (int i3 = 0; i3 < fArr.length; i3 += 2) {
                e(canvas, fArr[i3], fArr[i3 + 1], path);
            }
            canvas.restoreToCount(iSave);
        }
    }

    public void l(Canvas canvas, LimitLine limitLine, float[] fArr, float f) {
        String strI = limitLine.i();
        if (strI == null || strI.equals("")) {
            return;
        }
        this.g.setStyle(limitLine.n());
        this.g.setPathEffect(null);
        this.g.setColor(limitLine.a());
        this.g.setStrokeWidth(0.5f);
        this.g.setTextSize(limitLine.b());
        float fM = limitLine.m() + limitLine.d();
        LimitLine.LimitLabelPosition limitLabelPositionJ = limitLine.j();
        if (limitLabelPositionJ == LimitLine.LimitLabelPosition.RIGHT_TOP) {
            float fA = s86.a(this.g, strI);
            this.g.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strI, fArr[0] + fM, this.f20113a.j() + f + fA, this.g);
        } else if (limitLabelPositionJ == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
            this.g.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strI, fArr[0] + fM, this.f20113a.f() - f, this.g);
        } else if (limitLabelPositionJ != LimitLine.LimitLabelPosition.LEFT_TOP) {
            this.g.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strI, fArr[0] - fM, this.f20113a.f() - f, this.g);
        } else {
            this.g.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strI, fArr[0] - fM, this.f20113a.j() + f + s86.a(this.g, strI), this.g);
        }
    }

    public void m(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.n;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f20113a.j();
        float[] fArr3 = this.n;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f20113a.f();
        this.o.reset();
        Path path = this.o;
        float[] fArr4 = this.n;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.o;
        float[] fArr5 = this.n;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setColor(limitLine.l());
        this.g.setStrokeWidth(limitLine.m());
        this.g.setPathEffect(limitLine.h());
        canvas.drawPath(this.o, this.g);
    }

    public void n(Canvas canvas) {
        List<LimitLine> listS = this.h.s();
        if (listS == null || listS.size() <= 0) {
            return;
        }
        float[] fArr = this.l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i = 0; i < listS.size(); i++) {
            LimitLine limitLine = listS.get(i);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.m.set(this.f20113a.p());
                this.m.inset(-limitLine.m(), 0.0f);
                canvas.clipRect(this.m);
                fArr[0] = limitLine.k();
                fArr[1] = 0.0f;
                this.c.k(fArr);
                m(canvas, limitLine, fArr);
                l(canvas, limitLine, fArr, limitLine.e() + 2.0f);
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void o() {
        this.d.setColor(this.h.o());
        this.d.setStrokeWidth(this.h.q());
        this.d.setPathEffect(this.h.p());
    }
}
