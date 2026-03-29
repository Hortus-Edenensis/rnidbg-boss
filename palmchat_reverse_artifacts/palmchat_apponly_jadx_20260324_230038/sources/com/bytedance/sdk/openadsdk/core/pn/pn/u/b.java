package com.bytedance.sdk.openadsdk.core.pn.pn.u;

import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.pn.pn.pn;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends nr implements Runnable {
    private final AtomicBoolean u = new AtomicBoolean(false);
    private final AtomicBoolean nr = new AtomicBoolean(false);
    private final AtomicBoolean fx = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean l = new AtomicBoolean(false);

    public b(n.nr nrVar) {
        this.pn = nrVar;
    }

    private long b() {
        n.nr nrVar = this.pn;
        if (nrVar == null || nrVar.iz() <= 0) {
            return 10000L;
        }
        return this.pn.iz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.nr
    public void fx() {
        this.l.set(true);
        nr();
    }

    public void nr() {
        if (!this.l.get()) {
            if (this.u.get() && this.b.get()) {
                com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar = this.x;
                u(fxVar, fxVar != null ? 2 : 3);
                return;
            }
            return;
        }
        jk.nr().removeCallbacks(this);
        com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar2 = this.iz;
        if (fxVar2 != null) {
            u(fxVar2, 1);
            return;
        }
        if (this.b.get()) {
            com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar3 = this.x;
            if (fxVar3 != null) {
                u(fxVar3, 2);
            } else {
                u(null, 3);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.u.set(true);
        nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.nr
    public void u(pn pnVar, int i, String str) {
        this.n = pnVar;
        this.f5361a = i;
        this.jk = str;
        this.fx.set(true);
        this.l.set(true);
        nr();
    }

    public void u() {
        jk.nr().postDelayed(this, b());
    }

    private void u(com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar, int i) {
        com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar2;
        com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar3;
        if (this.nr.compareAndSet(false, true)) {
            this.t = i;
            if (i == 3) {
                pn pnVar = this.n;
                if (pnVar != null) {
                    pnVar.u(this.f5361a, this.jk);
                }
            } else if (fxVar != null) {
                fxVar.u();
            }
            if (i == 1 && (fxVar3 = this.x) != null) {
                fxVar3.fx();
            }
            if (i != 2 || (fxVar2 = this.iz) == null) {
                return;
            }
            fxVar2.fx();
            return;
        }
        if (i == this.t || fxVar == null) {
            return;
        }
        fxVar.fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.nr
    public void u(boolean z) {
        this.b.set(true);
        nr();
    }
}
