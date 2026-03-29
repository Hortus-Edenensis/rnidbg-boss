package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    public Map<String, u> u = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public String b;
        public String fx;
        public String nr;
        public int u;

        public u(JSONObject jSONObject) {
            try {
                this.u = jSONObject.optInt("type");
                this.nr = jSONObject.optString("url");
                this.fx = jSONObject.optString("pid");
                this.b = jSONObject.optString("ecom_live_params");
            } catch (Exception unused) {
            }
        }

        public boolean nr() {
            return 3 == this.u ? !TextUtils.isEmpty(this.b) : !TextUtils.isEmpty(this.nr);
        }

        public JSONObject u() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.u);
                jSONObject.put("url", this.nr);
                jSONObject.put("pid", this.fx);
                jSONObject.put("ecom_live_params", this.b);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public c(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sub_convert_link");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    u uVar = new u(jSONObjectOptJSONObject.optJSONObject(next));
                    if (uVar.nr()) {
                        this.u.put(next, uVar);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String b(bc bcVar, String str) {
        u uVar;
        c cVarU = u(bcVar);
        return (cVarU == null || (uVar = cVarU.u.get(str)) == null) ? "" : uVar.fx;
    }

    public static String fx(bc bcVar, String str) {
        u uVar;
        c cVarU = u(bcVar);
        return (cVarU == null || (uVar = cVarU.u.get(str)) == null) ? "" : uVar.nr;
    }

    public static int nr(bc bcVar, String str) {
        u uVar;
        c cVarU = u(bcVar);
        if (cVarU == null || (uVar = cVarU.u.get(str)) == null) {
            return 0;
        }
        return uVar.u;
    }

    public static String pn(bc bcVar, String str) {
        u uVar;
        c cVarU = u(bcVar);
        return (cVarU == null || (uVar = cVarU.u.get(str)) == null) ? "" : uVar.b;
    }

    public void u(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, u> entry : this.u.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().u());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception unused) {
        }
    }

    private static c u(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.yk();
    }

    public static boolean u(bc bcVar, String str) {
        c cVarU = u(bcVar);
        return (cVarU == null || !cVarU.u.containsKey(str) || TextUtils.isEmpty(fx(bcVar, str))) ? false : true;
    }
}
