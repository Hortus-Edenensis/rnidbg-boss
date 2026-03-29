package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sp3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointF f20799a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static int e(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int f(float f, float f2) {
        return g((int) f, (int) f2);
    }

    public static int g(int i, int i2) {
        return i - (i2 * e(i, i2));
    }

    public static void h(z65 z65Var, Path path) {
        path.reset();
        PointF pointFB = z65Var.b();
        path.moveTo(pointFB.x, pointFB.y);
        f20799a.set(pointFB.x, pointFB.y);
        for (int i = 0; i < z65Var.a().size(); i++) {
            nr0 nr0Var = z65Var.a().get(i);
            PointF pointFA = nr0Var.a();
            PointF pointFB2 = nr0Var.b();
            PointF pointFC = nr0Var.c();
            PointF pointF = f20799a;
            if (pointFA.equals(pointF) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            pointF.set(pointFC.x, pointFC.y);
        }
        if (z65Var.d()) {
            path.close();
        }
    }

    public static float i(float f, float f2, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int j(int i, int i2, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void k(b03 b03Var, int i, List<b03> list, b03 b03Var2, d03 d03Var) {
        if (b03Var.c(d03Var.getName(), i)) {
            list.add(b03Var2.a(d03Var.getName()).i(d03Var));
        }
    }
}
