package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wc0 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f21672a;
    public Response.ErrorListener b;

    public wc0(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f21672a = listener;
        this.b = errorListener;
    }

    public void n() throws DaoException {
        if (this.b == null || this.f21672a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        String str = vm0.R;
        if (v13.a()) {
            str = nl0.z + "/lbs.clean.v1";
        }
        try {
            String strZ = k86.Z(str);
            JSONObject jSONObject = new JSONObject();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f21672a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
