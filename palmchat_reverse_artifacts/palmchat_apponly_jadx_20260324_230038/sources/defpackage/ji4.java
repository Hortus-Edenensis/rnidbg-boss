package defpackage;

import com.github.mikephil.charting.charts.PieChart;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ji4 extends ki4<PieChart> {
    public ji4(PieChart pieChart) {
        super(pieChart);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ki4
    public vh2 b(int i, float f, float f2) {
        ao2 ao2VarU = ((ii4) ((PieChart) this.f18698a).getData()).u();
        return new vh2(i, ao2VarU.h(i).getY(), f, f2, 0, ao2VarU.i0());
    }
}
