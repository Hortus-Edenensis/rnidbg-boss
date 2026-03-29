package defpackage;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h92<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17896a;
    public Response.ErrorListener b;

    public h92(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f17896a = listener;
        this.b = errorListener;
    }

    public void n(String str) throws DaoException, JSONException {
        if (this.b == null || this.f17896a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String str2 = k86.Z(vm0.B) + "&md5Phone=" + str;
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, str2, null, this.f17896a, this.b);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
