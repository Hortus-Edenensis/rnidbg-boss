package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.wifi.ad.core.config.EventParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends u {
    public t(Activity activity, bc bcVar, ob obVar) {
        super(activity, bcVar, obVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean iz() {
        if (yd.fx(this.x)) {
            return (Integer.parseInt(this.l) == 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.t)) ? false : true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public float n() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(jk jkVar) {
        return fx(jkVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.u + "s 可获得奖励");
            jSONObject.put(EventParams.KEY_PARAM_NUMBER, this.l);
            jSONObject.put("number_unit", this.t);
            jSONObject.put("remain_time", this.u);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public int x() {
        return 2;
    }
}
