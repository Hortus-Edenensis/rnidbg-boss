package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k92 extends wt0 {
    public void n(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        try {
            String strZ = k86.Z(vm0.V0);
            JSONObject jSONObject = new JSONObject();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, listener, errorListener);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
