package defpackage;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import defpackage.rp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class i10<T extends rp> implements zl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f18081a;
    public List<vh2> b = new ArrayList();

    public i10(T t) {
        this.f18081a = t;
    }

    @Override // defpackage.zl2
    public vh2 a(float f, float f2) {
        ub3 ub3VarJ = j(f, f2);
        float f3 = (float) ub3VarJ.c;
        ub3.c(ub3VarJ);
        return f(f3, f, f2);
    }

    public List<vh2> b(kl2 kl2Var, int i, float f, DataSet.Rounding rounding) {
        Entry entryC0;
        ArrayList arrayList = new ArrayList();
        List<Entry> listP = kl2Var.p(f);
        if (listP.size() == 0 && (entryC0 = kl2Var.C0(f, Float.NaN, rounding)) != null) {
            listP = kl2Var.p(entryC0.getX());
        }
        if (listP.size() == 0) {
            return arrayList;
        }
        for (Entry entry : listP) {
            ub3 ub3VarE = this.f18081a.getTransformer(kl2Var.i0()).e(entry.getX(), entry.getY());
            arrayList.add(new vh2(entry.getX(), entry.getY(), (float) ub3VarE.c, (float) ub3VarE.d, i, kl2Var.i0()));
        }
        return arrayList;
    }

    public vh2 c(List<vh2> list, float f, float f2, YAxis.AxisDependency axisDependency, float f3) {
        vh2 vh2Var = null;
        for (int i = 0; i < list.size(); i++) {
            vh2 vh2Var2 = list.get(i);
            if (axisDependency == null || vh2Var2.b() == axisDependency) {
                float fE = e(f, f2, vh2Var2.i(), vh2Var2.k());
                if (fE < f3) {
                    vh2Var = vh2Var2;
                    f3 = fE;
                }
            }
        }
        return vh2Var;
    }

    public qp d() {
        return this.f18081a.getData();
    }

    public float e(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f - f3, f2 - f4);
    }

    public vh2 f(float f, float f2, float f3) {
        List<vh2> listH = h(f, f2, f3);
        if (listH.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float fI = i(listH, f3, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return c(listH, f2, f3, fI < i(listH, f3, axisDependency2) ? axisDependency : axisDependency2, this.f18081a.getMaxHighlightDistance());
    }

    public float g(vh2 vh2Var) {
        return vh2Var.k();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kl2] */
    public List<vh2> h(float f, float f2, float f3) {
        this.b.clear();
        qp qpVarD = d();
        if (qpVarD == null) {
            return this.b;
        }
        int iF = qpVarD.f();
        for (int i = 0; i < iF; i++) {
            ?? E = qpVarD.e(i);
            if (E.O()) {
                this.b.addAll(b(E, i, f, DataSet.Rounding.CLOSEST));
            }
        }
        return this.b;
    }

    public float i(List<vh2> list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            vh2 vh2Var = list.get(i);
            if (vh2Var.b() == axisDependency) {
                float fAbs = Math.abs(g(vh2Var) - f);
                if (fAbs < f2) {
                    f2 = fAbs;
                }
            }
        }
        return f2;
    }

    public ub3 j(float f, float f2) {
        return this.f18081a.getTransformer(YAxis.AxisDependency.LEFT).g(f, f2);
    }
}
