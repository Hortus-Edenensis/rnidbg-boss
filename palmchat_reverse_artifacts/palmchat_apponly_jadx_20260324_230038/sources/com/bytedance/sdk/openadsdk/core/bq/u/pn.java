package com.bytedance.sdk.openadsdk.core.bq.u;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    public final com.bytedance.sdk.component.u.o u;

    public pn(com.bytedance.sdk.component.u.o oVar) {
        this.u = oVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar) {
        oVar.u("canIUse", (com.bytedance.sdk.component.u.pn<?, ?>) new pn(oVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(OapsKey.KEY_NAMES);
                if (jSONArrayOptJSONArray != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject3.put(strOptString, this.u.u(strOptString) ? 1 : 0);
                        }
                    }
                    jSONObject2.put("code", 0);
                    jSONObject2.put("data", jSONObject3);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "names is not JsonArray or null");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("msg", "params is null");
            }
        } catch (Throwable th) {
            jSONObject2.put("code", 1);
            jSONObject2.put("msg", "exception: " + th.getMessage());
        }
        return jSONObject2;
    }
}
