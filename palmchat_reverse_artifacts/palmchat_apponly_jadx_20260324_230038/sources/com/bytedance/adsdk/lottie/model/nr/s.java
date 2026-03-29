package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.PointF;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s {
    private boolean fx;
    private PointF nr;
    private final List<com.bytedance.adsdk.lottie.model.u> u;

    public s(PointF pointF, boolean z, List<com.bytedance.adsdk.lottie.model.u> list) {
        this.nr = pointF;
        this.fx = z;
        this.u = new ArrayList(list);
    }

    public List<com.bytedance.adsdk.lottie.model.u> fx() {
        return this.u;
    }

    public boolean nr() {
        return this.fx;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.u.size() + "closed=" + this.fx + '}';
    }

    public void u(float f, float f2) {
        if (this.nr == null) {
            this.nr = new PointF();
        }
        this.nr.set(f, f2);
    }

    public PointF u() {
        return this.nr;
    }

    public s() {
        this.u = new ArrayList();
    }

    public void u(boolean z) {
        this.fx = z;
    }

    public void u(s sVar, s sVar2, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        if (this.nr == null) {
            this.nr = new PointF();
        }
        this.fx = sVar.nr() || sVar2.nr();
        if (sVar.fx().size() != sVar2.fx().size()) {
            com.bytedance.adsdk.lottie.pn.pn.nr("Curves must have the same number of control points. Shape 1: " + sVar.fx().size() + "\tShape 2: " + sVar2.fx().size());
        }
        int iMin = Math.min(sVar.fx().size(), sVar2.fx().size());
        if (this.u.size() < iMin) {
            for (int size = this.u.size(); size < iMin; size++) {
                this.u.add(new com.bytedance.adsdk.lottie.model.u());
            }
        } else if (this.u.size() > iMin) {
            for (int size2 = this.u.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.lottie.model.u> list = this.u;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFU = sVar.u();
        PointF pointFU2 = sVar2.u();
        u(com.bytedance.adsdk.lottie.pn.n.u(pointFU.x, pointFU2.x, f), com.bytedance.adsdk.lottie.pn.n.u(pointFU.y, pointFU2.y, f));
        for (int size3 = this.u.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.model.u uVar = sVar.fx().get(size3);
            com.bytedance.adsdk.lottie.model.u uVar2 = sVar2.fx().get(size3);
            PointF pointFU3 = uVar.u();
            PointF pointFNr = uVar.nr();
            PointF pointFFx = uVar.fx();
            PointF pointFU4 = uVar2.u();
            PointF pointFNr2 = uVar2.nr();
            PointF pointFFx2 = uVar2.fx();
            this.u.get(size3).u(com.bytedance.adsdk.lottie.pn.n.u(pointFU3.x, pointFU4.x, f), com.bytedance.adsdk.lottie.pn.n.u(pointFU3.y, pointFU4.y, f));
            this.u.get(size3).nr(com.bytedance.adsdk.lottie.pn.n.u(pointFNr.x, pointFNr2.x, f), com.bytedance.adsdk.lottie.pn.n.u(pointFNr.y, pointFNr2.y, f));
            this.u.get(size3).fx(com.bytedance.adsdk.lottie.pn.n.u(pointFFx.x, pointFFx2.x, f), com.bytedance.adsdk.lottie.pn.n.u(pointFFx.y, pointFFx2.y, f));
        }
    }
}
