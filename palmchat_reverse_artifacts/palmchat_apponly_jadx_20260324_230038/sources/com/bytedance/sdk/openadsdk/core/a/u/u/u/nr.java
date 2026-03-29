package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nr.u.nr.fx;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    private com.bytedance.sdk.openadsdk.core.a.u.u.u b;
    private String fx;
    private Map<String, Object> iz;
    private bc nr;
    private com.bytedance.sdk.component.t.u.u pn;
    private Context u;

    public nr(com.bytedance.sdk.openadsdk.core.a.u.u.u uVar, Context context, bc bcVar, String str, Map<String, Object> map, com.bytedance.sdk.component.t.u.u uVar2) {
        this.b = uVar;
        this.u = context;
        this.nr = bcVar;
        this.fx = str;
        this.pn = uVar2;
        this.iz = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(final Map<String, Object> map) {
        if (!com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.u(this.nr, false)) {
            com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.b;
            return uVar != null && uVar.u(map);
        }
        if (jk.pn(this.nr)) {
            com.bytedance.sdk.openadsdk.core.a.u.u.u uVar2 = this.b;
            return uVar2 != null && uVar2.u(map);
        }
        if (jk.b(this.nr)) {
            com.bytedance.sdk.openadsdk.core.a.u.u.u uVar3 = this.b;
            return uVar3 != null && uVar3.u(map);
        }
        new com.bytedance.sdk.openadsdk.core.nr.u.nr.fx(this.nr, this.u).u(this.fx).u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.u
            public void u() {
                if (nr.this.b.u(map)) {
                    return;
                }
                nr.this.pn.nr(nr.this.iz);
            }
        });
        return true;
    }
}
