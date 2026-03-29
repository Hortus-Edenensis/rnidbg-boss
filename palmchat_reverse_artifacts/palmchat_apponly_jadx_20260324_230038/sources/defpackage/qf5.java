package defpackage;

import com.android.volley.DefaultRetryPolicy;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.HexDumper;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class qf5 {
    public static void a(String str, String str2, int i, gs gsVar) {
        try {
            String str3 = nl0.n + "/sms/send";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ic", str);
            jSONObject.put("phone", str2);
            jSONObject.put("type", i);
            EncryptUtils.createCKey();
            String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str3, jSONObject, 1, false, gsVar.e(), gsVar.d());
            encryptedJsonRequest.addHeader("Content-CKey", hexString);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            VolleyNetwork.getNormalRequestQueue().add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str, String str2, int i, String str3, String str4, gs gsVar) {
        try {
            String str5 = nl0.n + "/sms/verify";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ic", str);
            jSONObject.put("phone", str2);
            jSONObject.put("type", i);
            jSONObject.put("code", str3);
            jSONObject.put("smsid", str4);
            EncryptUtils.createCKey();
            String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str5, jSONObject, 1, false, gsVar.e(), gsVar.d());
            encryptedJsonRequest.addHeader("Content-CKey", hexString);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            VolleyNetwork.getNormalRequestQueue().add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
