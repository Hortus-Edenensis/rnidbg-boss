package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class k65 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18585a = nl0.s + "/room/v3/config/set";
    public Response.Listener<JSONObject> b;
    public Response.ErrorListener c;

    public k65(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.b = listener;
        this.c = errorListener;
    }

    public void n(String str, int i) throws DaoException {
        if (this.c == null || this.b == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strGenerateEncodedURL = wt0.generateEncodedURL(this.f18585a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("roomId", Long.parseLong(str));
            jSONObject.put("status", i);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strGenerateEncodedURL, jSONObject, this.b, this.c);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (JSONException unused2) {
            throw new DaoException("json error");
        }
    }
}
