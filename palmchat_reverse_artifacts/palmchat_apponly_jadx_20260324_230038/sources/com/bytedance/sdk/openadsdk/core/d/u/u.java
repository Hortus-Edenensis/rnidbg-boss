package com.bytedance.sdk.openadsdk.core.d.u;

import com.bytedance.sdk.openadsdk.core.q.b;
import com.bytedance.sdk.openadsdk.core.q.fx;
import com.bytedance.sdk.openadsdk.core.q.iz;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.openadsdk.core.q.nr.u {
    private List<com.bytedance.sdk.openadsdk.core.d.u> u = new CopyOnWriteArrayList();

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
    public void b(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        this.u.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_load", "loaded", izVar != null ? izVar.u() : System.currentTimeMillis()));
        Iterator<String> it = uVar.b.iterator();
        while (it.hasNext()) {
            ((com.bytedance.sdk.openadsdk.core.q.u.nr) b.u(1)).u(it.next(), new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.d.u.u.1
                @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
                public void u(com.bytedance.sdk.openadsdk.core.q.u uVar2) {
                    if (uVar2 instanceof com.bytedance.sdk.openadsdk.core.component.nr) {
                        ((com.bytedance.sdk.openadsdk.core.component.nr) uVar2).x.addAll(u.this.u);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
    public void fx(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        this.u.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_load", "receive", izVar != null ? izVar.u() : System.currentTimeMillis()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
    public void nr(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        this.u.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_load", HiAnalyticsConstant.Direction.REQUEST, izVar != null ? izVar.u() : System.currentTimeMillis()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
    public void u(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        this.u.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_load", "start", izVar != null ? izVar.u() : System.currentTimeMillis()));
    }
}
