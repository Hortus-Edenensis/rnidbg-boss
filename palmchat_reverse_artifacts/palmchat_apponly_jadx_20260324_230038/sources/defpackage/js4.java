package defpackage;

import com.github.mikephil.charting.charts.RadarChart;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class js4 extends ki4<RadarChart> {
    public js4(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // defpackage.ki4
    public vh2 b(int i, float f, float f2) {
        List<vh2> listC = c(i);
        float fDistanceToCenter = ((RadarChart) this.f18698a).distanceToCenter(f, f2) / ((RadarChart) this.f18698a).getFactor();
        vh2 vh2Var = null;
        float f3 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < listC.size(); i2++) {
            vh2 vh2Var2 = listC.get(i2);
            float fAbs = Math.abs(vh2Var2.j() - fDistanceToCenter);
            if (fAbs < f3) {
                vh2Var = vh2Var2;
                f3 = fAbs;
            }
        }
        return vh2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry, fq] */
    public List<vh2> c(int i) {
        int i2 = i;
        this.b.clear();
        float fH = ((RadarChart) this.f18698a).getAnimator().h();
        float fI = ((RadarChart) this.f18698a).getAnimator().i();
        float sliceAngle = ((RadarChart) this.f18698a).getSliceAngle();
        float factor = ((RadarChart) this.f18698a).getFactor();
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        int i3 = 0;
        while (i3 < ((is4) ((RadarChart) this.f18698a).getData()).f()) {
            eo2 eo2VarE = ((is4) ((RadarChart) this.f18698a).getData()).e(i3);
            ?? H = eo2VarE.h(i2);
            float f = i2;
            s86.r(((RadarChart) this.f18698a).getCenterOffsets(), (H.getY() - ((RadarChart) this.f18698a).getYChartMin()) * factor * fI, (sliceAngle * f * fH) + ((RadarChart) this.f18698a).getRotationAngle(), vb3VarC);
            this.b.add(new vh2(f, H.getY(), vb3VarC.c, vb3VarC.d, i3, eo2VarE.i0()));
            i3++;
            i2 = i;
        }
        return this.b;
    }
}
