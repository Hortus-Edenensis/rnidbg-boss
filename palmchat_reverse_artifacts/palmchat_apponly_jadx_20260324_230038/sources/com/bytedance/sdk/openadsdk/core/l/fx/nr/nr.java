package com.bytedance.sdk.openadsdk.core.l.fx.nr;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public JSONObject b;
    public String fx;
    public String nr;
    public bc u;

    public static nr u() {
        return new nr();
    }

    public nr nr(String str) {
        this.fx = str;
        return this;
    }

    public static nr u(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        bc bcVarU = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString("tag", null);
        } catch (Exception unused) {
            strOptString = null;
            strOptString2 = null;
        }
        try {
            strOptString2 = jSONObject.optString("label", null);
            try {
                jSONObjectOptJSONObject = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                try {
                    bcVarU = com.bytedance.sdk.openadsdk.core.u.u(jSONObject.optJSONObject("material_meta"));
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                jSONObjectOptJSONObject = null;
            }
        } catch (Exception unused4) {
            strOptString2 = null;
            jSONObjectOptJSONObject = strOptString2;
        }
        return u().u(strOptString).nr(strOptString2).nr(jSONObjectOptJSONObject).u(bcVarU);
    }

    public nr nr(JSONObject jSONObject) {
        this.b = jSONObject;
        return this;
    }

    public JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.nr);
            jSONObject.put("label", this.fx);
            JSONObject jSONObject2 = this.b;
            if (jSONObject2 != null) {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject2);
            }
            bc bcVar = this.u;
            if (bcVar != null) {
                jSONObject.put("material_meta", bcVar.et());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public nr u(bc bcVar) {
        this.u = bcVar;
        return this;
    }

    public nr u(String str) {
        this.nr = str;
        return this;
    }
}
