package com.bytedance.sdk.openadsdk.core.component.b;

import com.bytedance.sdk.openadsdk.bq.u.nr.u.fx;
import com.bytedance.sdk.openadsdk.my.fx.nr.jk;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.core.pn.u<fx, List<jk>> {
    private static final u nr = new u();

    private u() {
    }

    public static u b() {
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public int u() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public void u(fx fxVar, List<jk> list) {
        if (fxVar != null) {
            fxVar.u(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u
    public void u(fx fxVar, int i, String str) {
        if (fxVar != null) {
            fxVar.u(i, str);
        }
    }
}
