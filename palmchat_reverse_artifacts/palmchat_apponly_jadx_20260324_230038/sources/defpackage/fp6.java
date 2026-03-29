package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fp6 extends ep6 {
    public Path r;
    public Path s;
    public float[] t;

    public fp6(nf6 nf6Var, YAxis yAxis, h16 h16Var) {
        super(nf6Var, yAxis, h16Var);
        this.r = new Path();
        this.s = new Path();
        this.t = new float[4];
        this.g.setTextAlign(Paint.Align.LEFT);
    }

    @Override // defpackage.kn
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f20113a.g() > 10.0f && !this.f20113a.x()) {
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

    @Override // defpackage.ep6
    public void d(Canvas canvas, float f, float[] fArr, float f2) {
        this.e.setTypeface(this.h.c());
        this.e.setTextSize(this.h.b());
        this.e.setColor(this.h.a());
        int i = this.h.S() ? this.h.n : this.h.n - 1;
        for (int i2 = !this.h.R() ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(this.h.m(i2), fArr[i2 * 2], f - f2, this.e);
        }
    }

    @Override // defpackage.ep6
    public void e(Canvas canvas) {
        int iSave = canvas.save();
        this.n.set(this.f20113a.p());
        this.n.inset(-this.h.Q(), 0.0f);
        canvas.clipRect(this.q);
        ub3 ub3VarE = this.c.e(0.0f, 0.0f);
        this.i.setColor(this.h.P());
        this.i.setStrokeWidth(this.h.Q());
        Path path = this.r;
        path.reset();
        path.moveTo(((float) ub3VarE.c) - 1.0f, this.f20113a.j());
        path.lineTo(((float) ub3VarE.c) - 1.0f, this.f20113a.f());
        canvas.drawPath(path, this.i);
        canvas.restoreToCount(iSave);
    }

    @Override // defpackage.ep6
    public RectF f() {
        this.k.set(this.f20113a.p());
        this.k.inset(-this.b.q(), 0.0f);
        return this.k;
    }

    @Override // defpackage.ep6
    public float[] g() {
        int length = this.l.length;
        int i = this.h.n;
        if (length != i * 2) {
            this.l = new float[i * 2];
        }
        float[] fArr = this.l;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2] = this.h.l[i2 / 2];
        }
        this.c.k(fArr);
        return fArr;
    }

    @Override // defpackage.ep6
    public Path h(Path path, int i, float[] fArr) {
        path.moveTo(fArr[i], this.f20113a.j());
        path.lineTo(fArr[i], this.f20113a.f());
        return path;
    }

    @Override // defpackage.ep6
    public void i(Canvas canvas) {
        float f;
        if (this.h.f() && this.h.z()) {
            float[] fArrG = g();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            this.e.setTextAlign(Paint.Align.CENTER);
            float fE = s86.e(2.5f);
            float fA = s86.a(this.e, "Q");
            YAxis.AxisDependency axisDependencyH = this.h.H();
            YAxis.YAxisLabelPosition yAxisLabelPositionI = this.h.I();
            if (axisDependencyH == YAxis.AxisDependency.LEFT) {
                f = (yAxisLabelPositionI == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.f20113a.j() : this.f20113a.j()) - fE;
            } else {
                f = (yAxisLabelPositionI == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.f20113a.f() : this.f20113a.f()) + fA + fE;
            }
            d(canvas, f, fArrG, this.h.e());
        }
    }

    @Override // defpackage.ep6
    public void j(Canvas canvas) {
        if (this.h.f() && this.h.w()) {
            this.f.setColor(this.h.i());
            this.f.setStrokeWidth(this.h.k());
            if (this.h.H() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f20113a.h(), this.f20113a.j(), this.f20113a.i(), this.f20113a.j(), this.f);
            } else {
                canvas.drawLine(this.f20113a.h(), this.f20113a.f(), this.f20113a.i(), this.f20113a.f(), this.f);
            }
        }
    }

    @Override // defpackage.ep6
    public void l(Canvas canvas) {
        List<LimitLine> listS = this.h.s();
        if (listS == null || listS.size() <= 0) {
            return;
        }
        float[] fArr = this.t;
        float f = 0.0f;
        fArr[0] = 0.0f;
        char c = 1;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.s;
        path.reset();
        int i = 0;
        while (i < listS.size()) {
            LimitLine limitLine = listS.get(i);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.q.set(this.f20113a.p());
                this.q.inset(-limitLine.m(), f);
                canvas.clipRect(this.q);
                fArr[0] = limitLine.k();
                fArr[2] = limitLine.k();
                this.c.k(fArr);
                fArr[c] = this.f20113a.j();
                fArr[3] = this.f20113a.f();
                path.moveTo(fArr[0], fArr[c]);
                path.lineTo(fArr[2], fArr[3]);
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setColor(limitLine.l());
                this.g.setPathEffect(limitLine.h());
                this.g.setStrokeWidth(limitLine.m());
                canvas.drawPath(path, this.g);
                path.reset();
                String strI = limitLine.i();
                if (strI != null && !strI.equals("")) {
                    this.g.setStyle(limitLine.n());
                    this.g.setPathEffect(null);
                    this.g.setColor(limitLine.a());
                    this.g.setTypeface(limitLine.c());
                    this.g.setStrokeWidth(0.5f);
                    this.g.setTextSize(limitLine.b());
                    float fM = limitLine.m() + limitLine.d();
                    float fE = s86.e(2.0f) + limitLine.e();
                    LimitLine.LimitLabelPosition limitLabelPositionJ = limitLine.j();
                    if (limitLabelPositionJ == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        float fA = s86.a(this.g, strI);
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strI, fArr[0] + fM, this.f20113a.j() + fE + fA, this.g);
                    } else if (limitLabelPositionJ == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strI, fArr[0] + fM, this.f20113a.f() - fE, this.g);
                    } else if (limitLabelPositionJ == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strI, fArr[0] - fM, this.f20113a.j() + fE + s86.a(this.g, strI), this.g);
                    } else {
                        this.g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strI, fArr[0] - fM, this.f20113a.f() - fE, this.g);
                    }
                }
                canvas.restoreToCount(iSave);
            }
            i++;
            f = 0.0f;
            c = 1;
        }
    }
}
