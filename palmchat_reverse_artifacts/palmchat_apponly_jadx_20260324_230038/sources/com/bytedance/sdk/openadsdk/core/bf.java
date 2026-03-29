package com.bytedance.sdk.openadsdk.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import defpackage.ml7;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bf {
    private Function<SparseArray<Object>, Object> n;
    private static final bf b = new bf();
    private static int x = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5215a = "ext_plugin";
    private volatile Function<SparseArray<Object>, Object> u = null;
    private volatile Function<SparseArray<Object>, Object> nr = null;
    private volatile Function<SparseArray<Object>, Object> fx = null;
    private AtomicBoolean pn = new AtomicBoolean(false);
    private AtomicBoolean iz = new AtomicBoolean(false);

    private bf() {
    }

    private static String a() {
        return (String) n.o().v().apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(String.class).u(0, "com.byted.csj.ext").nr());
    }

    public static void fx() {
        if (d.fx < 5001) {
            return;
        }
        if (!dw.nr().wq()) {
            JSONObject jSONObjectWq = n.o().wq();
            if (jSONObjectWq != null) {
                jSONObjectWq.remove("com.byted.csj.ext");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        Bundle bundleU = u(n.o().c());
        if (bundleU != null) {
            bundle.putBundle("com.byted.csj.ext", bundleU);
        }
        n.o().u(bundle);
    }

    private Integer iz() {
        Function<SparseArray<Object>, Object> functionL = l();
        if (functionL != null) {
            Object objApply = functionL.apply(com.bytedance.sdk.openadsdk.my.b.u().u(1004).u(Integer.class).nr());
            if (objApply instanceof Integer) {
                return (Integer) objApply;
            }
        }
        return -1;
    }

    private static String jk() {
        try {
            Function<SparseArray<Object>, Object> functionV = n.o().v();
            JSONObject jSONObjectOptJSONObject = n.o().wq().optJSONObject("com.byted.csj.ext");
            Object objApply = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, "com.byted.csj.ext").nr());
            if (!(objApply != null ? ((Boolean) objApply).booleanValue() : false)) {
                return jSONObjectOptJSONObject == null ? "0.0.0.0" : (String) jSONObjectOptJSONObject.opt(PluginConstants.KEY_PLUGIN_VERSION);
            }
            if (u().b()) {
                return t();
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr(f5215a, "ignore:" + th.getMessage());
            return "0.0.0.0";
        }
    }

    private Function<SparseArray<Object>, Object> l() {
        ClassLoader classLoader;
        try {
            if (this.n == null && (classLoader = (ClassLoader) n.o().v().apply(com.bytedance.sdk.openadsdk.my.b.u().u(4).u(ClassLoader.class).u(0, "com.byted.csj.ext").nr())) != null) {
                this.n = (Function) classLoader.loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return this.n;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr(f5215a, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    private static String n() {
        int i = d.fx;
        return (i == 5001 || i == 5002) ? jk() : a();
    }

    public static int nr() {
        if (x == -1) {
            x = u().iz().intValue();
        }
        return x;
    }

    private static String t() {
        try {
            Integer numIz = u().iz();
            if (numIz.intValue() != -1) {
                return nr(numIz.intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static bf u() {
        return b;
    }

    private Function<SparseArray<Object>, Object> x() {
        com.bytedance.sdk.openadsdk.core.rh.fx fxVar = (com.bytedance.sdk.openadsdk.core.rh.fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya");
        if (fxVar == null || !fxVar.isPitayaEnvAvailable()) {
            com.bytedance.sdk.component.utils.k.nr(f5215a, "can use pitaya false");
            return null;
        }
        if (!b() || iz().intValue() < 1100) {
            return null;
        }
        if (this.fx == null) {
            synchronized (bf.class) {
                if (this.fx == null) {
                    try {
                        Function<SparseArray<Object>, Object> functionL = l();
                        if (functionL != null) {
                            Object objApply = functionL.apply(com.bytedance.sdk.openadsdk.my.b.u().u(10003).u(Function.class).nr());
                            if (objApply instanceof Function) {
                                this.fx = (Function) objApply;
                            }
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.k.nr(f5215a, "getBridge:" + th.getMessage());
                    }
                }
            }
        }
        return this.fx;
    }

    public boolean b() {
        try {
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr(f5215a, "pit_ext_error:" + th.getMessage());
        }
        if (d.fx < 5001 || !dw.nr().wq()) {
            return false;
        }
        if (this.pn.get()) {
            return true;
        }
        if (this.iz.compareAndSet(false, true)) {
            final Function<SparseArray<Object>, Object> functionV = n.o().v();
            Object objApply = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, "com.byted.csj.ext").nr());
            if (objApply != null ? ((Boolean) objApply).booleanValue() : false) {
                Object objApply2 = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(7).u(Boolean.class).u(0, "com.byted.csj.ext").nr());
                if (objApply2 != null ? ((Boolean) objApply2).booleanValue() : false) {
                    this.pn.set(true);
                    this.iz.set(false);
                } else {
                    com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bf.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bf.this.u(functionV, true);
                        }
                    });
                }
            } else {
                this.iz.set(false);
            }
        }
        return false;
    }

    public ml7 pn() {
        if (d.fx >= 5001 && com.bytedance.sdk.openadsdk.core.c.nr.u(dw.nr().bc()) && b()) {
            return (ml7) com.bytedance.sdk.openadsdk.ats.fx.u("alog");
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> u(int i) {
        try {
            if (d.u() && i == 10003) {
                return x();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String nr(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        String string = sb.toString();
        if (i < 100 || i >= 1000) {
            return string;
        }
        return "0." + string;
    }

    private static Bundle u(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            String strN = n();
            if (TextUtils.isEmpty(strN)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strN);
            bundle.putString("sdk_version", nr(d.pn));
            return bundle;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr(f5215a, "error:" + th.getMessage());
            return null;
        }
    }

    public boolean u(Function<SparseArray<Object>, Object> function, boolean z) {
        try {
            if (this.pn.get()) {
                return true;
            }
            if (!z) {
                this.iz.set(true);
            }
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(5).u(Boolean.class).u(0, "com.byted.csj.ext").nr());
            boolean zBooleanValue = objApply != null ? ((Boolean) objApply).booleanValue() : false;
            this.pn.set(zBooleanValue);
            this.iz.set(false);
            return zBooleanValue;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr(f5215a, ":" + th.getMessage());
            return false;
        }
    }
}
