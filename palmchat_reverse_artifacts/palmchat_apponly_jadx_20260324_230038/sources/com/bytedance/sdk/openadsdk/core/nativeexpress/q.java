package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.wifi.ad.core.p001const.WifiNestConst;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q extends qq {
    public q(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(context, bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qq, com.bytedance.sdk.openadsdk.core.nativeexpress.c
    public void u(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.b = WifiNestConst.NestTypeConst.NEST_DRAW_AD;
        NativeExpressDrawVideoView nativeExpressDrawVideoView = new NativeExpressDrawVideoView(context, bcVar, nrVar, WifiNestConst.NestTypeConst.NEST_DRAW_AD);
        ((c) this).u = nativeExpressDrawVideoView;
        u(nativeExpressDrawVideoView, this.fx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(boolean z) {
        NativeExpressView nativeExpressView = ((c) this).u;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
        }
    }
}
