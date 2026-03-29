package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.core.c.b {
    private final WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> u;

    public b(com.bytedance.sdk.openadsdk.core.dw.b bVar) {
        this.u = new WeakReference<>(bVar);
    }

    @Override // com.bytedance.sdk.openadsdk.s.u
    public void u() {
        if (this.u.get() != null) {
            this.u.get().u(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.s.u
    public void u(int i, String str) {
        WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get();
    }
}
