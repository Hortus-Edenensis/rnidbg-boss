package defpackage;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.gift.bean.GiftPanelConfigBean;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.peoplematch.bean.CommonResponse;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class aa2 extends wt0 {
    public final Request n(String str, Map<String, Object> map, uw4 uw4Var) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return o(str, jSONObject, uw4Var);
    }

    public final Request o(String str, JSONObject jSONObject, uw4 uw4Var) {
        try {
            LogUtil.d("logmatch", "request: url=" + str);
            if (jSONObject != null) {
                LogUtil.d("logmatch", "request: params=" + jSONObject.toString());
            }
            String strZ = k86.Z(str);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            ww4 ww4Var = new ww4(uw4Var, strZ);
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, ww4Var, ww4Var);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
            return encryptedJsonRequest;
        } catch (Exception unused) {
            uw4Var.b(-1, "");
            uw4Var.c();
            return null;
        }
    }

    public Request p(String str, uw4<CommonResponse<GiftPanelConfigBean>> uw4Var) {
        HashMap map = new HashMap();
        map.put(ActionUtils.PAYMENT_AMOUNT, str);
        return n(nl0.z + "/vas.items.sdk.panel.config.v1", map, uw4Var);
    }
}
