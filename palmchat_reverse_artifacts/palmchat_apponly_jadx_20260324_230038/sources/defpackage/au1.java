package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class au1 extends wt0 {
    public static final String b = "au1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1570a = vm0.e0;

    public ke2 n(String str, String str2, int i) throws DaoException {
        try {
            String strZ = k86.Z(this.f1570a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cardCode", str);
            jSONObject.put("roomId", str2);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            JSONObject jSONObject2 = (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
            if (jSONObject2 == null) {
                return null;
            }
            LogUtil.i(b, jSONObject2.toString());
            return ke2.a(jSONObject2);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        } catch (JSONException unused2) {
            throw new DaoException("json error");
        }
    }
}
