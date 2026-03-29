package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.lf;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.p;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.q.fx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends com.bytedance.sdk.openadsdk.core.component.fx implements rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5267a;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr b;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz bg;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n bq;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a c;
    private com.bytedance.sdk.openadsdk.my.fx.nr.nr dw;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b gi;
    private int jk;
    private long k;
    private p kj;
    private u l;
    private long mv;
    private long my;
    private final rh n;
    private long o;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn oa;
    private oa pn;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a q;
    private p qq;
    private long s;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz sx;
    private com.bytedance.sdk.openadsdk.core.component.splash.u.u t;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x w;
    private Context x;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b z;
    private int fx = 2;
    private com.bytedance.sdk.openadsdk.bq.u.nr.u.u iz = null;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean rh = new AtomicBoolean(false);
    private final AtomicBoolean ja = new AtomicBoolean(false);
    private final AtomicBoolean bf = new AtomicBoolean(false);
    private final AtomicBoolean wq = new AtomicBoolean(false);
    private final AtomicInteger pb = new AtomicInteger(0);
    private final AtomicBoolean xg = new AtomicBoolean(false);
    private final AtomicBoolean m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final AtomicBoolean f5268jp = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);
    private final AtomicInteger bc = new AtomicInteger(0);
    private boolean xw = false;
    private final nr cj = new nr();

    /* JADX INFO: compiled from: SearchBox */
    public class u {
        private final AtomicBoolean nr = new AtomicBoolean(false);

        public u() {
        }

        private void b(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
            if (xVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.u.1
                @Override // java.lang.Runnable
                public void run() {
                    if (pn.this.iz != null) {
                        pn.this.iz.u(xVar.a(), new com.bytedance.sdk.openadsdk.my.fx.fx(xVar.b(), xVar.pn()));
                        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "onSplashRenderFail回调 true " + xVar.b());
                    }
                }
            });
            pn.this.x();
        }

        public void fx(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
            pn.this.mv();
            if (this.nr.get()) {
                return;
            }
            this.nr.set(true);
            iz.u(xVar.n(), pn.this.u(xVar.n()), pn.this.b, xVar);
            b(xVar);
            k.nr("SplashLoadManager", "渲染失败 code " + xVar.b() + " msg " + xVar.pn());
        }

        public void nr(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
            if (xVar == null) {
                return;
            }
            pn.this.mv();
            if (this.nr.get()) {
                return;
            }
            this.nr.set(true);
            pn.this.fx();
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.u.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pn.this.iz != null) {
                        if (pn.this.pb.get() > 0) {
                            pn.this.iz.u(null, new com.bytedance.sdk.openadsdk.my.fx.fx(1, "load splash material fail"));
                            return;
                        }
                        com.bytedance.sdk.openadsdk.my.fx.fx fxVar = new com.bytedance.sdk.openadsdk.my.fx.fx(xVar.b(), xVar.pn());
                        pn.this.u((String) null, false, fxVar);
                        pn.this.iz.u(fxVar);
                    }
                }
            });
            pn.this.x();
            com.bytedance.sdk.openadsdk.core.x.u.fx("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + xVar.b());
            iz.u(xVar.n(), pn.this.u(xVar.n()), pn.this.b, xVar);
        }

        public void u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
            if (xVar == null) {
                return;
            }
            pn.this.mv();
            if (this.nr.get()) {
                return;
            }
            this.nr.set(true);
            pn.this.fx();
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.u.2
                @Override // java.lang.Runnable
                public void run() {
                    if (pn.this.iz != null) {
                        if (xVar.b() == 22) {
                            xVar.nr(1);
                        }
                        com.bytedance.sdk.openadsdk.my.fx.fx fxVar = new com.bytedance.sdk.openadsdk.my.fx.fx(xVar.b(), xVar.pn());
                        pn.this.u((String) null, false, fxVar);
                        pn.this.iz.u(fxVar);
                        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "onSplashLoadFail 回调");
                    }
                }
            });
            u(false, true, (Object) null);
            pn.this.x();
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
            iz.u(xVar.n(), pn.this.u(xVar.n()), pn.this.b, xVar);
        }

        public boolean fx() {
            return this.nr.get();
        }

        public void nr() {
            if (this.nr.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            pn.this.l();
        }

        public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
            if (this.nr.get()) {
                return;
            }
            if (pn.this.pb.get() == 0) {
                pn.this.fx();
            }
            if (nVar != null) {
                p pVar = nVar.t() ? pn.this.kj : pn.this.qq;
                if (pVar != null) {
                    pVar.iz(nVar.u());
                    pVar.sx(nVar.s());
                    pVar.dw(System.currentTimeMillis() - pVar.qq());
                }
                u(pn.this.iz, pVar, nVar.nr(), nVar.l(), nVar.t(), nVar.k());
            }
        }

        private void u(com.bytedance.sdk.openadsdk.bq.u.nr.u.u uVar, p pVar, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, boolean z, boolean z2) {
            if (uVar == null || pVar == null || pn.this.pb.get() > 0) {
                return;
            }
            if (pn.this.u(bcVar)) {
                pn pnVar = pn.this;
                iz.u(z ? pnVar.kj : pnVar.qq, 2);
                pn.this.mv();
            }
            pn.this.f5268jp.set(z);
            pn.this.pb.set(1);
            long jCurrentTimeMillis = System.currentTimeMillis();
            u(nrVar, 1);
            pn.this.u(nrVar.z(), true, (com.bytedance.sdk.openadsdk.my.fx.fx) null);
            uVar.u(nrVar);
            pn.this.pb.set(2);
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
            u(z, false, (Object) nrVar);
            pVar.o(System.currentTimeMillis() - jCurrentTimeMillis);
            if (z2) {
                iz.u(pn.this.x, pVar, bcVar, z, jCurrentTimeMillis);
            }
        }

        public void u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar) {
            pn.this.mv();
            if (this.nr.get()) {
                return;
            }
            this.nr.set(true);
            boolean z = aVar != null && aVar.fx();
            pn.this.u(aVar);
            pn pnVar = pn.this;
            pnVar.u(z, z ? pnVar.kj : pnVar.qq);
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.u.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar2;
                    if (pn.this.iz == null || (aVar2 = aVar) == null) {
                        return;
                    }
                    u.this.u(aVar2.u(), 2);
                    pn.this.iz.nr(aVar.u());
                }
            });
        }

        public void u() {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "onTimeOut start");
            pn.this.d.set(true);
            if (this.nr.get()) {
                return;
            }
            this.nr.set(true);
            if (pn.this.pb.get() == 0) {
                pn.this.fx();
            }
            if (pn.this.oa != null) {
                pn.this.oa.u();
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "开屏超时");
            if (pn.this.iz != null) {
                if (pn.this.pb.get() > 0) {
                    pn.this.iz.u(null, new com.bytedance.sdk.openadsdk.my.fx.fx(3, "load success but render fail"));
                } else {
                    com.bytedance.sdk.openadsdk.my.fx.fx fxVar = new com.bytedance.sdk.openadsdk.my.fx.fx(23, "load splash time out");
                    pn.this.u((String) null, false, fxVar);
                    pn.this.iz.u(fxVar);
                }
                com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "回调开屏超时 true");
                pn.this.x();
            }
            boolean z = pn.this.xw;
            pn pnVar = pn.this;
            iz.u(z, pnVar.u(pnVar.xw), pn.this.b, new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x(23, "load splash time out", pn.this.xw));
            boolean z2 = pn.this.xw;
            pn pnVar2 = pn.this;
            iz.u(z2, pnVar2.u(pnVar2.xw), pn.this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, int i) {
            if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.presentation.u) {
                ((com.bytedance.sdk.openadsdk.core.component.splash.presentation.u) nrVar).u(i);
            }
        }

        private void u(boolean z, boolean z2, Object obj) {
            bc bcVarU = pn.this.u(true);
            if (pn.this.t == null || bcVarU == null) {
                return;
            }
            String strXx = bcVarU.xx();
            pn.this.t.u(pn.this.b.b(), strXx, z, z2, obj);
        }
    }

    private pn(Context context) {
        if (context != null) {
            this.x = context.getApplicationContext();
        } else {
            this.x = dw.getContext();
        }
        this.n = new rh(Looper.getMainLooper(), this);
        this.l = new u();
        com.bytedance.sdk.openadsdk.core.n.o().n(false);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iOptInt;
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar = this.bg;
        if (izVar != null && izVar.nr() != null && this.bg.nr().is() != null && (iOptInt = this.bg.nr().is().optInt("real_drop_cache_type", 0)) == 1) {
            com.bytedance.sdk.openadsdk.core.x.u.u("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + iOptInt);
            jk();
            return;
        }
        if (this.cj.u()) {
            com.bytedance.sdk.openadsdk.core.x.u.u("SplashLoadManager", "loadCacheWhenRealAdDrop - 计分模式下允许兜底缓存： ");
            jk();
        } else {
            u uVar = this.l;
            if (uVar != null) {
                uVar.u(this.w);
            }
        }
    }

    private void iz() {
        this.d.set(false);
        this.h.set(false);
        this.rh.set(false);
        this.ja.set(false);
        this.xg.set(false);
        this.m.set(false);
        this.bf.set(false);
        this.wq.set(false);
        this.f5268jp.set(false);
        this.y.set(false);
    }

    private void jk() {
        rh rhVar = this.n;
        if (rhVar != null) {
            rhVar.removeMessages(4);
        }
        u uVar = this.l;
        if (uVar != null) {
            uVar.nr();
        }
    }

    private void k() {
        this.qq = new p();
        p pVar = new p();
        this.kj = pVar;
        iz.u(this.qq, pVar);
        this.z = new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b();
        this.gi = new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.l == null) {
            return;
        }
        if (nr(u(true), true)) {
            AtomicBoolean atomicBoolean = this.h;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
            com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar = this.bq;
            if (nVar != null) {
                nVar.u(this.dw);
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.8
                @Override // java.lang.Runnable
                public void run() {
                    iz.b(pn.this.kj, jCurrentTimeMillis);
                    pn.this.t();
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.h;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
        final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u uVarNr = nr(this.bg, this.bq, this.l);
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar2 = this.bq;
        if (nVar2 != null) {
            nVar2.u(uVarNr.u());
        }
        final long jCurrentTimeMillis2 = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.9
            @Override // java.lang.Runnable
            public void run() {
                iz.b(pn.this.kj, jCurrentTimeMillis2);
                pn.this.l.u(pn.this.bq);
                pn pnVar = pn.this;
                pnVar.u(pnVar.bg, uVarNr, pn.this.bq.pn());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        rh rhVar = this.n;
        if (rhVar != null) {
            rhVar.removeMessages(4);
        }
        rh rhVar2 = this.n;
        if (rhVar2 != null) {
            rhVar2.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean my() {
        return this.fx == 2;
    }

    private void n() {
        com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar = this.t;
        if (uVar != null) {
            uVar.nr(this.b, this.pn);
        }
    }

    private boolean o() {
        return (com.bytedance.sdk.openadsdk.core.fx.pn.u().t() & 4) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.u(this.b, this.pn)) {
            return;
        }
        this.t.u(new lf(this.sx.b(), this.sx.nr(), null), this.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.l.u(this.bq);
        this.m.set(true);
        if (!this.ja.get() || this.xg.get()) {
            return;
        }
        this.xg.set(true);
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.l.u(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        int i;
        if (com.bytedance.sdk.openadsdk.core.component.splash.u.u.u(this.fx) && ((i = this.fx) == 1 || i == 3)) {
            return;
        }
        n();
    }

    private void pn() {
        this.nr = UUID.randomUUID().toString();
        com.bytedance.sdk.openadsdk.core.q.u.u uVar = (com.bytedance.sdk.openadsdk.core.q.u.u) com.bytedance.sdk.openadsdk.core.q.b.u(0);
        this.u = uVar;
        uVar.fx(this.nr);
        this.u.u(this.nr, new com.bytedance.sdk.openadsdk.core.d.u.u());
    }

    private void b(boolean z) {
        if (z) {
            this.o = System.currentTimeMillis();
        } else {
            this.my = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fx(boolean z) {
        return z && my();
    }

    public static boolean b() {
        return (com.bytedance.sdk.openadsdk.core.fx.pn.u().l() & 256) == 256;
    }

    private int fx(bc bcVar) {
        return Math.max(com.bytedance.sdk.openadsdk.core.fx.pn.u().s(), (this.jk - ((int) (System.currentTimeMillis() - this.mv))) - (bcVar != null ? tk.pn(bcVar) : 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nr(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar;
        return (z || this.t == null || (izVar = this.sx) == null || izVar.b() == null || this.sx.nr() == null || !com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.sx.nr())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(boolean z) {
        if (z) {
            this.gi.fx(System.currentTimeMillis() - this.o);
        } else {
            this.z.fx(System.currentTimeMillis() - this.my);
        }
    }

    private void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, long j) {
        if (nVar.t()) {
            if (this.wq.get()) {
                return;
            }
            this.gi.nr(j - this.k);
            this.kj.fx(nVar.iz());
            this.kj.nr(nVar.pn());
            return;
        }
        if (this.bf.get()) {
            return;
        }
        this.z.nr(j - this.s);
        this.qq.fx(nVar.iz());
        this.qq.nr(nVar.pn());
    }

    private void iz(boolean z) {
        if (this.n != null) {
            if (my()) {
                if (z) {
                    return;
                } else {
                    this.n.removeMessages(4);
                }
            }
            this.n.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, u uVar) {
        if (izVar == null || uVar == null) {
            return;
        }
        bc bcVarNr = izVar.nr();
        boolean zPn = izVar.pn();
        com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u uVarU = u(izVar, new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n(bcVarNr, zPn), uVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr(bcVarNr, zPn);
        nrVar.u(zPn);
        nrVar.u(izVar.b());
        nrVar.u(izVar.u());
        nrVar.u(izVar.fx());
        com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.iz izVarU = u(izVar, uVar, uVarU.u(), nrVar, jElapsedRealtime);
        uVarU.u(izVarU);
        iz.fx(zPn ? this.kj : this.qq, System.currentTimeMillis());
        izVarU.nr();
        int iFx = fx(bcVarNr);
        if (this.d.get()) {
            return;
        }
        if (u(bcVarNr, nrVar.b()) && this.n != null && iFx <= 0) {
            iFx = 0;
        }
        u(zPn, 1);
        u(uVarU, zPn, iFx);
    }

    public static pn u(Context context) {
        return new pn(context);
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.u uVar, final int i) {
        if (nrVar != null && !TextUtils.isEmpty(nrVar.dw())) {
            this.u = (com.bytedance.sdk.openadsdk.core.q.u.u) com.bytedance.sdk.openadsdk.core.q.b.u(0);
        } else {
            pn();
        }
        this.u.u(this.nr, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
            public void u(com.bytedance.sdk.openadsdk.core.q.u uVar2) {
                if (uVar2 instanceof com.bytedance.sdk.openadsdk.core.component.u) {
                    ((com.bytedance.sdk.openadsdk.core.component.u) uVar2).u = nrVar;
                }
            }
        });
        u();
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            com.bytedance.sdk.openadsdk.my.fx.fx fxVar = new com.bytedance.sdk.openadsdk.my.fx.fx(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            u((String) null, false, fxVar);
            uVar.u(fxVar);
            return;
        }
        int iN = dw.nr().n(jp.nr(nrVar));
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.n.o().x(1);
                    pn.this.iz = uVar;
                    pn.this.u(nrVar, i);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.my.fx.fx fxVar2 = new com.bytedance.sdk.openadsdk.my.fx.fx(4000, " msg = " + th.getMessage());
                    pn.this.u((String) null, false, fxVar2);
                    uVar.u(fxVar2);
                    k.u("SplashLoadManager", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!bg.u) {
            k.nr("SplashLoadManager", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            com.bytedance.sdk.openadsdk.my.fx.fx fxVar2 = new com.bytedance.sdk.openadsdk.my.fx.fx(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            u((String) null, false, fxVar2);
            uVar.u(fxVar2);
            return;
        }
        if (AdSdkInitializerHolder.isSdkInitSuccess() && (iN == 4 || u(nrVar))) {
            aVar.run();
        } else if (com.bytedance.sdk.openadsdk.core.rh.u()) {
            com.bytedance.sdk.component.jk.x.pn(aVar);
        } else {
            t.nr.l().execute(aVar);
        }
        com.bytedance.sdk.openadsdk.core.iz.u.fx().u(3, nrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nr(bc bcVar, boolean z) {
        if (bcVar == null) {
            return false;
        }
        if (my() && z && o()) {
            return false;
        }
        if ((com.bytedance.sdk.openadsdk.core.fx.pn.u().mv() & 1) == 1) {
            return true;
        }
        return x.nr(bcVar) && nr(bcVar) && bcVar.df() == 1;
    }

    private boolean nr(bc bcVar) {
        return bcVar != null && tk.u(bcVar) == 2;
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u nr(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, final u uVar) {
        if (izVar == null || nVar == null || uVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u(new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx(this.x, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, izVar, nVar, this.b), new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.5
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar) {
                pn.this.pn(izVar.pn());
                if (pn.this.f5268jp.get()) {
                    if (izVar.pn()) {
                        uVar.u(aVar);
                    }
                } else {
                    if (izVar.pn()) {
                        return;
                    }
                    uVar.u(aVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b
            public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
                uVar.fx(xVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b
            public void u() {
                pn.this.nr(izVar);
            }
        }, this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i) {
        if (nrVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "加载开屏广告--begin ");
        this.mv = System.currentTimeMillis();
        this.pn = nr(nrVar);
        this.b = nrVar;
        this.f5267a = jp.nr(nrVar);
        this.t = com.bytedance.sdk.openadsdk.core.component.splash.u.u.u();
        int iU = this.cj.u(this.f5267a);
        this.fx = iU;
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "当前rit位 " + this.f5267a);
        int iIz = dw.nr().iz(nrVar.b());
        u(nrVar.b(), iIz, i);
        oa oaVar = this.pn;
        long j = i;
        oaVar.f5318a = j;
        oaVar.jk = iIz;
        oaVar.t = this.jk;
        iz.u(nrVar, j);
        iz();
        nr();
        u(nrVar, this.pn, iU);
    }

    private oa nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        oa oaVar = new oa();
        oaVar.x = jCurrentTimeMillis;
        oaVar.mv = com.bytedance.sdk.openadsdk.core.n.o().nb();
        Object obj = this.iz;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.u.nr)) {
            oaVar.n = ((com.bytedance.sdk.openadsdk.core.u.nr) obj).u();
        }
        return oaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
        if (izVar != null && izVar.pn()) {
            return;
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i) {
        iz.u(this.qq, this.kj, oaVar, this.fx, i);
        u(nrVar, oaVar, this.l);
    }

    private void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, final u uVar) {
        if (uVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.u.pn pnVar = new com.bytedance.sdk.openadsdk.core.component.splash.u.pn();
        pnVar.u = this.cj.nr;
        com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn pnVar2 = new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn(new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.pn(nrVar, oaVar, pnVar), new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.7
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2;
                if (TextUtils.isEmpty(((com.bytedance.sdk.openadsdk.core.component.fx) pn.this).nr) && (nrVar2 = nrVar) != null && !TextUtils.isEmpty(nrVar2.dw()) && izVar != null && izVar.nr() != null && ((com.bytedance.sdk.openadsdk.core.component.fx) pn.this).u != null) {
                    pn pnVar3 = pn.this;
                    ((com.bytedance.sdk.openadsdk.core.component.fx) pnVar3).nr = ((com.bytedance.sdk.openadsdk.core.component.fx) pnVar3).u.nr(izVar.nr().xx());
                }
                if (izVar == null || izVar.nr() == null) {
                    uVar.u(new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x(1, "no ad model", false));
                    return;
                }
                bc bcVarNr = izVar.nr();
                if (izVar.pn()) {
                    pn.this.bc.set(1);
                    pn.this.bg = izVar;
                    if (!pn.this.my()) {
                        pn.this.xw = true;
                    }
                } else {
                    pn.this.sx = izVar;
                    pn.this.xw = false;
                }
                if (pn.this.d.get() || pn.this.l.fx() || pn.this.pb.get() > 0) {
                    pn.this.u(izVar, izVar.pn(), true);
                    return;
                }
                pn.this.u(izVar);
                if (pn.this.nr(bcVarNr, izVar.pn())) {
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "开始并发加载素材 ");
                    pn.this.nr(izVar, uVar);
                } else {
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "开始串行加载素材 getReqId " + izVar.nr().xx());
                    pn.this.u(izVar, uVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
            public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
                if (pn.this.fx == 1 && pn.this.cj.fx == 2) {
                    pn.this.fx = 2;
                    pn pnVar3 = pn.this;
                    pnVar3.u(nrVar, pnVar3.pn, pn.this.fx);
                    return;
                }
                boolean zN = xVar.n();
                if (zN) {
                    pn.this.bc.set(-1);
                }
                if (pn.this.fx(zN)) {
                    if (pn.this.y.get()) {
                        uVar.u(pn.this.w);
                        return;
                    }
                    return;
                }
                pn.this.w = xVar;
                if (pn.this.my()) {
                    if (pn.this.bc.get() != -1) {
                        if (pn.this.bc.get() == 1) {
                            pn.this.a();
                        }
                    } else {
                        uVar.u(xVar);
                    }
                    pn.this.y.set(true);
                    return;
                }
                uVar.u(xVar);
            }
        }, this.t, this.cj);
        this.oa = pnVar2;
        pnVar2.u(this.fx);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what == 2) {
            u uVar = this.l;
            if (uVar != null) {
                uVar.u();
            }
            rh rhVar = this.n;
            if (rhVar != null) {
                rhVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            jk();
        }
    }

    private boolean u(bc bcVar, boolean z) {
        return (bcVar == null || z || bcVar.jw() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(bc bcVar) {
        return (bcVar != null ? bcVar.jw() : 0) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bc u(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar = this.bg;
            if (izVar == null) {
                return null;
            }
            return izVar.nr();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar2 = this.sx;
        if (izVar2 == null) {
            return null;
        }
        return izVar2.nr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final boolean z, final p pVar) {
        com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("preloadSplash") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.10
            @Override // java.lang.Runnable
            public void run() {
                if (pn.this.nr(z)) {
                    pn.this.s();
                } else {
                    pn.this.x();
                }
                p pVar2 = pVar;
                boolean z2 = pVar2 != null && pVar2.pb();
                p pVar3 = pVar;
                boolean z3 = pVar3 != null && pVar3.bf();
                boolean z4 = z;
                iz.u(z4, pn.this.u(z4), pn.this.b, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
        boolean zPn = izVar.pn();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.mv;
        if (zPn) {
            iz.u(this.kj);
            this.gi.u(tk.u(u(zPn)));
            this.gi.nr(tk.nr(u(zPn)));
            this.gi.u(j);
            this.k = jCurrentTimeMillis;
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j);
            return;
        }
        iz.u(this.qq);
        this.z.u(tk.u(u(zPn)));
        this.z.nr(tk.nr(u(zPn)));
        this.z.u(j);
        this.s = jCurrentTimeMillis;
        iz.u(this.qq, izVar);
        com.bytedance.sdk.openadsdk.core.gi.pn.u().fx().u(this.qq);
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "实时加载物料--end 耗时S1： " + j);
    }

    private void u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, final u uVar) {
        if (nVar != null && this.pb.get() <= 0) {
            final boolean zT = nVar.t();
            final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u uVarNr = nr(izVar, nVar, uVar);
            nVar.u(uVarNr.u());
            if (!fx(nVar.t())) {
                com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "不需要等待实时广告 isCacheAd " + zT);
                if (b()) {
                    uVar.u(nVar);
                    u(izVar, uVarNr, nVar.pn());
                    return;
                } else {
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iz.b(zT ? pn.this.kj : pn.this.qq, jCurrentTimeMillis);
                            uVar.u(nVar);
                            pn.this.u(izVar, uVarNr, nVar.pn());
                        }
                    });
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + zT);
            this.bq = nVar;
            this.dw = uVarNr.u();
            this.h.set(true);
            if (this.y.get()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, final u uVar) {
        if (izVar == null || uVar == null) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        iz.fx(izVar.pn() ? this.kj : this.qq, System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr(izVar.nr(), izVar.pn());
        nrVar.u(izVar.b());
        nrVar.u(izVar.pn());
        nrVar.u(izVar.u());
        nrVar.u(izVar.fx());
        new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.iz(nrVar, new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.12
            private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n pn;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
            public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar2 = this.pn;
                if (nVar2 != null) {
                    nVar2.pn(true);
                }
                pn.this.u(nVar, izVar, uVar, (com.bytedance.sdk.openadsdk.my.fx.nr.nr) null, jElapsedRealtime, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public void fx(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
                this.pn = nVar;
                pn.this.u(nVar, izVar, uVar, (com.bytedance.sdk.openadsdk.my.fx.nr.nr) null, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
            public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
                pn.this.u(izVar, xVar, uVar, jElapsedRealtime);
            }
        }).nr();
        u(izVar.pn(), 0);
    }

    private void u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u uVar, boolean z, final int i) {
        b(z);
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.13
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u uVar2 = uVar;
                if (uVar2 == null) {
                    return;
                }
                uVar2.u(i);
                uVar.nr();
            }
        });
    }

    private void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zT = nVar.t();
        if (zT) {
            iz.u(this.kj, nVar);
            iz.u(this.kj, nVar, j, u(zT));
            iz.u(u(zT), this.kj, nVar);
            u(zT, nVar, jCurrentTimeMillis - this.k);
            com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar2 = this.bq;
            if (nVar2 != null) {
                nVar2.pn(true);
            }
        } else {
            iz.u(this.qq, nVar);
            iz.u(this.qq, nVar, j, u(zT));
            iz.u(u(zT), this.qq, nVar);
            u(zT, nVar, jCurrentTimeMillis - this.s);
        }
        nr(nVar, jCurrentTimeMillis);
        if (this.pb.get() <= 0 || this.d.get()) {
            return;
        }
        if (this.f5268jp.get()) {
            if (zT) {
                iz.u(this.x, this.kj, nVar.nr(), true, jCurrentTimeMillis);
            }
        } else {
            if (zT) {
                return;
            }
            iz.u(this.x, this.qq, nVar.nr(), false, jCurrentTimeMillis);
        }
    }

    private void u(boolean z, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, long j) {
        String str = z ? "缓存广告" : "实时广告";
        if (nVar.pn()) {
            if (nVar.jk()) {
                com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j);
                return;
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j);
            return;
        }
        if (nVar.iz()) {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j);
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j);
    }

    private void u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, final u uVar, com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        if (nVar != null && this.pb.get() <= 0) {
            final boolean zT = nVar.t();
            if (!fx(zT)) {
                com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.rh.get());
                nVar.u(nrVar);
                if (b()) {
                    uVar.u(nVar);
                    if (this.rh.get()) {
                        uVar.u(this.c);
                        return;
                    }
                    return;
                }
                final long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.2
                    @Override // java.lang.Runnable
                    public void run() {
                        iz.b(zT ? pn.this.kj : pn.this.qq, jCurrentTimeMillis);
                        uVar.u(nVar);
                        if (pn.this.rh.get()) {
                            uVar.u(pn.this.c);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
            this.bq = nVar;
            this.dw = nrVar;
            this.h.set(true);
            if (this.y.get()) {
                a();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.iz u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, final u uVar, final com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.nr nrVar2, final long j) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.iz(nrVar2, new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.3
            private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n iz;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
            public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar2 = this.iz;
                if (nVar2 != null) {
                    nVar2.pn(true);
                }
                pn.this.u(nVar, izVar, uVar, nrVar, j, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public void fx(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar) {
                this.iz = nVar;
                pn.this.u(nVar, izVar, uVar, nrVar, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.fx
            public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
                pn.this.u(izVar, xVar, uVar, j);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u u(final com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, final u uVar) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u(new com.bytedance.sdk.openadsdk.core.component.splash.fx.u.fx(this.x, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, izVar, nVar, this.b), new com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.pn.4
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar) {
                pn.this.pn(izVar.pn());
                if (pn.this.fx(aVar.fx())) {
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                    if (pn.this.m.get() && !pn.this.xg.get()) {
                        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "已经超时走缓存广告");
                        pn.this.xg.set(true);
                        uVar.u(aVar);
                    }
                    pn.this.ja.set(true);
                    pn.this.q = aVar;
                    return;
                }
                pn.this.rh.set(true);
                pn.this.c = aVar;
                if (pn.this.pb.get() == 2) {
                    if (!pn.this.my()) {
                        uVar.u(aVar);
                    } else {
                        if (pn.this.f5268jp.get()) {
                            return;
                        }
                        uVar.u(aVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b
            public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar) {
                if (!pn.this.fx(xVar.n())) {
                    pn.this.rh.set(false);
                    uVar.fx(xVar);
                } else {
                    pn.this.ja.set(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b
            public void u() {
                pn.this.nr(izVar);
            }
        }, this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.u uVar, boolean z) {
        if (uVar == null) {
            return;
        }
        int iFx = fx(u(izVar.pn()));
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "渲染 timeout " + iFx);
        if (this.d.get()) {
            return;
        }
        if (u(izVar.nr(), z) && this.n != null && iFx <= 0) {
            iFx = 0;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "开始渲染 isCache " + izVar.pn());
        u(uVar, izVar.pn(), iFx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a aVar) {
        if (aVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zFx = aVar.fx();
        if (zFx) {
            iz.u(u(zFx), this.gi, aVar);
            this.gi.b(jCurrentTimeMillis - this.mv);
            this.gi.b(this.fx);
            this.gi.u(zFx);
            iz.u(u(zFx), this.gi);
            iz.nr(u(zFx), this.gi);
        } else {
            iz.u(u(zFx), this.z, aVar);
            this.z.b(jCurrentTimeMillis - this.mv);
            this.z.b(this.fx);
            this.z.u(zFx);
            iz.u(u(zFx), this.z);
            iz.nr(u(zFx), this.z);
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (jCurrentTimeMillis - this.my));
        }
        StringBuilder sb = new StringBuilder("渲染成功回调 开屏广告类型： ");
        sb.append(zFx ? "缓存" : "实时");
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", sb.toString());
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "加载开屏广告--end，总耗时： " + (jCurrentTimeMillis - this.mv));
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "加载开屏广告--end，getReqId： " + u(zFx).xx());
    }

    private void u(String str, int i, int i2) {
        int iS = dw.nr().s(str);
        if (iS == 1) {
            this.jk = i > 0 ? Math.min(i, i2) : Math.max(i2, 500);
        } else if (iS != 2) {
            this.jk = i > 0 ? Math.max(i, i2) : Math.max(i2, 500);
        } else {
            this.jk = i > 0 ? i : Math.max(i2, 500);
        }
        int iCurrentTimeMillis = (int) (((long) this.jk) - (System.currentTimeMillis() - this.pn.n));
        if (iCurrentTimeMillis <= 0) {
            iCurrentTimeMillis = this.jk;
        }
        this.jk = iCurrentTimeMillis;
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "splashTimeOutControlType = " + iS + "; devTimeOut = " + i2 + "; cloudTimeOut = " + i + "; realTimeOut = " + this.jk);
        this.n.sendEmptyMessageDelayed(2, (long) this.jk);
        u(this.jk);
    }

    private void u(int i) {
        int iA = dw.nr().a(this.f5267a);
        if (iA >= i || iA <= 0 || !my() || this.n == null) {
            return;
        }
        int i2 = i - iA;
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "buffer time: " + iA + "  减去buffer time后超时时间：" + i2);
        this.n.sendEmptyMessageDelayed(4, (long) i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, u uVar, com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, boolean z) {
        if (this.d.get()) {
            return;
        }
        nr(nVar, System.currentTimeMillis());
        if (nVar.t()) {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存广告： 素材首包回调");
            this.wq.set(true);
        } else {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "实时广告： 素材首包回调");
            this.bf.set(true);
        }
        iz.u(nVar.t() ? this.kj : this.qq, 3);
        iz(nVar.t());
        if (z) {
            u(nVar, izVar, uVar);
        } else {
            u(nVar, izVar, uVar, nrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.n nVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, u uVar, com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, long j, boolean z) {
        if (nVar == null) {
            return;
        }
        u(izVar, izVar.pn(), false);
        if (this.d.get()) {
            return;
        }
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.presentation.u) {
            ((com.bytedance.sdk.openadsdk.core.component.splash.presentation.u) nrVar).u(nVar, false);
        }
        u(nVar, j);
        if (nVar.t() && this.wq.get()) {
            return;
        }
        if (nVar.t() || !this.bf.get()) {
            if (u(nVar.nr(), nVar.pn()) || u(izVar.nr())) {
                iz.u(nVar.t() ? this.kj : this.qq, 2);
                iz(nVar.t());
            }
            if (z) {
                u(nVar, izVar, uVar);
            } else {
                u(nVar, izVar, uVar, nrVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar, u uVar, long j) {
        if (xVar == null) {
            return;
        }
        boolean zN = xVar.n();
        if (!fx(zN)) {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            uVar.nr(xVar);
        } else {
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存广告: 素材加载失败");
            this.h.set(false);
            if (this.y.get()) {
                uVar.nr(xVar);
            }
        }
        u(izVar, zN, false);
        int i = xVar.iz() ? -14 : -7;
        if (!xVar.iz()) {
            x.u(j, false, false, u(xVar.n()), i, xVar.pn());
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", (zN ? "缓存广告" : "实时广告") + "加载素材失败 " + xVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar, boolean z, boolean z2) {
        if (z) {
            return;
        }
        try {
            if (this.pb.get() > 0 && !this.f5268jp.get()) {
                com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.u(this.b, this.pn)) {
                    return;
                }
                if (this.pb.get() > 0 || this.l.fx()) {
                    this.t.u(izVar, this.b, z2, this.fx);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void u(boolean z, int i) {
        (z ? this.gi : this.z).pn(i);
    }

    public static boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        return com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.u(nrVar, new oa()) && (com.bytedance.sdk.openadsdk.core.fx.pn.u().l() & 4) == 4;
    }
}
