package com.bytedance.sdk.openadsdk.core.s;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.pb;
import com.bytedance.sdk.openadsdk.core.s.a;
import com.huawei.openalliance.ad.constant.az;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private static volatile n u;

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(bc bcVar, String str) {
        if (bcVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        fxVarU.put("save_jump_success_time", System.currentTimeMillis());
        JSONObject jSONObjectEt = bcVar.et();
        if (jSONObjectEt == null) {
            return;
        }
        fxVarU.put("save_dpl_success_materialmeta", jSONObjectEt.toString());
        fxVarU.put("save_jump_success_ad_tag", str);
    }

    public static n u() {
        if (u == null) {
            synchronized (n.class) {
                if (u == null) {
                    u = new n();
                }
            }
        }
        return u;
    }

    public void u(final bc bcVar, final String str, final boolean z) {
        if (bcVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new a().u(new a.u() { // from class: com.bytedance.sdk.openadsdk.core.s.n.1
            private boolean iz = false;

            private void nr(String str2) {
                bc bcVar2 = bcVar;
                if (bcVar2 == null || this.iz) {
                    return;
                }
                boolean zHc = bcVar2.hc();
                my myVarKv = bcVar.kv();
                if (myVarKv == null || myVarKv.u()) {
                    return;
                }
                int iFx = myVarKv.fx();
                if (zHc) {
                    return;
                }
                if (iFx == 1 || iFx == 2) {
                    pb.u(bcVar, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.a.u
            public void u() {
                u(false, az.ag);
                if (!z) {
                    nr(str);
                }
                com.bytedance.sdk.openadsdk.core.nr.u().put("dpl_reject_by_dialog", true);
                b.u(bcVar, str, "dpl_popup", System.currentTimeMillis() - jCurrentTimeMillis);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.a.u
            public void u(String str2) {
                u(false, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.a.u
            public void u(boolean z2) {
                this.iz = z2;
                u(z2, "stop");
                if (!this.iz && !z) {
                    nr(str);
                }
                com.bytedance.sdk.openadsdk.core.nr.u().put("dpl_reject_by_dialog", false);
            }

            private void u(final boolean z2, final String str2) {
                com.bytedance.sdk.component.jk.x.u(new com.bytedance.sdk.component.jk.a("EventData") { // from class: com.bytedance.sdk.openadsdk.core.s.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (z) {
                            b.fx(bcVar, str, z2 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z2 ? "dpl_success" : "dpl_failed";
                        HashMap map = new HashMap();
                        boolean zU = com.bytedance.sdk.openadsdk.core.n.o().u();
                        map.put("has_focus", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.n.o().u(true)));
                        map.put("is_background", Boolean.valueOf(zU));
                        map.put("life", str2);
                        map.put("total_duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        b.n(bcVar, str, str3, map);
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        bc bcVar2 = bcVar;
                        if (bcVar2 != null) {
                            n.nr(bcVar2, str);
                        }
                    }
                }, 5);
            }
        });
    }
}
