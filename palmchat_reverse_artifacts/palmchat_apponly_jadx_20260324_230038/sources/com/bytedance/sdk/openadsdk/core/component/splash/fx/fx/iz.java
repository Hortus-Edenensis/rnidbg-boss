package com.bytedance.sdk.openadsdk.core.component.splash.fx.fx;

import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.kj.tk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private fx<n, x> fx;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nr;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.nr.u u;

    public iz(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar, fx<n, x> fxVar) {
        if (nrVar == null || fxVar == null) {
            return;
        }
        this.nr = nrVar;
        this.fx = fxVar;
        if (nrVar.t() == 1) {
            this.u = new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.nr();
        } else {
            this.u = new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.b();
        }
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar = this.nr;
        if (nrVar == null || this.fx == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.fx.nr.u uVar = this.u;
        if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.nr.u.nr) {
            uVar.u(nrVar, new fx<n, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.iz.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
                public void nr(n nVar) {
                    if (nVar != null) {
                        nVar.pn(true);
                    }
                    iz.this.fx.nr(nVar);
                    com.bytedance.sdk.openadsdk.core.component.splash.x.u(iz.this.nr.l());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void fx(n nVar) {
                    if (nVar != null) {
                        nVar.pn(false);
                    }
                    iz.this.fx.fx(nVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
                public void u(x xVar) {
                    iz.this.fx.u(xVar);
                }
            });
        } else {
            uVar.u(nrVar, new fx<n, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.iz.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
                public void nr(n nVar) {
                    if (nVar != null) {
                        nVar.pn(true);
                    }
                    iz.this.fx.nr(nVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void fx(n nVar) {
                    if (nVar != null) {
                        nVar.pn(false);
                    }
                    iz.this.fx.fx(nVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
                public void u(x xVar) {
                    if (iz.this.nr.mv() && iz.this.nr.nr() != null) {
                        tk.u(iz.this.nr.nr(), 1);
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.nr().u(iz.this.nr, iz.this.fx);
                }
            });
        }
    }

    public boolean u() {
        return this.u instanceof com.bytedance.sdk.openadsdk.core.component.splash.nr.u.b;
    }
}
