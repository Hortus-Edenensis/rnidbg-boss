package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bykv.vk.openvk.component.video.api.b.nr;
import com.bykv.vk.openvk.component.video.api.u;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.f;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.iz.fx.o;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.u.u {
    private int ay;
    private final boolean bf;
    private int cj;
    private ViewGroup d;
    private fx.u ja;
    private WeakReference<fx.nr> m;
    private int mk;
    private long nb;
    private WeakReference<fx.b> oa;
    private boolean pb;
    private int tk;
    private Map<String, Object> v;
    private WeakReference<u> w;
    private String wq;
    private boolean xg;
    private long yd;
    private long h = 0;
    private long rh = 0;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private boolean f5390jp = false;
    private boolean y = false;
    private boolean bc = true;
    private volatile boolean xw = false;
    private int wi = 0;
    private boolean su = false;
    private boolean mh = true;
    private u.InterfaceC0156u eh = new u.InterfaceC0156u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1
        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void fx(com.bykv.vk.openvk.component.video.api.u uVar) {
            b.this.nb();
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void nr(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cj();
                }
            });
            b.this.u(4);
            b.this.nr(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void nr(com.bykv.vk.openvk.component.video.api.u uVar) {
            if (uVar instanceof com.bytedance.sdk.component.l.u.u) {
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz.nr(((com.bytedance.sdk.component.l.u.u) uVar).bq());
            }
            if (!b.this.bf || t.u(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz)) {
                b.this.yd();
            }
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.oa != null && b.this.oa.get() != null) {
                        ((fx.b) b.this.oa.get()).E_();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null && (!b.this.ay() || !dw.nr().r())) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.nr();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.removeCallbacks(b.this.gi);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                        if (b.this.ay() && dw.nr().r()) {
                            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.gi();
                        } else {
                            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.nr();
                        }
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.removeCallbacks(b.this.gi);
                        b.this.su = false;
                    }
                    if (b.this.w != null && b.this.w.get() != null) {
                        ((u) b.this.w.get()).C_();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.removeCallbacks(b.this.gi);
                }
            });
            b.this.yd();
            b.this.yd = System.currentTimeMillis();
            b.this.mk();
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, final com.bykv.vk.openvk.component.video.api.fx.fx fxVar) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.4
                /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00eb  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int iU = fxVar.u();
                    int iNr = fxVar.nr();
                    b.this.u(iU, iNr, fxVar.fx(), (JSONArray) null);
                    k.nr("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!b.this.bc() || iNr == -1004) {
                        k.nr("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + iU + "," + iNr);
                        if (!b.this.b(iU, iNr) && !com.bytedance.sdk.openadsdk.core.video.fx.u.u(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz)) {
                            if (iU == 1 && (iNr == -19 || iNr == -38)) {
                                if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                                    ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.u2(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz, ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).f5395a, false);
                                }
                            }
                            if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.nr();
                            }
                            if (b.this.ja != null) {
                                b.this.ja.nr(b.this.rh, com.bykv.vk.openvk.component.video.u.pn.u.u(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).x, ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).my));
                            }
                            if (b.this.oa != null || b.this.oa.get() == null || b.this.bc()) {
                                return;
                            }
                            ((fx.b) b.this.oa.get()).u(iU, iNr);
                            return;
                        }
                        k.nr("NativeVideoController", "出错后展示结果页、、、、、、、");
                        if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.u2(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz, ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).f5395a, false);
                        }
                        b.this.fx(true);
                        b.this.jk();
                        if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                        }
                        if (b.this.ja != null) {
                        }
                        if (b.this.oa != null) {
                        }
                    }
                }
            });
            b.this.u(fxVar.u(), fxVar.fx());
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, boolean z) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.nr();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, final int i, final int i2) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.6
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nr(i, i2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2, int i3) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.q();
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.postDelayed(b.this.gi, 8000L);
                        b.this.su = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.nr();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.removeCallbacks(b.this.gi);
                    b.this.su = false;
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, final long j, final long j2) {
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).x) < 50) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).q != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).q.u(j, j2);
                    }
                    b.this.u(j, j2);
                    b.this.nr(j, j2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, JSONObject jSONObject, String str) {
            if (n.o().tk()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.bytedance.sdk.openadsdk.core.s.b.u((Context) ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).f5395a.get(), ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz, b.this.wq, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private int lf = 0;
    Runnable gi = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.u2(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz, ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).f5395a, false);
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.nr();
                b.this.fx(true);
                k.nr("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private final gi.u gc = new gi.u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.6
        @Override // com.bytedance.sdk.component.utils.gi.u
        public void u(Context context, Intent intent, boolean z, int i) {
            b.this.fx(context, i);
        }
    };
    private boolean p = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.b$9, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[k.u.values().length];
            u = iArr;
            try {
                iArr[k.u.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[k.u.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[k.u.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void C_();

        void a();

        void u(int i);
    }

    public b(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2, boolean z3) {
        this.wq = "embeded_ad";
        this.pb = false;
        this.xg = true;
        this.cj = 0;
        this.tk = 0;
        this.mk = 1;
        this.mk = o.fx(context);
        u(z);
        this.wq = str;
        try {
            this.cj = viewGroup.getWidth();
            this.tk = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.d = viewGroup;
        this.f5395a = new WeakReference<>(context);
        this.iz = bcVar;
        u(context);
        this.bf = true;
        this.pb = z2;
        this.xg = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u, com.bykv.vk.openvk.component.video.api.b.fx
    public boolean b() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u
    public boolean d() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean fx() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u, com.bykv.vk.openvk.component.video.api.b.fx
    public boolean pn() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ay() {
        return TextUtils.equals(this.wq, WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || TextUtils.equals(this.wq, "cache_splash_ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200 || i == 60008;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj() {
        iz izVar;
        this.lf++;
        if (h() && (izVar = this.pn) != null) {
            izVar.nr();
            fx.u uVar = this.ja;
            if (uVar != null) {
                uVar.u(this.rh, com.bykv.vk.openvk.component.video.u.pn.u.u(this.x, this.my));
            }
            this.rh = System.currentTimeMillis() - this.h;
            this.pn.pn(true);
            boolean zU = com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz);
            int iLf = this.iz.lf();
            boolean z = iLf <= 0;
            boolean z2 = !z && this.lf >= iLf;
            boolean zFx = jp.fx(this.iz);
            if (!zFx || z2 || zU) {
                this.pn.u2(this.iz, this.f5395a, true);
            }
            if (!this.dw.u(64) || tk() || wi()) {
                this.dw.fx(64);
                long j = this.my;
                nr(j, j);
                long j2 = this.my;
                this.x = j2;
                this.n = j2;
                o.u uVar2 = new o.u();
                uVar2.u(t());
                uVar2.fx(s());
                uVar2.nr(l());
                uVar2.iz(mv());
                com.bytedance.sdk.openadsdk.iz.nr.b.b(this.pn, uVar2);
            }
            if (!this.l && this.bq) {
                pn(this.pn, null);
            }
            this.bg = true;
            if (zU) {
                return;
            }
            if (zFx && (z || this.lf < iLf)) {
                kj();
                return;
            }
            if (!(t.u(this.iz) && (((s() / 1000) > 10L ? 1 : ((s() / 1000) == 10L ? 0 : -1)) < 0)) || this.lf >= 2) {
                return;
            }
            kj();
        }
    }

    private boolean eh() {
        bc bcVar = this.iz;
        return bcVar != null && bcVar.kw() == 1 && WifiNestConst.NestTypeConst.NEST_DRAW_AD.equals(this.wq) && this.d != null;
    }

    private void gc() {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.b(0);
            this.pn.u(false, false);
            this.pn.fx(false);
            this.pn.pn();
            this.pn.x();
        }
    }

    private void lf() {
        if (h()) {
            a(!this.bq);
            if (this.f5395a.get() instanceof Activity) {
                iz izVar = this.pn;
                if (izVar != null) {
                    izVar.nr(this.d);
                    this.pn.fx(false);
                }
                pn(1);
                WeakReference<fx.nr> weakReference = this.m;
                fx.nr nrVar = weakReference != null ? weakReference.get() : null;
                if (nrVar != null) {
                    nrVar.u(this.bq);
                }
            }
        }
    }

    private void mh() {
        com.bykv.vk.openvk.component.video.api.fx.iz izVar;
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            if (!uVar.s() || su()) {
                if (su()) {
                    this.x = n.o().gc();
                    n.o().u(-1L);
                    this.b.u(this.x);
                    this.b.nr();
                } else {
                    this.b.u(false, this.x, this.o);
                }
            } else if (this.jk || (((izVar = this.c) != null && izVar.x()) || com.bytedance.sdk.openadsdk.pn.u.nr(this.iz))) {
                bf();
            } else {
                nr(this.z);
            }
        }
        if (this.dw.u(2)) {
            o.u uVar2 = new o.u();
            uVar2.u(t());
            uVar2.fx(s());
            uVar2.nr(l());
            nr(sx(), uVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk() {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz) && !TextUtils.isEmpty(this.wq)) {
            boolean zU = this.dw.u(1024);
            long jLongValue = this.dw.nr(1).longValue();
            if (zU) {
                return;
            }
            this.dw.fx(1024);
            if (this.wq.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "embeded_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            } else if (this.wq.equals(WifiNestConst.NestTypeConst.NEST_DRAW_AD)) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, WifiNestConst.NestTypeConst.NEST_DRAW_AD, System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb() {
        iz izVar;
        if (!this.xw || (izVar = this.pn) == null || izVar.fx() == null) {
            return;
        }
        this.xw = false;
        this.pn.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.nr(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz.lk());
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.nr(b.this.cj);
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.fx(b.this.tk);
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.u((List<String>) null);
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.fx(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).iz.ap());
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.u(0L);
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.nr(b.this.bg());
                ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.u(((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).c.pn());
                b bVar = b.this;
                bVar.u(((com.bytedance.sdk.openadsdk.core.video.u.u) bVar).c);
                b.this.fx(false);
            }
        });
    }

    private boolean su() {
        return this.l && n.o().gc() > 0;
    }

    private boolean tk() {
        return this.lf > 0 && jp.fx(this.iz);
    }

    private boolean v() {
        f fVarOx;
        if (!ay()) {
            return false;
        }
        bc bcVar = this.iz;
        return bcVar == null || (fVarOx = bcVar.ox()) == null || fVarOx.u() != 0;
    }

    private boolean w() {
        com.bykv.vk.openvk.component.video.api.u bVar;
        bc bcVar = this.iz;
        if (com.bytedance.sdk.openadsdk.pn.u.nr(bcVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.nr nrVarQ = q();
            if (nrVarQ == null) {
                if (this.eh != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.pn == null);
                    this.eh.u((com.bykv.vk.openvk.component.video.api.u) null, new com.bykv.vk.openvk.component.video.api.fx.fx(60008, 10005, sb.toString()));
                }
                com.bytedance.sdk.component.utils.k.nr("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int iJk = jp.jk(this.iz);
            this.kj = gi();
            this.b = new com.bytedance.sdk.openadsdk.upie.video.lottie.u(nrVarQ, com.bytedance.sdk.openadsdk.pn.u.a(bcVar), new com.bykv.vk.openvk.component.video.u.b.b(String.valueOf(iJk), this.kj), zx.sx(bcVar));
        } else if (com.bytedance.sdk.openadsdk.pn.u.fx(bcVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.nr nrVarQ2 = q();
            if (nrVarQ2 == null) {
                if (this.eh != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.pn == null);
                    this.eh.u((com.bykv.vk.openvk.component.video.api.u) null, new com.bykv.vk.openvk.component.video.api.fx.fx(60008, 10005, sb2.toString()));
                }
                com.bytedance.sdk.component.utils.k.nr("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int iJk2 = jp.jk(this.iz);
            if (d.b() && this.c.sx() == 1) {
                bVar = new com.bytedance.sdk.component.l.nr.nr(dw.getContext(), String.valueOf(iJk2));
            } else {
                this.kj = gi();
                bVar = new com.bykv.vk.openvk.component.video.u.b.b(String.valueOf(iJk2), this.kj);
            }
            this.b = new com.bytedance.sdk.openadsdk.upie.video.lottie.nr(bVar, com.bytedance.sdk.openadsdk.pn.u.a(bcVar), nrVarQ2);
        } else {
            int iJk3 = jp.jk(this.iz);
            if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
                this.b = new com.bytedance.sdk.component.l.u.u(dw.getContext(), d(), (long) zx.x(this.iz), dw.nr().ua(), null);
            } else if (d.b() && this.c.sx() == 1) {
                this.b = new com.bytedance.sdk.component.l.nr.nr(dw.getContext(), String.valueOf(iJk3));
            } else {
                this.kj = gi();
                this.b = new com.bykv.vk.openvk.component.video.u.b.b(String.valueOf(iJk3), this.kj);
            }
        }
        return true;
    }

    private boolean wi() {
        return this.lf > 0 && t.u(this.iz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd() {
        if (!this.dw.u(2) || tk()) {
            o.u uVar = new o.u();
            if (ay()) {
                this.bc = true;
            }
            uVar.nr(this.bc);
            uVar.fx(s());
            this.dw.fx(2);
            com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn, uVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void a() {
        u(true, 3);
    }

    public boolean bc() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        return uVar != null && uVar.mv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean c() {
        return this.su;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean dw() {
        return this.bc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void iz() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.fx();
        }
        if ((!this.dw.u(64) || tk()) && this.dw.u(2)) {
            o.u uVar2 = new o.u();
            uVar2.u(t());
            uVar2.fx(s());
            uVar2.nr(l());
            u(this.pn, uVar2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void jk() {
        nr(s() == 0 ? -2 : -1);
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.pn();
            this.b = null;
        }
        bc bcVar = this.iz;
        int iLf = bcVar == null ? 2 : bcVar.lf();
        boolean z = iLf > 0 && this.lf == iLf;
        if (!jp.fx(this.iz) || z) {
            try {
                this.pn.u2(this.iz, this.f5395a, true);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.k.nr("NativeVideoController", e.getMessage());
            }
        }
        rh rhVar = this.u;
        if (rhVar != null) {
            rhVar.removeCallbacksAndMessages(null);
        }
        List<Runnable> list = this.t;
        if (list != null) {
            list.clear();
        }
        oa();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u
    public void jp() {
        if (this.f5395a == null) {
            return;
        }
        this.qq = com.bytedance.sdk.openadsdk.iz.nr.b.u();
        com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.kj;
        if (nrVar != null) {
            nrVar.nr(this.qq);
        }
        this.dw.fx(1);
        com.bytedance.sdk.openadsdk.iz.nr.b.u(this.iz, this.pn, this.c, this.bc, this.qq);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public int k() {
        return com.bykv.vk.openvk.component.video.u.pn.u.u(this.n, this.my);
    }

    public void kj() {
        if (com.bytedance.sdk.component.utils.o.fx(dw.getContext()) == 0) {
            return;
        }
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u();
        }
        fx(false);
        if (this.b != null) {
            this.dw.u();
            jp();
            this.b.u();
            yd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u, com.bykv.vk.openvk.component.video.api.b.fx
    public long l() {
        if (o() == null) {
            return 0L;
        }
        return o().my();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public int mv() {
        if (o() == null) {
            return 0;
        }
        return o().o();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void n() {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u();
        }
        iz izVar2 = this.pn;
        if (izVar2 != null) {
            izVar2.qq();
        }
        mh();
    }

    public void oa() {
        if (this.p) {
            this.p = false;
            try {
                gi.u(this.gc);
            } catch (Throwable unused) {
            }
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.nr q() {
        iz izVar;
        WeakReference<Context> weakReference = this.f5395a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        if ((this.f5395a.get().getResources().getConfiguration().orientation == 1 || com.bytedance.sdk.openadsdk.pn.u.u(this.iz)) && (izVar = this.pn) != null) {
            return izVar.o();
        }
        return null;
    }

    public boolean qq() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        return uVar == null || uVar.a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void x() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.fx();
        }
    }

    public void xw() {
        if (this.p || !this.mh) {
            return;
        }
        this.p = true;
        gi.u(this.gc, dw.getContext().getApplicationContext());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u
    public Map<String, Object> y() {
        return this.v;
    }

    private void fx(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        if (izVar == null) {
            u("model is null");
            return;
        }
        if (this.b != null) {
            bc bcVar = this.iz;
            if (bcVar != null) {
                izVar.b(String.valueOf(jp.t(bcVar)));
            }
            izVar.b(0);
            this.b.u(izVar);
        }
        this.h = System.currentTimeMillis();
        if (!TextUtils.isEmpty(izVar.my())) {
            iz izVar2 = this.pn;
            if (izVar2 != null) {
                izVar2.pn(8);
                this.pn.pn(0);
            }
            boolean zFx = jp.fx(this.iz);
            iz izVar3 = this.pn;
            boolean zNr = izVar3 != null ? wq.nr(izVar3.u, 50, 9) : true;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dw.u();
                    b.this.jp();
                    b.this.h = System.currentTimeMillis();
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).pn.b(0);
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).b.u(true, ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).x, ((com.bytedance.sdk.openadsdk.core.video.u.u) b.this).o);
                }
            };
            if (zFx && !zNr) {
                nr(runnable);
                n(true);
                WeakReference<u> weakReference = this.w;
                if (weakReference != null && weakReference.get() != null) {
                    this.w.get().a();
                }
            } else {
                u(runnable);
            }
        } else {
            u("url is null");
        }
        if (this.l) {
            xw();
        }
    }

    public void pn(int i) {
        if (h()) {
            boolean z = i == 0 || i == 8;
            Context context = this.f5395a.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    private View nr(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387651);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(q.fx(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        View viewNr = new com.bytedance.sdk.openadsdk.res.layout.video.b().nr(context);
        viewNr.setId(2114387688);
        viewNr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(viewNr);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387626);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        q.u(context, "tt_play_movebar_textpage", imageView2);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, q.x(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387653);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fFx = y.fx(context, 1.0f);
        gradientDrawable.setCornerRadius(fFx);
        int iFx = y.fx(context, 2.0f);
        gradientDrawable.setSize(-1, iFx);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fFx);
        gradientDrawable2.setSize(-1, iFx);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fFx);
        gradientDrawable3.setSize(-1, iFx);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        View tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.iz());
        ViewGroup.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.nr());
        ViewGroup.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.x());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387828);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(int i) {
        bc bcVar;
        int iFx = com.bytedance.sdk.component.utils.o.fx(dw.getContext());
        if (iFx == 0) {
            iz();
            this.k = true;
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.u2(this.iz, this.f5395a, false);
            }
        }
        if (iFx != 4 && iFx != 0) {
            iz izVar2 = this.pn;
            if (izVar2 != null) {
                izVar2.u();
            }
            iz();
            this.k = true;
            this.f5390jp = false;
            iz izVar3 = this.pn;
            if (izVar3 != null && (bcVar = this.iz) != null) {
                return izVar3.u(i, zx.k(bcVar), this.xg);
            }
        } else if (iFx == 4) {
            this.k = false;
            iz izVar4 = this.pn;
            if (izVar4 != null) {
                izVar4.bq();
            }
        }
        return true;
    }

    public void b(int i) {
        this.ay = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void b(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        if (this.bq) {
            a(false);
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.nr(this.d);
            }
            pn(1);
            return;
        }
        u(1);
        u(true, 3);
    }

    public void iz(boolean z) {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u();
        }
        iz izVar2 = this.pn;
        if (izVar2 != null && z) {
            izVar2.qq();
        }
        mh();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void pn(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        u(nrVar, view, false);
    }

    public void u(bc bcVar) {
        this.iz = bcVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void pn(boolean z) {
        this.mh = z;
    }

    public void u(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar) {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u(uVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void b(boolean z) {
        this.bc = z;
    }

    public void u(final NativeVideoTsView.u uVar) {
        iz izVar;
        if (!this.l || (izVar = this.pn) == null) {
            return;
        }
        izVar.u(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
            public void u(View view, int i) {
                NativeVideoTsView.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u(view, i);
                }
            }
        });
    }

    private boolean iz(int i) {
        iz izVar = this.pn;
        return izVar != null && izVar.fx(i);
    }

    public void u(mv mvVar) {
        iz izVar;
        if (!this.l || (izVar = this.pn) == null) {
            return;
        }
        izVar.u(mvVar);
    }

    public void u(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.cj = i;
        this.tk = i2;
    }

    @SuppressLint({"InflateParams"})
    private void u(Context context) {
        EnumSet<nr.u> enumSetNoneOf = EnumSet.noneOf(nr.u.class);
        enumSetNoneOf.add(nr.u.hideCloseBtn);
        enumSetNoneOf.add(nr.u.hideBackBtn);
        try {
            iz izVarU = u(context, enumSetNoneOf);
            this.pn = izVarU;
            if (izVarU != null) {
                izVarU.u((com.bykv.vk.openvk.component.video.api.b.u) this);
                this.pn.u((u.InterfaceC0273u) this);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr("NativeVideoController", th.getMessage());
        }
    }

    private boolean fx(int i, int i2) {
        return i < i2 && eh();
    }

    public iz u(Context context, EnumSet<nr.u> enumSet) {
        View layoutVideoDetail;
        if (this.l) {
            layoutVideoDetail = nr(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.l) {
            return new iz(context, view, true, enumSet, this.iz, this, pb(), null);
        }
        return new pn(context, view, true, enumSet, this.iz, this, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void fx(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.a();
        }
        u(1);
        u(true, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(Context context, int i) {
        nr(context, i);
        if (i == 4) {
            this.k = false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(fx.b bVar) {
        this.oa = new WeakReference<>(bVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean u(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        izVar.my();
        if (TextUtils.isEmpty(izVar.my())) {
            u("url is null");
            com.bytedance.sdk.component.utils.k.nr("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.c = izVar;
        this.o = izVar.t();
        this.x = izVar.jk();
        if (izVar.jk() > 0) {
            long jJk = izVar.jk();
            this.x = jJk;
            long j = this.n;
            if (j > jJk) {
                jJk = j;
            }
            this.n = jJk;
        }
        iz izVar2 = this.pn;
        if (izVar2 != null) {
            izVar2.u();
            if (this.lf == 0) {
                this.pn.x();
            }
            this.pn.fx(izVar.n(), izVar.a());
            this.pn.fx(this.d);
            this.pn.u(izVar.n(), izVar.a());
        }
        try {
            if (this.b == null) {
                if (!w()) {
                    u("create video error");
                    return false;
                }
                this.b.u(this.eh);
            }
            z();
            this.rh = 0L;
            fx(izVar);
            return true;
        } catch (Throwable th) {
            u(th.getMessage());
            com.bytedance.sdk.component.utils.k.nr("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    public b(Context context, ViewGroup viewGroup, bc bcVar, String str, boolean z, boolean z2) {
        this.wq = "embeded_ad";
        this.pb = false;
        this.xg = true;
        this.cj = 0;
        this.tk = 0;
        this.mk = 1;
        this.mk = com.bytedance.sdk.component.utils.o.fx(context);
        try {
            this.cj = viewGroup.getWidth();
            this.tk = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.d = viewGroup;
        this.wq = str;
        this.f5395a = new WeakReference<>(context);
        this.iz = bcVar;
        u(context);
        this.bf = true;
        this.pb = z;
        this.xg = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(fx.nr nrVar) {
        this.m = new WeakReference<>(nrVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(fx.u uVar) {
        this.ja = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.fx();
        }
        if ((!this.dw.u(64) || tk()) && this.dw.u(2)) {
            o.u uVar2 = new o.u();
            uVar2.u(t());
            uVar2.fx(s());
            uVar2.nr(l());
            if (map != null) {
                uVar2.u(map);
            }
            u(this.pn, uVar2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(long j) {
        this.x = j;
        long j2 = this.n;
        if (j2 > j) {
            j = j2;
        }
        this.n = j;
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u();
        }
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.u(true, this.x, this.o);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(boolean z, int i) {
        if (this.l) {
            u(1);
        }
        long jS = s();
        if ((!this.dw.u(64) || tk()) && this.dw.u(1) && jS > 0) {
            if (z) {
                o.u uVar = new o.u();
                uVar.u(t());
                uVar.fx(jS);
                uVar.nr(l());
                uVar.pn(i);
                uVar.iz(mv());
                this.dw.fx(32);
                com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn, uVar, this.v, !this.dw.u(2) ? 1 : 0);
            } else {
                o.u uVar2 = new o.u();
                uVar2.u(t());
                uVar2.fx(jS);
                uVar2.nr(l());
                u(this.pn, uVar2);
            }
        }
        jk();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr(Map<String, Object> map) {
        this.v = map;
    }

    public void nr(int i, int i2) {
        com.bykv.vk.openvk.component.video.api.u uVar;
        ViewGroup viewGroup;
        int iRound;
        int iRound2;
        ViewGroup.LayoutParams layoutParams;
        try {
            WeakReference<Context> weakReference = this.f5395a;
            if (weakReference != null && weakReference.get() != null && q() != null && (uVar = this.b) != null && (viewGroup = this.d) != null && viewGroup != null) {
                if (i < 0 && i2 < 0) {
                    i = uVar.t();
                    i2 = this.b.l();
                }
                int width = this.d.getWidth();
                int height = this.d.getHeight();
                if (width > 0 && height > 0 && i2 > 0 && i > 0) {
                    if (i == i2) {
                        iRound2 = width > height ? height : width;
                        iRound = iRound2;
                    } else if (i > i2) {
                        iRound = (int) Math.round((((double) width) * 1.0d) / ((double) ((i * 1.0f) / i2)));
                        iRound2 = width;
                    } else if (v()) {
                        iRound = 0;
                        iRound2 = 0;
                    } else {
                        iRound2 = (int) Math.round(((double) (height * 1.0f)) / ((double) ((i2 * 1.0f) / i)));
                        iRound = height;
                    }
                    if (iRound > height || iRound <= 0) {
                        iRound = height;
                    }
                    if (nr(i, i2, iRound2, width)) {
                        iRound2 = width;
                    }
                    if (v()) {
                        u(i, i2, width, height);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iRound2, iRound);
                    layoutParams2.addRule(13);
                    Object objQ = q();
                    if (objQ instanceof TextureView) {
                        ((TextureView) objQ).setLayoutParams(layoutParams2);
                    } else if (objQ instanceof UpieVideoView) {
                        ((UpieVideoView) objQ).setLayoutParams(layoutParams2);
                    } else if (objQ instanceof SurfaceView) {
                        ((SurfaceView) objQ).setLayoutParams(layoutParams2);
                    }
                    if (fx(i, i2) && (layoutParams = this.d.getLayoutParams()) != null) {
                        layoutParams.height = iRound;
                        layoutParams.width = iRound2;
                        this.d.setLayoutParams(layoutParams);
                        iz izVar = this.pn;
                        if (izVar != null) {
                            izVar.u(layoutParams.width, layoutParams.height);
                        }
                    }
                    u(width, height, iRound2, iRound);
                    return;
                }
                return;
            }
            WeakReference<Context> weakReference2 = this.f5395a;
            if (weakReference2 != null) {
                weakReference2.get();
            }
            q();
        } catch (Throwable unused) {
        }
    }

    private void u(float f, float f2, float f3, float f4) {
        boolean zJk;
        if (dw.nr().t()) {
            WeakReference<u> weakReference = this.w;
            View view = null;
            u uVar = weakReference != null ? weakReference.get() : null;
            if (uVar instanceof NativeVideoTsView) {
                NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) uVar;
                zJk = nativeVideoTsView.jk();
                Object parent = nativeVideoTsView.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                }
            } else {
                zJk = true;
            }
            View view2 = view;
            if (zJk) {
                s.u().u(this.iz, f, f2, f3, f4, view2);
            }
        }
    }

    private void u(int i, int i2, int i3, int i4) {
        Matrix matrix;
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        try {
            Object objQ = q();
            if (objQ instanceof TextureView) {
                matrix = ((TextureView) objQ).getMatrix();
            } else if (objQ instanceof UpieVideoView) {
                matrix = ((UpieVideoView) objQ).getMatrix();
            } else {
                matrix = objQ instanceof SurfaceView ? ((SurfaceView) objQ).getMatrix() : null;
            }
            float fMax = Math.max(f3, f6);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i3 - i) / 2, (i4 - i2) / 2);
            matrix.preScale(f2 / f, f5 / f4);
            matrix.postScale(fMax, fMax, i3 / 2, i4 / 2);
            if (objQ instanceof TextureView) {
                ((TextureView) objQ).setTransform(matrix);
                ((TextureView) objQ).postInvalidate();
            } else if (objQ instanceof UpieVideoView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((UpieVideoView) objQ).setAnimationMatrix(matrix);
                }
                ((UpieVideoView) objQ).postInvalidate();
            } else if (objQ instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) objQ).setAnimationMatrix(matrix);
                }
                ((SurfaceView) objQ).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    private boolean nr(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !fx(i, i2)) || i3 <= 0;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void nr(com.bykv.vk.openvk.component.video.api.b.nr nrVar, int i) {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.iz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(long j, long j2) {
        this.x = j;
        this.my = j2;
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u(j, j2);
            this.pn.nr(com.bykv.vk.openvk.component.video.u.pn.u.u(j, j2));
        }
        try {
            fx.u uVar = this.ja;
            if (uVar != null) {
                uVar.u(j, j2);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void nr(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        nr(nrVar, view, false, false);
    }

    public void nr(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view, boolean z, boolean z2) {
        if (h()) {
            a(!this.bq);
            if (this.f5395a.get() instanceof Activity) {
                if (this.bq) {
                    pn(z ? 8 : 0);
                    iz izVar = this.pn;
                    if (izVar != null) {
                        izVar.u(this.d);
                        this.pn.fx(false);
                    }
                } else {
                    pn(1);
                    iz izVar2 = this.pn;
                    if (izVar2 != null) {
                        izVar2.nr(this.d);
                        this.pn.fx(false);
                    }
                }
                WeakReference<fx.nr> weakReference = this.m;
                fx.nr nrVar2 = weakReference != null ? weakReference.get() : null;
                if (nrVar2 != null) {
                    nrVar2.u(this.bq);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        if (this.b == null || !h()) {
            return;
        }
        if (this.b.mv()) {
            iz();
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.nr(true, false);
                this.pn.iz();
                return;
            }
            return;
        }
        if (!this.b.s()) {
            iz izVar2 = this.pn;
            if (izVar2 != null) {
                izVar2.fx(this.d);
            }
            u(this.x);
            iz izVar3 = this.pn;
            if (izVar3 != null) {
                izVar3.nr(false, false);
                return;
            }
            return;
        }
        iz(false);
        iz izVar4 = this.pn;
        if (izVar4 != null) {
            izVar4.nr(false, false);
        }
    }

    private void nr(Context context, int i) {
        if (!h() || context == null || this.mk == i) {
            return;
        }
        this.mk = i;
        if (i != 4 && i != 0) {
            this.f5390jp = false;
        }
        if (!this.f5390jp && !bq() && this.pb) {
            jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.x(2);
                }
            });
        }
        WeakReference<u> weakReference = this.w;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.w.get().u(this.mk);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, int i) {
        if (this.b == null) {
            return;
        }
        u(this.nb, iz(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, int i, boolean z) {
        if (h()) {
            long j = (long) (((((long) i) * r0) * 1.0f) / 100.0f);
            if (this.my > 0) {
                this.nb = (int) j;
            } else {
                this.nb = 0L;
            }
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.u(this.nb);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        this.c = izVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr() {
        if (this.b != null) {
            fx(false);
            this.b.u();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view, boolean z, boolean z2) {
        if (this.l) {
            iz();
        }
        if (this.pn == null) {
            return;
        }
        if (z && !this.l && !qq()) {
            this.pn.nr(!bc(), false);
            this.pn.u(z2, true, false);
        }
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null && uVar.mv()) {
            this.pn.iz();
            this.pn.pn();
        } else {
            this.pn.iz();
        }
    }

    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view, boolean z) {
        lf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u() {
        if (com.bytedance.sdk.component.utils.o.fx(dw.getContext()) == 0) {
            return;
        }
        this.xw = true;
        if (this.b == null) {
            jk();
            nb();
        } else {
            jk();
        }
    }

    private void u(long j, boolean z) {
        if (this.b == null) {
            return;
        }
        if (z) {
            gc();
        }
        this.b.u(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.nr
    public void u(k.u uVar, String str) {
        int i = AnonymousClass9.u[uVar.ordinal()];
        if (i == 1) {
            iz();
            return;
        }
        if (i == 2) {
            u(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            n();
            this.k = false;
            this.f5390jp = true;
        }
    }

    public void u(Context context, int i) {
        nr(context, i);
        if (i == 4) {
            this.k = false;
            jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.n();
                }
            });
        }
    }

    public void u(u uVar) {
        this.w = new WeakReference<>(uVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
            if (this.yd <= 0) {
                this.yd = System.currentTimeMillis();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.yd;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(mv()));
                jSONObject.putOpt("buffer_time", Long.valueOf(l()));
            } catch (Exception unused) {
            }
            if (!this.dw.u(512)) {
                this.dw.fx(512);
                if (this.wq.equals("embeded_ad")) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "embeded_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
                } else if (this.wq.equals(WifiNestConst.NestTypeConst.NEST_DRAW_AD)) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, WifiNestConst.NestTypeConst.NEST_DRAW_AD, jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
                if (com.bytedance.sdk.openadsdk.core.live.nr.u().u(this.iz)) {
                    com.bytedance.sdk.openadsdk.core.live.nr.u().u("tobsdk_livesdk_live_window_duration_v2", this.iz, jCurrentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.fx.u.u("tobsdk_livesdk_live_window_duration_v2", this.iz, jCurrentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
            if (this.wq.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "embeded_ad", i, str, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            } else if (this.wq.equals(WifiNestConst.NestTypeConst.NEST_DRAW_AD)) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, WifiNestConst.NestTypeConst.NEST_DRAW_AD, i, str, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            }
        }
    }
}
