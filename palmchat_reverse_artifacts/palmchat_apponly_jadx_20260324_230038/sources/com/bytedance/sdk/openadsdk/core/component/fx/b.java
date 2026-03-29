package com.bytedance.sdk.openadsdk.core.component.fx;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.common.C;
import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.live.EcMallWebView;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.iz.fx.o;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.my.fx.nr implements fx.b, fx.InterfaceC0154fx, com.bykv.vk.openvk.component.video.api.nr.u, u.InterfaceC0273u, LazeLayout.u<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.u<NativeVideoTsView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5217a;
    private int[] b;
    int fx;
    private com.bytedance.sdk.openadsdk.core.z.fx iz;
    private LazeLayout jk;
    private volatile boolean k;
    private WeakReference<View> l;
    private com.bytedance.sdk.openadsdk.c.u.nr.u.nr mv;
    private bc my;
    private com.bytedance.sdk.openadsdk.c.u.nr.nr.u n;
    com.bytedance.sdk.openadsdk.my.fx.fx.nr nr;
    private UpieImageView o;
    private com.bytedance.sdk.openadsdk.c.u.nr.u.u pn;
    private volatile int s;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.u sx;
    private volatile WeakReference<NativeVideoTsView> t;
    protected com.bytedance.sdk.openadsdk.core.multipro.nr.u u;
    private int x;

    public b(Context context, bc bcVar, int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(new com.bytedance.sdk.openadsdk.core.z.fx(context, bcVar, i, nrVar, true));
        this.b = null;
        this.f5217a = false;
        this.jk = null;
        this.t = null;
        this.l = null;
        this.sx = new com.bytedance.sdk.openadsdk.qq.u.nr.u.u(null) { // from class: com.bytedance.sdk.openadsdk.core.component.fx.b.4
            @Override // com.bytedance.sdk.openadsdk.qq.u.nr.u.u
            public void nr(View view, mv mvVar) {
                if (b.this.t == null || b.this.t.get() == null) {
                    return;
                }
                ((NativeVideoTsView) b.this.t.get()).t();
            }

            @Override // com.bytedance.sdk.openadsdk.qq.u.nr.u.u
            public void u(mv mvVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.qq.u.nr.u.u
            public void u(View view, mv mvVar) {
                if (b.this.t == null || b.this.t.get() == null) {
                    return;
                }
                ((NativeVideoTsView) b.this.t.get()).t();
            }
        };
        com.bytedance.sdk.openadsdk.core.z.fx fxVar = (com.bytedance.sdk.openadsdk.core.z.fx) dw();
        this.iz = fxVar;
        fxVar.qq().u(this);
        this.fx = i;
        this.nr = nrVar;
        this.u = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
        this.my = bcVar;
        int iT = jp.t(bcVar);
        this.x = iT;
        u(iT);
        this.iz.u(this.sx);
        if (context == null || n_() || !com.bytedance.sdk.openadsdk.pn.u.n(bcVar)) {
            return;
        }
        this.o = new UpieImageView(context, com.bytedance.sdk.openadsdk.pn.u.a(bcVar), null);
    }

    private int[] kj() {
        if (this.iz.kj() == null) {
            return null;
        }
        if (this.iz.kj().ol() == 166 && m.u(this.iz.kj())) {
            return new int[]{m.l(this.iz.kj()), m.mv(this.iz.kj())};
        }
        if (this.iz.kj().oi() == 1 && this.iz.kj().uk() == 1 && zx.my(this.iz.kj()) != null) {
            return zx.my(this.iz.kj()).jk();
        }
        if (zx.k(this.iz.kj()) != null) {
            return zx.k(this.iz.kj()).jk();
        }
        return null;
    }

    private View qq() {
        View view;
        WeakReference<View> weakReference = this.l;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.iz.getContext(), this.iz.kj(), this.fx == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(xg.u(this.my));
        this.l = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    private boolean z() {
        if (this.iz.kj() == null || this.mv == null) {
            return false;
        }
        int iP = this.iz.kj().p();
        return iP == 1 || iP == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void D_() {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.pn(this);
        }
        if (!z() || this.k) {
            return;
        }
        this.mv.u(0);
        this.k = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
    public void E_() {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.u(this);
        }
    }

    public NativeVideoTsView iz() {
        if (this.t != null) {
            return this.t.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr, com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public Map<String, Object> k() {
        Map<String, Object> mapK = this.iz.k();
        if (this.iz.kj() == null || this.iz.kj().ol() != 166) {
            return mapK;
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz.kj())) {
            int iB = m.b(this.iz.kj());
            int iPn = m.pn(this.iz.kj());
            if (mapK == null) {
                mapK = new HashMap<>();
            }
            mapK.put("live_author_follower_count", Integer.valueOf(iB));
            mapK.put("live_watch_count", Integer.valueOf(iPn));
        }
        return mapK;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk
    public double k_() {
        if (t.u(this.iz.kj())) {
            return 0.0d;
        }
        return zx.x(this.iz.kj());
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk
    public int l() {
        com.bytedance.sdk.openadsdk.core.z.fx fxVar = this.iz;
        if (fxVar != null) {
            bc bcVarKj = fxVar.kj();
            int iBg = this.iz.bg();
            if (com.bytedance.sdk.openadsdk.pn.u.n(bcVarKj) && (iBg == 5 || iBg == 15)) {
                return bcVarKj.zu().get(0).nr();
            }
        }
        try {
            if (this.b == null) {
                this.b = kj();
            }
            int[] iArr = this.b;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return 1280;
        } catch (Throwable th) {
            k.u("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    public int l_() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
    public boolean m_() {
        return this.f5217a;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk
    public int mv() {
        com.bytedance.sdk.openadsdk.core.z.fx fxVar = this.iz;
        if (fxVar != null) {
            bc bcVarKj = fxVar.kj();
            int iBg = this.iz.bg();
            if (com.bytedance.sdk.openadsdk.pn.u.n(bcVarKj) && (iBg == 5 || iBg == 15)) {
                return bcVarKj.zu().get(0).fx();
            }
        }
        try {
            if (this.b == null) {
                this.b = kj();
            }
            int[] iArr = this.b;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            k.u("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    public int n() {
        return this.x;
    }

    public boolean n_() {
        return bc.nr(this.iz.kj());
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void o_() {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.nr(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void p_() {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.fx(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void q_() {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.b(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
    public com.bytedance.sdk.openadsdk.core.multipro.nr.u r_() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk
    public com.bytedance.sdk.openadsdk.c.u.nr.nr.u s() {
        if (!bc.u(this.iz.kj())) {
            return null;
        }
        if (this.n == null) {
            this.n = new com.bytedance.sdk.openadsdk.c.u.nr.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.b.3
                private long nr = 0;

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void b() {
                    com.bytedance.sdk.openadsdk.core.s.b.u(b.this.iz.kj(), jp.nr(b.this.iz.kj()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (zx.k(b.this.iz.kj()) != null) {
                        iz izVarU = zx.u(4, b.this.iz.kj());
                        izVarU.u("material_meta", b.this.iz.kj());
                        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = b.this.iz.kj().tm();
                        izVarU.u("ad_slot", Integer.valueOf(nrVarTm != null ? nrVarTm.bq() : 0));
                        izVarU.pn(-1);
                        com.bytedance.sdk.openadsdk.iz.nr.b.u(b.this.iz.kj(), (com.bykv.vk.openvk.component.video.api.nr.u) b.this, izVarU, true, com.bytedance.sdk.openadsdk.iz.nr.b.u());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void fx() {
                    if (this.nr == 0) {
                        this.nr = SystemClock.elapsedRealtime();
                    }
                    long jK_ = ((long) b.this.k_()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.nr) - jK_;
                    long j = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    o.u uVar = new o.u();
                    uVar.u(jK_);
                    uVar.fx(jK_);
                    uVar.nr(j);
                    uVar.iz(0);
                    uVar.u(true);
                    com.bytedance.sdk.openadsdk.iz.nr.b.b(b.this, uVar);
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void nr() {
                    this.nr = SystemClock.elapsedRealtime();
                    o.u uVar = new o.u();
                    uVar.nr(true);
                    uVar.u(true);
                    com.bytedance.sdk.openadsdk.iz.nr.b.u(b.this, uVar);
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public String u() {
                    if (b.this.iz.kj() == null || b.this.iz.kj().tk() != 1 || zx.k(b.this.iz.kj()) == null) {
                        return null;
                    }
                    if (!b.this.f5217a) {
                        b.this.f5217a = true;
                    }
                    return zx.u(b.this.iz.kj());
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void nr(long j) {
                    if (this.nr == 0) {
                        this.nr = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.nr) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    o.u uVar = new o.u();
                    uVar.u(j);
                    uVar.fx(((long) b.this.k_()) * 1000);
                    uVar.nr(j2);
                    uVar.u(true);
                    com.bytedance.sdk.openadsdk.iz.nr.b.nr(b.this, uVar);
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void u(long j) {
                    if (this.nr == 0) {
                        this.nr = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.nr) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    o.u uVar = new o.u();
                    uVar.u(j);
                    uVar.fx(((long) b.this.k_()) * 1000);
                    uVar.nr(j2);
                    uVar.u(true);
                    com.bytedance.sdk.openadsdk.iz.nr.b.u(b.this, uVar, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void fx(long j) {
                    if (this.nr == 0) {
                        this.nr = SystemClock.elapsedRealtime();
                    }
                    long jK_ = ((long) b.this.k_()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.nr) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    o.u uVar = new o.u();
                    uVar.u(j);
                    uVar.fx(jK_);
                    uVar.nr(j2);
                    uVar.pn(0);
                    uVar.iz(0);
                    uVar.u(true);
                    com.bytedance.sdk.openadsdk.iz.nr.b.u(b.this, uVar, null, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void u(int i, int i2) {
                    HashMap map = new HashMap();
                    map.put("creative_id", b.this.iz.kj().lk());
                    map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
                    map.put("extra_error_code", Integer.valueOf(i2));
                    map.put("is_customer", 1);
                    com.bykv.vk.openvk.component.video.api.fx.b bVarK = zx.k(b.this.iz.kj());
                    if (bVarK != null) {
                        map.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, Long.valueOf(bVarK.pn()));
                        map.put("video_resolution", bVarK.a());
                    }
                    com.bytedance.sdk.openadsdk.core.s.b.fx(b.this.iz.kj(), jp.nr(b.this.iz.kj()), "play_start_error", map);
                }

                @Override // com.bytedance.sdk.openadsdk.c.u.nr.nr.u
                public void u(long j, int i, int i2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.nr == 0) {
                        this.nr = jElapsedRealtime;
                    }
                    long j2 = jElapsedRealtime - this.nr;
                    long jK_ = ((long) b.this.k_()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    o.u uVar = new o.u();
                    uVar.nr(j3);
                    uVar.fx(jK_);
                    uVar.u(j);
                    uVar.u(i);
                    uVar.nr(i2);
                    uVar.u(true);
                    com.bytedance.sdk.openadsdk.iz.nr.b.u((com.bykv.vk.openvk.component.video.api.nr.u) b.this, uVar, "customer error", i3, false);
                }
            };
        }
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr, com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void fx() {
        NativeVideoTsView nativeVideoTsView;
        if (this.t != null && (nativeVideoTsView = this.t.get()) != null) {
            nativeVideoTsView.bq();
        }
        LazeLayout lazeLayout = this.jk;
        if (lazeLayout != null) {
            lazeLayout.u();
        }
        UpieImageView upieImageView = this.o;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(null);
        }
        super.fx();
    }

    private void nr(long j, long j2) {
        int i;
        if (z() && !this.k) {
            int iP = this.iz.kj().p();
            long j3 = iP == 1 ? C.DEFAULT_SEEK_FORWARD_INCREMENT_MS : iP == 2 ? 30000L : 0L;
            if (j2 <= j3) {
                i = (int) ((j2 - j) / 1000);
            } else {
                i = (int) ((j3 - j) / 1000);
            }
            if (i < 0) {
                i = 0;
            }
            if (i == this.s) {
                return;
            }
            this.s = i;
            if (this.s == 0) {
                this.k = true;
            }
            this.mv.u(this.s);
        }
    }

    public NativeVideoTsView u(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (z) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.iz.getContext(), this.iz.kj());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.iz.getContext(), this.iz.kj(), false, false, jp.nr(this.fx), false, false);
        }
        this.t = new WeakReference<>(nativeVideoTsView);
        this.iz.u(this.t);
        this.iz.pn();
        return nativeVideoTsView;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr, com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public View u() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsViewNr = null;
        if (this.iz.kj() == null || this.iz.getContext() == null) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.live.pn.b.u(this.iz.kj())) {
            return qq();
        }
        Context context = this.iz.getContext();
        if (n_()) {
            if (x.u() && dw.nr().jc().nr) {
                if (this.t != null && (nativeVideoTsView = this.t.get()) != null) {
                    nativeVideoTsView.setNativeRenderAd(true);
                    return nativeVideoTsView;
                }
                this.jk = new LazeLayout(context, this, this);
            } else {
                try {
                    nativeVideoTsViewNr = nr(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewNr != null) {
                    u(nativeVideoTsViewNr);
                }
                return nativeVideoTsViewNr;
            }
        } else if (this.o != null) {
            com.bytedance.sdk.openadsdk.core.z.fx fxVar = this.iz;
            if (fxVar != null && fxVar.qq() != null) {
                this.iz.qq().u(this.o);
            }
            return this.o;
        }
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.iz.kj()).u(this.fx).nr(this.x);
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b nr() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.u
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView nr(Context context) {
        NativeVideoTsView nativeVideoTsViewU = u(false);
        nativeVideoTsViewU.setVideoAdClickListenerTTNativeAd(this);
        nativeVideoTsViewU.setAdCreativeClickListener(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.b.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
            public void u(View view, int i) {
                if (b.this.iz.qq() != null) {
                    b.this.iz.qq().u(view, i);
                }
            }
        });
        n.o().u(-1L);
        nativeVideoTsViewU.setControllerStatusCallBack(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.b.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
            public void u(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = b.this.u;
                if (uVar != null) {
                    uVar.u = z;
                    uVar.pn = j;
                    uVar.iz = j2;
                    uVar.x = j3;
                    uVar.b = z2;
                    uVar.n = z3;
                }
            }
        });
        nativeVideoTsViewU.setVideoAdLoadListener(this);
        nativeVideoTsViewU.setVideoAdInteractionListener(this);
        if (5 == this.fx) {
            nativeVideoTsViewU.setIsAutoPlay(this.iz.gi() ? this.nr.pn() : this.iz.z());
        } else {
            nativeVideoTsViewU.setIsAutoPlay(this.iz.z());
        }
        nativeVideoTsViewU.setIsQuiet(this.my.jn() == 1);
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = this.iz.qq().u();
        if (fxVarU != null) {
            fxVarU.u(this);
        }
        return nativeVideoTsViewU;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.u
    public void u(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.u(0L, true, false);
        }
    }

    private void u(int i) {
        int iIz = dw.nr().iz(i);
        if (3 == iIz) {
            this.iz.nr(false);
            this.iz.u(false);
            return;
        }
        if (1 == iIz && com.bytedance.sdk.component.utils.o.b(this.iz.getContext())) {
            this.iz.nr(false);
        } else if (2 == iIz) {
            if (!com.bytedance.sdk.component.utils.o.pn(this.iz.getContext()) && !com.bytedance.sdk.component.utils.o.b(this.iz.getContext()) && !com.bytedance.sdk.component.utils.o.iz(this.iz.getContext())) {
                return;
            } else {
                this.iz.nr(false);
            }
        } else if (4 == iIz) {
            this.iz.nr(true);
            return;
        } else {
            if (5 != iIz) {
                return;
            }
            if (!com.bytedance.sdk.component.utils.o.b(this.iz.getContext()) && !com.bytedance.sdk.component.utils.o.iz(this.iz.getContext())) {
                return;
            }
        }
        this.iz.u(true);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk
    public void u(com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar) {
        this.pn = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.jk
    public void u(com.bytedance.sdk.openadsdk.c.u.nr.u.nr nrVar) {
        this.mv = nrVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.b
    public void u(int i, int i2) {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.u(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void u(long j, long j2) {
        com.bytedance.sdk.openadsdk.c.u.nr.u.u uVar = this.pn;
        if (uVar != null) {
            uVar.u(j, j2);
        }
        nr(j, j2);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar, com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.u uVar2) {
        View viewU;
        try {
            u(viewGroup, (List<View>) null, list, list2, list3, (View) null, uVar);
            if (uVar2 != null) {
                View viewFindViewById = viewGroup.findViewById(uVar2.nr());
                if (viewFindViewById != null && x() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(x());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = y.fx(viewGroup.getContext(), 38.0f);
                        layoutParams.height = y.fx(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(x());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(uVar2.u());
                if (frameLayout == null || (viewU = u()) == null) {
                    return;
                }
                y.n(viewU);
                frameLayout.removeAllViews();
                frameLayout.addView(viewU, -1, -1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        com.bytedance.sdk.openadsdk.core.z.fx fxVar = this.iz;
        if (fxVar != null) {
            fxVar.u(nrVar);
        }
    }
}
