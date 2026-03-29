package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.chat.ChatBubble;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b20 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f1630a;
    public Response.ErrorListener b;

    public b20(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f1630a = listener;
        this.b = errorListener;
    }

    public static ChatBubble o(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            LogUtil.json("logbubble", jSONObject, "/userem.bubble.use.v1");
            if (jSONObject.getInt("resultCode") == 0) {
                return (ChatBubble) az2.a(jSONObject.getJSONObject("data").toString(), ChatBubble.class);
            }
        }
        return null;
    }

    public void n() throws DaoException {
        if (this.b == null || this.f1630a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        String str = nl0.z + "/userem.bubble.use.v1";
        try {
            String strA = xn3.a();
            String strA0 = k86.a0(str, strA);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reqId", strA);
            LogUtil.d("logbubble", jSONObject.toString());
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strA0, jSONObject, this.f1630a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
