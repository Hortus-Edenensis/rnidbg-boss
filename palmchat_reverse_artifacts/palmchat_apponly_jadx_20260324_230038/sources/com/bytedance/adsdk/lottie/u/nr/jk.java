package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jk extends x<PointF> {
    private final PointF b;
    private final PathMeasure iz;
    private final float[] pn;
    private a x;

    public jk(List<? extends com.bytedance.adsdk.lottie.iz.u<PointF>> list) {
        super(list);
        this.b = new PointF();
        this.pn = new float[2];
        this.iz = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public PointF u(com.bytedance.adsdk.lottie.iz.u<PointF> uVar, float f) {
        PointF pointF;
        a aVar = (a) uVar;
        Path pathNr = aVar.nr();
        if (pathNr == null) {
            return uVar.u;
        }
        com.bytedance.adsdk.lottie.iz.fx<A> fxVar = this.fx;
        if (fxVar != 0 && (pointF = (PointF) fxVar.u(aVar.iz, aVar.x.floatValue(), aVar.u, aVar.nr, b(), f, n())) != null) {
            return pointF;
        }
        if (this.x != aVar) {
            this.iz.setPath(pathNr, false);
            this.x = aVar;
        }
        PathMeasure pathMeasure = this.iz;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.pn, null);
        PointF pointF2 = this.b;
        float[] fArr = this.pn;
        pointF2.set(fArr[0], fArr[1]);
        return this.b;
    }
}
