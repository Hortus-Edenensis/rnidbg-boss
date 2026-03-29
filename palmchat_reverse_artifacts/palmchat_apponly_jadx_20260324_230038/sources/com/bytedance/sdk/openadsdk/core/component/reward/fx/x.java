package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends u {
    public x(Activity activity, bc bcVar, ob obVar) {
        super(activity, bcVar, obVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean iz() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public float n() {
        return 0.85f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(jk jkVar) {
        return fx(jkVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "参与互动可以领取福利");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public int x() {
        return 4;
    }
}
