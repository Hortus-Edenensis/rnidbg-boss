package com.bytedance.sdk.openadsdk.core.ugeno.n;

import com.bytedance.sdk.openadsdk.core.gi.nr;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(JSONObject jSONObject);
    }

    public static void u(com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar, u uVar2) {
        if (uVar == null) {
            if (uVar2 != null) {
                uVar2.u(null);
            }
        } else {
            u(uVar.fx(), uVar.u(), uVar.nr(), uVar2);
        }
    }

    public static void u(String str, String str2, String str3, final u uVar) {
        JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.ugeno.x.u().u(str2, str3);
        if (jSONObjectU == null) {
            com.bytedance.sdk.openadsdk.core.gi.nr.u(str, str2, str3, new nr.InterfaceC0259nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.pn.1
                @Override // com.bytedance.sdk.openadsdk.core.gi.nr.InterfaceC0259nr
                public void u(JSONObject jSONObject) {
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.u(jSONObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.gi.nr.InterfaceC0259nr
                public void u() {
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.u(null);
                    }
                }
            });
        } else if (uVar != null) {
            uVar.u(jSONObjectU);
        }
    }
}
