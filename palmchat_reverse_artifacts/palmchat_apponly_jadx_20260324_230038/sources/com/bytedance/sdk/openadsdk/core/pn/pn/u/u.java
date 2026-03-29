package com.bytedance.sdk.openadsdk.core.pn.pn.u;

import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.pn.pn.pn;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends nr {
    private final AtomicBoolean u = new AtomicBoolean(false);
    private final AtomicBoolean nr = new AtomicBoolean(false);
    private final AtomicBoolean fx = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);

    public u(n.nr nrVar) {
        this.pn = nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.nr
    public void fx() {
        this.b.set(true);
        nr();
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar;
        if (this.fx.get() && (fxVar = this.x) != null) {
            u(fxVar, 2);
            return;
        }
        if (this.b.get()) {
            com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar2 = this.iz;
            if (fxVar2 != null) {
                u(fxVar2, 1);
            } else {
                u(null, 3);
            }
        }
    }

    public abstract void u();

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.nr
    public void u(pn pnVar, int i, String str) {
        this.n = pnVar;
        this.f5361a = i;
        this.jk = str;
        this.b.set(true);
        nr();
    }

    private void u(com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar, int i) {
        if (this.u.compareAndSet(false, true)) {
            if (i != 3) {
                if (fxVar != null) {
                    fxVar.u();
                }
            } else {
                pn pnVar = this.n;
                if (pnVar != null) {
                    pnVar.u(this.f5361a, this.jk);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.nr
    public void u(boolean z) {
        if (z) {
            this.fx.set(true);
            nr();
        } else {
            this.nr.set(true);
            u();
        }
    }
}
