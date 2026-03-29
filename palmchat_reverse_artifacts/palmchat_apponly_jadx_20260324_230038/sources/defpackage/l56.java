package defpackage;

import android.os.AsyncTask;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l56<T> extends wt0 {
    public static final String e = wm0.e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f18910a;
    public Response.ErrorListener b;
    public String c;
    public String d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Void, Void, JSONObject> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject doInBackground(Void... voidArr) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("dfp", fm1.k().toString());
                jSONObject.put("appList", ac1.s());
                jSONObject.put("platform", "android");
                jSONObject.put("deviceId", ac1.h);
                jSONObject.put("sdid", ac1.v());
                jSONObject.put("dhid", ac1.y());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return l56.this.s(jSONObject);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject != null) {
                l56.this.f18910a.onResponse(jSONObject);
            } else {
                l56.this.b.onErrorResponse(new VolleyError());
            }
        }
    }

    public l56(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, String str, String str2) {
        this.f18910a = listener;
        this.b = errorListener;
        this.c = str;
        this.d = str2;
    }

    public void q() {
        LogUtil.i("UploadDevAndApplistInfoDao", " AppContext.getSecretKey()=" + AppContext.getSecretKey());
        r();
    }

    public final void r() {
        new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final JSONObject s(JSONObject jSONObject) {
        try {
            LogUtil.i("UploadDevAndApplistInfoDao", "uploadOnSkNullImp 1");
            if (AppContext.getSecretKey() == null) {
                try {
                    ch.s().u().x(30000L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            LogUtil.i("UploadDevAndApplistInfoDao", "uploadOnSkNullImp 2");
            String strZ = (il5.l(this.d) || il5.l(this.c)) ? k86.Z(e) : k86.b0(e, this.c, this.d);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, 2, true, (Response.Listener<JSONObject>) requestFutureNewFuture, (Response.ErrorListener) requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            return (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        } catch (InterruptedException e4) {
            e4.printStackTrace();
            return null;
        } catch (ExecutionException e5) {
            e5.printStackTrace();
            return null;
        } catch (TimeoutException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
