package com.bytedance.sdk.openadsdk.core.l.fx;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.nr.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr implements com.bytedance.sdk.openadsdk.core.l.nr.b {
    private b.u z;

    public u(Context context, bc bcVar, String str, boolean z) {
        super(context, bcVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void nr() {
        super.nr();
        this.z = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.b
    public void u(b.u uVar) {
        this.z = uVar;
    }
}
