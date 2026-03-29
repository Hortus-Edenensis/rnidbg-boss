package com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    public fx(Activity activity, bc bcVar, ob obVar) {
        super(activity, bcVar, obVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean iz() {
        return (TextUtils.isEmpty(this.t) || TextUtils.isEmpty(this.l)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public float n() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u u(jk jkVar) {
        return fx(jkVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public int x() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.REWARD_NAME, this.t);
            jSONObject.put(MediationConstant.REWARD_AMOUNT, this.l);
            jSONObject.put("extra_info", this.u);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
