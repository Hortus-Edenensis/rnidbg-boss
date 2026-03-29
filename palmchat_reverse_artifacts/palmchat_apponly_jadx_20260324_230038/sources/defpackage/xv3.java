package defpackage;

import com.wifi.ad.core.utils.WifiLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xv3 {
    public static void a(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str);
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", str3);
            WifiLog.d("reportPreloadReq lx_client_nestad_advance_req_scene" + jSONObject.toString());
            zn6.d("lx_client_nestad_advance_req_scene", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b(int i, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frequency_reason", i);
            jSONObject.put("taichi", str);
            jSONObject.put("exp_group", str2);
            WifiLog.d("reportPreloadReqLimit lx_client_nestad_advance_req_limit" + jSONObject.toString());
            zn6.d("lx_client_nestad_advance_req_limit", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
