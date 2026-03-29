package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class vo6 extends uo6 {
    public BarChart p;
    public Path q;

    public vo6(nf6 nf6Var, XAxis xAxis, h16 h16Var, BarChart barChart) {
        super(nf6Var, xAxis, h16Var);
        this.q = new Path();
        this.p = barChart;
    }

    @Override // defpackage.uo6, defpackage.kn
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f20113a.k() > 10.0f && !this.f20113a.y()) {
            ub3 ub3VarG = this.c.g(this.f20113a.h(), this.f20113a.f());
            ub3 ub3VarG2 = this.c.g(this.f20113a.h(), this.f20113a.j());
            if (z) {
                f3 = (float) ub3VarG2.d;
                d = ub3VarG.d;
            } else {
                f3 = (float) ub3VarG.d;
                d = ub3VarG2.d;
            }
            ub3.c(ub3VarG);
            ub3.c(ub3VarG2);
            f = f3;
            f2 = (float) d;
        }
        b(f, f2);
    }

    @Override // defpackage.uo6
    public void d() {
        this.e.setTypeface(this.h.c());
        this.e.setTextSize(this.h.b());
        at1 at1VarB = s86.b(this.e, this.h.t());
        float fD = (int) (at1VarB.c + (this.h.d() * 3.5f));
        float f = at1VarB.d;
        at1 at1VarT = s86.t(at1VarB.c, f, this.h.H());
        this.h.J = Math.round(fD);
        this.h.K = Math.round(f);
        XAxis xAxis = this.h;
        xAxis.L = (int) (at1VarT.c + (xAxis.d() * 3.5f));
        this.h.M = Math.round(at1VarT.d);
        at1.c(at1VarT);
    }

    @Override // defpackage.uo6
    public void e(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(this.f20113a.i(), f2);
        path.lineTo(this.f20113a.h(), f2);
        canvas.drawPath(path, this.d);
        path.reset();
    }

    @Override // defpackage.uo6
    public void g(Canvas canvas, float f, vb3 vb3Var) {
        float fH = this.h.H();
        boolean zV = this.h.v();
        int i = this.h.n * 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2 += 2) {
            if (zV) {
                fArr[i2 + 1] = this.h.m[i2 / 2];
            } else {
                fArr[i2 + 1] = this.h.l[i2 / 2];
            }
        }
        this.c.k(fArr);
        for (int i3 = 0; i3 < i; i3 += 2) {
            float f2 = fArr[i3 + 1];
            if (this.f20113a.F(f2)) {
                h96 h96VarU = this.h.u();
                XAxis xAxis = this.h;
                f(canvas, h96VarU.a(xAxis.l[i3 / 2], xAxis), f, f2, vb3Var, fH);
            }
        }
    }

    @Override // defpackage.uo6
    public RectF h() {
        this.k.set(this.f20113a.p());
        this.k.inset(0.0f, -this.b.q());
        return this.k;
    }

    @Override // defpackage.uo6
    public void i(Canvas canvas) {
        if (this.h.f() && this.h.z()) {
            float fD = this.h.d();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            vb3 vb3VarC = vb3.c(0.0f, 0.0f);
            if (this.h.I() == XAxis.XAxisPosition.TOP) {
                vb3VarC.c = 0.0f;
                vb3VarC.d = 0.5f;
                g(canvas, this.f20113a.i() + fD, vb3VarC);
            } else if (this.h.I() == XAxis.XAxisPosition.TOP_INSIDE) {
                vb3VarC.c = 1.0f;
                vb3VarC.d = 0.5f;
                g(canvas, this.f20113a.i() - fD, vb3VarC);
            } else if (this.h.I() == XAxis.XAxisPosition.BOTTOM) {
                vb3VarC.c = 1.0f;
                vb3VarC.d = 0.5f;
                g(canvas, this.f20113a.h() - fD, vb3VarC);
            } else if (this.h.I() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                vb3VarC.c = 1.0f;
                vb3VarC.d = 0.5f;
                g(canvas, this.f20113a.h() + fD, vb3VarC);
            } else {
                vb3VarC.c = 0.0f;
                vb3VarC.d = 0.5f;
                g(canvas, this.f20113a.i() + fD, vb3VarC);
                vb3VarC.c = 1.0f;
                vb3VarC.d = 0.5f;
                g(canvas, this.f20113a.h() - fD, vb3VarC);
            }
            vb3.f(vb3VarC);
        }
    }

    @Override // defpackage.uo6
    public void j(Canvas canvas) {
        if (this.h.w() && this.h.f()) {
            this.f.setColor(this.h.i());
            this.f.setStrokeWidth(this.h.k());
            if (this.h.I() == XAxis.XAxisPosition.TOP || this.h.I() == XAxis.XAxisPosition.TOP_INSIDE || this.h.I() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f20113a.i(), this.f20113a.j(), this.f20113a.i(), this.f20113a.f(), this.f);
            }
            if (this.h.I() == XAxis.XAxisPosition.BOTTOM || this.h.I() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.h.I() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f20113a.h(), this.f20113a.j(), this.f20113a.h(), this.f20113a.f(), this.f);
            }
        }
    }

    @Override // defpackage.uo6
    public void n(Canvas canvas) {
        List<LimitLine> listS = this.h.s();
        if (listS == null || listS.size() <= 0) {
            return;
        }
        float[] fArr = this.l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.q;
        path.reset();
        for (int i = 0; i < listS.size(); i++) {
            LimitLine limitLine = listS.get(i);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.m.set(this.f20113a.p());
                this.m.inset(0.0f, -limitLine.m());
                canvas.clipRect(this.m);
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setColor(limitLine.l());
                this.g.setStrokeWidth(limitLine.m());
                this.g.setPathEffect(limitLine.h());
                fArr[1] = limitLine.k();
                this.c.k(fArr);
                path.moveTo(this.f20113a.h(), fArr[1]);
                path.lineTo(this.f20113a.i(), fArr[1]);
                canvas.drawPath(path, this.g);
                path.reset();
                String strI = limitLine.i();
                if (strI != null && !strI.equals("")) {
                    this.g.setStyle(limitLine.n());
                    this.g.setPathEffect(null);
                    this.g.setColor(limitLine.a());
                    this.g.setStrokeWidth(0.5f);
                    this.g.setTextSize(limitLine.b());
                    float fA = s86.a(this.g, strI);
                    float fE = s86.e(4.0f) + limitLine.d();
                    float fM = limitLine.m() + fA + limitLine.e();
                    LimitLine.LimitLabelPosition limitLabelPositionJ = limitLine.j();
                    if (limitLabelPositionJ == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strI, this.f20113a.i() - fE, (fArr[1] - fM) + fA, this.g);
                    } else if (limitLabelPositionJ == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strI, this.f20113a.i() - fE, fArr[1] + fM, this.g);
                    } else if (limitLabelPositionJ == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strI, this.f20113a.h() + fE, (fArr[1] - fM) + fA, this.g);
                    } else {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strI, this.f20113a.I() + fE, fArr[1] + fM, this.g);
                    }
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
