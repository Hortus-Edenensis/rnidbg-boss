package com.bytedance.sdk.openadsdk.core.component.splash.presentation;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.component.splash.n;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.kw;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.core.kj.nb;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.nr.u.fx.fx;
import com.bytedance.sdk.openadsdk.core.nr.u.u.u;
import com.bytedance.sdk.openadsdk.core.q.fx;
import com.bytedance.sdk.openadsdk.core.s.pn;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationSplashManagerDefault;
import com.bytedance.sdk.openadsdk.my.fx.u.fx;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.ll7;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.my.fx.nr.nr implements rh.u, TsView.u {
    protected SoftReference<fx> b;
    private Context bc;
    protected boolean c;
    protected com.bytedance.sdk.openadsdk.core.gi.u.nr d;
    protected boolean dw;
    private b<a, x> f;
    protected com.bytedance.sdk.openadsdk.core.l.nr.fx fx;
    private boolean gc;
    private pn ge;
    protected boolean h;
    protected View.OnTouchListener iz;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.b ja;
    protected x kj;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr kw;
    private com.bytedance.sdk.openadsdk.b.u.nr.u.nr lf;
    protected com.bytedance.sdk.openadsdk.b.u.nr.u.u n;
    private Activity nb;
    protected bc nr;
    protected iz o;
    private float oa;
    private n p;
    protected com.bytedance.sdk.openadsdk.core.nr.u pn;
    protected com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n sx;
    protected TsView u;
    private float w;
    protected nr x;
    private String xw;
    protected com.bytedance.sdk.openadsdk.core.q.u.nr y;
    private boolean yd;
    private com.bytedance.sdk.openadsdk.core.component.splash.u.u za;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AtomicBoolean f5270a = new AtomicBoolean(false);
    protected final Map<String, Object> jk = new HashMap();
    private Double cj = null;
    private boolean tk = false;
    private boolean wi = false;
    protected boolean t = false;
    protected int l = 3;
    protected int mv = -1;
    private final rh su = new rh(Looper.getMainLooper(), this);
    protected boolean s = false;
    protected boolean k = false;
    protected long my = 0;
    protected Map<String, Object> bg = new HashMap();
    protected AtomicBoolean bq = new AtomicBoolean(false);
    protected boolean q = true;
    protected boolean qq = false;
    private com.bytedance.sdk.openadsdk.core.component.splash.u mh = new com.bytedance.sdk.openadsdk.core.component.splash.u();
    private boolean ay = false;
    private long v = 0;
    private long eh = 5;
    protected AtomicBoolean z = new AtomicBoolean(false);
    protected AtomicBoolean gi = new AtomicBoolean(false);
    protected AtomicBoolean rh = new AtomicBoolean(false);
    private boolean mk = true;
    protected AtomicBoolean bf = new AtomicBoolean(false);
    protected int wq = -1;
    protected int pb = -1;
    protected final AtomicBoolean xg = new AtomicBoolean(false);
    private final AtomicBoolean tm = new AtomicBoolean(false);
    protected final AtomicInteger m = new AtomicInteger(0);

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr f5271jp = null;
    private boolean rv = false;
    private int ob = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void w_();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0256u implements u.nr {
        bc u;

        public C0256u(bc bcVar) {
            this.u = bcVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
        public void nr() {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_enter_foreground", System.currentTimeMillis());
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
        public void u() {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_enter_background", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.yd) {
            this.q = false;
            return;
        }
        if (this.ay) {
            return;
        }
        this.ay = true;
        com.bytedance.sdk.openadsdk.core.component.splash.u uVar = this.mh;
        if (uVar != null) {
            uVar.u();
            this.mh = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar = this.ja;
        if (bVar != null) {
            bVar.jk();
        }
        this.n = null;
        this.fx = null;
        this.nb = null;
    }

    private void gi() {
        boolean z = false;
        this.gc = false;
        n nVar = new n();
        this.p = nVar;
        nVar.u(this.bc, this.nr);
        if (!this.mh.fx() && my()) {
            z = true;
        }
        if (z) {
            SoftReference<fx> softReference = this.b;
            if (softReference == null) {
                this.p.u(this.xw, this.mv, this.mh, null);
            } else {
                this.p.u(this.xw, this.mv, this.mh, softReference.get());
            }
            this.c = true;
            this.p.u(2);
            com.bytedance.sdk.openadsdk.core.component.splash.u uVar = this.mh;
            if (uVar != null) {
                uVar.u(this);
            }
        }
    }

    private boolean my() {
        return (!nb.u(this.nr) || this.s || this.k || this.dw) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void bg() {
        if (!this.f5270a.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.component.splash.iz.u(2, this.nr, this.xw, 0);
        }
        TsView tsView = this.u;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.iz bq() {
        return new MediationSplashManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public Map<String, Object> dw() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.rh rhVar = bcVar.zu().get(0);
        if (rhVar == null) {
            return this.nr.sj();
        }
        if (!rhVar.iz()) {
            return this.nr.sj();
        }
        String strU = rhVar.u();
        Map<String, Object> mapSj = this.nr.sj();
        mapSj.put(WfConstant.EXTRA_KEY_IMAGE_URL, strU);
        return mapSj;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public View k() {
        return null;
    }

    public void kj() {
        com.bytedance.sdk.openadsdk.core.q.u.nr nrVar = this.y;
        if (nrVar != null) {
            nrVar.u(z(), com.bytedance.sdk.openadsdk.core.q.b.nr.CLICK);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public View o() {
        n nVar;
        if (this.c && (nVar = this.p) != null) {
            return nVar.u();
        }
        return null;
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.q.u.nr nrVar = this.y;
        if (nrVar != null) {
            nrVar.u(z(), com.bytedance.sdk.openadsdk.core.q.b.nr.CREATE);
        }
    }

    public void qq() {
        com.bytedance.sdk.openadsdk.core.q.u.nr nrVar = this.y;
        if (nrVar != null) {
            nrVar.u(z(), com.bytedance.sdk.openadsdk.core.q.b.nr.START);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public int sx() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.qf();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void u(ViewGroup viewGroup) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public String z() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return null;
        }
        return bcVar.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        TsView tsView = this.u;
        if (tsView != null) {
            tsView.u(this.nr.uq(), this.pn);
            if (tk.u(this.nr) == 1) {
                l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz(boolean z) {
        this.fx = com.bytedance.sdk.openadsdk.core.l.n.u(this.bc, this.nr, this.xw, false);
        x(z);
        com.bytedance.sdk.openadsdk.core.nr.u uVar = this.pn;
        if (uVar != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        TsView tsView = this.u;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i = 0; i < this.u.getChildCount(); i++) {
                View childAt = this.u.getChildAt(i);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.u.removeView(childAt);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final boolean z) {
        final String strLk = this.nr.lk();
        this.fx.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.3
            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void fx(long j, long j2, String str, String str2) {
                SoftReference<fx> softReference = u.this.b;
                if (softReference != null && softReference.get() != null) {
                    u.this.b.get().fx(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                u.C0239u.u(strLk, 4, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void nr(long j, long j2, String str, String str2) {
                SoftReference<fx> softReference = u.this.b;
                if (softReference != null && softReference.get() != null) {
                    u.this.b.get().nr(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                u.C0239u.u(strLk, 2, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u() {
                SoftReference<fx> softReference = u.this.b;
                if (softReference != null && softReference.get() != null) {
                    u.this.b.get().u();
                }
                if (z) {
                    u.C0239u.u(strLk, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, long j2, String str, String str2) {
                SoftReference<fx> softReference = u.this.b;
                if (softReference != null && softReference.get() != null) {
                    u.this.b.get().u(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                u.C0239u.u(strLk, 3, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, String str, String str2) {
                SoftReference<fx> softReference = u.this.b;
                if (softReference != null && softReference.get() != null) {
                    u.this.b.get().u(j, str, str2);
                }
                if (z) {
                    u.C0239u.u(strLk, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(String str, String str2) {
                SoftReference<fx> softReference = u.this.b;
                if (softReference != null && softReference.get() != null) {
                    u.this.b.get().u(str, str2);
                }
                if (z) {
                    u.C0239u.u(strLk, 6, 100);
                }
            }
        });
    }

    public void jk() {
        nr(1);
        if (!this.k) {
            this.k = true;
            this.t = true;
            if (!TextUtils.isEmpty(this.nr.ap())) {
                com.bytedance.sdk.openadsdk.core.s.b.u(this.my > 0 ? System.currentTimeMillis() - this.my : 0L, this.nr);
            }
            gi();
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.my, this.nr);
            fx(false);
            s();
        }
        com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar = this.n;
        if (uVar != null) {
            uVar.u(this, 1);
        }
    }

    public void l() {
        mk mkVarPq;
        bc bcVar = this.nr;
        if (bcVar == null || (mkVarPq = bcVar.pq()) == null || mkVarPq.a() != 5) {
            return;
        }
        final int iK = mkVarPq.k();
        final mk.u uVarS = mkVarPq.s();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                u uVar;
                com.bytedance.sdk.openadsdk.core.nr.u uVar2;
                TsView tsView;
                int iB = y.b(u.this.bc, view.getWidth());
                int iB2 = y.b(u.this.bc, view.getHeight());
                int iB3 = y.b(u.this.bc, motionEvent.getX());
                int iB4 = y.b(u.this.bc, motionEvent.getY());
                boolean z = iB3 >= uVarS.u() && iB4 >= uVarS.fx() && iB - iB3 >= uVarS.nr() && iB2 - iB4 >= uVarS.b();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            u.this.w = motionEvent.getY();
                        }
                    } else {
                        if (!z) {
                            return false;
                        }
                        u.this.w = motionEvent.getY();
                        int iB5 = y.b(u.this.bc, Math.abs(u.this.w - u.this.oa));
                        if (u.this.w - u.this.oa < 0.0f && iB5 > iK && (uVar2 = (uVar = u.this).pn) != null && (tsView = uVar.u) != null) {
                            uVar2.onClick(tsView);
                        }
                    }
                } else {
                    if (!z) {
                        return false;
                    }
                    u.this.oa = motionEvent.getY();
                }
                return true;
            }
        };
        this.iz = onTouchListener;
        TsView tsView = this.u;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    public void mv() {
        gi();
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.my, this.nr);
        nr(1);
        com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar = this.n;
        if (uVar != null && !this.t) {
            this.t = true;
            uVar.u(this, 2);
            fx(false);
        }
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public PluginValueSet n() {
        return ll7.k(super.n()).f(1, d.fx).a();
    }

    public void s() {
        com.bytedance.sdk.openadsdk.core.n.o().n(true);
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB == null) {
            return;
        }
        uVarB.fx((u.nr) null);
    }

    public void t() {
        this.su.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.13
            @Override // java.lang.Runnable
            public void run() {
                u.this.s = true;
                if (!com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.u) {
                    if (u.this.p != null) {
                        u.this.p.nr();
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.u = false;
                    com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = u.this.fx;
                    if (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                        ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVar).n().u(new com.bytedance.sdk.openadsdk.core.l.fx.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.13.1
                            @Override // com.bytedance.sdk.openadsdk.core.l.fx.u.u
                            public void u() {
                                if (u.this.p != null) {
                                    u.this.p.nr();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.ge.u(1.0f, i);
    }

    private void fx(int i) {
        TsView tsView = this.u;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.bytedance.sdk.openadsdk.core.n.o().b().fx(new C0256u(this.nr));
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.nr();
        }
        bc bcVar = this.nr;
        if (bcVar != null) {
            c.u(bcVar.dv());
        }
        bc bcVar2 = this.nr;
        xg.nr(bcVar2 != null ? bcVar2.n() : 0);
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr nrVar = this.f5271jp;
        if (nrVar != null) {
            nrVar.u();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.iz.u(1, this.nr, this.xw, this.ob);
    }

    public void fx(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar = this.za;
        if (uVar != null) {
            uVar.u(this.f, this.nr, this.kw, z);
        }
    }

    public void nr(boolean z) {
        this.h = z;
        nr();
    }

    public void b(boolean z) {
        if (z || this.u == null) {
            return;
        }
        if (this.m.get() == 2 && kw.u(this.nr)) {
            com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr nrVar = this.f5271jp;
            if (nrVar != null) {
                nrVar.nr();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.b countDownView = this.u.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
                public void u() {
                    u.this.mv();
                }
            });
            countDownView.u(false);
            countDownView.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.u
    public void iz() {
        AtomicBoolean atomicBoolean = this.rh;
        if (atomicBoolean != null && atomicBoolean.get()) {
            k.u("开屏view重复展示");
            TsView tsView = this.u;
            if (tsView != null && tsView.getCountDownView() != null && this.u.getCountDownView().getView() != null) {
                this.u.getCountDownView().getView().setVisibility(0);
            }
            b(this.f5270a.get());
        }
        this.ob = 1;
    }

    private void fx() {
        EmptyView emptyView = new EmptyView(this.bc, this.u, this.nr.re());
        emptyView.u(this.nr, this.xw);
        emptyView.setAdType(3);
        this.u.addView(emptyView);
        emptyView.setCallback(new EmptyView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.8
            private volatile boolean nr = false;

            private void fx() {
                boolean z = true;
                if (!this.nr) {
                    this.nr = true;
                    if (u.this.nr.qf() == 4) {
                        com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("splash_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TsView tsView;
                                Context context;
                                u uVar = u.this;
                                uVar.iz(tk.u(uVar.nr) != 1);
                                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = u.this.fx;
                                if (fxVar != null) {
                                    fxVar.u(false);
                                }
                                u uVar2 = u.this;
                                if (uVar2.fx == null || (tsView = uVar2.u) == null || tsView.getParent() == null) {
                                    return;
                                }
                                try {
                                    context = ((View) u.this.u.getParent()).getContext();
                                } catch (Exception unused) {
                                    context = null;
                                }
                                if (context instanceof Activity) {
                                    u.this.fx.u((Activity) context);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = u.this.fx;
                if (fxVar != null) {
                    try {
                        fxVar.u(false);
                        u uVar = u.this;
                        if (tk.u(uVar.nr) == 1) {
                            z = false;
                        }
                        uVar.x(z);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void nr() {
                u.this.b(15);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(boolean z) {
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = u.this.fx;
                if (fxVar != null && z) {
                    fxVar.u();
                }
                u.this.b(z ? 12 : 13);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u() {
                fx();
                u.this.b(14);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(View view, Map<String, Object> map) {
                iz izVar;
                u uVar = u.this;
                uVar.pn(uVar.bq.get());
                fx();
                u.this.b(11);
                u.this.my = System.currentTimeMillis();
                nr nrVar = u.this.x;
                if (nrVar != null) {
                    nrVar.w_();
                }
                u uVar2 = u.this;
                bc bcVar = uVar2.nr;
                if (bcVar != null && (izVar = uVar2.o) != null) {
                    bcVar.n(izVar.pn());
                    u.this.bg.put("cache_type", Integer.valueOf(dw.nr().n(jp.t(u.this.nr))));
                    u uVar3 = u.this;
                    uVar3.bg.put("splash_show_time_type", Integer.valueOf(uVar3.pb));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    u.this.bg.put("show_send_type", map.get("show_send_type"));
                }
                u uVar4 = u.this;
                uVar4.bg.put("is_repeat", Boolean.valueOf(uVar4.bq.get()));
                u.this.xg.set(true);
                if (!u.this.tm.get()) {
                    u.this.tm.set(true);
                    u uVar5 = u.this;
                    bc bcVar2 = uVar5.nr;
                    String str = uVar5.xw;
                    u uVar6 = u.this;
                    com.bytedance.sdk.openadsdk.core.s.b.u(bcVar2, str, uVar6.bg, uVar6.cj);
                    com.bytedance.sdk.openadsdk.core.bf.u.u().b();
                    bc bcVar3 = u.this.nr;
                    xg.u(bcVar3 != null ? bcVar3.n() : 0);
                }
                u.this.a();
                if (!u.this.rv) {
                    u.this.pn();
                }
                u uVar7 = u.this;
                uVar7.b(uVar7.f5270a.get());
                boolean zVp = dw.nr().vp();
                u uVar8 = u.this;
                if (uVar8.n != null && (!uVar8.bq.getAndSet(true) || zVp)) {
                    u uVar9 = u.this;
                    uVar9.n.u(uVar9);
                    bc bcVar4 = u.this.nr;
                    if (bcVar4 != null && bcVar4.fx() && u.this.nr.kv() != null) {
                        com.bytedance.sdk.openadsdk.core.o.u.u().u(u.this.bc, u.this.nr.kv().nr());
                    }
                }
                u.this.b();
                u.this.rh.set(true);
                TsView tsView = u.this.u;
                if (tsView != null) {
                    tsView.setIsShowSuccess(true);
                }
                u.this.fx(true);
            }
        });
        if (!this.rv) {
            emptyView.setNeedCheckingShow(true);
        }
        this.jk.put("splash_show_type", Integer.valueOf(this.mv));
        com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.bc, this.nr, this.xw, 4) { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.9
            @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, jk jkVar) {
                if ((view instanceof SplashClickBarBtn) && u.this.t) {
                    return;
                }
                super.u(view, jkVar);
            }
        };
        this.pn = uVar;
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.pn.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.jk);
        u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) this.pn.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class), emptyView);
        this.pn.nr(this.u.getDislikeView());
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.pn.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(new u.InterfaceC0278u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.10
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u.InterfaceC0278u
            public void u(View view, int i) {
                u.this.kj();
                u uVar2 = u.this;
                com.bytedance.sdk.openadsdk.core.s.b.nr(uVar2.my, uVar2.nr);
                u uVar3 = u.this;
                com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar4 = uVar3.n;
                if (uVar4 != null) {
                    uVar4.nr(uVar3);
                }
                u.this.t();
                u.this.c();
            }
        });
        this.u.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.jk();
            }
        });
    }

    private void nr() {
        if (!this.h || this.u == null) {
            return;
        }
        bc bcVar = this.nr;
        if ((bcVar == null || bcVar.ox() == null || this.nr.ox().nr() != 0) ? false : true) {
            this.u.setVideoViewVisibility(8);
        } else {
            this.u.setVideoViewVisibility(0);
            this.u.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    u.this.u.setVoiceViewImageDrawable(u.this.mk ? q.fx(u.this.bc, "tt_splash_unmute") : q.fx(u.this.bc, "tt_splash_mute"));
                    u.this.mk = !r2.mk;
                    u uVar = u.this;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar = uVar.ja;
                    if (bVar != null) {
                        bVar.nr(uVar.mk);
                    }
                }
            });
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx fxVar, b<a, x> bVar, com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar) {
        if (fxVar == null || bVar == null) {
            return;
        }
        this.za = uVar;
        this.bf.set(fxVar.a());
        this.f = bVar;
        x xVar = new x();
        this.kj = xVar;
        xVar.nr(fxVar.a());
        this.kj.u(fxVar.nr());
        this.kj.u(this);
        this.bc = fxVar.getContext();
        this.xw = fxVar.iz();
        this.o = fxVar.b();
        boolean z = true;
        u(fxVar.pn(), true);
        this.kw = fxVar.x();
        iz izVar = this.o;
        if (izVar == null) {
            this.kj.nr(3);
            this.kj.u("render splash ad model is null");
            bVar.u(this.kj);
        } else {
            if (this.sx == null) {
                this.kj.nr(3);
                this.kj.u("render splash material is null");
                bVar.u(this.kj);
                return;
            }
            bc bcVarNr = izVar.nr();
            this.nr = bcVarNr;
            this.ge = new pn(bcVarNr, this.xw);
            boolean zIm = dw.nr().im();
            if (!dw.nr().ms() && !zIm) {
                z = false;
            }
            this.rv = z;
            u();
        }
    }

    public void pn(final boolean z) {
        com.bytedance.sdk.openadsdk.core.q.u.nr nrVar = this.y;
        if (nrVar != null) {
            nrVar.u(z(), com.bytedance.sdk.openadsdk.core.q.b.nr.SHOW, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.5
                @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
                public void u(com.bytedance.sdk.openadsdk.core.q.u uVar) {
                    if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.nr) {
                        ((com.bytedance.sdk.openadsdk.core.component.nr) uVar).iz = z;
                    }
                }
            });
        }
    }

    private void nr(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.c || (tsView = this.u) == null || this.nr == null || this.p == null || this.yd) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.yd = true;
        ViewGroup viewGroupU = this.p.u();
        if (viewGroupU == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar = this.ja;
        if (bVar != null) {
            bVar.iz();
        }
        if (viewGroupU.getParent() != null) {
            ((ViewGroup) viewGroupU.getParent()).removeView(viewGroupU);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(viewGroupU);
            y.n(this.u);
            this.u.removeAllViews();
            this.u = null;
        }
        viewGroupU.setOnClickListener(null);
        viewGroupU.setOnTouchListener(null);
        if (this.qq) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar2 = this.ja;
            if (bVar2 != null) {
                bVar2.jk();
            }
            this.ja = null;
        }
        this.p.u(this.ja, new n.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.4
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.n.u
            public Context getActivity() {
                return u.this.nb;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.n.u
            public void nr() {
                u.this.gc = true;
                u.this.d();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.n.u
            public void u(long j) {
                u.this.su.removeMessages(1);
                if (j < 0) {
                    u.this.su.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j == 0) {
                        u.this.su.sendEmptyMessage(2);
                        return;
                    }
                    u.this.eh = j;
                    u.this.v = 0L;
                    u.this.su.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.n.u
            public void u() {
                u.this.su.removeMessages(1);
            }
        });
    }

    public void c() {
    }

    public void u(final bc bcVar, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (bcVar == null || nrVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.u.nr nrVar2 = (com.bytedance.sdk.openadsdk.core.q.u.nr) com.bytedance.sdk.openadsdk.core.q.b.u(1);
        this.y = nrVar2;
        nrVar2.fx(z());
        this.y.u(z(), new com.bytedance.sdk.openadsdk.core.d.u.nr());
        this.y.u(z(), new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.1
            @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
            public void u(com.bytedance.sdk.openadsdk.core.q.u uVar) {
                if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.nr) {
                    com.bytedance.sdk.openadsdk.core.component.nr nrVar3 = (com.bytedance.sdk.openadsdk.core.component.nr) uVar;
                    nrVar3.pn = bcVar;
                    com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar4 = nrVar;
                    if (nrVar4 != null) {
                        nrVar3.nr = nrVar4.bq();
                        nrVar3.fx = nrVar.b();
                    }
                }
            }
        });
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
        this.cj = d;
    }

    public void nr(final int i) {
        com.bytedance.sdk.openadsdk.core.q.u.nr nrVar = this.y;
        if (nrVar != null) {
            nrVar.u(z(), com.bytedance.sdk.openadsdk.core.q.b.nr.END, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.6
                @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
                public void u(com.bytedance.sdk.openadsdk.core.q.u uVar) {
                    if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.nr) {
                        ((com.bytedance.sdk.openadsdk.core.component.nr) uVar).b = i;
                    }
                }
            });
        }
    }

    public synchronized void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, boolean z) {
        if (this.sx == null || !z) {
            this.sx = nVar;
            if (nVar != null) {
                nr(nVar.pn());
                this.d = nVar.b();
            }
        }
    }

    private void u() {
        if (this.nr == null) {
            return;
        }
        try {
            this.t = false;
            TsView tsView = new TsView(this.bc, this.xw, this.nr);
            this.u = tsView;
            tsView.setAttachedToWindowListener(this);
            nr();
            this.u.setCountDownViewPosition(this.nr);
            if (this.nr.f() == 0) {
                TsView tsView2 = this.u;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.u;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.nr.up() <= 0) {
                fx(3);
            } else {
                int iUp = this.nr.up();
                this.l = iUp;
                fx(iUp);
            }
            u(this.nr);
            fx();
        } catch (ArrayIndexOutOfBoundsException e) {
            k.nr("sbr", e.getMessage());
        }
    }

    public void u(nr nrVar) {
        this.x = nrVar;
    }

    private void u(bc bcVar) {
        TsView tsView;
        if (bcVar == null || (tsView = this.u) == null) {
            return;
        }
        tsView.u(bcVar);
    }

    public void u(final com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar, final EmptyView emptyView) {
        fxVar.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.u.12
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.u
            public boolean u() {
                fxVar.u(emptyView);
                fxVar.u(u.this.bg);
                fxVar.u(u.this.xw);
                fxVar.u(u.this.cj);
                return u.this.xg.get();
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        if (i == 1) {
            long j = this.v + 1;
            this.v = j;
            if (j >= this.eh) {
                this.su.sendEmptyMessage(2);
                return;
            } else {
                this.su.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (!this.gc && nb.u(this.nr)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 0);
                com.bytedance.sdk.openadsdk.core.s.b.nr(this.nr, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, "splash_card_close", jSONObject);
            } catch (JSONException unused) {
            }
        }
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.u
    public void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.nr nrVar = this.f5271jp;
        if (nrVar != null) {
            nrVar.u(z);
        }
        this.ob++;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        this.b = new SoftReference<>(fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void u(com.bytedance.sdk.openadsdk.b.u.nr.u.u uVar) {
        this.n = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void u(com.bytedance.sdk.openadsdk.b.u.nr.u.nr nrVar) {
        this.lf = nrVar;
        com.bytedance.sdk.openadsdk.core.component.splash.u uVar = this.mh;
        if (uVar != null) {
            uVar.u(nrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.nr
    public void u(ViewGroup viewGroup, Activity activity) {
        this.nb = activity;
        nr(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
        if (this.tk) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.rh.u(this.nr, d);
        this.tk = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
        if (this.wi) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.rh.u(this.nr, d, str, str2);
        this.wi = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar) {
        bc bcVar = this.nr;
        if (bcVar != null) {
            c.u(bcVar.dv(), nrVar, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
        }
    }

    public void u(int i) {
        this.wq = i;
    }
}
