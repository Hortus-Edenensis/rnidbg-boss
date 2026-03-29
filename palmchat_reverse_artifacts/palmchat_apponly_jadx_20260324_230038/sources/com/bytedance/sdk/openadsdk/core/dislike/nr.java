package com.bytedance.sdk.openadsdk.core.dislike;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static com.bytedance.sdk.openadsdk.core.dislike.u.b nr;
    private static com.bytedance.sdk.openadsdk.core.dislike.u.fx u;

    public static void u() {
        if (nr == null) {
            nr = new com.bytedance.sdk.openadsdk.core.dislike.u.b() { // from class: com.bytedance.sdk.openadsdk.core.dislike.nr.1
                @Override // com.bytedance.sdk.openadsdk.core.dislike.u.b
                public int u(Context context, float f) {
                    return y.fx(context, f);
                }
            };
        }
        if (u == null) {
            u = new com.bytedance.sdk.openadsdk.core.dislike.u.fx() { // from class: com.bytedance.sdk.openadsdk.core.dislike.nr.2
                @Override // com.bytedance.sdk.openadsdk.core.dislike.u.fx
                public void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, iz izVar) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(nrVar, izVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.u.fx
                public void u(Context context, com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, String str) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(nrVar.b(), nrVar.pn(), nrVar.n(), str);
                }
            };
        }
        com.bytedance.sdk.openadsdk.core.dislike.u.u.u(u, nr);
    }
}
