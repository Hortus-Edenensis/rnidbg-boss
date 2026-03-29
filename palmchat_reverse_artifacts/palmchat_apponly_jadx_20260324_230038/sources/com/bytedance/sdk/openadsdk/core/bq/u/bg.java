package com.bytedance.sdk.openadsdk.core.bq.u;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bg extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    public static void u(com.bytedance.sdk.component.u.o oVar) {
        oVar.u("getSettingInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new bg());
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        String[] strArrSplit;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keys");
                JSONObject jSONObjectL = com.bytedance.sdk.openadsdk.core.dw.nr().l();
                if (jSONObjectL == null) {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "settingsJson is null");
                } else if (jSONArrayOptJSONArray != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString) && (strArrSplit = strOptString.split("\\.")) != null) {
                            Object objOpt = null;
                            JSONObject jSONObjectOptJSONObject = jSONObjectL;
                            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                                String str = strArrSplit[i2];
                                if (str != null && jSONObjectOptJSONObject != null) {
                                    if (i2 != strArrSplit.length - 1) {
                                        jSONObjectOptJSONObject = jSONObjectOptJSONObject.optJSONObject(str);
                                    } else {
                                        objOpt = jSONObjectOptJSONObject.opt(str);
                                    }
                                }
                            }
                            jSONObject3.putOpt(strOptString, objOpt);
                        }
                    }
                    jSONObject2.put("code", 0);
                    jSONObject2.put("data", jSONObject3);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "keys is not JsonArray or null");
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
