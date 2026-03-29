package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.sdk.component.adexpress.nr.jk;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.t.u.nr;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.eh;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.nr.b;
import com.bytedance.sdk.openadsdk.core.ugeno.express.nr;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class NativeExpressView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.b, com.bytedance.sdk.component.adexpress.nr.k, com.bytedance.sdk.component.adexpress.nr.n, com.bytedance.sdk.component.adexpress.theme.u, t {
    public static int bg = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected bc f5338a;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.pn ay;
    private Dialog b;
    private final Runnable bc;
    private com.bytedance.sdk.openadsdk.core.ugeno.t.u bf;
    protected boolean bq;
    protected boolean c;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.iz cj;
    private float d;
    protected FrameLayout dw;
    private com.bytedance.sdk.component.adexpress.nr.a eh;
    private boolean f;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.nr fx;
    private my gc;
    private float ge;
    private float gi;
    private com.bytedance.sdk.openadsdk.iz.u h;
    protected final Context iz;
    private eh ja;
    protected String jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f5339jp;
    private long ju;
    protected boolean k;
    private final AtomicBoolean kj;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.fx kw;
    protected fx.b l;
    private com.bytedance.sdk.component.adexpress.nr.b<? extends View> lf;
    private final AtomicBoolean m;
    private com.bytedance.sdk.component.adexpress.nr.nr mh;
    private boolean mk;
    protected fx.InterfaceC0154fx mv;
    protected boolean my;
    protected com.bytedance.sdk.openadsdk.my.fx.fx.nr n;
    private com.bytedance.sdk.component.adexpress.nr.mv nb;
    private int nr;
    protected com.bytedance.sdk.component.adexpress.nr.fx o;
    private ThemeStatusBroadcastReceiver oa;
    private float ob;
    private dw p;
    private FrameLayout pb;
    private u pn;
    private com.bytedance.sdk.openadsdk.core.nr.u q;
    private com.bytedance.sdk.openadsdk.core.nr.nr qq;
    private boolean rh;
    private float rv;
    protected FrameLayout s;
    private com.bytedance.sdk.component.adexpress.nr.my su;
    protected boolean sx;
    protected ExpressVideoView t;
    private jk.u tk;
    private float tm;
    private boolean u;
    private volatile com.bytedance.sdk.component.adexpress.nr.s v;
    private kj w;
    private List<com.bytedance.sdk.component.adexpress.nr.jk> wi;
    private FrameLayout wq;
    protected String x;
    private final com.bytedance.sdk.openadsdk.core.s.pn xg;
    private final Runnable xw;
    private final Runnable y;
    private com.bytedance.sdk.component.adexpress.nr.iz yd;
    private String z;
    private SparseArray<b.u> za;
    private View zx;

    public NativeExpressView(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        super(context);
        this.u = true;
        this.nr = 0;
        this.x = "embeded_ad";
        this.kj = new AtomicBoolean(false);
        this.z = null;
        this.my = false;
        this.sx = false;
        this.bq = false;
        this.rh = false;
        this.m = new AtomicBoolean(false);
        this.c = false;
        this.f5339jp = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.pn(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.y);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.y, 500L);
            }
        };
        this.y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!wq.nr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.iz(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.iz(nativeExpressView.getVisibility());
                }
            }
        };
        this.bc = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(0);
            }
        };
        this.xw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(8);
            }
        };
        this.za = new SparseArray<>();
        this.tm = -1.0f;
        this.rv = -1.0f;
        this.ge = -1.0f;
        this.ob = -1.0f;
        this.ju = 0L;
        this.x = str;
        this.iz = context;
        this.f5338a = bcVar;
        this.xg = new com.bytedance.sdk.openadsdk.core.s.pn(bcVar, str);
        this.n = nrVar;
        l();
    }

    private void bf() {
        if (k()) {
            return;
        }
        qq();
    }

    private boolean d() {
        if (TextUtils.equals(this.x, "rewarded_video") || TextUtils.equals(this.x, "fullscreen_interstitial_ad")) {
            return this.f5338a.uo();
        }
        return true;
    }

    private int getRenderThread() {
        if (gi()) {
            return 1;
        }
        if ((com.bytedance.sdk.openadsdk.core.fx.pn.u().l() & 2) == 2) {
            return 1;
        }
        return tk.b(this.f5338a);
    }

    private boolean gi() {
        return com.bytedance.sdk.openadsdk.core.dw.nr().n(jp.t(this.f5338a)) == 4 && rh();
    }

    private com.bytedance.sdk.openadsdk.iz.u h() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = new com.bytedance.sdk.openadsdk.core.s.jk(this.x, this.f5338a, jSONObject);
        jkVar.u(jSONObject, "webview_source", (Object) 1);
        return jkVar;
    }

    private void ja() {
        this.nr = tk.nr(this.f5338a);
        if (rh() && tk.u(this.f5338a) == 1) {
            this.nr = 1000;
        }
        com.bytedance.sdk.openadsdk.core.mv.u.u uVar = new com.bytedance.sdk.openadsdk.core.mv.u.u(this.f5338a, new WeakReference(this));
        int i = this.nr;
        if (i == 3) {
            com.bytedance.sdk.component.adexpress.nr.nr nrVar = new com.bytedance.sdk.component.adexpress.nr.nr(this.iz, this.nb, this.oa, this.bq, new com.bytedance.sdk.component.adexpress.dynamic.b.x(), this, uVar);
            this.mh = nrVar;
            this.wi.add(nrVar);
            this.mh.u(com.bytedance.sdk.openadsdk.core.dw.nr().bo());
        } else if (i == 7) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.b bVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.b(this.iz, this.f5338a, (com.bytedance.sdk.openadsdk.core.ugeno.express.nr) this.nb, this);
            this.rh = bVar.a();
            com.bytedance.sdk.openadsdk.core.ugeno.express.pn pnVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.pn(this.iz, bVar, this, this.nb);
            this.ay = pnVar;
            this.wi.add(pnVar);
        } else if (i == 10) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.iz izVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.iz(this.iz, this.f5338a, (com.bytedance.sdk.openadsdk.core.ugeno.express.nr) this.nb, this);
            this.cj = izVar;
            this.rh = izVar.a();
            this.ay = new com.bytedance.sdk.openadsdk.core.ugeno.express.pn(this.iz, this.cj, this, this.nb);
            if (tk.u(jp.jk(this.f5338a))) {
                this.cj.u(new com.bytedance.adsdk.ugeno.fx.n() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.5
                    @Override // com.bytedance.adsdk.ugeno.fx.n
                    public void u(a.u uVar2) {
                        try {
                            b.u(uVar2.b(), NativeExpressView.this.nb.pn());
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.bytedance.adsdk.ugeno.fx.n
                    public void nr(a.u uVar2) {
                    }
                });
            }
            this.wi.add(this.ay);
        } else if (i != 1000) {
            kj kjVar = new kj(this.iz, this.nb, this.oa, this.h, this.f5338a, this.eh);
            this.w = kjVar;
            com.bytedance.sdk.component.adexpress.nr.my myVar = new com.bytedance.sdk.component.adexpress.nr.my(this.iz, this.nb, kjVar, this);
            this.su = myVar;
            this.wi.add(myVar);
        }
        int iFx = tk.fx(this.f5338a);
        if (iFx > 0 && z() && TextUtils.equals(this.x, "embeded_ad")) {
            this.wi.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.pn(this.iz, new com.bytedance.sdk.openadsdk.core.ugeno.nr.fx(this.iz, this.f5338a, (com.bytedance.sdk.openadsdk.core.ugeno.express.nr) this.nb, this), this, this.nb));
        } else {
            boolean z = iFx == 1;
            this.u = z;
            if (z || this.nr == 1000) {
                com.bytedance.sdk.component.adexpress.nr.iz izVar2 = new com.bytedance.sdk.component.adexpress.nr.iz(this.iz, this.nb, new sx(this, this.oa, this.nb));
                this.yd = izVar2;
                this.wi.add(izVar2);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.nr.u.nr(this.f5338a)) {
                this.wi.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.pn(this.iz, new com.bytedance.sdk.openadsdk.core.ugeno.nr.fx(this.iz, this.f5338a, (com.bytedance.sdk.openadsdk.core.ugeno.express.nr) this.nb, this), this, this.nb));
            }
        }
        this.tk = new com.bytedance.sdk.component.adexpress.nr.l(this.wi, this.eh);
    }

    private boolean k() {
        return rh() && tk.u(this.f5338a) == 1;
    }

    private void kj() {
        mv.u uVar;
        List<rh> listZu;
        rh rhVar;
        boolean zN = tk.n(this.f5338a);
        JSONObject jSONObjectU = null;
        if (!k()) {
            if (zN) {
                jSONObjectU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.f5338a, com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.gi, this.d, this.my), com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.f5338a), false, this.jk);
            } else if (!tk.jk(this.f5338a)) {
                jSONObjectU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.gi, this.d, this.my, this.f5338a);
            } else if (tk.iz(this.f5338a) != null && !TextUtils.isEmpty(tk.iz(this.f5338a).a())) {
                jSONObjectU = com.bytedance.sdk.openadsdk.core.ugeno.jk.u(tk.iz(this.f5338a).a(), tk.iz(this.f5338a).jk(), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
            }
            if (tk.iz(this.f5338a) != null) {
                com.bytedance.sdk.openadsdk.core.b.u().u(tk.iz(this.f5338a).nr());
            }
            if (tk.x(this.f5338a) != null) {
                com.bytedance.sdk.openadsdk.core.b.u().u(tk.x(this.f5338a).u());
            }
        }
        this.h = h();
        if (k()) {
            this.eh = new bg();
        } else {
            this.eh = new jk(this.h, this.x, this.f5338a, this.z);
        }
        boolean zD = d();
        if (tk.jk(this.f5338a) || tk.l(this.f5338a) || com.bytedance.sdk.openadsdk.core.ugeno.nr.u.nr(this.f5338a) || z()) {
            nr.u uVar2 = new nr.u();
            uVar2.pn(com.bytedance.sdk.openadsdk.core.ugeno.jk.u(this.f5338a, (View) this, false));
            uVar2.u((com.bytedance.adsdk.ugeno.fx.c) this.eh);
            uVar2.u(this.gi);
            uVar2.nr(this.d);
            uVar2.pn(z());
            uVar = uVar2;
        } else {
            uVar = new mv.u();
        }
        uVar.fx(zN);
        if (TextUtils.equals(this.x, WifiNestConst.NestTypeConst.NEST_SPLASH_AD)) {
            uVar.iz(com.bytedance.sdk.openadsdk.gi.jk.pn());
        }
        if (tk.nr(this.f5338a) == 3 && com.bytedance.sdk.openadsdk.pn.u.b(this.f5338a) && (listZu = this.f5338a.zu()) != null && !listZu.isEmpty() && (rhVar = listZu.get(0)) != null) {
            uVar.a(rhVar.u());
            uVar.u(new UpieImageView(this.iz, com.bytedance.sdk.openadsdk.pn.u.a(this.f5338a), com.bytedance.sdk.openadsdk.pn.u.jk(this.f5338a)));
        }
        this.nb = uVar.u(this.x).nr(this.f5338a.lk()).fx(jp.sx(this.f5338a)).b(this.f5338a.ap()).u(jSONObjectU).u(this.eh).u(com.bytedance.sdk.openadsdk.core.dw.nr().u(this.x, tk.nr(this.f5338a))).nr(zD).nr(this.f5338a.kw()).fx(this.f5338a.qf()).pn(com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.b(this.f5338a)).u(com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.pn(this.f5338a)).b(getRenderThread()).pn(this.f5338a.gz()).iz(this.f5338a.an()).x(this.f5338a.qv()).nr(this.f5338a.xs()).fx(this.f5338a.or()).b(this.f5338a.bi()).a(this.f5338a.ki()).n(this.f5338a.zq()).x(this.f5338a.uc()).n("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").u(com.bytedance.sdk.openadsdk.core.n.o().pn()).jk(this.f5338a.n()).b(com.bytedance.sdk.openadsdk.core.dw.nr().jk()).u();
    }

    private void pb() {
        Dialog dialog = this.b;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.fx;
        if (nrVar != null) {
            nrVar.u();
        } else {
            TTDelegateActivity.u(getContext(), this.f5338a);
        }
    }

    private void q() {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar;
        if (TextUtils.equals(this.x, WifiNestConst.NestTypeConst.NEST_SPLASH_AD) && (nrVar = this.n) != null && this.d == nrVar.x() && this.gi == this.n.iz()) {
            this.d = y.b(this.iz, this.d);
            int iB = y.b(this.iz);
            if (this.gi < iB) {
                this.gi = y.b(this.iz, r0);
            } else {
                this.gi = y.b(this.iz, r1);
            }
        }
    }

    private void qq() {
        try {
            if (this.oa == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            this.iz.registerReceiver(this.oa, intentFilter, jp.z(), null);
        } catch (Throwable unused) {
        }
    }

    private boolean rh() {
        return TextUtils.equals(this.x, WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || TextUtils.equals(this.x, "cache_splash_ad");
    }

    private void s() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.oa = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.u(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        com.bytedance.sdk.openadsdk.iz.u uVar = this.h;
        if (uVar instanceof com.bytedance.sdk.openadsdk.core.s.jk) {
            ((com.bytedance.sdk.openadsdk.core.s.jk) uVar).nr(this.nb.n());
        }
        this.h.u();
        this.tk.u(this);
        this.tk.u();
    }

    private boolean xg() {
        bc bcVar = this.f5338a;
        return bcVar != null && bcVar.mk() == 1 && bc.nr(this.f5338a);
    }

    private boolean z() {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar = this.n;
        return nrVar != null && d.fx >= 5900 && nrVar.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.k
    public void a_(final int i) {
        this.f = true;
        if (!this.u) {
            this.eh.t();
        }
        this.eh.l();
        com.bytedance.sdk.component.adexpress.nr.a aVar = this.eh;
        if (aVar instanceof jk) {
            ((jk) aVar).s();
        }
        if (this.pn != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.pn.u(this, com.bytedance.sdk.openadsdk.core.x.u(i), i);
            } else {
                com.bytedance.sdk.openadsdk.core.bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.pn != null) {
                            NativeExpressView.this.pn.u(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.x.u(i), i);
                        }
                    }
                });
            }
        }
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.u
    public void b_(int i) {
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar == null || !(bVar instanceof s)) {
            return;
        }
        ((s) bVar).b_(i);
    }

    public void bg() {
        try {
            FrameLayout frameLayout = this.s;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.s);
        } catch (Throwable unused) {
        }
    }

    public void bq() {
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (!(bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) || (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.iz)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.ugeno.express.b) bVar).nr();
    }

    public void c() {
        dw dwVar = this.p;
        if (dwVar != null) {
            dwVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        com.bytedance.sdk.openadsdk.core.nr.u uVar = this.q;
        if (uVar != null) {
            uVar.fx(motionEvent.getDeviceId());
            this.q.nr(motionEvent.getSource());
            this.q.b(motionEvent.getToolType(0));
        }
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar = this.qq;
        if (nrVar != null) {
            nrVar.fx(motionEvent.getDeviceId());
            this.qq.nr(motionEvent.getSource());
            this.qq.b(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.tm = motionEvent.getRawX();
            this.rv = motionEvent.getRawY();
            this.ju = System.currentTimeMillis();
            i = 0;
        } else if (actionMasked == 1) {
            i = 3;
        } else if (actionMasked != 2) {
            i = actionMasked != 3 ? -1 : 4;
        } else {
            this.ge += Math.abs(motionEvent.getX() - this.tm);
            this.ob += Math.abs(motionEvent.getY() - this.rv);
            this.tm = motionEvent.getX();
            this.rv = motionEvent.getY();
            i = (System.currentTimeMillis() - this.ju <= 200 || (this.ge <= 8.0f && this.ob <= 8.0f)) ? 2 : 1;
        }
        SparseArray<b.u> sparseArray = this.za;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new b.u(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dw() {
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        return bVar != null && bVar.fx() == 1;
    }

    public int fx() {
        return 0;
    }

    public com.bytedance.sdk.openadsdk.core.s.pn getAdShowTime() {
        return this.xg;
    }

    public com.bytedance.sdk.openadsdk.core.nr.u getClickCreativeListener() {
        return this.q;
    }

    public com.bytedance.sdk.openadsdk.core.nr.nr getClickListener() {
        return this.qq;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar != null) {
            return bVar.fx();
        }
        return 0;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.pb;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.d).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.gi).intValue();
    }

    public u getExpressInteractionListener() {
        return this.pn;
    }

    public ja getJsObject() {
        kj kjVar = this.w;
        if (kjVar != null) {
            return kjVar.F_();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        x xVarK;
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (!(bVar instanceof kj) || (xVarK = ((kj) bVar).k()) == null) {
            return 0;
        }
        return xVarK.u();
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.express.iz getUGenV3Render() {
        return this.cj;
    }

    public ViewGroup getVideoContainer() {
        return this.s;
    }

    public com.bykv.vk.openvk.component.video.api.b.fx getVideoController() {
        return null;
    }

    public SSWebView getWebView() {
        kj kjVar = this.w;
        if (kjVar == null) {
            return null;
        }
        return kjVar.u();
    }

    public void iz() {
    }

    public void l() {
        this.dw = new FrameLayout(this.iz);
        this.wq = new FrameLayout(this.iz);
        this.pb = new FrameLayout(this.iz);
        addView(this.dw);
        addView(this.wq);
        addView(this.pb);
        this.wi = new ArrayList();
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar = this.n;
        if (nrVar != null) {
            this.gi = nrVar.n();
            this.d = this.n.a();
            q();
            this.z = this.n.b();
        }
        if (!k()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            s();
        }
        kj();
        ja();
        com.bytedance.sdk.component.adexpress.nr.my myVar = this.su;
        if (myVar != null) {
            this.w = (kj) myVar.nr();
        }
        if (z()) {
            this.gc = new my(this);
        }
    }

    public void mv() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.bytedance.sdk.component.adexpress.nr.jk> it = this.wi.iterator();
            while (it.hasNext()) {
                it.next().u();
            }
            this.fx = null;
            this.b = null;
            this.n = null;
            this.f5338a = null;
            this.q = null;
            this.o = null;
            this.qq = null;
            this.l = null;
            this.mv = null;
            this.pn = null;
            Context context = this.iz;
            if (context != null && (themeStatusBroadcastReceiver = this.oa) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.t;
            if (expressVideoView != null) {
                expressVideoView.bq();
            }
            this.xg.u(56);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("NativeExpressView", "detach error", th);
        }
    }

    public void my() {
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar instanceof s) {
            ((s) bVar).n();
        }
        bf();
    }

    public void n() {
        if (z() && TextUtils.equals(this.x, "embeded_ad")) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.fx.nr(this.f5338a.et(), com.bytedance.sdk.openadsdk.core.dislike.b.u());
            nrVar.nr("dislike");
            com.bytedance.sdk.openadsdk.core.dislike.u.u.u().u(this.iz, nrVar, "close_success");
        }
    }

    public int nr() {
        return 0;
    }

    public void o() {
        if (!com.bytedance.sdk.openadsdk.core.dw.nr().qn() || !this.f) {
            if (com.bytedance.sdk.openadsdk.core.dw.nr().bo() && com.bytedance.sdk.openadsdk.gi.x.u()) {
                com.bytedance.sdk.component.utils.jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.7
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeExpressView.this.wq();
                    }
                });
                return;
            } else {
                wq();
                return;
            }
        }
        if (this.pn != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.pn.u(this, com.bytedance.sdk.openadsdk.core.x.u(-16), -16);
            } else {
                com.bytedance.sdk.openadsdk.core.bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.pn != null) {
                            NativeExpressView.this.pn.u(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.x.u(-16), -16);
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.component.utils.k.nr("webviewpool", "onAttachedToWindow+++");
        pn(51);
        getViewTreeObserver().addOnScrollChangedListener(this.f5339jp);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.sdk.openadsdk.iz.u uVar = this.h;
            if (uVar != null) {
                uVar.nr(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.f5339jp);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.k.nr("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.k.nr("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        my myVar;
        return (!z() || (myVar = this.gc) == null) ? super.onInterceptTouchEvent(motionEvent) : myVar.u(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        pn(55);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.k.nr("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        my myVar;
        return (!z() || (myVar = this.gc) == null) ? super.onTouchEvent(motionEvent) : myVar.nr(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        pn(z ? 53 : 54);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.xw);
        removeCallbacks(this.bc);
        if (i == 0) {
            postDelayed(this.bc, 50L);
        } else {
            postDelayed(this.xw, 50L);
        }
    }

    public void pn() {
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.nr.fx fxVar) {
        this.o = fxVar;
        com.bytedance.sdk.component.adexpress.nr.iz izVar = this.yd;
        if (izVar != null) {
            izVar.u(fxVar);
        }
    }

    public void setClickCreativeListener(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this.q = uVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        this.qq = nrVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar != null && (bVar instanceof sx) && (backupView = (BackupView) bVar.x()) != null) {
            backupView.setDislikeInner(nrVar);
        }
        this.fx = nrVar;
    }

    public void setDynamicSkipListener(com.bytedance.sdk.openadsdk.core.component.splash.countdown.fx fxVar) {
        this.kw = fxVar;
    }

    public void setEasyPlayableSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz izVar) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(izVar);
    }

    public void setExpressInteractionListener(u uVar) {
        this.pn = uVar;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar != null && (bVar instanceof sx) && (backupView = (BackupView) bVar.x()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.b = dialog;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void setSoundMute(boolean z) {
        this.bq = z;
        com.bytedance.sdk.component.adexpress.nr.nr nrVar = this.mh;
        if (nrVar != null && nrVar.nr() != null) {
            this.mh.nr().setSoundMute(z);
        }
        if (this.lf.fx() == 7) {
            com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
            if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) {
                ((com.bytedance.sdk.component.adexpress.dynamic.b) bVar).setSoundMute(z);
            }
        }
    }

    public void setVideoAdInteractionListener(fx.InterfaceC0154fx interfaceC0154fx) {
        this.mv = interfaceC0154fx;
    }

    public void setVideoAdListener(fx.b bVar) {
        this.l = bVar;
    }

    public void sx() {
        kj kjVar = this.w;
        if (kjVar == null || kjVar.x() == null) {
            return;
        }
        this.w.pn();
    }

    public long u() {
        return 0L;
    }

    public void x(int i) {
        this.nb.u(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(int i) {
        if (this.m.get() && this.xg.u()) {
            this.xg.u(wq.nr(this), i);
        }
    }

    public void b(int i) {
    }

    public void fx(int i) {
    }

    public void iz(int i) {
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar == null || !(bVar instanceof s)) {
            return;
        }
        ((s) bVar).nr(i);
    }

    public void nr(int i) {
    }

    public void u(float f) {
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.fx fxVar = this.kw;
        if (fxVar != null) {
            fxVar.u();
        }
    }

    public void u(float f, float f2, float f3, float f4, int i) {
    }

    private void fx(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(context, bcVar, str);
    }

    private void nr(View view, com.bytedance.sdk.openadsdk.core.kj.q qVar, com.bytedance.sdk.openadsdk.core.kj.jk jkVar, int i, String str, int i2) {
        if (bc.pn(this.f5338a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar = this.qq;
        if (nrVar != null) {
            nrVar.u(qVar);
            com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.qq.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
            u(uVar);
            uVar.nr(str);
            this.qq.u(jkVar);
            Map<String, Object> mapU = com.bytedance.sdk.component.t.pn.u.u().u(this.f5338a.hashCode() + this.f5338a.xx());
            mapU.put("convert_tag", qVar.sx);
            u(qVar, mapU);
            this.qq.u(view, jkVar);
        }
        u uVar2 = this.pn;
        if (uVar2 != null) {
            uVar2.u(this, i2);
        }
    }

    public void u(int i) {
    }

    public void u(int i, String str) {
    }

    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, eh ehVar) {
        this.ja = ehVar;
        u(view, i, fxVar);
        this.ja = null;
    }

    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.kj.jk jkVar;
        com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar;
        com.bytedance.sdk.openadsdk.core.nr.u uVar2;
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar;
        if (i == -1 || fxVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kj.q qVar = (com.bytedance.sdk.openadsdk.core.kj.q) fxVar;
        com.bytedance.sdk.openadsdk.core.nr.u uVar3 = this.q;
        if (uVar3 != null) {
            uVar3.pn(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar2 = this.qq;
        if (nrVar2 != null) {
            nrVar2.pn(getDynamicShowType());
        }
        if (i != 1 || (nrVar = this.qq) == null) {
            jkVar = null;
            uVar = null;
        } else {
            jkVar = nrVar.nr();
            uVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.qq.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
            uVar.u(uVar.pn());
        }
        if (i == 2 && (uVar2 = this.q) != null) {
            jkVar = uVar2.nr();
            uVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
            uVar.u(uVar.pn());
        }
        try {
            Object obj = qVar.u().get("click_extra_map");
            if (uVar != null && (obj instanceof Map)) {
                uVar.u((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (jkVar == null) {
            jkVar = new com.bytedance.sdk.openadsdk.core.kj.jk();
        }
        if (this.ja != null) {
            jkVar.nr(this);
        }
        jkVar.u(qVar.u);
        jkVar.nr(qVar.nr);
        jkVar.fx(qVar.fx);
        jkVar.b(qVar.b);
        jkVar.nr(qVar.k);
        jkVar.x(qVar.bg);
        jkVar.u(com.bytedance.sdk.openadsdk.core.kj.c.b(this.f5338a, qVar.sx));
        jkVar.nr(qVar.sx);
        jkVar.u(qVar.my);
        SparseArray<b.u> sparseArray = qVar.o;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.za;
        }
        jkVar.u(sparseArray);
        JSONObject jSONObjectU = qVar.u();
        jkVar.b(jSONObjectU.optBoolean("is_compliant_download"));
        String strOptString = jSONObjectU.optString("uchain_event_name");
        jkVar.fx(strOptString);
        jkVar.u(this.c);
        int iOptInt = jSONObjectU.optInt("convertActionType", Integer.MIN_VALUE);
        if (iOptInt == 1) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.nr.u uVar4 = this.q;
                if (uVar4 != null) {
                    uVar4.fx();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.nr.nr nrVar3 = this.qq;
                if (nrVar3 != null) {
                    nrVar3.fx();
                }
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.nr.u uVar5 = this.q;
                if (uVar5 != null) {
                    uVar5.b();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.nr.nr nrVar4 = this.qq;
                if (nrVar4 != null) {
                    nrVar4.b();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = qVar.t;
        bc bcVar = this.f5338a;
        int iQf = bcVar != null ? bcVar.qf() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.s;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                nr(view2, qVar, jkVar, 0, str, iQf);
                break;
            case 2:
                u(view2, qVar, jkVar, 0, str, iQf);
                break;
            case 3:
                pb();
                break;
            case 4:
                FrameLayout frameLayout2 = this.s;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                jp.q(this.f5338a);
                if ("embeded_ad".equals(this.x) && xg() && !this.k && jp.q(this.f5338a)) {
                    u(view2, qVar, jkVar, 0, str, iQf);
                } else {
                    nr(view2, qVar, jkVar, 0, str, iQf);
                }
                break;
            case 5:
                u(!this.bq);
                break;
            case 6:
                x();
                break;
            case 7:
                if (!u(strOptString)) {
                    com.bytedance.sdk.openadsdk.core.y.iz.u(this.iz, this.f5338a);
                }
                break;
            case 8:
                n();
                break;
            case 9:
                nr(this.f5338a, this.iz, this.x);
                break;
            case 10:
                u(this.f5338a, this.iz, this.x);
                break;
            case 12:
                fx(this.f5338a, this.iz, this.x);
                break;
            case 13:
                String strOptString2 = jSONObjectU.optString("openCommonWebUrl", "");
                String strOptString3 = jSONObjectU.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    TTDelegateActivity.b(this.iz, strOptString2, strOptString3);
                }
                break;
        }
    }

    private void nr(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar, com.bytedance.sdk.openadsdk.core.kj.jk jkVar, int i2) {
        if (bc.pn(this.f5338a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nr.u uVar = this.q;
        if (uVar != null) {
            u(((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(), i);
            this.q.u(qVar);
            this.q.u(jkVar);
            this.q.u(view, jkVar);
        }
        u uVar2 = this.pn;
        if (uVar2 != null) {
            uVar2.u(this, i2);
        }
    }

    public void a() {
    }

    public void jk() {
    }

    public void t() {
    }

    public void nr(com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar, com.bytedance.sdk.component.adexpress.nr.s sVar) {
        try {
            this.lf = bVar;
            this.v = sVar;
            if (bVar.fx() != 1) {
                View viewX = bVar.x();
                this.zx = viewX;
                if (viewX.getParent() != null) {
                    ((ViewGroup) this.zx.getParent()).removeView(this.zx);
                }
                this.wq.addView(this.zx);
                ViewGroup.LayoutParams layoutParams = this.zx.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                if (this.p != null && (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) && !(bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.iz)) {
                    this.p.u(((com.bytedance.sdk.openadsdk.core.ugeno.express.b) bVar).n());
                    this.p.u(this);
                }
            }
            com.bytedance.sdk.component.adexpress.nr.a aVar = this.eh;
            if (aVar instanceof jk) {
                ((jk) aVar).s();
            }
            if (this.h != null && bVar.fx() != 0) {
                this.h.u(bVar.fx(), sVar.t(), sVar.jk());
            }
            com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar2 = this.lf;
            if ((bVar2 instanceof k) && ((k) bVar2).F_() != null) {
                ((k) this.lf).F_().u((t) this);
            }
            if (sVar.nr() == 10 && (sVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx)) {
                this.bf = ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar).sx();
            }
            u uVar = this.pn;
            if (uVar != null) {
                uVar.u(this, (float) sVar.b(), (float) sVar.pn());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void setPauseFromExpressView(boolean z) {
    }

    public void setTimeUpdate(int i) {
    }

    public NativeExpressView(boolean z, Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, boolean z2) {
        super(context);
        this.u = true;
        this.nr = 0;
        this.x = "embeded_ad";
        this.kj = new AtomicBoolean(false);
        this.z = null;
        this.my = false;
        this.sx = false;
        this.bq = false;
        this.rh = false;
        this.m = new AtomicBoolean(false);
        this.c = false;
        this.f5339jp = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.pn(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.y);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.y, 500L);
            }
        };
        this.y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!wq.nr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.iz(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.iz(nativeExpressView.getVisibility());
                }
            }
        };
        this.bc = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(0);
            }
        };
        this.xw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(8);
            }
        };
        this.za = new SparseArray<>();
        this.tm = -1.0f;
        this.rv = -1.0f;
        this.ge = -1.0f;
        this.ob = -1.0f;
        this.ju = 0L;
        this.x = str;
        this.iz = context;
        this.f5338a = bcVar;
        this.xg = new com.bytedance.sdk.openadsdk.core.s.pn(bcVar, str);
        this.n = nrVar;
        this.my = z;
        this.bq = z2;
        l();
    }

    private void nr(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.nr(bcVar, context, str);
    }

    public void nr(int i, String str) {
        ja jaVarF_;
        com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
        if (bVar == null || !(bVar instanceof kj) || (jaVarF_ = ((kj) bVar).F_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            jaVarF_.nr("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public NativeExpressView(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, boolean z) {
        super(context);
        this.u = true;
        this.nr = 0;
        this.x = "embeded_ad";
        this.kj = new AtomicBoolean(false);
        this.z = null;
        this.my = false;
        this.sx = false;
        this.bq = false;
        this.rh = false;
        this.m = new AtomicBoolean(false);
        this.c = false;
        this.f5339jp = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.pn(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.y);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.y, 500L);
            }
        };
        this.y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!wq.nr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.iz(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.iz(nativeExpressView.getVisibility());
                }
            }
        };
        this.bc = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(0);
            }
        };
        this.xw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(8);
            }
        };
        this.za = new SparseArray<>();
        this.tm = -1.0f;
        this.rv = -1.0f;
        this.ge = -1.0f;
        this.ob = -1.0f;
        this.ju = 0L;
        this.x = str;
        this.iz = context;
        this.f5338a = bcVar;
        this.xg = new com.bytedance.sdk.openadsdk.core.s.pn(bcVar, str);
        this.n = nrVar;
        this.bq = z;
        if (nrVar.bq() == 9) {
            this.my = nrVar.k() == 2;
        }
        l();
    }

    public void nr(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar = this.bf;
        if (uVar != null) {
            uVar.u(i, i2);
        }
    }

    private void u(View view, com.bytedance.sdk.openadsdk.core.kj.q qVar, com.bytedance.sdk.openadsdk.core.kj.jk jkVar, int i, String str, int i2) {
        if (bc.pn(this.f5338a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nr.u uVar = this.q;
        if (uVar != null) {
            uVar.u(qVar);
            com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar2 = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
            u(uVar2);
            uVar2.nr(str);
            this.q.u(jkVar);
            Map<String, Object> mapU = com.bytedance.sdk.component.t.pn.u.u().u(this.f5338a.hashCode() + this.f5338a.xx());
            mapU.put("convert_tag", qVar.sx);
            u(qVar, mapU);
            this.q.u(view, jkVar);
        }
        u uVar3 = this.pn;
        if (uVar3 != null) {
            uVar3.u(this, i2);
        }
    }

    public NativeExpressView(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, boolean z, String str2) {
        super(context);
        this.u = true;
        this.nr = 0;
        this.x = "embeded_ad";
        this.kj = new AtomicBoolean(false);
        this.z = null;
        this.my = false;
        this.sx = false;
        this.bq = false;
        this.rh = false;
        this.m = new AtomicBoolean(false);
        this.c = false;
        this.f5339jp = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.pn(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.y);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.y, 500L);
            }
        };
        this.y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!wq.nr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.iz(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.iz(nativeExpressView.getVisibility());
                }
            }
        };
        this.bc = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(0);
            }
        };
        this.xw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.iz(8);
            }
        };
        this.za = new SparseArray<>();
        this.tm = -1.0f;
        this.rv = -1.0f;
        this.ge = -1.0f;
        this.ob = -1.0f;
        this.ju = 0L;
        this.x = str;
        this.iz = context;
        this.f5338a = bcVar;
        this.xg = new com.bytedance.sdk.openadsdk.core.s.pn(bcVar, str);
        this.jk = str2;
        this.n = nrVar;
        this.bq = z;
        if (nrVar.bq() == 9) {
            this.my = nrVar.k() == 2;
        }
        l();
    }

    public void u(com.bytedance.sdk.openadsdk.core.kj.q qVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(qVar.u().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar) {
        eh ehVar = this.ja;
        if (ehVar != null) {
            HashMap map = new HashMap();
            map.put("custom_express_gesture", 1);
            map.put("express_gesture_type", Integer.valueOf(ehVar.nr()));
            map.put("express_slide_direction", Integer.valueOf(ehVar.b()));
            map.put("express_slide_threshold", Double.valueOf(ehVar.fx()));
            uVar.u(map);
        }
    }

    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
        if (i == -1 || fxVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kj.q qVar = (com.bytedance.sdk.openadsdk.core.kj.q) fxVar;
        com.bytedance.sdk.openadsdk.core.kj.jk jkVar = new com.bytedance.sdk.openadsdk.core.kj.jk();
        jkVar.u(qVar.o);
        jkVar.u(qVar.u);
        jkVar.nr(qVar.nr);
        jkVar.fx(qVar.fx);
        jkVar.b(qVar.b);
        jkVar.nr(qVar.k);
        JSONObject jSONObjectU = qVar.u();
        int iOptInt = jSONObjectU.optInt("convertActionType", Integer.MIN_VALUE);
        jkVar.b(jSONObjectU.optBoolean("is_compliant_download"));
        if (iOptInt == 1) {
            if (i == 2) {
                this.q.fx();
            } else {
                this.qq.fx();
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                this.q.b();
            } else {
                this.qq.b();
            }
        }
        View view2 = view == null ? this : view;
        com.bytedance.sdk.openadsdk.core.nr.u uVar = this.q;
        if (uVar != null) {
            uVar.pn(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar = this.qq;
        if (nrVar != null) {
            nrVar.pn(getDynamicShowType());
        }
        bc bcVar = this.f5338a;
        int iQf = bcVar != null ? bcVar.qf() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.s;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                u(view2, i2, qVar, jkVar, iQf);
                break;
            case 2:
                nr(view2, i2, qVar, jkVar, iQf);
                break;
            case 3:
                pb();
                break;
            case 4:
                FrameLayout frameLayout2 = this.s;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                jp.q(this.f5338a);
                if ("embeded_ad".equals(this.x) && xg() && !this.k && jp.q(this.f5338a)) {
                    nr(view2, i2, qVar, jkVar, iQf);
                } else {
                    u(view2, i2, qVar, jkVar, iQf);
                }
                break;
            case 5:
                u(!this.bq);
                break;
            case 6:
                x();
                break;
            case 8:
                n();
                break;
        }
    }

    private boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        jp.gi();
        HashMap map = new HashMap();
        map.put("material_meta", this.f5338a);
        map.put("context", this.iz);
        new nr.u(str).u(this.f5338a.et()).u(map).u().u();
        return true;
    }

    private void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar, com.bytedance.sdk.openadsdk.core.kj.jk jkVar, int i2) {
        if (bc.pn(this.f5338a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar = this.qq;
        if (nrVar != null) {
            u(((com.bytedance.sdk.openadsdk.core.nr.u.u.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(), i);
            this.qq.u(qVar);
            this.qq.u(jkVar);
            this.qq.u(view, jkVar);
        }
        u uVar = this.pn;
        if (uVar != null) {
            uVar.u(this, i2);
        }
    }

    private void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar, int i) {
        if (fxVar != null && (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn)) {
            com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVarN = ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVar).n();
            fxVarN.nr(true);
            fxVarN.u(i);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.k
    public void u(final com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar, final com.bytedance.sdk.component.adexpress.nr.s sVar) {
        this.f = true;
        this.m.set(true);
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.8
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.nr(bVar, sVar);
            }
        });
    }

    public void u(MotionEvent motionEvent) {
        View view = this.zx;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void u(CharSequence charSequence, int i, int i2, boolean z) {
        u(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    public void u(int i, int i2, boolean z) {
        int iB;
        if (TextUtils.equals(this.x, "fullscreen_interstitial_ad")) {
            iB = (!gi.u(this.f5338a) || gi.nr(this.f5338a) <= 0) ? com.bytedance.sdk.openadsdk.core.dw.nr().pn(Integer.parseInt(this.z)) : 0;
        } else if (!TextUtils.equals(this.x, "rewarded_video")) {
            return;
        } else {
            iB = com.bytedance.sdk.openadsdk.core.dw.nr().b(Integer.parseInt(this.z));
        }
        int i3 = (i2 >= iB || z) ? 1 : 0;
        int i4 = i2 <= iB ? iB - i2 : 0;
        com.bytedance.sdk.component.adexpress.nr.nr nrVar = this.mh;
        if (nrVar != null && nrVar.nr() != null) {
            this.mh.nr().u(String.valueOf(i), i3, i4, z);
        }
        if (this.lf.fx() == 7 || this.lf.fx() == 10) {
            com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
            if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) {
                ((com.bytedance.sdk.component.adexpress.dynamic.b) bVar).u(String.valueOf(i), i3, i4, z);
            }
        }
    }

    private void u(bc bcVar, Context context, String str) {
        if (bcVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.fx(bcVar, context, str);
    }

    public void u(boolean z) {
        if (this.lf.fx() == 7) {
            com.bytedance.sdk.component.adexpress.nr.b<? extends View> bVar = this.lf;
            if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.b) {
                ((com.bytedance.sdk.component.adexpress.dynamic.b) bVar).setSoundMute(z);
            }
        }
    }

    public void u(JSONObject jSONObject) {
        boolean zBq = com.bytedance.sdk.openadsdk.core.dw.nr().bq();
        this.mk = zBq;
        if (zBq && jp.b(this.f5338a)) {
            this.p = new dw(this.f5338a, jSONObject, this);
        }
    }
}
