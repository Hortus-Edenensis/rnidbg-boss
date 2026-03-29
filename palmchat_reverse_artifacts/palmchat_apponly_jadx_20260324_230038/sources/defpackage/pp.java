package defpackage;

import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pp extends i10<op> {
    public pp(op opVar) {
        super(opVar);
    }

    @Override // defpackage.i10, defpackage.zl2
    public vh2 a(float f, float f2) {
        vh2 vh2VarA = super.a(f, f2);
        if (vh2VarA == null) {
            return null;
        }
        ub3 ub3VarJ = j(f, f2);
        lk2 lk2Var = (lk2) ((op) this.f18081a).getBarData().e(vh2VarA.d());
        if (lk2Var.K()) {
            return l(vh2VarA, lk2Var, (float) ub3VarJ.c, (float) ub3VarJ.d);
        }
        ub3.c(ub3VarJ);
        return vh2VarA;
    }

    @Override // defpackage.i10
    public qp d() {
        return ((op) this.f18081a).getBarData();
    }

    @Override // defpackage.i10
    public float e(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3);
    }

    public int k(xs4[] xs4VarArr, float f) {
        if (xs4VarArr == null || xs4VarArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (xs4 xs4Var : xs4VarArr) {
            if (xs4Var.a(f)) {
                return i;
            }
            i++;
        }
        int iMax = Math.max(xs4VarArr.length - 1, 0);
        if (f > xs4VarArr[iMax].b) {
            return iMax;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public vh2 l(vh2 vh2Var, lk2 lk2Var, float f, float f2) {
        BarEntry barEntry = (BarEntry) lk2Var.o0(f, f2);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.getYVals() == null) {
            return vh2Var;
        }
        xs4[] ranges = barEntry.getRanges();
        if (ranges.length <= 0) {
            return null;
        }
        int iK = k(ranges, f2);
        ub3 ub3VarE = ((op) this.f18081a).getTransformer(lk2Var.i0()).e(vh2Var.h(), ranges[iK].b);
        vh2 vh2Var2 = new vh2(barEntry.getX(), barEntry.getY(), (float) ub3VarE.c, (float) ub3VarE.d, vh2Var.d(), iK, vh2Var.b());
        ub3.c(ub3VarE);
        return vh2Var2;
    }
}
