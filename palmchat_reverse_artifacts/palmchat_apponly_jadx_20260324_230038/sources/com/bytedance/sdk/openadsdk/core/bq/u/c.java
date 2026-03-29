package com.bytedance.sdk.openadsdk.core.bq.u;

import com.bytedance.sdk.component.u.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ja> u;

    public c(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
        this.u = null;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, final com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("mallTopbarClick", new b.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.c.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new c(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.n.o().tk();
        WeakReference<com.bytedance.sdk.openadsdk.core.ja> weakReference = this.u;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() != null && jSONObject != null) {
            String strOptString = jSONObject.optString("schema");
            if (strOptString.isEmpty()) {
                fx();
                return;
            } else {
                u(strOptString, jSONObject.optBoolean("sync_auth", false));
                return;
            }
        }
        fx();
    }

    private void u(final String str, boolean z) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.bytedance.sdk.openadsdk.core.live.nr.u().pn()) {
            u(str, jSONObject);
            return;
        }
        int iU = com.bytedance.sdk.openadsdk.core.live.nr.u().u(new com.bytedance.sdk.openadsdk.core.live.nr.nr() { // from class: com.bytedance.sdk.openadsdk.core.bq.u.c.2
            @Override // com.bytedance.sdk.openadsdk.core.live.nr.nr
            public void u(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("code")) {
                        Object obj2 = map.get("code");
                        if (obj2 instanceof String) {
                            try {
                                int i = Integer.parseInt((String) obj2);
                                if (i == 1) {
                                    c.this.u(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt("code", Integer.valueOf(i));
                                } catch (JSONException unused) {
                                }
                                c.this.u(i, "授权失败");
                                c.this.u(jSONObject);
                                return;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt("code", -1);
                } catch (JSONException unused3) {
                }
                c.this.u(-1, "授权失败");
                c.this.u(jSONObject);
            }
        }, z);
        jSONObject.putOpt("code", Integer.valueOf(iU));
        if (iU != 1) {
            u(iU, "执行授权失败");
            u(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, JSONObject jSONObject) {
        int iU = com.bytedance.sdk.openadsdk.core.live.nr.u().u(str);
        try {
            jSONObject.putOpt("code", Integer.valueOf(iU));
        } catch (JSONException unused) {
        }
        if (iU != 1) {
            u(iU, "schema 解析失败");
        }
        u(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        com.bytedance.sdk.component.utils.h.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), "努力加载中，请稍后再试", 1);
    }
}
