package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends u {
    private int o;
    private int sx;

    public iz(Activity activity, bc bcVar, ob obVar) {
        JSONObject jSONObjectNr;
        super(activity, bcVar, obVar);
        ob obVar2 = this.f5234a;
        if (obVar2 == null || (jSONObjectNr = obVar2.nr()) == null) {
            return;
        }
        this.o = jSONObjectNr.optInt("reduce_time");
        this.sx = jSONObjectNr.optInt("reduce_duration");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void b(jk jkVar) {
        if (jkVar != null) {
            jkVar.u(this.o);
        }
        this.f5234a.u(true);
        if (jkVar != null) {
            jkVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean iz() {
        int i;
        ob obVar = this.f5234a;
        return (obVar == null || !obVar.iz()) && this.o > 0 && (i = this.sx) > 0 && this.nr < i;
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
    public void u(com.bytedance.sdk.openadsdk.core.widget.iz izVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public int x() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.o + "s");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
