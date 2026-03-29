package com.bytedance.sdk.openadsdk.core.rh;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.bt;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements fx, u.nr, Function {
    private Function<SparseArray<Object>, Object> fx;
    private AtomicBoolean u = new AtomicBoolean(false);
    private AtomicBoolean nr = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB != null) {
            uVarB.u(this);
        }
    }

    private void iz() {
        if (this.fx == null) {
            this.fx = new n() { // from class: com.bytedance.sdk.openadsdk.core.rh.iz.2
                @Override // com.bytedance.sdk.openadsdk.core.rh.n, com.bytedance.sdk.openadsdk.core.bc.b
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    com.bytedance.sdk.openadsdk.my.u uVar = new com.bytedance.sdk.openadsdk.my.u((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
                    try {
                        if (i == 1) {
                            JSONObject jSONObject = (JSONObject) uVar.b().objectValue(10, JSONObject.class);
                            u.u().u(jSONObject.optString(bt.e), jSONObject.optString("key"), jSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", true);
                            return (T) com.bytedance.sdk.openadsdk.my.b.u().u(37, jSONObject2).nr();
                        }
                        if (i != 2) {
                            return (T) super.applyFunction(i, pluginValueSet, cls);
                        }
                        JSONObject jSONObject3 = (JSONObject) uVar.b().objectValue(10, JSONObject.class);
                        String strOptString = jSONObject3.optString(bt.e);
                        String strOptString2 = jSONObject3.optString("key");
                        String strU = u.u().u(strOptString, strOptString2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(strOptString2, strU);
                        return (T) com.bytedance.sdk.openadsdk.my.b.u().u(37, jSONObject4).nr();
                    } catch (JSONException unused) {
                        return (T) com.bytedance.sdk.openadsdk.my.b.u().u(37, new JSONObject()).nr();
                    }
                }
            };
        }
    }

    private Function<SparseArray<Object>, Object> pn() {
        Function<SparseArray<Object>, Object> functionU = dw.u(10003);
        if (functionU != null && isPitayaInitSuccess()) {
            return functionU;
        }
        return null;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            init((Context) sparseArray.get(1), (Function) sparseArray.get(2));
            return null;
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(isPitayaEnvAvailable());
        }
        if (iIntValue == 3) {
            return Boolean.valueOf(isPitayaInitSuccess());
        }
        if (iIntValue == 4) {
            runTask((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Function) sparseArray.get(3));
            return null;
        }
        if (iIntValue != 6) {
            return null;
        }
        queryPackage((String) sparseArray.get(1), (Function) sparseArray.get(2));
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public boolean fx() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public void init(Context context, final Function<SparseArray<Object>, Object> function) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (dw.u(10003) == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(-1).u(Void.class).nr());
                return;
            }
            return;
        }
        if (isPitayaInitSuccess()) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(0).u(Void.class).nr());
                return;
            }
            return;
        }
        try {
            if (this.u.compareAndSet(false, true)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("aid", "1371");
                jSONObject.put("channel", d.x);
                jSONObject.put("core_api_version", d.b);
                jSONObject.put("core_plugin_version", "7.2.3.2");
                jSONObject.put("debug", false);
                jSONObject.put("update", true);
                jSONObject.put("download_concurrency", 2);
                jSONObject.put("py_concurrency", 2);
                jSONObject.put("provide_applog", true);
                jSONObject.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.qq.nr.u);
                iz();
                function.apply(com.bytedance.sdk.openadsdk.my.b.u(ll7.b().g(21, jSONObject).g(22, context).g(38, this.fx).g(1, new n() { // from class: com.bytedance.sdk.openadsdk.core.rh.iz.1
                    @Override // com.bytedance.sdk.openadsdk.core.rh.n
                    public PluginValueSet u(int i, pn pnVar) {
                        iz.this.nr.set(pnVar.u());
                        if (pnVar.u()) {
                            Function function2 = function;
                            if (function2 != null) {
                                function2.apply(com.bytedance.sdk.openadsdk.my.b.u().u(0).u(Void.class).nr());
                            }
                            iz.this.b();
                        } else {
                            if (pnVar.nr() != null) {
                                k.nr("pitaya_ext_plugin", "pit error:" + pnVar.nr().toString());
                            }
                            Function function3 = function;
                            if (function3 != null) {
                                function3.apply(com.bytedance.sdk.openadsdk.my.b.u().u(-1).u(Void.class).nr());
                            }
                        }
                        iz.this.u(System.currentTimeMillis() - jCurrentTimeMillis, pnVar);
                        return super.u(i, pnVar);
                    }
                }).g(13, com.bytedance.sdk.component.jk.x.u()).a().sparseArray()).u(1001).u(Void.class).nr());
            }
        } catch (Throwable th) {
            k.nr("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(-1).u(Void.class).nr());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public boolean isPitayaEnvAvailable() {
        int i;
        if (!d.u() || d.fx < 5003 || (i = Build.VERSION.SDK_INT) < 28) {
            return false;
        }
        if (fx() && i == 29) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.c.nr.nr(dw.nr().bc());
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public boolean isPitayaInitSuccess() {
        return this.nr.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public void queryPackage(String str, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> functionU = dw.u(10003);
        if (functionU != null) {
            ll7 ll7VarB = ll7.b();
            ll7VarB.g(1, function);
            ll7VarB.h(25, str);
            functionU.apply(com.bytedance.sdk.openadsdk.my.b.u(ll7VarB.a().sparseArray()).u(1004).u(Void.class).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> functionU = dw.u(10003);
        if (functionU != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("run_package_start", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            functionU.apply(com.bytedance.sdk.openadsdk.my.b.u().u(1003).u(Void.class).u(25, str).u(26, jSONObject).u(1, function).u(37, jSONObject2).nr());
        } else if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(Void.class).u(-99999979, com.bytedance.sdk.openadsdk.my.pn.u().u(-6).u(false).u("predict bridge is null").u(com.bytedance.sdk.openadsdk.my.b.u().u(5, str).nr()).nr()).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void nr() {
        Function<SparseArray<Object>, Object> functionPn;
        try {
            if (com.bytedance.sdk.openadsdk.core.n.o().ja() || (functionPn = pn()) == null) {
                return;
            }
            functionPn.apply(com.bytedance.sdk.openadsdk.my.b.u().u(1008).u(Void.class).u(36, 0).nr());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, pn pnVar) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(j, pnVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void u() {
        Function<SparseArray<Object>, Object> functionPn;
        try {
            if (com.bytedance.sdk.openadsdk.core.n.o().ja() || (functionPn = pn()) == null) {
                return;
            }
            functionPn.apply(com.bytedance.sdk.openadsdk.my.b.u().u(1008).u(Void.class).u(36, 1).nr());
        } catch (Throwable unused) {
        }
    }
}
