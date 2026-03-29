package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class NativeVideoView extends NativeVideoTsView {
    private boolean c;
    private fx dw;
    private u nr;
    private int u;

    public NativeVideoView(Context context) {
        super(context);
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.u(true);
        }
        this.bq.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void B_() {
        super.B_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bytedance.sdk.openadsdk.core.video.nativevideo.b.u
    public void C_() {
        y.u((View) this.jk, 8);
        super.C_();
    }

    public void O_() {
        u uVar = this.nr;
        if (uVar != null) {
            uVar.n();
            y.u((View) this.jk, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null) {
            B_();
        } else if ((fxVar instanceof b) && !o()) {
            ((b) this.pn).xw();
        }
        if (this.pn == null || !this.bq.get()) {
            return;
        }
        this.bq.set(false);
        x();
        if (!k()) {
            if (this.pn.bq()) {
                y.u((View) this.jk, 0);
                return;
            } else {
                l();
                y.u((View) this.jk, 0);
                return;
            }
        }
        y.u((View) this.jk, 0);
        ImageView imageView = this.l;
        if (imageView != null) {
            y.u((View) imageView, 8);
        }
        if (zx.k(this.b) == null) {
            k.nr("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        iz izVarU = zx.u(4, this.b);
        izVarU.nr(this.b.lk());
        izVarU.nr(this.iz.getWidth());
        izVarU.fx(this.iz.getHeight());
        izVarU.fx(this.b.ap());
        this.b.v(this.u);
        izVarU.pn(this.u);
        izVarU.u(t.u(this.b));
        izVarU.u(this.pn.t());
        izVarU.nr(this.pn.bg());
        ((b) this.pn).b(this.u);
        ((b) this.pn).u(this.b);
        u(izVarU);
        this.pn.fx(false);
    }

    public void n() {
        u uVar = this.nr;
        if (uVar != null) {
            uVar.iz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bykv.vk.openvk.component.video.api.b.fx.u
    public void nr(long j, int i) {
        super.nr(j, i);
        y.u((View) this.jk, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        fx fxVar = this.dw;
        if (fxVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrU = fxVar.u(i, i2);
            super.onMeasure(iArrU[0], iArrU[1]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.c && i == 8) {
            pn();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void pn() {
        super.pn();
        y.u((View) this.jk, 0);
    }

    public void setExtraMap(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.nr(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        y.u((View) this.jk, 0);
    }

    public void setLp(boolean z) {
        this.c = z;
    }

    public void setPlayerType(int i) {
        this.u = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.b.fx u(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2, boolean z3) {
        u uVar = new u(context, viewGroup, bcVar, str, z, z2, z3);
        this.nr = uVar;
        return uVar;
    }

    public void u(boolean z, boolean z2) {
        l();
        y.u((View) this.jk, 0);
        y.u((View) this.mv, z ? 0 : 8);
        y.u((View) this.t, z2 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public boolean u(long j, boolean z, boolean z2) {
        this.iz.setVisibility(0);
        if (this.pn == null) {
            this.pn = new b(getContext(), this.x, this.b, this.k, false, false);
        }
        if (mv() || this.f5388a) {
            u(this.fx, 25, zx.nr(this.b));
        }
        return false;
    }

    public void u(fx fxVar) {
        this.dw = fxVar;
    }
}
