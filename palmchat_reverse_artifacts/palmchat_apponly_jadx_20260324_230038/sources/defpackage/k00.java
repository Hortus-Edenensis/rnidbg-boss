package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k00 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18541a = nl0.z + "/service.ids.config.v1";
    public Response.Listener<JSONObject> b;
    public Response.ErrorListener c;

    public k00(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.b = listener;
        this.c = errorListener;
    }

    public void n(String str, String str2, int i, int i2) throws DaoException {
        if (this.c == null || this.b == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(this.f18541a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("serviceId", str);
            jSONObject.put(DeviceInfoUtil.UID_TAG, str2);
            jSONObject.put("order", String.valueOf(i));
            jSONObject.put("status", String.valueOf(i2));
            z53.a("ChangeServiceIdsConfigNewDao", "params=" + jSONObject.toString());
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.b, this.c);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
