package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.s;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.bg;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.iz.fx.o;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"ViewConstructor"})
public class NativeVideoTsView extends FrameLayout implements fx.u, rh.u, b.u {
    private static volatile com.bytedance.sdk.component.b.nr.fx v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f5388a;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz ay;
    protected bc b;
    private int bc;
    private final String bf;
    public b bg;
    protected final AtomicBoolean bq;
    private boolean c;
    private boolean cj;
    private boolean d;
    private String dw;
    private nr eh;
    protected final Context fx;
    private boolean gc;
    private NativeExpressVideoView gi;
    private long h;
    protected ViewGroup iz;
    private boolean ja;
    protected RelativeLayout jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private boolean f5389jp;
    protected String k;
    private boolean kj;
    private AtomicBoolean kw;
    protected ImageView l;
    private boolean lf;
    private fx.InterfaceC0154fx m;
    private View.OnAttachStateChangeListener mh;
    private boolean mk;
    protected ImageView mv;
    protected int my;
    protected boolean n;
    private boolean nb;
    private boolean nr;
    AtomicBoolean o;
    private boolean oa;
    private volatile boolean p;
    private long pb;
    protected com.bykv.vk.openvk.component.video.api.b.fx pn;
    private boolean q;
    private boolean qq;
    private final rh rh;
    protected boolean s;
    private ViewTreeObserver su;
    boolean sx;
    protected ImageView t;
    private fx tk;
    private boolean u;
    private boolean w;
    private ViewTreeObserver.OnGlobalLayoutListener wi;
    private TTViewStub wq;
    protected FrameLayout x;
    private long xg;
    private int xw;
    private boolean y;
    private ViewGroup yd;
    private boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void u(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements qq {
        private bc b;
        private WeakReference<GifView> fx = new WeakReference<>(null);
        private int iz;
        private WeakReference<ViewGroup> nr;
        private String pn;
        private s u;
        private int x;

        public fx(s sVar, ViewGroup viewGroup, bc bcVar, String str, int i, int i2) {
            this.u = sVar;
            this.nr = new WeakReference<>(viewGroup);
            this.b = bcVar;
            this.pn = str;
            this.iz = i;
            this.x = i2;
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onFailed(int i, String str, Throwable th) {
            k.nr("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.fx.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.s.b.u(this.b, this.pn, 2);
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onSuccess(final my myVar) {
            try {
                ViewGroup viewGroup = this.nr.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.fx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) fx.this.nr.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            fx fxVar = fx.this;
                            fxVar.u(context, fxVar.u, myVar, viewGroup2);
                        } catch (Exception unused) {
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                onFailed(1002, "", e);
            }
        }

        private int u() {
            if (this.u.iz() > 0.0d) {
                return (int) (((double) this.x) * this.u.iz());
            }
            return this.x / 2;
        }

        private void u(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.u.fx() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = y.fx(context, 19.0f);
            }
        }

        private void u(Object obj, my myVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (myVar.isGif()) {
                    gifView.u((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(bg.u((byte[]) obj, 0));
                }
            }
        }

        private void u(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Context context, s sVar, my myVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int iFx = y.fx(context, 12.0f);
            this.iz = viewGroup.getWidth() <= 0 ? this.iz : viewGroup.getWidth();
            this.x = viewGroup.getHeight() <= 0 ? this.x : viewGroup.getHeight();
            int iU = u();
            if (sVar.u() == 3) {
                if (iU > y.fx(context, 88.0f)) {
                    iU = y.fx(context, 88.0f);
                }
            } else if (sVar.u() == 4 && iU > y.fx(context, 178.0f)) {
                iU = y.fx(context, 178.0f);
            }
            int i = this.iz - iFx;
            int iX = (int) (((double) iU) * sVar.x());
            if (iX > i && iX > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, iU);
            }
            u(context, layoutParams, iFx);
            gifView.setVisibility(0);
            u(myVar.getResult(), myVar, gifView);
            u(this.fx.get());
            viewGroup.addView(gifView, layoutParams);
            this.fx = new WeakReference<>(gifView);
            com.bytedance.sdk.openadsdk.core.s.b.u(this.b, this.pn, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class nr implements Runnable {
        private volatile boolean nr;

        private nr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.nr(this.nr);
        }

        public Runnable u(boolean z) {
            this.nr = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(View view, int i);
    }

    public NativeVideoTsView(Context context, bc bcVar) {
        this(context, bcVar, false, false);
    }

    private void bf() {
        if (v == null) {
            v = getKvCache();
        }
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null || o() || !v.get("key_video_is_update_flag", false)) {
            return;
        }
        boolean z = v.get("key_native_video_complete", false);
        long j = v.get("key_video_current_play_position", -1L);
        long j2 = v.get("key_video_total_play_duration", fxVar.s() + fxVar.l());
        long j3 = v.get("key_video_duration", fxVar.s());
        fxVar.fx(z);
        if (z) {
            fxVar.nr(j3);
        } else {
            fxVar.nr(j);
        }
        fxVar.fx(j2);
        fxVar.b(j3);
        v.put("key_video_is_update_flag", false);
    }

    private void c() {
        addView(u(this.fx));
        B_();
    }

    private boolean d() {
        View view;
        if (!t.u(this.b)) {
            view = this;
        } else if (tk.u(this.b) == 2) {
            view = this.gi;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return wq.nr(view, com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(50, this.b), 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.b.nr.fx getKvCache() {
        return bf.u("sp_multi_native_video_data");
    }

    private void gi() {
        boolean zD = d();
        if (this.p && zD) {
            com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
            if (fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.b) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) fxVar).rh();
            }
            this.p = false;
        } else {
            if (this.eh == null) {
                this.eh = new nr();
            } else {
                jk.nr().removeCallbacks(this.eh);
            }
            this.eh.u(zD);
            jk.nr().post(this.eh);
        }
        this.rh.sendEmptyMessageDelayed(1, this.pb);
    }

    private boolean h() {
        if (o()) {
            return false;
        }
        if (v == null) {
            v = getKvCache();
        }
        return v.get("key_video_is_from_detail_page", false) || v.get("key_video_isfromvideodetailpage", false);
    }

    private void ja() {
        if (this.yd == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.yd.hashCode()) {
                    this.yd.hashCode();
                    return;
                }
            }
        }
    }

    private void kj() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null) {
            return;
        }
        fxVar.b(this.u);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) this.pn).u((b.u) this);
        this.pn.u(this);
    }

    private void n() {
        u(0L, 0);
        this.m = null;
    }

    private boolean pb() {
        return 5 == dw.nr().iz(jp.t(this.b));
    }

    private void q() {
        if (!(this instanceof NativeDrawVideoTsView) || this.o.get() || n.o().oa() == null) {
            return;
        }
        this.mv.setImageBitmap(n.o().oa());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mv.getLayoutParams();
        int iFx = y.fx(getContext(), this.my);
        layoutParams.width = iFx;
        layoutParams.height = iFx;
        this.mv.setLayoutParams(layoutParams);
        this.o.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.su;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.wi) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private void rh() {
        if (o()) {
            return;
        }
        if (v == null) {
            v = getKvCache();
        }
        v.put("key_video_isfromvideodetailpage", false);
        v.put("key_video_is_from_detail_page", false);
    }

    private boolean wq() {
        return 2 == dw.nr().iz(jp.t(this.b));
    }

    private void xg() {
        y.pn(this.l);
        y.pn(this.jk);
    }

    private boolean z() {
        return TextUtils.equals(this.k, WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || TextUtils.equals(this.k, "cache_splash_ad");
    }

    public void B_() {
        this.pn = u(this.fx, this.x, this.b, this.k, !o(), this.qq, this.kj);
        kj();
        this.mh = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.su = nativeVideoTsView.iz.getViewTreeObserver();
                if (NativeVideoTsView.this.su == null || NativeVideoTsView.this.wi == null) {
                    return;
                }
                NativeVideoTsView.this.su.addOnGlobalLayoutListener(NativeVideoTsView.this.wi);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.qq();
            }
        };
        this.wi = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.iz.getWidth();
                int height = NativeVideoTsView.this.iz.getHeight();
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) NativeVideoTsView.this.pn).u(width, height);
                NativeVideoTsView.this.qq();
                NativeVideoTsView.this.nr(width, height);
            }
        };
    }

    public void C_() {
        y.u((View) this.jk, 8);
        fx.InterfaceC0154fx interfaceC0154fx = this.m;
        if (interfaceC0154fx != null && !this.mk) {
            this.mk = true;
            interfaceC0154fx.o_();
        }
        y.u((View) this.jk, 8);
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz izVar = this.ay;
        if (izVar != null) {
            izVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.b.u
    public void a() {
        this.p = true;
        if (this.rh.hasMessages(1)) {
            return;
        }
        this.rh.sendEmptyMessage(1);
    }

    public void bg() {
        if (this.pn != null) {
            xg();
            this.pn.nr();
        }
    }

    public void bq() {
        rh rhVar = this.rh;
        if (rhVar != null) {
            rhVar.removeCallbacksAndMessages(null);
        }
    }

    public com.bykv.vk.openvk.component.video.api.b.fx getNativeVideoController() {
        return this.pn;
    }

    public boolean getVideoError() {
        return this.q;
    }

    public boolean jk() {
        return this.nb;
    }

    public boolean k() {
        return this.u;
    }

    public void l() {
        TTViewStub tTViewStub;
        if (z() || this.fx == null || (tTViewStub = this.wq) == null || tTViewStub.getParent() == null || this.b == null || this.jk != null) {
            return;
        }
        if (this.wq.getParent() != null && (this.wq.getParent() instanceof ViewGroup)) {
            this.jk = (RelativeLayout) this.wq.u();
        }
        this.t = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387847);
        this.mv = imageView;
        if (this.s) {
            y.u((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(zx.nr(this.b))) {
            com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.b)).to(this.t);
            u(this.t, zx.nr(this.b));
        }
        q();
    }

    public boolean mv() {
        bc bcVar = this.b;
        return bcVar != null && bcVar.ts() == 4 && tk.u(this.b) == 1 && !TextUtils.equals(WifiNestConst.NestTypeConst.NEST_DRAW_AD, this.k);
    }

    public boolean my() {
        return this.n;
    }

    public boolean o() {
        return this.nr;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.oa) {
            ViewGroup viewGroup = this.iz;
            if (viewGroup != null && (onAttachStateChangeListener = this.mh) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            b();
            com.bytedance.sdk.openadsdk.core.k.n.u(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.iz;
        if (viewGroup != null && (onAttachStateChangeListener = this.mh) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        pn();
        this.tk = null;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.oa) {
            b();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        t();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        pn();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar2;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar3;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar4;
        super.onWindowFocusChanged(z);
        if (this.oa) {
            this.f5389jp = z;
            bf();
            if (h() && (fxVar4 = this.pn) != null && fxVar4.bq()) {
                rh();
                y.u((View) this.jk, 8);
                b(true);
                n();
                return;
            }
            x();
            if (!o() && k() && (fxVar2 = this.pn) != null && !fxVar2.my()) {
                if (this.rh != null) {
                    if (z && (fxVar3 = this.pn) != null && !fxVar3.bq()) {
                        this.rh.obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        this.rh.removeMessages(1);
                        nr(false);
                        return;
                    }
                }
                return;
            }
            if (k()) {
                return;
            }
            if (!z && (fxVar = this.pn) != null && fxVar.o() != null && this.pn.o().mv()) {
                this.rh.removeMessages(1);
                nr(false);
            } else if (z) {
                this.rh.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar2;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar3;
        super.onWindowVisibilityChanged(i);
        if (this.oa) {
            ja();
            bf();
            if (this.gc) {
                this.gc = i == 0;
            }
            if (h() && (fxVar3 = this.pn) != null && fxVar3.bq()) {
                rh();
                y.u((View) this.jk, 8);
                b(true);
                n();
                return;
            }
            x();
            if (o() || !k() || (fxVar = this.pn) == null || fxVar.my() || this.b == null) {
                return;
            }
            boolean zNr = wq.nr(this, com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(20, this.b), 5);
            isShown();
            if (this.d && zx.k(this.b) != null && zNr) {
                com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, this.b);
                izVarU.nr(this.b.lk());
                izVarU.nr(this.iz.getWidth());
                izVarU.fx(this.iz.getHeight());
                izVarU.fx(this.b.ap());
                izVarU.u(this.h);
                izVarU.nr(my());
                u(izVarU);
                y.u((View) this.jk, 8);
            } else {
                try {
                    StringBuilder sb = new StringBuilder("onWindowVisibilityChanged materialMeta.getVideo() is null ");
                    sb.append(this.jk == null);
                    sb.append(" ");
                    sb.append(this.gc);
                    sb.append(" ");
                    sb.append(hashCode());
                    k.nr("NativeVideoAdView", sb.toString());
                    if (this.gc && this.jk == null) {
                        l();
                        y.u((View) this.jk, 0);
                    }
                } catch (Throwable unused) {
                }
            }
            if (i != 0 || !this.f5389jp || this.rh == null || (fxVar2 = this.pn) == null || fxVar2.bq()) {
                return;
            }
            this.rh.obtainMessage(1).sendToTarget();
        }
    }

    public void pn() {
        this.bg = null;
        sx();
        s();
    }

    public void s() {
        if (!this.bq.get()) {
            this.bq.set(true);
            if (this.pn != null) {
                rh rhVar = this.rh;
                if (rhVar != null) {
                    rhVar.removeCallbacksAndMessages(null);
                }
                this.pn.u(true, 3);
            }
        }
        this.kw.set(false);
    }

    public void setAdCreativeClickListener(u uVar) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) fxVar).u(uVar);
        }
    }

    public void setComplete(boolean z) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.fx(z);
        }
    }

    public void setControllerStatusCallBack(b bVar) {
        this.bg = bVar;
    }

    public void setDrawVideoListener(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) fxVar).u(uVar);
        }
    }

    public void setEasyPlayableEventSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz izVar) {
        this.ay = izVar;
    }

    public void setEnableAutoCheck(boolean z) {
        this.oa = z;
    }

    public void setEnableBlur(boolean z) {
        this.f5388a = z;
    }

    public void setIsAutoPlay(boolean z) {
        bc bcVar;
        if (this.ja || (bcVar = this.b) == null) {
            return;
        }
        int iIz = dw.nr().iz(jp.t(bcVar));
        if (z && iIz != 4 && (!o.pn(this.fx) ? !(!o.iz(this.fx) ? o.b(this.fx) : wq() || pb()) : !wq())) {
            z = false;
        }
        this.u = z;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.b(z);
        }
        if (this.u) {
            y.u((View) this.jk, 8);
        } else {
            l();
            RelativeLayout relativeLayout = this.jk;
            if (relativeLayout != null) {
                y.u((View) relativeLayout, 0);
                if (zx.k(this.b) != null) {
                    com.bytedance.sdk.openadsdk.n.nr.u(zx.nr(this.b)).to(this.t);
                    u(this.t, zx.nr(this.b));
                } else {
                    k.nr("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        }
        this.ja = true;
    }

    public void setIsQuiet(boolean z) {
        this.n = z;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.nr(z);
        }
    }

    public void setMaterialMeta(bc bcVar) {
        this.b = bcVar;
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.gi = nativeExpressVideoView;
    }

    public void setNativeRenderAd(boolean z) {
        this.nb = z;
    }

    public void setNativeVideoAdListener(fx.u uVar) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.u(uVar);
        }
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.b.fx fxVar) {
        this.pn = fxVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.s = z;
    }

    public void setVideoAdClickListenerTTNativeAd(mv mvVar) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) fxVar).u(mvVar);
        }
    }

    public void setVideoAdInteractionListener(fx.InterfaceC0154fx interfaceC0154fx) {
        this.m = interfaceC0154fx;
    }

    public void setVideoAdLoadListener(fx.b bVar) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.u(bVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.dw = str;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            s();
        }
    }

    public void sx() {
        com.bykv.vk.openvk.component.video.api.b.nr nrVarSx;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null || (nrVarSx = fxVar.sx()) == null) {
            return;
        }
        nrVarSx.u();
        View viewFx = nrVarSx.fx();
        if (viewFx != null) {
            viewFx.setVisibility(8);
            if (viewFx.getParent() != null) {
                ((ViewGroup) viewFx.getParent()).removeView(viewFx);
            }
        }
    }

    public void t() {
        b bVar;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar;
        if (this.nr || (bVar = this.bg) == null || (fxVar = this.pn) == null) {
            return;
        }
        bVar.u(fxVar.bq(), this.pn.s(), this.pn.s() + this.pn.l(), this.pn.t(), this.u, this.n);
    }

    public void x() {
        bc bcVar = this.b;
        if (bcVar == null) {
            return;
        }
        int iIz = dw.nr().iz(jp.t(bcVar));
        if (iIz == 1) {
            this.u = o.b(this.fx);
        } else if (iIz == 2) {
            this.u = o.pn(this.fx) || o.b(this.fx) || o.iz(this.fx) || o.fx(dw.getContext()) == 1;
        } else if (iIz == 3) {
            this.u = false;
        } else if (iIz == 4) {
            this.sx = true;
        } else if (iIz == 5) {
            this.u = o.b(this.fx) || o.iz(this.fx);
        }
        if (this.nr) {
            this.n = false;
        } else {
            this.n = this.b.jn() == 1;
        }
        if (WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(this.k)) {
            this.u = true;
            this.n = true;
        }
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.b(this.u);
        }
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public void b() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null) {
            B_();
        } else if ((fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.b) && !o()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) this.pn).xw();
        }
        if (this.pn == null || !this.bq.get()) {
            return;
        }
        this.bq.set(false);
        x();
        if (!k()) {
            if (this.pn.bq()) {
                b(true);
                return;
            } else {
                l();
                y.u((View) this.jk, 0);
                return;
            }
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            y.u((View) imageView, 8);
        }
        if (zx.k(this.b) == null) {
            k.nr("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, this.b);
        izVarU.nr(this.b.lk());
        izVarU.nr(this.iz.getWidth());
        izVarU.fx(this.iz.getHeight());
        izVarU.fx(this.b.ap());
        izVarU.u(0L);
        izVarU.u(t.u(this.b));
        izVarU.nr(my());
        if (z()) {
            String strFx = com.bytedance.sdk.openadsdk.gi.jk.u(0).fx();
            if (this.b.az()) {
                strFx = com.bytedance.sdk.openadsdk.gi.jk.u();
            }
            izVarU.u(strFx);
        }
        u(izVarU);
        this.pn.fx(false);
    }

    public void fx(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz izVar = this.ay;
        if (izVar != null) {
            izVar.u(z);
        }
    }

    public void nr(long j, int i) {
        this.q = true;
    }

    public NativeVideoTsView(Context context, bc bcVar, boolean z, boolean z2) {
        this(context, bcVar, z, z2, "embeded_ad", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i, int i2) {
        if (o()) {
            return;
        }
        bc bcVar = this.b;
        s sVarVm = bcVar == null ? null : bcVar.vm();
        if (sVarVm != null && i2 > 0) {
            if (!sVarVm.n()) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.b, this.k, 1);
                return;
            }
            this.bc = i;
            this.xw = i2;
            if (this.tk == null) {
                this.tk = new fx(sVarVm, this.iz, this.b, this.k, i, i2);
            }
            com.bytedance.sdk.openadsdk.n.nr.u(sVarVm.pn()).type(3).config(Bitmap.Config.RGB_565).to(this.tk);
        }
    }

    public NativeVideoTsView(Context context, bc bcVar, String str, boolean z, boolean z2) {
        this(context, bcVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(Context context, bc bcVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.u = true;
        this.n = true;
        this.nr = false;
        this.c = false;
        this.q = false;
        this.qq = false;
        this.kj = true;
        this.z = false;
        this.s = true;
        this.k = "embeded_ad";
        this.my = 50;
        this.d = true;
        this.o = new AtomicBoolean(false);
        this.ja = false;
        this.bf = com.bytedance.sdk.openadsdk.core.y.jk.nr();
        this.sx = false;
        this.pb = 50L;
        this.xg = 500L;
        this.f5389jp = true;
        this.y = false;
        this.oa = true;
        this.w = true;
        this.lf = false;
        this.bq = new AtomicBoolean(false);
        this.gc = true;
        this.p = false;
        this.kw = new AtomicBoolean(false);
        this.k = str;
        this.fx = context;
        this.b = bcVar;
        this.nr = z;
        this.z = z2;
        this.qq = z3;
        this.kj = z4;
        this.rh = new rh(com.bytedance.sdk.openadsdk.gi.x.nr(), this);
        setContentDescription("NativeVideoAdView");
        x();
        c();
        com.bytedance.sdk.openadsdk.gi.x.nr(new a("ts_video") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.v == null) {
                    com.bytedance.sdk.component.b.nr.fx unused = NativeVideoTsView.v = NativeVideoTsView.this.getKvCache();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
    public void u(long j, int i) {
        this.lf = true;
        fx.InterfaceC0154fx interfaceC0154fx = this.m;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.D_();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
    public void u() {
        if (this.m == null || !z()) {
            return;
        }
        this.m.D_();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
    public void u(long j, long j2) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar;
        if (j != j2) {
            this.lf = false;
        }
        fx.InterfaceC0154fx interfaceC0154fx = this.m;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.u(j, j2);
        }
        if (d() || (fxVar = this.pn) == null) {
            return;
        }
        fxVar.iz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if (this.lf || this.c == z) {
            return;
        }
        if (!z) {
            jk.nr().removeCallbacks(this.eh);
        }
        this.c = z;
        fx(z);
        if (this.b == null || this.pn == null) {
            return;
        }
        boolean zH = h();
        rh();
        if (zH && this.pn.bq()) {
            b(true);
            n();
            return;
        }
        if (z && !this.pn.bq() && !this.pn.my()) {
            if (this.pn.o() != null && this.pn.o().s()) {
                if (this.u) {
                    if ("ALP-AL00".equals(this.bf)) {
                        this.pn.n();
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) this.pn).iz(zH);
                    }
                    fx.InterfaceC0154fx interfaceC0154fx = this.m;
                    if (interfaceC0154fx != null) {
                        interfaceC0154fx.q_();
                        return;
                    }
                    return;
                }
                this.c = false;
                return;
            }
            if (this.u && this.pn.o() == null) {
                if (!this.bq.get()) {
                    this.bq.set(true);
                }
                this.kw.set(false);
                b();
                return;
            }
            return;
        }
        if (this.pn.o() == null || !this.pn.o().mv()) {
            return;
        }
        this.pn.iz();
        fx.InterfaceC0154fx interfaceC0154fx2 = this.m;
        if (interfaceC0154fx2 != null) {
            interfaceC0154fx2.p_();
        }
    }

    private View u(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387848);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.iz = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387756);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.x = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.pn());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387607);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.wq = tTViewStub;
        return frameLayout;
    }

    public void b(boolean z) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            fxVar.fx(z);
            com.bykv.vk.openvk.component.video.api.b.nr nrVarSx = this.pn.sx();
            if (nrVarSx != null) {
                nrVarSx.nr();
                View viewFx = nrVarSx.fx();
                if (viewFx != null) {
                    if (viewFx.getParent() != null) {
                        ((ViewGroup) viewFx.getParent()).removeView(viewFx);
                    }
                    viewFx.setVisibility(0);
                    addView(viewFx);
                    nrVarSx.u(this.b, new WeakReference<>(this.fx), false);
                }
            }
        }
    }

    public void u(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.pn.u.u(this.b) || com.bytedance.sdk.openadsdk.pn.u.x(this.b)) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.nr.u(str).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my<Bitmap> myVar) {
                Bitmap result;
                if (myVar == null || (result = myVar.getResult()) == null) {
                    return;
                }
                final Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(NativeVideoTsView.this.fx, result, 25);
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2.1
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

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.wq.getParent() != null && (this.wq.getParent() instanceof ViewGroup)) {
            this.jk = (RelativeLayout) this.wq.u();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.t = imageView;
        imageView.setImageDrawable(null);
        this.mv = (ImageView) findViewById(2114387847);
        com.bytedance.sdk.openadsdk.n.nr.u(str).to(this.t);
        u(this.t, str);
        y.u((View) this.jk, 0);
    }

    public void nr(boolean z, boolean z2) {
        this.w = z;
        this.cj = z2;
    }

    public void nr(int i) {
        if (o.fx(dw.getContext()) == 0) {
            return;
        }
        if (this.pn.o() != null) {
            if (this.pn.o().mv() && i == 2) {
                nr(false);
                rh rhVar = this.rh;
                if (rhVar != null) {
                    rhVar.removeMessages(1);
                }
                u(true);
                return;
            }
            if (this.pn.o().s() && i == 3) {
                this.u = true;
                nr(true);
                x();
                rh rhVar2 = this.rh;
                if (rhVar2 != null) {
                    rhVar2.sendEmptyMessageDelayed(1, this.pb);
                }
                u(false);
                return;
            }
        }
        if (k() || this.kw.get()) {
            return;
        }
        this.kw.set(true);
        if (zx.k(this.b) != null) {
            xg();
            com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, this.b);
            izVarU.nr(this.b.lk());
            izVarU.nr(this.iz.getWidth());
            izVarU.fx(this.iz.getHeight());
            izVarU.fx(this.b.ap());
            izVarU.u(this.h);
            izVarU.nr(my());
            izVarU.u(com.bytedance.sdk.openadsdk.gi.jk.u(this.b.oi()).b());
            u(izVarU);
        } else {
            k.nr("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        rh rhVar3 = this.rh;
        if (rhVar3 != null) {
            rhVar3.sendEmptyMessageDelayed(1, this.pb);
        }
        u(false);
    }

    public com.bykv.vk.openvk.component.video.api.b.fx u(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2, boolean z3) {
        return new com.bytedance.sdk.openadsdk.core.video.nativevideo.b(context, viewGroup, bcVar, str, z, z2, z3);
    }

    public boolean u(long j, boolean z, boolean z2) {
        boolean zU = false;
        this.iz.setVisibility(0);
        if (this.pn == null) {
            this.pn = new com.bytedance.sdk.openadsdk.core.video.nativevideo.b(this.fx, this.x, this.b, this.k, this.qq, this.kj);
            kj();
        }
        this.h = j;
        if (o()) {
            this.pn.u(false);
            if (zx.k(this.b) != null) {
                com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, this.b);
                izVarU.nr(this.b.lk());
                izVarU.nr(this.iz.getWidth());
                izVarU.fx(this.iz.getHeight());
                izVarU.fx(this.b.ap());
                izVarU.u(j);
                izVarU.nr(my());
                if (z2) {
                    this.pn.nr(izVarU);
                    return true;
                }
                zU = u(izVarU);
            }
            if (((j > 0 && !z && !z2) || (j > 0 && z && !this.z)) && (this.pn instanceof com.bytedance.sdk.openadsdk.core.video.u.u)) {
                o.u uVar = new o.u();
                uVar.u(this.pn.t());
                uVar.fx(this.pn.s());
                uVar.nr(this.pn.l());
                com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
                ((com.bytedance.sdk.openadsdk.core.video.u.u) fxVar).nr(fxVar.sx(), uVar);
            }
            return zU;
        }
        if (mv() || this.f5388a) {
            u(this.fx, 25, zx.nr(this.b));
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 1) {
            return;
        }
        gi();
    }

    public void nr() {
        if (com.bytedance.sdk.component.utils.o.fx(dw.getContext()) == 0) {
            return;
        }
        if (this.pn.o() != null) {
            if (this.pn.o().mv()) {
                nr(false);
                rh rhVar = this.rh;
                if (rhVar != null) {
                    rhVar.removeMessages(1);
                }
                u(true);
                return;
            }
            if (this.pn.o().s()) {
                this.u = true;
                nr(true);
                x();
                rh rhVar2 = this.rh;
                if (rhVar2 != null) {
                    rhVar2.sendEmptyMessageDelayed(1, this.pb);
                }
                u(false);
                return;
            }
        }
        if (k() || this.kw.get()) {
            return;
        }
        this.kw.set(true);
        if (zx.k(this.b) != null) {
            xg();
            com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, this.b);
            izVarU.nr(this.b.lk());
            izVarU.nr(this.iz.getWidth());
            izVarU.fx(this.iz.getHeight());
            izVarU.fx(this.b.ap());
            izVarU.u(this.h);
            izVarU.nr(my());
            u(izVarU);
        } else {
            k.nr("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        rh rhVar3 = this.rh;
        if (rhVar3 != null) {
            rhVar3.sendEmptyMessageDelayed(1, this.pb);
        }
        u(false);
    }

    public boolean u(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        if (this.pn == null) {
            return false;
        }
        this.d = false;
        this.pb = this.xg;
        if (this.cj) {
            izVar.nr(this.w);
        }
        return this.pn.u(izVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.b.u
    public void u(int i) {
        x();
    }

    public void u(boolean z) {
        if (this.l == null) {
            this.l = new ImageView(getContext());
            if (n.o().oa() != null) {
                this.l.setImageBitmap(n.o().oa());
            } else {
                q.u(dw.getContext(), "tt_new_play_video", this.l);
            }
            this.l.setScaleType(ImageView.ScaleType.FIT_XY);
            int iFx = y.fx(getContext(), this.my);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iFx, iFx);
            layoutParams.gravity = 17;
            this.iz.addView(this.l, layoutParams);
        }
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void u(int i, int i2) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) fxVar).u(i, i2);
        }
    }

    public void u(final Context context, final int i, String str) {
        final com.bykv.vk.openvk.component.video.api.b.nr nrVarSx;
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.pn;
        if (fxVar == null || (nrVarSx = fxVar.sx()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.nr.u(str).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my<Bitmap> myVar) {
                Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(context, myVar.getResult(), i);
                if (bitmapU == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), bitmapU);
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bykv.vk.openvk.component.video.api.b.nr nrVar = nrVarSx;
                        if (nrVar != null) {
                            nrVar.u(bitmapDrawable);
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i2, String str2, Throwable th) {
            }
        }, 4);
    }
}
