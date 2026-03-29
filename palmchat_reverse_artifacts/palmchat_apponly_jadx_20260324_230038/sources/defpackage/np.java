package defpackage;

import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class np extends qp<lk2> {
    public float j = 0.85f;

    public float u() {
        return this.j;
    }

    public float v(float f, float f2) {
        return (this.i.size() * (this.j + f2)) + f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(float f, float f2, float f3) {
        BarEntry barEntry;
        if (this.i.size() <= 1) {
            throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
        }
        int iK0 = ((lk2) m()).K0();
        float f4 = f2 / 2.0f;
        float f5 = f3 / 2.0f;
        float f6 = this.j / 2.0f;
        float fV = v(f2, f3);
        for (int i = 0; i < iK0; i++) {
            float f7 = f + f4;
            for (T t : this.i) {
                float f8 = f7 + f5 + f6;
                if (i < t.K0() && (barEntry = (BarEntry) t.h(i)) != null) {
                    barEntry.setX(f8);
                }
                f7 = f8 + f6 + f5;
            }
            float f9 = f7 + f4;
            float f10 = fV - (f9 - f);
            if (f10 > 0.0f || f10 < 0.0f) {
                f9 += f10;
            }
            f = f9;
        }
        t();
    }
}
