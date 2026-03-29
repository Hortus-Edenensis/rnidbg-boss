package com.bytedance.sdk.openadsdk.core.pn.pn;

import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private com.bytedance.sdk.openadsdk.core.pn.u.u b;
    protected com.bytedance.sdk.openadsdk.core.pn.fx.u fx;
    protected int nr;
    private com.bytedance.sdk.openadsdk.core.pn.u.u pn;
    protected n.nr u;

    public nr(int i) {
        this.nr = i;
        this.u = n.u(i);
        fx();
        b();
    }

    private void b() {
        int i = this.nr;
        if (i == 1) {
            this.pn = new com.bytedance.sdk.openadsdk.core.pn.b(this, i);
            this.b = new com.bytedance.sdk.openadsdk.core.component.u.nr(this);
            return;
        }
        switch (i) {
            case 5:
                this.pn = new com.bytedance.sdk.openadsdk.core.pn.b(this, i);
                this.b = new com.bytedance.sdk.openadsdk.core.component.fx.nr(this);
                break;
            case 6:
                this.b = new com.bytedance.sdk.openadsdk.core.component.b.nr(this);
                break;
            case 7:
                this.b = new com.bytedance.sdk.openadsdk.core.component.reward.u.x(this);
                break;
            case 8:
                this.b = new com.bytedance.sdk.openadsdk.core.component.reward.u.u(this);
                break;
            case 9:
                this.pn = new com.bytedance.sdk.openadsdk.core.pn.b(this, i);
                this.b = new com.bytedance.sdk.openadsdk.core.component.nr.nr(this);
                break;
        }
    }

    private void fx() {
        int iNr = nr();
        if (iNr == -1) {
            this.fx = new com.bytedance.sdk.openadsdk.core.pn.fx.fx(this.nr);
            return;
        }
        if (iNr == 0) {
            this.fx = new com.bytedance.sdk.openadsdk.core.pn.fx.nr(this.nr);
            return;
        }
        if (iNr == 1) {
            this.fx = new com.bytedance.sdk.openadsdk.core.pn.fx.pn(this.nr);
        } else if (iNr != 3) {
            this.fx = u.nr(this.nr);
        } else {
            this.fx = new com.bytedance.sdk.openadsdk.core.pn.fx.b(this.nr);
        }
    }

    private int nr() {
        n.nr nrVar = this.u;
        if (nrVar == null) {
            return -2;
        }
        if (nrVar.x() && dw.nr().sv()) {
            return this.u.b();
        }
        return -1;
    }

    public boolean u(bc bcVar) {
        return com.bytedance.sdk.openadsdk.core.live.nr.u().fx(bcVar) != 3;
    }

    public com.bytedance.sdk.openadsdk.core.pn.fx.u u() {
        return this.fx;
    }

    public com.bytedance.sdk.openadsdk.core.pn.u.u u(boolean z) {
        com.bytedance.sdk.openadsdk.core.pn.u.u uVar;
        return (!z || (uVar = this.pn) == null) ? this.b : uVar;
    }
}
