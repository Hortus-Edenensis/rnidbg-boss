package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s extends u<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u<Float, Float> f5008a;
    protected com.bytedance.adsdk.lottie.iz.fx<Float> b;
    private final PointF iz;
    private final u<Float, Float> n;
    protected com.bytedance.adsdk.lottie.iz.fx<Float> pn;
    private final PointF x;

    public s(u<Float, Float> uVar, u<Float, Float> uVar2) {
        super(Collections.emptyList());
        this.iz = new PointF();
        this.x = new PointF();
        this.n = uVar;
        this.f5008a = uVar2;
        u(n());
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF x() {
        return u(null, 0.0f);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public PointF u(com.bytedance.adsdk.lottie.iz.u<PointF> uVar, float f) {
        Float fU;
        com.bytedance.adsdk.lottie.iz.u<Float> uVarFx;
        com.bytedance.adsdk.lottie.iz.u<Float> uVarFx2;
        Float fU2 = null;
        if (this.b == null || (uVarFx2 = this.n.fx()) == null) {
            fU = null;
        } else {
            float fPn = this.n.pn();
            Float f2 = uVarFx2.x;
            com.bytedance.adsdk.lottie.iz.fx<Float> fxVar = this.b;
            float f3 = uVarFx2.iz;
            fU = fxVar.u(f3, f2 == null ? f3 : f2.floatValue(), uVarFx2.u, uVarFx2.nr, f, f, fPn);
        }
        if (this.pn != null && (uVarFx = this.f5008a.fx()) != null) {
            float fPn2 = this.f5008a.pn();
            Float f4 = uVarFx.x;
            com.bytedance.adsdk.lottie.iz.fx<Float> fxVar2 = this.pn;
            float f5 = uVarFx.iz;
            fU2 = fxVar2.u(f5, f4 == null ? f5 : f4.floatValue(), uVarFx.u, uVarFx.nr, f, f, fPn2);
        }
        if (fU == null) {
            this.x.set(this.iz.x, 0.0f);
        } else {
            this.x.set(fU.floatValue(), 0.0f);
        }
        if (fU2 == null) {
            PointF pointF = this.x;
            pointF.set(pointF.x, this.iz.y);
        } else {
            PointF pointF2 = this.x;
            pointF2.set(pointF2.x, fU2.floatValue());
        }
        return this.x;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    public void u(float f) {
        this.n.u(f);
        this.f5008a.u(f);
        this.iz.set(this.n.x().floatValue(), this.f5008a.x().floatValue());
        for (int i = 0; i < this.u.size(); i++) {
            this.u.get(i).u();
        }
    }
}
