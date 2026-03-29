package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.dw;
import com.bytedance.sdk.component.fx.nr.rh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends rh {
    private final com.bytedance.sdk.component.fx.u.pn fx;
    private final long nr;
    private final String u;

    public n(String str, long j, com.bytedance.sdk.component.fx.u.pn pnVar) {
        this.u = str;
        this.nr = j;
        this.fx = pnVar;
    }

    @Override // com.bytedance.sdk.component.fx.nr.rh
    public com.bytedance.sdk.component.fx.u.pn fx() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.fx.nr.rh
    public long nr() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.fx.nr.rh
    public dw u() {
        String str = this.u;
        if (str != null) {
            return dw.u(str);
        }
        return null;
    }
}
