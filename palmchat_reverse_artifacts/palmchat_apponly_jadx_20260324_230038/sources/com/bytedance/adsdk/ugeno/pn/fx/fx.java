package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends nr implements com.bytedance.adsdk.ugeno.pn.u.b {
    private com.bytedance.adsdk.ugeno.pn.u.fx t;

    public fx(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        com.bytedance.adsdk.ugeno.pn.u.u uVarY = this.nr.y();
        if (uVarY == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.pn.u.fx fxVarU = uVarY.u(this.iz);
        this.t = fxVarU;
        if (fxVarU != null) {
            fxVarU.u(this);
            return false;
        }
        uVarY.u(this.iz, new com.bytedance.adsdk.ugeno.pn.u.nr());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.pn.u.b
    public void u(String str) {
        this.u.u(this.nr, this.iz, this.fx.nr());
    }
}
