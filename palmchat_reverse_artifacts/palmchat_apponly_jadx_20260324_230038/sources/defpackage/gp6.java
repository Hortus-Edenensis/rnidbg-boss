package defpackage;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gp6 extends ep6 {
    public RadarChart r;
    public Path s;

    public gp6(nf6 nf6Var, YAxis yAxis, RadarChart radarChart) {
        super(nf6Var, yAxis, null);
        this.s = new Path();
        this.r = radarChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // defpackage.kn
    public void b(float f, float f2) {
        ?? r5;
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
        boolean zV = this.b.v();
        if (this.b.B()) {
            float f4 = ((float) dAbs) / (iR - 1);
            jn jnVar2 = this.b;
            jnVar2.n = iR;
            if (jnVar2.l.length < iR) {
                jnVar2.l = new float[iR];
            }
            for (int i = 0; i < iR; i++) {
                this.b.l[i] = f3;
                f3 += f4;
            }
        } else {
            double dCeil = dY == 0.0d ? 0.0d : Math.ceil(((double) f3) / dY) * dY;
            if (zV) {
                dCeil -= dY;
            }
            double dW = dY == 0.0d ? 0.0d : s86.w(Math.floor(((double) f2) / dY) * dY);
            if (dY != 0.0d) {
                double d = dCeil;
                r5 = zV;
                while (d <= dW) {
                    d += dY;
                    r5 = (r5 == true ? 1 : 0) + 1;
                }
            } else {
                r5 = zV;
            }
            int i2 = r5 + 1;
            jn jnVar3 = this.b;
            jnVar3.n = i2;
            if (jnVar3.l.length < i2) {
                jnVar3.l = new float[i2];
            }
            for (int i3 = 0; i3 < i2; i3++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                this.b.l[i3] = (float) dCeil;
                dCeil += dY;
            }
            iR = i2;
        }
        if (dY < 1.0d) {
            this.b.o = (int) Math.ceil(-Math.log10(dY));
        } else {
            this.b.o = 0;
        }
        if (zV) {
            jn jnVar4 = this.b;
            if (jnVar4.m.length < iR) {
                jnVar4.m = new float[iR];
            }
            float[] fArr = jnVar4.l;
            float f5 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i4 = 0; i4 < iR; i4++) {
                jn jnVar5 = this.b;
                jnVar5.m[i4] = jnVar5.l[i4] + f5;
            }
        }
        jn jnVar6 = this.b;
        float[] fArr2 = jnVar6.l;
        float f6 = fArr2[0];
        jnVar6.H = f6;
        float f7 = fArr2[iR - 1];
        jnVar6.G = f7;
        jnVar6.I = Math.abs(f7 - f6);
    }

    @Override // defpackage.ep6
    public void i(Canvas canvas) {
        if (this.h.f() && this.h.z()) {
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            vb3 centerOffsets = this.r.getCenterOffsets();
            vb3 vb3VarC = vb3.c(0.0f, 0.0f);
            float factor = this.r.getFactor();
            int i = this.h.S() ? this.h.n : this.h.n - 1;
            for (int i2 = !this.h.R() ? 1 : 0; i2 < i; i2++) {
                YAxis yAxis = this.h;
                s86.r(centerOffsets, (yAxis.l[i2] - yAxis.H) * factor, this.r.getRotationAngle(), vb3VarC);
                canvas.drawText(this.h.m(i2), vb3VarC.c + 10.0f, vb3VarC.d, this.e);
            }
            vb3.f(centerOffsets);
            vb3.f(vb3VarC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ep6
    public void l(Canvas canvas) {
        List<LimitLine> listS = this.h.s();
        if (listS == null) {
            return;
        }
        float sliceAngle = this.r.getSliceAngle();
        float factor = this.r.getFactor();
        vb3 centerOffsets = this.r.getCenterOffsets();
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        for (int i = 0; i < listS.size(); i++) {
            LimitLine limitLine = listS.get(i);
            if (limitLine.f()) {
                this.g.setColor(limitLine.l());
                this.g.setPathEffect(limitLine.h());
                this.g.setStrokeWidth(limitLine.m());
                float fK = (limitLine.k() - this.r.getYChartMin()) * factor;
                Path path = this.s;
                path.reset();
                for (int i2 = 0; i2 < ((is4) this.r.getData()).m().K0(); i2++) {
                    s86.r(centerOffsets, fK, (i2 * sliceAngle) + this.r.getRotationAngle(), vb3VarC);
                    if (i2 == 0) {
                        path.moveTo(vb3VarC.c, vb3VarC.d);
                    } else {
                        path.lineTo(vb3VarC.c, vb3VarC.d);
                    }
                }
                path.close();
                canvas.drawPath(path, this.g);
            }
        }
        vb3.f(centerOffsets);
        vb3.f(vb3VarC);
    }
}
