package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    private Map<String, Object> b;
    private com.bytedance.sdk.component.t.u.u fx;
    private com.bytedance.sdk.openadsdk.core.a.u.u.u nr;
    private String pn;
    private bc u;

    public pn(com.bytedance.sdk.openadsdk.core.a.u.u.u uVar, bc bcVar, com.bytedance.sdk.component.t.u.u uVar2, Map<String, Object> map, String str) {
        this.u = bcVar;
        this.nr = uVar;
        this.fx = uVar2;
        this.b = map;
        this.pn = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(final Map<String, Object> map) {
        int iU = com.bytedance.sdk.openadsdk.core.live.nr.u().u(this.u, new com.bytedance.sdk.openadsdk.core.live.u.fx() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.live.u.fx
            public void u(int i) {
                if (pn.this.nr != null && pn.this.nr.u(map)) {
                    return;
                }
                pn.this.fx.nr(pn.this.b);
            }
        }, this.pn);
        if (iU == 1 || iU == 2) {
            u();
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.nr;
        return uVar != null && uVar.u(map);
    }

    private void u() {
        Map<String, Object> map;
        Map<String, Object> map2 = this.b;
        if (map2 != null) {
            Object obj = map2.get("click_chain");
            Object obj2 = this.b.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.nr.u.fx)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.nr.u.fx fxVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx) obj;
            com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) fxVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
            if (uVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    map = (Map) obj2;
                } else {
                    map = new HashMap<>();
                }
                uVar.u(map, fxVar);
            }
        }
    }
}
