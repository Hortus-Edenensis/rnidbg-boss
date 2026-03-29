package defpackage;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n56<T> extends wt0 {
    public void n() throws DaoException {
        try {
            String strZ = k86.Z(vm0.G);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, strZ, null, requestFutureNewFuture, requestFutureNewFuture);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void o() throws DaoException {
        try {
            String strZ = k86.Z(vm0.H);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(0, strZ, null, requestFutureNewFuture, requestFutureNewFuture);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
