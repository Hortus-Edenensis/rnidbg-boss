package com.bytedance.adsdk.lottie.u.u;

import com.bytedance.adsdk.lottie.model.nr.bg;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class dw implements u.InterfaceC0166u, fx {
    private final bg.u b;
    private final List<u.InterfaceC0166u> fx = new ArrayList();
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> iz;
    private final boolean nr;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> pn;
    private final String u;
    private final com.bytedance.adsdk.lottie.u.nr.u<?, Float> x;

    public dw(com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.bg bgVar) {
        this.u = bgVar.u();
        this.nr = bgVar.pn();
        this.b = bgVar.getType();
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = bgVar.fx().u();
        this.pn = uVarU;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU2 = bgVar.nr().u();
        this.iz = uVarU2;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU3 = bgVar.b().u();
        this.x = uVarU3;
        fxVar.u(uVarU);
        fxVar.u(uVarU2);
        fxVar.u(uVarU3);
        uVarU.u(this);
        uVarU2.u(this);
        uVarU3.u(this);
    }

    public com.bytedance.adsdk.lottie.u.nr.u<?, Float> b() {
        return this.x;
    }

    public com.bytedance.adsdk.lottie.u.nr.u<?, Float> fx() {
        return this.iz;
    }

    public bg.u getType() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.u.nr.u<?, Float> nr() {
        return this.pn;
    }

    public boolean pn() {
        return this.nr;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        for (int i = 0; i < this.fx.size(); i++) {
            this.fx.get(i).u();
        }
    }

    public void u(u.InterfaceC0166u interfaceC0166u) {
        this.fx.add(interfaceC0166u);
    }
}
