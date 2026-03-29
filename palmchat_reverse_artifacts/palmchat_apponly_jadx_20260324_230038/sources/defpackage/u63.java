package defpackage;

import android.os.AsyncTask;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.lantern.auth.http.HttpPostManager;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class u63 extends AsyncTask<Void, Void, LXBaseNetBean<JSONObject>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nx4 f21147a;
    public b73 b;

    public u63(b73 b73Var, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        this.b = b73Var;
        this.f21147a = nx4Var;
        if (b73Var != null) {
            HashMap map = new HashMap();
            map.put("requestId", b73Var.f1660a);
            map.put("url", b73Var.b);
            zn6.j("lx_login_req", null, map);
        }
    }

    public static void e(b73 b73Var, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        new u63(b73Var, nx4Var).executeOnExecutor(HttpPostManager.getExecutorPool(), new Void[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.android.volley.toolbox.JsonObjectRequest] */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.android.volley.Request] */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.zenmen.palmchat.utils.EncryptedJsonRequest] */
    public final Request a(sw4 sw4Var, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) throws UnsupportedEncodingException {
        ?? jsonObjectRequest;
        JSONObject jSONObjectD = sw4Var.d();
        if (sw4Var.h) {
            if (sw4Var.c == 1) {
                EncryptUtils.setLxData(jSONObjectD);
            }
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
        } else {
            jsonObjectRequest = new JsonObjectRequest(sw4Var.j, k86.Z(sw4Var.f), jSONObjectD, listener, errorListener);
            if (sw4Var.g) {
                jsonObjectRequest.addHeader(Request.HEADER_RUN_IN_THREAD, "1");
            }
        }
        ux4 ux4Var = sw4Var.l;
        if (ux4Var != null) {
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(ux4Var.f21317a, ux4Var.b, ux4Var.c));
        } else {
            jsonObjectRequest.setRetryPolicy(wt0.genRetryPolicy());
        }
        jsonObjectRequest.setPriority(c(sw4Var.k));
        return jsonObjectRequest;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [T, org.json.JSONObject] */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: b */
    public LXBaseNetBean<JSONObject> doInBackground(Void... voidArr) {
        LXBaseNetBean<JSONObject> lXBaseNetBean = new LXBaseNetBean<>();
        try {
            sw4 requestArgs = this.b.getRequestArgs();
            LogUtil.json("LoginCommonTask", requestArgs.d(), "request:" + requestArgs.f);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            Request requestA = a(requestArgs, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(requestA);
            JSONObject jSONObject = (JSONObject) requestFutureNewFuture.get(requestA);
            if (jSONObject != null) {
                LogUtil.json("LoginCommonTask", jSONObject, "response:" + requestArgs.f);
                lXBaseNetBean.resultCode = jSONObject.optInt("resultCode");
                lXBaseNetBean.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                lXBaseNetBean.data = jSONObject.optJSONObject("data");
            } else {
                LogUtil.json("LoginCommonTask", "get null resp", "response:" + requestArgs.f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            LogUtil.log4ClientError("LoginCommonTask_Throwable", null, th, true);
        }
        HashMap map = new HashMap();
        if (lXBaseNetBean.isNetError()) {
            map.put(MediationConstant.KEY_ERROR_MSG, "网络错误");
        } else {
            map.put(MediationConstant.KEY_ERROR_MSG, lXBaseNetBean.errorMsg);
        }
        map.put("resultCode", Integer.valueOf(lXBaseNetBean.resultCode));
        map.put("requestId", this.b.f1660a);
        map.put("url", this.b.b);
        zn6.j("lx_login_resp", null, map);
        return this.b.a(lXBaseNetBean);
    }

    public final Request.Priority c(int i) {
        Request.Priority priority = Request.Priority.NORMAL;
        return i == 0 ? Request.Priority.LOW : (i != 1 && i == 2) ? Request.Priority.HIGH : priority;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d */
    public void onPostExecute(LXBaseNetBean<JSONObject> lXBaseNetBean) {
        this.f21147a.a(lXBaseNetBean);
    }
}
