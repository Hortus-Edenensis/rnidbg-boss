package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.huawei.openalliance.ad.constant.az;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class l implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "event_tag")
    private String b;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_from_landing_page")
    private boolean fx;

    @com.bytedance.sdk.component.t.nr.u(u = az.at)
    private int iz;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = "wc_miniapp_info")
    private JSONObject pn;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc u;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        if (!u()) {
            uVar.nr(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u.n nVar = new com.bytedance.sdk.openadsdk.core.a.u.u.u.n(jw.u(this.pn), this.nr, this.fx, this.b, map2, uVar, this.iz);
        nVar.u(this.u);
        if (nVar.u(new HashMap())) {
            uVar.u(map2);
        } else {
            uVar.nr(map2);
        }
        return true;
    }

    private boolean u() {
        return (this.u == null || this.nr == null || this.pn == null) ? false : true;
    }
}
