package com.bytedance.sdk.openadsdk.core.rh;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t {
    public static boolean fx() {
        return com.bytedance.sdk.openadsdk.core.fx.pn.u().k() == 1;
    }

    public static boolean nr() {
        JSONObject jSONObjectEx = dw.nr().ex();
        return jSONObjectEx != null && jSONObjectEx.optInt("pre_drop", 0) == 1;
    }

    public static boolean u() {
        JSONObject jSONObjectEx = dw.nr().ex();
        return jSONObjectEx != null && jSONObjectEx.optInt("video_cache", 0) == 1;
    }

    public static void u(final Function<SparseArray<Object>, Object> function) {
        fx fxVar;
        Function<SparseArray<Object>, Object> functionV = com.bytedance.sdk.openadsdk.core.n.o().v();
        if (dw.nr().wq()) {
            Object objApply = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, "com.byted.csj.ext").nr());
            if (objApply != null ? ((Boolean) objApply).booleanValue() : false) {
                Object objApply2 = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(7).u(Boolean.class).u(0, "com.byted.csj.ext").nr());
                if (((objApply2 != null ? ((Boolean) objApply2).booleanValue() : false) || bf.u().u(functionV, false)) && (fxVar = (fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya")) != null) {
                    fxVar.init(dw.getContext(), new com.bytedance.sdk.openadsdk.core.bc.b() { // from class: com.bytedance.sdk.openadsdk.core.rh.t.1
                        @Override // com.bytedance.sdk.openadsdk.core.bc.b
                        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                            if (function == null) {
                                return null;
                            }
                            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(i).u(Void.class).u(-99999979, (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).nr());
                            return null;
                        }
                    });
                }
            }
        }
    }
}
