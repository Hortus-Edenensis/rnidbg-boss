package com.bytedance.sdk.openadsdk.core.component.reward.u;

import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.pn.nr;
import com.bytedance.sdk.openadsdk.core.y.q;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends iz<com.bytedance.sdk.openadsdk.core.component.reward.fx> {
    public x(com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar) {
        super(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public /* synthetic */ void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List list, com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar) {
        u(nrVar, (List<bc>) list, fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public boolean u() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, nr.u<com.bytedance.sdk.openadsdk.core.component.reward.fx> uVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx(dw.getContext(), list.get(0), nrVar);
        if (uVar != null) {
            uVar.u(fxVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public boolean u(com.bytedance.sdk.openadsdk.core.kj.u uVar) {
        List<bc> listNr;
        if (uVar != null && (listNr = uVar.nr()) != null) {
            bc bcVar = listNr.get(0);
            if (ja.nr(u(), bcVar, false) && ja.b(bcVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.iz
    public void u(com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar) {
        fxVar.fx(1);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar) {
        bc bcVar = list.get(0);
        if (bcVar.qn() <= 0) {
            fxVar.u(System.currentTimeMillis() + 10500000);
        } else {
            fxVar.u(bcVar.qn() * 1000);
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar) || q.fx(bcVar) || wi.u(bcVar) || !bcVar.ah()) {
            return;
        }
        fxVar.u();
    }
}
