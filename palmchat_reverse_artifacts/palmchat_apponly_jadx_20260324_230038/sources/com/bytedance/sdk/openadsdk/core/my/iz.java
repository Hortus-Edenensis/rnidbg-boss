package com.bytedance.sdk.openadsdk.core.my;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.bf;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static volatile iz u;
    private boolean fx;
    private final com.bytedance.sdk.component.b.nr.fx nr;
    private int pn;
    private boolean x;
    private final Set<String> b = new CopyOnWriteArraySet();
    private final Map<String, Long> iz = new ConcurrentHashMap();

    private iz() {
        com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("req_exemption_error_code");
        this.nr = fxVarU;
        Map all = fxVarU.getAll();
        if (all != null) {
            for (Map.Entry entry : all.entrySet()) {
                if (entry != null) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if ((key instanceof String) && (value instanceof Long)) {
                        this.iz.put((String) key, (Long) value);
                    }
                }
            }
        }
    }

    private void fx() {
        if (this.x) {
            return;
        }
        this.x = true;
        dw.nr().mv();
    }

    public static iz u() {
        if (u == null) {
            synchronized (iz.class) {
                if (u == null) {
                    u = new iz();
                }
            }
        }
        return u;
    }

    public boolean nr(String str) {
        if (!nr() || TextUtils.isEmpty(str)) {
            return false;
        }
        Long l = this.iz.get(str);
        if (l == null) {
            return true;
        }
        if (System.currentTimeMillis() - l.longValue() <= this.pn) {
            return false;
        }
        this.iz.remove(str);
        this.nr.remove(str);
        return true;
    }

    public void u(String str, int i, int i2) {
        String str2;
        if (!nr() || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        String strValueOf = String.valueOf(i);
        if (i2 != 0) {
            str2 = (strValueOf + "_") + String.valueOf(i2);
        } else {
            str2 = strValueOf;
        }
        if (this.b.contains(strValueOf) || this.b.contains(str2)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.nr.put(str, jCurrentTimeMillis);
            this.iz.put(str, Long.valueOf(jCurrentTimeMillis));
        }
    }

    public boolean nr() {
        fx();
        return this.fx;
    }

    public void u(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        }
        u(jSONObject);
    }

    public void u(JSONObject jSONObject) {
        this.b.clear();
        if (jSONObject != null) {
            this.fx = jSONObject.optBoolean("enable", false);
            int iOptInt = jSONObject.optInt("duration", 0) * 1000;
            this.pn = iOptInt;
            if (iOptInt <= 0) {
                this.fx = false;
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("error_codes");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.b.add(strOptString);
                    }
                }
            }
            if (this.b.isEmpty()) {
                this.fx = false;
                return;
            }
            return;
        }
        this.fx = false;
    }
}
