package defpackage;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class z65 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<nr0> f22370a;
    public PointF b;
    public boolean c;

    public z65(PointF pointF, boolean z, List<nr0> list) {
        this.b = pointF;
        this.c = z;
        this.f22370a = new ArrayList(list);
    }

    public List<nr0> a() {
        return this.f22370a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(z65 z65Var, z65 z65Var2, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = z65Var.d() || z65Var2.d();
        if (z65Var.a().size() != z65Var2.a().size()) {
            m63.c("Curves must have the same number of control points. Shape 1: " + z65Var.a().size() + "\tShape 2: " + z65Var2.a().size());
        }
        int iMin = Math.min(z65Var.a().size(), z65Var2.a().size());
        if (this.f22370a.size() < iMin) {
            for (int size = this.f22370a.size(); size < iMin; size++) {
                this.f22370a.add(new nr0());
            }
        } else if (this.f22370a.size() > iMin) {
            for (int size2 = this.f22370a.size() - 1; size2 >= iMin; size2--) {
                List<nr0> list = this.f22370a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = z65Var.b();
        PointF pointFB2 = z65Var2.b();
        f(sp3.i(pointFB.x, pointFB2.x, f), sp3.i(pointFB.y, pointFB2.y, f));
        for (int size3 = this.f22370a.size() - 1; size3 >= 0; size3--) {
            nr0 nr0Var = z65Var.a().get(size3);
            nr0 nr0Var2 = z65Var2.a().get(size3);
            PointF pointFA = nr0Var.a();
            PointF pointFB3 = nr0Var.b();
            PointF pointFC = nr0Var.c();
            PointF pointFA2 = nr0Var2.a();
            PointF pointFB4 = nr0Var2.b();
            PointF pointFC2 = nr0Var2.c();
            this.f22370a.get(size3).d(sp3.i(pointFA.x, pointFA2.x, f), sp3.i(pointFA.y, pointFA2.y, f));
            this.f22370a.get(size3).e(sp3.i(pointFB3.x, pointFB4.x, f), sp3.i(pointFB3.y, pointFB4.y, f));
            this.f22370a.get(size3).f(sp3.i(pointFC.x, pointFC2.x, f), sp3.i(pointFC.y, pointFC2.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f22370a.size() + "closed=" + this.c + '}';
    }

    public z65() {
        this.f22370a = new ArrayList();
    }
}
