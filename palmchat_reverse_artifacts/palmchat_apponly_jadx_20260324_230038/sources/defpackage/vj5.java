package defpackage;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ei5;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vj5<R extends BaseNetBean> extends AsyncTask<Object, Void, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21460a;
    public String b;
    public int c;
    public long d = System.currentTimeMillis();
    public long e;
    public ei5<R> f;

    public vj5(String str, ei5 ei5Var, int i, String str2) {
        this.f21460a = str;
        this.f = ei5Var;
        this.b = str2;
        this.c = i;
        qj5.W(str2, str, i);
    }

    public static <R extends BaseNetBean> vj5 d(String str, ei5 ei5Var) {
        return f(str, ei5Var, -1, xn3.a());
    }

    public static <R extends BaseNetBean> vj5 e(String str, ei5 ei5Var, int i) {
        return f(str, ei5Var, i, xn3.a());
    }

    public static <R extends BaseNetBean> vj5 f(String str, ei5 ei5Var, int i, String str2) {
        vj5 vj5Var = new vj5(str, ei5Var, i, str2);
        vj5Var.executeOnExecutor(jo1.a(), new Object[0]);
        return vj5Var;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public R doInBackground(Object... objArr) {
        JSONObject jSONObjectGenRequestParams = this.f.genRequestParams();
        String strOptString = jSONObjectGenRequestParams.optString("native_err");
        aw awVarB = ei5.a.b(jSONObjectGenRequestParams);
        if (!TextUtils.isEmpty(strOptString)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MediationConstant.KEY_ERROR_MSG, strOptString);
                jSONObject.put("resultCode", BaseNetBean.NET_ERR_NATIVE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return (R) b(jSONObject);
        }
        if (awVarB == null && !hx3.m(c.b())) {
            return (R) b(new JSONObject());
        }
        String string = bi5.f1722a + this.f21460a;
        JSONObject jSONObjectA = null;
        try {
            Uri.Builder builderBuildUpon = Uri.parse(string).buildUpon();
            if (!TextUtils.isEmpty(this.b)) {
                builderBuildUpon.appendQueryParameter("requestId", this.b);
            }
            string = builderBuildUpon.build().toString();
            LogUtil.json("SquareTask", jSONObjectGenRequestParams.toString(), "request: " + string);
            this.e = System.currentTimeMillis();
            jSONObjectA = zw4.m(string, 1, jSONObjectGenRequestParams, awVarB);
            if (jSONObjectA != null) {
                LogUtil.json("SquareTask", jSONObjectA.toString(), "response: " + string);
            } else {
                LogUtil.json("SquareTask", "", "response error: " + string);
            }
            return (R) b(jSONObjectA);
        } catch (Exception e2) {
            LogUtil.json("SquareTask", "", "response exception: " + e2.getMessage() + " " + string);
            e2.printStackTrace();
            if ((e2 instanceof ExecutionException) && lw3.c(e2.getCause())) {
                jSONObjectA = lw3.a();
            }
            R r = (R) b(jSONObjectA);
            Pair<Integer, String> pairY = ap3.a().Y(e2);
            r.extCode = ((Integer) pairY.first).intValue();
            r.extMsg = (String) pairY.second;
            return r;
        }
    }

    public final R b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("requestId", this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (R) this.f.handle(jSONObject);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(R r) {
        String errMsg;
        int i;
        int i2 = r.resultCode;
        String str = r.errorMsg;
        if (r.isNetErr() || r.isNativeErr()) {
            errMsg = r.getErrMsg();
            i = -12345;
        } else {
            i = i2;
            errMsg = str;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        qj5.X(this.b, this.f21460a, this.c, jCurrentTimeMillis - this.d, jCurrentTimeMillis - this.e, i, errMsg);
        this.f.onPostExecute(r);
    }
}
