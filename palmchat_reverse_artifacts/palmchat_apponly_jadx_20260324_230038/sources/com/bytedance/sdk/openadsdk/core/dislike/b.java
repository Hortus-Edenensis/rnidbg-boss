package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private com.bytedance.sdk.openadsdk.core.dislike.fx.fx b;
    private String fx;
    private String nr;
    private boolean u;

    public static b u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return u(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public String b() {
        return this.fx;
    }

    public String fx() {
        return this.nr;
    }

    public boolean nr() {
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.fx.fx pn() {
        return this.b;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.u));
            jSONObject.putOpt("upload_api", this.nr);
            jSONObject.putOpt("alert_text", this.fx);
            com.bytedance.sdk.openadsdk.core.dislike.fx.fx fxVar = this.b;
            if (fxVar != null) {
                jSONObject.putOpt("filter_word", fxVar.n());
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static b u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.u = jSONObject.optBoolean("enable");
        bVar.nr = jSONObject.optString("upload_api");
        bVar.fx = jSONObject.optString("alert_text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter_word");
        if (jSONObjectOptJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.dislike.fx.fx fxVarU = com.bytedance.sdk.openadsdk.core.dislike.fx.fx.u(jSONObjectOptJSONObject);
            if (fxVarU != null) {
                if (TextUtils.isEmpty(fxVarU.u())) {
                    fxVarU.u("99:1");
                }
                if (TextUtils.isEmpty(fxVarU.nr())) {
                    fxVarU.nr("素材反馈");
                }
                fxVarU.nr(false);
            }
            bVar.b = fxVarU;
        }
        return bVar;
    }

    public static com.bytedance.sdk.openadsdk.core.dislike.fx.fx u() {
        b bVarZq = dw.nr().zq();
        if (bVarZq == null || TextUtils.isEmpty(bVarZq.nr)) {
            return null;
        }
        if (dw.nr().fa()) {
            com.bytedance.sdk.openadsdk.core.dislike.fx.fx fxVar = new com.bytedance.sdk.openadsdk.core.dislike.fx.fx();
            fxVar.u("99:1");
            fxVar.nr(true);
            fxVar.nr("其他问题");
            return fxVar;
        }
        return bVarZq.pn();
    }
}
