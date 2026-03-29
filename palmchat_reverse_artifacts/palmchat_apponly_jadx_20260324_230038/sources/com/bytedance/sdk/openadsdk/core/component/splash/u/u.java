package com.bytedance.sdk.openadsdk.core.component.splash.u;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.lf;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.p;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.y.bg;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.jk;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    protected pn iz;
    protected long u = 0;
    protected long nr = 0;
    protected AtomicBoolean fx = new AtomicBoolean(false);
    protected AtomicBoolean b = new AtomicBoolean(false);
    protected AtomicBoolean pn = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0257u {
        void u();

        void u(iz izVar);
    }

    public static u u() {
        return (com.bytedance.sdk.openadsdk.core.fx.pn.u().t() & 16) == 16 ? new fx() : new b();
    }

    public abstract void fx();

    public abstract void nr();

    public void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar) {
        if (dw.nr().nr(jp.nr(nrVar)) && nrVar != null && TextUtils.isEmpty(nrVar.dw())) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "preLoadSplashAd... ");
            oa oaVar2 = oaVar == null ? new oa() : oaVar.u();
            oaVar2.x = System.currentTimeMillis();
            oaVar2.mv = n.o().nb();
            u(nrVar, oaVar2);
        }
    }

    public abstract void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b<a, x> bVar, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z);

    public abstract void u(x xVar, String str, InterfaceC0257u interfaceC0257u, pn pnVar);

    public abstract void u(lf lfVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z);

    public abstract void u(String str, bc bcVar);

    public abstract void u(String str, String str2, boolean z, boolean z2, Object obj);

    public void u(iz izVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z, int i) {
        if (u(i) && com.bytedance.sdk.openadsdk.core.pn.b.pn.u(izVar.nr()) && !this.fx.get()) {
            this.fx.set(true);
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            u(new lf(izVar.b(), izVar.nr(), null), nrVar, false);
            if (z) {
                u(izVar.b(), izVar.nr(), nrVar);
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean u(int i) {
        int iT = com.bytedance.sdk.openadsdk.core.fx.pn.u().t();
        return i == 2 ? (iT & 2) == 2 : (i == 3 || i == 1) && (iT & 32) == 32;
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar) {
        if (this.fx.get()) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.b.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (dw.nr().jk(nrVar.b()) && oaVar != null) {
            oaVar.iz = 2;
        }
        dw.u().u(nrVar, oaVar, 4, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.u.1
            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                u.this.b.set(false);
                nrVar2.u(i);
                com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                if (com.bytedance.sdk.openadsdk.core.component.splash.x.nr(uVar)) {
                    bc bcVar = uVar.nr().get(0);
                    if (bcVar.fq()) {
                        AtomicBoolean atomicBoolean = u.this.fx;
                        if ((atomicBoolean == null || !atomicBoolean.get()) && com.bytedance.sdk.openadsdk.core.pn.b.pn.u(bcVar)) {
                            u.this.u(new lf(uVar, bcVar, null), nrVar, false);
                            u.this.u(uVar, bcVar, nrVar);
                            return;
                        }
                        return;
                    }
                    nrVar2.u(-4);
                    com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar2);
                    return;
                }
                u.this.b.set(false);
            }
        });
    }

    public void u(final com.bytedance.sdk.openadsdk.core.kj.u uVar, final bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (bcVar.zu() == null || bcVar.zu().size() <= 0) {
            return;
        }
        rh rhVar = bcVar.zu().get(0);
        String strU = rhVar.u();
        int iNr = rhVar.nr();
        int iFx = rhVar.fx();
        this.u = System.currentTimeMillis();
        this.nr = SystemClock.elapsedRealtime();
        p pVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().fx().fx();
        if (pVarFx != null) {
            pVarFx.u(false);
        }
        final boolean z = zx.k(bcVar) != null;
        bg.u(new com.bytedance.sdk.openadsdk.mv.nr(strU, rhVar.x()), iNr, iFx, new bg.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.u.2
            @Override // com.bytedance.sdk.openadsdk.core.y.bg.u
            public void u(com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar2, my myVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.x.u(uVar);
                if (!z) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, WifiNestConst.NestTypeConst.NEST_SPLASH_AD, System.currentTimeMillis() - u.this.u);
                }
                u uVar2 = u.this;
                uVar2.u = 0L;
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.x.u(uVar2.nr, false, true, bcVar, 0L, "preLoadImageSuccess");
                }
                u.this.b.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.bg.u
            public void u() {
                com.bytedance.sdk.openadsdk.core.component.splash.x.u(uVar);
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.x.u(u.this.nr, false, false, bcVar, -7L, "preLoadImageFailed");
                }
                u.this.b.set(false);
            }
        }, jk.pn(), 4, null, false);
    }
}
