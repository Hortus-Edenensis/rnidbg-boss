package com.bytedance.adsdk.ugeno.pn.nr;

import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sx f5039a;

    public fx(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
        super(fxVar, str, uVar);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.nr.u
    public void u() {
        sx sxVarC = this.fx.c();
        this.f5039a = sxVarC;
        if (sxVarC != null) {
            sxVarC.u(this.fx, this.x, this.nr);
        }
    }
}
