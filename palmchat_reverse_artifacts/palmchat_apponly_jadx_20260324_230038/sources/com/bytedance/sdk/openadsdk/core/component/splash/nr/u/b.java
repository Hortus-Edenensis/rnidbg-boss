package com.bytedance.sdk.openadsdk.core.component.splash.nr.u;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.gi.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.sdk.openadsdk.core.component.splash.fx.nr.u {
    private x u = new x();

    private void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<n, x> fxVar) {
        if (nrVar == null || fxVar == null) {
            return;
        }
        this.u.nr(nrVar.s());
        this.u.u(nrVar.nr());
        int iA = nrVar.a();
        com.bykv.vk.openvk.component.video.api.fx.b bVarN = nrVar.n();
        this.u.u(true);
        if (bVarN == null) {
            this.u.nr(2);
            this.u.u("no video info");
            fxVar.u(this.u);
            return;
        }
        String strL = bVarN.l();
        if (TextUtils.isEmpty(strL)) {
            this.u.nr(2);
            this.u.u("no video url");
            fxVar.u(this.u);
            return;
        }
        String strK = bVarN.k();
        if (TextUtils.isEmpty(strK)) {
            strK = com.bytedance.sdk.component.utils.x.nr(strL);
        }
        if (TextUtils.isEmpty(strK)) {
            this.u.nr(2);
            this.u.u("no video cahce filename");
            fxVar.u(this.u);
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "加载视频素材");
        bc bcVarNr = nrVar.nr();
        if (bcVarNr == null) {
            return;
        }
        boolean zJk = nrVar.jk();
        bVarN.pn(1);
        if (bVarN.my() == 0) {
            bVarN.b(307200);
        }
        iz izVarU = zJk ? zx.u(2, bcVarNr) : zx.u(3, bcVarNr);
        izVarU.u("material_meta", bcVarNr);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jk.u(bcVarNr.oi()).u(izVarU)) {
            n nVar = new n(nrVar.nr(), nrVar.s());
            nVar.u(true);
            nVar.fx(true);
            nVar.u(nrVar.u());
            nVar.pn(nrVar.fx());
            fxVar.nr(nVar);
            izVarU.a(1);
            com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVarU, bcVarNr, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return;
        }
        if (dw.nr().x(String.valueOf(iA)) && !o.b(dw.getContext())) {
            this.u.nr(2);
            this.u.u(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
            fxVar.u(this.u);
        } else {
            if (nrVar.nr() == null || nrVar.nr().ju() != 3) {
                com.bykv.vk.openvk.component.video.u.u.u();
                u(izVarU, nrVar, nrVar.nr(), fxVar);
                return;
            }
            n nVar2 = new n(nrVar.nr(), nrVar.s());
            nVar2.u(true);
            nVar2.fx(false);
            nVar2.u(nrVar.u());
            nVar2.pn(nrVar.fx());
            nVar2.u(zx.u(nrVar.nr()));
            fxVar.nr(nVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.nr.u
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<n, x> fxVar) {
        nr(nrVar, fxVar);
    }

    private void u(iz izVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar, bc bcVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<n, x> fxVar) {
        if (bcVar == null || fxVar == null || nrVar == null || izVar == null || zx.k(bcVar) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVar, new com.bykv.vk.openvk.component.video.api.pn.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.b.1
            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void u(iz izVar2, int i) {
                if (fxVar != null) {
                    n nVar = new n(nrVar.nr(), nrVar.s());
                    nVar.u(true);
                    nVar.fx(false);
                    nVar.u((com.bytedance.sdk.component.a.nr) null);
                    nVar.u(nrVar.u());
                    nVar.pn(nrVar.fx());
                    fxVar.nr(nVar);
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void u(iz izVar2, int i, String str) {
                if (fxVar != null) {
                    b.this.u.nr(2);
                    b.this.u.u("preload video fail");
                    fxVar.u(b.this.u);
                }
            }
        });
    }
}
