package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.kj.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends b {
    public fx(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, bcVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.b
    public com.bykv.vk.openvk.component.video.api.renderview.nr q() {
        iz izVar = this.pn;
        if (izVar != null) {
            return izVar.o();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.b
    public void u(int i, int i2) {
        super.u(i, i2);
        iz izVar = this.pn;
        if (izVar == null || i <= 0 || i2 <= 0) {
            return;
        }
        izVar.fx(i, i2);
        this.pn.u(i, i2);
        nr(-1, -1);
    }
}
