package com.bytedance.sdk.openadsdk.core.component.reward.business.fx;

import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static void nr(bc bcVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", jp.l(bcVar));
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, "second_page_show", jSONObject);
    }

    public static void u(bc bcVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, "second_page_jsb_invoke", jSONObject);
    }

    public static void u(bc bcVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", jp.l(bcVar));
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, "second_page_request", jSONObject);
    }
}
