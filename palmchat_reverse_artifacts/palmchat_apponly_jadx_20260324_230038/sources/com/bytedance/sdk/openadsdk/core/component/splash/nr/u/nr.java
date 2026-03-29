package com.bytedance.sdk.openadsdk.core.component.splash.nr.u;

import com.bytedance.sdk.component.iz.bq;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.bg;
import com.bytedance.sdk.openadsdk.core.y.o;
import com.bytedance.sdk.openadsdk.gi.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.openadsdk.core.component.splash.fx.nr.u {
    private x u = new x();

    private void nr(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<n, x> fxVar) {
        if (nrVar == null || fxVar == null) {
            return;
        }
        this.u.nr(nrVar.s());
        this.u.u(nrVar.nr());
        if (dw.nr().n(nrVar.a()) == 4) {
            n nVar = new n(nrVar.nr(), nrVar.s());
            nVar.u(false);
            nVar.u(nrVar.u());
            nVar.u(nrVar.fx());
            fxVar.nr(nVar);
            return;
        }
        com.bytedance.sdk.openadsdk.mv.nr nrVarPn = nrVar.pn();
        if (nrVarPn == null) {
            this.u.nr(2);
            this.u.u("image request fail");
            this.u.u(false);
            fxVar.u(this.u);
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "加载图片素材 " + nrVar.nr().xx());
        bg.u(nrVarPn, nrVar.iz(), nrVar.x(), new bg.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.y.bg.u
            public void u(com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar2, my myVar) {
                n nVar2 = new n(nrVar2, nrVar.nr(), nrVar.s());
                nVar2.u(false);
                nVar2.u(nrVar.u());
                nVar2.pn(nrVar.fx());
                if (myVar != null) {
                    nVar2.u(myVar.getHeaders());
                    nVar2.nr(myVar.isLocal());
                    nVar2.nr(o.u(myVar.getHeaders()));
                    if (myVar.getHttpTime() != null) {
                        nVar2.nr(myVar.getHttpTime().getFirstFrameTime());
                        nVar2.fx(myVar.getHttpTime().getStartRequestTime());
                        nVar2.b(myVar.getHttpTime().getEndRequestTime());
                    }
                }
                fxVar.nr(nVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.bg.u
            public void u() {
                nr.this.u.nr(2);
                nr.this.u.u("load image fail");
                nr.this.u.u(false);
                fxVar.u(nr.this.u);
            }
        }, jk.pn(), 4, new bq() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.nr.2
            @Override // com.bytedance.sdk.component.iz.bq
            public void onStep(int i, Object obj) {
                if (i == 3 && nr.this.u(nrVar)) {
                    n nVar2 = new n(nrVar.nr(), nrVar.s());
                    nVar2.u(false);
                    nVar2.u(nrVar.u());
                    nVar2.u(nrVar.fx());
                    nVar2.b(true);
                    nVar2.nr(false);
                    fxVar.fx(nVar2);
                }
            }
        }, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.nr.u
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<n, x> fxVar) {
        nr(nrVar, fxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar) {
        bc bcVarNr;
        if (nrVar == null || (bcVarNr = nrVar.nr()) == null) {
            return false;
        }
        int iJw = bcVarNr.jw();
        return iJw == 3 || iJw == 4;
    }
}
