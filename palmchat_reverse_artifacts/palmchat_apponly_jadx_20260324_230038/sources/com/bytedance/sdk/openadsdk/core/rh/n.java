package com.bytedance.sdk.openadsdk.core.rh;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import defpackage.ll7;
import java.util.UUID;
import java.util.function.LongSupplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n extends com.bytedance.sdk.openadsdk.core.bc.b implements LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        u(i, (SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class));
        return null;
    }

    public PluginValueSet fx(int i, SparseArray<Object> sparseArray) {
        JSONObject jSONObjectRg = dw.nr().rg();
        if (jSONObjectRg != null) {
            return ll7.b().g(33, jSONObjectRg).a();
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public PluginValueSet nr(int i, SparseArray<Object> sparseArray) {
        return null;
    }

    public PluginValueSet u(int i, a aVar) {
        return null;
    }

    public PluginValueSet nr(int i) {
        return ll7.b().h(32, String.valueOf(jp.pn())).a();
    }

    public PluginValueSet u(int i, pn pnVar) {
        return null;
    }

    public PluginValueSet u(int i, SparseArray<Object> sparseArray) {
        if (i == 1) {
            return u(i);
        }
        if (i == 6) {
            return u(i, new pn(sparseArray, i));
        }
        if (i == 3) {
            return fx(i, sparseArray);
        }
        if (i != 4) {
            switch (i) {
                case 8:
                    return u(i, new a(sparseArray, i));
                case 9:
                    return nr(i, sparseArray);
                case 10:
                    u(sparseArray);
                    return null;
                default:
                    return null;
            }
        }
        return nr(i);
    }

    private void u(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            try {
                PluginValueSet pluginValueSetB = new com.bytedance.sdk.openadsdk.my.u(sparseArray).b();
                if (pluginValueSetB != null) {
                    String strStringValue = pluginValueSetB.stringValue(6);
                    JSONObject jSONObject = (JSONObject) pluginValueSetB.objectValue(7, JSONObject.class);
                    jSONObject.put("label", strStringValue);
                    com.bytedance.sdk.component.n.nr.b.u.u uVar = new com.bytedance.sdk.component.n.nr.b.u.u(UUID.randomUUID().toString(), jSONObject);
                    uVar.u((byte) 0);
                    uVar.nr((byte) 2);
                    com.bytedance.sdk.openadsdk.gi.u.fx.u(uVar.x());
                    com.bytedance.sdk.component.n.nr.u.u(uVar, "csj");
                }
            } catch (Exception unused) {
            }
        }
    }

    public PluginValueSet u(int i) {
        return ll7.b().h(31, sx.fx()).a();
    }
}
