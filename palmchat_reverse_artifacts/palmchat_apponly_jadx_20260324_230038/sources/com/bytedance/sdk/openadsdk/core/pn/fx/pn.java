package com.bytedance.sdk.openadsdk.core.pn.fx;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements u {
    private final int u;

    public pn(int i) {
        this.u = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar, Object obj, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void nr(String str) {
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).nr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public boolean u(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final bc bcVar) {
        if (bcVar.qn() <= 0) {
            bcVar.pn((System.currentTimeMillis() + 10500000) / 1000);
        }
        x.b(new a("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.pn.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.pn.b.pn.u(pn.this.u).u(nrVar, bcVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public bc u(String str, long j) {
        return com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, false, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public List<bc> u(String str, long j, int i) {
        List<bc> listU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, false, j, i);
        listU.size();
        return listU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(String str, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, bcVar.nu());
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(final bc bcVar) {
        final int iT = jp.t(bcVar);
        x.u(new a("PreloadStrategyShowDelete-onShow") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.pn.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.pn.b.pn pnVarU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(pn.this.u);
                StringBuilder sb = new StringBuilder();
                sb.append(iT);
                pnVarU.u(sb.toString(), bcVar.nu());
            }
        });
    }
}
