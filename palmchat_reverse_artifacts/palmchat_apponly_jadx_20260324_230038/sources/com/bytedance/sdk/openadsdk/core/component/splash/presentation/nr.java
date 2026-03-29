package com.bytedance.sdk.openadsdk.core.component.splash.presentation;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.component.splash.presentation.SlideInterceptView;
import com.bytedance.sdk.openadsdk.core.component.splash.presentation.u;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.kw;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.iz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.pn;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u implements fx.b, fx.InterfaceC0154fx, u.nr, u.InterfaceC0273u {
    private NativeExpressView bc;
    private int cj;
    private SlideInterceptView mh;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr oa;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx su;
    private String w;
    private WeakReference<ViewGroup> wi;
    private Context xw;
    private final AtomicBoolean tk = new AtomicBoolean(false);
    private final SlideInterceptView.u yd = new SlideInterceptView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.1
        @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.SlideInterceptView.u
        public void u(View view, jk jkVar) {
            com.bytedance.sdk.openadsdk.core.nr.u uVar = nr.this.pn;
            if (uVar != null) {
                uVar.u(view, jkVar);
            }
            nr.this.c();
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int b;
        final /* synthetic */ String fx;
        final /* synthetic */ b iz;
        final /* synthetic */ com.bytedance.sdk.openadsdk.my.fx.fx.nr nr;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx pn;
        final /* synthetic */ Context u;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.u.u x;

        public AnonymousClass2(Context context, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx fxVar, b bVar, com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar) {
            this.u = context;
            this.nr = nrVar;
            this.fx = str;
            this.b = i;
            this.pn = fxVar;
            this.iz = bVar;
            this.x = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                nr.this.xw = this.u;
                nr.this.oa = this.nr;
                nr.this.w = this.fx;
                nr.this.cj = this.b;
                nr nrVar = nr.this;
                nrVar.u((u.nr) nrVar);
                nr.this.u(this.pn, this.iz, this.x);
                nr nrVar2 = nr.this;
                nrVar2.su = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx(nrVar2.nr, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.2.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public int fx() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public int nr() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public long u() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void fx(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void nr(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void u(float f) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
                    public void nr(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                        if (nr.this.bc != null) {
                            nr.this.bc.u(view, i, fxVar);
                        }
                        nr.this.c();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void u(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void u(int i, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
                    public void u(View view) {
                        nr.this.kj();
                        nr nrVar3 = nr.this;
                        com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar = nrVar3.n;
                        if (uVar != null) {
                            uVar.nr(nrVar3);
                        }
                        a.u(nr.this.nr, true, 2, 3, (JSONObject) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
                    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                        if (nr.this.bc != null) {
                            nr.this.bc.u(view, i, fxVar);
                        }
                        a.u(nr.this.nr, false, 1, fxVar instanceof q ? ((q) fxVar).u().optBoolean("isLottieInternalClick", false) : false ? 2 : 1, (JSONObject) null);
                        nr.this.c();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
                    public void u(ViewGroup viewGroup) {
                        if (z.iz(nr.this.nr).iz()) {
                            TextView textView = new TextView(nr.this.xw);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            textView.setTextSize(1, 20.0f);
                            int iFx = y.fx(dw.getContext(), 80.0f);
                            textView.setText("跳转至详情页或第三方应用");
                            layoutParams.bottomMargin = iFx;
                            int i = iFx / 3;
                            layoutParams.leftMargin = i;
                            layoutParams.rightMargin = i;
                            layoutParams.gravity = 81;
                            textView.setTextColor(-1);
                            int i2 = iFx / 6;
                            textView.setPadding(0, i2, 0, i2);
                            textView.setGravity(17);
                            textView.setLayoutParams(layoutParams);
                            textView.setClickable(true);
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.2.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (nr.this.bc != null) {
                                        nr.this.bc.u(view, 2, new q.u().u());
                                    }
                                }
                            });
                            textView.bringToFront();
                            viewGroup.addView(textView);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void b() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void iz() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void pn() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
                    public void setPauseFromExpressView(boolean z) {
                    }
                });
            } catch (Throwable th) {
                k.nr("splrender", th.getMessage());
            }
        }
    }

    public nr(Context context, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx fxVar, b<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a, x> bVar, com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar) {
        if (fxVar != null) {
            this.nr = fxVar.nr();
            u(fxVar.nr(), fxVar.x());
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new AnonymousClass2(context, nrVar, str, i, fxVar, bVar, uVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf() {
        NativeExpressView nativeExpressView = this.bc;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.nr(this.l, 0);
        this.bc.setDynamicSkipListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.fx() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.7
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.fx
            public void u() {
                nr.this.jk();
            }
        });
        ((u) this).u.nr();
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr();
        this.f5271jp = nrVar;
        nrVar.u(this.l);
        this.f5271jp.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.8
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr.u
            public void u() {
                nr.this.mv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr.u
            public void u(int i) {
                if (nr.this.bc != null) {
                    nr.this.bc.nr(nr.this.l, i);
                }
            }
        });
        if (this.xg.get()) {
            this.f5271jp.nr();
        }
    }

    private void d() {
        if (this.nr.sv() == 2) {
            this.bc = new NativeExpressView(true, this.xw, this.nr, this.oa, this.w, true);
        } else {
            this.bc = new NativeExpressView(false, this.xw, this.nr, this.oa, this.w, true);
        }
    }

    private void h() {
        if (this.nr.sv() == 2) {
            this.bc = new NativeExpressVideoView(true, this.xw, this.nr, this.oa, this.w);
        } else {
            this.bc = new NativeExpressVideoView(false, this.xw, this.nr, this.oa, this.w);
        }
        if (this.bc.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.b) {
            this.ja = (com.bytedance.sdk.openadsdk.core.video.nativevideo.b) this.bc.getVideoController();
        }
        this.bc.setVideoAdListener(this);
        this.bc.setVideoAdInteractionListener(this);
    }

    private void ja() {
        if (this.pb > 0) {
            return;
        }
        if (this.wq == 1) {
            this.pb = 1;
        } else {
            this.pb = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        final mk mkVarPq = this.nr.pq();
        if (mkVarPq == null || ((u) this).u == null) {
            return;
        }
        if ((this.m.get() != 1 || mkVarPq.o() == 1) && mkVarPq.my() > 0.0f) {
            ((u) this).u.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.5
                @Override // java.lang.Runnable
                public void run() {
                    View rootView = ((u) nr.this).u.getRootView();
                    if (rootView instanceof FrameLayout) {
                        ViewGroup viewGroup = (ViewGroup) rootView;
                        int height = ((u) nr.this).u.getHeight();
                        int iA = y.a(nr.this.xw);
                        if (mkVarPq.my() >= 1.0f) {
                            float f = iA;
                            if (height <= mkVarPq.my() * f && !nr.this.t) {
                                int iKj = mkVarPq.bq() == 1 ? iA - height : mkVarPq.kj() > 0.0f ? (int) (f * mkVarPq.kj()) : 0;
                                nr.this.mh = new SlideInterceptView(nr.this.xw, mkVarPq, nr.this.yd);
                                if (iKj <= 0) {
                                    iKj = -1;
                                }
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iKj);
                                layoutParams.gravity = 80;
                                viewGroup.addView(nr.this.mh, layoutParams);
                            }
                        }
                    }
                }
            }, mkVarPq.dw());
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void D_() {
        nr(1);
        this.q = false;
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.my, this.nr);
        com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar = this.n;
        if (uVar != null) {
            this.t = true;
            uVar.u(this, 4);
            fx(false);
        }
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.u
    public void c() {
        try {
            SlideInterceptView slideInterceptView = this.mh;
            if (slideInterceptView == null) {
                return;
            }
            slideInterceptView.u();
            if (((ViewGroup) this.mh.getParent()) == null) {
                return;
            }
            this.mh.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) nr.this.mh.getParent();
                        if (viewGroup == null) {
                            return;
                        }
                        viewGroup.removeView(nr.this.mh);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        nr(3);
    }

    public void gi() {
        NativeExpressView nativeExpressView = this.bc;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.x(this.cj);
        this.bc.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.u, com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public View k() {
        if (this.pb == -1) {
            this.pb = 0;
        }
        return ((u) this).u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
    public boolean m_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
    public com.bytedance.sdk.openadsdk.core.multipro.nr.u r_() {
        NativeExpressView nativeExpressView;
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
        fx videoController = this.ja;
        if (videoController == null && (nativeExpressView = this.bc) != null) {
            videoController = nativeExpressView.getVideoController();
        }
        if (videoController != null) {
            uVar.x = videoController.t();
            uVar.u = videoController.bq();
            uVar.n = videoController.bg();
        }
        return uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void u(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.nr
    public void w_() {
        bc bcVar = this.nr;
        if (bcVar == null || this.bg == null) {
            return;
        }
        if (tk.u(bcVar) == 2) {
            if (this.tk.get()) {
                NativeExpressView nativeExpressView = this.bc;
                if (nativeExpressView != null) {
                    nativeExpressView.my();
                    kj.u(this.bg, this.nr, this.bc);
                }
                this.bg.put("splash_show_type", 3);
            }
        } else if (this.h) {
            if (TextUtils.isEmpty(zx.u(this.nr))) {
                this.bg.put("splash_show_type", 2);
            }
            this.bg.put("splash_show_type", 1);
        } else {
            this.bg.put("splash_show_type", 0);
        }
        u(this.nr);
    }

    public void fx(int i) {
        this.cj = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.u, com.bytedance.sdk.openadsdk.core.component.splash.TsView.u
    public void x() {
        super.x();
        NativeExpressView nativeExpressView = this.bc;
        if (nativeExpressView != null) {
            nativeExpressView.mv();
        }
        this.bc = null;
        this.x = null;
        this.iz = null;
        Map<String, Object> map = this.jk;
        if (map != null) {
            map.clear();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx fxVar = this.su;
        if (fxVar != null) {
            fxVar.nr();
        }
        c();
        fx(false);
        s();
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx fxVar, b<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a, x> bVar) {
        this.mv = 3;
        u(bVar);
        gi();
    }

    private void u(final b<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a, x> bVar) {
        if (bVar == null || this.nr == null) {
            return;
        }
        if (this.h) {
            this.dw = true;
            h();
        } else {
            this.dw = false;
            d();
        }
        this.kj.u(this);
        NativeExpressView nativeExpressView = this.bc;
        if (nativeExpressView == null) {
            this.kj.nr(3);
            this.kj.u("no render express");
            bVar.u(this.kj);
        } else {
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.3
                @Override // com.bytedance.sdk.component.adexpress.nr.fx
                public boolean u(ViewGroup viewGroup, int i) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(nr.this.xw);
                        nr nrVar = nr.this;
                        splashExpressBackupView.u(nrVar.d, nrVar.nr, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.b) {
                            nr.this.ja = (com.bytedance.sdk.openadsdk.core.video.nativevideo.b) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(nr.this);
                        nr.this.l();
                        TsView tsView = ((u) nr.this).u;
                        if (tsView == null) {
                            return true;
                        }
                        tsView.u();
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            this.mv = 3;
            this.bc.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.nr.4
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, int i) {
                    nr.this.kj();
                    nr nrVar = nr.this;
                    com.bytedance.sdk.openadsdk.core.s.b.nr(nrVar.my, nrVar.nr);
                    nr nrVar2 = nr.this;
                    com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar = nrVar2.n;
                    if (uVar != null) {
                        uVar.nr(nrVar2);
                    }
                    nr.this.t();
                    nr.this.c();
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, String str, int i) {
                    k.nr(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:".concat(String.valueOf(str)));
                    nr.this.kj.nr(3);
                    nr.this.kj.u("render splash express fail");
                    bVar.u(nr.this.kj);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, float f, float f2) {
                    if (view != null && f > 0.0f && f2 > 0.0f) {
                        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar = new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a(nr.this.bf.get(), nr.this);
                        boolean zDw = nr.this.bc.dw();
                        if (nr.this.bc != null && !zDw) {
                            ((u) nr.this).u.setComplianceBarVisibility(8);
                        }
                        aVar.u(zDw);
                        nr.this.m.set(zDw ? 1 : 2);
                        nr.this.z.set(true);
                        nr nrVar = nr.this;
                        ((u) nrVar).u.setExpressView(nrVar.bc);
                        nr.this.tk.set(true);
                        if (nr.this.gi.get()) {
                            nr nrVar2 = nr.this;
                            nrVar2.u((WeakReference<ViewGroup>) nrVar2.wi);
                            nr.this.gi.set(false);
                        }
                        if (!nr.this.f5270a.get() && !zDw && kw.u(nr.this.nr)) {
                            nr.this.bf();
                        }
                        bVar.nr(aVar);
                        nr.this.su.u(((u) nr.this).u.getEasyPlayableLayout(), nr.this.bc.getVideoContainer());
                        nr.this.rh();
                        return;
                    }
                    nr.this.kj.nr(3);
                    nr.this.kj.u("render splash view error");
                    bVar.u(nr.this.kj);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
    public void E_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void o_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void q_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.u, com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void u(ViewGroup viewGroup) {
        qq();
        if (viewGroup == null) {
            k.nr(MediationConstant.RIT_TYPE_SPLASH, "展示开屏的容器不能为空");
            return;
        }
        ja();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.wi = weakReference;
        if (this.z.get() && ((u) this).u != null) {
            u(weakReference);
        } else {
            this.gi.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (((u) this).u.getParent() != null) {
            ((ViewGroup) ((u) this).u.getParent()).removeView(((u) this).u);
        }
        viewGroup.addView(((u) this).u);
    }

    private void u(bc bcVar) {
        if (this.bc == null || bcVar == null) {
            return;
        }
        Context context = this.xw;
        String str = this.w;
        iz izVar = new iz(context, bcVar, str, jp.nr(str));
        izVar.u(this.bc);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.jk);
        this.bc.setClickListener(izVar);
        Context context2 = this.xw;
        String str2 = this.w;
        pn pnVar = new pn(context2, bcVar, str2, jp.nr(str2));
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        pnVar.u(this.bc);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.jk);
        this.bc.setClickCreativeListener(pnVar);
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.u(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
    public void u(int i, int i2) {
        this.q = false;
    }
}
