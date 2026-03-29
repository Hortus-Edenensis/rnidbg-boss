package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.u.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class NativeExpressVideoView extends NativeExpressView implements fx.b, fx.InterfaceC0154fx {
    int b;
    boolean fx;
    private HashSet<String> gi;
    private long kj;
    boolean nr;
    boolean pn;
    private com.bytedance.sdk.openadsdk.core.multipro.nr.u q;
    private long qq;
    int u;
    private com.bytedance.sdk.component.adexpress.nr.b z;

    public NativeExpressVideoView(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        super(context, bcVar, nrVar, str, true);
        this.u = 1;
        this.nr = false;
        this.fx = true;
        this.pn = true;
        this.bq = this.f5338a.jn() == 1;
        s();
    }

    private void q() {
        ExpressVideoView expressVideoView;
        try {
            this.q = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
            ExpressVideoView expressVideoViewU = u(this.iz, this.f5338a, this.x);
            this.t = expressVideoViewU;
            expressVideoViewU.setNativeExpressVideoView(this);
            this.t.setAdCreativeClickListener(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
                public void u(View view, int i) {
                    u expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.u(view, i);
                }
            });
            boolean z = false;
            this.t.setShouldCheckNetChange(false);
            this.t.setControllerStatusCallBack(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                public void u(boolean z2, long j, long j2, long j3, boolean z3, boolean z4) {
                    NativeExpressVideoView.this.q.u = z2;
                    NativeExpressVideoView.this.q.pn = j;
                    NativeExpressVideoView.this.q.iz = j2;
                    NativeExpressVideoView.this.q.x = j3;
                    NativeExpressVideoView.this.q.b = z3;
                    NativeExpressVideoView.this.q.n = z4;
                }
            });
            this.t.setVideoAdLoadListener(this);
            this.t.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.x)) {
                this.t.setIsAutoPlay(this.nr ? this.n.pn() : this.fx);
            } else if (WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(this.x)) {
                this.t.setIsAutoPlay(true);
            } else {
                this.t.setIsAutoPlay(this.fx);
            }
            if (!WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(this.x)) {
                expressVideoView = this.t;
                if (this.f5338a.jn() == 1) {
                }
                expressVideoView.setIsQuiet(z);
                this.t.fx();
            }
            expressVideoView = this.t;
            z = true;
            expressVideoView.setIsQuiet(z);
            this.t.fx();
        } catch (Exception e) {
            this.t = null;
            com.bytedance.sdk.component.utils.k.nr("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    private void qq() {
        ExpressVideoView expressVideoView;
        com.bytedance.sdk.component.adexpress.nr.b bVar = this.z;
        if (((bVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) || (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b)) && (expressVideoView = this.t) != null) {
            expressVideoView.nr(true);
            if (this.t.A_()) {
                this.t.setPauseIcon(true);
                this.t.setVideoPlayStatus(2);
            } else {
                this.t.setVideoPlayStatus(3);
                this.t.setPauseIcon(false);
            }
            this.t.performClick();
            this.t.iz();
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void D_() {
        this.pn = false;
        com.bytedance.sdk.component.adexpress.nr.b bVar = this.z;
        if (bVar != null) {
            if (bVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) {
                ((com.bytedance.sdk.component.adexpress.dynamic.u.u) bVar).b();
            }
            com.bytedance.sdk.component.adexpress.nr.b bVar2 = this.z;
            if (bVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.b) bVar2).l();
            }
        }
        fx.InterfaceC0154fx interfaceC0154fx = this.mv;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.D_();
        }
        this.u = 5;
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = this.q;
        if (uVar != null) {
            uVar.u = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
    public void E_() {
        fx.b bVar = this.l;
        if (bVar != null) {
            bVar.E_();
        }
        com.bytedance.sdk.component.adexpress.nr.b bVar2 = this.z;
        if (bVar2 != null) {
            if (bVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) {
                ((com.bytedance.sdk.component.adexpress.dynamic.u.u) bVar2).pn();
            }
            com.bytedance.sdk.component.adexpress.nr.b bVar3 = this.z;
            if (bVar3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.b) bVar3).mv();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.b.fx getVideoController() {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            return expressVideoView.getVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.nr.u getVideoModel() {
        return this.q;
    }

    public void k() {
        this.t.t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void mv() {
        super.mv();
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.bq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void n() {
        super.n();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void o_() {
        this.pn = false;
        fx.InterfaceC0154fx interfaceC0154fx = this.mv;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.o_();
        }
        this.u = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ExpressVideoView expressVideoView;
        int i;
        super.onAttachedToWindow();
        com.bytedance.sdk.component.adexpress.nr.b bVar = this.z;
        if ((!(bVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) && !(bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b)) || (expressVideoView = this.t) == null || (i = this.u) == 2 || i == 5) {
            return;
        }
        expressVideoView.setNeedNativeVideoPlayBtnVisible(true);
        this.t.z_();
        this.t.y_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ExpressVideoView expressVideoView;
        ImageView imageView;
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.component.adexpress.nr.b bVar = this.z;
        if (((bVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) || (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b)) && (expressVideoView = this.t) != null && z && (imageView = expressVideoView.nr) != null && imageView.getVisibility() == 0) {
            this.t.nr.setVisibility(8);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void p_() {
        this.pn = false;
        fx.InterfaceC0154fx interfaceC0154fx = this.mv;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.p_();
        }
        this.k = true;
        this.u = 3;
    }

    public void pn(int i) {
        int iIz = com.bytedance.sdk.openadsdk.core.dw.nr().iz(i);
        if (3 == iIz) {
            this.nr = false;
            this.fx = false;
        } else if (1 == iIz) {
            this.nr = false;
            this.fx = com.bytedance.sdk.component.utils.o.b(this.iz);
        } else if (2 == iIz) {
            if (com.bytedance.sdk.component.utils.o.pn(this.iz) || com.bytedance.sdk.component.utils.o.b(this.iz) || com.bytedance.sdk.component.utils.o.iz(this.iz)) {
                this.nr = false;
                this.fx = true;
            }
        } else if (5 == iIz) {
            if (com.bytedance.sdk.component.utils.o.b(this.iz) || com.bytedance.sdk.component.utils.o.iz(this.iz)) {
                this.nr = false;
                this.fx = true;
            }
        } else if (4 == iIz) {
            this.nr = true;
        }
        if (this.fx) {
            return;
        }
        this.u = 3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void q_() {
        this.pn = false;
        fx.InterfaceC0154fx interfaceC0154fx = this.mv;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.q_();
        }
        this.k = false;
        this.u = 2;
    }

    public void s() {
        this.s = new FrameLayout(this.iz);
        this.b = jp.t(this.f5338a);
        this.gi = new HashSet<>();
        pn(this.b);
        q();
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void x() {
        super.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void nr(com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar, com.bytedance.sdk.component.adexpress.nr.s sVar) {
        ExpressVideoView expressVideoView;
        this.z = bVar;
        if ((bVar instanceof k) && ((k) bVar).F_() != null) {
            ((k) this.z).F_().u((t) this);
        }
        if (sVar != null && sVar.fx()) {
            if ((sVar.nr() == 2 || sVar.nr() == 7) && (expressVideoView = this.t) != null) {
                expressVideoView.u(this.iz, 25, zx.nr(this.f5338a));
            }
            u(sVar);
        }
        com.bytedance.sdk.component.adexpress.nr.b bVar2 = this.z;
        if (bVar2 != null && (bVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u)) {
            ((com.bytedance.sdk.component.adexpress.dynamic.u.u) bVar2).u(this.f5338a.jn() == 1);
        }
        super.nr(bVar, sVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f, float f2, float f3, float f4, int i) {
    }

    public ExpressVideoView u(Context context, bc bcVar, String str) {
        return new ExpressVideoView(context, bcVar, str, false);
    }

    private void u(final com.bytedance.sdk.component.adexpress.nr.s sVar) {
        if (sVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr(sVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.nr(sVar);
                }
            });
        }
    }

    public NativeExpressVideoView(boolean z, Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        super(z, context, bcVar, nrVar, str, true);
        this.u = 1;
        this.nr = false;
        this.fx = true;
        this.pn = true;
        this.bq = this.f5338a.jn() == 1;
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(boolean z) {
        super.u(z);
        this.bq = z;
        this.t.nr(z, true);
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.t.getNativeVideoController().nr(z);
        }
        com.bytedance.sdk.component.adexpress.nr.b bVar = this.z;
        if (bVar == null || !(bVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.u.u) bVar).u(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.component.adexpress.nr.s sVar) {
        if (sVar == null) {
            return;
        }
        double dIz = sVar.iz();
        double dX = sVar.x();
        double dN = sVar.n();
        double dA = sVar.a();
        int iFx = y.fx(this.iz, (float) dIz);
        int iFx2 = y.fx(this.iz, (float) dX);
        int iFx3 = y.fx(this.iz, (float) dN);
        int iFx4 = y.fx(this.iz, (float) dA);
        float fFx = sVar.l() > 0.0f ? y.fx(this.iz, sVar.l()) : 0.0f;
        float fFx2 = sVar.mv() > 0.0f ? y.fx(this.iz, sVar.mv()) : 0.0f;
        float fFx3 = sVar.s() > 0.0f ? y.fx(this.iz, sVar.s()) : 0.0f;
        float fFx4 = sVar.k() > 0.0f ? y.fx(this.iz, sVar.k()) : 0.0f;
        if (fFx2 < fFx) {
            fFx = fFx2;
        }
        if (fFx3 >= fFx) {
            fFx3 = fFx;
        }
        if (fFx4 >= fFx3) {
            fFx4 = fFx3;
        }
        if (sVar.nr() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iFx3, iFx4);
            }
            layoutParams.width = iFx3;
            layoutParams.height = iFx4;
            layoutParams.topMargin = iFx2;
            layoutParams.leftMargin = iFx;
            this.s.setLayoutParams(layoutParams);
        }
        y.nr(this.s, fFx4);
        this.s.removeAllViews();
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            this.s.addView(expressVideoView);
            this.t.u(0L, true, false);
            pn(this.b);
            if (!com.bytedance.sdk.component.utils.o.b(this.iz) && !this.fx && this.pn) {
                this.t.z_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.s.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.s);
        }
        if (sVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx) {
            FrameLayout frameLayoutMy = ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar).my();
            if (frameLayoutMy != null) {
                ExpressVideoView expressVideoView2 = this.t;
                if (expressVideoView2 != null) {
                    expressVideoView2.setClickable(false);
                }
                frameLayoutMy.addView(this.s, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (sVar.nr() == 2) {
            View viewU = sVar.u();
            if (viewU instanceof ViewGroup) {
                ExpressVideoView expressVideoView3 = this.t;
                if (expressVideoView3 != null) {
                    expressVideoView3.setClickable(false);
                }
                ((ViewGroup) viewU).addView(this.s);
                return;
            }
            return;
        }
        this.dw.addView(this.s);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView == null) {
            com.bytedance.sdk.component.utils.k.nr("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            expressVideoView.u(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            expressVideoView.setVideoPlayStatus(i);
            this.t.setCanInterruptVideoPlay(true);
            this.t.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().jk();
        } else {
            if (i != 5) {
                return;
            }
            expressVideoView.u(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void iz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void jk() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void t() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.nr.n
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
        if (i == -1 || fxVar == null) {
            return;
        }
        if (i == 4) {
            qq();
        } else if (i != 5) {
            super.u(view, i, fxVar);
        } else {
            u(!this.bq);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void fx(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.nr.n
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
        if (i == -1 || fxVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.u(view, i, fxVar, i2);
                return;
            }
        } else if (this.x == WifiNestConst.NestTypeConst.NEST_DRAW_AD) {
            ExpressVideoView expressVideoView = this.t;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        u(!this.bq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public long u() {
        return this.qq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void u(long j, long j2) {
        this.pn = false;
        fx.InterfaceC0154fx interfaceC0154fx = this.mv;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.u(j, j2);
        }
        if (u(j)) {
            this.u = 2;
        }
        this.qq = j;
        this.kj = j2;
        if (!this.gi.isEmpty()) {
            com.bykv.vk.openvk.component.video.api.b.fx videoController = this.t.getVideoController();
            if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.b) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) videoController).fx(50);
            }
        }
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = this.q;
        if (uVar != null) {
            uVar.x = j;
        }
        com.bytedance.sdk.component.adexpress.nr.b bVar = this.z;
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.b) bVar).u(j, j2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
    public void u(int i, int i2) {
        fx.b bVar = this.l;
        if (bVar != null) {
            bVar.u(i, i2);
        }
        this.qq = this.kj;
        this.u = 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final int i, final String str) {
        super.u(i, str);
        com.bykv.vk.openvk.component.video.api.b.fx videoController = this.t.getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.b) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.b) videoController;
            bVar.fx(50);
            bVar.u(new u.InterfaceC0303u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4
                @Override // com.bytedance.sdk.openadsdk.core.video.u.u.InterfaceC0303u
                public void u(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 < 0 || iAbs > 50 || i2 > j2 || iAbs >= 50 || NativeExpressVideoView.this.gi.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.t.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.t.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.t.performClick();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                NativeExpressVideoView.this.nr(i, str);
                            }
                        }, iAbs);
                    } else {
                        NativeExpressVideoView.this.t.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.t.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.t.performClick();
                        NativeExpressVideoView.this.nr(i, str);
                    }
                    NativeExpressVideoView.this.gi.add(str);
                }
            });
        }
    }

    private boolean u(long j) {
        int i = this.u;
        if (i != 5 && i != 3 && j > this.qq) {
            return true;
        }
        ExpressVideoView expressVideoView = this.t;
        return expressVideoView != null && expressVideoView.A_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int nr() {
        ExpressVideoView expressVideoView;
        if (this.u == 3 && (expressVideoView = this.t) != null) {
            expressVideoView.fx();
        }
        ExpressVideoView expressVideoView2 = this.t;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().c()) {
            return this.u;
        }
        return 1;
    }
}
