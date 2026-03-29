package com.bytedance.sdk.openadsdk.core.qq;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class mv implements com.bytedance.sdk.openadsdk.core.qq.fx.u {
    public static final mv u = new mv();

    private mv() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq.fx.u
    public void u(final com.bytedance.sdk.openadsdk.t.u.u uVar, final String str, final boolean z) {
        com.bytedance.sdk.openadsdk.gi.x.nr(new com.bytedance.sdk.component.jk.a("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.core.qq.mv.1
            @Override // java.lang.Runnable
            public void run() {
                if (pn.u(str, 1.0d) || !z) {
                    mv.this.u(uVar, z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.t.u.u uVar, boolean z) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObjectU = uVar.u().u();
            if (jSONObjectU != null) {
                String strOptString = jSONObjectU.optString("event_extra");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(strOptString);
                }
                int iIncrementAndGet = nr.nr.incrementAndGet();
                jSONObject.put("stats_index", iIncrementAndGet);
                jSONObject.put("sdk_session_id", nr.u);
                jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.n.o().xw() ? 1 : 0);
                if (!TextUtils.isEmpty(jp.f5411a)) {
                    jSONObject.put("wrong_stats_url", jp.f5411a);
                }
                if (!TextUtils.isEmpty(jp.jk)) {
                    jSONObject.put("wrong_applog_url", jp.jk);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.rh.u.u().u("DeviceRate", "bytebench_value")));
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("abtest_version", com.bytedance.sdk.openadsdk.core.n.o().mk());
                } catch (Exception unused2) {
                }
                if (com.bytedance.sdk.openadsdk.core.n.o().x()) {
                    jSONObject.putOpt("first_of_two", 1);
                }
                jSONObjectU.put("event_extra", jSONObject.toString());
                com.bytedance.sdk.component.n.nr.b.u.u uVar2 = new com.bytedance.sdk.component.n.nr.b.u.u(UUID.randomUUID().toString(), jSONObjectU);
                uVar2.fx((byte) 0);
                uVar2.nr((byte) 3);
                uVar2.u((byte) 1);
                nr.u(uVar2, jSONObjectU.optString("type"), iIncrementAndGet);
            }
        } catch (Throwable unused3) {
        }
    }
}
