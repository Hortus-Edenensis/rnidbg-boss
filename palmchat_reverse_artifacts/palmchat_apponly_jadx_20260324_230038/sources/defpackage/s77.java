package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s77 extends va7 {
    @Override // defpackage.va7
    public e07 b(ru6 ru6Var, Context context, String str) throws Throwable {
        return d(ru6Var, context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }

    @Override // defpackage.va7
    public String f(ru6 ru6Var) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("api_name", "/sdk/log");
        map.put("api_version", "1.0.0");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("log_v", "1.0");
        return h(ru6Var, map, map2);
    }

    @Override // defpackage.va7
    public Map<String, String> i(boolean z, String str) {
        HashMap map = new HashMap();
        map.put("msp-gzip", String.valueOf(z));
        map.put("content-type", "application/octet-stream");
        map.put("des-mode", "CBC");
        return map;
    }

    @Override // defpackage.va7
    public JSONObject j() throws JSONException {
        return null;
    }

    @Override // defpackage.va7
    public boolean o() {
        return false;
    }

    @Override // defpackage.va7
    public String g(ru6 ru6Var, String str, JSONObject jSONObject) {
        return str;
    }
}
