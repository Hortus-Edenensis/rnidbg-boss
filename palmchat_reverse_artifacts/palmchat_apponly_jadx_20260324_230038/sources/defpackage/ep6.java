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
public class ep6 extends kn {
    public YAxis h;
    public Paint i;
    public Path j;
    public RectF k;
    public float[] l;
    public Path m;
    public RectF n;
    public Path o;
    public float[] p;
    public RectF q;

    public ep6(nf6 nf6Var, YAxis yAxis, h16 h16Var) {
        super(nf6Var, h16Var, yAxis);
        this.j = new Path();
        this.k = new RectF();
        this.l = new float[2];
        this.m = new Path();
        this.n = new RectF();
        this.o = new Path();
        this.p = new float[2];
        this.q = new RectF();
        this.h = yAxis;
        if (this.f20113a != null) {
            this.e.setColor(-16777216);
            this.e.setTextSize(s86.e(10.0f));
            Paint paint = new Paint(1);
            this.i = paint;
            paint.setColor(-7829368);
            this.i.setStrokeWidth(1.0f);
            this.i.setStyle(Paint.Style.STROKE);
        }
    }

    public void d(Canvas canvas, float f, float[] fArr, float f2) {
        int i = this.h.S() ? this.h.n : this.h.n - 1;
        for (int i2 = !this.h.R() ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(this.h.m(i2), f, fArr[(i2 * 2) + 1] + f2, this.e);
        }
    }

    public void e(Canvas canvas) {
        int iSave = canvas.save();
        this.n.set(this.f20113a.p());
        this.n.inset(0.0f, -this.h.Q());
        canvas.clipRect(this.n);
        ub3 ub3VarE = this.c.e(0.0f, 0.0f);
        this.i.setColor(this.h.P());
        this.i.setStrokeWidth(this.h.Q());
        Path path = this.m;
        path.reset();
        path.moveTo(this.f20113a.h(), (float) ub3VarE.d);
        path.lineTo(this.f20113a.i(), (float) ub3VarE.d);
        canvas.drawPath(path, this.i);
        canvas.restoreToCount(iSave);
    }

    public RectF f() {
        this.k.set(this.f20113a.p());
        this.k.inset(0.0f, -this.b.q());
        return this.k;
    }

    public float[] g() {
        int length = this.l.length;
        int i = this.h.n;
        if (length != i * 2) {
            this.l = new float[i * 2];
        }
        float[] fArr = this.l;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2 + 1] = this.h.l[i2 / 2];
        }
        this.c.k(fArr);
        return fArr;
    }

    public Path h(Path path, int i, float[] fArr) {
        int i2 = i + 1;
        path.moveTo(this.f20113a.I(), fArr[i2]);
        path.lineTo(this.f20113a.i(), fArr[i2]);
        return path;
    }

    public void i(Canvas canvas) {
        float fI;
        float fI2;
        float f;
        if (this.h.f() && this.h.z()) {
            float[] fArrG = g();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            float fD = this.h.d();
            float fA = (s86.a(this.e, "A") / 2.5f) + this.h.e();
            YAxis.AxisDependency axisDependencyH = this.h.H();
            YAxis.YAxisLabelPosition yAxisLabelPositionI = this.h.I();
            if (axisDependencyH == YAxis.AxisDependency.LEFT) {
                if (yAxisLabelPositionI == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.e.setTextAlign(Paint.Align.RIGHT);
                    fI = this.f20113a.I();
                    f = fI - fD;
                } else {
                    this.e.setTextAlign(Paint.Align.LEFT);
                    fI2 = this.f20113a.I();
                    f = fI2 + fD;
                }
            } else if (yAxisLabelPositionI == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.e.setTextAlign(Paint.Align.LEFT);
                fI2 = this.f20113a.i();
                f = fI2 + fD;
            } else {
                this.e.setTextAlign(Paint.Align.RIGHT);
                fI = this.f20113a.i();
                f = fI - fD;
            }
            d(canvas, f, fArrG, fA);
        }
    }

    public void j(Canvas canvas) {
        if (this.h.f() && this.h.w()) {
            this.f.setColor(this.h.i());
            this.f.setStrokeWidth(this.h.k());
            if (this.h.H() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f20113a.h(), this.f20113a.j(), this.f20113a.h(), this.f20113a.f(), this.f);
            } else {
                canvas.drawLine(this.f20113a.i(), this.f20113a.j(), this.f20113a.i(), this.f20113a.f(), this.f);
            }
        }
    }

    public void k(Canvas canvas) {
        if (this.h.f()) {
            if (this.h.y()) {
                int iSave = canvas.save();
                canvas.clipRect(f());
                float[] fArrG = g();
                this.d.setColor(this.h.o());
                this.d.setStrokeWidth(this.h.q());
                this.d.setPathEffect(this.h.p());
                Path path = this.j;
                path.reset();
                for (int i = 0; i < fArrG.length; i += 2) {
                    canvas.drawPath(h(path, i, fArrG), this.d);
                    path.reset();
                }
                canvas.restoreToCount(iSave);
            }
            if (this.h.T()) {
                e(canvas);
            }
        }
    }

    public void l(Canvas canvas) {
        List<LimitLine> listS = this.h.s();
        if (listS == null || listS.size() <= 0) {
            return;
        }
        float[] fArr = this.p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.o;
        path.reset();
        for (int i = 0; i < listS.size(); i++) {
            LimitLine limitLine = listS.get(i);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.q.set(this.f20113a.p());
                this.q.inset(0.0f, -limitLine.m());
                canvas.clipRect(this.q);
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
                    this.g.setTypeface(limitLine.c());
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
