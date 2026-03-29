package com.bytedance.sdk.openadsdk.core.component.reward.nr;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private nr b;
    private bc fx;
    private boolean iz = false;
    private final TTBaseVideoActivity nr;
    private pn pn;
    protected boolean u;

    public b(TTBaseVideoActivity tTBaseVideoActivity) {
        this.nr = tTBaseVideoActivity;
    }

    public boolean b() {
        nr nrVar = this.b;
        if (nrVar != null) {
            return nrVar.rh();
        }
        return false;
    }

    public void fx() {
        this.b.d();
        this.pn.u(this.nr.yd().gc());
    }

    public boolean iz() {
        return this.u;
    }

    public void nr() {
        if (q.nr(this.fx)) {
            if (this.b.pb() || b()) {
                boolean z = !this.u;
                this.u = z;
                this.b.u(z);
            }
        }
    }

    public boolean pn() {
        if (q.fx(this.fx)) {
            return this.b.wq();
        }
        return false;
    }

    public void u(nr nrVar, bc bcVar, String str, pn pnVar) {
        if (this.iz) {
            return;
        }
        this.iz = true;
        this.b = nrVar;
        this.fx = bcVar;
        this.pn = pnVar;
    }

    public void nr(boolean z) {
        this.b.iz(z);
    }

    public void u() {
        if (q.nr(this.fx) && !this.b.pb()) {
            b();
        }
    }

    public void u(boolean z) {
        nr nrVar = this.b;
        if (nrVar != null && nrVar.h()) {
            this.u = z;
            this.pn.b(z);
            this.b.u(this.u);
        }
    }

    public void u(boolean z, boolean z2) {
        this.b.kj();
        u(z);
        nr(z2);
    }

    public void u(int i, int i2) {
        this.b.nr(i, i2);
    }

    public void u(bc bcVar) {
        this.fx = bcVar;
    }
}
