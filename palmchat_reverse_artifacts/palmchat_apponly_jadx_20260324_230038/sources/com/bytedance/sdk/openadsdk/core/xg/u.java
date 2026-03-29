package com.bytedance.sdk.openadsdk.core.xg;

import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.jk.u.nr;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static boolean nr = false;
    public static volatile boolean u = true;

    public static void nr() {
        JSONObject jSONObjectRv = dw.nr().rv();
        if (jSONObjectRv == null) {
            return;
        }
        t tVar = t.nr;
        int iOptInt = jSONObjectRv.optInt("big_max_mum", 50);
        if (iOptInt > 0) {
            tVar.b(iOptInt);
        }
        int iOptInt2 = jSONObjectRv.optInt("core_count", 0);
        if (iOptInt2 > 0) {
            tVar.fx(iOptInt2);
        }
        int iOptInt3 = jSONObjectRv.optInt("big_keep_alive", 0);
        if (iOptInt3 > 0) {
            tVar.u(iOptInt3);
        }
        tVar.pn(jSONObjectRv.optBoolean("big_priority", false));
        tVar.fx(jSONObjectRv.optBoolean("catch_oom", true));
        tVar.nr(jSONObjectRv.optBoolean("forbid_autosize_oom", true));
        tVar.iz(jSONObjectRv.optBoolean("enable_proxy", true));
        u = jSONObjectRv.optBoolean("can_set_crash", true);
        x.u(jSONObjectRv.optBoolean("autosize", true));
        tVar.a(jSONObjectRv.optBoolean("report_task", false));
        tVar.nr(jSONObjectRv.optInt("wait_in_big", 50));
        tVar.fx(jSONObjectRv.optInt("wait_in_little", 2000));
        tVar.b(jSONObjectRv.optInt("run_cost", 6000));
    }

    public static void u() {
        if (nr) {
            return;
        }
        nr = true;
        t tVar = t.nr;
        tVar.u(11);
        tVar.b(d.u());
        tVar.fx(true);
        tVar.u(true);
        tVar.nr(true);
        tVar.u(new nr() { // from class: com.bytedance.sdk.openadsdk.core.xg.u.1
            @Override // com.bytedance.sdk.component.jk.u.nr
            public String u(String str) {
                return str != null ? str.startsWith("csj") ? str : "csj_".concat(str) : "csj_uk";
            }
        });
    }
}
