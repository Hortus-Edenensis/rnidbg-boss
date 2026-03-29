package com.bytedance.sdk.openadsdk.core.a.u.u.nr;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    private com.bytedance.sdk.openadsdk.core.a.u.u.u nr;
    private com.bytedance.sdk.openadsdk.core.video.nr.nr u;

    public nr(com.bytedance.sdk.openadsdk.core.a.u.u.u uVar, com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.nr = uVar;
        this.u = nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar = this.u;
        if (nrVar == null) {
            return this.nr.u(map);
        }
        if (nrVar.u()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.nr;
        if (uVar == null) {
            return false;
        }
        return uVar.u(map);
    }

    public nr(com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.u = nrVar;
    }
}
