package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private Map<String, Long> b = new HashMap();
    private long fx;
    private long nr;
    private String u;

    private x(String str, long j) {
        this.u = str;
        this.nr = j;
        this.fx = j;
    }

    public static x u(String str) {
        return new x(str, SystemClock.elapsedRealtime());
    }

    public long nr(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.fx;
        this.fx = SystemClock.elapsedRealtime();
        this.b.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long u() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.nr;
        this.b.put(this.u, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void u(JSONObject jSONObject) {
        u(jSONObject, 0L);
    }

    public void u(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.b.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
