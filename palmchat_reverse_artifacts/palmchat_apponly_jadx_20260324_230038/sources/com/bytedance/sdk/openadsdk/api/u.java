package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import defpackage.ji7;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    private TTAdSdk.InitCallback u;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Function<SparseArray<Object>, Object> {
        private b() {
        }

        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray == null || (sparseArray2 = (SparseArray) wc7.k(sparseArray).a().objectValue(-99999979, SparseArray.class)) == null) {
                return null;
            }
            ValueSet valueSetA = wc7.k(sparseArray2).a();
            u.this.nr(ji7.b().c(valueSetA.intValue(-999900)).e(valueSetA.stringValue(-999901)).f(valueSetA.booleanValue(-999903)).d(wc7.k((SparseArray) valueSetA.objectValue(-999902, SparseArray.class)).a()).a());
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class fx implements TTAdManager {
        private Map<nr<Manager>, Object> b = new WeakHashMap();
        private volatile boolean fx;
        private volatile boolean nr;
        private volatile Manager u;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.u$fx$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchBox */
        public class AnonymousClass1 extends AbstractC0235u<Loader> {
            final /* synthetic */ SoftReference fx;
            final nr<Manager> nr;
            Loader u;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.fx = softReference;
                this.nr = new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.u.nr
                    public void u(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.u = manager.createLoader((Context) anonymousClass1.fx.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.u.AbstractC0235u
            public void u(final nr<Loader> nrVar, int i) {
                Loader loader = this.u;
                if (loader != null) {
                    nrVar.u(loader);
                } else {
                    fx.this.call(new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.u.nr
                        public void u(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            fx.this.u(anonymousClass1.nr);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.u = manager.createLoader((Context) anonymousClass12.fx.get());
                            nrVar.u(AnonymousClass1.this.u);
                        }
                    }, i + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final nr<Manager> nrVar, final int i) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return;
            }
            if (this.u == null) {
                if (!this.nr && i > 10000) {
                    throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
                }
                com.bytedance.sdk.openadsdk.sx.u.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (fx.this.u != null) {
                                nrVar.u(fx.this.u);
                                return;
                            }
                            iz.b("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        } catch (Throwable th) {
                            iz.b("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                            fx.this.u(th);
                        }
                    }
                });
                return;
            }
            try {
                nrVar.u(this.u);
            } catch (Throwable th) {
                iz.b("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                u(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T nr(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> functionU;
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return null;
            }
            SparseArray<Object> sparseArray = wc7.c(3).h(9, cls).h(10, bundle).f(-99999987, 6).h(-99999985, cls).a().sparseArray();
            if (!(manager instanceof com.bytedance.sdk.openadsdk.api.fx) || (functionU = ((com.bytedance.sdk.openadsdk.api.fx) manager).u(1)) == null) {
                return null;
            }
            return (T) functionU.apply(sparseArray);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return null;
            }
            return new pn(new AnonymousClass1(new SoftReference(context))).u();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return null;
            }
            if (this.u != null) {
                return (T) nr(this.u, cls, bundle);
            }
            call(new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.4
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Manager manager) {
                    fx.nr(fx.this.u, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.u != null ? this.u.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.2.3.2";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.u != null) {
                return this.u.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> functionU;
            ValueSet valueSetA = wc7.b().h(20, bundle).f(-99999987, 19).h(-99999985, Bundle.class).a();
            if ((this.u instanceof com.bytedance.sdk.openadsdk.api.fx) && (functionU = ((com.bytedance.sdk.openadsdk.api.fx) this.u).u(1)) != null) {
                Object objApply = functionU.apply(valueSetA.sparseArray());
                if (objApply instanceof Bundle) {
                    return (Bundle) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return;
            }
            call(new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.2
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Manager manager) {
                    Function<SparseArray<Object>, Object> functionU;
                    SparseArray<Object> sparseArray = wc7.c(2).h(8, fx.this.u(obj)).f(-99999987, 4).h(-99999985, Void.class).a().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.fx) || (functionU = ((com.bytedance.sdk.openadsdk.api.fx) manager).u(1)) == null) {
                        return;
                    }
                    functionU.apply(sparseArray);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return;
            }
            call(new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.5
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Manager manager) {
                    Function<SparseArray<Object>, Object> functionU;
                    SparseArray<Object> sparseArray = wc7.c(2).h(7, context).f(-99999987, 3).h(-99999985, Void.class).a().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.fx) || (functionU = ((com.bytedance.sdk.openadsdk.api.fx) manager).u(1)) == null) {
                        return;
                    }
                    functionU.apply(sparseArray);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return;
            }
            call(new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.6
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Manager manager) {
                    Function<SparseArray<Object>, Object> functionU;
                    ValueSet valueSetA = wc7.b().f(11, i).f(-99999987, 1).h(-99999985, Void.class).a();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.fx) || (functionU = ((com.bytedance.sdk.openadsdk.api.fx) manager).u(1)) == null) {
                        return;
                    }
                    functionU.apply(valueSetA.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return false;
            }
            HashMap map = new HashMap();
            map.put("activity", activity);
            map.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, new com.bytedance.sdk.openadsdk.my.u.nr.u(exitInstallListener));
            Object objApply = com.bytedance.sdk.openadsdk.downloadnew.fx.u(TTAppContextHolder.getContext()).apply(wc7.c(2).h(0, map).f(-99999987, 0).h(-99999985, Boolean.class).a().sparseArray());
            if (objApply == null) {
                return false;
            }
            return ((Boolean) objApply).booleanValue();
        }

        public Object u(Object obj) {
            return obj;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return;
            }
            call(new nr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.u.fx.3
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Manager manager) {
                    Function<SparseArray<Object>, Object> functionU;
                    Object nrVar = obj;
                    if (com.bytedance.sdk.openadsdk.d.nr.u(nrVar)) {
                        nrVar = new com.bytedance.sdk.openadsdk.d.nr(obj);
                    }
                    SparseArray<Object> sparseArray = wc7.c(2).h(8, nrVar).f(-99999987, 5).h(-99999985, Void.class).a().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.fx) || (functionU = ((com.bytedance.sdk.openadsdk.api.fx) manager).u(1)) == null) {
                        return;
                    }
                    functionU.apply(sparseArray);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> functionU;
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetA = wc7.k(com.bytedance.sdk.openadsdk.my.u.fx.nr.u(adSlot)).j(13, z).f(14, i).f(-99999987, 2).h(-99999985, String.class).a();
            if ((this.u instanceof com.bytedance.sdk.openadsdk.api.fx) && (functionU = ((com.bytedance.sdk.openadsdk.api.fx) this.u).u(1)) != null) {
                Object objApply = functionU.apply(valueSetA.sparseArray());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
            }
            return null;
        }

        public void u(Throwable th) {
        }

        public void u(boolean z) {
            this.nr = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Manager manager, boolean z) {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return;
            }
            this.fx = z;
            this.u = manager;
            if (this.u == null || !z) {
                return;
            }
            try {
                Iterator<nr<Manager>> it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    it.next().u(this.u);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(nr<Manager> nrVar) {
            if (com.bytedance.sdk.openadsdk.api.pn.u() || this.fx) {
                return;
            }
            this.b.put(nrVar, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr<T> {
        void u(T t);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractC0235u<T> {
        private AbstractC0235u() {
        }

        public abstract void u(nr<T> nrVar, int i);
    }

    public abstract com.bytedance.sdk.openadsdk.fx.fx fx();

    public abstract fx nr();

    public abstract void nr(Context context, wc7 wc7Var);

    public boolean nr(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public void u(Result result) {
    }

    public abstract boolean u();

    public abstract boolean u(Context context, wc7 wc7Var);

    /* JADX INFO: compiled from: SearchBox */
    public static class pn extends com.bytedance.sdk.openadsdk.my.u.u {
        private AbstractC0235u<Loader> u;

        public pn(AbstractC0235u<Loader> abstractC0235u) {
            this.u = abstractC0235u;
        }

        private void u(nr<Loader> nrVar, int i) {
            iz.nr("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.u.u(nrVar, i);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void a(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.2
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).j(2, true).h(1, function).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void b(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.5
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).h(1, function).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void fx(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.4
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).h(1, function).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void iz(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.8
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).h(1, function).a(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void n(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.10
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).j(2, true).h(1, function).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void nr(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.3
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).h(1, function).a(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void pn(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.7
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).h(1, function).a(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void x(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.9
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).j(2, true).h(1, function).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void u(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.1
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).h(1, function).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public void u(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            u(new nr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.u.pn.6
                @Override // com.bytedance.sdk.openadsdk.api.u.nr
                public void u(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, wc7.k(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).f(3, i).h(1, function).a(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.my.u.u
        public Pair<Integer, String> u(Exception exc) {
            iz.b("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    public void nr(Result result) {
        u(result);
        if (result.isSuccess()) {
            iz.nr("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.u;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            iz.pn("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.u;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.u = null;
    }

    public void u(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.bytedance.sdk.openadsdk.api.pn.u()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.fx.b.u().u(fx());
        if (nr(context, adConfig, initCallback)) {
            this.u = initCallback;
            final wc7 wc7VarK = wc7.k(com.bytedance.sdk.openadsdk.my.u.fx.u.u(adConfig));
            wc7VarK.g(1, SystemClock.elapsedRealtime());
            wc7VarK.i(5, "main");
            wc7VarK.j(4, true);
            wc7VarK.f(6, 999);
            wc7VarK.f(10, 7232);
            wc7VarK.i(11, "7.2.3.2");
            wc7VarK.i(12, "com.byted.pangle");
            wc7VarK.j(14, true);
            wc7VarK.h(16, com.bytedance.sdk.openadsdk.fx.b.u());
            wc7VarK.h(17, com.bytedance.sdk.openadsdk.sx.u.u().nr());
            Thread threadCurrentThread = Thread.currentThread();
            wc7VarK.i(2, threadCurrentThread.getName());
            wc7VarK.f(3, threadCurrentThread.getPriority());
            wc7VarK.h(15, new b());
            wc7VarK.h(8301, new MediationInitCLassLoader());
            if (!u(context, wc7VarK)) {
                com.bytedance.sdk.openadsdk.sx.u.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr(context, wc7VarK);
                    }
                });
            }
            nr().u(true);
        }
    }

    public void u(Manager manager, boolean z) {
        iz.nr("_tt_ad_sdk_", "update manager");
        nr().u(manager, z);
        nr().register(com.bytedance.sdk.openadsdk.fx.b.u());
    }
}
