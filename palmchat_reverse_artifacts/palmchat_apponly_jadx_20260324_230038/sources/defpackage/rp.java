package defpackage;

import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface rp extends j10 {
    qp getData();

    float getHighestVisibleX();

    float getLowestVisibleX();

    h16 getTransformer(YAxis.AxisDependency axisDependency);

    boolean isInverted(YAxis.AxisDependency axisDependency);
}
