package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private com.bytedance.sdk.openadsdk.b.u.nr.u.nr u;

    public boolean fx() {
        return d.fx < 4700 || this.u == null;
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.b.u.nr.u.nr nrVar;
        if (d.fx < 4700 || (nrVar = this.u) == null) {
            return;
        }
        nrVar.u();
    }

    public void u(com.bytedance.sdk.openadsdk.b.u.nr.u.nr nrVar) {
        this.u = nrVar;
    }

    public void u() {
        com.bytedance.sdk.openadsdk.b.u.nr.u.nr nrVar;
        if (d.fx < 4700 || (nrVar = this.u) == null) {
            return;
        }
        nrVar.nr();
        this.u = null;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        com.bytedance.sdk.openadsdk.b.u.nr.u.nr nrVar2;
        if (d.fx < 4700 || (nrVar2 = this.u) == null) {
            return;
        }
        nrVar2.u(nrVar);
    }
}
