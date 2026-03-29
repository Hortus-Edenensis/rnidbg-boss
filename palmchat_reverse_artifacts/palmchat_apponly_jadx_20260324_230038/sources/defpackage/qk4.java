package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qk4 extends wt0 {
    public static final String c = "qk4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f20271a;
    public Response.ErrorListener b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<ContactInfoItem.Portrait>> {
    }

    public qk4(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f20271a = listener;
        this.b = errorListener;
    }

    public static List<ContactInfoItem.Portrait> o(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            LogUtil.json(c, jSONObject, "/userem.avatar.get.v1");
            if (jSONObject.getInt("resultCode") == 0) {
                return (List) az2.b(jSONObject.getJSONObject("data").getJSONArray("imgList").toString(), new a().getType());
            }
        }
        return null;
    }

    public void n() throws DaoException {
        if (this.b == null || this.f20271a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        String str = nl0.z + "/userem.avatar.get.v1";
        try {
            String strA = xn3.a();
            String strA0 = k86.a0(str, strA);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reqId", strA);
            LogUtil.d("logportrait", jSONObject.toString());
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strA0, jSONObject, this.f20271a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void p(List<ContactInfoItem.Portrait> list, int i, int i2) throws DaoException {
        if (this.b == null || this.f20271a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        String str = nl0.z + "/userem.avatar.set.v2";
        try {
            String strA = xn3.a();
            String strA0 = k86.a0(str, strA);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reqId", strA);
            JSONArray jSONArray = new JSONArray();
            for (ContactInfoItem.Portrait portrait : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("headIcon", portrait.headIcon);
                jSONObject2.put("headImg", portrait.headImg);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("imgList", jSONArray);
            jSONObject.put("postSquareFlag", i);
            jSONObject.put("syncTinder", i2);
            LogUtil.json("logportrait", jSONObject.toString(), "/userem.avatar.set.v2");
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strA0, jSONObject, this.f20271a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
