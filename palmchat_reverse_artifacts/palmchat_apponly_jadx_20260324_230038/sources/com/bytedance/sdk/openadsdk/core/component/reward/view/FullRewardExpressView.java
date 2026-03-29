package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.nr.b;
import com.bytedance.sdk.component.adexpress.nr.fx;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.video.u.u;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FullRewardExpressView extends NativeExpressView {
    private b b;
    private FullSwiperItemView.u d;
    com.bytedance.sdk.openadsdk.core.video.nr.u fx;
    private u.InterfaceC0303u gi;
    private com.bytedance.sdk.openadsdk.core.ugeno.t.u h;
    private u kj;
    FullRewardExpressBackupView nr;
    private s pn;
    private ImageView q;
    private HashSet<String> qq;
    t u;
    private View z;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(int i);
    }

    public FullRewardExpressView(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, boolean z, String str2) {
        super(context, bcVar, nrVar, str, z, str2);
        this.qq = new HashSet<>();
    }

    private void k() {
        setBackupListener(new fx() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.component.adexpress.nr.fx
            public boolean u(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).bg();
                    FullRewardExpressView.this.nr = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                    fullRewardExpressView.nr.u(((NativeExpressView) fullRewardExpressView).f5338a, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    private void q() {
        com.bytedance.sdk.openadsdk.core.video.nr.u uVar;
        if ((this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) && (uVar = this.fx) != null) {
            if (uVar.wi()) {
                this.fx.iz();
                nr(true);
            } else {
                this.fx.n();
                nr(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void a() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.a();
        }
    }

    public s getRenderResult() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.b.fx getVideoController() {
        return this.fx;
    }

    public FrameLayout getVideoFrameLayout() {
        return dw() ? this.nr.getVideoContainer() : this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void jk() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.jk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void l() {
        this.my = true;
        this.s = new FrameLayout(this.iz);
        super.l();
        k();
        if (getJsObject() != null) {
            getJsObject().l(this.bq);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void mv() {
        super.mv();
        this.qq.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void n() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fx(z);
    }

    public boolean s() {
        s sVar = this.pn;
        if (sVar == null) {
            return true;
        }
        return sVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx ? ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar).my() != null : (sVar.n() == 0.0d || this.pn.a() == 0.0d) ? false : true;
    }

    public void setEasyPlayableContainer(View view) {
        this.z = view;
    }

    public void setExpressVideoListenerProxy(t tVar) {
        this.u = tVar;
    }

    public void setInteractListener(FullSwiperItemView.u uVar) {
        this.d = uVar;
    }

    public void setOnVideoSizeChangeListener(u uVar) {
        this.kj = uVar;
    }

    public void setVideoController(com.bykv.vk.openvk.component.video.api.b.fx fxVar) {
        if (fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nr.u) {
            com.bytedance.sdk.openadsdk.core.video.nr.u uVar = (com.bytedance.sdk.openadsdk.core.video.nr.u) fxVar;
            this.fx = uVar;
            uVar.fx(50);
            this.fx.u(this.gi);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void t() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.t();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void x() {
        super.x();
        t tVar = this.u;
        if (tVar != null) {
            tVar.x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b(int i) {
        t tVar = this.u;
        if (tVar != null) {
            tVar.b(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int fx() {
        t tVar = this.u;
        if (tVar != null) {
            return tVar.fx();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void iz() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.iz();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nr(b<? extends View> bVar, s sVar) {
        boolean z;
        FrameLayout frameLayoutO;
        View view;
        this.b = bVar;
        if (bVar instanceof k) {
            k kVar = (k) bVar;
            if (kVar.F_() != null) {
                kVar.F_().u((t) this);
            }
            if (kVar.F_() != null) {
                kVar.F_().fx(this.jk);
            }
        }
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.u) bVar).u(this);
        }
        if (sVar != null && sVar.fx()) {
            this.pn = sVar;
            if (sVar.nr() == 2) {
                View viewU = sVar.u();
                if (viewU instanceof ViewGroup) {
                    ((ViewGroup) viewU).addView(getVideoContainer());
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    u((ViewGroup) this.s, true);
                }
                if (sVar.nr() == 10 && (sVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx)) {
                    this.h = ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar).sx();
                }
                if (sVar.nr() == 10 && (sVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx) && (frameLayoutO = ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar).o()) != null && (view = this.z) != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.z);
                    }
                    frameLayoutO.addView(this.z);
                }
            }
        }
        super.nr(bVar, sVar);
        iz(getVisibility());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void pn() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.pn();
        }
    }

    public void u(final ViewGroup viewGroup, final boolean z) {
        if (this.pn == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr(viewGroup, z);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.nr(viewGroup, z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b() {
        t tVar = this.u;
        if (tVar != null) {
            tVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void fx(int i) {
        t tVar = this.u;
        if (tVar != null) {
            tVar.fx(i);
        }
    }

    private void fx(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nr.u uVar;
        if ((this.b instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u) && z) {
            ImageView imageView = this.q;
            if (imageView != null && imageView.getVisibility() == 0 && (uVar = this.fx) != null) {
                uVar.iz();
            } else {
                u(this.bq);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(boolean z) {
        super.u(z);
        this.bq = z;
        t tVar = this.u;
        if (tVar != null) {
            tVar.u(z);
        }
        b bVar = this.b;
        if (bVar == null || !(bVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.u)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.u.u) bVar).u(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i) {
        t tVar = this.u;
        if (tVar != null) {
            tVar.u(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public long u() {
        t tVar = this.u;
        if (tVar != null) {
            return tVar.u();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f, float f2, float f3, float f4, int i) {
        t tVar = this.u;
        if (tVar != null) {
            tVar.u(f, f2, f3, f4, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final int i, final String str) {
        this.gi = new u.InterfaceC0303u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3
            @Override // com.bytedance.sdk.openadsdk.core.video.u.u.InterfaceC0303u
            public void u(long j, long j2) {
                int iAbs = (int) Math.abs(((long) i) - j);
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                int i2 = fullRewardExpressView.fx instanceof com.bytedance.sdk.openadsdk.core.component.reward.draw.b ? 200 : 50;
                int i3 = i;
                if (i3 < 0 || iAbs > i2 || i3 > j2 || iAbs >= i2 || fullRewardExpressView.qq.contains(str)) {
                    return;
                }
                if (i > j) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.fx.iz();
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FullRewardExpressView.this.nr(i, str);
                            if (yd.o(((NativeExpressView) FullRewardExpressView.this).f5338a) || wi.u(((NativeExpressView) FullRewardExpressView.this).f5338a)) {
                                FullRewardExpressView.this.u.u(2);
                            }
                            t tVar = FullRewardExpressView.this.u;
                            if (tVar != null) {
                                tVar.setPauseFromExpressView(true);
                            }
                        }
                    }, iAbs);
                } else {
                    FullRewardExpressView.this.fx.iz();
                    FullRewardExpressView.this.nr(i, str);
                    if (yd.o(((NativeExpressView) FullRewardExpressView.this).f5338a) || wi.u(((NativeExpressView) FullRewardExpressView.this).f5338a)) {
                        FullRewardExpressView.this.u.u(2);
                    }
                    t tVar = FullRewardExpressView.this.u;
                    if (tVar != null) {
                        tVar.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.qq.add(str);
            }
        };
        com.bytedance.sdk.openadsdk.core.video.nr.u uVar = this.fx;
        if (uVar != null) {
            uVar.fx(50);
            this.fx.u(this.gi);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f) {
        t tVar = this.u;
        if (tVar != null) {
            tVar.u(f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.nr.n
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
        FullSwiperItemView.u uVar = this.d;
        if (uVar != null) {
            uVar.u();
        }
        if (i != -1 && fxVar != null && i == 3) {
            jk();
            return;
        }
        if (i == 5) {
            u(!this.bq);
        } else if (i == 4) {
            q();
        } else {
            super.u(view, i, fxVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void setPauseFromExpressView(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nr(ViewGroup viewGroup, boolean z) {
        s sVar = this.pn;
        if (sVar == null) {
            return;
        }
        double dIz = sVar.iz();
        double dX = this.pn.x();
        double dN = this.pn.n();
        double dA = this.pn.a();
        int iFx = y.fx(this.iz, (float) dIz);
        int iFx2 = y.fx(this.iz, (float) dX);
        int iFx3 = y.fx(this.iz, (float) dN);
        int iFx4 = y.fx(this.iz, (float) dA);
        float fFx = this.pn.l() > 0.0f ? y.fx(this.iz, this.pn.l()) : 0.0f;
        float fFx2 = this.pn.mv() > 0.0f ? y.fx(this.iz, this.pn.mv()) : 0.0f;
        float fFx3 = this.pn.s() > 0.0f ? y.fx(this.iz, this.pn.s()) : 0.0f;
        float fFx4 = this.pn.k() > 0.0f ? y.fx(this.iz, this.pn.k()) : 0.0f;
        if (fFx2 < fFx) {
            fFx = fFx2;
        }
        if (fFx3 >= fFx) {
            fFx3 = fFx;
        }
        if (fFx4 >= fFx3) {
            fFx4 = fFx3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iFx3, iFx4);
        }
        layoutParams.width = iFx3;
        layoutParams.height = iFx4;
        layoutParams.topMargin = iFx2;
        layoutParams.leftMargin = iFx;
        viewGroup.setLayoutParams(layoutParams);
        y.nr(viewGroup, fFx4);
        if (z) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.b.fx() == 7 || this.b.fx() == 10) {
                s sVar2 = this.pn;
                if (sVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx) {
                    FrameLayout frameLayoutMy = ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar2).my();
                    if (frameLayoutMy != null) {
                        frameLayoutMy.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else {
                    this.dw.addView(viewGroup);
                }
            }
            u uVar = this.kj;
            if (uVar == null || iFx4 == 0) {
                return;
            }
            uVar.u(iFx4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.nr.n
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
        FullSwiperItemView.u uVar = this.d;
        if (uVar != null) {
            uVar.u();
        }
        if (i != -1 && fxVar != null && i == 3) {
            jk();
        } else {
            super.u(view, i, fxVar, i2);
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar = this.h;
        if (uVar != null) {
            uVar.u(i, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int nr() {
        t tVar = this.u;
        if (tVar != null) {
            return tVar.nr();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void nr(int i) {
        t tVar = this.u;
        if (tVar != null) {
            tVar.nr(i);
        }
    }

    public void nr(boolean z) {
        if (this.q == null) {
            this.q = new ImageView(getContext());
            if (n.o().oa() != null) {
                this.q.setImageBitmap(n.o().oa());
            } else {
                q.u(dw.getContext(), "tt_new_play_video", this.q);
            }
            this.q.setScaleType(ImageView.ScaleType.FIT_XY);
            int iFx = y.fx(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iFx, iFx);
            layoutParams.gravity = 17;
            this.s.addView(this.q, layoutParams);
        }
        if (z) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }
}
