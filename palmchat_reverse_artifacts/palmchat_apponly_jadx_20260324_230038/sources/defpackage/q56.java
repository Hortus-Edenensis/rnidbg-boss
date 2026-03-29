package defpackage;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class q56<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f20184a;
    public Response.ErrorListener b;
    public HashMap<String, T> c;

    public q56(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, HashMap<String, T> map) {
        this.f20184a = listener;
        this.b = errorListener;
        this.c = map;
    }

    public void n() throws DaoException, JSONException {
        if (this.b == null || this.f20184a == null || this.c == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        String strB0 = nl0.z + "/ympns.register.v4";
        try {
            if (AccountUtils.t(AppContext.getContext())) {
                strB0 = k86.Z(strB0);
            } else if (PushTokenManager.e() != null) {
                strB0 = k86.b0(strB0, PushTokenManager.e().optString(DeviceInfoUtil.UID_TAG), PushTokenManager.e().optString(WkParams.SESSIONID));
            }
            String str = strB0;
            JSONObject jSONObject = new JSONObject(this.c);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str, jSONObject, this.f20184a, this.b);
            if (hp4.c()) {
                encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(15000, 2, 1.0f));
            }
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
