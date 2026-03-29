package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class se5<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20730a = vm0.K0;
    public Response.Listener<JSONObject> b;
    public Response.ErrorListener c;
    public JSONObject d;

    public se5(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, JSONObject jSONObject) {
        this.b = listener;
        this.c = errorListener;
        this.d = jSONObject;
    }

    public void n() throws DaoException {
        if (this.c == null || this.b == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strGenerateEncodedURL = wt0.generateEncodedURL(this.f20730a);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strGenerateEncodedURL, this.d, this.b, this.c);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
