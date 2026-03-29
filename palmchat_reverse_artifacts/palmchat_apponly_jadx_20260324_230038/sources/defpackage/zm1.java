package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zm1 extends wt0 {
    public void n() throws DaoException {
        try {
            String strZ = k86.Z(vm0.P);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, strZ, null, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void o(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) throws DaoException {
        if (listener == null || errorListener == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.O);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, null, listener, errorListener);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
