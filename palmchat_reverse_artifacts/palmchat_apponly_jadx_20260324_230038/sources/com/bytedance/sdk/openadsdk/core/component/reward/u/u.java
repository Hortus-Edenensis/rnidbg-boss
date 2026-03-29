package com.bytedance.sdk.openadsdk.core.component.reward.u;

import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.pn.nr;
import com.bytedance.sdk.openadsdk.core.y.q;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends iz<com.bytedance.sdk.openadsdk.core.component.reward.nr> {
    public u(com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar) {
        super(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public /* synthetic */ void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List list, com.bytedance.sdk.openadsdk.core.component.reward.nr nrVar2) {
        u(nrVar, (List<bc>) list, nrVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public boolean u() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, nr.u<com.bytedance.sdk.openadsdk.core.component.reward.nr> uVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.nr nrVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.nr(dw.getContext(), list.get(0), nrVar);
        if (uVar != null) {
            uVar.u(nrVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public boolean u(com.bytedance.sdk.openadsdk.core.kj.u uVar) {
        List<bc> listNr;
        if (uVar != null && (listNr = uVar.nr()) != null) {
            bc bcVar = listNr.get(0);
            if (gi.u(bcVar)) {
                return bcVar.tw().fx() != 1;
            }
            if (ja.nr(u(), bcVar, false) && ja.b(bcVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public void u(com.bytedance.sdk.openadsdk.core.component.reward.nr nrVar) {
        nrVar.u(1);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, com.bytedance.sdk.openadsdk.core.component.reward.nr nrVar2) {
        bc bcVar = list.get(0);
        if (bcVar.qn() <= 0) {
            nrVar2.u(System.currentTimeMillis() + 10500000);
        } else {
            nrVar2.u(bcVar.qn() * 1000);
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar) || q.fx(bcVar) || wi.u(bcVar) || !bcVar.ah()) {
            return;
        }
        nrVar2.u();
    }
}
