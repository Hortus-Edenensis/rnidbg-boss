package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.wifi.ad.core.p001const.WifiNestConst;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"ViewConstructor"})
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private int nr;
    private boolean u;

    public NativeDrawVideoTsView(Context context, bc bcVar) {
        super(context, bcVar);
        this.u = false;
        setOnClickListener(this);
        this.nr = getResources().getConfiguration().orientation;
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

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        int i = getResources().getConfiguration().orientation;
        if (this.nr == i) {
            super.b();
        } else {
            this.nr = i;
            y.u(this, new y.u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                @Override // com.bytedance.sdk.openadsdk.core.y.y.u
                public void u(View view) {
                    NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                    if (nativeDrawVideoTsView.pn == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.u(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.b();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void nr() {
        if (this.u) {
            super.nr();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.l;
        if (imageView != null && imageView.getVisibility() == 0) {
            y.pn(this.jk);
        }
        nr();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = this.nr;
        int i2 = configuration.orientation;
        if (i == i2) {
            return;
        }
        this.nr = i2;
        y.u(this, new y.u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
            @Override // com.bytedance.sdk.openadsdk.core.y.y.u
            public void u(View view) {
                NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                if (nativeDrawVideoTsView.pn == null) {
                    return;
                }
                NativeDrawVideoTsView.this.u(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
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
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void x() {
        this.k = WifiNestConst.NestTypeConst.NEST_DRAW_AD;
        super.x();
    }

    public void u(Bitmap bitmap, int i) {
        n.o().u(bitmap);
        this.my = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.b.fx u(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2, boolean z3) {
        return new fx(context, viewGroup, bcVar, str, z, z2, z3);
    }

    public NativeDrawVideoTsView(Context context, bc bcVar, String str, boolean z, boolean z2) {
        super(context, bcVar, str, z, z2);
        this.u = false;
        setOnClickListener(this);
        this.nr = getResources().getConfiguration().orientation;
    }
}
