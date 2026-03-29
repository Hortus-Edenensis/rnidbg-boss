package com.bytedance.sdk.openadsdk.core.l;

import com.bytedance.sdk.openadsdk.core.y.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements u.nr {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static nr u = new nr();
    }

    public static nr fx() {
        return u.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void nr() {
        com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("dl_work") { // from class: com.bytedance.sdk.openadsdk.core.l.nr.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.n.o().u(a.u());
            }
        });
    }

    private nr() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB != null) {
            uVarB.u(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void u() {
    }
}
