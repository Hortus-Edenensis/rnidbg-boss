package com.bytedance.sdk.component.t.fx;

import android.text.TextUtils;
import com.bytedance.sdk.component.t.fx.u;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private final Map<String, u> b = new HashMap();
    private boolean fx;
    private JSONObject iz;
    private String nr;
    private u pn;
    private String u;

    public fx(JSONObject jSONObject) {
        this.fx = false;
        String next = jSONObject.keys().next();
        this.nr = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.u = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.fx = zOptBoolean;
        if (zOptBoolean) {
            this.iz = jSONObjectOptJSONObject;
        } else {
            u(jSONObjectOptJSONObject);
        }
    }

    private void u(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(f.ax);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            u uVar = new u(jSONArrayOptJSONArray.optJSONObject(i));
            this.b.put(uVar.u(), uVar);
            if (uVar.u().equals(jSONObject.optString("main"))) {
                this.pn = uVar;
            }
        }
    }

    public List<u> fx(u uVar, JSONObject jSONObject, Map<String, Object> map) {
        List<u.C0230u> listB = uVar.b();
        ArrayList arrayList = new ArrayList();
        for (u.C0230u c0230u : listB) {
            if (c0230u != null && u(c0230u.nr(), jSONObject, map)) {
                arrayList.add(u(c0230u.u()));
            }
        }
        return arrayList;
    }

    public String nr() {
        return this.nr;
    }

    public List<u> nr(u uVar, JSONObject jSONObject, Map<String, Object> map) {
        return u(jSONObject, map, uVar.iz());
    }

    public u u(String str) {
        if (this.fx) {
            u(this.iz);
        }
        return this.b.get(str);
    }

    public u u() {
        if (this.fx) {
            u(this.iz);
        }
        return this.pn;
    }

    public List<u> u(u uVar, JSONObject jSONObject, Map<String, Object> map) {
        return u(jSONObject, map, uVar.pn());
    }

    private List<u> u(JSONObject jSONObject, Map<String, Object> map, List<u.C0230u> list) {
        u uVarU;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (u.C0230u c0230u : list) {
            if (c0230u != null && (uVarU = u(c0230u.u())) != null && u(c0230u.nr(), jSONObject, map)) {
                arrayList.add(uVarU);
            }
        }
        return arrayList;
    }

    private static boolean u(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.bytedance.adsdk.nr.nr.u.u(str.substring(2, str.length() - 1)).u(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
