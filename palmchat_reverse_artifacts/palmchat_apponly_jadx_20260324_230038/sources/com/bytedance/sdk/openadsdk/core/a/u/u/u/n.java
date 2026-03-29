package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.nr.u.nr.pn;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.bytedance.sdk.openadsdk.core.a.u.u.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5203a;
    private boolean b;
    private Context fx;
    private jw iz;
    private com.bytedance.sdk.component.t.u.u n;
    private bc nr;
    private String pn;
    private com.bytedance.sdk.openadsdk.core.a.u.u.u u;
    private Map<String, Object> x;

    public n(jw jwVar, Context context, boolean z, String str, Map<String, Object> map, com.bytedance.sdk.component.t.u.u uVar, int i) {
        this.iz = jwVar;
        this.fx = context;
        this.b = z;
        this.pn = str;
        this.x = map;
        this.n = uVar;
        this.f5203a = i;
    }

    public void u(bc bcVar) {
        this.nr = bcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(final Map<String, Object> map) {
        boolean zU = !com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u() ? new com.bytedance.sdk.openadsdk.core.nr.u.nr.pn(this.nr, this.fx).u(this.pn).u(this.f5203a).nr(this.b).u(new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u
            public void nr() {
                if (n.this.u != null ? n.this.u.u(map) : false) {
                    return;
                }
                n.this.n.nr(n.this.x);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u
            public void u() {
            }
        }) : false;
        com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u(false);
        if (zU) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.u;
        return uVar != null && uVar.u(map);
    }
}
