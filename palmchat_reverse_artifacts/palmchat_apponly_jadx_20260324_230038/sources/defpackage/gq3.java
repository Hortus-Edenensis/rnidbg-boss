package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gq3<T> extends wt0 {
    public static final String c = "gq3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17771a;
    public Response.ErrorListener b;

    public gq3(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f17771a = listener;
        this.b = errorListener;
    }

    public void n(HashMap<String, T> map) throws DaoException, JSONException {
        if (this.b == null || this.f17771a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(nl0.z + "/user.update.extinfo");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            LogUtil.d(c, "modifyExtInfoAsync: " + jSONObject.toString());
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f17771a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
