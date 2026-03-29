package com.bytedance.sdk.openadsdk.core.component.u;

import com.bytedance.sdk.openadsdk.bq.u.nr.u.pn;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.core.pn.u<pn, List<mv>> {
    private static final u nr = new u();

    private u() {
    }

    public static u b() {
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public int u() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public void u(pn pnVar, List<mv> list) {
        if (pnVar != null) {
            pnVar.u(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public void u(pn pnVar, int i, String str) {
        if (pnVar != null) {
            pnVar.u(i, str);
        }
    }
}
