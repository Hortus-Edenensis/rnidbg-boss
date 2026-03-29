package com.bytedance.sdk.openadsdk.core.u;

import com.bytedance.sdk.openadsdk.core.qq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements qq.nr {
    private int nr;
    private qq.nr u;

    public u(qq.nr nrVar) {
        this.u = nrVar;
    }

    public void u(int i) {
        this.nr = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq.nr
    public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
        qq.nr nrVar2 = this.u;
        if (nrVar2 != null) {
            nrVar2.u(i, str, nrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq.nr
    public void u(final com.bytedance.sdk.openadsdk.core.kj.u uVar, final com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
        int i = this.nr;
        boolean z = true;
        boolean z2 = i == 3 || i == 4;
        if (z2) {
            z = (com.bytedance.sdk.openadsdk.core.fx.pn.u().l() & 1) != 1;
        }
        if (z) {
            if (this.u != null) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.u.u(uVar, nrVar);
                    }
                };
                if (z2) {
                    com.bytedance.sdk.openadsdk.gi.x.u(runnable);
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.gi.x.nr(runnable);
                    return;
                }
            }
            return;
        }
        qq.nr nrVar2 = this.u;
        if (nrVar2 != null) {
            nrVar2.u(uVar, nrVar);
        }
    }
}
