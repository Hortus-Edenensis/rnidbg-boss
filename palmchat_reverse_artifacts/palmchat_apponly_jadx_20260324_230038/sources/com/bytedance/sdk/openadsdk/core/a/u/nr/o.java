package com.bytedance.sdk.openadsdk.core.a.u.nr;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class o implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "reward_dialog_callback")
    private com.bytedance.sdk.openadsdk.core.component.reward.fx.jk u;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar = this.u;
        if (jkVar == null) {
            uVar.nr(map2);
            return true;
        }
        jkVar.nr();
        uVar.u(map2);
        return true;
    }
}
