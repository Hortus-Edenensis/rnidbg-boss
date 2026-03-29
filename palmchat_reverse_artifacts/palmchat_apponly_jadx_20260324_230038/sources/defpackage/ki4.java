package defpackage;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ki4<T extends PieRadarChartBase> implements zl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f18698a;
    public List<vh2> b = new ArrayList();

    public ki4(T t) {
        this.f18698a = t;
    }

    @Override // defpackage.zl2
    public vh2 a(float f, float f2) {
        if (this.f18698a.distanceToCenter(f, f2) > this.f18698a.getRadius()) {
            return null;
        }
        float angleForPoint = this.f18698a.getAngleForPoint(f, f2);
        T t = this.f18698a;
        if (t instanceof PieChart) {
            angleForPoint /= t.getAnimator().i();
        }
        int indexForAngle = this.f18698a.getIndexForAngle(angleForPoint);
        if (indexForAngle < 0 || indexForAngle >= this.f18698a.getData().m().K0()) {
            return null;
        }
        return b(indexForAngle, f, f2);
    }

    public abstract vh2 b(int i, float f, float f2);
}
