package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bq {
    private Map<String, u> u;

    public static bq fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        bq bqVar = new bq();
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    map.put(next, new u(jSONArrayOptJSONArray.optInt(0), jSONArrayOptJSONArray.optInt(1)));
                }
            }
            bqVar.u(map);
        } catch (JSONException unused) {
        }
        return bqVar;
    }

    public int nr(String str) {
        int iU = u(false);
        Map<String, u> map = this.u;
        if (map != null && map.containsKey(str)) {
            u uVar = this.u.get(str);
            iU = uVar != null ? iU + uVar.nr() : iU + 5000;
        }
        return iU + 5000;
    }

    @NonNull
    public String toString() {
        if (this.u == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, u> entry : this.u.entrySet()) {
            u value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.u());
                jSONArray.put(value.nr());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject.toString();
    }

    public void u(Map<String, u> map) {
        this.u = map;
    }

    public int u(String str) {
        int iU = u(true);
        Map<String, u> map = this.u;
        if (map != null && map.containsKey(str)) {
            u uVar = this.u.get(str);
            iU = uVar != null ? iU + uVar.u() : iU + 5000;
        }
        return iU + 5000;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private int nr;
        private int u;

        public u(int i, int i2) {
            this.u = i;
            this.nr = i2;
        }

        public int nr() {
            return this.nr;
        }

        public int u() {
            return this.u;
        }

        public u() {
        }
    }

    private int u(boolean z) {
        float fYm;
        int iMx = 0;
        if (!com.bytedance.sdk.openadsdk.core.dw.nr().wf()) {
            return 0;
        }
        double d = 0.0d;
        try {
            String strU = com.bytedance.sdk.openadsdk.core.rh.u.u().u("DeviceRate", "bytebench_value");
            if (!TextUtils.isEmpty(strU)) {
                double d2 = Double.parseDouble(strU);
                if (d2 >= 0.0d) {
                    try {
                        if (d2 < com.bytedance.sdk.openadsdk.core.dw.nr().yb()) {
                            iMx = 0 + com.bytedance.sdk.openadsdk.core.dw.nr().mx();
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                d = d2;
            }
        } catch (NumberFormatException unused2) {
        }
        try {
            int i = Integer.parseInt(com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", z ? "h5_render_success" : "native_render_success"));
            int i2 = Integer.parseInt(com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", z ? "h5_render_fail" : "native_render_fail"));
            int i3 = i + i2;
            float f = i3 > 0 ? (i2 / i3) * 100.0f : 0.0f;
            if (z) {
                fYm = com.bytedance.sdk.openadsdk.core.dw.nr().bp();
            } else {
                fYm = com.bytedance.sdk.openadsdk.core.dw.nr().ym();
            }
            if (f >= fYm) {
                iMx += com.bytedance.sdk.openadsdk.core.dw.nr().mx();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isH5", z);
            jSONObject.put("bytebenchScore", d);
            jSONObject.put("successCount", i);
            jSONObject.put("failCount", i2);
            jSONObject.put("errorRate", f);
            jSONObject.put("result", iMx);
            com.bytedance.sdk.openadsdk.core.qq.s.u().x(jSONObject);
        } catch (NumberFormatException | JSONException unused3) {
        }
        return iMx;
    }
}
