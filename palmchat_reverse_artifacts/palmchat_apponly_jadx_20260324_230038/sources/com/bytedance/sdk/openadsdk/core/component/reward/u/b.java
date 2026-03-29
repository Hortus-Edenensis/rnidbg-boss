package com.bytedance.sdk.openadsdk.core.component.reward.u;

import com.bytedance.sdk.openadsdk.my.fx.nr.k;
import com.bytedance.sdk.openadsdk.my.fx.nr.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private com.bytedance.sdk.openadsdk.bq.u.nr.u.b nr;
    private com.bytedance.sdk.openadsdk.bq.u.nr.u.x u;

    public b(com.bytedance.sdk.openadsdk.bq.u.nr.u.x xVar) {
        this.u = xVar;
    }

    public void nr(Object obj) {
        com.bytedance.sdk.openadsdk.bq.u.nr.u.x xVar = this.u;
        if (xVar != null && (obj instanceof k)) {
            xVar.nr();
            this.u.nr((k) obj);
        }
        com.bytedance.sdk.openadsdk.bq.u.nr.u.b bVar = this.nr;
        if (bVar == null || !(obj instanceof t)) {
            return;
        }
        bVar.nr();
        this.nr.nr((t) obj);
    }

    public void u(int i, String str) {
        com.bytedance.sdk.openadsdk.bq.u.nr.u.x xVar = this.u;
        if (xVar != null) {
            xVar.u(i, str);
        }
        com.bytedance.sdk.openadsdk.bq.u.nr.u.b bVar = this.nr;
        if (bVar != null) {
            bVar.u(i, str);
        }
    }

    public b(com.bytedance.sdk.openadsdk.bq.u.nr.u.b bVar) {
        this.nr = bVar;
    }

    public void u(Object obj) {
        com.bytedance.sdk.openadsdk.bq.u.nr.u.x xVar = this.u;
        if (xVar != null && (obj instanceof k)) {
            xVar.u((k) obj);
        }
        com.bytedance.sdk.openadsdk.bq.u.nr.u.b bVar = this.nr;
        if (bVar == null || !(obj instanceof t)) {
            return;
        }
        bVar.u((t) obj);
    }

    public long u() {
        Object obj = this.u;
        if (obj != null) {
            return obj instanceof com.bytedance.sdk.openadsdk.core.u.nr ? ((com.bytedance.sdk.openadsdk.core.u.nr) obj).u() : System.currentTimeMillis();
        }
        Object obj2 = this.nr;
        if (obj2 != null) {
            return obj2 instanceof com.bytedance.sdk.openadsdk.core.u.nr ? ((com.bytedance.sdk.openadsdk.core.u.nr) obj2).u() : System.currentTimeMillis();
        }
        return 0L;
    }
}
