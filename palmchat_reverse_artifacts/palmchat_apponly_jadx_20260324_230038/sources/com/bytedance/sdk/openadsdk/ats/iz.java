package com.bytedance.sdk.openadsdk.ats;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.qq.s;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements pn {
    private Map<String, Object> u;

    @Override // com.bytedance.sdk.openadsdk.ats.pn
    public void u(String str, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", "ser create failed ".concat(String.valueOf(str)));
        } catch (JSONException unused) {
        }
        s.u().u("ats", jSONObject, th);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.pn
    public void u(String str, String str2, String str3, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", str3);
            jSONObject.put("api", str);
            jSONObject.put("impl", str2);
        } catch (JSONException unused) {
        }
        s.u().u("ats", jSONObject, th);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.pn
    public void u(String str, Object obj) {
        Map<String, Object> map;
        if (TextUtils.isEmpty(str) || obj == null || (map = this.u) == null) {
            return;
        }
        map.put(str, obj);
    }

    public Map<String, Object> u() {
        return this.u;
    }
}
