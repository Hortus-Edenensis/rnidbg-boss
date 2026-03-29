package com.bytedance.sdk.openadsdk.gi.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.my.b;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private static Function<SparseArray<Object>, Object> u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static final fx u = new fx();
    }

    public static fx u() {
        return u.u;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    private fx() {
    }

    public static void u(Function<SparseArray<Object>, Object> function) {
        u = function;
    }

    public static void u(JSONObject jSONObject) {
        if (u != null) {
            b bVarU = b.u();
            bVarU.u(10001).u(Void.class);
            bVarU.u(20001, jSONObject);
            u.apply(bVarU.nr());
        }
    }

    private void u(Map<String, String> map) {
        com.bytedance.sdk.component.b.nr.fx fxVar = dw.nr().fx;
        if (map == null || fxVar == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            fxVar.put(key + "_qa_modify_setting", entry.getValue());
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        if (pluginValueSetA.intValue(-99999987) != 10003) {
            return null;
        }
        u((Map<String, String>) pluginValueSetA.objectValue(20003, Map.class));
        return null;
    }
}
