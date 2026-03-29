package com.bytedance.sdk.openadsdk.core.component.reward.u;

import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u u = new com.bytedance.sdk.openadsdk.core.pn.fx.nr(7);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u nr = new com.bytedance.sdk.openadsdk.core.pn.fx.nr(8);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u fx = new com.bytedance.sdk.openadsdk.core.pn.fx.pn(7);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u b = new com.bytedance.sdk.openadsdk.core.pn.fx.pn(8);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u pn = new com.bytedance.sdk.openadsdk.core.pn.fx.b(7);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u iz = new com.bytedance.sdk.openadsdk.core.pn.fx.b(8);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u x = new com.bytedance.sdk.openadsdk.core.pn.fx.fx(7);
    private static final com.bytedance.sdk.openadsdk.core.pn.fx.u n = new com.bytedance.sdk.openadsdk.core.pn.fx.fx(8);

    public static int u(boolean z) {
        n.nr nrVarU = com.bytedance.sdk.openadsdk.core.kj.n.u(z ? 7 : 8);
        if (!nrVarU.x() || !dw.nr().sv()) {
            return -1;
        }
        int iB = nrVarU.b();
        if (iB < 0 || iB == 2 || iB > 4) {
            return 1;
        }
        return iB;
    }

    public static com.bytedance.sdk.openadsdk.core.pn.fx.u u(boolean z, boolean z2, boolean z3) {
        if (z2 || z3) {
            return z ? x : n;
        }
        int iU = u(z);
        return iU != -1 ? iU != 0 ? iU != 3 ? z ? fx : b : z ? pn : iz : z ? u : nr : z ? x : n;
    }
}
