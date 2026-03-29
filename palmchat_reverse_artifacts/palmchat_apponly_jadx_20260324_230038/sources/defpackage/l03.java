package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l03 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18871a = nl0.s + "/room/v3/kick";
    public String b = nl0.s + "/room/v3/kicks";
    public Response.Listener<JSONObject> c;
    public Response.ErrorListener d;

    public l03(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.c = listener;
        this.d = errorListener;
    }

    public void n(ArrayList<String> arrayList, String str, int i) throws DaoException {
        if (this.d == null || this.c == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strGenerateEncodedURL = wt0.generateEncodedURL(this.b);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uids", new JSONArray((Collection) arrayList));
            jSONObject.put("roomId", Long.parseLong(str));
            jSONObject.put("addBlackList", i);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strGenerateEncodedURL, jSONObject, this.c, this.d);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (JSONException unused2) {
            throw new DaoException("json error");
        }
    }
}
