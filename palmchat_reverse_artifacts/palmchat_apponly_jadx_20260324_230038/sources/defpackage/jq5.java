package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class jq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18481a;
    public long b;
    public HashMap<String, Long> c = new HashMap<>();
    public List<String> d = new ArrayList();
    public String e = null;

    public static jq5 a(JSONObject jSONObject) {
        jq5 jq5Var = new jq5();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("syncKeys");
        LogUtil.i("SyncDao", "operateSyncKeys" + jSONObjectOptJSONObject);
        jq5Var.f18481a = jSONObjectOptJSONObject.optInt("continueFlag");
        jq5Var.b = (long) jSONObjectOptJSONObject.optInt("pushVersion");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("list");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            jq5Var.e = jSONArrayOptJSONArray.toString();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject2.optString("syncKey");
                long jOptLong = jSONObjectOptJSONObject2.optLong("version");
                if (strOptString != null) {
                    jq5Var.c.put(strOptString, Long.valueOf(jOptLong));
                    if (jSONObjectOptJSONObject2.optBoolean("reset")) {
                        jq5Var.d.add(strOptString);
                    }
                }
            }
        }
        LogUtil.i("SyncDao", "SyncVersionResult buildFromJson=" + jq5Var.toString());
        return jq5Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Long> entry : this.c.entrySet()) {
            sb.append("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return "continueFlag=" + this.f18481a + " pushVersion=" + this.b + sb.toString();
    }
}
