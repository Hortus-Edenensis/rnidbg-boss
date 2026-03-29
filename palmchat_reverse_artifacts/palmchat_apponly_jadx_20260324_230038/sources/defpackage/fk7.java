package defpackage;

import android.text.TextUtils;
import com.bytedance.u.nr.fx;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fk7 {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            mf7.a(e);
            return 0;
        }
    }

    public static String b(String str) {
        Map<String, Object> mapE;
        if (uh7.j() == null || (mapE = uh7.j().e()) == null) {
            return null;
        }
        Object obj = mapE.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static void c(ql7 ql7Var, oi7 oi7Var, fx fxVar) {
        if (ql7Var == null || ql7Var.d() == null || fxVar == null) {
            return;
        }
        JSONObject jSONObjectD = ql7Var.d();
        long jOptLong = jSONObjectD.optLong("crash_time");
        int iA = a(b("aid"));
        String strA = uh7.c().a();
        if (jOptLong <= 0 || iA <= 0 || TextUtils.isEmpty(strA) || "0".equals(strA) || TextUtils.isEmpty(fxVar.u())) {
            return;
        }
        try {
            String str = "android_" + iA + "_" + strA + "_" + jOptLong + "_" + fxVar;
            if (oi7Var == null) {
                jSONObjectD.put("unique_key", str);
                return;
            }
            JSONObject jSONObjectJ = oi7Var.j();
            if (jSONObjectJ != null) {
                jSONObjectJ.put("unique_key", str);
            }
        } catch (JSONException unused) {
        }
    }
}
