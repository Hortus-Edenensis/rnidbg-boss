package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class iz implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc b;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context fx;

    @com.bytedance.sdk.component.t.nr.u(u = "ad_dislike")
    private com.bytedance.sdk.openadsdk.core.dislike.ui.nr nr;

    @com.bytedance.sdk.component.t.nr.u(u = "outer_dislike")
    private Dialog u;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        Dialog dialog = this.u;
        if (dialog != null) {
            dialog.show();
            uVar.u(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.nr;
        if (nrVar != null) {
            nrVar.u();
            uVar.u(map2);
            return true;
        }
        TTDelegateActivity.u(this.fx, this.b);
        uVar.u(map2);
        return true;
    }
}
