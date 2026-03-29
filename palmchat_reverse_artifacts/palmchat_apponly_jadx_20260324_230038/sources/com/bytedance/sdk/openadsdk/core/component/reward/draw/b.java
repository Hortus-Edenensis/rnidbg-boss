package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.kj.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.core.component.reward.iz.nr {
    private boolean xg;

    public b(Context context, ViewGroup viewGroup, bc bcVar) {
        super(context, viewGroup, bcVar, null);
        u(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nr.u
    public void iz(boolean z) {
        super.iz(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nr.u, com.bykv.vk.openvk.component.video.api.b.fx
    public void jk() {
        this.xg = false;
        super.jk();
    }

    public boolean kj() {
        return this.xg;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.iz.nr, com.bytedance.sdk.openadsdk.core.video.nr.u, com.bykv.vk.openvk.component.video.api.b.fx
    public void n() {
        if (this.xg) {
            return;
        }
        super.n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.iz.nr, com.bytedance.sdk.openadsdk.core.video.nr.u
    public int q() {
        return 4;
    }

    public boolean qq() {
        return o() != null && o().s();
    }

    public void x(boolean z) {
        this.xg = z;
    }
}
