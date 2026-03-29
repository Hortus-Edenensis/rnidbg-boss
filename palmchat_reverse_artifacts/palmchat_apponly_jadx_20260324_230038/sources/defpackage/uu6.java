package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import defpackage.xt6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class uu6 {
    public static au6 a() {
        try {
            try {
                return cu6.b("NP", System.currentTimeMillis(), new v47(j07.e().d()), (short) xt6.c.a(j07.e().c()), new ic7());
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return cu6.c();
        }
    }

    public static HashMap<String, String> b(ru6 ru6Var) {
        HashMap<String, String> map = new HashMap<>();
        try {
            au6 au6VarA = a();
            JSONObject jSONObject = new JSONObject();
            Context contextA = ru6Var != null ? ru6Var.a() : null;
            if (contextA == null) {
                contextA = j07.e().c().getApplicationContext();
            }
            String strI = qh7.i(ru6Var, contextA);
            String strC = rz6.c(ru6Var, contextA);
            jSONObject.put("ap_q", au6VarA != null ? au6VarA.a() : "");
            jSONObject.put("ap_link_token", ru6Var != null ? ru6Var.d : "");
            jSONObject.put("u_pd", String.valueOf(qh7.V()));
            jSONObject.put("u_lk", String.valueOf(qh7.O(qh7.B())));
            jSONObject.put("u_pi", String.valueOf(ru6Var != null ? ru6Var.g : "_"));
            jSONObject.put("u_fu", strI);
            jSONObject.put("u_oi", strC);
            map.put("ap_req", jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(au6VarA != null ? au6VarA.a() : "");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(strI);
            xt6.b(ru6Var, "biz", "ap_q", sb.toString());
        } catch (Exception e) {
            xt6.c(ru6Var, "biz", "APMEx1", e);
        }
        return map;
    }

    public static JSONObject c(ru6 ru6Var, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("ap_resp");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return new JSONObject(strOptString);
        } catch (JSONException e) {
            xt6.c(ru6Var, "biz", "APMEx2", e);
            return null;
        }
    }

    public static void d(ru6 ru6Var, HashMap<String, String> map) {
        JSONObject jSONObjectB = vt6.I().b();
        if (map == null || jSONObjectB == null) {
            return;
        }
        xt6.b(ru6Var, "biz", "ap_r", jSONObjectB.optString("ap_r"));
        map.putAll(qh7.o(jSONObjectB));
    }

    public static void e(ru6 ru6Var, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt("ap_args", jSONObject2);
        } catch (JSONException e) {
            xt6.c(ru6Var, "biz", "APMEx2", e);
        }
    }
}
