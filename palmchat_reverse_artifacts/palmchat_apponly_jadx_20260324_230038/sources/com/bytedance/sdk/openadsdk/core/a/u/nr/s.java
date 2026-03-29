package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class s implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc u;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        Context context;
        bc bcVar = this.u;
        if (bcVar == null || (context = this.nr) == null) {
            uVar.nr(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(context, bcVar);
        uVar.u(map2);
        return true;
    }
}
