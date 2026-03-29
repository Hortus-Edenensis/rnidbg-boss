package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.wifi.ad.core.p001const.WifiNestConst;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean c;
    private boolean dw;
    public ImageView nr;
    private boolean q;
    protected int u;

    public ExpressVideoView(Context context, bc bcVar, String str, boolean z) {
        super(context, bcVar, false, false, str, false, false);
        this.dw = false;
        if (WifiNestConst.NestTypeConst.NEST_DRAW_AD.equals(str)) {
            this.dw = true;
        }
        this.c = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    private void c() {
        l();
        RelativeLayout relativeLayout = this.jk;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.b)).to(this.t);
            u(this.t, zx.nr(this.b));
        }
        n();
    }

    private void n() {
        y.u((View) this.jk, 0);
        y.u((View) this.t, 0);
        y.u((View) this.mv, 8);
    }

    public boolean A_() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        return (fxVar == null || fxVar.o() == null || !this.pn.o().mv()) ? false : true;
    }

    public void fx() {
        ImageView imageView = this.mv;
        if (imageView != null) {
            y.u((View) imageView, 8);
        }
    }

    public com.bykv.vk.openvk.component.video.api.b.fx getVideoController() {
        return this.pn;
    }

    public void iz() {
        ImageView imageView = this.l;
        if (imageView != null) {
            y.u((View) imageView, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void nr() {
        if (this.dw) {
            super.nr(this.u);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.l;
        if (imageView != null && imageView.getVisibility() == 0) {
            y.pn(this.jk);
        }
        nr(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.dw = z;
    }

    public void setPauseIcon(boolean z) {
        if (this.nr == null) {
            this.nr = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.n.o().oa() != null) {
                this.nr.setImageBitmap(com.bytedance.sdk.openadsdk.core.n.o().oa());
            } else {
                com.bytedance.sdk.component.utils.q.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), "tt_new_play_video", this.nr);
            }
            this.nr.setScaleType(ImageView.ScaleType.FIT_XY);
            int iFx = y.fx(getContext(), this.my);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iFx, iFx);
            layoutParams.gravity = 17;
            this.iz.addView(this.nr, layoutParams);
        }
        if (z) {
            this.nr.setVisibility(0);
        } else {
            this.nr.setVisibility(8);
        }
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.pn(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        com.bykv.vk.openvk.component.video.api.b.nr nrVarSx;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null || (nrVarSx = fxVar.sx()) == null) {
            return;
        }
        nrVarSx.u(z);
    }

    public void setVideoPlayStatus(int i) {
        this.u = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.b.fx u(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2, boolean z3) {
        return this.c ? new com.bytedance.sdk.openadsdk.core.video.nativevideo.fx(context, viewGroup, bcVar, str, z, z2, z3) : super.u(context, viewGroup, bcVar, str, z, z2, z3);
    }

    public void y_() {
        ImageView imageView = this.mv;
        if (imageView != null) {
            y.u((View) imageView, 0);
        }
    }

    public void z_() {
        l();
        y.u((View) this.jk, 0);
    }

    public void nr(boolean z) {
        this.q = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void u(boolean z) {
        if (this.q) {
            super.u(z);
        }
    }
}
