package defpackage;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class qi2 extends pp {
    public qi2(op opVar) {
        super(opVar);
    }

    @Override // defpackage.pp, defpackage.i10, defpackage.zl2
    public vh2 a(float f, float f2) {
        np barData = ((op) this.f18081a).getBarData();
        ub3 ub3VarJ = j(f2, f);
        vh2 vh2VarF = f((float) ub3VarJ.d, f2, f);
        if (vh2VarF == null) {
            return null;
        }
        lk2 lk2Var = (lk2) barData.e(vh2VarF.d());
        if (lk2Var.K()) {
            return l(vh2VarF, lk2Var, (float) ub3VarJ.d, (float) ub3VarJ.c);
        }
        ub3.c(ub3VarJ);
        return vh2VarF;
    }

    @Override // defpackage.i10
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
            ub3 ub3VarE = ((op) this.f18081a).getTransformer(kl2Var.i0()).e(entry.getY(), entry.getX());
            arrayList.add(new vh2(entry.getX(), entry.getY(), (float) ub3VarE.c, (float) ub3VarE.d, i, kl2Var.i0()));
        }
        return arrayList;
    }

    @Override // defpackage.pp, defpackage.i10
    public float e(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }
}
