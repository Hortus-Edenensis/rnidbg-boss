package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class js1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f18488a = new HashMap();
    public Map<String, String> b = new HashMap();
    public Map<String, String> c = new HashMap();
    public Map<String, String> d = new HashMap();
    public Map<String, Map<String, String>> e = new HashMap();

    public static js1 a(JSONObject jSONObject) {
        js1 js1Var = new js1();
        if (jSONObject != null) {
            try {
                js1Var.f18488a.putAll(az2.d(new JSONObject(jSONObject.optString("likepersonality_female"))));
                js1Var.b.putAll(az2.d(new JSONObject(jSONObject.optString("likepersonality_male"))));
                js1Var.c.putAll(az2.d(new JSONObject(jSONObject.optString("personality_female"))));
                js1Var.d.putAll(az2.d(new JSONObject(jSONObject.optString("personality_male"))));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("hobby");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("key");
                            String strOptString2 = jSONObjectOptJSONObject.optString("items");
                            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                                js1Var.e.put(strOptString, az2.d(new JSONObject(strOptString2)));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return js1Var;
    }
}
