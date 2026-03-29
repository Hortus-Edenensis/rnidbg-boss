package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class l92 extends wt0 {
    public static final String c = "l92";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f18933a;
    public Response.ErrorListener b;

    public l92(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f18933a = listener;
        this.b = errorListener;
    }

    public static ContactInfoItem p(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        LogUtil.d(c, "parse response:" + jSONObject.toString());
        if (jSONObject.getInt("resultCode") != 0) {
            return null;
        }
        ContactInfoItem contactInfoItemA = co0.a(jSONObject.getJSONObject("data"));
        if (contactInfoItemA != null) {
            contactInfoItemA.setFriendType(1);
        }
        return contactInfoItemA;
    }

    public void n(String str) throws DaoException {
        o(str, null);
    }

    public void o(String str, String str2) throws DaoException {
        if (this.b == null || this.f18933a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strF0 = k86.f0(k86.Z(nl0.n + ko1.a("/user/v3/user_info.json", "/user/v4/user_info.json")) + "&fuid=" + str, "fexid", str2);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, strF0, null, this.f18933a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
