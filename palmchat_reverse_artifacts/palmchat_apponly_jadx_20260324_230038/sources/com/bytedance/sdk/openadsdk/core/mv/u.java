package com.bytedance.sdk.openadsdk.core.mv;

import com.bytedance.sdk.component.adexpress.u.fx.b;
import com.bytedance.sdk.component.adexpress.u.nr.x;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.ugeno.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static void u(bc bcVar, final fx fxVar) {
        final b bVarA;
        if (bcVar == null || tk.n(bcVar) || (bVarA = tk.a(bcVar)) == null) {
            return;
        }
        x.u(new a("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.mv.u.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.u.nr.x.u().u(bVarA, new x.u() { // from class: com.bytedance.sdk.openadsdk.core.mv.u.1.1
                    @Override // com.bytedance.sdk.component.adexpress.u.nr.x.u
                    public void nr() {
                        fx fxVar2 = fxVar;
                        if (fxVar2 != null) {
                            fxVar2.u();
                        }
                    }

                    @Override // com.bytedance.sdk.component.adexpress.u.nr.x.u
                    public void u() {
                        fx fxVar2 = fxVar;
                        if (fxVar2 != null) {
                            fxVar2.u(null);
                        }
                    }
                });
            }
        }, 10);
    }
}
