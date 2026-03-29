package defpackage;

import android.content.ContentValues;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.ServerException;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r92 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20420a = "r92";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                r92.this.o();
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (DaoException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static ContentValues p(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject.getInt("resultCode") != 0 || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return null;
        }
        LogUtil.d(f20420a, "profileData = " + jSONObjectOptJSONObject.toString() + ", mode = " + Integer.valueOf(jSONObjectOptJSONObject.optInt("mode")));
        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_inited_time"), Long.valueOf(jSONObjectOptJSONObject.optLong("initedTime")));
        AppContext.getContext().getTrayPreferences().f(k86.w(), jSONObjectOptJSONObject.optInt("privacyConfig"));
        AppContext.getContext().getTrayPreferences().f(k86.s(), jSONObjectOptJSONObject.optInt("mode"));
        if (jSONObjectOptJSONObject.has("kidsModeCfg")) {
            TeenagersModeManager.a().f(jSONObjectOptJSONObject.optInt("kidsModeCfg"));
        }
        return co0.b(true, jSONObjectOptJSONObject, 1);
    }

    public void n() {
        new g13(new a()).start();
    }

    public void o() throws DaoException, ServerException {
        try {
            String strZ = k86.Z(nl0.n + ko1.a("/user/v3/profile.json", "/user/v4/profile.json"));
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, strZ, null, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            ContentValues contentValuesP = p((JSONObject) requestFutureNewFuture.get(encryptedJsonRequest));
            if (contentValuesP != null) {
                AppContext.getContext().getContentResolver().insert(ho0.f18003a, contentValuesP);
            }
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InterruptedException unused2) {
            throw new ServerException(ServerException.NETWORK_REQUEST_ERROR_MESSAGE);
        } catch (ExecutionException unused3) {
            throw new ServerException(ServerException.NETWORK_REQUEST_ERROR_MESSAGE);
        } catch (TimeoutException unused4) {
            throw new ServerException(ServerException.NETWORK_REQUEST_TIMEOUT_MESSAGE);
        } catch (JSONException unused5) {
            throw new DaoException(DaoException.JSON_RESPONSE_PARSE_ERROR);
        }
    }
}
