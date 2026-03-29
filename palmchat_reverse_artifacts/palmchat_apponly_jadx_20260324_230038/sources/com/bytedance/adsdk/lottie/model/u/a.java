package com.bytedance.adsdk.lottie.model.u;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements mv<PointF, PointF> {
    private final nr nr;
    private final nr u;

    public a(nr nrVar, nr nrVar2) {
        this.u = nrVar;
        this.nr = nrVar2;
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public List<com.bytedance.adsdk.lottie.iz.u<PointF>> fx() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public boolean nr() {
        return this.u.nr() && this.nr.nr();
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> u() {
        return new com.bytedance.adsdk.lottie.u.nr.s(this.u.u(), this.nr.u());
    }
}
