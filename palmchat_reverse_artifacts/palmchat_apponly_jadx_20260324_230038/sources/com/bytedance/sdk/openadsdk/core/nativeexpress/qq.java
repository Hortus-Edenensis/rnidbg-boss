package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class qq extends c {
    public qq(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(context, bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr
    public com.bytedance.sdk.openadsdk.core.multipro.nr.u t() {
        WeakReference<mv> weakReference = this.pn;
        if (weakReference != null && weakReference.get() != null) {
            return this.pn.get().getVideoModel();
        }
        NativeExpressView nativeExpressView = ((c) this).u;
        if (!(nativeExpressView instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) nativeExpressView).k();
        return ((NativeExpressVideoView) ((c) this).u).getVideoModel();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
    public void u(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, bcVar, nrVar, "embeded_ad");
        ((c) this).u = nativeExpressVideoView;
        u(nativeExpressVideoView, this.fx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(final com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar) {
        NativeExpressView nativeExpressView = ((c) this).u;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(new fx.b() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.qq.1
                @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
                public void E_() {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.u();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
                public void u(int i, int i2) {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.u(i, i2);
                    }
                }
            });
            ((c) this).u.setVideoAdInteractionListener(new fx.InterfaceC0154fx() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.qq.2
                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void D_() {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.pn();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void o_() {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.nr();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void p_() {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.fx();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void q_() {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.b();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void u(long j, long j2) {
                    com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar2 = fxVar;
                    if (fxVar2 != null) {
                        fxVar2.u(j, j2);
                    }
                }
            });
        }
    }
}
