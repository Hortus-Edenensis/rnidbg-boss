package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.openadsdk.core.dislike.nr.u {
    private final bc u;

    public u(bc bcVar) {
        this.u = bcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.u
    public boolean u(String str, Dialog dialog) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.u
    public boolean u(iz izVar, String str, Dialog dialog) {
        if (!"7:1".equals(izVar.u())) {
            return false;
        }
        s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.dislike.u.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_feedback_cannot_close");
                if (u.this.u != null) {
                    nrVarU.iz(u.this.u.xx()).n(u.this.u.ap());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("render_control", tk.nr(u.this.u));
                    jSONObject.put("ad_info", u.this.u.yf());
                    jSONObject.put("render_sequence", tk.nr(u.this.u));
                    nrVarU.nr(jSONObject.toString());
                }
                return nrVarU;
            }
        }, "stats_feedback_cannot_close");
        return true;
    }

    public static void u(com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar, bc bcVar) {
        if (nrVar == null || bcVar == null) {
            return;
        }
        nrVar.u(new u(bcVar));
    }
}
