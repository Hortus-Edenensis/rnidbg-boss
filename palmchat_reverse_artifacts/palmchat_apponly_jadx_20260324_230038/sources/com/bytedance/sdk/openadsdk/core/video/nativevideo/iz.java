package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.b.nr;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.u.pn.nr;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.bq;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.nr.u.u.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.core.widget.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements com.bykv.vk.openvk.component.video.api.b.nr<bc>, com.bykv.vk.openvk.component.video.api.renderview.u, rh.u, k.nr, s.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f5391a;
    private TextView ay;
    View b;
    private NativeVideoTsView.u bc;
    com.bytedance.sdk.openadsdk.core.nr.u bf;
    int bg;
    int bq;
    volatile boolean c;
    private RelativeLayout cj;
    nr d;
    boolean dw;
    private int eh;
    private final int f;
    ImageView fx;
    private u.InterfaceC0273u gc;
    k gi;
    boolean h;
    ImageView iz;
    com.bykv.vk.openvk.component.video.api.b.fx ja;
    View jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private TextView f5392jp;
    TTProgressBar k;
    bc kj;
    private final int kw;
    TextView l;
    private boolean lf;
    private View m;
    private RoundImageView mh;
    private x mk;
    TextView mv;
    protected TTViewStub my;
    View n;
    private com.bytedance.sdk.openadsdk.core.nr.u nb;
    com.bykv.vk.openvk.component.video.api.renderview.nr nr;
    int o;
    private RoundImageView oa;
    private final int p;
    com.bytedance.sdk.openadsdk.dw.u.nr.u.u pb;
    View pn;
    int q;
    EnumSet<nr.u> qq;
    com.bytedance.sdk.openadsdk.core.l.nr.fx rh;
    TextView s;
    private RelativeLayout su;
    int sx;
    RoundImageView t;
    private TTViewStub tk;
    View u;
    private String v;
    private TextView w;
    private View wi;
    com.bytedance.sdk.openadsdk.core.nr.u wq;
    protected TTViewStub x;
    boolean xg;
    private RelativeLayout xw;
    private TextView y;
    private TextView yd;
    Context z;
    private AtomicBoolean za;

    public iz(Context context, View view, boolean z, EnumSet<nr.u> enumSet, bc bcVar, com.bykv.vk.openvk.component.video.api.b.fx fxVar, boolean z2, com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this.dw = true;
        this.h = true;
        this.xg = true;
        this.p = 1;
        this.kw = 2;
        this.f = 3;
        this.za = new AtomicBoolean(false);
        if (this instanceof pn) {
            return;
        }
        this.z = dw.getContext().getApplicationContext();
        b(z2);
        this.u = view;
        this.dw = z;
        this.qq = enumSet == null ? EnumSet.noneOf(nr.u.class) : enumSet;
        this.ja = fxVar;
        this.nb = uVar;
        this.kj = bcVar;
        h();
        b(8);
        u(context, this.u, bcVar);
        b();
        my();
    }

    private void bf() {
        if (this.z == null || this.u == null) {
            return;
        }
        View view = new View(this.z) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.8
            private final AtomicBoolean nr = new AtomicBoolean(true);

            private void nr() {
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar;
                if (this.nr.getAndSet(true) || (fxVar = iz.this.rh) == null) {
                    return;
                }
                fxVar.nr();
            }

            private void u() {
                if (iz.this.kj == null) {
                    return;
                }
                if (this.nr.getAndSet(false) && (com.bytedance.sdk.openadsdk.core.video.fx.u.u(iz.this.kj) || iz.this.kj.qf() == 4)) {
                    iz.this.rh();
                }
                c.u(iz.this.kj.pg(), iz.this.mk, x.class);
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                iz.this.za.set(false);
                u();
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                iz.this.za.set(true);
                nr();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                u();
            }

            @Override // android.view.View
            public void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                nr();
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = iz.this.rh;
                if (fxVar == null || !z) {
                    return;
                }
                fxVar.u();
            }
        };
        View view2 = this.u;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    private void h() {
        this.eh = 1;
        String strNr = jp.nr(this.kj);
        String str = "embeded_ad_landingpage";
        if (strNr == null) {
            strNr = this.h ? "embeded_ad" : "embeded_ad_landingpage";
        }
        this.eh = jp.nr(strNr);
        if (!this.h && strNr.equals(WifiNestConst.NestTypeConst.NEST_DRAW_AD)) {
            str = "draw_ad_landingpage";
        } else if (this.h || !strNr.equals("embeded_ad")) {
            str = strNr;
        }
        this.v = str;
    }

    private boolean ja() {
        bc bcVar = this.kj;
        return bcVar != null && tk.iz(bcVar) == null && tk.x(this.kj) == null && this.kj.mk() == 1 && bc.nr(this.kj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.jk;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.u;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.u.getMeasuredHeight();
            int iFx = y.fx(this.z, 200.0f);
            int iFx2 = y.fx(this.z, 331.0f);
            int iFx3 = y.fx(this.z, 110.0f);
            int iFx4 = y.fx(this.z, 100.0f);
            if (measuredWidth >= iFx && measuredHeight >= iFx2) {
                iz(1);
                return;
            }
            if (measuredWidth > iFx3 && measuredHeight > iFx4) {
                iz(3);
                return;
            }
            iz(2);
        } catch (Exception unused) {
        }
    }

    private void m() {
        if (xg()) {
            y.u((View) this.fx, 8);
            if (!dw.nr().r()) {
                y.u(this.b, 8);
                y.u(this.pn, 8);
                y.u((View) this.iz, 8);
                return;
            }
        }
        y.u(this.b, 0);
        y.u((View) this.xw, 8);
        y.iz(this.b);
        if (xg() && dw.nr().r()) {
            y.u(this.pn, 8);
        } else {
            y.iz(this.pn);
        }
        if (this.iz == null || TextUtils.isEmpty(zx.nr(this.kj))) {
            return;
        }
        y.iz(this.iz);
        com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.kj)).to(this.iz);
        u(this.iz, zx.nr(this.kj));
    }

    private void pb() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        bc bcVar = this.kj;
        if (bcVar != null && com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            String strA = m.a(this.kj);
            if (!TextUtils.isEmpty(strA)) {
                com.bytedance.sdk.openadsdk.n.nr.u(strA).to(this.oa);
            }
            String strFx = m.fx(this.kj);
            String strN = m.n(this.kj);
            if (!TextUtils.isEmpty(strFx)) {
                y.u(this.w, strFx);
            }
            if (this.xw == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.n.nr.u(strN).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.10
                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                    iz izVar = iz.this;
                    com.bytedance.sdk.openadsdk.core.s.b.u(izVar.kj, izVar.v, i, str);
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(iz.this.z, myVar.getResult(), 25);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(iz.this.xw.getResources(), bitmapU);
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iz.this.xw != null) {
                                iz.this.xw.setBackground(bitmapDrawable);
                            }
                        }
                    });
                    iz izVar = iz.this;
                    com.bytedance.sdk.openadsdk.core.s.b.b(izVar.kj, izVar.v, System.currentTimeMillis() - jCurrentTimeMillis);
                }
            }, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        com.bytedance.sdk.openadsdk.gi.x.u(new a("native_video_layout_download_listener") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.1
            @Override // java.lang.Runnable
            public void run() {
                iz izVar = iz.this;
                if (izVar.rh == null) {
                    izVar.rh = n.u(izVar.z, izVar.kj, izVar.v, false);
                }
                com.bytedance.sdk.openadsdk.core.nr.u uVar = iz.this.bf;
                if (uVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(iz.this.rh);
                }
                com.bytedance.sdk.openadsdk.core.nr.u uVar2 = iz.this.wq;
                if (uVar2 != null) {
                    ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(iz.this.rh);
                }
                if (iz.this.gc != null) {
                    iz izVar2 = iz.this;
                    izVar2.rh.u(izVar2.gc);
                }
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = iz.this.rh;
                if (fxVar != null) {
                    fxVar.u(false);
                }
            }
        });
    }

    private boolean wq() {
        if (this.kj == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.v) || "rewarded_video".equals(this.v)) {
            int iSv = this.kj.sv();
            float fBa = this.kj.ba();
            if (iSv == 1 && fBa == 100.0f) {
                return true;
            }
        }
        return false;
    }

    private boolean xg() {
        return TextUtils.equals(this.v, WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || TextUtils.equals(this.v, "cache_splash_ad");
    }

    private boolean y() {
        bc bcVar;
        return this.h && this.jk != null && (bcVar = this.kj) != null && bcVar.cj() == 1;
    }

    public void bg() {
        if (this.d == null || this.gi != null) {
            return;
        }
        System.currentTimeMillis();
        k kVar = new k();
        this.gi = kVar;
        kVar.u(this.z, this.u);
        this.gi.u(this.d, this);
        System.currentTimeMillis();
    }

    public void bq() {
        k kVar = this.gi;
        if (kVar != null) {
            kVar.u(false);
        }
    }

    public void c() {
        y.u(this.b, 8);
        y.u((View) this.xw, 0);
        pb();
    }

    public boolean d() {
        return !this.qq.contains(nr.u.alwayShowMediaView) || this.dw;
    }

    public boolean dw() {
        if (this.d != null) {
            return true;
        }
        com.bytedance.sdk.component.utils.k.nr("NewLiveViewLayout", "callback is null");
        return false;
    }

    public void fx(boolean z) {
    }

    public void gi() {
        if (xg()) {
            y.u((View) this.fx, 8);
            y.pn(this.b);
            y.pn(this.pn);
            ImageView imageView = this.iz;
            if (imageView != null) {
                y.pn(imageView);
            }
        }
    }

    public void iz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.k.nr
    public boolean jk() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.s.u
    public boolean k() {
        k kVar = this.gi;
        return kVar != null && kVar.u();
    }

    public void kj() {
        y.u(this.n, 8);
        y.u((View) this.f5391a, 8);
        y.u(this.jk, 8);
        y.u((View) this.t, 8);
        y.u((View) this.l, 8);
        y.u((View) this.mv, 8);
        y.u((View) this.s, 8);
        y.u(this.wi, 8);
        y.u((View) this.su, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.k.nr
    public void l() {
        u(true, false);
    }

    public boolean mv() {
        return this.c;
    }

    public void my() {
        View view;
        h();
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.kj)) {
            com.bytedance.sdk.openadsdk.core.nr.u uVar = this.nb;
            if (uVar != null) {
                this.bf = uVar;
            } else {
                this.bf = new com.bytedance.sdk.openadsdk.core.nr.u(this.z, this.kj, this.v, this.eh);
            }
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bf.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(new u.InterfaceC0278u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.5
                @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u.InterfaceC0278u
                public void u(View view2, int i) {
                    if (iz.this.bc != null) {
                        iz.this.bc.u(view2, i);
                    }
                }
            });
            if (this.nb == null && (view = this.u) != null) {
                view.setOnClickListener(this.bf);
                this.u.setOnTouchListener(this.bf);
            }
            if (y.b(this.cj)) {
                this.cj.setOnClickListener(this.bf);
                this.cj.setOnTouchListener(this.bf);
                return;
            }
            return;
        }
        bf();
        com.bytedance.sdk.openadsdk.core.nr.u uVar2 = new com.bytedance.sdk.openadsdk.core.nr.u(this.z, this.kj, this.v, this.eh);
        this.bf = uVar2;
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).nr(true);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bf.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(new u.InterfaceC0278u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.6
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u.InterfaceC0278u
            public void u(View view2, int i) {
                if (iz.this.bc != null) {
                    iz.this.bc.u(view2, i);
                }
            }
        });
        nr(this.bf);
        if (this.h) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bf.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
        } else {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bf.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(false);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bf.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
        }
        if (ja()) {
            com.bytedance.sdk.openadsdk.core.nr.u uVar3 = new com.bytedance.sdk.openadsdk.core.nr.u(this.z, this.kj, this.v, this.eh);
            this.wq = uVar3;
            nr(uVar3);
            this.mk = new x(this);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.wq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).nr(true);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.wq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(new u.InterfaceC0278u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.7
                @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u.InterfaceC0278u
                public void u(View view2, int i) {
                    if (iz.this.bc != null) {
                        iz.this.bc.u(view2, i);
                    }
                }
            });
            if (this.h) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.wq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
            } else {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.wq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(false);
            }
            u(this.wq);
            View view2 = this.u;
            if (view2 != null) {
                view2.setOnClickListener(this.wq);
                this.u.setOnTouchListener(this.wq);
            }
        }
    }

    public void nr(ViewGroup viewGroup) {
    }

    public com.bykv.vk.openvk.component.video.api.renderview.nr o() {
        return this.nr;
    }

    public void pn() {
    }

    public void q() {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.kj)) {
            c();
        } else {
            y.u((View) this.xw, 8);
            y.iz(this.b);
            y.iz(this.pn);
        }
        ImageView imageView = this.fx;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        y.u((View) this.fx, 8);
    }

    @TargetApi(14)
    public void qq() {
        y.u(this.u, 0);
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.nr;
        if (nrVar != null) {
            View view = nrVar.getView();
            y.u(view, 8);
            y.u(view, 0);
        }
    }

    public void sx() {
        if (this.kj == null) {
            return;
        }
        if (this.lf) {
            y.u((View) this.ay, 8);
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.kj)) {
            String strA = m.a(this.kj);
            String strFx = m.fx(this.kj);
            String strN = m.n(this.kj);
            y.u(this.wi, 0);
            y.u((View) this.su, 0);
            if (!TextUtils.isEmpty(strA)) {
                com.bytedance.sdk.openadsdk.n.nr.u(strA).to(this.mh);
            }
            if (!TextUtils.isEmpty(strFx)) {
                y.u(this.yd, strFx);
            }
            if (this.su == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.n.nr.u(strN).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.9
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(iz.this.z, myVar.getResult(), 25);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(iz.this.su.getResources(), bitmapU);
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iz.this.su != null) {
                                iz.this.su.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            }, 4);
        }
    }

    public boolean t() {
        return this.dw;
    }

    public void u(long j) {
    }

    public void z() {
        bc bcVar = this.kj;
        if (bcVar == null) {
            return;
        }
        if (this.kj.mf() != 5 ? bcVar.mf() == 1 && yd.o(this.kj) : true) {
            u(false, this.dw);
            u(this.u, dw.getContext());
            if (this.f5391a == null || TextUtils.isEmpty(zx.nr(this.kj))) {
                return;
            }
            y.u(this.n, 0);
            y.u((View) this.f5391a, 0);
            y.u(this.jk, 8);
            com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.kj)).to(this.f5391a);
            u(this.f5391a, zx.nr(this.kj));
        }
    }

    private void n(int i) {
        y.u(this.jk, i);
        y.u(this.m, i);
    }

    private int x(int i) {
        if (this.bg <= 0 || this.bq <= 0) {
            return 0;
        }
        int iFx = y.fx(this.z, 228.0f);
        int iFx2 = y.fx(this.z, 160.0f);
        int i2 = (int) (this.bq * ((i * 1.0f) / this.bg));
        return i2 > iFx ? iFx : i2 < iFx2 ? iFx2 : i2;
    }

    public void a() {
        TTProgressBar tTProgressBar = this.k;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.k.setSecondaryProgress(0);
        }
        b(8);
        if (d()) {
            this.nr.setVisibility(8);
        }
        ImageView imageView = this.iz;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.iz.setBackground(null);
        }
        ImageView imageView2 = this.f5391a;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.f5391a.setBackground(null);
        }
        b(8);
        y.u(this.n, 8);
        y.u((View) this.f5391a, 8);
        y.u(this.jk, 8);
        y.u((View) this.t, 8);
        y.u((View) this.l, 8);
        y.u((View) this.mv, 8);
        y.u(this.wi, 8);
        y.u((View) this.su, 8);
        k kVar = this.gi;
        if (kVar != null) {
            kVar.u(true);
        }
    }

    public void b() {
        this.nr.u(this);
        ImageView imageView = this.fx;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (iz.this.dw()) {
                        TextView textView = iz.this.s;
                        if (textView == null || textView.getVisibility() != 0) {
                            iz izVar = iz.this;
                            izVar.d.u(izVar, view);
                        }
                    }
                }
            });
        }
    }

    public boolean fx(int i) {
        return false;
    }

    public void nr(boolean z) {
    }

    public void u(long j, long j2) {
    }

    public void iz(int i) {
        bc bcVar;
        if (this.t == null || (bcVar = this.kj) == null || bcVar.dd() == null || this.kj.dd().u() == null) {
            return;
        }
        if (i == 1) {
            int iFx = y.fx(this.z, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iFx, iFx);
            layoutParams.addRule(14);
            this.t.setLayoutParams(layoutParams);
            this.l.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = y.fx(this.z, 16.0f);
            layoutParams2.topMargin = y.fx(this.z, 8.0f);
            layoutParams2.leftMargin = y.fx(this.z, 16.0f);
            layoutParams2.rightMargin = y.fx(this.z, 16.0f);
            layoutParams2.addRule(3, this.t.getId());
            layoutParams2.addRule(14);
            this.mv.setLayoutParams(layoutParams2);
            this.mv.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, y.fx(this.z, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.mv.getId());
            layoutParams3.leftMargin = y.fx(this.z, 20.0f);
            layoutParams3.rightMargin = y.fx(this.z, 20.0f);
            this.s.setPadding(y.fx(this.z, 36.0f), y.fx(this.z, 7.0f), y.fx(this.z, 36.0f), y.fx(this.z, 8.0f));
            this.s.setLayoutParams(layoutParams3);
            this.s.setEllipsize(TextUtils.TruncateAt.END);
            this.s.setSingleLine(true);
            this.s.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int iFx2 = y.fx(this.z, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iFx2, iFx2);
            layoutParams4.addRule(14);
            this.t.setLayoutParams(layoutParams4);
            this.l.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = y.fx(this.z, 8.0f);
            layoutParams5.topMargin = y.fx(this.z, 8.0f);
            layoutParams5.addRule(3, this.t.getId());
            layoutParams5.addRule(14);
            this.mv.setLayoutParams(layoutParams5);
            this.mv.setTextSize(10.0f);
            y.u((View) this.s, 8);
            return;
        }
        int iFx3 = y.fx(this.z, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iFx3, iFx3);
        layoutParams6.addRule(14);
        this.t.setLayoutParams(layoutParams6);
        this.l.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = y.fx(this.z, 8.0f);
        layoutParams7.topMargin = y.fx(this.z, 8.0f);
        layoutParams7.addRule(3, this.t.getId());
        layoutParams7.addRule(14);
        this.mv.setLayoutParams(layoutParams7);
        this.mv.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, y.fx(this.z, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.mv.getId());
        int iFx4 = y.fx(this.z, 20.0f);
        int iFx5 = y.fx(this.z, 25.0f);
        int iFx6 = y.fx(this.z, 6.0f);
        TextPaint paint = this.s.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.s.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String string = text.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        this.s.setTextSize(13.0f);
        if (this.s.getWidth() > (iFx5 * 2) + rect.width() && this.s.getHeight() > (iFx6 * 2) + rect.height()) {
            layoutParams8.leftMargin = iFx4;
            layoutParams8.rightMargin = iFx4;
            this.s.setPadding(iFx5, y.fx(this.z, 5.0f), iFx5, iFx6);
        }
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        this.s.setSingleLine(true);
        this.s.setLayoutParams(layoutParams8);
    }

    public void pn(int i) {
        y.u(this.u, 0);
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.nr;
        if (nrVar != null) {
            nrVar.setVisibility(i);
        }
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
    }

    private void nr(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        bc bcVar;
        if (uVar == null || (bcVar = this.kj) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.my.fx.nr.s sVarU = com.bytedance.sdk.openadsdk.core.video.b.u.u(Integer.valueOf(bcVar.hashCode()));
        if (sVarU instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.c) {
            ((com.bytedance.sdk.openadsdk.core.nativeexpress.c) sVarU).u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        }
    }

    public void fx(int i, int i2) {
        this.bg = i;
        this.bq = i2;
    }

    public void n() {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.kj)) {
            y.u((View) this.xw, 8);
        } else {
            y.pn(this.b);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.s.u
    public void u(View view, boolean z) {
    }

    public void b(boolean z) {
        this.h = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.nr.u uVar = this.bf;
            if (uVar != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
            }
            com.bytedance.sdk.openadsdk.core.nr.u uVar2 = this.wq;
            if (uVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nr.u uVar3 = this.bf;
        if (uVar3 != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar3.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bf.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
        }
        com.bytedance.sdk.openadsdk.core.nr.u uVar4 = this.wq;
        if (uVar4 != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar4.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.wq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
        }
    }

    public void u(ViewGroup viewGroup) {
    }

    public void fx(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.u.getParent() == null) {
            viewGroup.addView(this.u);
        }
        b(0);
    }

    public void pn(boolean z) {
        this.lf = z;
    }

    public void u(String str) {
    }

    public void x() {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.kj)) {
            c();
        } else {
            m();
        }
        ImageView imageView = this.fx;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        y.u((View) this.fx, 8);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void u(bc bcVar, WeakReference weakReference, boolean z) {
        u2(bcVar, (WeakReference<Context>) weakReference, z);
    }

    private void nr(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387888);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387688);
        if (wq()) {
            y.u((View) relativeLayout, 0);
            y.u((View) relativeLayout2, 8);
            this.xw = relativeLayout;
        } else {
            y.u((View) relativeLayout2, 0);
            y.u((View) relativeLayout, 8);
            this.xw = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.xw;
        if (relativeLayout3 == null) {
            return;
        }
        this.oa = (RoundImageView) relativeLayout3.findViewById(2114387831);
        this.w = (TextView) this.xw.findViewById(2114387742);
        this.cj = (RelativeLayout) this.xw.findViewById(2114387693);
    }

    private void u(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        bc bcVar;
        if (uVar == null || (bcVar = this.kj) == null || !com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("click_live_element", "click_live_feed");
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    public View fx() {
        return this.u;
    }

    public void u(NativeVideoTsView.u uVar) {
        this.bc = uVar;
    }

    public void u(mv mvVar) {
        u(mvVar, this.bf);
        u(mvVar, this.wq);
    }

    private void u(mv mvVar, com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        bq bqVarQq;
        if (uVar == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(mvVar);
        com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class);
        if ((mvVar instanceof com.bytedance.sdk.openadsdk.core.z.fx) && (bqVarQq = ((com.bytedance.sdk.openadsdk.core.z.fx) mvVar).qq()) != null) {
            bqVarQq.u(fxVar);
        }
    }

    public void b(int i) {
        this.q = i;
        y.u(this.u, i);
    }

    private void nr(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.my) == null || tTViewStub.getParent() == null || this.m != null) {
            return;
        }
        this.my.u();
        this.m = view.findViewById(2114387674);
        this.f5392jp = (TextView) view.findViewById(2114387868);
        this.y = (TextView) view.findViewById(2114387842);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.s.u
    public void s() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, com.bykv.vk.openvk.component.video.api.renderview.nr] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.ViewGroup, android.widget.RelativeLayout] */
    public void u(Context context, View view, bc bcVar) {
        ?? sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.bytedance.sdk.openadsdk.pn.u.nr(bcVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.z);
        } else if (com.bytedance.sdk.openadsdk.pn.u.fx(bcVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.bytedance.sdk.openadsdk.pn.u.a(bcVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.z);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (xg()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(-16777216);
            }
        }
        y.u((View) sSRenderTextureView, 8);
        this.nr = sSRenderTextureView;
        this.fx = (ImageView) view.findViewById(2114387626);
        this.k = (TTProgressBar) view.findViewById(2114387653);
        this.b = view.findViewById(2114387900);
        this.pn = view.findViewById(2114387631);
        this.iz = (ImageView) view.findViewById(2114387651);
        this.x = (TTViewStub) view.findViewById(2114387744);
        this.tk = (TTViewStub) view.findViewById(2114387666);
        this.my = (TTViewStub) view.findViewById(2114387828);
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            nr(context, view);
        }
        System.currentTimeMillis();
    }

    public iz(Context context, View view, boolean z, EnumSet<nr.u> enumSet, bc bcVar, com.bykv.vk.openvk.component.video.api.b.fx fxVar, com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this(context, view, z, enumSet, bcVar, fxVar, true, uVar);
    }

    public void nr(boolean z, boolean z2) {
        ImageView imageView = this.fx;
        if (imageView != null) {
            if (z) {
                q.u(this.z, "tt_play_movebar_textpage", imageView);
            } else {
                q.u(this.z, "tt_stop_movebar_textpage", imageView);
            }
        }
    }

    public void nr(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.u;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.u.setLayoutParams(layoutParams);
    }

    public void nr(int i) {
        y.u((View) this.k, 0);
        TTProgressBar tTProgressBar = this.k;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    public void nr() {
        if (xg()) {
            y.u(this.b, 8);
            y.u(this.pn, 8);
            y.u((View) this.iz, 8);
            y.u((View) this.fx, 8);
            return;
        }
        y.u((View) this.xw, 8);
        y.pn(this.b);
        y.pn(this.pn);
        ImageView imageView = this.iz;
        if (imageView != null) {
            y.pn(imageView);
        }
    }

    public void u(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.tk) == null || tTViewStub.getParent() == null || this.wi != null) {
            return;
        }
        this.wi = this.tk.u();
        this.su = (RelativeLayout) view.findViewById(2114387953);
        this.mh = (RoundImageView) view.findViewById(2114387958);
        this.yd = (TextView) view.findViewById(2114387926);
        this.ay = (TextView) view.findViewById(2114387877);
    }

    public void u(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.x) == null || tTViewStub.getParent() == null || this.n != null) {
            return;
        }
        this.n = this.x.u();
        this.x.setVisibility(0);
        this.f5391a = (ImageView) view.findViewById(2114387804);
        this.jk = view.findViewById(2114387961);
        this.t = (RoundImageView) view.findViewById(2114387664);
        this.l = (TextView) view.findViewById(2114387957);
        this.mv = (TextView) view.findViewById(2114387764);
        this.s = (TextView) view.findViewById(2114387686);
    }

    public boolean u(int i, com.bykv.vk.openvk.component.video.api.fx.b bVar, boolean z) {
        k kVar = this.gi;
        return kVar == null || kVar.u(i, bVar, z);
    }

    public void u(com.bykv.vk.openvk.component.video.api.b.u uVar) {
        if (uVar instanceof nr) {
            this.d = (nr) uVar;
            bg();
        }
    }

    public void u(int i, int i2) {
        if (i == -1) {
            i = y.b(this.z);
        }
        if (i <= 0) {
            return;
        }
        this.o = i;
        if (!t() && !jk() && !this.qq.contains(nr.u.fixedSize)) {
            this.sx = x(i);
        } else {
            this.sx = i2;
        }
        nr(this.o, this.sx);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    public void u() {
        u(false, this.dw);
        kj();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    public void u(boolean z) {
        this.xg = z;
    }

    public void u(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.pn.u.u(this.kj) || com.bytedance.sdk.openadsdk.pn.u.x(this.kj)) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.nr.u(str).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.12
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my<Bitmap> myVar) {
                Bitmap result;
                if (myVar == null || (result = myVar.getResult()) == null) {
                    return;
                }
                final Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(iz.this.z, result, 25);
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmapU != null) {
                            imageView.setBackground(new BitmapDrawable(bitmapU));
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i, String str2, Throwable th) {
            }
        }, 4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: u, reason: avoid collision after fix types in other method */
    public void u2(bc bcVar, WeakReference<Context> weakReference, boolean z) {
        String strYm;
        bc bcVar2;
        if (bcVar == null || xg()) {
            return;
        }
        u(false, this.dw);
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            u(dw.getContext(), this.u);
            sx();
            return;
        }
        u(this.u, dw.getContext());
        View view = this.n;
        if (view != null) {
            y.u(view, 0);
        }
        ImageView imageView = this.f5391a;
        if (imageView != null) {
            y.u((View) imageView, 0);
        }
        if (jp.fx(this.kj)) {
            nr(this.u, dw.getContext());
            y.u(this.jk, 8);
            y.u((View) this.f5391a, 0);
            y.u(this.m, 0);
            y.u((View) this.f5392jp, 0);
            y.u((View) this.y, 0);
            if (this.y != null && o.fx(dw.getContext()) == 0) {
                y.u((View) this.y, 8);
            }
            View view2 = this.n;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.bykv.vk.openvk.component.video.api.b.fx fxVar = iz.this.ja;
                        if (fxVar != null) {
                            ((com.bykv.vk.openvk.component.video.api.b.u) fxVar).u();
                            com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar = iz.this.pb;
                            if (uVar != null) {
                                uVar.u();
                            }
                        }
                    }
                });
            }
            if (this.f5391a != null && !TextUtils.isEmpty(zx.nr(this.kj))) {
                if (com.bytedance.sdk.openadsdk.pn.u.nr(bcVar)) {
                    com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.kj)).to(this.f5391a);
                    u(this.f5391a, zx.nr(this.kj));
                } else {
                    com.bykv.vk.openvk.component.video.u.pn.nr.u(2147483647L, zx.u(this.kj), new nr.InterfaceC0162nr() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.3
                        @Override // com.bykv.vk.openvk.component.video.u.pn.nr.InterfaceC0162nr
                        public void u(Bitmap bitmap) {
                            if (bitmap == null) {
                                com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(iz.this.kj)).to(iz.this.f5391a);
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iz.this.f5391a.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                float height = (bitmap.getHeight() * y.b(dw.getContext())) / bitmap.getWidth();
                                layoutParams.width = y.b(dw.getContext());
                                layoutParams.height = (int) height;
                                layoutParams.addRule(13);
                                iz.this.f5391a.setLayoutParams(layoutParams);
                            }
                            iz.this.f5391a.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        } else {
            y.u(this.jk, 0);
            if (this.f5391a != null && !TextUtils.isEmpty(zx.nr(this.kj))) {
                com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.kj)).to(this.f5391a);
                u(this.f5391a, zx.nr(this.kj));
            }
            if (y()) {
                this.jk.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.iz.4
                    @Override // java.lang.Runnable
                    public void run() {
                        iz.this.jp();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(bcVar.j())) {
            strYm = bcVar.j();
        } else if (!TextUtils.isEmpty(bcVar.wf())) {
            strYm = bcVar.wf();
        } else {
            strYm = !TextUtils.isEmpty(bcVar.ym()) ? bcVar.ym() : "";
        }
        if (this.t != null && (bcVar2 = this.kj) != null && bcVar2.dd() != null && this.kj.dd().u() != null) {
            y.u((View) this.t, 0);
            y.u((View) this.l, 4);
            com.bytedance.sdk.openadsdk.n.nr.u(this.kj.dd()).to(this.t);
            if (ja()) {
                this.t.setOnClickListener(this.wq);
                this.t.setOnTouchListener(this.wq);
            } else {
                this.t.setOnClickListener(this.bf);
                this.t.setOnTouchListener(this.bf);
            }
        } else if (!TextUtils.isEmpty(strYm)) {
            y.u((View) this.t, 4);
            y.u((View) this.l, 0);
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(strYm.substring(0, 1));
                if (ja()) {
                    this.l.setOnClickListener(this.wq);
                    this.l.setOnTouchListener(this.wq);
                } else {
                    this.l.setOnClickListener(this.bf);
                    this.l.setOnTouchListener(this.bf);
                }
            }
        }
        if (this.mv != null && !TextUtils.isEmpty(strYm)) {
            this.mv.setText(strYm);
        }
        y.u((View) this.mv, 0);
        y.u((View) this.s, 0);
        String strYb = bcVar.yb();
        if (TextUtils.isEmpty(strYb)) {
            int iQf = bcVar.qf();
            strYb = iQf != 4 ? iQf != 5 ? "查看详情" : "立即拨打" : "立即下载";
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setText(strYb);
            this.s.setOnClickListener(this.bf);
            this.s.setOnTouchListener(this.bf);
        }
        TextView textView3 = this.f5392jp;
        if (textView3 != null) {
            textView3.setText(strYb);
            this.f5392jp.setOnClickListener(this.bf);
            this.f5392jp.setOnTouchListener(this.bf);
        }
        if (this.xg) {
            return;
        }
        n(4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.u
    public void u(SurfaceTexture surfaceTexture, int i, int i2) {
        this.c = true;
        if (dw()) {
            this.d.u(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.u
    public boolean u(SurfaceTexture surfaceTexture) {
        this.c = false;
        if (!dw()) {
            return true;
        }
        this.d.nr(this, surfaceTexture);
        return true;
    }

    public void u(boolean z, boolean z2, boolean z3) {
        y.u((View) this.k, 0);
        y.u((View) this.fx, (z && (y.b(this.b) && y.b(this.xw))) ? 0 : 8);
    }

    public void u(boolean z, boolean z2) {
        y.u((View) this.k, z ? 0 : 8);
        y.u((View) this.fx, 8);
    }

    public void u(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar) {
        this.pb = uVar;
        com.bytedance.sdk.openadsdk.core.nr.u uVar2 = this.bf;
        if (uVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(uVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    public void u(Drawable drawable) {
        View view = this.u;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.nr
    public void u(int i) {
        y.u((View) this.cj, i);
    }

    public void u(u.InterfaceC0273u interfaceC0273u) {
        this.gc = interfaceC0273u;
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.rh;
        if (fxVar != null) {
            fxVar.u(interfaceC0273u);
        }
    }
}
