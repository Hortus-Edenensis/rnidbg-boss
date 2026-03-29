package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t extends x<PointF> {
    private final PointF b;

    public t(List<com.bytedance.adsdk.lottie.iz.u<PointF>> list) {
        super(list);
        this.b = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public PointF u(com.bytedance.adsdk.lottie.iz.u<PointF> uVar, float f) {
        return u(uVar, f, f, f);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public PointF u(com.bytedance.adsdk.lottie.iz.u<PointF> uVar, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = uVar.u;
        if (pointF3 == null || (pointF = uVar.nr) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        if (fxVar != 0 && (pointF2 = (PointF) fxVar.u(uVar.iz, uVar.x.floatValue(), pointF4, pointF5, f, b(), n())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.b;
        float f4 = pointF4.x;
        float f5 = f4 + (f2 * (pointF5.x - f4));
        float f6 = pointF4.y;
        pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
        return this.b;
    }
}
