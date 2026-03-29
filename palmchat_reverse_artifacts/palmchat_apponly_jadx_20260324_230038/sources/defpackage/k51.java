package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k51 implements ul2 {
    @Override // defpackage.ul2
    public float a(hm2 hm2Var, q23 q23Var) {
        float yChartMax = q23Var.getYChartMax();
        float yChartMin = q23Var.getYChartMin();
        p23 lineData = q23Var.getLineData();
        if (hm2Var.S() > 0.0f && hm2Var.W() < 0.0f) {
            return 0.0f;
        }
        if (lineData.p() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.r() < 0.0f) {
            yChartMin = 0.0f;
        }
        return hm2Var.W() >= 0.0f ? yChartMin : yChartMax;
    }
}
