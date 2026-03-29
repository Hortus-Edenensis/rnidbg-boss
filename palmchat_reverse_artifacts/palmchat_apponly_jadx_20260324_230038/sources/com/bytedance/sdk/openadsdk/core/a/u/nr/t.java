package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class t implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "dpa_tag")
    private String b;

    @com.bytedance.sdk.component.t.nr.u(u = "event_tag")
    private String fx;

    @com.bytedance.sdk.component.t.nr.u(u = "view")
    private View iz;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = "live_saas_interaction_type")
    private int pn = -1;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc u;

    @com.bytedance.sdk.component.t.nr.u(u = "handle_chain_data")
    private Map<String, Object> x;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        if (!u()) {
            uVar.nr(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u.iz izVar = new com.bytedance.sdk.openadsdk.core.a.u.u.u.iz(this.u, this.nr, this.fx, this.b);
        int i = this.pn;
        if (i != -1) {
            izVar.nr(i);
        }
        izVar.u(this.iz);
        izVar.nr(this.x);
        if (new com.bytedance.sdk.openadsdk.core.a.u.u.u.nr(new com.bytedance.sdk.openadsdk.core.a.u.u.u.pn(izVar, this.u, uVar, map2, this.fx), this.nr, this.u, this.fx, map2, uVar).u(new HashMap())) {
            uVar.u(map2);
            return false;
        }
        uVar.nr(map2);
        return false;
    }

    private boolean u() {
        return (this.u == null || this.nr == null) ? false : true;
    }
}
