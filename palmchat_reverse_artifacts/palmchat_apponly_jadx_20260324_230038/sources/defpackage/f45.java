package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f45 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17431a;
    public Response.ErrorListener b;

    public f45(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f17431a = listener;
        this.b = errorListener;
    }

    public void n(String str, String str2, String str3) {
        try {
            String strZ = k86.Z(nl0.n + ko1.a("/user/v5/search_user.json", "/user/v6/search_user.json"));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("phone", str);
            jSONObject.put("ic", str2);
            jSONObject.put(az.at, str3);
            jSONObject.put("sdid", ac1.v());
            EncryptUtils.setLxData(jSONObject);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f17431a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
