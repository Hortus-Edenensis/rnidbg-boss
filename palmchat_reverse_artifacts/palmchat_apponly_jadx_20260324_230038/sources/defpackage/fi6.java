package defpackage;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.transformer.ExportException;
import com.igexin.push.core.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class fi6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<String> f17535a;
    public static final String b;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f17535a = sparseArray;
        sparseArray.put(-1, "un support");
        sparseArray.put(0, b.B);
        sparseArray.put(3001, "请求异常");
        sparseArray.put(3007, "未知异常");
        sparseArray.put(4001, "客户端请求异常");
        sparseArray.put(4002, "参数非法");
        sparseArray.put(4003, "数据格式解析异常");
        sparseArray.put(5001, "服务端异常");
        sparseArray.put(5002, "服务端返回非法数据");
        sparseArray.put(5003, "没有数据");
        sparseArray.put(5004, "没有访问权限");
        sparseArray.put(6001, "没有网络");
        sparseArray.put(6002, "网络异常");
        sparseArray.put(7001, "支付取消");
        sparseArray.put(ExportException.ERROR_CODE_MUXING_TIMEOUT, "支付异常");
        sparseArray.put(ExportException.ERROR_CODE_MUXING_APPEND, "订单创建失败");
        sparseArray.put(7004, "未选择支付方式");
        b = "{\"code\":3007,\"msg\":\"" + sparseArray.get(3007) + "\"}";
    }

    public static String a(int i) {
        return b(i, f17535a.get(i));
    }

    public static String b(int i, String str) {
        return c(i, str, null, new Pair[0]);
    }

    public static String c(int i, String str, JSONObject jSONObject, Pair<String, Object>... pairArr) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("code", Integer.valueOf(i));
            try {
                jSONObject2.putOpt("msg", str);
            } catch (JSONException e) {
                LogUtil.e("LxWallet", e);
            }
            try {
                jSONObject2.putOpt("data", jSONObject);
            } catch (JSONException e2) {
                LogUtil.e("LxWallet", e2);
            }
            if (pairArr != null) {
                for (Pair<String, Object> pair : pairArr) {
                    try {
                        jSONObject2.putOpt((String) pair.first, pair.second);
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONObject2.toString();
        } catch (JSONException e3) {
            LogUtil.e("LxWallet", e3);
            return b;
        }
    }

    public static String d(int i, Pair<String, Object>... pairArr) {
        return c(i, f17535a.get(i), null, pairArr);
    }

    public static String e(JSONObject jSONObject) {
        return c(0, f17535a.get(0), jSONObject, new Pair[0]);
    }

    public static String f(JSONObject jSONObject, Pair<String, Object>... pairArr) {
        return c(0, f17535a.get(0), jSONObject, pairArr);
    }
}
