package com.bytedance.sdk.component.n.nr.nr.fx;

import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    protected final com.bytedance.sdk.component.n.nr.nr.nr fx;
    protected final com.bytedance.sdk.component.n.u.pn nr;
    private volatile fx u;

    public b(com.bytedance.sdk.component.n.u.pn pnVar, com.bytedance.sdk.component.n.nr.nr.nr nrVar) {
        this.nr = pnVar;
        this.fx = nrVar;
    }

    public void iz() {
        com.bytedance.sdk.component.n.u.b bVarB = this.nr.b();
        if (bVarB != null && bVarB.nr() != null) {
            fx();
            return;
        }
        fx fxVarPn = pn();
        fxVarPn.u(this);
        fxVarPn.start();
    }

    public fx pn() {
        if (this.u == null) {
            synchronized (this) {
                if (this.u == null) {
                    this.u = new fx();
                }
            }
        }
        return this.u;
    }

    public Looper x() {
        com.bytedance.sdk.component.n.u.b bVarB = this.nr.b();
        return (bVarB == null || bVarB.nr() == null) ? pn().getLooper() : bVarB.nr();
    }

    public void fx() {
    }
}
