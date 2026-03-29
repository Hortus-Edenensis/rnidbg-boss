package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class k implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc fx;

    @com.bytedance.sdk.component.t.nr.u(u = "log_extra")
    private String nr;

    @com.bytedance.sdk.component.t.nr.u(u = "label")
    private String u;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        if (!u()) {
            com.bytedance.sdk.component.utils.k.nr("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            uVar.nr(map2);
            return false;
        }
        JSONObject jSONObjectU = u(map);
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, jp.nr(this.fx), this.u, jSONObjectU);
        uVar.u(map2);
        return true;
    }

    private JSONObject u(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("label");
            hashSet.add(MediationConstant.EXTRA_ADID);
            hashSet.add("log_extra");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean u() {
        return (TextUtils.isEmpty(this.u) || TextUtils.isEmpty(this.nr) || this.fx == null) ? false : true;
    }
}
