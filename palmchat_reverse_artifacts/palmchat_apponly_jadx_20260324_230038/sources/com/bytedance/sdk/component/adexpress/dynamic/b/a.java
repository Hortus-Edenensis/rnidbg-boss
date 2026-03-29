package com.bytedance.sdk.component.adexpress.dynamic.b;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static String nr(String str, String str2) {
        if (!com.bytedance.sdk.component.adexpress.b.u()) {
            return u.u(str);
        }
        if (str.indexOf(46) < 0) {
            str = str + ".png";
        }
        return str2 + "static/images/" + str;
    }

    public static void u(String str, JSONObject jSONObject) {
        JSONObject jSONObjectGe = com.bytedance.sdk.component.adexpress.nr.ge(str);
        if (jSONObjectGe == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectGe.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        u(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject u(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectGe = com.bytedance.sdk.component.adexpress.nr.ge(str);
        if (jSONObjectGe == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return u(jSONObject2, jSONObjectGe.optJSONObject("themeValues"), jSONObject);
    }

    private static void u(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static JSONObject u(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String u(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectGe = com.bytedance.sdk.component.adexpress.nr.ge(str);
        if (jSONObjectGe == null || (jSONObjectOptJSONObject = jSONObjectGe.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String u(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectGe = com.bytedance.sdk.component.adexpress.nr.ge(str);
        if (jSONObjectGe == null || (jSONObjectOptJSONObject = jSONObjectGe.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject u(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }
}
