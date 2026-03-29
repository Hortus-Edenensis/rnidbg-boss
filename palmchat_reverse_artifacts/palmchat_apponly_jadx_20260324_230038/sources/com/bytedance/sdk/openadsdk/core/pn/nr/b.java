package com.bytedance.sdk.openadsdk.core.pn.nr;

import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public Map<String, JSONObject> nr;
    public int u;

    public boolean u() {
        int i = this.u;
        return i > 20000 && i < 100000;
    }

    public static b u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("code");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
        HashMap map = new HashMap();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString(ReportItem.RequestKeyRequestId, "");
                    if (!TextUtils.isEmpty(u(strOptString, strOptString2))) {
                        map.put(u(strOptString, strOptString2), jSONObjectOptJSONObject);
                    }
                }
            }
        }
        b bVar = new b();
        bVar.nr = map;
        bVar.u = iOptInt;
        return bVar;
    }

    public static String u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + "_" + str;
    }
}
