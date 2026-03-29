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
import com.zenmen.palmchat.utils.EncryptUtils;
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
/* JADX INFO: loaded from: classes13.dex */
public class m92<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f19166a;
    public Response.ErrorListener b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Void, Void, JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f19167a;
        public final /* synthetic */ int b;

        public a(HashMap map, int i) {
            this.f19167a = map;
            this.b = i;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject doInBackground(Void... voidArr) {
            return m92.this.s(this.f19167a, this.b);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject != null) {
                m92.this.f19166a.onResponse(jSONObject);
            } else {
                m92.this.b.onErrorResponse(new VolleyError());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Void, Void, JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f19168a;
        public final /* synthetic */ int b;

        public b(HashMap map, int i) {
            this.f19168a = map;
            this.b = i;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject doInBackground(Void... voidArr) {
            return m92.this.t(this.f19168a, this.b);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject != null) {
                m92.this.f19166a.onResponse(jSONObject);
            } else {
                m92.this.b.onErrorResponse(new VolleyError());
            }
        }
    }

    public m92(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, boolean z) {
        this.f19166a = listener;
        this.b = errorListener;
        this.c = z;
    }

    public void p(HashMap<String, T> map, int i) throws DaoException, JSONException {
        if (this.b == null || this.f19166a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        LogUtil.i("GetPeopleNearbyDao", "getPeopleNearbyAsync AppContext.getSecretKey()=" + AppContext.getSecretKey());
        if (AppContext.getSecretKey() == null) {
            r(map, i);
        } else {
            v(map, i);
        }
    }

    public void q(HashMap<String, T> map, int i) throws DaoException, JSONException {
        if (this.b == null || this.f19166a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        LogUtil.i("GetPeopleNearbyDao", "getPeopleNearbyAsync AppContext.getSecretKey()=" + AppContext.getSecretKey());
        if (AppContext.getSecretKey() == null) {
            u(map, i);
        } else {
            w(map, i);
        }
    }

    public void r(HashMap<String, T> map, int i) throws DaoException {
        if (this.b == null || this.f19166a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        new a(map, i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public JSONObject s(HashMap<String, T> map, int i) {
        String strX = x();
        try {
            LogUtil.i("GetPeopleNearbyDao", "getPeopleNearbySyncImp 1");
            if (AppContext.getSecretKey() == null) {
                try {
                    ch.s().u().x(30000L);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i("GetPeopleNearbyDao", "getPeopleNearbySyncImp 2");
            String str = k86.Z(strX) + "&index=" + i;
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            EncryptUtils.setLxData(jSONObject);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
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

    public JSONObject t(HashMap<String, T> map, int i) {
        String strY = y();
        try {
            LogUtil.i("GetPeopleNearbyDao", "getPeopleNearbySyncImp 1");
            if (AppContext.getSecretKey() == null) {
                try {
                    ch.s().u().x(30000L);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i("GetPeopleNearbyDao", "getPeopleNearbySyncImp 2");
            String str = k86.Z(strY) + "&index=" + i;
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            EncryptUtils.setLxData(jSONObject);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
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

    public void u(HashMap<String, T> map, int i) throws DaoException {
        if (this.b == null || this.f19166a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        new b(map, i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void v(HashMap<String, T> map, int i) throws DaoException, JSONException {
        if (this.b == null || this.f19166a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String str = k86.Z(x()) + "&index=" + i;
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            EncryptUtils.setLxData(jSONObject);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str, jSONObject, this.f19166a, this.b);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(wt0.waitTime, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void w(HashMap<String, T> map, int i) throws DaoException, JSONException {
        if (this.b == null || this.f19166a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String str = k86.Z(y()) + "&index=" + i;
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            EncryptUtils.setLxData(jSONObject);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str, jSONObject, this.f19166a, this.b);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(wt0.waitTime, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public final String x() {
        String str = nl0.n + "/weblbs/v8/nearby_user.json";
        if (!v13.a()) {
            return str;
        }
        return nl0.z + "/lbs.getNearbyUsers.v9";
    }

    public final String y() {
        return nl0.z + "/lbs.getNearbyUsers.v10";
    }
}
