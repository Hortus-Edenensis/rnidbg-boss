package com.bytedance.adsdk.lottie.model.u;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements mv<PointF, PointF> {
    private final List<com.bytedance.adsdk.lottie.iz.u<PointF>> u;

    public pn(List<com.bytedance.adsdk.lottie.iz.u<PointF>> list) {
        this.u = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public List<com.bytedance.adsdk.lottie.iz.u<PointF>> fx() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public boolean nr() {
        return this.u.size() == 1 && this.u.get(0).pn();
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public com.bytedance.adsdk.lottie.u.nr.u<PointF, PointF> u() {
        return this.u.get(0).pn() ? new com.bytedance.adsdk.lottie.u.nr.t(this.u) : new com.bytedance.adsdk.lottie.u.nr.jk(this.u);
    }
}
