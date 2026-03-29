package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class f56 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17460a;
    public Response.ErrorListener b;

    public f56(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f17460a = listener;
        this.b = errorListener;
    }

    public void n(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            String strB0 = k86.b0(nl0.z + str3, str, str2);
            LogUtil.d("UpdateUserInfoDao", "updateUserInfo :" + jSONObject);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strB0, jSONObject, this.f17460a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void o(JSONObject jSONObject) {
        try {
            String strZ = k86.Z(nl0.z + "/user.update.info");
            LogUtil.d("UpdateUserInfoDao", "updateUserInfo :" + jSONObject);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f17460a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
