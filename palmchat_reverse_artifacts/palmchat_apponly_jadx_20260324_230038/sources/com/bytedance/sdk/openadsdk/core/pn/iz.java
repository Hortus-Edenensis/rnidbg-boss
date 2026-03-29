package com.bytedance.sdk.openadsdk.core.pn;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.qq.s;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static final Map<String, u> u = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final int u;

        public u(n.fx fxVar) {
            this.u = fxVar.x();
        }

        public int u(int i, n.fx fxVar) {
            int i2 = this.u - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> linkedHashMapIz = fxVar.iz();
            int i3 = -1;
            if (linkedHashMapIz == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : linkedHashMapIz.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && iIntValue > i3) {
                    i3 = iIntValue;
                }
            }
            return i3;
        }

        public void u(final int i, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final n.fx fxVar, final String str, final String str2) {
            s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.pn.iz.u.1
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("slot_type", Integer.valueOf(i));
                    jSONObject.putOpt("rit", nrVar.b());
                    jSONObject.putOpt("reason", str);
                    jSONObject.putOpt("reason_value", str2);
                    jSONObject.putOpt("score", Integer.valueOf(u.this.u));
                    jSONObject.putOpt("score_threshold", Integer.valueOf(fxVar.b()));
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("load_score_cache").nr(jSONObject.toString());
                }
            }, "load_score_cache");
        }
    }

    public static u u(String str, n.fx fxVar) {
        if (TextUtils.isEmpty(str)) {
            return new u(fxVar);
        }
        Map<String, u> map = u;
        u uVar = map.get(str);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(fxVar);
        map.put(str, uVar2);
        return uVar2;
    }
}
