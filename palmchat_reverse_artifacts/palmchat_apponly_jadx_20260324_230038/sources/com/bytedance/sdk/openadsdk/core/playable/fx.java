package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.gi.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class fx extends com.bytedance.sdk.openadsdk.core.video.nr.u {
    private boolean xg;

    public fx(Context context, ViewGroup viewGroup, bc bcVar, com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        super(context, viewGroup, bcVar, uVar);
        this.xg = true;
        u(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nr.u
    public void iz(boolean z) {
        super.iz(z);
        if (this.xg) {
            if (!t.u(this.iz) || pn()) {
                nr();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nr.u
    public int q() {
        return 5;
    }

    public void qq() {
        oa();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nr.u
    public boolean v_() {
        return false;
    }

    public void x(boolean z) {
        this.xg = z;
    }
}
