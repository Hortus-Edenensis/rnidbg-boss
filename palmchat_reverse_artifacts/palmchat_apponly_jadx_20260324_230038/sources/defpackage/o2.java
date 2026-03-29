package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.dao.DaoException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o2 extends wt0 {
    public void n(String str, int i, String str2, Response.ErrorListener errorListener, Response.Listener<JSONObject> listener) throws DaoException {
        SmidHelper.x(SmidHelper.SMScene.FRIEND_AGREE);
        if (errorListener == null || listener == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strJ = k86.j(nl0.n + "/friend/v4/agree.json");
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rid", str);
            jSONObject.put("agreeSubType", i);
            jSONObject.put("remarkName", io0.v(str2));
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strJ, jSONObject, listener, errorListener);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void o(String str, Response.ErrorListener errorListener, Response.Listener<JSONObject> listener) throws DaoException {
        n(str, 0, "", errorListener, listener);
    }
}
