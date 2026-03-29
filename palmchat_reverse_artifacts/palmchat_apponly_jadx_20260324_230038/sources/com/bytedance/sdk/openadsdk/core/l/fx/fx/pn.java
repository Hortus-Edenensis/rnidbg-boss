package com.bytedance.sdk.openadsdk.core.l.fx.fx;

import com.bytedance.sdk.openadsdk.core.kj.bq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    @Override // com.bytedance.sdk.openadsdk.core.l.fx.fx.u
    public boolean fx() {
        this.fx = 2;
        int iMv = bq.mv(this.nr);
        if (iMv == 2) {
            return false;
        }
        if (iMv == 0) {
            return b();
        }
        return true;
    }
}
