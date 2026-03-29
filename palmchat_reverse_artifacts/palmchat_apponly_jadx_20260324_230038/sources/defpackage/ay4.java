package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ay4 extends wt0 {
    public static final String d = l03.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1608a = nl0.s + "/room/v3/revoke";
    public Response.Listener<JSONObject> b;
    public Response.ErrorListener c;

    public ay4(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.b = listener;
        this.c = errorListener;
    }

    public void n(String str, String str2) throws DaoException {
        if (this.c == null || this.b == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strGenerateEncodedURL = wt0.generateEncodedURL(this.f1608a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, Long.parseLong(str));
            jSONObject.put("roomId", Long.parseLong(str2));
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
