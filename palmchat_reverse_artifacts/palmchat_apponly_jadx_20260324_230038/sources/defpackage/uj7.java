package defpackage;

import android.text.TextUtils;
import com.apm.lite.CrashType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class uj7 {
    public static void a(ev6 ev6Var, q37 q37Var, CrashType crashType) {
        if (ev6Var != null) {
            b(ev6Var.G(), q37Var, crashType);
        }
    }

    public static void b(JSONObject jSONObject, q37 q37Var, CrashType crashType) {
        if (jSONObject == null || crashType == null) {
            return;
        }
        long jOptLong = jSONObject.optLong("crash_time");
        String strA = x97.h().a();
        if (jOptLong <= 0 || TextUtils.isEmpty(crashType.getName())) {
            return;
        }
        try {
            String str = "android__" + strA + "_" + jOptLong + "_" + crashType;
            if (q37Var == null || (jSONObject = q37Var.s()) != null) {
                jSONObject.put("unique_key", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
