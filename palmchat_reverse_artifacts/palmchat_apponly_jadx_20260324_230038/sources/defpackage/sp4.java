package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sp4 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f20800a;
    public Response.ErrorListener b;

    public sp4(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f20800a = listener;
        this.b = errorListener;
    }

    public void n() {
        try {
            String strZ = k86.Z(nl0.z + "/hih.queryAmount.v3");
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, null, this.f20800a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
