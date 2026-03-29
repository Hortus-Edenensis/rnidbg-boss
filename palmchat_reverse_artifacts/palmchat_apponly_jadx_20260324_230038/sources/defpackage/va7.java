package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import defpackage.nu6;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class va7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21395a = true;
    public boolean b = true;

    public static String e(nu6.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f19618a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public static JSONObject k(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(ActionUtils.METHOD, str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public static boolean l(nu6.b bVar) {
        return Boolean.valueOf(e(bVar, "msp-gzip")).booleanValue();
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String strOptString = jSONObject.getJSONObject("params").optString("public_key", null);
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            b07.d(strOptString);
            return true;
        } catch (JSONException e) {
            w97.d(e);
            return false;
        }
    }

    public e07 a(ru6 ru6Var, Context context) throws Throwable {
        return b(ru6Var, context, "");
    }

    public e07 b(ru6 ru6Var, Context context, String str) throws Throwable {
        return c(ru6Var, context, str, lh7.a(context));
    }

    public e07 c(ru6 ru6Var, Context context, String str, String str2) throws Throwable {
        return d(ru6Var, context, str, str2, true);
    }

    public e07 d(ru6 ru6Var, Context context, String str, String str2, boolean z) throws Throwable {
        w97.f("mspl", "Packet: " + str2);
        k37 k37Var = new k37(this.b);
        e07 e07Var = new e07(f(ru6Var), g(ru6Var, str, j()));
        Map<String, String> mapI = i(false, str);
        q77 q77VarC = k37Var.c(e07Var, this.f21395a, mapI.get("iSr"));
        nu6.b bVarA = nu6.a(context, new nu6.a(str2, i(q77VarC.b(), str), q77VarC.a()));
        if (bVarA == null) {
            throw new RuntimeException("Response is null.");
        }
        e07 e07VarB = k37Var.b(new q77(l(bVarA), bVarA.c), mapI.get("iSr"));
        return (e07VarB != null && m(e07VarB.b()) && z) ? d(ru6Var, context, str, str2, false) : e07VarB;
    }

    public String f(ru6 ru6Var) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", Build.MODEL);
        map.put("namespace", "com.alipay.mobilecashier");
        map.put("api_name", "com.alipay.mcpay");
        map.put("api_version", n());
        return h(ru6Var, map, new HashMap<>());
    }

    public String g(ru6 ru6Var, String str, JSONObject jSONObject) {
        j07 j07VarE = j07.e();
        su6 su6VarA = su6.a(j07VarE.c());
        JSONObject jSONObjectA = t77.a(new JSONObject(), jSONObject);
        try {
            jSONObjectA.put("external_info", str);
            jSONObjectA.put("tid", su6VarA.g());
            jSONObjectA.put("user_agent", j07VarE.a().a(ru6Var, su6VarA, o()));
            jSONObjectA.put("has_alipay", qh7.v(ru6Var, j07VarE.c(), fu6.d, false));
            jSONObjectA.put("has_msp_app", qh7.a0(j07VarE.c()));
            jSONObjectA.put("app_key", "2014052600006128");
            jSONObjectA.put("utdid", j07VarE.d());
            jSONObjectA.put("new_client_key", su6VarA.f());
            jSONObjectA.put("pa", b07.g(j07VarE.c()));
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "BodyErr", th);
            w97.d(th);
        }
        return jSONObjectA.toString();
    }

    public String h(ru6 ru6Var, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public Map<String, String> i(boolean z, String str) {
        HashMap map = new HashMap();
        map.put("msp-gzip", String.valueOf(z));
        map.put("Operation-Type", "alipay.msp.cashier.dispatch.bytes");
        map.put("content-type", "application/octet-stream");
        map.put("Version", "2.0");
        map.put("AppId", "TAOBAO");
        map.put("Msp-Param", ou6.a(str));
        map.put("des-mode", "CBC");
        return map;
    }

    public abstract JSONObject j() throws JSONException;

    public String n() {
        return "4.9.0";
    }

    public abstract boolean o();
}
