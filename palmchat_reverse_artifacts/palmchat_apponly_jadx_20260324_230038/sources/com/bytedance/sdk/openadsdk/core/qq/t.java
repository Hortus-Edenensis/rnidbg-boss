package com.bytedance.sdk.openadsdk.core.qq;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class t implements com.bytedance.sdk.component.n.u.u.pn {
    com.bytedance.sdk.component.a.nr u;

    public t(com.bytedance.sdk.component.a.nr nrVar) {
        this.u = nrVar;
    }

    @Override // com.bytedance.sdk.component.n.u.u.pn
    public String b() {
        com.bytedance.sdk.component.a.nr nrVar = this.u;
        return nrVar != null ? nrVar.fx() : "";
    }

    @Override // com.bytedance.sdk.component.n.u.u.pn
    public int fx() {
        com.bytedance.sdk.component.a.nr nrVar = this.u;
        if (nrVar != null) {
            return nrVar.nr();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.n.u.u.pn
    public String nr() {
        com.bytedance.sdk.component.a.nr nrVar = this.u;
        return nrVar != null ? nrVar.pn() : "";
    }

    @Override // com.bytedance.sdk.component.n.u.u.pn
    public Map<String, String> pn() {
        com.bytedance.sdk.component.a.nr nrVar = this.u;
        return nrVar != null ? nrVar.b() : new HashMap();
    }

    @Override // com.bytedance.sdk.component.n.u.u.pn
    public boolean u() {
        com.bytedance.sdk.component.a.nr nrVar = this.u;
        if (nrVar != null) {
            return nrVar.a();
        }
        return false;
    }
}
