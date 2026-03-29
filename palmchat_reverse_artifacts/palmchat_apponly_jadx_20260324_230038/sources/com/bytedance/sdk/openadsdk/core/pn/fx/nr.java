package com.bytedance.sdk.openadsdk.core.pn.fx;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.gi.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements u {
    private int u;

    public nr(int i) {
        this.u = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(bc bcVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void nr(String str) {
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).nr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar, Object obj, boolean z) {
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
        x.b(new a("PreloadStrategyLoadDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.nr.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.pn.b.pn.u(nr.this.u).u(nrVar, bcVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public bc u(String str, long j) {
        bc bcVarU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, false, j);
        if (bcVarU != null) {
            com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, bcVarU.nu());
        }
        return bcVarU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public List<bc> u(String str, long j, int i) {
        List<bc> listU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, false, j, i);
        Iterator<bc> it = listU.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, it.next().nu());
        }
        listU.size();
        return listU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(String str, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.u).u(str, bcVar.nu());
    }
}
