package com.zenmen.palmchat.redpacket.data;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PayStatusVo {
    public static final int STATUS_CHECK_AGAIN = 3;
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_SUCCESS = 1;
    public String errorMsg;
    public int result;
    public int resultCode = -1;
    public int interval = 30;

    public static PayStatusVo parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PayStatusVo payStatusVo = new PayStatusVo();
        payStatusVo.resultCode = jSONObject.optInt("resultCode", -1);
        payStatusVo.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject == null) {
            return payStatusVo;
        }
        payStatusVo.result = jSONObjectOptJSONObject.optInt("payResult");
        payStatusVo.interval = jSONObjectOptJSONObject.optInt("interval");
        return payStatusVo;
    }

    public String toString() {
        return "PayStatusVo{resultCode=" + this.resultCode + ", result=" + this.result + ", interval=" + this.interval + ", errorMsg='" + this.errorMsg + "'}";
    }
}
