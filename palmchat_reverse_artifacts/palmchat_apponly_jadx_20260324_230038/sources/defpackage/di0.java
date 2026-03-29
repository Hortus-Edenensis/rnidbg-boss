package defpackage;

import com.github.mikephil.charting.data.DataSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class di0 extends i10<bi0> {
    public pp c;

    public di0(bi0 bi0Var, op opVar) {
        super(bi0Var);
        this.c = opVar.getBarData() == null ? null : new pp(opVar);
    }

    @Override // defpackage.i10
    public List<vh2> h(float f, float f2, float f3) {
        this.b.clear();
        List<qp> listU = ((bi0) this.f18081a).getCombinedData().u();
        for (int i = 0; i < listU.size(); i++) {
            qp qpVar = listU.get(i);
            pp ppVar = this.c;
            if (ppVar == null || !(qpVar instanceof np)) {
                int iF = qpVar.f();
                for (int i2 = 0; i2 < iF; i2++) {
                    kl2 kl2VarE = listU.get(i).e(i2);
                    if (kl2VarE.O()) {
                        for (vh2 vh2Var : b(kl2VarE, i2, f, DataSet.Rounding.CLOSEST)) {
                            vh2Var.l(i);
                            this.b.add(vh2Var);
                        }
                    }
                }
            } else {
                vh2 vh2VarA = ppVar.a(f2, f3);
                if (vh2VarA != null) {
                    vh2VarA.l(i);
                    this.b.add(vh2VarA);
                }
            }
        }
        return this.b;
    }
}
