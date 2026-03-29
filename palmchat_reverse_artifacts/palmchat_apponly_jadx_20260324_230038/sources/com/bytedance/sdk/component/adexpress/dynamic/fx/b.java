package com.bytedance.sdk.component.adexpress.dynamic.fx;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public String b;
    public String fx;
    public String nr;
    public List<u> u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public JSONObject nr;
        public int u;
    }

    public static b u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    u uVar = new u();
                    uVar.u = jSONObjectOptJSONObject.optInt("id");
                    uVar.nr = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(uVar);
                }
            }
        } catch (JSONException unused) {
        }
        bVar.u = arrayList;
        bVar.nr = jSONObject.optString("diff_data");
        bVar.fx = jSONObject.optString("style_diff");
        bVar.b = jSONObject.optString("tag_diff");
        return bVar;
    }
}
