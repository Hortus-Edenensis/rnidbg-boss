package com.bytedance.sdk.component.u;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    private final Map<String, Object> u = new ConcurrentHashMap();

    private k() {
    }

    public static k u() {
        return new k();
    }

    public String nr() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.u.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public k u(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.u.put(str, obj);
        }
        return this;
    }
}
