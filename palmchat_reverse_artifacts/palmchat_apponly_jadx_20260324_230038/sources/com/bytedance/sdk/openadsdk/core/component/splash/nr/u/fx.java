package com.bytedance.sdk.openadsdk.core.component.splash.nr.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.pn;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.qq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private x u = new x();
    private int fx = 3;
    private final qq nr = dw.u();

    public void u(final pn pnVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr<iz, x> nrVar) {
        if (this.nr == null || pnVar == null) {
            return;
        }
        this.u.nr(false);
        this.nr.u(pnVar.b(), pnVar.pn(), this.fx, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.fx.1
            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                fx.this.u.nr(i);
                fx.this.u.fx(nrVar2 != null ? nrVar2.fx() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                fx.this.u.u(str);
                nrVar.u(fx.this.u);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                if (uVar == null || uVar.nr() == null) {
                    fx.this.u.nr(1);
                    fx.this.u.u("no ad or material");
                    nrVar.u(fx.this.u);
                    return;
                }
                iz izVar = new iz(uVar, false);
                izVar.nr(nrVar2.a());
                izVar.fx(nrVar2.jk());
                izVar.b(nrVar2.t());
                izVar.pn(nrVar2.l());
                izVar.u(pnVar.u());
                izVar.u(pnVar.fx());
                nrVar.nr(izVar);
            }
        });
    }
}
