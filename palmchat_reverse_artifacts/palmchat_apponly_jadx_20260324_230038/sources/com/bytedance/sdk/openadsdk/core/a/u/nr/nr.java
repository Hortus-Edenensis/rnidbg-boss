package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import com.bytedance.sdk.component.t.u.nr;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class nr implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "function_desc_popup_listener")
    private iz.u b;

    @com.bytedance.sdk.component.t.nr.u(u = MediationConstant.EXTRA_ADID)
    private String fx;

    @com.bytedance.sdk.component.t.nr.u(u = "confirm_event")
    private String iz;

    @com.bytedance.sdk.component.t.nr.u(u = "cancel_event")
    private String n;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc nr;

    @com.bytedance.sdk.component.t.nr.u(u = "app_manage_model")
    private String pn;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context u;

    @com.bytedance.sdk.component.t.nr.u(u = "deny_event")
    private String x;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.fx, u());
        TTDelegateActivity.fx(this.u, this.fx, this.pn);
        uVar.u(map2);
        return true;
    }

    private iz.u u() {
        return new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                if (nr.this.b == null) {
                    return;
                }
                nr.this.b.onDialogBtnNo();
                nr nrVar = nr.this;
                nrVar.u(nrVar.x);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                if (nr.this.b == null) {
                    return;
                }
                nr.this.b.onDialogBtnYes();
                nr nrVar = nr.this;
                nrVar.u(nrVar.iz);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                if (nr.this.b == null) {
                    return;
                }
                nr.this.b.onDialogCancel();
                nr nrVar = nr.this;
                nrVar.u(nrVar.n);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        HashMap map = new HashMap();
        map.put("material_meta", this.nr);
        map.put("context", this.u);
        new nr.u(str).u(this.nr.et()).u(map).u().u();
    }
}
