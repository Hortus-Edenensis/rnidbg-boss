package com.bytedance.adsdk.nr.nr.nr.u;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c implements com.bytedance.adsdk.nr.nr.nr.u {
    private final String u;

    public c(String str) {
        this.u = str;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        return this.u;
    }

    public String toString() {
        return "VariableNode [literals=" + this.u + "]";
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU;
        if (map == null || map.size() <= 0 || (objU = u(this.u, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objU;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.iz.VARIABLE;
    }

    public Object u(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u(str.split("\\."), 0, jSONObject);
    }

    private Object u(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf <= iIndexOf2) {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            } else {
                objOpt = jSONObject.opt(str);
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return u(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException unused2) {
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return u(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
