package com.bytedance.sdk.openadsdk.core.component;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.q.b;
import com.bytedance.sdk.openadsdk.core.q.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx {
    protected String nr;
    protected com.bytedance.sdk.openadsdk.core.q.u.u u;

    public void fx() {
        com.bytedance.sdk.openadsdk.core.q.u.u uVar = this.u;
        if (uVar != null) {
            uVar.u(this.nr, com.bytedance.sdk.openadsdk.core.q.b.u.RECEIVE);
        }
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.q.u.u uVar = this.u;
        if (uVar != null) {
            uVar.u(this.nr, com.bytedance.sdk.openadsdk.core.q.b.u.REQ);
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.q.u.u uVar = this.u;
        if (uVar != null) {
            uVar.u(this.nr, com.bytedance.sdk.openadsdk.core.q.b.u.START);
        }
    }

    public void u(final String str, final boolean z, final com.bytedance.sdk.openadsdk.my.fx.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.q.u.u uVar = this.u;
        if (uVar != null) {
            uVar.u(this.nr, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.1
                @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
                public void u(com.bytedance.sdk.openadsdk.core.q.u uVar2) {
                    if (uVar2 instanceof u) {
                        u uVar3 = (u) uVar2;
                        uVar3.nr = z;
                        uVar3.fx = fxVar;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        uVar3.b.add(str);
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                ((com.bytedance.sdk.openadsdk.core.q.u.nr) b.u(1)).u(str, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.2
                    @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
                    public void u(com.bytedance.sdk.openadsdk.core.q.u uVar2) {
                        if (uVar2 instanceof nr) {
                            ((nr) uVar2).u = fx.this.nr;
                        }
                    }
                });
            }
            this.u.u(this.nr, com.bytedance.sdk.openadsdk.core.q.b.u.LOADED);
        }
    }
}
