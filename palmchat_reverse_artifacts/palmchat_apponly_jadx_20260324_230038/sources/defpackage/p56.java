package defpackage;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectByteRequest;
import com.android.volley.toolbox.RequestFuture;
import com.efs.sdk.base.Constants;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.util.GZipUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p56<T> extends wt0 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends JsonObjectByteRequest {
        public a(int i, String str, byte[] bArr, Response.Listener listener, Response.ErrorListener errorListener) {
            super(i, str, bArr, listener, errorListener);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers = super.getHeaders();
            headers.put("Content-Encoding-ZX", Constants.CP_GZIP);
            return headers;
        }
    }

    public JSONObject n(HashMap<String, T> map, String str) throws DaoException, JSONException {
        try {
            String strZ = k86.Z(ao0.f() ? vm0.l : vm0.j);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            EncryptUtils.setLxData(jSONObject);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            a aVar = new a(1, strZ, GZipUtil.compress(jSONObject.toString().getBytes("utf-8")), requestFutureNewFuture, requestFutureNewFuture);
            aVar.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(aVar);
            return (JSONObject) requestFutureNewFuture.get(aVar);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return null;
        } catch (TimeoutException e4) {
            e4.printStackTrace();
            return null;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
