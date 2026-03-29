package defpackage;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ow3<R extends BaseNetBean> extends AsyncTask<Object, Void, R> {
    public static final String g = nl0.c + "/one/ax/";
    public static List<Map<String, Object>> h = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19888a;
    public String b;
    public int c;
    public long d = System.currentTimeMillis();
    public long e;
    public jw3<R> f;

    public ow3(String str, jw3 jw3Var, int i, String str2) {
        this.f19888a = str;
        this.f = jw3Var;
        this.b = str2;
        this.c = i;
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] (LINE:1) ow3.class) */
    public static synchronized Map<String, Object> c() {
        synchronized (ow3.class) {
            if (h.isEmpty()) {
                return new HashMap();
            }
            return h.remove(0);
        }
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] (LINE:1) ow3.class) */
    public static synchronized void e(Map<String, Object> map) {
        synchronized (ow3.class) {
            map.clear();
            if (h.size() >= 5) {
                return;
            }
            h.add(map);
        }
    }

    public static <R extends BaseNetBean> ow3 f(String str, jw3 jw3Var) {
        return g(str, jw3Var, -1, xn3.a());
    }

    public static <R extends BaseNetBean> ow3 g(String str, jw3 jw3Var, int i, String str2) {
        ow3 ow3Var = new ow3(str, jw3Var, i, str2);
        ow3Var.executeOnExecutor(jo1.a(), new Object[0]);
        return ow3Var;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public R doInBackground(Object... objArr) {
        Map<String, Object> mapA = this.f.a(c());
        JSONObject jSONObject = new JSONObject(mapA);
        e(mapA);
        String strOptString = jSONObject.optString("native_err");
        if (!TextUtils.isEmpty(strOptString)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(MediationConstant.KEY_ERROR_MSG, strOptString);
                jSONObject2.put("resultCode", BaseNetBean.NET_ERR_NATIVE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return (R) b(jSONObject2);
        }
        if (!hx3.m(c.b())) {
            return (R) b(new JSONObject());
        }
        String str = g + this.f19888a;
        JSONObject jSONObjectL = null;
        try {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            if (!TextUtils.isEmpty(this.b)) {
                builderBuildUpon.appendQueryParameter("requestId", this.b);
            }
            String string = builderBuildUpon.build().toString();
            LogUtil.json("NetTask", jSONObject.toString(), "request: " + string);
            this.e = System.currentTimeMillis();
            jSONObjectL = zw4.l(string, 1, jSONObject);
            if (jSONObjectL != null) {
                LogUtil.json("NetTask", jSONObjectL.toString(), "response: " + string);
            } else {
                LogUtil.json("NetTask", "", "response error: " + string);
            }
        } catch (Exception e2) {
            LogUtil.json("NetTask", "", "response exception: " + e2.getMessage() + " " + str);
            e2.printStackTrace();
        }
        return (R) b(jSONObjectL);
    }

    public final R b(JSONObject jSONObject) {
        Type[] actualTypeArguments;
        if (jSONObject != null) {
            try {
                jSONObject.put("requestId", this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Type genericSuperclass = this.f.getClass().getGenericSuperclass();
        BaseNetBean baseNetBeanCreateBean = (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0 || jSONObject == null) ? null : (BaseNetBean) az2.b(jSONObject.toString(), actualTypeArguments[0]);
        if (baseNetBeanCreateBean == null) {
            baseNetBeanCreateBean = BaseNetBean.createBean(jSONObject);
        }
        return (R) this.f.b(baseNetBeanCreateBean);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(R r) {
        this.f.c(r);
    }
}
