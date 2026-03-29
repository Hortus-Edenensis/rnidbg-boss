package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.umeng.analytics.pro.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    private String bg;
    private String bq;
    private int o;
    private int sx;

    public b(Activity activity, bc bcVar, ob obVar) {
        JSONObject jSONObjectOptJSONObject;
        super(activity, bcVar, obVar);
        JSONObject jSONObjectNr = obVar.nr();
        if (jSONObjectNr == null || (jSONObjectOptJSONObject = jSONObjectNr.optJSONObject("coupon")) == null) {
            return;
        }
        this.o = jSONObjectOptJSONObject.optInt("amount");
        this.sx = jSONObjectOptJSONObject.optInt("threshold");
        this.bg = jSONObjectOptJSONObject.optString(f.p);
        this.bq = jSONObjectOptJSONObject.optString("expire_time");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean iz() {
        return (this.o == 0 || this.sx == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public float n() {
        return 0.55f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(jk jkVar) {
        return fx(jkVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.o);
            jSONObject.put("threshold", "满" + this.sx + "元可用");
            if (TextUtils.isEmpty(this.bg)) {
                if (TextUtils.isEmpty(this.bq)) {
                    str = "领取当日起30分钟内有效";
                } else {
                    str = "有效期至" + this.bq;
                }
            } else if (TextUtils.isEmpty(this.bq)) {
                str = "有效期至" + this.bg;
            } else {
                str = "有效期" + this.bg + "至" + this.bq;
            }
            jSONObject.put(f.p, this.bg);
            jSONObject.put("expire_text", str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public int x() {
        return 6;
    }
}
