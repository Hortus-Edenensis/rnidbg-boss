package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BannerExpressVideoView extends u {
    public BannerExpressVideoView(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(context, bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ void fx() {
        super.fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.nr.u getVideoModel() {
        NativeExpressView nativeExpressView = this.nr;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ boolean nr() {
        return super.nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ void pn() {
        super.pn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar) {
        super.setExpressInteractionListener(uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar) {
        super.setVideoAdListener(fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public void u() {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.u, this.b, this.pn, this.jk);
        this.nr = nativeExpressVideoView;
        addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.u
    public void u(bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.u, bcVar, nrVar, this.jk);
        this.fx = nativeExpressVideoView;
        nativeExpressVideoView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, int i) {
                BannerExpressVideoView bannerExpressVideoView = BannerExpressVideoView.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = bannerExpressVideoView.iz;
                if (uVar != null) {
                    uVar.u(bannerExpressVideoView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, float f, float f2) {
                BannerExpressVideoView.this.u(f, f2);
                BannerExpressVideoView.this.iz();
            }
        });
        y.u((View) this.fx, 8);
        addView(this.fx, new ViewGroup.LayoutParams(-1, -1));
    }
}
