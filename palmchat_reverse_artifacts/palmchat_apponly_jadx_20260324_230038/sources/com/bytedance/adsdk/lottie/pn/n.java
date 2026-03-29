package com.bytedance.adsdk.lottie.pn;

import android.graphics.Path;
import android.graphics.PointF;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.adsdk.lottie.model.nr.s;
import com.bytedance.component.sdk.annotation.FloatRange;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n {
    private static final PointF u = new PointF();

    public static boolean fx(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int nr(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static float u(float f, float f2, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int u(int i, int i2, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static float nr(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static PointF u(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void u(s sVar, Path path) {
        path.reset();
        PointF pointFU = sVar.u();
        path.moveTo(pointFU.x, pointFU.y);
        u.set(pointFU.x, pointFU.y);
        for (int i = 0; i < sVar.fx().size(); i++) {
            com.bytedance.adsdk.lottie.model.u uVar = sVar.fx().get(i);
            PointF pointFU2 = uVar.u();
            PointF pointFNr = uVar.nr();
            PointF pointFFx = uVar.fx();
            PointF pointF = u;
            if (pointFU2.equals(pointF) && pointFNr.equals(pointFFx)) {
                path.lineTo(pointFFx.x, pointFFx.y);
            } else {
                path.cubicTo(pointFU2.x, pointFU2.y, pointFNr.x, pointFNr.y, pointFFx.x, pointFFx.y);
            }
            pointF.set(pointFFx.x, pointFFx.y);
        }
        if (sVar.nr()) {
            path.close();
        }
    }

    public static int u(float f, float f2) {
        return u((int) f, (int) f2);
    }

    private static int u(int i, int i2) {
        return i - (i2 * nr(i, i2));
    }

    public static int u(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }
}
