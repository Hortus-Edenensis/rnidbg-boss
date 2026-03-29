package defpackage;

import android.os.AsyncTask;
import android.os.RemoteException;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ia5<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f18135a;
    public Response.ErrorListener b;
    public HashMap<String, T> c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Void, Void, JSONObject> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject doInBackground(Void... voidArr) {
            return ia5.this.r();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject != null) {
                ia5.this.f18135a.onResponse(jSONObject);
            } else {
                ia5.this.b.onErrorResponse(new VolleyError());
            }
        }
    }

    public ia5(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, HashMap<String, T> map) {
        this.f18135a = listener;
        this.b = errorListener;
        this.c = map;
    }

    public void p() throws DaoException, JSONException {
        if (this.b == null || this.f18135a == null || this.c == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        LogUtil.i("SignInDao", "signInAsync AppContext.getSecretKey()=" + AppContext.getSecretKey());
        if (AppContext.getSecretKey() == null) {
            q();
        } else {
            s();
        }
    }

    public void q() throws DaoException {
        if (this.b == null || this.f18135a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public JSONObject r() {
        String str = vm0.b0;
        try {
            LogUtil.i("SignInDao", "signInOnSyncImp 1");
            if (AppContext.getSecretKey() == null) {
                try {
                    ch.s().u().x(30000L);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i("SignInDao", "getPeopleNearbySyncImp 2");
            String strZ = k86.Z(str);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            return (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return null;
        } catch (ExecutionException e4) {
            e4.printStackTrace();
            return null;
        } catch (TimeoutException e5) {
            e5.printStackTrace();
            return null;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public void s() throws DaoException, JSONException {
        if (this.b == null || this.f18135a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.b0);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f18135a, this.b);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(wt0.waitTime, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
