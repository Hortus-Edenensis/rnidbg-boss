package com.bytedance.sdk.openadsdk.core.component.splash.fx.fx;

import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private com.bytedance.sdk.openadsdk.my.fx.nr.nr b;
    private b<a, x> fx;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx nr;
    private com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr u;

    public u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx fxVar, b<a, x> bVar, com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar) {
        if (fxVar == null || bVar == null) {
            return;
        }
        this.nr = fxVar;
        this.fx = bVar;
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr(fxVar.getContext(), fxVar.x(), fxVar.iz(), this.nr.n(), fxVar, bVar, uVar);
        this.u = nrVar;
        this.b = nrVar;
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr nrVar = this.u;
        if (nrVar != null) {
            nrVar.u(this.nr, this.fx);
        }
    }

    public void u(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr nrVar = this.u;
        if (nrVar != null) {
            nrVar.fx(i);
        }
    }

    public void u(iz izVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx fxVar = this.nr;
        if (fxVar == null || fxVar.b == null || izVar == null) {
            return;
        }
        boolean zU = izVar.u();
        this.nr.b.u(zU);
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr nrVar = this.u;
        if (nrVar != null) {
            nrVar.nr(zU);
        }
    }

    public com.bytedance.sdk.openadsdk.my.fx.nr.nr u() {
        return this.b;
    }
}
