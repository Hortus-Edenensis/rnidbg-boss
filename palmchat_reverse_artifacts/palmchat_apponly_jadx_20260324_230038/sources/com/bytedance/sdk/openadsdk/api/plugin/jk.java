package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.a;
import com.bytedance.sdk.openadsdk.api.u;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import dalvik.system.BaseDexClassLoader;
import defpackage.ji7;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends com.bytedance.sdk.openadsdk.api.u {
    private static final u u = new u();
    private x b;
    private SharedPreferences pn;
    private boolean x;
    private volatile Initializer nr = pn();
    private volatile Initializer fx = null;
    private boolean iz = false;
    private com.bytedance.sdk.openadsdk.fx.fx n = new com.bytedance.sdk.openadsdk.fx.fx() { // from class: com.bytedance.sdk.openadsdk.api.plugin.jk.1
        @Override // com.bytedance.sdk.openadsdk.fx.fx
        public Function<SparseArray<Object>, Object> u(int i) {
            return jk.this.u(i);
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static final class fx {
        private static final fx u = new fx();
        private volatile Initializer nr;

        private fx() {
        }

        private static Initializer nr(x xVar) throws b {
            try {
                xVar.nr("call_create_initializer");
                BaseDexClassLoader baseDexClassLoaderU = a.u(TTAppContextHolder.getContext()).u(xVar, 60000);
                if (baseDexClassLoaderU == null) {
                    throw new b(4205, "Get ClassLoader failed");
                }
                Class<?> clsLoadClass = baseDexClassLoaderU.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                xVar.nr("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new a.fx());
                bundle.putInt("api_sdk_version", 7232);
                xVar.nr("create_bundle_cost");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                xVar.nr("get_init_method_cost");
                try {
                    com.bytedance.sdk.openadsdk.api.b bVar = new com.bytedance.sdk.openadsdk.api.b((Function) declaredMethod.invoke(null, bundle));
                    xVar.nr("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "Create initializer success");
                    return bVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                if (th2 instanceof b) {
                    throw th2;
                }
                throw new b(4206, "Create initializer failed", th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer u(x xVar) throws b {
            if (this.nr == null) {
                synchronized (this) {
                    if (this.nr == null) {
                        this.nr = nr(xVar);
                    }
                }
            }
            return this.nr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends u.fx {
        private u() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.u.fx
        public void u(Throwable th) {
            a.u(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.u.fx
        public Object u(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                a.u(TTAppContextHolder.getContext()).u((TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.fx.u((ILiveAdCustomConfig) obj) : com.bytedance.sdk.openadsdk.d.nr.u(obj) ? new com.bytedance.sdk.openadsdk.d.nr(obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return a.u(TTAppContextHolder.getContext()).u(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        ExecutorService executorService = (ExecutorService) u(ExecutorService.class, 1);
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            t.nr.u(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.sx.u.u().u(threadPoolExecutor);
        }
        ExecutorService executorService2 = (ExecutorService) u(ExecutorService.class, 2);
        if (executorService2 != null) {
            t.nr.nr((ThreadPoolExecutor) executorService2);
        }
        ExecutorService executorService3 = (ExecutorService) u(ExecutorService.class, 3);
        if (executorService3 != null) {
            t.nr.u((ScheduledExecutorService) executorService3);
        }
    }

    private static Initializer pn() {
        try {
            if (com.bytedance.sdk.openadsdk.api.pn.u()) {
                return null;
            }
            Class<?> clsLoadClass = TTAdSdk.class.getClassLoader().loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new a.fx());
            bundle.putInt("api_sdk_version", 7232);
            Object objInvoke = clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class).invoke(null, bundle);
            if (objInvoke == null) {
                iz.u(4206, "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder getNewInstance null", false, null, null);
            }
            return new com.bytedance.sdk.openadsdk.api.b((Function) objInvoke);
        } catch (Throwable th) {
            iz.u(4206, th.getMessage(), false, null, th);
            com.bytedance.sdk.openadsdk.api.iz.pn("_tt_ad_sdk_", "Get direct initializer failed", th);
            return null;
        }
    }

    public boolean b() {
        if (this.pn == null) {
            this.pn = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
        }
        return this.pn.getInt("_use_pl_", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public com.bytedance.sdk.openadsdk.fx.fx fx() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public boolean nr(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.nr(context, adConfig, initCallback);
        this.b = x.u("duration");
        boolean z = false;
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.iz.nr("_tt_ad_sdk_", e);
        }
        if (com.bytedance.sdk.openadsdk.api.pn.u()) {
            nr(ji7.b().f(false).c(4204).e("Only support >= 7.0").a());
            return false;
        }
        if (adConfig != null && adConfig.isDebug()) {
            z = true;
        }
        this.x = z;
        iz.u(adConfig);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public void u(Result result) {
        super.u(result);
        iz.u();
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public boolean u(Context context, wc7 wc7Var) {
        if (u(context) && b()) {
            com.bytedance.sdk.openadsdk.api.iz.fx("_tt_ad_sdk_", "use pl Init");
            return false;
        }
        if (com.bytedance.sdk.openadsdk.api.plugin.fx.fx.nr()) {
            com.bytedance.sdk.openadsdk.api.iz.pn("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.nr != null) {
            this.iz = true;
            u(this.nr.getManager(), false);
            this.nr.init(context, wc7Var.a());
            return false;
        }
        nr(ji7.b().f(false).c(4206).a());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public void nr(Context context, wc7 wc7Var) {
        com.bytedance.sdk.openadsdk.api.iz.fx("_tt_ad_sdk_", "async init");
        if (this.iz && Build.VERSION.SDK_INT < 26) {
            com.bytedance.sdk.openadsdk.api.iz.b("_tt_ad_sdk_", "lower 26");
            return;
        }
        this.b.nr("wait_asyn_cost");
        a.u(TTAppContextHolder.getContext());
        if (!com.bytedance.sdk.openadsdk.api.plugin.fx.fx.nr() && !u(context)) {
            com.bytedance.sdk.openadsdk.api.iz.b("_tt_ad_sdk_", "no pl");
        } else {
            com.bytedance.sdk.openadsdk.api.iz.b("_tt_ad_sdk_", "start pl load");
            u(this.b, wc7Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class nr implements Function<SparseArray<Object>, Object> {
        private nr() {
        }

        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }

        public ValueSet u(int i, Result result) {
            com.bytedance.sdk.openadsdk.api.iz.fx("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (!result.isSuccess()) {
                iz.u(result.code(), result.message(), true ^ jk.this.iz, null, null);
            } else if (jk.this.fx != null) {
                if (jk.this.iz && jk.this.nr != null && jk.this.nr.isInitSuccess()) {
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.nr.getManager(), result);
                }
                jk jkVar2 = jk.this;
                jkVar2.nr = jkVar2.fx;
                jk jkVar3 = jk.this;
                jkVar3.u(jkVar3.nr.getManager(), true);
            }
            if (!jk.this.iz) {
                jk.this.nr(result);
            }
            if (result.isSuccess() && jk.this.fx != null) {
                jk.this.iz();
            }
            return null;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetA = wc7.k(sparseArray).a();
            int iIntValue = valueSetA.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetA.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 != null) {
                ValueSet valueSetA2 = wc7.k(sparseArray2).a();
                u(iIntValue, ji7.b().c(valueSetA2.intValue(-999900)).e(valueSetA2.stringValue(-999901)).f(valueSetA2.booleanValue(-999903)).d(wc7.k((SparseArray) valueSetA2.objectValue(-999902, SparseArray.class)).a()).a());
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public boolean u() {
        return (com.bytedance.sdk.openadsdk.api.pn.u() || this.nr == null || !this.nr.isInitSuccess()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.u
    public u.fx nr() {
        return u;
    }

    private boolean u(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.nr.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> u(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.fx.u();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.fx.u(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.u.u.u();
    }

    private void u(x xVar, wc7 wc7Var) {
        if (this.fx == null || !this.fx.isInitSuccess()) {
            wc7 wc7VarK = wc7.k(wc7Var.a().sparseArray());
            wc7VarK.h(15, new nr());
            try {
                if (this.fx == null) {
                    synchronized (fx.class) {
                        if (this.fx == null) {
                            Initializer initializerU = fx.u.u(xVar);
                            this.fx = initializerU;
                            u(initializerU, xVar, wc7VarK);
                        }
                    }
                }
            } catch (Exception e) {
                int iU = e instanceof b ? ((b) e).u() : 4206;
                iz.u(iU, e.getMessage(), true, xVar, e);
                if (this.iz) {
                    return;
                }
                nr(ji7.b().f(false).c(iU).e(e.getMessage()).a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Manager manager, Result result) {
        if (manager == null || !(manager instanceof com.bytedance.sdk.openadsdk.api.fx)) {
            return;
        }
        Function<SparseArray<Object>, Object> functionU = ((com.bytedance.sdk.openadsdk.api.fx) manager).u(1);
        if (functionU instanceof Function) {
            functionU.apply(wc7.c(1).f(-99999987, 16).h(-99999985, Void.class).j(17, true).h(21, result.values() == null ? null : result.values().sparseArray()).a().sparseArray());
        }
    }

    private <T> T u(Class<T> cls, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", i);
        return (T) nr().getExtra(cls, bundle);
    }

    private static void u(Initializer initializer, x xVar, wc7 wc7Var) throws b {
        if (initializer != null) {
            try {
                xVar.u();
                JSONObject jSONObject = new JSONObject();
                xVar.u(jSONObject, 20L);
                jSONObject.put("zeus", a.u(TTAppContextHolder.getContext()).u());
                wc7Var.h(17, com.bytedance.sdk.openadsdk.sx.u.u().nr());
                t tVar = t.nr;
                wc7Var.h(20, tVar.a());
                wc7Var.h(19, tVar.jk());
                wc7Var.h(21, tVar.l());
                wc7Var.h(22, new com.bytedance.sdk.openadsdk.ats.fx());
                initializer.init(TTAppContextHolder.getContext(), wc7Var.h(9, jSONObject).a());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                }
                com.bytedance.sdk.openadsdk.api.iz.nr("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new b(4207, "Init error", e);
            }
        }
        throw new b(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "initializer null");
    }
}
