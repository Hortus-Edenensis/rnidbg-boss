package defpackage;

import android.os.AsyncTask;
import android.os.RemoteException;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bt;
import com.wifi.utils.WKID;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class m56<T> extends wt0 {
    public static final String c = wm0.d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f19140a;
    public Response.ErrorListener b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Void, Void, JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f19141a;

        public a(JSONObject jSONObject) {
            this.f19141a = jSONObject;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject doInBackground(Void... voidArr) {
            try {
                this.f19141a.put("channelId", ac1.m);
                this.f19141a.put("platform", ac1.c);
                this.f19141a.put("deviceName", ac1.b);
                this.f19141a.put("versionName", ac1.g);
                this.f19141a.put(az.aW, ac1.f);
                this.f19141a.put(WkParams.IMEI, ac1.i);
                this.f19141a.put("imsi", ac1.j);
                this.f19141a.put("osVersion", ac1.e);
                this.f19141a.put("resolution", me1.g() + "-" + me1.f());
                this.f19141a.put(bt.P, ac1.l);
                this.f19141a.put("deviceId", ac1.h);
                this.f19141a.put("simulator", ac1.n ? 1 : 0);
                this.f19141a.put("androidID", ac1.p);
                this.f19141a.put("uiType", "1");
                this.f19141a.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
                this.f19141a.put("sdid", ac1.v());
                this.f19141a.put("ua", ac1.x(AppContext.getContext()));
                this.f19141a.put("mdaDhid", WKID.getInstance().get(AppContext.getContext()));
                this.f19141a.put("mac", ac1.k);
                this.f19141a.put("oneId", "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return m56.this.r(this.f19141a);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject != null) {
                m56.this.f19140a.onResponse(jSONObject);
            } else {
                m56.this.b.onErrorResponse(new VolleyError());
            }
        }
    }

    public m56(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f19140a = listener;
        this.b = errorListener;
    }

    public void p(JSONObject jSONObject) {
        LogUtil.i("UploadDevInfoDao", " AppContext.getSecretKey()=" + AppContext.getSecretKey());
        q(jSONObject);
    }

    public void q(JSONObject jSONObject) {
        new a(jSONObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public JSONObject r(JSONObject jSONObject) {
        try {
            LogUtil.i("UploadDevInfoDao", "uploadOnSkNullImp 1");
            if (AppContext.getSecretKey() == null) {
                try {
                    ch.s().u().x(30000L);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i("UploadDevInfoDao", "uploadOnSkNullImp 2");
            String strZ = k86.Z(c);
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
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
