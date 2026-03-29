package com.bytedance.sdk.openadsdk.core.live.pn;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("name", null);
                    if (TextUtils.equals(strOptString, "ec_reward_gold") || TextUtils.equals(strOptString, "reward_gold") || TextUtils.equals(strOptString, "auth_reward_gold")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean u(bc bcVar) {
        JSONObject jSONObjectPn;
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf = bcVar.bf();
        return (uVarBf == null || (jSONObjectPn = uVarBf.pn()) == null || jSONObjectPn.optBoolean("landing_type", false)) ? false : true;
    }
}
