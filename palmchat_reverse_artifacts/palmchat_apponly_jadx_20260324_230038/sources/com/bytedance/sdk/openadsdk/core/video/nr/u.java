package com.bytedance.sdk.openadsdk.core.video.nr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bykv.vk.openvk.component.video.api.b.nr;
import com.bykv.vk.openvk.component.video.api.u;
import com.bykv.vk.openvk.component.video.u.b.b;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.iz;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoPlayLayoutForLive;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends com.bytedance.sdk.openadsdk.core.video.u.u {
    private fx.u bc;
    private WeakReference<fx.nr> cj;
    protected ViewGroup d;
    private int eh;
    public long gi;
    private long lf;
    private long mh;
    private int nb;
    private InterfaceC0302u oa;
    private final int tk;
    private int v;
    protected com.bytedance.sdk.openadsdk.core.nr.u wq;
    private final String yd;
    protected long h = 0;
    protected boolean rh = false;
    protected boolean ja = false;
    protected Map<String, Object> bf = null;
    private final AtomicInteger xg = new AtomicInteger(0);
    private final AtomicInteger m = new AtomicInteger(0);

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private long f5394jp = 0;
    private long y = 0;
    private final Runnable xw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.1
        @Override // java.lang.Runnable
        public void run() {
            if (u.this.bc != null) {
                u.this.bc.u();
            }
            if (u.this.oa != null) {
                u.this.oa.nr();
            }
        }
    };
    private boolean w = false;
    private boolean wi = false;
    private boolean su = true;
    private boolean ay = false;
    u.InterfaceC0156u pb = new u.InterfaceC0156u() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2
        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void nr(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.iz(false);
                }
            });
            u.this.u(4);
            u.this.nr(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void nr(com.bykv.vk.openvk.component.video.api.u uVar) {
            if (uVar instanceof com.bytedance.sdk.component.l.u.u) {
                ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.nr(((com.bytedance.sdk.component.l.u.u) uVar).bq());
            }
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.removeCallbacks(u.this.xw);
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn != null) {
                        u.this.pn(0);
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.nr();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn != null) {
                        u.this.pn(0);
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.nr();
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.removeCallbacks(u.this.xw);
                        u.this.wi = false;
                    }
                }
            });
            u.this.u(j, false);
            u.this.mh = System.currentTimeMillis();
            u.this.su();
            if (u.this.oa != null) {
                u.this.oa.fx();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(final com.bykv.vk.openvk.component.video.api.u uVar, final com.bykv.vk.openvk.component.video.api.fx.fx fxVar) {
            if (fxVar == null) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.u uVar2;
                    com.bykv.vk.openvk.component.video.api.u uVar3;
                    int iBq;
                    int iU = fxVar.u();
                    if (iU == 308 && (uVar2 = ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).b) != null && uVar2 != (uVar3 = uVar) && (uVar3 instanceof b) && ((iBq = ((b) uVar3).bq()) == 200 || iBq == 203)) {
                        k.nr("BaseVideoController", "ignore errorCode:" + iU + " state:" + iBq);
                        return;
                    }
                    u.this.u(iU, fxVar.nr(), fxVar.fx(), (JSONArray) null);
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.removeCallbacks(u.this.xw);
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn != null) {
                        u.this.pn(0);
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.nr();
                    }
                    if (u.this.bc != null) {
                        u.this.bc.nr(u.this.y, com.bykv.vk.openvk.component.video.u.pn.u.u(((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).x, u.this.gi));
                    }
                    if (u.this.oa != null) {
                        u.this.oa.u(iU, fxVar.fx());
                    }
                }
            });
            u.this.u(fxVar.u(), fxVar.fx());
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, boolean z) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.5
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.removeCallbacks(u.this.xw);
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn != null) {
                        u.this.pn(0);
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.nr();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2) {
            u.this.v = i;
            u.this.eh = i2;
            u.this.mh();
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2, int i3) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn != null) {
                        u.this.pn(8);
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.q();
                        u.this.oa();
                        u.this.wi = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn != null) {
                        u.this.pn(0);
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.nr();
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.removeCallbacks(u.this.xw);
                        u.this.wi = false;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void u(final com.bykv.vk.openvk.component.video.api.u uVar, final long j, final long j2) {
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).x) < 50) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).q != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).q.u(j, j2);
                    }
                    u.this.nr(j, j2);
                    u.this.u(j, j2);
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.de() <= 0 || j2 <= ((long) ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.de()) * 1000 || j < ((long) ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.de()) * 1000 || ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).s) {
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).s = true;
                    uVar.b();
                    u.this.iz(false);
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
            com.bytedance.sdk.openadsdk.core.s.b.u((Context) ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).f5395a.get(), ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz, u.this.yd, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
        public void fx(com.bykv.vk.openvk.component.video.api.u uVar) {
        }
    };
    private final gi.u gc = new gi.u() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.3
        @Override // com.bytedance.sdk.component.utils.gi.u
        public void u(Context context, Intent intent, boolean z, int i) {
            u.this.u(context, i);
        }
    };
    private boolean mk = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nr.u$8, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass8 {
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

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0302u {
        void fx();

        void nr();

        void u();

        void u(int i, String str);

        void u(long j, long j2);
    }

    public u(Context context, ViewGroup viewGroup, bc bcVar, com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this.nb = 1;
        this.nb = o.fx(context);
        this.d = viewGroup;
        this.f5395a = new WeakReference<>(context);
        this.iz = bcVar;
        this.wq = uVar;
        u(context);
        this.tk = jp.t(this.iz);
        this.yd = jp.nr(this.iz);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void b(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u
    public boolean d() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean dw() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void pn(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
    }

    public abstract int q();

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(fx.b bVar) {
    }

    public boolean v_() {
        bc bcVar = this.iz;
        return bcVar == null || bcVar.ba() == 100.0f;
    }

    private void ay() {
        InterfaceC0302u interfaceC0302u = this.oa;
        if (interfaceC0302u != null) {
            interfaceC0302u.u();
        }
    }

    private com.bykv.vk.openvk.component.video.api.renderview.nr eh() {
        iz izVar;
        WeakReference<Context> weakReference = this.f5395a;
        if (weakReference == null || weakReference.get() == null || (izVar = this.pn) == null) {
            return null;
        }
        return izVar.o();
    }

    private void lf() {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.b(0);
            this.pn.u(false, false);
            this.pn.fx(false);
            this.pn.pn();
            pn(8);
            this.pn.x();
        }
    }

    private boolean qq() {
        com.bykv.vk.openvk.component.video.api.u bVar;
        bc bcVar = this.iz;
        if (com.bytedance.sdk.openadsdk.pn.u.nr(bcVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.nr nrVarEh = eh();
            if (nrVarEh == null) {
                if (this.pb != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.pn == null);
                    this.pb.u((com.bykv.vk.openvk.component.video.api.u) null, new com.bykv.vk.openvk.component.video.api.fx.fx(60008, 10005, sb.toString()));
                }
                com.bytedance.sdk.component.utils.k.nr("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int iJk = jp.jk(this.iz);
            this.kj = gi();
            this.b = new com.bytedance.sdk.openadsdk.upie.video.lottie.u(nrVarEh, com.bytedance.sdk.openadsdk.pn.u.a(bcVar), new b(String.valueOf(iJk), this.kj), zx.sx(bcVar));
        } else if (com.bytedance.sdk.openadsdk.pn.u.fx(bcVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.nr nrVarEh2 = eh();
            if (nrVarEh2 == null) {
                if (this.pb != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.pn == null);
                    this.pb.u((com.bykv.vk.openvk.component.video.api.u) null, new com.bykv.vk.openvk.component.video.api.fx.fx(60008, 10005, sb2.toString()));
                }
                com.bytedance.sdk.component.utils.k.nr("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int iJk2 = jp.jk(this.iz);
            if (d.b() && this.c.sx() == 1) {
                bVar = new com.bytedance.sdk.component.l.nr.nr(dw.getContext(), String.valueOf(iJk2));
            } else {
                this.kj = gi();
                bVar = new b(String.valueOf(iJk2), this.kj);
            }
            this.b = new com.bytedance.sdk.openadsdk.upie.video.lottie.nr(bVar, com.bytedance.sdk.openadsdk.pn.u.a(bcVar), nrVarEh2);
        } else {
            int iJk3 = jp.jk(this.iz);
            if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
                this.b = new com.bytedance.sdk.component.l.u.u(dw.getContext(), d(), (long) zx.x(this.iz), dw.nr().ua(), null);
            } else if (d.b() && this.c.sx() == 1) {
                this.b = new com.bytedance.sdk.component.l.nr.nr(dw.getContext(), String.valueOf(iJk3));
            } else {
                this.kj = gi();
                this.b = new b(String.valueOf(iJk3), this.kj);
            }
        }
        return true;
    }

    private boolean v() throws Throwable {
        bc bcVar;
        WeakReference<Context> weakReference = this.f5395a;
        return weakReference == null || weakReference.get() == null || eh() == null || this.b == null || (bcVar = this.iz) == null || tk.iz(bcVar) != null || tk.x(this.iz) != null || this.iz.za() == 1;
    }

    private void yd() {
        if (!this.dw.u(64) || fx() || b()) {
            this.dw.fx(64);
            long j = this.gi;
            nr(j, j);
            long j2 = this.gi;
            this.x = j2;
            this.n = j2;
            xg();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void a() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.pn();
            this.b = null;
        }
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.a();
        }
        this.u.removeCallbacks(this.xw);
        this.u.removeCallbacksAndMessages(null);
        this.bc = null;
        this.oa = null;
    }

    public void bc() {
        bc bcVar = this.iz;
        if (bcVar != null) {
            new u.C0284u().nr("auto_replay").u(jp.nr(bcVar)).pn(this.iz.lk()).b(this.iz.ap()).u(new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.4
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject) throws JSONException {
                    com.bykv.vk.openvk.component.video.api.fx.b bVarKj;
                    JSONObject jSONObject2 = new JSONObject();
                    if (t.u(((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).c != null && (bVarKj = ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).c.kj()) != null && bVarKj.x() > 0.0d) {
                        jSONObject2.put("start", bVarKj.x());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean c() {
        return this.wi;
    }

    public boolean cj() {
        return this.ay;
    }

    public void iz(boolean z) {
        if (h() && this.pn != null) {
            this.u.removeCallbacks(this.xw);
            pn(0);
            this.pn.nr();
            this.y = System.currentTimeMillis() - this.f5394jp;
            this.pn.pn(true);
            if (jp.n(this.iz)) {
                this.pn.u2(this.iz, this.f5395a, true);
            } else {
                this.pn.z();
            }
            yd();
            fx.u uVar = this.bc;
            if (uVar != null) {
                uVar.u(this.y, com.bykv.vk.openvk.component.video.u.pn.u.u(this.x, this.gi));
            }
            ay();
            this.bg = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void jk() {
        nr(-1);
        a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public int k() {
        return com.bykv.vk.openvk.component.video.u.pn.u.u(this.n, this.gi);
    }

    public void mh() {
        this.u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.7
            @Override // java.lang.Runnable
            public void run() {
                if (bg.b(((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz) || !u.this.v_()) {
                    u uVar = u.this;
                    uVar.u(uVar.v, u.this.eh);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz) && ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.sv() == 2 && u.this.v_()) {
                    return;
                }
                if (!u.this.v_()) {
                    u uVar2 = u.this;
                    uVar2.u(uVar2.v, u.this.eh);
                    return;
                }
                if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz != null && ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.kw() == 0) {
                    u uVar3 = u.this;
                    uVar3.b(uVar3.v, u.this.eh);
                } else if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz == null || ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).iz.kw() != 2) {
                    u uVar4 = u.this;
                    uVar4.fx(uVar4.v, u.this.eh);
                } else {
                    u uVar5 = u.this;
                    uVar5.nr(uVar5.v, u.this.eh);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public int mv() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar == null) {
            return 0;
        }
        return uVar.o();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void n() {
        com.bykv.vk.openvk.component.video.api.fx.iz izVar;
        iz izVar2 = this.pn;
        if (izVar2 != null) {
            izVar2.u();
            this.pn.bq();
            this.pn.qq();
        }
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            if (!uVar.s()) {
                this.b.u(false, this.x, this.o);
            } else if (this.jk || (((izVar = this.c) != null && izVar.x()) || com.bytedance.sdk.openadsdk.pn.u.nr(this.iz))) {
                bf();
            } else {
                nr(this.z);
            }
        }
        if (!this.dw.u(64) || fx() || b()) {
            if (this.dw.u(2) || t.u(this.iz)) {
                m();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void oa() {
        int iTs;
        int iQ = q();
        if (iQ == 2 || iQ == 1) {
            iTs = dw.nr().ts() * 1000;
        } else {
            iTs = 5;
            if (iQ != 5) {
                if (iQ == 3) {
                    iTs = dw.nr().n(String.valueOf(this.tk));
                }
            }
        }
        this.u.removeCallbacks(this.xw);
        this.u.postDelayed(this.xw, iTs);
    }

    public void su() {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
            int iQ = q();
            boolean zU = this.dw.u(1024);
            long jLongValue = this.dw.nr(1).longValue();
            if (zU) {
                return;
            }
            this.dw.fx(1024);
            if (iQ == 1) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "rewarded_video", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            } else if (iQ == 2) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "fullscreen_interstitial_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            }
        }
    }

    public boolean tk() {
        return this.b.a();
    }

    public void w() {
        if (!this.dw.u(64) || fx() || b()) {
            if (this.dw.u(2) || t.u(this.iz)) {
                m();
            }
        }
    }

    public boolean wi() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        return uVar != null && uVar.mv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void x() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.fx();
        }
    }

    public int xw() {
        return t.u(this.iz) ? this.m.get() : this.xg.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u
    public Map<String, Object> y() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.bf;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : jp.u(this.h, this.iz, o()).entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
        return map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u, com.bykv.vk.openvk.component.video.api.b.fx
    public boolean pn() {
        if (t.u(this.iz)) {
            return ((double) this.m.get()) < ((double) zx.o(this.iz).x());
        }
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(int i) {
        bc bcVar;
        int iFx = o.fx(dw.getContext());
        if (iFx != 4 && iFx != 0) {
            iz();
            this.k = true;
            this.w = false;
            iz izVar = this.pn;
            if (izVar != null && (bcVar = this.iz) != null) {
                return izVar.u(i, zx.k(bcVar), true);
            }
        } else if (iFx == 4) {
            this.k = false;
            iz izVar2 = this.pn;
            if (izVar2 != null) {
                izVar2.bq();
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.u.u, com.bykv.vk.openvk.component.video.api.b.fx
    public boolean b() {
        if (t.u(this.iz)) {
            return ((double) this.m.get()) <= ((double) zx.o(this.iz).x());
        }
        return super.b();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean fx() {
        return this.xg.get() > 0;
    }

    private void fx(com.bykv.vk.openvk.component.video.api.fx.iz izVar) throws Exception {
        if (izVar == null) {
            u("model is null");
            return;
        }
        this.c = izVar;
        if (this.b != null) {
            bc bcVar = this.iz;
            if (bcVar != null) {
                izVar.b(String.valueOf(jp.t(bcVar)));
            }
            izVar.b(1);
            this.b.u(izVar);
        }
        this.f5394jp = System.currentTimeMillis();
        if (!TextUtils.isEmpty(izVar.my())) {
            this.pn.pn(8);
            this.pn.pn(0);
            u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.5
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).b == null) {
                        u.this.u("play video error proxy empty");
                        return;
                    }
                    if (u.this.dw.b(1)) {
                        u.this.u("multi play_start");
                        return;
                    }
                    u.this.dw.u();
                    u.this.jp();
                    u.this.f5394jp = System.currentTimeMillis();
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).pn.b(0);
                    ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).b.u(true, ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).x, ((com.bytedance.sdk.openadsdk.core.video.u.u) u.this).o);
                }
            });
            return;
        }
        u("url is null");
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void pn(boolean z) {
        this.su = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        bc bcVar;
        try {
            WeakReference<Context> weakReference = this.f5395a;
            if (weakReference != null && weakReference.get() != null && eh() != null && this.b != null && (bcVar = this.iz) != null) {
                boolean z = bcVar.sv() == 1;
                int[] iArrNr = y.nr(dw.getContext());
                u(iArrNr[0], iArrNr[1], i, i2, z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr() {
        if (this.b != null) {
            if (!pn()) {
                this.xg.getAndAdd(1);
                bc();
            }
            this.m.getAndAdd(1);
            this.dw.u();
            jp();
            u(0L, true);
            fx(false);
            this.b.u();
        }
    }

    public void pn(int i) {
        Object obj;
        if (this.f5395a == null || !com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz) || this.f5395a.get() == null || (obj = (Context) this.f5395a.get()) == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.n.nr)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.n.nr) obj).u(i == 0);
    }

    @SuppressLint({"InflateParams"})
    private void u(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(nr.u.class);
        enumSetNoneOf.add(nr.u.hideCloseBtn);
        enumSetNoneOf.add(nr.u.hideBackBtn);
        iz izVar = new iz(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, enumSetNoneOf, this.iz, this, this.wq);
        this.pn = izVar;
        izVar.u((com.bykv.vk.openvk.component.video.api.b.u) this);
    }

    public void b(int i) {
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

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void iz() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.fx();
        }
        if (!this.dw.u(64) || fx() || b()) {
            if (this.dw.u(2) || t.u(this.iz)) {
                fx((Map<String, Object>) null);
            }
        }
    }

    public void u(long j, boolean z) {
        if (this.dw.u(2)) {
            return;
        }
        this.h = j;
        jk(z);
        this.ja = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(int i, int i2) {
        try {
            if (v()) {
                return;
            }
            int[] iArrNr = y.nr(dw.getContext());
            boolean z = false;
            boolean z2 = this.iz.sv() == 1;
            float f = iArrNr[0];
            float f2 = iArrNr[1];
            float f3 = i;
            float f4 = i2;
            if (z2) {
                if (f3 > f4) {
                    u(f, f2, f3, f4, true);
                    return;
                }
            } else if (f3 < f4) {
                u(f, f2, f3, f4, false);
                return;
            }
            float f5 = f3 / f4;
            float f6 = f / f2;
            if (z2) {
                if (f6 < 0.5625f && f5 == 0.5625f) {
                    f3 = (9.0f * f2) / 16.0f;
                    f4 = f2;
                    z = true;
                }
            } else if (f6 > 1.7777778f && f5 == 1.7777778f) {
                f4 = (9.0f * f) / 16.0f;
                f3 = f;
                z = true;
            }
            if (z) {
                f = f3;
                f2 = f4;
            }
            int i3 = (int) f;
            int i4 = (int) f2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            layoutParams.addRule(13);
            Object objEh = eh();
            if ((objEh instanceof TextureView) || (objEh instanceof UpieVideoView)) {
                if (objEh instanceof TextureView) {
                    ((TextureView) objEh).setLayoutParams(layoutParams);
                } else {
                    ((UpieVideoView) objEh).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i4;
                    layoutParams2.width = i3;
                    this.d.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr(Map<String, Object> map) {
        this.bf = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i, int i2) {
        try {
            WeakReference<Context> weakReference = this.f5395a;
            if (weakReference != null && weakReference.get() != null && eh() != null && this.b != null && this.iz != null) {
                int[] iArrNr = y.nr(dw.getContext());
                boolean z = this.iz.sv() == 1;
                float f = iArrNr[0];
                float f2 = iArrNr[1];
                float f3 = i;
                float f4 = i2;
                if (z) {
                    if (f3 > f4) {
                        u(f, f2, f3, f4, true);
                        return;
                    }
                    f2 = (f4 * f) / f3;
                } else {
                    if (f3 < f4) {
                        u(f, f2, f3, f4, false);
                        return;
                    }
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (this.d != null) {
                    Object objEh = eh();
                    if (objEh instanceof TextureView) {
                        ((TextureView) objEh).setLayoutParams(layoutParams);
                    } else if (objEh instanceof UpieVideoView) {
                        ((UpieVideoView) objEh).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    private boolean iz(int i) {
        return this.pn.fx(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void b(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        if (this.bq) {
            a(false);
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.nr(this.d);
            }
            b(1);
            return;
        }
        u(1);
        u(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean u(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        if (izVar == null) {
            u("model is null");
            return false;
        }
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null && uVar.s()) {
            this.b.nr();
            return true;
        }
        this.c = izVar;
        izVar.my();
        if (TextUtils.isEmpty(izVar.my())) {
            com.bytedance.sdk.component.utils.k.nr("BaseVideoController", "No video info");
            u("url is null");
            return false;
        }
        this.rh = (izVar.my().startsWith(HttpHost.DEFAULT_SCHEME_NAME) || com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) ? false : true;
        this.o = izVar.t();
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
            pn(8);
            this.pn.x();
            this.pn.fx(izVar.n(), izVar.a());
            this.pn.fx(this.d);
        }
        try {
            if (this.b == null) {
                if (!qq()) {
                    u("create video error");
                    return false;
                }
                this.b.u(this.pb);
            }
            z();
            this.y = 0L;
            fx(izVar);
            return true;
        } catch (Throwable th) {
            u(th.getMessage());
            com.bytedance.sdk.component.utils.k.nr("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
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
        this.gi = j2;
        this.pn.u(j, j2);
        int iU = com.bykv.vk.openvk.component.video.u.pn.u.u(j, j2);
        if (!fx() && !b()) {
            this.pn.nr(iU);
        } else {
            this.pn.nr(100);
        }
        try {
            fx.u uVar = this.bc;
            if (uVar != null) {
                uVar.u(j, j2);
            }
            InterfaceC0302u interfaceC0302u = this.oa;
            if (interfaceC0302u != null) {
                interfaceC0302u.u(j, j2);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("BaseVideoController", "onProgressUpdate error: ", th);
        }
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

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void nr(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        nr(nrVar, view, false, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(fx.nr nrVar) {
        this.cj = new WeakReference<>(nrVar);
    }

    public void nr(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view, boolean z, boolean z2) {
        if (h()) {
            a(!this.bq);
            if (this.f5395a.get() instanceof Activity) {
                if (this.bq) {
                    b(z ? 8 : 0);
                    iz izVar = this.pn;
                    if (izVar != null) {
                        izVar.u(this.d);
                        this.pn.fx(false);
                    }
                } else {
                    b(1);
                    iz izVar2 = this.pn;
                    if (izVar2 != null) {
                        izVar2.nr(this.d);
                        this.pn.fx(false);
                    }
                }
                WeakReference<fx.nr> weakReference = this.cj;
                fx.nr nrVar2 = weakReference != null ? weakReference.get() : null;
                if (nrVar2 != null) {
                    nrVar2.u(this.bq);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(fx.u uVar) {
        this.bc = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.fx();
        }
        if (!this.dw.u(64) || fx() || b()) {
            if (this.dw.u(2) || t.u(this.iz)) {
                fx(map);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(long j) {
        this.x = Math.max(j, o().bg());
        this.n = Math.max(this.n, t());
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.u();
        }
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.u(false, this.x, this.o);
            this.b.u(this.x);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(boolean z, int i) {
        nr(i);
        a();
    }

    private void nr(long j, boolean z) {
        if (this.b == null) {
            return;
        }
        if (z) {
            lf();
        }
        this.b.u(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (eh() != null && this.b != null && (viewGroup = this.d) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.d.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = f * (height / (f2 * 1.0f));
                } else {
                    height = f2 * (width / (f * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object objEh = eh();
                if (objEh instanceof TextureView) {
                    ((TextureView) objEh).setLayoutParams(layoutParams);
                } else if (objEh instanceof UpieVideoView) {
                    ((UpieVideoView) objEh).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr(com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        this.c = izVar;
    }

    private void u(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = zx.b(this.iz);
                f4 = zx.fx(this.iz);
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            Object objEh = eh();
            if (objEh instanceof TextureView) {
                ((TextureView) objEh).setLayoutParams(layoutParams);
            } else if (objEh instanceof UpieVideoView) {
                ((UpieVideoView) objEh).setLayoutParams(layoutParams);
            }
            this.ay = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view) {
        if (this.b == null || !h()) {
            return;
        }
        if (this.b.mv()) {
            iz();
            this.pn.nr(true, false);
            this.pn.iz();
            return;
        }
        if (!this.b.s()) {
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.fx(this.d);
            }
            u(this.x);
            iz izVar2 = this.pn;
            if (izVar2 != null) {
                izVar2.nr(false, false);
                return;
            }
            return;
        }
        n();
        iz izVar3 = this.pn;
        if (izVar3 != null) {
            izVar3.nr(false, false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, int i) {
        if (this.b == null) {
            return;
        }
        nr(this.lf, iz(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, int i, boolean z) {
        if (h()) {
            long j = (long) (((((long) i) * r0) * 1.0f) / 100.0f);
            if (this.gi > 0) {
                this.lf = (int) j;
            } else {
                this.lf = 0L;
            }
            iz izVar = this.pn;
            if (izVar != null) {
                izVar.u(this.lf);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, View view, boolean z, boolean z2) {
        if (this.l) {
            iz();
        }
        if (z && !this.l && !tk()) {
            this.pn.nr(!wi(), false);
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

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u() {
        iz izVar = this.pn;
        if (izVar != null) {
            izVar.pn();
            this.pn.u();
        }
        iz izVar2 = this.pn;
        if (izVar2 != null) {
            izVar2.qq();
        }
        u(-1L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.nr
    public void u(k.u uVar, String str) {
        int i = AnonymousClass8.u[uVar.ordinal()];
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
            this.w = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, int i) {
        if (h() && this.nb != i) {
            if (!this.w) {
                jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nr.u.6
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.x(2);
                    }
                });
            }
            this.nb = i;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.iz)) {
            int iQ = q();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mh;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(mv()));
                jSONObject.putOpt("buffer_time", Long.valueOf(l()));
            } catch (Exception unused) {
            }
            if (!this.dw.u(512)) {
                this.dw.fx(512);
                if (iQ == 1) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "rewarded_video", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
                } else if (iQ == 2) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "fullscreen_interstitial_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
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
            int iQ = q();
            if (iQ == 1) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "rewarded_video", i, str, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            } else if (iQ == 2) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.iz, "fullscreen_interstitial_ad", i, str, com.bytedance.sdk.openadsdk.iz.nr.b.u(this.pn));
            }
        }
    }

    public void u(InterfaceC0302u interfaceC0302u) {
        this.oa = interfaceC0302u;
    }
}
