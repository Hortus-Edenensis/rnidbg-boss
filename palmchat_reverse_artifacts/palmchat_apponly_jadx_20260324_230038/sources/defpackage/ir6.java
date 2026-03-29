package defpackage;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ir6 extends of6 {
    public static l54<ir6> m;
    public float i;
    public float j;
    public YAxis.AxisDependency k;
    public Matrix l;

    static {
        l54<ir6> l54VarA = l54.a(1, new ir6(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        m = l54VarA;
        l54VarA.g(0.5f);
    }

    public ir6(nf6 nf6Var, float f, float f2, float f3, float f4, h16 h16Var, YAxis.AxisDependency axisDependency, View view) {
        super(nf6Var, f3, f4, h16Var, view);
        this.l = new Matrix();
        this.i = f;
        this.j = f2;
        this.k = axisDependency;
    }

    public static ir6 b(nf6 nf6Var, float f, float f2, float f3, float f4, h16 h16Var, YAxis.AxisDependency axisDependency, View view) {
        ir6 ir6Var = (ir6) m.b();
        ir6Var.e = f3;
        ir6Var.f = f4;
        ir6Var.i = f;
        ir6Var.j = f2;
        ir6Var.d = nf6Var;
        ir6Var.g = h16Var;
        ir6Var.k = axisDependency;
        ir6Var.h = view;
        return ir6Var;
    }

    public static void c(ir6 ir6Var) {
        m.c(ir6Var);
    }

    @Override // l54.a
    public l54.a a() {
        return new ir6(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.l;
        this.d.a0(this.i, this.j, matrix);
        this.d.L(matrix, this.h, false);
        float fS = ((BarLineChartBase) this.h).getAxis(this.k).I / this.d.s();
        float fR = ((BarLineChartBase) this.h).getXAxis().I / this.d.r();
        float[] fArr = this.c;
        fArr[0] = this.e - (fR / 2.0f);
        fArr[1] = this.f + (fS / 2.0f);
        this.g.k(fArr);
        this.d.Y(this.c, matrix);
        this.d.L(matrix, this.h, false);
        ((BarLineChartBase) this.h).calculateOffsets();
        this.h.postInvalidate();
        c(this);
    }
}
