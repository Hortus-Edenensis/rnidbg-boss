package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class e63<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17222a;
    public Response.ErrorListener b;
    public HashMap<String, T> c;

    public e63(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, HashMap<String, T> map) {
        this.f17222a = listener;
        this.b = errorListener;
        this.c = map;
    }

    public void n() throws DaoException, JSONException {
        if (this.b == null || this.f17222a == null || this.c == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.Z);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f17222a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
