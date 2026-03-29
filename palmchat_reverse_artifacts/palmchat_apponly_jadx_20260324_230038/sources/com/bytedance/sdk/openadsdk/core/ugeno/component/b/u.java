package com.bytedance.sdk.openadsdk.core.ugeno.component.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;
import com.igexin.assist.sdk.AssistPushConsts;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.adsdk.ugeno.widget.fx.u {
    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: ay, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout u() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.nr);
        uGFrameLayout.u(this);
        return uGFrameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.fx.u, com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
    }

    public void u(long j, long j2) {
        my myVar;
        JSONObject jSONObjectFx;
        if (!u(12) || (myVar = this.tr.get(12)) == null || (jSONObjectFx = myVar.fx()) == null) {
            return;
        }
        jSONObjectFx.optString("type");
        JSONArray jSONArrayOptJSONArray = jSONObjectFx.optJSONArray(AssistPushConsts.MSG_TYPE_ACTIONS);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                int iOptInt = jSONObjectOptJSONObject.optInt("progress") * 1000;
                if (iOptInt > j2) {
                    iOptInt = (int) j2;
                }
                if (j == iOptInt && TextUtils.equals(strOptString, "onShow")) {
                    fx fxVarNr = nr(this);
                    String strOptString2 = jSONObjectOptJSONObject.optString("nodeId");
                    if (fxVarNr != null) {
                        fxVarNr.b(strOptString2).nr(0);
                    }
                }
            }
        }
    }
}
