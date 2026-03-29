package com.opos.acs.st.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static Map<String, String> a(String str) {
        if (k.a(str)) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            f.b("CommonUtils", "", e);
            return null;
        }
    }

    public static String b(Map<String, String> map) {
        JSONObject jSONObjectA;
        if (map == null || (jSONObjectA = a(map)) == null) {
            return null;
        }
        return jSONObjectA.toString();
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (jSONObject.has(next) && !jSONObject.isNull(next)) {
                try {
                    map.put(next, jSONObject.getString(next));
                } catch (JSONException e) {
                    f.b("CommonUtils", "", e);
                }
            }
        }
        return map;
    }

    public static JSONObject a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            return new JSONObject(map);
        } catch (Exception e) {
            f.b("CommonUtils", "", e);
            return null;
        }
    }
}
