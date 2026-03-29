package defpackage;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.PostFormRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.zenmen.palmchat.ad.model.FormText;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class th6 implements ko2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gs f20988a;

        public a(gs gsVar) {
            this.f20988a = gsVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            try {
                this.f20988a.onSuccess(new JSONObject(str), null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends gs {
        public final /* synthetic */ go2 f;

        public b(go2 go2Var) {
            this.f = go2Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            this.f.onResult(false, null, exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            Exception exc;
            LXBaseNetBean lXBaseNetBeanCreate;
            try {
                lXBaseNetBeanCreate = LXBaseNetBean.create(this.f, jSONObject);
                exc = null;
            } catch (Exception e) {
                exc = e;
                lXBaseNetBeanCreate = null;
            }
            if (lXBaseNetBeanCreate != null) {
                this.f.onResult(true, lXBaseNetBeanCreate, null);
            } else {
                this.f.onResult(false, null, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends gs {
        public final /* synthetic */ yw4 f;

        public c(yw4 yw4Var) {
            this.f = yw4Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            yw4 yw4Var = this.f;
            if (yw4Var != null) {
                yw4Var.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            yw4 yw4Var = this.f;
            if (yw4Var != null) {
                yw4Var.onSuccess(jSONObject, yy2Var);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends gs {
        public final /* synthetic */ yw4 f;

        public d(yw4 yw4Var) {
            this.f = yw4Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            yw4 yw4Var = this.f;
            if (yw4Var != null) {
                yw4Var.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            yw4 yw4Var = this.f;
            if (yw4Var != null) {
                yw4Var.onSuccess(jSONObject, yy2Var);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gs f20989a;

        public e(gs gsVar) {
            this.f20989a = gsVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f20989a.onFail(volleyError);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.Listener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gs f20990a;

        public f(gs gsVar) {
            this.f20990a = gsVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            try {
                this.f20990a.onSuccess(new JSONObject(str), null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends gs {
        public final /* synthetic */ yw4 f;

        public g(yw4 yw4Var) {
            this.f = yw4Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            yw4 yw4Var = this.f;
            if (yw4Var != null) {
                yw4Var.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            yw4 yw4Var = this.f;
            if (yw4Var != null) {
                yw4Var.onSuccess(jSONObject, yy2Var);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gs f20991a;

        public h(gs gsVar) {
            this.f20991a = gsVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f20991a.onFail(volleyError);
        }
    }

    @Override // defpackage.ko2
    public void a(String str, String str2, String str3, yw4 yw4Var) throws Exception {
        d dVar = new d(yw4Var);
        dVar.f(yw4Var != null && yw4Var.toastOnFail());
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        rs3 rs3Var = new rs3(k86.Z(str), new e(dVar), new f(dVar), new File(str2), str3, null);
        rs3Var.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
        normalRequestQueue.add(rs3Var);
    }

    @Override // defpackage.ko2
    public void b(String str, String str2, String str3, String str4, String str5, yw4 yw4Var) throws Exception {
        g gVar = new g(yw4Var);
        gVar.f(yw4Var != null && yw4Var.toastOnFail());
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        rs3 rs3Var = new rs3(k86.b0(str, str2, str3), new h(gVar), new a(gVar), new File(str4), str5, null);
        rs3Var.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
        normalRequestQueue.add(rs3Var);
    }

    @Override // defpackage.ko2
    public void c(String str, int i, JSONObject jSONObject, yw4 yw4Var, boolean z, boolean z2) {
        c cVar = new c(yw4Var);
        cVar.f(yw4Var != null && yw4Var.toastOnFail());
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        if (z) {
            try {
                str = k86.Z(str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String str2 = str;
        Request encryptedJsonRequest = z2 ? new EncryptedJsonRequest(i, str2, jSONObject, cVar.e(), cVar.d()) : new JsonObjectRequest(i, str2, jSONObject, cVar.e(), cVar.d());
        if (yw4Var != null) {
            encryptedJsonRequest.setCacheConfig(yw4Var.getCacheConfig());
        }
        encryptedJsonRequest.setRetryPolicy(wt0.genRetryPolicy());
        normalRequestQueue.add(encryptedJsonRequest);
    }

    @Override // defpackage.ko2
    public JSONObject d(String str, int i, JSONObject jSONObject, boolean z, aw awVar) throws Exception {
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        Request encryptedJsonRequest = z ? new EncryptedJsonRequest(i, k86.Z(str), jSONObject, requestFutureNewFuture, requestFutureNewFuture) : new JsonObjectRequest(i, k86.Z(str), jSONObject, requestFutureNewFuture, requestFutureNewFuture);
        encryptedJsonRequest.setRetryPolicy(wt0.genRetryPolicy());
        encryptedJsonRequest.setCacheConfig(awVar);
        normalRequestQueue.add(encryptedJsonRequest);
        return (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
    }

    @Override // defpackage.ko2
    public LXBaseNetBean e(go2 go2Var) throws Exception {
        sw4 requestArgs = go2Var.getRequestArgs();
        LogUtil.json("VolleyRequestManager", requestArgs.d(), "request:" + requestArgs.f);
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        Request requestJ = j(requestArgs, requestFutureNewFuture, requestFutureNewFuture);
        requestJ.setCacheConfig(requestArgs.o);
        normalRequestQueue.add(requestJ);
        JSONObject jSONObject = (JSONObject) requestFutureNewFuture.get(requestJ);
        if (jSONObject != null) {
            LogUtil.json("VolleyRequestManager", jSONObject, "response:" + requestArgs.f);
        } else {
            LogUtil.json("VolleyRequestManager", "get null resp", "response:" + requestArgs.f);
        }
        return LXBaseNetBean.create(go2Var, jSONObject);
    }

    @Override // defpackage.ko2
    public void f(go2 go2Var) {
        sw4 requestArgs = go2Var.getRequestArgs();
        b bVar = new b(go2Var);
        bVar.g(requestArgs.m, requestArgs.n);
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        try {
            Request requestJ = j(requestArgs, bVar.e(), bVar.d());
            requestJ.setCacheConfig(requestArgs.o);
            normalRequestQueue.add(requestJ);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.ko2
    public void g(JSONObject jSONObject) {
        try {
            EncryptUtils.setLxData(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.ko2
    public String getUserAgent() {
        return Volley.getUserAgent();
    }

    @Override // defpackage.ko2
    public JSONObject h(String str, HashMap<String, Object> map, boolean z) throws Exception {
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        Request encryptedJsonRequest = z ? new EncryptedJsonRequest(1, k86.Z(str), jSONObject, requestFutureNewFuture, requestFutureNewFuture) : new JsonObjectRequest(1, k86.Z(str), jSONObject, requestFutureNewFuture, requestFutureNewFuture);
        normalRequestQueue.add(encryptedJsonRequest);
        return (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
    }

    public final List<FormText> i(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                arrayList.add(new FormText(next, jSONObject.optString(next)));
            }
        }
        return arrayList;
    }

    @Override // defpackage.ko2
    public void init(Context context) {
        VolleyNetwork.init(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.android.volley.toolbox.JsonObjectRequest] */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.android.volley.toolbox.PostFormRequest] */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.android.volley.Request] */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.zenmen.palmchat.utils.EncryptedJsonRequest] */
    public final Request j(sw4 sw4Var, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) throws UnsupportedEncodingException {
        ?? jsonObjectRequest;
        JSONObject jSONObjectD = sw4Var.d();
        if (sw4Var.h) {
            jsonObjectRequest = new EncryptedJsonRequest(sw4Var.j, k86.Z(sw4Var.f), jSONObjectD, sw4Var.c, sw4Var.d, listener, errorListener);
            if (sw4Var.g) {
                jsonObjectRequest.addHeader(Request.HEADER_RUN_IN_THREAD, "1");
            }
            HashMap<String, String> map = sw4Var.b;
            if (map != null) {
                for (String str : map.keySet()) {
                    jsonObjectRequest.addHeader(str, sw4Var.b.get(str));
                }
            }
        } else if (sw4Var.i) {
            jsonObjectRequest = new PostFormRequest(k86.Z(sw4Var.f), i(jSONObjectD), listener, errorListener);
        } else {
            jsonObjectRequest = new JsonObjectRequest(sw4Var.j, k86.Z(sw4Var.f), jSONObjectD, listener, errorListener);
            if (sw4Var.g) {
                jsonObjectRequest.addHeader(Request.HEADER_RUN_IN_THREAD, "1");
            }
            HashMap<String, String> map2 = sw4Var.b;
            if (map2 != null) {
                for (String str2 : map2.keySet()) {
                    jsonObjectRequest.addHeader(str2, sw4Var.b.get(str2));
                }
            }
        }
        ux4 ux4Var = sw4Var.l;
        if (ux4Var != null) {
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(ux4Var.f21317a, ux4Var.b, ux4Var.c));
        } else {
            jsonObjectRequest.setRetryPolicy(wt0.genRetryPolicy());
        }
        jsonObjectRequest.setPriority(k(sw4Var.k));
        return jsonObjectRequest;
    }

    public final Request.Priority k(int i) {
        Request.Priority priority = Request.Priority.NORMAL;
        return i == 0 ? Request.Priority.LOW : (i != 1 && i == 2) ? Request.Priority.HIGH : priority;
    }
}
