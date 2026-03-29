package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.component.splash.n;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.wifi.ad.core.p001const.WifiNestConst;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
abstract class fx {
    protected n.u b;
    protected bc fx;
    protected ViewGroup nr;
    protected Context u;

    public void nr() {
        n.u uVar = this.b;
        if (uVar != null) {
            uVar.nr();
        }
    }

    public abstract String u();

    public abstract void u(com.bytedance.sdk.openadsdk.core.nr.u uVar);

    public void u(boolean z) {
    }

    public void u(Context context, ViewGroup viewGroup, bc bcVar) {
        this.u = context;
        this.nr = viewGroup;
        this.fx = bcVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, n.u uVar) {
        com.bytedance.sdk.openadsdk.core.s.b.fx(this.fx, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, u());
        this.nr.setVisibility(0);
        this.b = uVar;
    }
}
