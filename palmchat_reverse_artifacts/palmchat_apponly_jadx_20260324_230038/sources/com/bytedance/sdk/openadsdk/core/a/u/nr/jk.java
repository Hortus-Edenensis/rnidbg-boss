package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr(u = "SINGLETON")
public class jk implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = WfConstant.EXTRA_KEY_INTERACTION_TYPE)
    private int b;

    @com.bytedance.sdk.component.t.nr.u(u = "url")
    private String fx;

    @com.bytedance.sdk.component.t.nr.u(u = "is_open_web_page")
    private boolean iz;

    @com.bytedance.sdk.component.t.nr.u(u = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.nr.nr n;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = "activity_type")
    private int pn;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc u;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_from_landing_page")
    private boolean x;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, final Map<String, Object> map2, final com.bytedance.sdk.component.t.u.u uVar) {
        if (this.iz) {
            return true;
        }
        if (this.x) {
            uVar.nr(map2);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.u.ap());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.u.gq()));
            jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.u.xx());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().u("landing_page", TurnInfo.TYPE_NATIVE, 0, jSONObject);
        if (this.b == 2) {
            boolean zU = u();
            if (zU) {
                uVar.u(map2);
            } else {
                uVar.nr(map2);
            }
            return zU;
        }
        com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar = this.n;
        if (nrVar != null && new com.bytedance.sdk.openadsdk.core.a.u.u.nr.nr(nrVar).u(new HashMap())) {
            uVar.u(map2);
            return true;
        }
        Intent intent = new Intent(this.nr, (Class<?>) jp.iz(this.pn));
        if (!(this.nr instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        bc bcVar = this.u;
        if (bcVar != null) {
            intent.putExtra("get_phone_num_status", bcVar.iz());
        }
        if (map == null) {
            com.bytedance.sdk.component.utils.k.nr("UChain_LP", "param == null");
            uVar.nr(map2);
        }
        map.putAll(map2);
        map.remove("context");
        map.remove("activity_type");
        Object objRemove = map.remove(az.at);
        jp.u(map, this.u);
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception unused2) {
            }
        }
        intent.putExtra(az.at, i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.nr.u(this.nr, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.nr.jk.1
            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u() {
                uVar.u(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u(Throwable th) {
                uVar.nr(map2);
            }
        });
        return true;
    }

    private boolean u() {
        if (!com.bytedance.sdk.component.utils.o.u(this.fx)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.fx));
            if (!(this.nr instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.component.utils.nr.u(this.nr, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
