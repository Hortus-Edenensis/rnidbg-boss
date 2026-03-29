package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rh implements Function<SparseArray<Object>, Object> {
    private volatile Context u;

    public rh(Context context) {
        this.u = (context == null ? dw.getContext() : context).getApplicationContext();
    }

    private void a(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        u(com.bytedance.sdk.openadsdk.core.y.h.u(7, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.a(function));
    }

    private Context getContext() {
        if (this.u == null) {
            this.u = dw.getContext();
        }
        return this.u;
    }

    private void n(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        u(com.bytedance.sdk.openadsdk.core.y.h.u(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.pn(function));
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public void b(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        u(com.bytedance.sdk.openadsdk.core.y.h.u(8, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.iz(function));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public void fx(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        u(1, com.bytedance.sdk.openadsdk.core.y.h.u(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.x(function));
    }

    public void iz(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        nr(com.bytedance.sdk.openadsdk.core.y.h.u(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.n(function));
    }

    public void nr(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.fx fxVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            fxVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.rh.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.b.u.b().u(nrVar, fxVar, jCurrentTimeMillis);
                } catch (Throwable th) {
                    fxVar.u(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (bg.u) {
            u(aVar, 6);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(6, nrVar);
        } else {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            fxVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        }
    }

    public void pn(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        u(com.bytedance.sdk.openadsdk.core.y.h.u(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.n(function));
    }

    public void x(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        fx(com.bytedance.sdk.openadsdk.core.y.h.u(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.n(function));
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.fx fxVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            fxVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.fx.u.b().u(nrVar, fxVar, jCurrentTimeMillis);
                } catch (Throwable th) {
                    fxVar.u(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            fxVar.u(10000, "Please exec  TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 5);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(5, nrVar);
        }
    }

    public void fx(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.iz izVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            izVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (rh.this.u(nrVar, false)) {
                        com.bytedance.sdk.openadsdk.core.component.u.u.b().u(nrVar, izVar, jCurrentTimeMillis);
                    } else {
                        izVar.u(110, x.u(110));
                    }
                } catch (Throwable th) {
                    izVar.u(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "Banner express error, pls check", th);
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            izVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 1);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(1, nrVar);
        }
    }

    public void nr(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        u(com.bytedance.sdk.openadsdk.core.y.h.u(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.b(function));
    }

    public void u(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        nr(com.bytedance.sdk.openadsdk.core.y.h.u(6, pluginValueSet), new com.bytedance.sdk.openadsdk.core.u.pn(function));
    }

    public void nr(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.iz izVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            izVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (rh.this.u(nrVar, false)) {
                        com.bytedance.sdk.openadsdk.core.component.nr.u.b().u(nrVar, izVar, jCurrentTimeMillis);
                    } else {
                        izVar.u(110, x.u(110));
                    }
                } catch (Throwable th) {
                    izVar.u(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "Error msg =", th);
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            izVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 9);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(9, nrVar);
        }
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.nr nrVar2) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            nrVar2.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    rh.this.u(nrVar);
                    com.bytedance.sdk.openadsdk.core.component.nr.u.b().u(nrVar, nrVar2, jCurrentTimeMillis);
                } catch (Throwable th) {
                    nrVar2.u(4000, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            nrVar2.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 9);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(9, nrVar);
        }
    }

    public void u(int i, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.pn pnVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            pnVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.u.u.b().u(nrVar, pnVar, jCurrentTimeMillis);
                } catch (Throwable th) {
                    pnVar.u(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "Error msg = ", th.getMessage());
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            pnVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, i);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(i, nrVar.b());
        }
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, com.bytedance.sdk.openadsdk.bq.u.nr.u.u uVar, int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.pn.u(getContext()).u(nrVar, uVar, i);
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.x xVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            xVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.u.n.u().u(nrVar, new com.bytedance.sdk.openadsdk.core.component.reward.u.b(xVar));
                } catch (Throwable th) {
                    xVar.u(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 7);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(7, nrVar);
        }
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            bVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.u.nr.u().u(nrVar, new com.bytedance.sdk.openadsdk.core.component.reward.u.b(bVar));
                } catch (Throwable th) {
                    bVar.u(4000, " msg = " + th.getMessage());
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            bVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 8);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(8, nrVar);
        }
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.iz izVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            izVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.jk.a aVar = new com.bytedance.sdk.component.jk.a("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.rh.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (rh.this.u(nrVar, false)) {
                        com.bytedance.sdk.openadsdk.core.component.fx.u.b().u(nrVar, izVar, jCurrentTimeMillis);
                    } else {
                        izVar.u(110, x.u(110));
                    }
                } catch (Throwable th) {
                    izVar.u(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.k.u("TTAdNativeImpl", "Error msg = ", th);
                }
            }
        };
        if (!bg.u) {
            com.bytedance.sdk.component.utils.k.nr("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            izVar.u(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            u(aVar, 5);
            com.bytedance.sdk.openadsdk.core.iz.u.fx().u(5, nrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        com.bytedance.sdk.component.utils.bg.u(nrVar.iz() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.component.utils.bg.u(nrVar.x() > 0, "必须设置图片素材尺寸");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z) {
        if (nrVar == null) {
            return false;
        }
        return (z && !dw.nr().a(nrVar.b())) || nrVar.n() > 0.0f;
    }

    public static boolean u() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    private void u(com.bytedance.sdk.component.jk.a aVar, int i) {
        if (u()) {
            com.bytedance.sdk.component.jk.x.pn(aVar);
        } else {
            com.bytedance.sdk.component.jk.t.nr.l().execute(aVar);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.bytedance.sdk.component.utils.k.u("apply->load with null ->SparseArray");
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999982);
        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetA.objectValue(1, Function.class);
        if (function == null) {
            com.bytedance.sdk.component.utils.k.u("apply->load with null callback");
            return null;
        }
        u(iIntValue, pluginValueSetA, function);
        return null;
    }

    public void u(int i, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        ll7 ll7VarK = ll7.k(pluginValueSet);
        ll7VarK.f(1, 0);
        PluginValueSet pluginValueSetA = ll7VarK.a();
        if (i == 1) {
            if (pluginValueSetA.booleanValue(2)) {
                x(pluginValueSetA, function);
                return;
            } else {
                fx(pluginValueSetA, function);
                return;
            }
        }
        if (i != 3) {
            switch (i) {
                case 5:
                    if (pluginValueSetA.booleanValue(2)) {
                        pn(pluginValueSetA, function);
                    } else {
                        n(pluginValueSetA, function);
                    }
                    break;
                case 6:
                    u(pluginValueSetA, function);
                    break;
                case 7:
                    a(pluginValueSetA, function);
                    break;
                case 8:
                    b(pluginValueSetA, function);
                    break;
                case 9:
                    if (pluginValueSetA.booleanValue(2)) {
                        iz(pluginValueSetA, function);
                    } else {
                        nr(pluginValueSetA, function);
                    }
                    break;
            }
            return;
        }
        u(com.bytedance.sdk.openadsdk.core.y.h.u(3, pluginValueSetA), new com.bytedance.sdk.openadsdk.core.u.fx(function), pluginValueSetA.intValue(3));
    }
}
