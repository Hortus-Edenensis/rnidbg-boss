package com.bytedance.sdk.openadsdk.core.l.fx.fx;

import com.bytedance.sdk.openadsdk.core.kj.bq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private boolean pn = false;
    private int iz = 0;
    private boolean x = false;

    public void fx(boolean z) {
        this.x = z;
    }

    public void nr(boolean z) {
        this.pn = z;
    }

    public void u(int i) {
        this.iz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.fx.u
    public boolean fx() {
        this.fx = 1;
        boolean z = iz.b;
        int iL = bq.l(this.nr);
        if (z) {
            iL = 0;
            iz.b = false;
        }
        if (this.x) {
            return b();
        }
        if (this.pn) {
            int i = this.iz;
            if (i == 2) {
                return b();
            }
            if (iL == 2 && i == 1) {
                return b();
            }
        }
        if (iL == 0) {
            return b();
        }
        return true;
    }
}
