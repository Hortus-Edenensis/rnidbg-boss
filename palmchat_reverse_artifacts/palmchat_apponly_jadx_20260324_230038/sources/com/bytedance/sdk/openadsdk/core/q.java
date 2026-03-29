package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q {
    private Map<String, Long> b = new HashMap();
    private long fx;
    private long nr;
    private String u;

    private q(String str, long j) {
        this.u = str;
        this.nr = j;
        this.fx = j;
    }

    public static q u(String str) {
        return new q(str, SystemClock.elapsedRealtime());
    }

    public long nr(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.fx;
        this.fx = jElapsedRealtime;
        this.b.put(str, Long.valueOf(j));
        return j;
    }

    public long u() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.nr;
        this.b.put(this.u, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void u(String str, long j) {
        this.b.put(str, Long.valueOf(j));
    }

    public long nr() {
        return SystemClock.elapsedRealtime() - this.nr;
    }

    public void u(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.b.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value.longValue() > j || key.equals("armor_load_cost"))) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public JSONObject u(long j) {
        JSONObject jSONObject = new JSONObject();
        u(jSONObject, j);
        return jSONObject;
    }
}
