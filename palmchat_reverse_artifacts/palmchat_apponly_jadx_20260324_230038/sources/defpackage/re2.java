package defpackage;

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
public class re2<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f20457a;
    public Response.ErrorListener b;
    public HashMap<String, T> c;

    public re2(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, HashMap<String, T> map) {
        this.f20457a = listener;
        this.b = errorListener;
        this.c = map;
    }

    public void n() throws DaoException {
        if (this.b == null || this.f20457a == null || this.c == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.M0);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            VolleyNetwork.getNormalRequestQueue().add(new EncryptedJsonRequest(1, strZ, jSONObject, this.f20457a, this.b));
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
