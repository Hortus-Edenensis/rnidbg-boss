package com.bytedance.sdk.openadsdk.core.component.nr;

import com.bytedance.sdk.openadsdk.my.fx.nr.a;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.core.pn.u<com.bytedance.sdk.openadsdk.bq.u.nr.u.nr, List<a>> {
    private static final u nr = new u();

    private u() {
    }

    public static u b() {
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public int u() {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public void u(com.bytedance.sdk.openadsdk.bq.u.nr.u.nr nrVar, List<a> list) {
        if (nrVar != null) {
            nrVar.u(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public void u(com.bytedance.sdk.openadsdk.bq.u.nr.u.nr nrVar, int i, String str) {
        if (nrVar != null) {
            nrVar.u(i, str);
        }
    }
}
