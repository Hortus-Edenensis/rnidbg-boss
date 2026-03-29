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
public class n92<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f19464a;
    public Response.ErrorListener b;

    public n92(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f19464a = listener;
        this.b = errorListener;
    }

    public void n(String str, int i, boolean z) throws DaoException, JSONException {
        if (this.b == null || this.f19464a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.p);
            StringBuilder sb = new StringBuilder();
            sb.append(strZ);
            sb.append("&md5Phone=");
            sb.append(str);
            sb.append("&index=");
            sb.append(i);
            sb.append("&ghost=");
            sb.append(z ? 1 : 0);
            String string = sb.toString();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, string, null, this.f19464a, this.b);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
